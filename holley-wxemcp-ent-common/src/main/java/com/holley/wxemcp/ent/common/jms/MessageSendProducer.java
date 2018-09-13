package com.holley.wxemcp.ent.common.jms;

import javax.jms.Destination;

import org.springframework.jms.core.JmsTemplate;

/**
 * 消息发送实体
 * 
 * @author zhouli
 */
public class MessageSendProducer implements MessageSendService {

    private JmsTemplate jmsTemplate;
    private Destination sendQueue;
    private Destination sendTopic;

    private void sendMessage(Object msgObj, Destination destination) {
        jmsTemplate.convertAndSend(destination, msgObj);
    }

    private void sendMessage(String message, Destination destination) {
        jmsTemplate.convertAndSend(destination, message);
    }

    @Override
    public void sendQueue(Object msgObj) {
        sendMessage(msgObj, sendQueue);
    }

    @Override
    public void sendTopic(Object msgObj) {
        sendMessage(msgObj, sendTopic);
    }

    @Override
    public void sendQueue(String message) {
        sendMessage(message, sendQueue);
    }

    @Override
    public void sendTopic(String message) {
        sendMessage(message, sendTopic);
    }

    // ------------getter and setter
    public void setJmsTemplate(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void setSendQueue(Destination sendQueue) {
        this.sendQueue = sendQueue;
    }

    public void setSendTopic(Destination sendTopic) {
        this.sendTopic = sendTopic;
    }

}
