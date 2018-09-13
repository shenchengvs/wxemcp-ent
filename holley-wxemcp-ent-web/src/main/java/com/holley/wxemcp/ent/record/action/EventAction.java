package com.holley.wxemcp.ent.record.action;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.holley.platform.common.constants.Globals;
import com.holley.platform.common.dataobject.Page;
import com.holley.platform.common.util.DateUtil;
import com.holley.platform.common.util.StringUtil;
import com.holley.wxemcp.ent.action.BaseAction;
import com.holley.wxemcp.ent.common.constants.CmdTypeEnum;
import com.holley.wxemcp.ent.common.constants.ObjectTypeEnum;
import com.holley.wxemcp.ent.common.constants.RetTypeEnum;
import com.holley.wxemcp.ent.common.constants.SendMsgTypeEnum;
import com.holley.wxemcp.ent.model.dat.DatEvtHis;
import com.holley.wxemcp.ent.model.dat.DatEvtHisKey;
import com.holley.wxemcp.ent.model.def.EventDetailVo;
import com.holley.wxemcp.ent.model.def.EvtRecordBase;
import com.holley.wxemcp.ent.model.def.EvtRecordVo;
import com.holley.wxemcp.ent.model.def.MessageVo;
import com.holley.wxemcp.ent.model.def.MessagesBase;
import com.holley.wxemcp.ent.model.def.PpfControlCmdBase;
import com.holley.wxemcp.ent.model.def.PpfControlCmdVo;
import com.holley.wxemcp.ent.model.def.RechargeBase;
import com.holley.wxemcp.ent.model.def.RechargeVo;
import com.holley.wxemcp.ent.model.def.WxemcpEntResultBean;
import com.holley.wxemcp.ent.model.def.WxemcpEntWebUser;
import com.holley.wxemcp.ent.model.obj.ObjPoint;
import com.holley.wxemcp.ent.model.obj.ObjRtu;
import com.holley.wxemcp.ent.model.ppf.EvtRecord;
import com.holley.wxemcp.ent.model.ppf.EvtRecordKey;
import com.holley.wxemcp.ent.service.emcp.RecordService;

/**
 * 事件相关
 * 
 * @author lenovo
 */
public class EventAction extends BaseAction {

    @Resource
    private RecordService recordService;

    public WxemcpEntResultBean getWxemcpEntResultBean() {
        return wxemcpEntResultBean;
    }

    public String initParkEventPage() {
        return SUCCESS;
    }

    public String initPrepayEventPage() {
        return SUCCESS;
    }

    public String initEventBlankPage() {
        return SUCCESS;
    }

    /**
     * 查询短信记录
     * 
     * @return
     */
    public String queryMessages() {
        int pageIndex = getParamInt("pageIndex");
        int sendType = getParamInt("sendType");
        String dateTime = getParameter("dateTime");// yyyy-MM
        String rechargeUpdateTime = getParameter("rechargeUpdateTime");// yyyy-MM-dd HH:mm:ss
        String remoteUpdateTime = getParameter("remoteUpdateTime");// yyyy-MM-dd HH:mm:ss
        WxemcpEntWebUser wxemcpEntWebUser = getUser();
        Map<String, Object> param = new HashMap<String, Object>();

        if (sendType > 0) {
            param.put("sendType", sendType);
        }
        if (StringUtil.isNotEmpty(dateTime)) {
            Date date = DateUtil.StrToDate(dateTime, DateUtil.MONTHTIME);
            param.put("firstDayOfMonth", returnFirstDatetime(DateUtil.getFirstDayOfMonth(date), 0));
            param.put("lastDayOfMonth", returnLastDatetime(DateUtil.getLastDayOfMonth(date), 0));
        }
        Page page = returnPage(pageIndex, limit);
        param.put("eid", wxemcpEntWebUser.getEntId());
        param.put(Globals.PAGE, page);
        List<MessageVo> ls = recordService.selectMessagesByPage(param);
        MessagesBase mb = new MessagesBase(page.getTotalProperty(), pageIndex, limit);
        mb.setDatas(ls);
        if (!StringUtil.isEmpty(rechargeUpdateTime)) {
            param.put("rechargeUpdateTime", DateUtil.StrToDate(rechargeUpdateTime, DateUtil.TIME_LONG));
            mb.setNewRechargeCount(recordService.queryNewRechargeCount(param));
        }
        if (!StringUtil.isEmpty(remoteUpdateTime)) {
            param.put("remoteUpdateTime", DateUtil.StrToDate(remoteUpdateTime, DateUtil.TIME_LONG));
            mb.setNewRemoteCount(recordService.queryNewRemoteCount(param));
        }
        wxemcpEntResultBean.setData(mb);
        return SUCCESS;
    }

    public String queryRemotes() {
        int remoteType = getParamInt("remoteType");
        int pageIndex = getParamInt("pageIndex");
        String dateTime = getParameter("dateTime");// yyyy-MM
        String messageUpdateTime = getParameter("messageUpdateTime");// 短信记录最后更新时间
        String rechargeUpdateTime = getParameter("rechargeUpdateTime");// 充值记录最后更新时间
        WxemcpEntWebUser wxemcpEntWebUser = getUser();
        Map<String, Object> param = new HashMap<String, Object>();
        if (remoteType > 0) {
            param.put("remoteType", remoteType);
            if (remoteType == 1) {// 自动拉闸
                param.put("cmdtype", CmdTypeEnum.DISCONNECT.getValue());
                param.put("operatetype", SendMsgTypeEnum.AUTO.getValue());
            }
            if (remoteType == 2) {// 自动合闸
                param.put("cmdtype", CmdTypeEnum.CONNECT.getValue());
                param.put("operatetype", SendMsgTypeEnum.AUTO.getValue());
            }
            if (remoteType == 3) {// 手动拉闸
                param.put("cmdtype", CmdTypeEnum.DISCONNECT.getValue());
                param.put("operatetype", SendMsgTypeEnum.MANUAL.getValue());
            }
            if (remoteType == 4) {// 手动合闸
                param.put("cmdtype", CmdTypeEnum.CONNECT.getValue());
                param.put("operatetype", SendMsgTypeEnum.MANUAL.getValue());
            }
        }
        if (StringUtil.isNotEmpty(dateTime)) {
            Date date = DateUtil.StrToDate(dateTime, DateUtil.MONTHTIME);
            param.put("firstDayOfMonth", returnFirstDatetime(DateUtil.getFirstDayOfMonth(date), 0));
            param.put("lastDayOfMonth", returnLastDatetime(DateUtil.getLastDayOfMonth(date), 0));
        }

        Page page = returnPage(pageIndex, limit);
        param.put("eid", wxemcpEntWebUser.getEntId());
        param.put(Globals.PAGE, page);
        List<PpfControlCmdVo> ls = recordService.selectRemotesByPage(param);
        PpfControlCmdBase pb = new PpfControlCmdBase(page.getTotalProperty(), pageIndex, limit);
        pb.setDatas(ls);
        if (!StringUtil.isEmpty(rechargeUpdateTime)) {
            param.put("rechargeUpdateTime", DateUtil.StrToDate(rechargeUpdateTime, DateUtil.TIME_LONG));
            pb.setNewRechargeCount(recordService.queryNewRechargeCount(param));
        }
        if (!StringUtil.isEmpty(messageUpdateTime)) {
            param.put("messageUpdateTime", DateUtil.StrToDate(messageUpdateTime, DateUtil.TIME_LONG));
            pb.setNewMessageCount(recordService.queryNewMessageCount(param));
        }
        wxemcpEntResultBean.setData(pb);
        return SUCCESS;
    }

    public String queryEvents() {
        int pageIndex = getParamInt("pageIndex");
        WxemcpEntWebUser wxemcpEntWebUser = getUser();
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("eid", wxemcpEntWebUser.getEntId());
        Date now = new Date();
        Date firstDatetime = returnFirstDatetime(now, 0);
        Date lastDatetime = returnLastDatetime(now, 0);
        Date firstDatetime2 = returnFirstDatetime(now, -1);
        param.put("firstDatetime", firstDatetime);
        param.put("lastDatetime", lastDatetime);
        param.put("firstDatetime2", firstDatetime2);
        Page page = returnPage(pageIndex, limit);
        param.put(Globals.PAGE, page);
        List<EvtRecordVo> ls = recordService.selectEvtRecordByPage(param);
        EvtRecordBase eb = new EvtRecordBase(page.getTotalProperty(), pageIndex, limit);
        eb.setDatas(ls);

        param.put("objtype", ObjectTypeEnum.OBJ_POINT.getIntValue());
        int hisPointToday = recordService.countTodayEvtHis(param);
        int hisPointLast = recordService.countLastEvtHis(param);

        param.put("objtype", ObjectTypeEnum.OBJ_RTU.getIntValue());
        int hisRtuToday = recordService.countTodayEvtHis(param);
        int hisRtuLast = recordService.countLastEvtHis(param);

        int last = recordService.countLastEvtRecord(param);
        int today = recordService.countTodayEvtRecord(param);

        int allToday = hisPointToday + hisRtuToday + today;
        int allLast = hisPointLast + hisRtuLast + last;
        eb.setTodayCount(allToday);
        eb.setYesterdayCount(allLast);
        wxemcpEntResultBean.setData(eb);
        return SUCCESS;

    }

    public String queryRecharges() {
        int pageIndex = getParamInt("pageIndex");
        int paywayType = getParamInt("paywayType");
        String dateTime = getParameter("dateTime");// yyyy-MM
        String messageUpdateTime = getParameter("messageUpdateTime");// 短信记录最后更新时间
        String remoteUpdateTime = getParameter("remoteUpdateTime");// yyyy-MM-dd HH:mm:ss
        WxemcpEntWebUser wxemcpEntWebUser = getUser();
        Map<String, Object> param = new HashMap<String, Object>();

        if (StringUtil.isNotEmpty(dateTime)) {
            Date tempdate = DateUtil.StrToDate(dateTime, DateUtil.MONTHTIME);

            param.put("firstDayOfMonth", returnFirstDatetime(DateUtil.getFirstDayOfMonth(tempdate), 0));
            param.put("lastDayOfMonth", returnLastDatetime(DateUtil.getLastDayOfMonth(tempdate), 0));
        }
        if (paywayType > 0) {
            param.put("paywayType", paywayType);
        }
        param.put("eid", wxemcpEntWebUser.getEntId());
        Page page = returnPage(pageIndex, limit);
        param.put(Globals.PAGE, page);
        List<RechargeVo> ls = recordService.selectRecordByPage(param);
        RechargeBase rg = new RechargeBase(page.getTotalProperty(), pageIndex, limit);
        rg.setDatas(ls);
        if (!StringUtil.isEmpty(remoteUpdateTime)) {
            param.put("remoteUpdateTime", DateUtil.StrToDate(remoteUpdateTime, DateUtil.TIME_LONG));
            rg.setNewRemoteCount(recordService.queryNewRemoteCount(param));
        }
        if (!StringUtil.isEmpty(messageUpdateTime)) {
            param.put("messageUpdateTime", DateUtil.StrToDate(messageUpdateTime, DateUtil.TIME_LONG));
            rg.setNewMessageCount(recordService.queryNewMessageCount(param));
        }
        wxemcpEntResultBean.setData(rg);
        return SUCCESS;

    }

    /**
     * 获取事件的详细信息
     * 
     * @return
     */
    public String queryEventDetail() {
        int type = getParamInt("type");
        int objid = getParamInt("objid");
        int objtype = getParamInt("objtype");
        // record
        int eventparamid = getParamInt("eventparamid");
        String occurtime = getParameter("occurtime");
        // his
        int eventitemid = getParamInt("eventitemid");
        int status = getParamInt("status");
        String eventtime = getParameter("eventtime");
        if (objid <= 0 || objtype <= 0) {
            wxemcpEntResultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        EventDetailVo vo = new EventDetailVo();
        if (type == 1) {
            vo.setType((short) 1);
            Date occurtimeDate = DateUtil.StrToDate(occurtime, DateUtil.TIME_LONG);
            if (eventparamid <= 0 || occurtimeDate == null) {
                wxemcpEntResultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
                return SUCCESS;
            }
            EvtRecordKey key = new EvtRecordKey();
            key.setEventparamid(eventparamid);
            key.setObjid(objid);
            key.setObjtype(objtype);
            key.setOccurtime(occurtimeDate);
            EvtRecord r = recordService.selectEvtRecordByPrimaryKey(key);
            if (r == null) {
                wxemcpEntResultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
                return SUCCESS;
            }
            vo.setEventContent(r.getEventdesc());
            vo.setEventTime(r.getSendtime());
            vo.setRecEventType(r.getEventtype());
        } else if (type == 2) {
            vo.setType((short) 2);
            Date eventtimeDate = DateUtil.StrToDate(eventtime, DateUtil.TIME_LONG);
            if (eventitemid <= 0 || status < 0) {
                wxemcpEntResultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
                return SUCCESS;
            }
            DatEvtHisKey key = new DatEvtHisKey();
            key.setEventitemid((short) eventitemid);
            key.setEventtime(eventtimeDate);
            key.setObjid(objid);
            key.setObjtype((short) objtype);
            key.setStatus((short) status);
            DatEvtHis his = recordService.selectDatEvtHisByPrimaryKey(key);
            if (his == null) {
                wxemcpEntResultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
                return SUCCESS;
            }
            vo.setEventTime(his.getEventtime());
            vo.setHisEvenStatus(his.getStatus());
            vo.setHisEventNote(his.getEventnote());
            if (ObjectTypeEnum.OBJ_POINT.getShortValue() == his.getObjtype()) {
                ObjPoint point = recordService.selectObjPointByPrimaryKey(his.getObjid());
                vo.setEventContent("计量点【" + point.getName() + "】 " + his.getEventdata());
            } else if (ObjectTypeEnum.OBJ_RTU.getShortValue() == his.getObjtype()) {
                ObjRtu rtu = recordService.selectObjRtuByPrimaryKey(his.getObjid());
                vo.setEventContent("终端【" + rtu.getName() + "】 " + his.getEventdata());
            }
        }
        wxemcpEntResultBean.setData(vo);
        return SUCCESS;
    }

    private Date returnFirstDatetime(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    private Date returnLastDatetime(Date date, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return calendar.getTime();
    }

}
