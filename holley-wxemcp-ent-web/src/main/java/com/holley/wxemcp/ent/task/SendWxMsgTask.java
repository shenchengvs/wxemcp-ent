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
import com.holley.wxemcp.ent.model.def.EvtWxSendVo;
import com.holley.wxemcp.ent.model.ppf.PpfEnterpriseWechat;
import com.holley.wxemcp.ent.model.ppf.PpfEnterpriseWechatExample;
import com.holley.wxemcp.ent.service.emcp.RecordService;

public class SendWxMsgTask {

    private final static Logger logger = Logger.getLogger(SendWxMsgTask.class);
    @Resource
    private RecordService       recordService;

    public void execute() {
        logger.info("WX消息推送任务执行CURRENT。。。");
        if (WxEmcpEntLocalUtil.rtuEventIds != null || WxEmcpEntLocalUtil.pointEventIds != null) {
            Map<String, Object> map = new HashMap<String, Object>();
            List<EvtWxSendVo> pointEventList = null;
            List<EvtWxSendVo> rtuEventList = null;
            List<EvtWxSendVo> allEventList = new ArrayList<EvtWxSendVo>();
            Date pointLastTime = null;
            Date rtuLastTime = null;
            Date lastTime = null;
            for (Integer eid : WxEmcpEntLocalUtil.eids) {
                allEventList.clear();
                pointLastTime = null;
                rtuLastTime = null;
                lastTime = null;
                map.put("eid", eid);
                map.put("isOne", 2);
                map.put("dataTime", WxEmcpEntLocalUtil.lastEventTimeMap.get(eid));
                if (WxEmcpEntLocalUtil.rtuEventIds != null && !WxEmcpEntLocalUtil.rtuEventIds.isEmpty()) {
                    map.put("rtuEventIds", WxEmcpEntLocalUtil.rtuEventIds);
                    rtuEventList = recordService.selectRtuWxSendEvent(map);
                }
                if (WxEmcpEntLocalUtil.pointEventIds != null && !WxEmcpEntLocalUtil.pointEventIds.isEmpty()) {
                    map.put("pointEventIds", WxEmcpEntLocalUtil.pointEventIds);
                    pointEventList = recordService.selectPointWxSendEvent(map);
                }
                if (pointEventList != null && !pointEventList.isEmpty()) {
                    pointLastTime = pointEventList.get(0).getEventTime();
                    allEventList.addAll(pointEventList);
                }
                if (rtuEventList != null && !rtuEventList.isEmpty()) {
                    rtuLastTime = rtuEventList.get(0).getEventTime();
                    allEventList.addAll(rtuEventList);
                }
                lastTime = getMaxDate(pointLastTime, rtuLastTime);
                if (lastTime != null) {
                    WxEmcpEntLocalUtil.lastEventTimeMap.put(eid, lastTime);
                }
                if (!allEventList.isEmpty()) {
                    sendWxMsg(eid, allEventList);
                }
            }
        }
    }

    private Date getMaxDate(Date time1, Date time2) {
        if (time1 == null && time2 == null) {
            return null;
        } else if (time1 == null && time2 != null) {
            return time2;
        } else if (time2 == null && time1 != null) {
            return time1;
        }
        if (time1.getTime() == time2.getTime()) {
            return time1;
        }
        return time1.getTime() > time2.getTime() ? time1 : time2;
    }

    private void sendWxMsg(Integer eid, List<EvtWxSendVo> allEventList) {
        logger.info("CURRENT进入发送" + "eid:" + eid + "任务数量：" + allEventList.size());
        PpfEnterpriseWechatExample emp = new PpfEnterpriseWechatExample();
        PpfEnterpriseWechatExample.Criteria cr = emp.createCriteria();
        cr.andEnterpriseIdEqualTo(eid);
        cr.andLoginStatusEqualTo(LoginStatusTypeEnum.LOGIN.getShortValue());
        cr.andPushStatusEqualTo(WxPushStatusTypeEnum.PUSH.getShortValue());
        List<PpfEnterpriseWechat> l = recordService.selectPpfEnterpriseWechatByExample(emp);
        for (PpfEnterpriseWechat wx : l) {
            for (EvtWxSendVo vo : allEventList) {
                logger.info("CURRENT发送：" + wx.getOpenId() + "-----" + JSON.toJSONString(vo));
                WxEmcpEntUtil.sendTemplateMsg(wx.getOpenId(), vo.getEventNote(), vo.getEventTimeStr(), vo.getEventContent());
            }
        }
    }
}
