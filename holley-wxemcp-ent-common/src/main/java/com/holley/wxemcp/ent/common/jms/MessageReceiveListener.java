package com.holley.wxemcp.ent.common.jms;

import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import org.apache.commons.lang.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageReceiveListener implements MessageListener {

    private static Logger logger = LoggerFactory.getLogger(MessageReceiveListener.class);

    private int           count  = 0;

    /**
     * MessageListener回调函数.
     */
    @Override
    public void onMessage(Message message) {
        try {
            logger.info("收到消息？");
            if (message != null) {
                logger.info("收到消息！");
                if (message instanceof ObjectMessage) {
                    ObjectMessage objMessage = (ObjectMessage) message;
                    byte[] bytes = (byte[]) objMessage.getObject();
                    Object obj = SerializationUtils.deserialize(bytes);
                    if (obj != null) {
                        // if (obj instanceof String) {
                        // logger.info((String) obj);
                        // }
                        // if (obj instanceof PileStatusBean) {
                        // PileStatusBean bean = (PileStatusBean) obj;
                        // System.out.println("bean =" + bean.getPointId());
                        // logger.info("bean =" + bean.getPointId());
                        // }
                    }
                } else if (message instanceof TextMessage) {
                    TextMessage msg = (TextMessage) message;
                    logger.info(count++ + "----------" + msg.getText());
                } else if (message instanceof MapMessage) {
                    MapMessage mapMessage = (MapMessage) message;
                    logger.info(count++ + "----------" + mapMessage.toString());
                }
            }
        } catch (Exception e) {
            logger.error("处理消息时发生异常.", e);
        }
    }

}
