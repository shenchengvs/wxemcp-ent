package com.holley.wxemcp.ent.tools.pool;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.holley.platform.common.configuration.DefaultCommResourceLoader;

/**
 * 线程池。运行技术服务任务
 * 
 * @author zhouli
 */
public class ThreadComsPool {

    /**
     * 定时计算任务，手工计算的线程池
     */
    private static ThreadPoolExecutor pool            = null;

    /**
     * 存储数据线程池
     */
    private static ThreadPoolExecutor saveDatePool    = null;

    /**
     * 立即执行的线程池，用于马上计算的情况
     */

    private static Resource           resource;
    private static ResourceLoader     resourceLoader  = new DefaultCommResourceLoader();

    private static final String       COREPOOLSIZE    = "corePoolSize";
    private static final String       MAXIMUMPOOLSIZE = "maximumPoolSize";
    private static final String       KEEPALIVETIME   = "keepAliveTime";
    private static final String       QUEUETYPE       = "queueType";
    private static final String       QUEUESIZE       = "queueSize";

    private static ThreadPoolExecutor getPool() throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {
        if (pool == null) {
            String[] keys = new String[] { COREPOOLSIZE, MAXIMUMPOOLSIZE, KEEPALIVETIME, QUEUETYPE, QUEUESIZE };
            Map<String, String> paraMap = getParam(keys);
            int corePoolSize = Integer.parseInt(paraMap.get(COREPOOLSIZE).toString());
            int maximumPoolSize = Integer.parseInt(paraMap.get(MAXIMUMPOOLSIZE).toString());
            int keepAliveTime = Integer.parseInt(paraMap.get(KEEPALIVETIME).toString());
            String queueType = paraMap.get(QUEUETYPE).toString();
            if ("SynchronousQueue".equals(queueType)) {
                pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
            } else if ("LinkedBlockingQueue".equals(queueType)) {
                pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
            } else if ("ArrayBlockingQueue".equals(queueType)) {
                int queueSize = Integer.parseInt(paraMap.get(QUEUESIZE).toString());
                pool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
            }

        }
        return pool;
    }

    private static ThreadPoolExecutor getSaveDatePool() throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {
        if (saveDatePool == null) {
            String[] keys = new String[] { COREPOOLSIZE, MAXIMUMPOOLSIZE, KEEPALIVETIME, QUEUETYPE, QUEUESIZE };
            Map<String, String> paraMap = getParam(keys);
            int corePoolSize = Integer.parseInt(paraMap.get(COREPOOLSIZE).toString());
            int maximumPoolSize = Integer.parseInt(paraMap.get(MAXIMUMPOOLSIZE).toString());
            int keepAliveTime = Integer.parseInt(paraMap.get(KEEPALIVETIME).toString());
            String queueType = paraMap.get(QUEUETYPE).toString();
            if ("SynchronousQueue".equals(queueType)) {
                saveDatePool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
            } else if ("LinkedBlockingQueue".equals(queueType)) {
                saveDatePool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
            } else if ("ArrayBlockingQueue".equals(queueType)) {
                int queueSize = Integer.parseInt(paraMap.get(QUEUESIZE).toString());
                saveDatePool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
            }
        }
        return saveDatePool;
    }

    private static Map<String, String> getParam(String[] keys) throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {
        Map<String, String> paraMap = new HashMap<String, String>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true); // never forget this!
        DocumentBuilder builder = factory.newDocumentBuilder();
        resource = resourceLoader.getResource("classpath:/config/threadPoolConfig.xml");
        InputStream in = resource.getInputStream();
        Document doc = builder.parse(in);

        XPathFactory pathFactory = XPathFactory.newInstance();

        XPath xpath = pathFactory.newXPath();
        for (int i = 0; i < keys.length; i++) {
            String spath = "//thread-config/" + keys[i] + "/text()";
            XPathExpression pathExpression = xpath.compile(spath);

            Object result = pathExpression.evaluate(doc, XPathConstants.NODESET);

            NodeList nodes = (NodeList) result;
            if (nodes.getLength() > 0) {
                paraMap.put(keys[i], nodes.item(0).getNodeValue());
            }
        }
        return paraMap;
    }

    /**
     * 排队等待执行
     * 
     * @param command
     * @throws XPathExpressionException
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException
     */
    public static void executeSaveData(Runnable command) throws XPathExpressionException, ParserConfigurationException, IOException, SAXException {
        ThreadPoolExecutor threadPool = getSaveDatePool();
        threadPool.execute(command);
    }

}
