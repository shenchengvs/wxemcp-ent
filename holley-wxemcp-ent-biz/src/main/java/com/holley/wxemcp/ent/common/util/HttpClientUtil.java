package com.holley.wxemcp.ent.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/*
 * 利用HttpClient进行post请求的工具类
 */
public class HttpClientUtil {

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public String doPost(String url, Map<String, String> map, String charset) {
        HttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try {
            httpClient = new SSLClient();
            httpPost = new HttpPost(url);
            // 设置参数
            List<NameValuePair> list = new ArrayList<NameValuePair>();
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Entry<String, String> elem = (Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
            }
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * 发送get请求
     * 
     * @param url 链接地址
     * @param charset 字符编码，若为null则默认utf-8
     * @return
     */
    public String doGet(String url, String charset) {
        if (null == charset) {
            charset = "utf-8";
        }
        HttpClient httpClient = null;
        HttpGet httpGet = null;
        String result = null;

        try {
            httpClient = new SSLClient();
            httpGet = new HttpGet(url);

            HttpResponse response = httpClient.execute(httpGet);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (resEntity != null) {
                    result = EntityUtils.toString(resEntity, charset);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 发送HttpPost请求
     * 
     * @param strURL 服务地址
     * @param params json字符串,例如: "{ \"id\":\"12345\" }" ;其中属性名必须带双引号<br/>
     * @return 成功:返回json字符串<br/>
     */
    public static String postJson(String strURL, String params) {
        try {
            // 创建连接
            URL url = new URL(strURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setInstanceFollowRedirects(true);
            // 设置请求方式
            connection.setRequestMethod("POST");
            // 设置接收数据的格式
            connection.setRequestProperty("Accept", "application/json");
            // 设置发送数据的格式
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();
            // utf-8编码
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            out.append(params);
            // 关闭流
            out.flush();
            out.close();
            // 读取响应 ，获取长度
            int length = (int) connection.getContentLength();
            InputStream is = connection.getInputStream();
            if (length != -1) {
                byte[] data = new byte[length];
                byte[] temp = new byte[512];
                int readLen = 0;
                int destPos = 0;
                while ((readLen = is.read(temp)) > 0) {
                    System.arraycopy(temp, 0, data, destPos, readLen);
                    destPos += readLen;
                }
                // utf-8编码
                String result = new String(data, "UTF-8");
                // 返回
                return result;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 自定义错误信息
        return "error";
    }

}
