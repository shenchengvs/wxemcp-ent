package com.holley.wxemcp.ent.common.cache;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import com.holley.platform.common.util.StringUtil;
import com.sohu.tv.builder.ClientBuilder;
import com.sohu.tv.cachecloud.client.basic.util.ClientConfig;

public abstract class CacheCloudUtil {

    protected static Logger          logger             = Logger.getLogger(CacheCloudUtil.class);

    private static String            APP_ID             = null;
    private static String            APP_TYPE           = "redis-standalone";

    private static int               CONNECTION_TIMEOUT = 8000;
    private static int               SO_TIMEOUT         = 8000;

    private static JedisPool         jedisPool          = null;
    private static JedisSentinelPool sentinelPool       = null;
    private static JedisCluster      jedisCluster       = null;
    private static Jedis             jedis              = null;

    /**
     * redis过期时间,以秒为单位
     */
    public final static int          EXRP_1M            = 60;                                    // 3分钟过期
    public final static int          EXRP_3M            = 60 * 3;                                // 3分钟过期
    public final static int          EXRP_10M           = 60 * 10;                               // 10分钟过期
    public final static int          EXRP_30M           = 30 * 60;                               // 30分钟过期
    public final static int          EXRP_HOUR          = 60 * 60;                               // 一小时
    public final static int          EXRP_DAY           = 60 * 60 * 24;                          // 一天
    public final static int          EXRP_MONTH         = 60 * 60 * 24 * 30;                     // 一个月

    private static GenericObjectPoolConfig getPoolConfig() {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(GenericObjectPoolConfig.DEFAULT_MAX_TOTAL * 20);
        poolConfig.setMaxIdle(GenericObjectPoolConfig.DEFAULT_MAX_IDLE * 20);
        poolConfig.setMinIdle(GenericObjectPoolConfig.DEFAULT_MAX_IDLE * 10);
        // JedisPool.borrowObject最大等待时间
        poolConfig.setMaxWaitMillis(2000L);
        poolConfig.setJmxNamePrefix("jedis-pool");
        poolConfig.setJmxEnabled(true);
        return poolConfig;
    }

    /**
     * 初始化Redis连接池
     */
    private static void initialPool() {
        logger.debug("init pool ...");
        InputStream is = null;
        try {
            // String useCacheCloud = ClientConfig.getUseCacheCloud();
            // String useCacheCloud = null;
            // APP_ID = ClientConfig.getAppId();
            // APP_TYPE = ClientConfig.getAppType();
            // logger.error("useCacheCloud is empty , start read cacheCloudClient.properties");

            Properties prop = ReaderResourceUtil.getClassPathProperties("cacheCloudClient.properties");

            String useCacheCloud = prop.getProperty("use_cachecloud");
            APP_ID = prop.getProperty("app_id");
            APP_TYPE = prop.getProperty("app_type");

            int httpConnTimeout = Integer.parseInt(prop.getProperty("http_conn_timeout"));
            ClientConfig.setHttpConnTimeout(httpConnTimeout);
            int httpSocketTimeout = Integer.parseInt(prop.getProperty("http_socket_timeout"));
            ClientConfig.setHttpSocketTimeout(httpSocketTimeout);
            String clientVersion = prop.getProperty("client_version");
            ClientConfig.setClientVersion(clientVersion);
            String domainUrl = prop.getProperty("domain_url");
            ClientConfig.setDomainUrl(domainUrl);
            String cachecloudReportUrl = prop.getProperty("cachecloud_report_url");
            ClientConfig.setCachecloudReportUrl(cachecloudReportUrl);
            String redisClusterSuffix = prop.getProperty("redis_cluster_suffix");
            ClientConfig.setRedisClusterSuffix(redisClusterSuffix);
            String redisSentinelSuffix = prop.getProperty("redis_sentinel_suffix");
            ClientConfig.setRedisSentinelSuffix(redisSentinelSuffix);
            String redisStandaloneSuffix = prop.getProperty("redis_standalone_suffix");
            ClientConfig.setRedisStandaloneSuffix(redisStandaloneSuffix);

            ClientConfig.setServer(prop.getProperty("server"));
            ClientConfig.setPort(prop.getProperty("port"));
            ClientConfig.setMaxActive(prop.getProperty("max_active"));
            ClientConfig.setNeedpassword(prop.getProperty("needpassword"));
            ClientConfig.setPassword(prop.getProperty("password"));
            ClientConfig.setMaxIdle(prop.getProperty("max_idle"));
            ClientConfig.setMaxWait(prop.getProperty("max_wait"));
            ClientConfig.setTimeout(prop.getProperty("timeout"));
            ClientConfig.setTestOnBorrow(prop.getProperty("test_on_borrow"));

            if (StringUtil.isEmpty(useCacheCloud)) {
                logger.error("initial pool error, useCacheCloud is empty, because cacheCloudClient.properties has error.");
                throw new Exception("initial pool error, useCacheCloud is empty, because cacheCloudClient.properties has error.");
            }

            if ("true".equals(useCacheCloud)) {
                if (StringUtil.isEmpty(APP_ID) || !StringUtil.isDigits(APP_ID)) {
                    logger.error("initial pool error,because app_id is empty or app_id is not number. ");
                    throw new Exception("initial pool error,because app_id is empty or app_id is not number.");
                }
                long appId = Long.valueOf(APP_ID);
                if (RedisTypeEnum.STANDALONE.getValue().equalsIgnoreCase(APP_TYPE)) {
                    jedisPool = ClientBuilder.redisStandalone(appId).setPoolConfig(getPoolConfig()).build();
                } else if (RedisTypeEnum.SENTINEL.getValue().equalsIgnoreCase(APP_TYPE)) {
                    sentinelPool = ClientBuilder.redisSentinel(appId).setConnectionTimeout(CONNECTION_TIMEOUT).setSoTimeout(SO_TIMEOUT).setPoolConfig(getPoolConfig()).build();
                } else if (RedisTypeEnum.CLUSTER.getValue().equalsIgnoreCase(APP_TYPE)) {
                    jedisCluster = ClientBuilder.redisCluster(appId).setJedisPoolConfig(getPoolConfig()).setConnectionTimeout(CONNECTION_TIMEOUT).setSoTimeout(SO_TIMEOUT).build();
                }
            } else {
                APP_TYPE = RedisTypeEnum.STANDALONE.getValue();
                JedisPoolConfig config = new JedisPoolConfig();
                config.setMaxTotal(Integer.parseInt(ClientConfig.getMaxActive()));
                config.setMaxIdle(Integer.parseInt(ClientConfig.getMaxIdle()));
                config.setMaxWaitMillis(Integer.parseInt(ClientConfig.getMaxWait()));
                config.setTestOnBorrow(Boolean.parseBoolean(ClientConfig.getTestOnBorrow()));
                jedisPool = new JedisPool(config, ClientConfig.getServer(), Integer.parseInt(ClientConfig.getPort()), Integer.parseInt(ClientConfig.getTimeout()),
                                          ClientConfig.getPassword());
            }
        } catch (Exception e) {
            logger.error("First create JedisPool error : ", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    logger.error("close input stream error:", e);
                }
            }
        }

    }

    /**
     * 在多线程环境同步初始化
     */
    private static synchronized void poolInit() {
        if (jedisPool == null && sentinelPool == null) {
            initialPool();
        }
    }

    /**
     * 查询key的过期时间
     *
     * @param key
     * @return 0已经过期
     */
    public static Long ttl(String key) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            if (jedis == null) {
                return null;
            }
            Long ttl = jedis.ttl(key);
            if (ttl == null) {
                return null;
            }
            return ttl > 0 ? ttl : 0;
        } catch (Exception e) {
            logger.error("ttl error:", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

    /**
     * 同步获取Jedis实例
     *
     * @return Jedis
     */
    public synchronized static Jedis getJedis() {
        if (jedisPool == null && sentinelPool == null) {
            poolInit();
        }
        Jedis jedis = null;
        try {
            if (jedisPool != null) {
                jedis = jedisPool.getResource();
            } else if (sentinelPool != null) {
                jedis = sentinelPool.getResource();
            }
        } catch (Exception e) {
            logger.error("Get jedis error : ", e);
        }
        return jedis;
    }

    /**
     * 设置 String
     *
     * @param key
     * @param value
     */
    public static boolean setString(String key, String value) {
        Jedis jedis = null;
        try {
            value = StringUtil.isEmpty(value) ? "" : value;
            if (RedisTypeEnum.CLUSTER.getValue().equalsIgnoreCase(APP_TYPE)) {
                jedisCluster.set(key, value);
            } else {
                jedis = getJedis();
                if (jedis == null) {
                    return false;
                }
                jedis.set(key, value);
            }
            return true;
        } catch (Exception e) {
            logger.error("Set key error : ", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return false;

    }

    /**
     * 设置 过期时间的String
     *
     * @param key
     * @param value
     * @param timeout 以秒为单位
     */
    public static void setString(String key, String value, int timeout) {
        Jedis jedis = null;
        try {
            value = StringUtil.isEmpty(value) ? "" : value;
            if (RedisTypeEnum.CLUSTER.getValue().equalsIgnoreCase(APP_TYPE)) {
                jedisCluster.setex(key, timeout, value);
            } else {
                jedis = getJedis();
                if (jedis == null) {
                    return;
                }
                jedis.setex(key, timeout, value);
            }
        } catch (Exception e) {
            logger.error("Set keyex error : ", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

    /**
     * 设置 byte[]
     *
     * @param key
     * @param value
     */
    public static void setByte(byte[] key, byte[] value) {
        Jedis jedis = null;
        try {
            if (RedisTypeEnum.CLUSTER.getValue().equalsIgnoreCase(APP_TYPE)) {
                jedisCluster.set(key, value);
            } else {
                jedis = getJedis();
                if (jedis == null) {
                    return;
                }
                jedis.set(key, value);
            }
        } catch (Exception e) {
            logger.error("Set keyex error : ", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

    /**
     * 设置 过期时间的String
     *
     * @param key
     * @param value
     * @param timeout 以秒为单位
     */
    public static void setByteEx(byte[] key, byte[] value, int timeout) {
        Jedis jedis = null;
        try {
            if (RedisTypeEnum.CLUSTER.getValue().equalsIgnoreCase(APP_TYPE)) {
                jedisCluster.setex(key, timeout, value);
            } else {
                jedis = getJedis();
                if (jedis == null) {
                    return;
                }
                jedis.setex(key, timeout, value);
            }
        } catch (Exception e) {
            logger.error("Set keyex error : ", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

    }

    /**
     * 获取String值
     *
     * @param key
     * @return value
     */
    public static String getString(String key) {
        Jedis jedis = null;
        String value = null;
        try {
            if (RedisTypeEnum.CLUSTER.getValue().equalsIgnoreCase(APP_TYPE)) {
                value = jedisCluster.get(key);
            } else {
                jedis = getJedis();
                if (jedis == null || !jedis.exists(key)) {
                    return null;
                }
                value = jedis.get(key);
            }
        } catch (Exception e) {
            logger.error("Set keyex error : ", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return value;
    }

    /**
     * 获取String值
     *
     * @param key
     * @return value
     */
    public static byte[] getByte(byte[] key) {
        Jedis jedis = null;
        byte[] value = null;
        try {
            if (RedisTypeEnum.CLUSTER.getValue().equalsIgnoreCase(APP_TYPE)) {
                value = jedisCluster.get(key);
            } else {
                jedis = getJedis();
                if (jedis == null || !jedis.exists(key)) {
                    return null;
                }
                value = jedis.get(key);
            }
        } catch (Exception e) {
            logger.error("Set keyex error : ", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return value;
    }

    public static boolean delKey(String key) {
        Jedis jedis = null;
        Long dels = null;
        try {
            if (RedisTypeEnum.CLUSTER.getValue().equalsIgnoreCase(APP_TYPE)) {
                dels = jedisCluster.del(key);
            } else {
                jedis = getJedis();
                if (jedis != null) {
                    dels = jedis.del(key);
                }
            }
        } catch (Exception e) {
            logger.error("del keyex error : ", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return dels != null;
    }

    public static boolean delKey(byte[] key) {
        Jedis jedis = null;
        Long dels = null;
        try {
            if (RedisTypeEnum.CLUSTER.getValue().equalsIgnoreCase(APP_TYPE)) {
                dels = jedisCluster.del(key);
            } else {
                jedis = getJedis();
                if (jedis != null) {
                    dels = jedis.del(key);
                }
            }
        } catch (Exception e) {
            logger.error("del keyex error : ", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return dels != null;
    }

    /**
     * 设置key的过期时间，单位秒
     *
     * @param key
     * @param timeout
     */
    public static void expire(String key, int timeout) {
        Jedis jedis = null;

        try {
            if (RedisTypeEnum.CLUSTER.getValue().equalsIgnoreCase(APP_TYPE)) {
                jedisCluster.expire(key, timeout);
            } else {
                jedis = getJedis();
                if (jedis != null) {
                    jedis.expire(key, timeout);
                }
            }
        } catch (Exception e) {
            logger.error("expire keyex error : ", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 设置key的过期时间，单位秒
     *
     * @param key
     * @param timeout
     */
    public static void expire(byte[] key, int timeout) {
        Jedis jedis = null;
        try {
            if (RedisTypeEnum.CLUSTER.getValue().equalsIgnoreCase(APP_TYPE)) {
                jedisCluster.expire(key, timeout);
            } else {
                jedis = getJedis();
                if (jedis != null) {
                    jedis.expire(key, timeout);
                }
            }
        } catch (Exception e) {
            logger.error("expire keyex error : ", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    /**
     * 队列入
     *
     * @param key
     * @param value
     */
    public static boolean lpush(String key, String value) {
        Jedis jedis = null;
        try {
            if (RedisTypeEnum.CLUSTER.getValue().equalsIgnoreCase(APP_TYPE)) {
                jedisCluster.lpush(key, value);
            } else {
                jedis = getJedis();
                if (jedis == null) {
                    return false;
                }
                jedis.lpush(key, value);
            }
            return true;
        } catch (Exception e) {
            logger.error("lpush error : ", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return false;
    }

    /**
     * 队列入（单个对象或List）
     *
     * @param key
     * @param value
     */
    public static boolean lpush(byte[] key, byte[] value) {
        Jedis jedis = null;
        try {
            if (RedisTypeEnum.CLUSTER.getValue().equalsIgnoreCase(APP_TYPE)) {
                jedisCluster.lpush(key, value);
            } else {
                jedis = getJedis();
                if (jedis == null) {
                    return false;
                }
                jedis.lpush(key, value);
            }
            return true;
        } catch (Exception e) {
            logger.error("lpush error : ", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return false;
    }

    /**
     * 队列出
     *
     * @param key
     */
    public static String rpop(String key) {
        Jedis jedis = null;
        try {
            if (RedisTypeEnum.CLUSTER.getValue().equalsIgnoreCase(APP_TYPE)) {
                return jedisCluster.rpop(key);
            } else {
                jedis = getJedis();
                if (jedis == null) {
                    return null;
                }
                return jedis.rpop(key);
            }
        } catch (Exception e) {
            logger.error("rpop error : ", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

    /**
     * 队列出（取单个对象）
     *
     * @param key
     * @return
     */
    public static byte[] rpop(byte[] key) {
        Jedis jedis = null;
        try {
            if (RedisTypeEnum.CLUSTER.getValue().equalsIgnoreCase(APP_TYPE)) {
                return jedisCluster.rpop(key);
            } else {
                jedis = getJedis();
                if (jedis == null) {
                    return null;
                }
                return jedis.rpop(key);
            }
        } catch (Exception e) {
            logger.error("rpop error : ", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        getString("a");

    }
}
