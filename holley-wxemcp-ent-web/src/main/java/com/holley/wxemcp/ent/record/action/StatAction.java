package com.holley.wxemcp.ent.record.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.alibaba.rocketmq.shade.io.netty.util.internal.StringUtil;
import com.holley.platform.common.constants.CircleTypeEnum;
import com.holley.platform.common.util.DateUtil;
import com.holley.platform.common.util.NumberUtil;
import com.holley.wxemcp.ent.action.BaseAction;
import com.holley.wxemcp.ent.common.constants.EnterpriseTypeEnum;
import com.holley.wxemcp.ent.common.constants.SmsTypeEnum;
import com.holley.wxemcp.ent.common.util.WxEmcpEntUtil;
import com.holley.wxemcp.ent.model.def.CuiFeiCountBlock;
import com.holley.wxemcp.ent.model.def.CuiFeiCountVo;
import com.holley.wxemcp.ent.model.def.DataPresentationBase;
import com.holley.wxemcp.ent.model.def.DepartmentUseBlock;
import com.holley.wxemcp.ent.model.def.DepartmentUseDetailsBlock;
import com.holley.wxemcp.ent.model.def.DepartmentUseDetailsVo;
import com.holley.wxemcp.ent.model.def.DepartmentUseVo;
import com.holley.wxemcp.ent.model.def.ElectricalConsumptionBlock;
import com.holley.wxemcp.ent.model.def.ElectricalConsumptionBlockVo;
import com.holley.wxemcp.ent.model.def.EnergyUseDetailsBlock;
import com.holley.wxemcp.ent.model.def.EnergyUseDetailsVo;
import com.holley.wxemcp.ent.model.def.EnergyUserBlock;
import com.holley.wxemcp.ent.model.def.EnergyUserBlockVo;
import com.holley.wxemcp.ent.model.def.EventCountBlock;
import com.holley.wxemcp.ent.model.def.EventCountDetailsBlock;
import com.holley.wxemcp.ent.model.def.EventCountVo;
import com.holley.wxemcp.ent.model.def.LaZhaCountBlock;
import com.holley.wxemcp.ent.model.def.LaZhaCountVo;
import com.holley.wxemcp.ent.model.def.RechargeCountBlock;
import com.holley.wxemcp.ent.model.def.RechargeCountVo;
import com.holley.wxemcp.ent.model.def.RechargeMoneyBlock;
import com.holley.wxemcp.ent.model.def.RechargeMoneyVo;
import com.holley.wxemcp.ent.model.def.WxemcpEntResultBean;
import com.holley.wxemcp.ent.model.def.WxemcpEntWebUser;
import com.holley.wxemcp.ent.service.emcp.RecordService;

/**
 * 图表统计相关
 * 
 * @author sc
 */
public class StatAction extends BaseAction {

    @Resource
    private RecordService recordService;

    public WxemcpEntResultBean getWxemcpEntResultBean() {
        return wxemcpEntResultBean;
    }

    public String initStatPage() {
        return SUCCESS;
    }

    public String initDepartmentUserDetailsPage() {
        return SUCCESS;
    }

    public String initEnergyUseDetailsPage() {
        return SUCCESS;
    }

    public String initEventDetailsPage() {
        return SUCCESS;
    }

    public String queryStatistics() {
        int dataType = getParamInt("datatype");
        String datetime = getParameter("datetime");
        WxemcpEntWebUser wxemcpEntWebUser = getUser();
        Integer entId = wxemcpEntWebUser.getEntId();

        if (StringUtil.isNullOrEmpty(datetime)) { // 如果没有时间参数，默认为当天
            if (dataType == 1) {
                datetime = DateUtil.DateToStr(new Date(), DateUtil.TIME_SHORT);
            } else {
                datetime = DateUtil.DateToStr(new Date(), DateUtil.MONTHTIME);
            }
        }

        double temvalue = 0;
        DataPresentationBase dataBase = new DataPresentationBase();

        /*----------------电力能耗模块start---------------*/
        ElectricalConsumptionBlock electricalConsumptionBlock = new ElectricalConsumptionBlock();
        List<ElectricalConsumptionBlockVo> electricalConsumptions = wrapElectricalConsumption(dataType, datetime, entId);
        electricalConsumptionBlock.setLs(electricalConsumptions);

        double lalaconsumption = electricalConsumptions.get(0).getConsumption();// 上周本日/去年本月数据
        double nowconsumption = electricalConsumptions.get(1).getConsumption();// 当日/当月数据
        double laconsumption = electricalConsumptions.get(2).getConsumption();// 昨日/上月数据

        if (laconsumption != 0) {
            temvalue = (nowconsumption - laconsumption) / laconsumption;
            temvalue = temvalue > 0 ? temvalue : 0.0;
            temvalue = new BigDecimal(temvalue * 100).setScale(NumberUtil.DEF_SCALE, NumberUtil.PERCISION).doubleValue();
            electricalConsumptionBlock.setUpratethanla(temvalue);
        }
        if (lalaconsumption != 0) {
            temvalue = (nowconsumption - lalaconsumption) / lalaconsumption;
            temvalue = temvalue > 0 ? temvalue : 0.0;
            temvalue = new BigDecimal(temvalue * 100).setScale(NumberUtil.DEF_SCALE, NumberUtil.PERCISION).doubleValue();
            electricalConsumptionBlock.setUpratethanlala(temvalue);
        }
        electricalConsumptionBlock.setNowsum(nowconsumption);
        /*----------------电力能耗模块end---------------*/

        /*----------------能耗用途模块start---------------*/
        EnergyUserBlock energyUserBlock = new EnergyUserBlock();
        List<EnergyUserBlockVo> energyUsers = wrapEnergyUse(dataType, datetime, entId);
        energyUserBlock.setLs(energyUsers);
        /*----------------能耗用途模块end---------------*/

        /*----------------部门用能模块start---------------*/
        DepartmentUseBlock departmentUseBlock = new DepartmentUseBlock();
        List<DepartmentUseVo> departmentUses = wrapDepartmentUse(dataType, datetime, entId);
        departmentUseBlock.setLs(departmentUses);

        /*----------------部门用能模块end---------------*/
        dataBase.setElectricalConsumptionBlock(electricalConsumptionBlock);
        dataBase.setEnergyUserBlock(energyUserBlock);
        dataBase.setDepartmentUseBlock(departmentUseBlock);
        if (EnterpriseTypeEnum.PREPAY.getShortValue().equals(wxemcpEntWebUser.getEntType())) {
            /*----------------充值金额模块start---------------*/
            List<RechargeMoneyVo> rechargeMoneys = wrapRechargeMoneyDatas(dataType, datetime, entId);
            RechargeMoneyBlock rechargeMoneyBlock = new RechargeMoneyBlock();
            rechargeMoneyBlock.setLs(rechargeMoneys);

            double todayOrMonthRechargeMoney = rechargeMoneys.get(1).getMoney();// 当天数据/当月数据
            double lastdayOrMonthRechargeMoney = rechargeMoneys.get(2).getMoney();// 昨天数据/上月数据
            double preWeekTodayOrMonthRechargeMoney = rechargeMoneys.get(0).getMoney();// 上周本日/去年本月
            rechargeMoneyBlock.setNowRechargeMoney(todayOrMonthRechargeMoney);
            if (lastdayOrMonthRechargeMoney != 0) {
                temvalue = (todayOrMonthRechargeMoney - lastdayOrMonthRechargeMoney) / lastdayOrMonthRechargeMoney;
                temvalue = temvalue > 0 ? temvalue : 0.0;
                temvalue = new BigDecimal(temvalue * 100).setScale(NumberUtil.DEF_SCALE, NumberUtil.PERCISION).doubleValue();
                rechargeMoneyBlock.setUpRateThanLa(temvalue);
            }
            if (preWeekTodayOrMonthRechargeMoney != 0) {
                temvalue = (todayOrMonthRechargeMoney - preWeekTodayOrMonthRechargeMoney) / preWeekTodayOrMonthRechargeMoney;
                temvalue = temvalue > 0 ? temvalue : 0.0;
                temvalue = new BigDecimal(temvalue * 100).setScale(NumberUtil.DEF_SCALE, NumberUtil.PERCISION).doubleValue();
                rechargeMoneyBlock.setUpRateThanLaLa(temvalue);
            }
            /*----------------充值金额模块end---------------*/

            /*----------------事件统计模块start---------------*/
            EventCountBlock eventCountBlock = new EventCountBlock();
            List<EventCountVo> eventCounts = wrapEventCountDatas(dataType, datetime, entId);
            eventCountBlock.setLs(eventCounts);
            /*----------------事件统计模块end---------------*/

            dataBase.setRechargeMoneyBlock(rechargeMoneyBlock);
            dataBase.setEventCountBlock(eventCountBlock);

            Map<String, Object> param = new HashMap<String, Object>();
            param.put("eid", wxemcpEntWebUser.getEntId());
            dataBase.setOwingmoney(recordService.queryAllOwingMoney(param));

            dataBase.setRemainingmoney(recordService.queryAllRemainingMoney(param));

            dataBase.setOwingusers(recordService.queryOwingMoneyCstomer(param));
        }
        wxemcpEntResultBean.setData(dataBase);
        return SUCCESS;
    }

    private List<RechargeMoneyVo> wrapRechargeMoneyDatas(int datatype, String date, Integer eid) {

        Map<String, Date> map = WxEmcpEntUtil.getDateTimeByType(datatype, date);
        Map<String, Object> param = new HashMap<String, Object>();

        param.put("eid", eid);
        List<RechargeMoneyVo> ls = new ArrayList<RechargeMoneyVo>();

        param.put("tobeg", map.get("tobeg"));
        param.put("labeg", map.get("labeg"));
        param.put("latobeg", map.get("latobeg"));
        param.put("latoend", map.get("latoend"));
        param.put("toend", map.get("toend"));

        double todayRechargeMoney = recordService.queryMoneyCount(param);
        RechargeMoneyVo v1 = new RechargeMoneyVo();
        v1.setMoney(todayRechargeMoney);
        v1.setName(datatype == 1 ? "当日" : "当月");

        double lastRechargeMoney = recordService.queryLaMoneyCount(param);// 昨天的充值金额
        RechargeMoneyVo v2 = new RechargeMoneyVo();
        v2.setMoney(lastRechargeMoney);
        v2.setName(datatype == 1 ? "上日" : "上月");

        double preWeekTodayRechargeMoney = recordService.queryLaLaMoneyCount(param);
        RechargeMoneyVo v3 = new RechargeMoneyVo();
        v3.setMoney(preWeekTodayRechargeMoney);
        v3.setName(datatype == 1 ? "上周本日" : "去年本月");
        ls.add(v3);
        ls.add(v1);
        ls.add(v2);

        return ls;
    }

    private List<EventCountVo> wrapEventCountDatas(int datatype, String date, Integer eid) {

        List<EventCountVo> ls = new ArrayList<EventCountVo>();
        Map<String, Date> map = WxEmcpEntUtil.getDateTimeByType(datatype, date);
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("eid", eid);
        param.put("tobeg", map.get("tobeg"));
        param.put("toend", map.get("toend"));
        param.put("type", SmsTypeEnum.REMINDERFEE.getValue());
        int queryCuifeiCount = recordService.queryCuifeiCount(param);
        EventCountVo v1 = new EventCountVo();
        v1.setCount(queryCuifeiCount);
        v1.setName("催费次数");
        int queryRechargeCount = recordService.queryRechargeCount(param);
        EventCountVo v2 = new EventCountVo();
        v2.setCount(queryRechargeCount);
        v2.setName("充值次数");
        int queryLazhaCount = recordService.queryLazhaCount(param);
        EventCountVo v3 = new EventCountVo();
        v3.setCount(queryLazhaCount);
        v3.setName("拉闸次数");
        ls.add(v1);
        ls.add(v2);
        ls.add(v3);
        return ls;

    }

    private List<ElectricalConsumptionBlockVo> wrapElectricalConsumption(int datatype, String date, Integer eid) {
        List<ElectricalConsumptionBlockVo> ls = new ArrayList<ElectricalConsumptionBlockVo>();
        Map<String, Date> map = WxEmcpEntUtil.getDateTimeByType(datatype, date);
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("eid", eid);
        param.put("tobeg", map.get("tobeg"));
        param.put("labeg", map.get("labeg"));
        param.put("latobeg", map.get("latobeg"));
        param.put("latoend", map.get("latoend"));

        if (datatype == 1) {
            param.put("type", CircleTypeEnum.DAY.getValue());
        } else {
            param.put("type", CircleTypeEnum.MONTH.getValue());
        }

        double queryLastSum = recordService.queryLastSum(param);
        double queryLaLaSum = recordService.queryLaLaSum(param);
        double querySum = recordService.queryNowSumTwo(param);
        Date now = new Date();
        if ((DateUtil.DateToStr(now, DateUtil.TIME_SHORT).equals(date) && datatype == 1) || (DateUtil.DateToStr(now, DateUtil.MONTHTIME).equals(date) && datatype != 1)) {
            if (datatype == 1) {
                param.put("type", CircleTypeEnum.HOUR.getValue());
            } else {
                param.put("type", CircleTypeEnum.DAY.getValue());
            }
            querySum = recordService.queryNowSum(param);
        }

        ElectricalConsumptionBlockVo v1 = new ElectricalConsumptionBlockVo();
        v1.setConsumption(querySum);
        v1.setName(datatype == 1 ? "当日" : "当月");
        ElectricalConsumptionBlockVo v2 = new ElectricalConsumptionBlockVo();
        v2.setConsumption(queryLastSum);
        v2.setName(datatype == 1 ? "上日" : "上月");
        ElectricalConsumptionBlockVo v3 = new ElectricalConsumptionBlockVo();
        v3.setConsumption(queryLaLaSum);
        v3.setName(datatype == 1 ? "上周本日" : "去年本月");
        ls.add(v3);
        ls.add(v1);
        ls.add(v2);

        return ls;
    }

    private List<EnergyUserBlockVo> wrapEnergyUse(int datatype, String date, Integer eid) {
        Map<String, Date> map = WxEmcpEntUtil.getDateTimeByType(datatype, date);
        Map<String, Object> param = new HashMap<String, Object>();
        Date now = new Date();
        if (datatype == 1) {
            param.put("type", CircleTypeEnum.DAY.getValue());
        } else {
            param.put("type", CircleTypeEnum.MONTH.getValue());
        }
        if ((DateUtil.DateToStr(now, DateUtil.TIME_SHORT).equals(date) && datatype == 1) || (DateUtil.DateToStr(now, DateUtil.MONTHTIME).equals(date) && datatype != 1)) {
            param.put("isToday", 1);
            if (datatype == 1) {
                param.put("type", CircleTypeEnum.HOUR.getValue());
                param.put("tobeg", map.get("tobeg"));
                param.put("toend", map.get("toend"));
            } else {
                param.put("type", CircleTypeEnum.DAY.getValue());
                param.put("tobeg", map.get("tobeg"));
                param.put("toend", new Date());
            }
        } else {
            param.put("isToday", 2);
            param.put("tobeg", map.get("tobeg"));
        }
        param.put("eid", eid);
        // param.put("tobeg", map.get("tobeg"));
        // param.put("labeg", map.get("labeg"));
        // param.put("latobeg", map.get("latobeg"));
        // param.put("latoend", map.get("latoend"));
        // param.put("toend", map.get("toend"));

        List<EnergyUserBlockVo> queryEnergyUser = recordService.queryEnergyUser(param);
        return queryEnergyUser;
    }

    private List<DepartmentUseVo> wrapDepartmentUse(int datatype, String date, Integer eid) {
        Map<String, Date> map = WxEmcpEntUtil.getDateTimeByType(datatype, date);
        Map<String, Object> param = new HashMap<String, Object>();
        if (datatype == 1) {
            param.put("type", CircleTypeEnum.DAY.getValue());
        } else {
            param.put("type", CircleTypeEnum.MONTH.getValue());
        }
        param.put("eid", eid);
        param.put("tobeg", map.get("tobeg"));
        param.put("labeg", map.get("labeg"));
        param.put("latobeg", map.get("latobeg"));
        param.put("latoend", map.get("latoend"));
        List<DepartmentUseVo> queryDepartmentUse = new ArrayList<DepartmentUseVo>();
        Date now = new Date();
        if ((DateUtil.DateToStr(now, DateUtil.TIME_SHORT).equals(date) && datatype == 1) || (DateUtil.DateToStr(now, DateUtil.MONTHTIME).equals(date) && datatype != 1)) {
            if (datatype == 1) {
                param.put("type", CircleTypeEnum.HOUR.getValue());
            } else {
                param.put("type", CircleTypeEnum.DAY.getValue());
            }
            queryDepartmentUse = recordService.queryDepartmentUseNow(param);
        } else {
            queryDepartmentUse = recordService.queryDepartmentUse(param);
        }

        return queryDepartmentUse;
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

    // 事件统计详情
    public String queryEventDetails() {
        int dataType = getParamInt("datatype");
        String datetime = getParameter("datetime");
        WxemcpEntWebUser wxemcpEntWebUser = getUser();
        Integer eid = wxemcpEntWebUser.getEntId();
        if (StringUtil.isNullOrEmpty(datetime)) { // 如果没有时间参数，默认为当天
            if (dataType == 1) {
                datetime = DateUtil.DateToStr(new Date(), DateUtil.TIME_SHORT);
            } else {
                datetime = DateUtil.DateToStr(new Date(), DateUtil.MONTHTIME);
            }
        }
        Map<String, Date> map = WxEmcpEntUtil.getDateTimeByType(dataType, datetime);
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("eid", eid);
        param.put("tobeg", map.get("tobeg"));
        param.put("labeg", map.get("labeg"));
        param.put("latobeg", map.get("latobeg"));
        param.put("latoend", map.get("latoend"));
        param.put("toend", map.get("toend"));

        /*----------------拉闸次数模块---------------*/
        int remoteCount = recordService.queryLazhaCount(param);
        int remoteLaCount = recordService.queryLALazhaCount(param);
        int remoteLaLaCount = recordService.queryLALALazhaCount(param);
        List<LaZhaCountVo> ls = new ArrayList<LaZhaCountVo>();
        LaZhaCountVo v1 = new LaZhaCountVo();
        v1.setName(dataType == 1 ? "当日" : "当月");
        v1.setCount(remoteCount);
        LaZhaCountVo v2 = new LaZhaCountVo();
        v2.setName(dataType == 1 ? "上日" : "上月");
        v2.setCount(remoteLaCount);
        LaZhaCountVo v3 = new LaZhaCountVo();
        v3.setName(dataType == 1 ? "上周本日" : "去年本月");
        v3.setCount(remoteLaLaCount);
        ls.add(v3);
        ls.add(v1);
        ls.add(v2);

        LaZhaCountBlock laZhaCountBlock = new LaZhaCountBlock();
        laZhaCountBlock.setLs(ls);
        double temvalue = 0;
        if (remoteLaCount != 0) {
            temvalue = (remoteCount - remoteLaCount) / remoteLaCount;
            temvalue = temvalue > 0 ? temvalue : 0.0;
            temvalue = new BigDecimal(temvalue * 100).setScale(NumberUtil.DEF_SCALE, NumberUtil.PERCISION).doubleValue();
            laZhaCountBlock.setUpratethanla(temvalue);
        }
        if (remoteLaLaCount != 0) {
            temvalue = (remoteCount - remoteLaLaCount) / remoteLaLaCount;
            temvalue = temvalue > 0 ? temvalue : 0.0;
            temvalue = new BigDecimal(temvalue * 100).setScale(NumberUtil.DEF_SCALE, NumberUtil.PERCISION).doubleValue();
            laZhaCountBlock.setUpratethanlala(temvalue);
        }
        laZhaCountBlock.setNowcount(remoteCount);

        /*----------------拉闸次数模块---------------*/
        /*----------------充值次数模块---------------*/
        int rechargeCount = recordService.queryChongZhiCount(param);
        int rechargeLaCount = recordService.queryLaChongZhiCount(param);
        int rechargeLaLaCount = recordService.queryLaLaChongZhiCount(param);
        List<RechargeCountVo> ls2 = new ArrayList<RechargeCountVo>();
        RechargeCountVo vo1 = new RechargeCountVo();
        vo1.setName(dataType == 1 ? "当日" : "当月");
        vo1.setCount(rechargeCount);
        RechargeCountVo vo2 = new RechargeCountVo();
        vo2.setName(dataType == 1 ? "上日" : "上月");
        vo2.setCount(rechargeLaCount);
        RechargeCountVo vo3 = new RechargeCountVo();
        vo3.setName(dataType == 1 ? "上周本日" : "去年本月");
        vo3.setCount(rechargeLaLaCount);
        RechargeCountBlock rechargeCountBlock = new RechargeCountBlock();
        ls2.add(vo3);
        ls2.add(vo1);
        ls2.add(vo2);
        rechargeCountBlock.setLs(ls2);
        if (rechargeLaCount != 0) {
            temvalue = (rechargeCount - rechargeLaCount) / rechargeLaCount;
            temvalue = temvalue > 0 ? temvalue : 0.0;
            temvalue = new BigDecimal(temvalue * 100).setScale(NumberUtil.DEF_SCALE, NumberUtil.PERCISION).doubleValue();
            rechargeCountBlock.setUpratethanla(temvalue);
        }
        if (rechargeLaLaCount != 0) {
            temvalue = (rechargeCount - rechargeLaLaCount) / rechargeLaLaCount;
            temvalue = temvalue > 0 ? temvalue : 0.0;
            temvalue = new BigDecimal(temvalue * 100).setScale(NumberUtil.DEF_SCALE, NumberUtil.PERCISION).doubleValue();
            rechargeCountBlock.setUpratethanlala(temvalue);
        }
        rechargeCountBlock.setNowcount(rechargeCount);
        /*----------------充值次数模块---------------*/
        /*----------------催费次数模块---------------*/

        param.put("type", SmsTypeEnum.REMINDERFEE.getValue());
        int cuifeiCount = recordService.queryCuifeiCount(param);
        int cuifeiLaCount = recordService.queryLACuiFeiCount(param);
        int cuifeiLaLaCount = recordService.queryLALACuiFeiCount(param);

        CuiFeiCountVo cuiFeiCountVo1 = new CuiFeiCountVo();
        cuiFeiCountVo1.setCount(cuifeiCount);
        cuiFeiCountVo1.setName(dataType == 1 ? "当日" : "当月");

        CuiFeiCountVo cuiFeiCountVo2 = new CuiFeiCountVo();
        cuiFeiCountVo2.setCount(cuifeiLaCount);
        cuiFeiCountVo2.setName(dataType == 1 ? "上日" : "上月");

        CuiFeiCountVo cuiFeiCountVo3 = new CuiFeiCountVo();
        cuiFeiCountVo3.setCount(cuifeiLaLaCount);
        cuiFeiCountVo3.setName(dataType == 1 ? "上周本日" : "去年本月");
        List<CuiFeiCountVo> cuiFeiCountVos = new ArrayList<CuiFeiCountVo>();
        CuiFeiCountBlock cuiFeiCountBlock = new CuiFeiCountBlock();

        cuiFeiCountVos.add(cuiFeiCountVo3);
        cuiFeiCountVos.add(cuiFeiCountVo1);
        cuiFeiCountVos.add(cuiFeiCountVo2);

        cuiFeiCountBlock.setLs(cuiFeiCountVos);
        if (cuifeiLaCount != 0) {
            temvalue = (cuifeiCount - cuifeiLaCount) / cuifeiLaCount;
            temvalue = temvalue > 0 ? temvalue : 0.0;
            temvalue = new BigDecimal(temvalue * 100).setScale(NumberUtil.DEF_SCALE, NumberUtil.PERCISION).doubleValue();
            cuiFeiCountBlock.setUpratethanla(temvalue);
        }
        if (cuifeiLaLaCount != 0) {
            temvalue = (cuifeiCount - cuifeiLaLaCount) / cuifeiLaLaCount;
            temvalue = temvalue > 0 ? temvalue : 0.0;
            temvalue = new BigDecimal(temvalue * 100).setScale(NumberUtil.DEF_SCALE, NumberUtil.PERCISION).doubleValue();
            cuiFeiCountBlock.setUpratethanlala(temvalue);
        }
        cuiFeiCountBlock.setNowcount(cuifeiCount);
        /*----------------催费次数模块---------------*/
        EventCountDetailsBlock eventCountDetailsBlock = new EventCountDetailsBlock();
        eventCountDetailsBlock.setCuiFeiCountBlock(cuiFeiCountBlock);
        eventCountDetailsBlock.setLaZhaCountBlock(laZhaCountBlock);
        eventCountDetailsBlock.setRechargeCountBlock(rechargeCountBlock);
        wxemcpEntResultBean.setData(eventCountDetailsBlock);
        return SUCCESS;
    }

    public String queryDepartmentUserDetails() {
        int dataType = getParamInt("datatype");
        String datetime = getParameter("datetime");
        WxemcpEntWebUser wxemcpEntWebUser = getUser();
        Integer eid = wxemcpEntWebUser.getEntId();
        Date now = new Date();
        if (StringUtil.isNullOrEmpty(datetime)) { // 如果没有时间参数，默认为当天
            if (dataType == 1) {
                datetime = DateUtil.DateToStr(now, DateUtil.TIME_SHORT);
            } else {
                datetime = DateUtil.DateToStr(now, DateUtil.MONTHTIME);
            }
        }

        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Date> map = WxEmcpEntUtil.getDateTimeByType(dataType, datetime);
        param.put("eid", eid);
        param.put("tobeg", map.get("tobeg"));
        param.put("labeg", map.get("labeg"));
        param.put("latobeg", map.get("latobeg"));
        param.put("latoend", map.get("latoend"));
        if (dataType == 1) {
            param.put("type", CircleTypeEnum.DAY.getValue());
        } else {
            param.put("type", CircleTypeEnum.MONTH.getValue());
        }

        List<DepartmentUseDetailsVo> ls = recordService.queryAllDepartmentUseDetailsOne(param);

        if ((DateUtil.DateToStr(now, DateUtil.TIME_SHORT).equals(datetime) && dataType == 1) || (DateUtil.DateToStr(now, DateUtil.MONTHTIME).equals(datetime) && dataType != 1)) {
            Date tempDate = null;
            Date startTime = null;
            Date endTime = null;
            if (dataType == 1) {// 处理天
                tempDate = DateUtil.StrToDate(datetime, DateUtil.TIME_SHORT);
                startTime = WxEmcpEntUtil.returnFirstDatetime(tempDate, 0);
                endTime = WxEmcpEntUtil.returnLastDatetime(tempDate, 0);
                param.put("circleType", CircleTypeEnum.HOUR.getValue());
            } else {// 处理月
                tempDate = DateUtil.StrToDate(datetime, DateUtil.MONTHTIME);
                startTime = WxEmcpEntUtil.returnFirstDatetime(DateUtil.getFirstDayOfMonth(tempDate), 0);
                endTime = WxEmcpEntUtil.returnLastDatetime(DateUtil.getLastDayOfMonth(tempDate), 0);
                param.put("circleType", CircleTypeEnum.DAY.getValue());
            }
            param.put("startTime", startTime);
            param.put("endTime", endTime);
            List<DepartmentUseDetailsVo> list = recordService.selectCurStaEnergyByDateTime(param);
            for (DepartmentUseDetailsVo vo : list) {
                vo.setDatatime(tempDate);
                ls.add(vo);
            }

        }

        Map<Integer, DepartmentUseDetailsBlock> mp = new HashMap<Integer, DepartmentUseDetailsBlock>();
        for (DepartmentUseDetailsVo dv : ls) {
            DepartmentUseDetailsBlock db = mp.get(dv.getObjid());
            if (db == null) {
                db = new DepartmentUseDetailsBlock();
                db.getLs().add(dv);
                mp.put(dv.getObjid(), db);
            } else {
                DepartmentUseDetailsBlock detailsBlock = mp.get(dv.getObjid());
                detailsBlock.getLs().add(dv);
            }
            if (StringUtil.isNullOrEmpty(db.getName())) {
                db.setName(dv.getName());
            }
            if (dv.getDatatime().compareTo(map.get("tobeg")) == 0) {
                dv.setDatename(dataType == 1 ? "当日" : "当月");
                db.setNowsum(dv.getEnergy());
            } else if (dv.getDatatime().compareTo(map.get("labeg")) == 0) {
                dv.setDatename(dataType == 1 ? "上日" : "上月");
                db.setLasum(dv.getEnergy());
            } else if (dv.getDatatime().compareTo(map.get("latobeg")) == 0) {
                dv.setDatename(dataType == 1 ? "上周本日" : "去年本月");
                db.setLalasum(dv.getEnergy());
            }
        }
        for (Map.Entry<Integer, DepartmentUseDetailsBlock> en : mp.entrySet()) {
            List<DepartmentUseDetailsVo> list = en.getValue().getLs();
            if (list.size() > 0 && list.size() < 3) {
                DepartmentUseDetailsVo tempVo = list.get(0);
                DepartmentUseDetailsVo newVo = null;
                if (dataType == 1) {
                    if (!containDate(list, "上日")) {
                        newVo = new DepartmentUseDetailsVo();
                        newVo.setDatename("上日");
                        newVo.setName(tempVo.getName());
                        newVo.setObjid(tempVo.getObjid());
                        list.add(newVo);
                    }
                    if (!containDate(list, "上周本日")) {
                        newVo = new DepartmentUseDetailsVo();
                        newVo.setDatename("上周本日");
                        newVo.setName(tempVo.getName());
                        newVo.setObjid(tempVo.getObjid());
                        list.add(newVo);
                    }
                    if (!containDate(list, "当日")) {
                        newVo = new DepartmentUseDetailsVo();
                        newVo.setDatename("当日");
                        newVo.setName(tempVo.getName());
                        newVo.setObjid(tempVo.getObjid());
                        list.add(newVo);
                    }

                } else {
                    if (!containDate(list, "上月")) {
                        newVo = new DepartmentUseDetailsVo();
                        newVo.setDatename("上月");
                        newVo.setName(tempVo.getName());
                        newVo.setObjid(tempVo.getObjid());
                        list.add(newVo);
                    }
                    if (!containDate(list, "去年本月")) {
                        newVo = new DepartmentUseDetailsVo();
                        newVo.setDatename("去年本月");
                        newVo.setName(tempVo.getName());
                        newVo.setObjid(tempVo.getObjid());
                        list.add(newVo);
                    }
                    if (!containDate(list, "当月")) {
                        newVo = new DepartmentUseDetailsVo();
                        newVo.setDatename("当月");
                        newVo.setName(tempVo.getName());
                        newVo.setObjid(tempVo.getObjid());
                        list.add(newVo);
                    }

                }
            }
            Collections.sort(list);
        }

        List<DepartmentUseDetailsBlock> list = new ArrayList<DepartmentUseDetailsBlock>(mp.values());
        Collections.sort(list);
        wxemcpEntResultBean.setData(list);

        return SUCCESS;

    }

    private boolean containDate(List<DepartmentUseDetailsVo> list, String dateName) {
        for (DepartmentUseDetailsVo vo : list) {
            if (vo.getDatename().equals(dateName)) {
                return true;
            }
        }
        return false;
    }

    private boolean containDate2(List<EnergyUseDetailsVo> list, String dateName) {
        for (EnergyUseDetailsVo vo : list) {
            if (vo.getDatename().equals(dateName)) {
                return true;
            }
        }
        return false;
    }

    public String queryEnergyUseDetails() {
        int dataType = getParamInt("datatype");
        String datetime = getParameter("datetime");
        WxemcpEntWebUser wxemcpEntWebUser = getUser();
        Integer eid = wxemcpEntWebUser.getEntId();
        Date now = new Date();
        if (StringUtil.isNullOrEmpty(datetime)) { // 如果没有时间参数，默认为当天
            if (dataType == 1) {
                datetime = DateUtil.DateToStr(now, DateUtil.TIME_SHORT);
            } else {
                datetime = DateUtil.DateToStr(now, DateUtil.MONTHTIME);
            }
        }
        Map<String, Object> param = new HashMap<String, Object>();
        Map<String, Date> map = WxEmcpEntUtil.getDateTimeByType(dataType, datetime);
        param.put("eid", eid);
        param.put("tobeg", map.get("tobeg"));
        param.put("labeg", map.get("labeg"));
        param.put("latobeg", map.get("latobeg"));
        param.put("latoend", map.get("latoend"));
        if (dataType == 1) {
            param.put("type", CircleTypeEnum.DAY.getValue());
        } else {
            param.put("type", CircleTypeEnum.MONTH.getValue());
        }

        List<EnergyUseDetailsVo> ls = new ArrayList<EnergyUseDetailsVo>();

        if (!DateUtil.DateToStr(now, DateUtil.TIME_SHORT).equals(datetime) && !DateUtil.DateToStr(now, DateUtil.MONTHTIME).equals(datetime)) {
            ls = recordService.queryEnergyUseDetailsOne(param);
        } else if (!DateUtil.DateToStr(now, DateUtil.TIME_SHORT).equals(datetime)) {
            param.put("type", CircleTypeEnum.DAY.getValue());
            List<EnergyUseDetailsVo> list = recordService.queryEnergyUseDetailsToday(param);
            for (EnergyUseDetailsVo Vo : list) {
                Vo.setDatatime(map.get("tobeg"));
                ls.add(Vo);
            }
            param.remove("tobeg");
            List<EnergyUseDetailsVo> one = recordService.queryEnergyUseDetailsOne(param);
            param.put("tobeg", map.get("tobeg"));
            for (EnergyUseDetailsVo Vo : one) {
                ls.add(Vo);
            }

        } else {
            param.put("type", CircleTypeEnum.HOUR.getValue());
            List<EnergyUseDetailsVo> list = recordService.queryEnergyUseDetailsToday(param);
            for (EnergyUseDetailsVo Vo : list) {
                Vo.setDatatime(map.get("tobeg"));
                ls.add(Vo);
            }
            param.remove("tobeg");
            List<EnergyUseDetailsVo> one = recordService.queryEnergyUseDetailsOne(param);
            param.put("tobeg", map.get("tobeg"));
            for (EnergyUseDetailsVo Vo : one) {
                ls.add(Vo);
            }
        }
        for (int x = 0; x < ls.size(); x++) {

            if (ls.get(x).getDatatime().compareTo(map.get("tobeg")) == 0) {
                ls.get(x).setDatename(dataType == 1 ? "当日" : "当月");
            }
            if (ls.get(x).getDatatime().compareTo(map.get("labeg")) == 0) {
                ls.get(x).setDatename(dataType == 1 ? "上日" : "上月");
            }
            if (ls.get(x).getDatatime().compareTo(map.get("latobeg")) == 0) {
                ls.get(x).setDatename(dataType == 1 ? "上周本日" : "去年本月");
            }
        }
        Map<Integer, EnergyUseDetailsBlock> mp = new HashMap<Integer, EnergyUseDetailsBlock>();
        for (EnergyUseDetailsVo vo : ls) {
            EnergyUseDetailsBlock eb = null;
            if (mp.get(vo.getId()) == null) {
                eb = new EnergyUseDetailsBlock();
                List<EnergyUseDetailsVo> le = new ArrayList<EnergyUseDetailsVo>();
                le.add(vo);
                eb.setLs(le);
                mp.put(vo.getId(), eb);
            } else {
                eb = mp.get(vo.getId());
                List<EnergyUseDetailsVo> ls2 = eb.getLs();
                ls2.add(vo);
            }
            if (StringUtil.isNullOrEmpty(eb.getName())) {
                eb.setName(vo.getName());
            }
        }
        for (Map.Entry<Integer, EnergyUseDetailsBlock> e : mp.entrySet()) {
            EnergyUseDetailsBlock value = e.getValue();
            List<EnergyUseDetailsVo> list = value.getLs();
            for (EnergyUseDetailsVo dv : list) {
                if (dv.getDatatime().compareTo(map.get("tobeg")) == 0) {
                    value.setNowsum(dv.getEnergy());
                }
                if (dv.getDatatime().compareTo(map.get("labeg")) == 0) {
                    value.setLasum(dv.getEnergy());
                }
                if (dv.getDatatime().compareTo(map.get("latobeg")) == 0) {
                    value.setLalasum(dv.getEnergy());
                }
            }

        }

        for (Map.Entry<Integer, EnergyUseDetailsBlock> en : mp.entrySet()) {
            List<EnergyUseDetailsVo> list = en.getValue().getLs();
            if (list.size() > 0 && list.size() < 3) {
                EnergyUseDetailsVo tempVo = list.get(0);
                EnergyUseDetailsVo newVo = null;
                if (dataType == 1) {
                    if (!containDate2(list, "上日")) {
                        newVo = new EnergyUseDetailsVo();
                        newVo.setDatename("上日");
                        newVo.setName(tempVo.getName());
                        newVo.setId(tempVo.getId());
                        list.add(newVo);
                    }

                    if (!containDate2(list, "上周本日")) {
                        newVo = new EnergyUseDetailsVo();
                        newVo.setDatename("上周本日");
                        newVo.setName(tempVo.getName());
                        newVo.setId(tempVo.getId());
                        list.add(newVo);
                    }

                    if (!containDate2(list, "当日")) {
                        newVo = new EnergyUseDetailsVo();
                        newVo.setDatename("当日");
                        newVo.setName(tempVo.getName());
                        newVo.setId(tempVo.getId());
                        list.add(newVo);
                    }

                } else {
                    if (!containDate2(list, "上月")) {
                        newVo = new EnergyUseDetailsVo();
                        newVo.setDatename("上月");
                        newVo.setName(tempVo.getName());
                        newVo.setId(tempVo.getId());
                        list.add(newVo);
                    }

                    if (!containDate2(list, "去年本月")) {
                        newVo = new EnergyUseDetailsVo();
                        newVo.setDatename("去年本月");
                        newVo.setName(tempVo.getName());
                        newVo.setId(tempVo.getId());
                        list.add(newVo);
                    }

                    if (!containDate2(list, "当月")) {
                        newVo = new EnergyUseDetailsVo();
                        newVo.setDatename("当月");
                        newVo.setName(tempVo.getName());
                        newVo.setId(tempVo.getId());
                        list.add(newVo);
                    }

                }
            }
            Collections.sort(list);
        }

        List<EnergyUseDetailsBlock> energyUseDetailsBlocks = new ArrayList<EnergyUseDetailsBlock>(mp.values());
        wxemcpEntResultBean.setData(energyUseDetailsBlocks);
        return SUCCESS;

    }
}
