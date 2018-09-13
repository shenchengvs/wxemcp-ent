package com.holley.wxemcp.ent.common.cache;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class ReaderResourceUtil {

    public static Properties getClassPathProperties(String classPath) {
        Resource r = new ClassPathResource(classPath);
        // File clsFile = ResourceUtils.getFile("classpath:jdbc.properties");
        Properties p = new Properties();
        try {
            p.load(r.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return p;
    }

    public static Properties getFilePathProperties(String filePath) {
        Resource r = new FileSystemResource(filePath);
        Properties p = new Properties();
        try {
            p.load(r.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return p;
    }

    public static void main(String[] args) {
        CacheCloudUtil.setString("aa", "aa");
        System.out.println(CacheCloudUtil.getString("aa"));
        CacheCloudUtil.delKey("aa");
    }
}
