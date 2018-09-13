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

public class SendRtuWxMsgPrincipalAndAssistantTask {

    @SuppressWarnings("unused")
    private final static Logger       logger = Logger.getLogger(SendRtuWxMsgPrincipalAndAssistantTask.class);
    @Resource
    private DatEvtHisMapper           datEvtHisMapper;
    @Resource
    private PpfEnterpriseWechatMapper ppfEnterpriseWechatMapper;

    public void execute() {
        logger.info("WX主副事件消息推送任务执行RTU。。。");
        if (WxEmcpEntLocalUtil.rtuPrincipalEventIds != null && !WxEmcpEntLocalUtil.rtuPrincipalEventIds.isEmpty()) {
            Map<String, Object> map = new HashMap<String, Object>();
            List<EvtWxSendVo> lastRtuPrincipalEvents = null;
            List<WxSendStatusBean> wxSendStatusBeanList = null;
            List<EvtWxSendVo> lastRtuAssistantEvents = null;
            List<EvtWxSendVo> allEventList = new ArrayList<EvtWxSendVo>();
            for (Integer eid : WxEmcpEntLocalUtil.eids) {
                allEventList.clear();
                map.put("eid", eid);
                map.put("rtuEventIds", WxEmcpEntLocalUtil.rtuPrincipalEventIds);
                lastRtuPrincipalEvents = datEvtHisMapper.selectRtuWxSendEventByEid(map);
                if (lastRtuPrincipalEvents != null && !lastRtuPrincipalEvents.isEmpty()) {
                    map.put("rtuEventIds", WxEmcpEntLocalUtil.rtuAssistantEventIds);
                    lastRtuAssistantEvents = datEvtHisMapper.selectRtuWxSendEventByEid(map);
                    wxSendStatusBeanList = WxEmcpEntLocalUtil.rtuSendStatusBean.get(eid);
                    for (EvtWxSendVo vo : lastRtuPrincipalEvents) {
                        step1(eid, vo, lastRtuAssistantEvents, allEventList, wxSendStatusBeanList);
                    }
                    if (!allEventList.isEmpty()) {
                        sendWxMsg(eid, allEventList);
                    }

                }

            }
        }
    }

    private void step1(Integer eid, EvtWxSendVo lastRtuPrincipalEvent, List<EvtWxSendVo> lastRtuAssistantEvents, List<EvtWxSendVo> allEventList, List<WxSendStatusBean> list) {
        boolean isExist = false;
        if (list != null && !list.isEmpty()) {
            for (WxSendStatusBean bean : list) {
                if (lastRtuPrincipalEvent.getObjId().equals(bean.getObjId()) && lastRtuPrincipalEvent.getEventItemId().intValue() == bean.getPrincipalId()) {
                    isExist = true;
                    if (lastRtuPrincipalEvent.getEventTime().getTime() > bean.getPrincipalDate().getTime()) {
                        bean.setPrincipalDate(lastRtuPrincipalEvent.getEventTime());
                        bean.setSendDate(new Date());
                    }

                    if (step2(bean, lastRtuAssistantEvents)) {
                        allEventList.add(lastRtuPrincipalEvent);
                    }
                    break;
                }
            }
        }

        if (!isExist) {
            WxEmcpEntLocalUtil.initRtuWxSendStatusBean(eid, lastRtuPrincipalEvent);
        }
    }

    private boolean step2(WxSendStatusBean bean, List<EvtWxSendVo> lastRtuAssistantEvents) {
        if (!WxEmcpEntLocalUtil.rtuPrincipalSendEventId.containsKey(bean.getPrincipalId()) || bean.getSendDate() == null) {
            return false;
        }
        WxSendEventId wxSendEventId = WxEmcpEntLocalUtil.rtuPrincipalSendEventId.get(bean.getPrincipalId());
        long principalTime = bean.getPrincipalDate().getTime();
        long nowTime = System.currentTimeMillis();
        long sendTime = bean.getSendDate().getTime();
        long min = (nowTime - sendTime) / 60000;
        boolean isExist = false;
        logger.info("objId:" + bean.getObjId() + "RTU间隔：" + min);
        if (lastRtuAssistantEvents == null || lastRtuAssistantEvents.isEmpty()) {
            if (min >= wxSendEventId.getDelayTime()) {
                bean.setSendDate(new Date());
                return true;
            }
            return false;
        }

        for (EvtWxSendVo vo : lastRtuAssistantEvents) {
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
        logger.info("RTU进入发送" + "eid:" + eid + "任务数量：" + allEventList.size());
        PpfEnterpriseWechatExample emp = new PpfEnterpriseWechatExample();
        PpfEnterpriseWechatExample.Criteria cr = emp.createCriteria();
        cr.andEnterpriseIdEqualTo(eid);
        cr.andLoginStatusEqualTo(LoginStatusTypeEnum.LOGIN.getShortValue());
        cr.andPushStatusEqualTo(WxPushStatusTypeEnum.PUSH.getShortValue());
        List<PpfEnterpriseWechat> l = ppfEnterpriseWechatMapper.selectByExample(emp);
        for (PpfEnterpriseWechat wx : l) {
            for (EvtWxSendVo vo : allEventList) {
                logger.info("RTU发送：" + wx.getOpenId() + "-----" + JSON.toJSONString(vo));
                WxEmcpEntUtil.sendTemplateMsg(wx.getOpenId(), vo.getEventNote(), vo.getEventTimeStr(), vo.getEventContent());
            }
        }
    }
}
