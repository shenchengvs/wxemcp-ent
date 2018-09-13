package com.holley.wxemcp.ent.common.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.math.NumberUtils;

import com.holley.platform.common.util.StringUtil;
import com.holley.platform.model.sys.SysAccount;
import com.holley.wxemcp.ent.common.cache.ReaderResourceUtil;
import com.holley.wxemcp.ent.common.constants.EnterpriseTypeEnum;
import com.holley.wxemcp.ent.common.constants.WxemcpEntGlobals;
import com.holley.wxemcp.ent.dao.dat.DatEvtHisMapper;
import com.holley.wxemcp.ent.model.def.EvtWxSendVo;
import com.holley.wxemcp.ent.model.def.WxSendEventId;
import com.holley.wxemcp.ent.model.def.WxSendStatusBean;
import com.holley.wxemcp.ent.model.def.WxemcpEntWebUser;
import com.holley.wxemcp.ent.model.obj.ObjEnterprise;
import com.holley.wxemcp.ent.model.sys.SysUnregisterAccount;
import com.holley.wxemcp.ent.service.common.BaseService;
import com.holley.wxemcp.ent.service.emcp.AccountService;
import com.holley.wxemcp.ent.service.emcp.RecordService;

public class WxEmcpEntLocalUtil {

    private static ThreadLocal<WxemcpEntWebUser>               wxemcpEntWebUserLocal     = new ThreadLocal<WxemcpEntWebUser>();
    private static AccountService                              accountService;
    private static RecordService                               recordService;
    private static BaseService                                 baseService;
    private static ConcurrentHashMap<String, WxemcpEntWebUser> map                       = new ConcurrentHashMap<String, WxemcpEntWebUser>();
    public static List<Integer>                                eids                      = null;
    // 实时事件
    public static List<Integer>                                rtuEventIds               = null;
    public static List<Integer>                                pointEventIds             = null;
    public static Map<Integer, Date>                           lastEventTimeMap          = new HashMap<Integer, Date>();

    // 主副事件
    public static List<Integer>                                rtuPrincipalEventIds      = null;
    public static List<Integer>                                rtuAssistantEventIds      = null;
    public static List<Integer>                                pointPrincipalEventIds    = null;
    public static List<Integer>                                pointAssistantEventIds    = null;
    public static List<Integer>                                rtuDelayTimes             = null;
    public static List<Integer>                                pointDelayTimes           = null;
    public static Map<Integer, List<WxSendStatusBean>>         rtuSendStatusBean         = null;
    public static Map<Integer, List<WxSendStatusBean>>         pointSendStatusBean       = null;
    public static Map<Integer, WxSendEventId>                  rtuPrincipalSendEventId   = null;
    public static Map<Integer, WxSendEventId>                  pointPrincipalSendEventId = null;

    public static void init() {
        initWechatConfig();
        initLastEventTimeAllEid();
        initWxSendEventId();
        initPrincipalAndAssistant();
    }

    public static void initRtuWxSendStatusBean(Integer eid, EvtWxSendVo lastRtuPrincipalEvent) {
        Integer itemid = lastRtuPrincipalEvent.getEventItemId().intValue();
        List<WxSendStatusBean> list = rtuSendStatusBean.get(eid);

        if (rtuPrincipalSendEventId.containsKey(itemid)) {
            WxSendStatusBean bean = new WxSendStatusBean();
            bean.setEid(eid);
            bean.setObjId(lastRtuPrincipalEvent.getObjId());
            bean.setObjType(lastRtuPrincipalEvent.getObjType());
            bean.setPrincipalId(lastRtuPrincipalEvent.getEventItemId().intValue());
            bean.setPrincipalDate(lastRtuPrincipalEvent.getEventTime());
            bean.setAssistantId(rtuPrincipalSendEventId.get(itemid).getAssistanId());
            bean.setSendDate(new Date());
            list.add(bean);
        }
    }

    public static void initPointWxSendStatusBean(Integer eid, EvtWxSendVo lastPointPrincipalEvent) {
        Integer itemid = lastPointPrincipalEvent.getEventItemId().intValue();
        List<WxSendStatusBean> list = pointSendStatusBean.get(eid);

        if (pointPrincipalSendEventId.containsKey(itemid)) {
            WxSendStatusBean bean = new WxSendStatusBean();
            bean.setEid(eid);
            bean.setObjId(lastPointPrincipalEvent.getObjId());
            bean.setObjType(lastPointPrincipalEvent.getObjType());
            bean.setPrincipalId(lastPointPrincipalEvent.getEventItemId().intValue());
            bean.setPrincipalDate(lastPointPrincipalEvent.getEventTime());
            bean.setAssistantId(pointPrincipalSendEventId.get(itemid).getAssistanId());
            bean.setSendDate(new Date());
            list.add(bean);
        }
    }

    private static void initWxSendEventId() {
        WxSendEventId wxSendEventId = null;
        if (eids != null && !eids.isEmpty()) {
            if (rtuDelayTimes != null && !rtuDelayTimes.isEmpty()) {
                int dsize = rtuDelayTimes.size();
                if (rtuPrincipalEventIds != null && !rtuPrincipalEventIds.isEmpty() && rtuPrincipalEventIds.size() == rtuAssistantEventIds.size()) {
                    int psize = rtuPrincipalEventIds.size();
                    rtuPrincipalSendEventId = new HashMap<Integer, WxSendEventId>();
                    for (int x = 0; x < psize; x++) {
                        wxSendEventId = new WxSendEventId(rtuAssistantEventIds.get(x), dsize == psize ? rtuDelayTimes.get(x) : rtuDelayTimes.get(0));
                        rtuPrincipalSendEventId.put(rtuPrincipalEventIds.get(x), wxSendEventId);
                    }
                }
            }
            if (pointDelayTimes != null && !pointDelayTimes.isEmpty()) {
                int dsize = pointDelayTimes.size();
                if (pointPrincipalEventIds != null && !pointPrincipalEventIds.isEmpty() && pointPrincipalEventIds.size() == pointAssistantEventIds.size()) {
                    int psize = pointPrincipalEventIds.size();
                    pointPrincipalSendEventId = new HashMap<Integer, WxSendEventId>();
                    for (int x = 0; x < psize; x++) {
                        wxSendEventId = new WxSendEventId(pointAssistantEventIds.get(x), dsize == psize ? pointDelayTimes.get(x) : pointDelayTimes.get(0));
                        pointPrincipalSendEventId.put(pointPrincipalEventIds.get(x), wxSendEventId);
                    }
                }
            }
        }
    }

    private static void initPrincipalAndAssistant() {
        if (eids != null && !eids.isEmpty()) {
            Date now = new Date();
            for (Integer eid : eids) {
                initPrincipalAndAssistant(eid, now);
            }

        }
    }

    private static void initPrincipalAndAssistant(Integer eid, Date now) {
        if (rtuPrincipalEventIds != null && rtuAssistantEventIds != null && rtuPrincipalEventIds.size() == rtuAssistantEventIds.size()) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("eid", eid);
            map.put("rtuEventIds", rtuPrincipalEventIds);
            List<EvtWxSendVo> lastRtuPrincipalEvents = baseService.getMapperBean(DatEvtHisMapper.class).selectRtuWxSendEventByEid(map);
            if (rtuSendStatusBean == null) {
                rtuSendStatusBean = new HashMap<Integer, List<WxSendStatusBean>>();
            }
            WxSendStatusBean bean = null;
            List<WxSendStatusBean> l = new ArrayList<WxSendStatusBean>();
            for (EvtWxSendVo vo : lastRtuPrincipalEvents) {
                for (Integer rtuEventid : rtuPrincipalEventIds) {
                    if (vo.getEventItemId().intValue() == rtuEventid) {
                        bean = new WxSendStatusBean();
                        bean.setEid(eid);
                        bean.setObjId(vo.getObjId());
                        bean.setObjType(vo.getObjType());
                        bean.setPrincipalId(vo.getEventItemId().intValue());
                        bean.setPrincipalDate(vo.getEventTime());
                        bean.setAssistantId(rtuPrincipalSendEventId.get(rtuEventid).getAssistanId());
                        bean.setSendDate(now);
                        l.add(bean);
                        break;
                    }
                }
            }
            rtuSendStatusBean.put(eid, l);
        }
        if (pointPrincipalEventIds != null && pointAssistantEventIds != null && pointPrincipalEventIds.size() == pointAssistantEventIds.size()) {

            Map<String, Object> map = new HashMap<String, Object>();
            map.put("eid", eid);
            map.put("pointEventIds", pointPrincipalEventIds);
            List<EvtWxSendVo> lastRtuPrincipalEvents = baseService.getMapperBean(DatEvtHisMapper.class).selectPointWxSendEventByEid(map);
            if (pointSendStatusBean == null) {
                pointSendStatusBean = new HashMap<Integer, List<WxSendStatusBean>>();
            }
            WxSendStatusBean bean = null;
            List<WxSendStatusBean> l = new ArrayList<WxSendStatusBean>();
            for (EvtWxSendVo vo : lastRtuPrincipalEvents) {
                for (Integer pointEventid : pointPrincipalEventIds) {
                    if (vo.getEventItemId().intValue() == pointEventid) {
                        bean = new WxSendStatusBean();
                        bean.setEid(eid);
                        bean.setObjId(vo.getObjId());
                        bean.setObjType(vo.getObjType());
                        bean.setPrincipalId(vo.getEventItemId().intValue());
                        bean.setPrincipalDate(vo.getEventTime());
                        bean.setAssistantId(pointPrincipalSendEventId.get(pointEventid).getAssistanId());
                        bean.setSendDate(now);
                        l.add(bean);
                        break;
                    }
                }
            }
            pointSendStatusBean.put(eid, l);
        }
    }

    private static void initLastEventTimeAllEid() {
        if (eids != null && !eids.isEmpty()) {
            for (Integer eid : eids) {
                initLastEventTimeOneEid(eid);
            }

        }
    }

    private static void initLastEventTimeOneEid(Integer eid) {
        Date rtuLastDate = null;
        Date pointLastDate = null;
        Date lastDate = null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("eid", eid);
        map.put("isOne", 1);
        if (rtuEventIds != null && !rtuEventIds.isEmpty()) {
            map.put("rtuEventIds", rtuEventIds);
            List<EvtWxSendVo> rtuList = recordService.selectRtuWxSendEvent(map);
            if (rtuList != null && !rtuList.isEmpty()) {
                rtuLastDate = rtuList.get(0).getEventTime();
            }
        }
        if (pointEventIds != null && !pointEventIds.isEmpty()) {
            map.put("pointEventIds", pointEventIds);
            List<EvtWxSendVo> pointList = recordService.selectPointWxSendEvent(map);
            if (pointList != null && !pointList.isEmpty()) {
                pointLastDate = pointList.get(0).getEventTime();
            }
        }
        if (rtuLastDate != null) {
            lastDate = rtuLastDate;
        }
        if (lastDate != null && pointLastDate != null && pointLastDate.getTime() > lastDate.getTime()) {
            lastDate = pointLastDate;
        } else if (lastDate == null && pointLastDate != null) {
            lastDate = pointLastDate;
        }

        lastDate = lastDate != null ? lastDate : new Date();
        lastEventTimeMap.put(eid, lastDate);
    }

    /**
     * 载入微信公众号配置
     */
    private static void initWechatConfig() {
        // 载入配置
        Properties p = ReaderResourceUtil.getClassPathProperties("wxemcpEnt.properties");
        String tem = null;
        tem = p.getProperty("app_secret");
        if (StringUtil.isNotEmpty(tem)) {
            WxemcpEntGlobals.WX_APP_SECRET = tem;
        }
        tem = p.getProperty("app_id");
        if (StringUtil.isNotEmpty(tem)) {
            WxemcpEntGlobals.WX_APP_ID = tem;
        }
        tem = p.getProperty("warn_template_id");
        if (StringUtil.isNotEmpty(tem)) {
            WxemcpEntGlobals.WX_WARN_TEMPLATE_ID = tem;
        }
        tem = p.getProperty("release_mode");
        if (StringUtil.isNotEmpty(tem)) {
            WxemcpEntGlobals.RELEASE_MODE = Integer.parseInt(tem);
        }

        tem = p.getProperty("proxy_ip");
        if (StringUtil.isNotEmpty(tem)) {
            WxemcpEntGlobals.PROXY_IP = tem;
        }

        tem = p.getProperty("port");
        if (StringUtil.isNotEmpty(tem)) {
            WxemcpEntGlobals.PORT = Integer.parseInt(tem);
        }

        tem = p.getProperty("eids");
        if (StringUtil.isNotEmpty(tem)) {
            eids = wrapPropertys(tem);
        }
        tem = p.getProperty("rtu_event_ids");
        if (StringUtil.isNotEmpty(tem)) {
            rtuEventIds = wrapPropertys(tem);
        }
        tem = p.getProperty("point_event_ids");
        if (StringUtil.isNotEmpty(tem)) {
            pointEventIds = wrapPropertys(tem);
        }
        // 主副事件配置
        tem = p.getProperty("rtu_principal_event_ids");
        if (StringUtil.isNotEmpty(tem)) {
            rtuPrincipalEventIds = wrapPropertys(tem);
        }

        tem = p.getProperty("rtu_assistant_event_ids");
        if (StringUtil.isNotEmpty(tem)) {
            rtuAssistantEventIds = wrapPropertys(tem);
        }

        tem = p.getProperty("point_principal_event_ids");
        if (StringUtil.isNotEmpty(tem)) {
            pointPrincipalEventIds = wrapPropertys(tem);
        }

        tem = p.getProperty("point_assistant_event_ids");
        if (StringUtil.isNotEmpty(tem)) {
            pointAssistantEventIds = wrapPropertys(tem);
        }

        tem = p.getProperty("rtuDelayTimes");
        if (StringUtil.isNotEmpty(tem)) {
            rtuDelayTimes = wrapPropertys(tem);
        }
        tem = p.getProperty("pointDelayTimes");
        if (StringUtil.isNotEmpty(tem)) {
            pointDelayTimes = wrapPropertys(tem);
        }
    }

    private static List<Integer> wrapPropertys(String value) {
        List<String> tlist = Arrays.asList(value.split(","));
        List<Integer> list = new ArrayList<Integer>();
        if (tlist != null && tlist.size() > 0) {
            for (String s : tlist) {
                int time = NumberUtils.toInt(s);
                if (time > 0) {
                    list.add(time);
                }
            }
        }
        return list;
    }

    public static void setUserLocal(WxemcpEntWebUser wxemcpEntWebUser) {
        wxemcpEntWebUserLocal.set(wxemcpEntWebUser);
    }

    public static WxemcpEntWebUser getUserLocal() {
        return wxemcpEntWebUserLocal.get();
    }

    public static void removeUserLocal() {
        wxemcpEntWebUserLocal.remove();
    }

    public static WxemcpEntWebUser addUser(SysAccount account, ObjEnterprise objEnterprise) {
        Short etype = objEnterprise.getEtype();
        if (!EnterpriseTypeEnum.PARK.getShortValue().equals(etype) && !EnterpriseTypeEnum.PREPAY.getShortValue().equals(etype)) {
            etype = EnterpriseTypeEnum.PARK.getShortValue();
        }
        WxemcpEntWebUser wxemcpEntWebUser = new WxemcpEntWebUser();
        wxemcpEntWebUser.setAccount(account.getAccount());
        wxemcpEntWebUser.setEntType(etype);
        wxemcpEntWebUser.setEntId(account.getDepartmentid());
        map.put(wxemcpEntWebUser.getAccount(), wxemcpEntWebUser);
        return wxemcpEntWebUser;
    }

    public static WxemcpEntWebUser addUnregisterUser(String phone, ObjEnterprise objEnterprise, Short entType) {
        // Short etype = objEnterprise.getEtype();
        // if (!EnterpriseTypeEnum.PARK.getShortValue().equals(etype) &&
        // !EnterpriseTypeEnum.PREPAY.getShortValue().equals(etype)) {
        // etype = EnterpriseTypeEnum.PARK.getShortValue();
        // }
        WxemcpEntWebUser wxemcpEntWebUser = new WxemcpEntWebUser();
        wxemcpEntWebUser.setAccount(phone);
        wxemcpEntWebUser.setEntType(entType);
        wxemcpEntWebUser.setEntId(objEnterprise.getEid());
        map.put(wxemcpEntWebUser.getAccount(), wxemcpEntWebUser);
        return wxemcpEntWebUser;
    }

    public static WxemcpEntWebUser returnUser(String account) {
        if (map.containsKey(account)) {
            return map.get(account);
        } else {
            SysAccount sysAccount = accountService.selectAccountByPrimaryKey(account);
            if (sysAccount != null) {
                if (sysAccount.getDepartmentid() != null && sysAccount.getDepartmentid() > 0) {
                    ObjEnterprise objEnterprise = accountService.selectEnterpriseByPrimaryKey(sysAccount.getDepartmentid());
                    if (objEnterprise != null) {
                        return addUser(sysAccount, objEnterprise);
                    }
                }

            } else {
                SysUnregisterAccount UnregisterAccount = accountService.selectUnregisterAccountByPrimaryKey(account);
                if (UnregisterAccount != null) {
                    ObjEnterprise objEnterprise = accountService.selectEnterpriseByPrimaryKey(WxemcpEntGlobals.DEFAULT_UNREGISTER_ENT);
                    if (objEnterprise != null) {
                        return addUnregisterUser(account, objEnterprise, EnterpriseTypeEnum.PARK.getShortValue());
                    }
                }
            }

        }
        return null;
    }

    public static void setAccountService(AccountService accountService) {
        WxEmcpEntLocalUtil.accountService = accountService;
    }

    public static void setRecordService(RecordService recordService) {
        WxEmcpEntLocalUtil.recordService = recordService;
    }

    public static void setBaseService(BaseService baseService) {
        WxEmcpEntLocalUtil.baseService = baseService;
    }

}
