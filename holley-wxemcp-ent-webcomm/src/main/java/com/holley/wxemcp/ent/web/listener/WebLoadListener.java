package com.holley.wxemcp.ent.web.listener;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import com.holley.platform.common.constants.Globals;
import com.holley.wxemcp.ent.common.cache.ReaderResourceUtil;

public class WebLoadListener implements ServletContextListener {

    private final static Logger logger = Logger.getLogger(WebLoadListener.class);

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {

    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext context = event.getServletContext();
        context.setAttribute(Globals.WEB_ROOT, context.getContextPath());
        logger.info("webRoot=" + context.getContextPath());

        Properties p = ReaderResourceUtil.getClassPathProperties("wxemcpEnt.properties");
        String v = p.getProperty("version");
        v = v != null ? v : "" + System.currentTimeMillis();
        context.setAttribute("version", v);
        // 加载省
        // List<DicCity> province = CachedCityUtil.getProvince();
        // context.setAttribute(WxemcpEntGlobals.PROVINCE, province);
    }
}
