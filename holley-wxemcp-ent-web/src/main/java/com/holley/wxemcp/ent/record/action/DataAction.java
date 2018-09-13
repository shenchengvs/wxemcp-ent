package com.holley.wxemcp.ent.record.action;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.holley.platform.common.dataobject.Page;
import com.holley.platform.common.util.DateUtil;
import com.holley.platform.common.util.StringUtil;
import com.holley.wxemcp.ent.action.BaseAction;
import com.holley.wxemcp.ent.common.constants.EnergyTypeEnum;
import com.holley.wxemcp.ent.common.constants.FeeCheckStatusEnum;
import com.holley.wxemcp.ent.common.constants.LoginStatusTypeEnum;
import com.holley.wxemcp.ent.common.constants.ObjectTypeEnum;
import com.holley.wxemcp.ent.common.constants.RetTypeEnum;
import com.holley.wxemcp.ent.common.constants.WxPushStatusTypeEnum;
import com.holley.wxemcp.ent.model.def.DataCount;
import com.holley.wxemcp.ent.model.def.DataElecDetail;
import com.holley.wxemcp.ent.model.def.DataFee;
import com.holley.wxemcp.ent.model.def.DataQuery;
import com.holley.wxemcp.ent.model.def.DataReal;
import com.holley.wxemcp.ent.model.def.DataWaterDetail;
import com.holley.wxemcp.ent.model.def.DetailElecVo;
import com.holley.wxemcp.ent.model.def.DetailWaterVo;
import com.holley.wxemcp.ent.model.def.FeeVo;
import com.holley.wxemcp.ent.model.def.QueryVo;
import com.holley.wxemcp.ent.model.def.RealVo;
import com.holley.wxemcp.ent.model.def.SubEuuFirst;
import com.holley.wxemcp.ent.model.def.WxemcpEntResultBean;
import com.holley.wxemcp.ent.model.def.WxemcpEntWebUser;
import com.holley.wxemcp.ent.model.obj.ObjSubeuu;
import com.holley.wxemcp.ent.model.obj.ObjSubeuuExample;
import com.holley.wxemcp.ent.model.obj.ObjSubeuuExample.Criteria;
import com.holley.wxemcp.ent.model.ppf.PpfCustomerFeeMonth;
import com.holley.wxemcp.ent.model.ppf.PpfCustomerFeeMonthOther;
import com.holley.wxemcp.ent.model.ppf.PpfEnterpriseWechat;
import com.holley.wxemcp.ent.model.ppf.PpfPriceRule;
import com.holley.wxemcp.ent.model.ppf.PpfPriceRuleOther;
import com.holley.wxemcp.ent.service.emcp.DataService;

/**
 * 数据相关
 * 
 * @author sc
 */
public class DataAction extends BaseAction {

    private static final long serialVersionUID = 1L;

    @Resource
    private DataService       dataService;

    public String initBlankPage() {
        return SUCCESS;
    }

    public String initRealPowerPage() {
        return SUCCESS;
    }

    public String initRealWaterPage() {
        return SUCCESS;
    }

    public String initPowerFeePage() {
        return SUCCESS;
    }

    public String initWaterFeePage() {
        return SUCCESS;
    }

    public String initPowePage() {
        return SUCCESS;
    }

    public String initWaterPage() {
        return SUCCESS;
    }

    public String initPowerFeeDetailPage() {
        return SUCCESS;
    }

    public String initWaterFeeDetailPage() {
        return SUCCESS;
    }

    /**
     * 此接口用于查询企业/费控用户实时电量情况
     * 
     * @return
     */
    public String queryRealPowers() {
        // parameter
        String keyWord = getParameter("keyWord");
        Integer unit = getParamInt("unit");
        Integer subUnit = getParamInt("subUnit");
        Integer pageindex = getParamInt("pageIndex");

        WxemcpEntWebUser user = getUser();
        // page
        Page page = returnPage(pageindex, limit);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);

        // query
        if (!StringUtil.isEmpty(keyWord)) {
            map.put("keyword", keyWord);
        }
        if (unit == 0) {// 不筛选
            // 企业自有计量点
            map.put("ownerid", user.getEntId());
            map.put("ownertype", ObjectTypeEnum.OBJ_ENTERPRISE.getShortValue());
        } else if (subUnit == 0) {// 筛选第一级
            // 第一级子单位自有计量点
            map.put("ownerid", unit);
            map.put("ownertype", ObjectTypeEnum.OBJ_SUBEU.getShortValue());
        } else {
            // 第二级子单位自有计量点
            map.put("ownerid", subUnit);
            map.put("ownertype", ObjectTypeEnum.OBJ_SUBEU.getShortValue());
        }
        List<RealVo> realVo = dataService.selectRealElecByPage(map);
        DataReal real = new DataReal(page.getTotalProperty(), pageindex, limit);
        real.setDatas(realVo);
        wxemcpEntResultBean.setData(real);
        return SUCCESS;
    }

    /**
     * 此接口用于查询企业/费控用户实时水量情况
     * 
     * @return
     */
    public String queryRealWaters() {
        // parameter
        String keyWord = getParameter("keyWord");
        Integer unit = getParamInt("unit");
        Integer subUnit = getParamInt("subUnit");
        Integer pageindex = getParamInt("pageIndex");

        WxemcpEntWebUser user = getUser();
        // page
        Page page = returnPage(pageindex, limit);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);

        // query
        if (!StringUtil.isEmpty(keyWord)) {
            map.put("keyword", keyWord);
        }
        if (unit == 0) {// 不筛选
            // 企业自有计量点
            map.put("ownerid", user.getEntId());
            map.put("ownertype", ObjectTypeEnum.OBJ_ENTERPRISE.getShortValue());
        } else if (subUnit == 0) {// 筛选第一级
            // 第一级子单位自有计量点
            map.put("ownerid", unit);
            map.put("ownertype", ObjectTypeEnum.OBJ_SUBEU.getShortValue());
        } else {
            // 第二级子单位自有计量点
            map.put("ownerid", subUnit);
            map.put("ownertype", ObjectTypeEnum.OBJ_SUBEU.getShortValue());
        }
        List<RealVo> realVo = dataService.selectRealWaterByPage(map);
        DataReal real = new DataReal(page.getTotalProperty(), pageindex, limit);
        real.setDatas(realVo);
        wxemcpEntResultBean.setData(real);
        return SUCCESS;
    }

    /**
     * 此接口用于查询企业用户电量情况
     * 
     * @return
     */
    public String queryPowers() {
        // parameter
        String keyWord = getParameter("keyWord");
        Integer unit = getParamInt("unit");
        Integer subUnit = getParamInt("subUnit");
        String dateTime = getParameter("dateTime");
        Integer dateType = getParamInt("dateType");
        Integer pageindex = getParamInt("pageIndex");

        WxemcpEntWebUser user = getUser();
        // page
        Page page = returnPage(pageindex, limit);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);

        // query
        if (!StringUtil.isEmpty(keyWord)) {
            map.put("keyword", keyWord);
        }
        // 筛选unit&subUnit
        if (unit == 0) {// 不筛选
            // 企业自有计量点
            map.put("ownerid", user.getEntId());
            map.put("ownertype", ObjectTypeEnum.OBJ_ENTERPRISE.getShortValue());
        } else if (subUnit == 0) {// 筛选第一级
            // 第一级子单位自有计量点
            map.put("ownerid", unit);
            map.put("ownertype", ObjectTypeEnum.OBJ_SUBEU.getShortValue());
        } else {
            // 第二级子单位自有计量点
            map.put("ownerid", subUnit);
            map.put("ownertype", ObjectTypeEnum.OBJ_SUBEU.getShortValue());
        }
        // 月/日
        Date date;
        Calendar calendar = Calendar.getInstance();
        if (dateType == 1) {
            // 月
            date = DateUtil.StrToDate(dateTime, DateUtil.MONTHTIME);
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 1);
        } else if (dateType == 2) {
            // 日
            date = DateUtil.StrToDate(dateTime, DateUtil.TIME_SHORT);
            calendar.setTime(date);
            calendar.add(Calendar.DATE, 1);
        } else {
            wxemcpEntResultBean.setRet(RetTypeEnum.PARAM_ERROR.getShortValue());
            wxemcpEntResultBean.setMsg("dateType参数错误");
            return SUCCESS;
        }
        map.put("starttime", date);
        map.put("endtime", calendar.getTime());
        List<QueryVo> queryVo = dataService.selectHistoryElecByPage(map, user.getEntId());
        DataQuery query = new DataQuery(page.getTotalProperty(), pageindex, limit);
        query.setDatas(queryVo);
        wxemcpEntResultBean.setData(query);
        return SUCCESS;
    }

    /**
     * 此接口用于查询企业用户水量情况
     * 
     * @return
     */
    public String queryWaters() {
        // parameter
        String keyWord = getParameter("keyWord");
        Integer unit = getParamInt("unit");
        Integer subUnit = getParamInt("subUnit");
        String dateTime = getParameter("dateTime");
        Integer dateType = getParamInt("dateType");
        Integer pageindex = getParamInt("pageIndex");

        WxemcpEntWebUser user = getUser();
        // page
        Page page = returnPage(pageindex, limit);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);

        // query
        if (!StringUtil.isEmpty(keyWord)) {
            map.put("keyword", keyWord);
        }
        // 筛选unit&subUnit
        if (unit == 0) {// 不筛选
            // 企业自有计量点
            map.put("ownerid", user.getEntId());
            map.put("ownertype", ObjectTypeEnum.OBJ_ENTERPRISE.getShortValue());
        } else if (subUnit == 0) {// 筛选第一级
            // 第一级子单位自有计量点
            map.put("ownerid", unit);
            map.put("ownertype", ObjectTypeEnum.OBJ_SUBEU.getShortValue());
        } else {
            // 第二级子单位自有计量点
            map.put("ownerid", subUnit);
            map.put("ownertype", ObjectTypeEnum.OBJ_SUBEU.getShortValue());
        }
        // 月/日
        Date date;
        Calendar calendar = Calendar.getInstance();
        if (dateType == 1) {
            // 月
            date = DateUtil.StrToDate(dateTime, DateUtil.MONTHTIME);
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 1);
        } else if (dateType == 2) {
            // 日
            date = DateUtil.StrToDate(dateTime, DateUtil.TIME_SHORT);
            calendar.setTime(date);
            calendar.add(Calendar.DATE, 1);
        } else {
            wxemcpEntResultBean.setRet(RetTypeEnum.PARAM_ERROR.getShortValue());
            wxemcpEntResultBean.setMsg("dateType参数错误");
            return SUCCESS;
        }
        map.put("starttime", date);
        map.put("endtime", calendar.getTime());
        List<QueryVo> queryVo = dataService.selectHistoryWaterByPage(map);
        DataQuery query = new DataQuery(page.getTotalProperty(), pageindex, limit);
        query.setDatas(queryVo);
        wxemcpEntResultBean.setData(query);
        return SUCCESS;
    }

    /**
     * 此接口用于查询费控用户电费情况，欠费情况，可用余额及可用天数等
     * 
     * @return
     */
    public String queryPowerFees() {
        // parameter
        String keyWord = getParameter("keyWord");
        String month = getParameter("month");
        Integer orderType = getParamInt("orderType");
        Integer pageindex = getParamInt("pageIndex");

        WxemcpEntWebUser user = getUser();
        // page
        Page page = returnPage(pageindex, limit);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);

        // query
        List<FeeVo> feeVo = new ArrayList<FeeVo>();
        if (!StringUtil.isEmpty(keyWord)) {
            map.put("keyword", keyWord);
        }
        map.put("orderType", orderType);
        map.put("eid", user.getEntId());
        map.put("month", DateUtil.StrToDate(month, DateUtil.MONTHTIME));
        // 判断月份
        Calendar calendar = Calendar.getInstance();
        if (Integer.parseInt(month.substring(5)) == (calendar.get(Calendar.MONTH) + 1)) {
            // 当月
            feeVo = dataService.selectCurMonthElecFeeByPage(map);
        } else {
            // 往月 - 没有余额和可用天数
            feeVo = dataService.selectPastMonthElecFeeByPage(map);
        }
        // 清点欠费户数
        int loan = 0;
        for (FeeVo vo : feeVo) {
            if (vo.getUsableMoney() == null) {
                continue;
            }
            if (vo.getUsableMoney().compareTo(BigDecimal.ZERO) == -1) {
                loan++;
            }
        }
        DataFee fee = new DataFee(page.getTotalProperty(), pageindex, limit);
        fee.setArrearageUserCount(loan);
        fee.setDatas(feeVo);
        wxemcpEntResultBean.setData(fee);
        return SUCCESS;
    }

    /**
     * 此接口用于查询费控用户水费情况，欠费情况，可用余额及可用天数等
     * 
     * @return
     */
    public String queryWaterFees() {
        // parameter
        String keyWord = getParameter("keyWord");
        String month = getParameter("month");
        Integer orderType = getParamInt("orderType");
        Integer pageindex = getParamInt("pageIndex");

        WxemcpEntWebUser user = getUser();
        // page
        Page page = returnPage(pageindex, limit);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("page", page);

        // query
        List<FeeVo> feeVo = new ArrayList<FeeVo>();
        if (!StringUtil.isEmpty(keyWord)) {
            map.put("keyword", keyWord);
        }
        map.put("orderType", orderType);
        map.put("eid", user.getEntId());
        map.put("month", DateUtil.StrToDate(month, DateUtil.MONTHTIME));
        // 判断月份
        Calendar calendar = Calendar.getInstance();
        if (Integer.parseInt(month.substring(5)) == (calendar.get(Calendar.MONTH) + 1)) {
            // 当月
            feeVo = dataService.selectCurMonthWaterFeeByPage(map);
        } else {
            // 往月
            feeVo = dataService.selectPastMonthWaterFeeByPage(map);
        }
        // 清点欠费户数
        int loan = 0;
        for (FeeVo vo : feeVo) {
            if (vo.getUsableMoney() == null) {
                continue;
            }
            if (vo.getUsableMoney().compareTo(BigDecimal.ZERO) == -1) {
                loan++;
            }
        }
        DataFee fee = new DataFee(page.getTotalProperty(), pageindex, limit);
        fee.setArrearageUserCount(loan);
        fee.setDatas(feeVo);
        wxemcpEntResultBean.setData(fee);
        return SUCCESS;
    }

    /**
     * 此接口用于展现费控用户电费详细情况
     * 
     * @return
     */
    public String queryPowerFeeDetail() {
        // parameter
        String month = getParameter("month");
        Integer customerid = getParamInt("customerid");
        // map
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("month", DateUtil.StrToDate(month, DateUtil.MONTHTIME));
        map.put("customerid", customerid);
        // query
        // 基本信息
        List<DetailElecVo> detailVo = dataService.selectDetailElecMonthBillByCustomerId(map);
        // 查询pricerule
        List<Integer> priceidList = new ArrayList<Integer>();
        for (DetailElecVo vo : detailVo) {
            priceidList.add(vo.getPriceid());
        }
        if (!priceidList.isEmpty()) {
            List<PpfPriceRule> priceList = dataService.selectPriceRuleByIdList(priceidList);
            // 对应pricerule
            for (PpfPriceRule price : priceList) {
                for (DetailElecVo vo : detailVo) {
                    if (vo.getPriceid() == price.getPriceid()) {
                        vo.setPricerule(price);
                    }
                }
            }
        }
        DataElecDetail detail;
        // 判断月份
        Calendar calendar = Calendar.getInstance();
        if (Integer.parseInt(month.substring(5)) == (calendar.get(Calendar.MONTH) + 1)) {
            // 当月
            detail = dataService.selectBaseMonthCurDetailElecByParam(map);
        } else {
            // 往月
            PpfCustomerFeeMonth feeMonth = dataService.selectFeeMonthByPrimaryKey(map);
            if (feeMonth == null || feeMonth.getStatus() == FeeCheckStatusEnum.UNCHECKED.getShortValue()) {
                // 未进行人工核算
                wxemcpEntResultBean.setRet(RetTypeEnum.SYS_ERROR.getShortValue());
                wxemcpEntResultBean.setMsg("该账单未进行人工核算，请待工作人员核算后查看");
                return SUCCESS;
            }
            detail = dataService.selectBaseMonthPastDetailElecByParam(map);
        }
        if (detail == null) {
            detail = new DataElecDetail();
        }
        detail.setBillTime(month);
        detail.setDatas(detailVo);
        wxemcpEntResultBean.setData(detail);
        return SUCCESS;
    }

    /**
     * 此接口用于展现费控用户水费详细情况
     * 
     * @return
     */
    public String queryWaterFeeDetail() {
        // parameter
        String month = getParameter("month");
        Integer customerid = getParamInt("customerid");
        // map
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("month", DateUtil.StrToDate(month, DateUtil.MONTHTIME));
        map.put("customerid", customerid);
        // query
        // 基本信息
        List<DetailWaterVo> detailVo = dataService.selectDetailWaterMonthBillByCustomerId(map);
        // 查询pricerule
        List<Integer> priceidList = new ArrayList<Integer>();
        for (DetailWaterVo vo : detailVo) {
            priceidList.add(vo.getPriceid());
        }
        if (!priceidList.isEmpty()) {
            List<PpfPriceRuleOther> priceList = dataService.selectPriceRuleOtherByIdList(priceidList);
            // 对应pricerule
            for (PpfPriceRuleOther price : priceList) {
                for (DetailWaterVo vo : detailVo) {
                    if (vo.getPriceid() == price.getPriceid()) {
                        vo.setPricerule(price);
                    }
                }
            }
        }
        DataWaterDetail detail;
        // 判断月份
        Calendar calendar = Calendar.getInstance();
        if (Integer.parseInt(month.substring(5)) == (calendar.get(Calendar.MONTH) + 1)) {
            // 当月
            detail = dataService.selectBaseMonthCurDetailWaterByParam(map);
        } else {
            // 往月
            map.put("energytype", EnergyTypeEnum.WATER.getShortValue());
            PpfCustomerFeeMonthOther feeMonthOther = dataService.selectFeeMonthOtherByPrimaryKey(map);
            if (feeMonthOther == null || feeMonthOther.getStatus() == FeeCheckStatusEnum.UNCHECKED.getShortValue()) {
                // 未进行人工核算
                wxemcpEntResultBean.setRet(RetTypeEnum.SYS_ERROR.getShortValue());
                wxemcpEntResultBean.setMsg("该账单未进行人工核算，请待工作人员核算后查看");
                return SUCCESS;
            }
            detail = dataService.selectBaseMonthPastDetailWaterByParam(map);
        }
        if (detail == null) {
            detail = new DataWaterDetail();
        }
        detail.setBillTime(month);
        detail.setDatas(detailVo);
        wxemcpEntResultBean.setData(detail);
        return SUCCESS;
    }

    /**
     * 返回终端、计量点个数
     * 
     * @return
     */
    public String rtuPointCount() {
        Integer type = getParamInt("type");

        WxemcpEntWebUser user = getUser();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("eid", user.getEntId());
        map.put("type", type);

        // 获取其他计数
        DataCount count = dataService.selectOtherCountByEid(map);
        // 获取未实时上报计量点数
        if (type == EnergyTypeEnum.POWER.getValue()) {
            count.setUnRealCount(dataService.countUnRealPointElecByEid(user.getEntId()));
        } else if (type == EnergyTypeEnum.WATER.getValue()) {
            count.setUnRealCount(dataService.countUnRealPointWaterByEid(user.getEntId()));
        }
        wxemcpEntResultBean.setData(count);
        return SUCCESS;
    }

    /**
     * 获取次级用能单位的级联关系
     * 
     * @return
     */
    public String subEuuMap() {
        WxemcpEntWebUser user = getUser();
        ObjSubeuuExample example = new ObjSubeuuExample();
        Criteria criteria = example.createCriteria();
        criteria.andOwneridEqualTo(user.getEntId());
        criteria.andOwnertypeEqualTo(ObjectTypeEnum.OBJ_ENTERPRISE.getShortValue());
        // 选出第一级
        List<SubEuuFirst> parent = dataService.selectFirstSubeuuByExample(example);
        List<Integer> firstIdList = new ArrayList<Integer>();
        // 获得一级单位的id列表
        for (SubEuuFirst subEuuFirst : parent) {
            firstIdList.add(subEuuFirst.getSubeuuid());
        }
        if (!firstIdList.isEmpty()) {
            example = new ObjSubeuuExample();
            criteria = example.createCriteria();
            criteria.andOwneridIn(firstIdList);
            criteria.andOwnertypeEqualTo(ObjectTypeEnum.OBJ_SUBEU.getShortValue());
            List<ObjSubeuu> child = dataService.selectSubeuuByExample(example);
            for (ObjSubeuu second : child) {
                for (SubEuuFirst first : parent) {
                    if (second.getOwnerid().equals(first.getSubeuuid())) {
                        List<ObjSubeuu> list = first.getChildList();
                        if (list == null) {
                            list = new ArrayList<ObjSubeuu>();
                        }
                        list.add(second);
                        first.setChildList(list);
                        break;
                    }
                }
            }
        }

        wxemcpEntResultBean.setData(parent);
        return SUCCESS;
    }

    /**
     * 存储openId
     * 
     * @return
     */
    public String saveOpenId() {
        WxemcpEntWebUser user = getUser();
        String openId = getParameter("openId");
        if (StringUtil.isEmpty(openId)) {
            wxemcpEntResultBean.setRet(RetTypeEnum.PARAM_ERROR.getValue());
            return SUCCESS;
        }
        PpfEnterpriseWechat wechat = dataService.selectPpfEnterpriseWechatByPrimaryKey(openId);
        if (wechat == null) {
            PpfEnterpriseWechat newWechat = new PpfEnterpriseWechat();
            newWechat.setAccount(user.getAccount());
            newWechat.setEnterpriseId(user.getEntId());
            newWechat.setOpenId(openId);
            newWechat.setUpdateTime(new Date());
            newWechat.setLoginStatus(LoginStatusTypeEnum.LOGIN.getShortValue());
            newWechat.setPushStatus(WxPushStatusTypeEnum.PUSH.getShortValue());
            dataService.insertPpfEnterpriseWechat(newWechat);
        } else {
            PpfEnterpriseWechat newWechat = new PpfEnterpriseWechat();
            newWechat.setAccount(user.getAccount());
            newWechat.setEnterpriseId(user.getEntId());
            newWechat.setOpenId(openId);
            newWechat.setUpdateTime(new Date());
            newWechat.setLoginStatus(LoginStatusTypeEnum.LOGIN.getShortValue());
            dataService.updateEnterpriseWechatByPrimaryKeySelective(newWechat);
        }
        return SUCCESS;
    }

    public WxemcpEntResultBean getWxemcpEntResultBean() {
        return wxemcpEntResultBean;
    }
}
