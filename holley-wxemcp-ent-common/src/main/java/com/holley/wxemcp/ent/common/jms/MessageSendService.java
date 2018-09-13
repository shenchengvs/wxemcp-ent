package com.holley.wxemcp.ent.common.jms;

/**
 * 消息发送接口
 * 
 * @author zhouli
 */
public interface MessageSendService {

    /**
     * 将对象发送至配置的队列
     * 
     * @param msgObj 序列化对象或者map
     */
    public void sendQueue(Object msgObj);

    /**
     * 将文本发送至配置的队列
     * 
     * @param message
     */
    public void sendQueue(String message);

    /**
     * 将对象发送至配置的主题
     * 
     * @param msgObj 序列化对象或者map
     */
    public void sendTopic(Object msgObj);

    /**
     * 将文本发送至配置的主题
     * 
     * @param message
     */
    public void sendTopic(String message);

}
