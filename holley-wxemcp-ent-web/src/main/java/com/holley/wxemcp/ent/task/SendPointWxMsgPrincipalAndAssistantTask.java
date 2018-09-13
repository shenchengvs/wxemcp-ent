package com.holley.wxemcp.ent.task;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.holley.wxemcp.ent.common.constants.LoginStatusTypeEnum;
import com.holley.wxemcp.ent.common.constants.WxPushStatusTypeEnum;
import com.holley.wxemcp.ent.common.util.WxEmcpEntLocalUtil;
import com.holley.wxemcp.ent.common.util.WxEmcpEntUtil;
import com.holley.wxemcp.ent.dao.dat.DatEvtHisMapper;
import com.holley.wxemcp.ent.dao.ppf.PpfEnterpriseWechatMapper;
import com.holley.wxemcp.ent.model.def.EvtWxSendVo;
import com.holley.wxemcp.ent.model.def.WxSendEventId;
import com.holley.wxemcp.ent.model.def.WxSendStatusBean;
import com.holley.wxemcp.ent.model.ppf.PpfEnterpriseWechat;
import com.holley.wxemcp.ent.model.ppf.PpfEnterpriseWechatExample;

public class SendPointWxMsgPrincipalAndAssistantTask {

    @SuppressWarnings("unused")
    private final static Logger       logger = Logger.getLogger(SendPointWxMsgPrincipalAndAssistantTask.class);
    @Resource
    private DatEvtHisMapper           datEvtHisMapper;
    @Resource
    private PpfEnterpriseWechatMapper ppfEnterpriseWechatMapper;

    public void execute() {
        logger.info("WX主副事件消息推送任务执行POINT。。。");
        if (WxEmcpEntLocalUtil.pointPrincipalEventIds != null && !WxEmcpEntLocalUtil.pointPrincipalEventIds.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            List<EvtWxSendVo> allEventList = new ArrayList<EvtWxSendVo>();
            List<EvtWxSendVo> lastPointPrincipalEvents = null;
            List<WxSendStatusBean> wxSendStatusBeanList = null;
            List<EvtWxSendVo> lastPointAssistantEvents = null;
            for (Integer eid : WxEmcpEntLocalUtil.eids) {
                allEventList.clear();
                map.put("eid", eid);
                map.put("pointEventIds", WxEmcpEntLocalUtil.pointPrincipalEventIds);
                lastPointPrincipalEvents = datEvtHisMapper.selectPointWxSendEventByEid(map);
                if (lastPointPrincipalEvents != null && !lastPointPrincipalEvents.isEmpty()) {
                    map.put("pointEventIds", WxEmcpEntLocalUtil.pointAssistantEventIds);
                    lastPointAssistantEvents = datEvtHisMapper.selectPointWxSendEventByEid(map);
                    wxSendStatusBeanList = WxEmcpEntLocalUtil.pointSendStatusBean.get(eid);
                    for (EvtWxSendVo vo : lastPointPrincipalEvents) {
                        step1(eid, vo, lastPointAssistantEvents, allEventList, wxSendStatusBeanList);
                    }
                    if (!allEventList.isEmpty()) {
                        sendWxMsg(eid, allEventList);
                    }
                }

            }
        }
    }

    private void step1(Integer eid, EvtWxSendVo lastPointPrincipalEvent, List<EvtWxSendVo> lastPointAssistantEvents, List<EvtWxSendVo> allEventList, List<WxSendStatusBean> list) {
        boolean isExist = false;
        if (list != null && !list.isEmpty()) {
            for (WxSendStatusBean bean : list) {
                if (lastPointPrincipalEvent.getObjId().equals(bean.getObjId()) && lastPointPrincipalEvent.getEventItemId().intValue() == bean.getPrincipalId()) {
                    isExist = true;
                    if (lastPointPrincipalEvent.getEventTime().getTime() > bean.getPrincipalDate().getTime()) {
                        bean.setPrincipalDate(lastPointPrincipalEvent.getEventTime());
                        bean.setSendDate(new Date());
                    }

                    if (step2(bean, lastPointAssistantEvents)) {
                        allEventList.add(lastPointPrincipalEvent);
                    }
                }
            }
        }

        if (!isExist) {
            WxEmcpEntLocalUtil.initPointWxSendStatusBean(eid, lastPointPrincipalEvent);
        }
    }

    private boolean step2(WxSendStatusBean bean, List<EvtWxSendVo> lastPointAssistantEvents) {

        if (!WxEmcpEntLocalUtil.pointPrincipalSendEventId.containsKey(bean.getPrincipalId()) || bean.getSendDate() == null) {
            return false;
        }
        WxSendEventId wxSendEventId = WxEmcpEntLocalUtil.pointPrincipalSendEventId.get(bean.getPrincipalId());
        long principalTime = bean.getPrincipalDate().getTime();
        long nowTime = System.currentTimeMillis();
        long sendTime = bean.getSendDate().getTime();
        long min = (nowTime - sendTime) / 60000;
        boolean isExist = false;
        logger.info("objId:" + bean.getObjId() + "POINT间隔：" + min);
        if (lastPointAssistantEvents == null || lastPointAssistantEvents.isEmpty()) {
            if (min >= wxSendEventId.getDelayTime()) {
                bean.setSendDate(new Date());
                return true;
            }
            return false;
        }

        for (EvtWxSendVo vo : lastPointAssistantEvents) {
            if (bean.getObjId().equals(vo.getObjId()) && bean.getAssistantId() == vo.getEventItemId().intValue()) {
                isExist = true;
                long assistantTime = vo.getEventTime().getTime();
                if (assistantTime >= principalTime) {
                    logger.info("objId:" + vo.getObjId() + "恢复事件不需要发送");
                    bean.setSendDate(null);
                    return false;
                }
                if (min >= wxSendEventId.getDelayTime()) {
                    bean.setSendDate(new Date());
                    return true;
                }
                break;
            }
        }
        if (!isExist) {
            if (min >= wxSendEventId.getDelayTime()) {
                bean.setSendDate(new Date());
                return true;
            }
        }
        return false;
    }

    private void sendWxMsg(Integer eid, List<EvtWxSendVo> allEventList) {
        logger.info("POINT进入发送" + "eid:" + eid + "任务数量：" + allEventList.size());
        PpfEnterpriseWechatExample emp = new PpfEnterpriseWechatExample();
        PpfEnterpriseWechatExample.Criteria cr = emp.createCriteria();
        cr.andEnterpriseIdEqualTo(eid);
        cr.andLoginStatusEqualTo(LoginStatusTypeEnum.LOGIN.getShortValue());
        cr.andPushStatusEqualTo(WxPushStatusTypeEnum.PUSH.getShortValue());
        List<PpfEnterpriseWechat> l = ppfEnterpriseWechatMapper.selectByExample(emp);
        for (PpfEnterpriseWechat wx : l) {
            for (EvtWxSendVo vo : allEventList) {
                logger.info("POINT发送：" + wx.getOpenId() + "-----" + JSON.toJSONString(vo));
                WxEmcpEntUtil.sendTemplateMsg(wx.getOpenId(), vo.getEventNote(), vo.getEventTimeStr(), vo.getEventContent());
            }
        }
    }
}
