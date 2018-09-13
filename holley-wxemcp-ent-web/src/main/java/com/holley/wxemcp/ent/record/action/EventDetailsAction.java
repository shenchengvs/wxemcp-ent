package com.holley.wxemcp.ent.record.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.rocketmq.shade.io.netty.util.internal.StringUtil;
import com.holley.platform.common.util.DateUtil;
import com.holley.wxemcp.ent.action.BaseAction;
import com.holley.wxemcp.ent.common.constants.SmsTypeEnum;
import com.holley.wxemcp.ent.common.util.WxEmcpEntUtil;
import com.holley.wxemcp.ent.model.def.CuiFeiCountBlock;
import com.holley.wxemcp.ent.model.def.CuiFeiCountVo;
import com.holley.wxemcp.ent.model.def.EventCountDetailsBlock;
import com.holley.wxemcp.ent.model.def.LaZhaCountBlock;
import com.holley.wxemcp.ent.model.def.LaZhaCountVo;
import com.holley.wxemcp.ent.model.def.RechargeCountBlock;
import com.holley.wxemcp.ent.model.def.RechargeCountVo;
import com.holley.wxemcp.ent.model.def.WxemcpEntResultBean;
import com.holley.wxemcp.ent.model.def.WxemcpEntWebUser;
import com.holley.wxemcp.ent.service.emcp.RecordService;

public class EventDetailsAction extends BaseAction {

    @Resource
    private RecordService dataService;

    public WxemcpEntResultBean getWxemcpEntResultBean() {
        return wxemcpEntResultBean;
    }

    public String queryEventDetails() {
        int dataType = getParamInt("dataType");
        String datetime = getParameter("datetime");
        WxemcpEntWebUser wxemcpEntWebUser = getUser();
        Integer eid = wxemcpEntWebUser.getEntId();
        if (StringUtil.isNullOrEmpty(datetime)) { // 如果没有时间参数，默认为当天
            datetime = DateUtil.DateToStr(new Date(), DateUtil.TIME_SHORT_CN);
        }
        Map<String, Date> map = WxEmcpEntUtil.getDateTimeByType(dataType, datetime);
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("eid", eid);
        param.put("tobeg", map.get("tobeg"));
        param.put("labeg", map.get("labeg"));
        param.put("latobeg", map.get("latobeg"));
        param.put("latoend", map.get("latoend"));

        /*----------------拉闸次数模块---------------*/
        int nowLazhaCount = dataService.queryLazhaCount(param);
        int LALazhaCount = dataService.queryLALazhaCount(param);
        int LALALazhaCount = dataService.queryLALALazhaCount(param);
        List<LaZhaCountVo> ls = new ArrayList<LaZhaCountVo>();
        LaZhaCountVo v1 = new LaZhaCountVo();
        v1.setName(dataType == 1 ? "当日" : "当月");
        v1.setCount(nowLazhaCount);
        LaZhaCountVo v2 = new LaZhaCountVo();
        v2.setName(dataType == 1 ? "上日" : "上月");
        v2.setCount(LALazhaCount);
        LaZhaCountVo v3 = new LaZhaCountVo();
        v3.setName(dataType == 1 ? "上周本日" : "去年本月");
        v3.setCount(LALALazhaCount);
        ls.add(v1);
        ls.add(v2);
        ls.add(v3);
        LaZhaCountBlock lb = new LaZhaCountBlock();
        lb.setLs(ls);
        if (LALazhaCount != 0) {
            lb.setUpratethanla((nowLazhaCount - LALazhaCount) / LALazhaCount);
        }
        if (LALALazhaCount != 0) {
            lb.setUpratethanlala((nowLazhaCount - LALALazhaCount) / LALALazhaCount);
        }
        lb.setNowcount(nowLazhaCount);

        /*----------------拉闸次数模块---------------*/
        /*----------------充值次数模块---------------*/
        int queryCount = dataService.queryChongZhiCount(param);
        int queryLaCount = dataService.queryLaChongZhiCount(param);
        int queryLaLaCount = dataService.queryLaLaChongZhiCount(param);
        List<RechargeCountVo> ls2 = new ArrayList<RechargeCountVo>();
        RechargeCountVo vo1 = new RechargeCountVo();
        vo1.setName(dataType == 1 ? "当日" : "当月");
        vo1.setCount(queryCount);
        RechargeCountVo vo2 = new RechargeCountVo();
        vo2.setName(dataType == 1 ? "上日" : "上月");
        vo2.setCount(queryLaCount);
        RechargeCountVo vo3 = new RechargeCountVo();
        vo3.setName(dataType == 1 ? "上周本日" : "去年本月");
        vo3.setCount(queryLaLaCount);
        RechargeCountBlock rb = new RechargeCountBlock();
        ls2.add(vo1);
        ls2.add(vo2);
        ls2.add(vo3);
        rb.setLs(ls2);
        if (queryLaCount != 0) {
            rb.setUpratethanla((queryCount - queryLaCount) / queryLaCount);
        }
        if (queryLaLaCount != 0) {
            rb.setUpratethanlala((queryCount - queryLaLaCount) / queryLaLaCount);
        }
        rb.setNowcount(queryCount);
        /*----------------充值次数模块---------------*/
        /*----------------催费次数模块---------------*/

        param.put("type", SmsTypeEnum.REMINDERFEE.getValue());
        int nowCuifeiCount = dataService.queryCuifeiCount(param);
        int LACuiFeiCount = dataService.queryLACuiFeiCount(param);
        int LALACuiFeiCount = dataService.queryLALACuiFeiCount(param);
        CuiFeiCountVo voo1 = new CuiFeiCountVo();
        voo1.setCount(nowCuifeiCount);
        voo1.setName(dataType == 1 ? "当日" : "当月");
        CuiFeiCountVo voo2 = new CuiFeiCountVo();
        voo2.setCount(LACuiFeiCount);
        voo2.setName(dataType == 1 ? "上日" : "上月");
        CuiFeiCountVo voo3 = new CuiFeiCountVo();
        voo3.setCount(LALACuiFeiCount);
        voo3.setName(dataType == 1 ? "上周本日" : "去年本月");
        List<CuiFeiCountVo> ls3 = new ArrayList<CuiFeiCountVo>();
        CuiFeiCountBlock cf = new CuiFeiCountBlock();
        ls3.add(voo1);
        ls3.add(voo2);
        ls3.add(voo3);
        cf.setLs(ls3);
        if (LACuiFeiCount != 0) {
            cf.setUpratethanla((nowCuifeiCount - LACuiFeiCount) / LACuiFeiCount);
        }
        if (LALACuiFeiCount != 0) {
            cf.setUpratethanlala((nowCuifeiCount - LALACuiFeiCount) / LALACuiFeiCount);
        }
        cf.setNowcount(nowCuifeiCount);
        /*----------------催费次数模块---------------*/
        EventCountDetailsBlock eb = new EventCountDetailsBlock();
        eb.setCuiFeiCountBlock(cf);
        eb.setLaZhaCountBlock(lb);
        eb.setRechargeCountBlock(rb);
        wxemcpEntResultBean.setData(eb);
        return SUCCESS;
    }
}
