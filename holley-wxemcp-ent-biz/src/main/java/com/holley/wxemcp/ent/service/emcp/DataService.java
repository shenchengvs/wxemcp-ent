package com.holley.wxemcp.ent.service.emcp;

import java.util.List;
import java.util.Map;

import com.holley.wxemcp.ent.model.def.DataCount;
import com.holley.wxemcp.ent.model.def.DataElecDetail;
import com.holley.wxemcp.ent.model.def.DataWaterDetail;
import com.holley.wxemcp.ent.model.def.DetailElecVo;
import com.holley.wxemcp.ent.model.def.DetailWaterVo;
import com.holley.wxemcp.ent.model.def.FeeVo;
import com.holley.wxemcp.ent.model.def.QueryVo;
import com.holley.wxemcp.ent.model.def.RealVo;
import com.holley.wxemcp.ent.model.def.SubEuuFirst;
import com.holley.wxemcp.ent.model.obj.ObjSubeuu;
import com.holley.wxemcp.ent.model.obj.ObjSubeuuExample;
import com.holley.wxemcp.ent.model.ppf.PpfCustomerFeeMonth;
import com.holley.wxemcp.ent.model.ppf.PpfCustomerFeeMonthOther;
import com.holley.wxemcp.ent.model.ppf.PpfEnterpriseWechat;
import com.holley.wxemcp.ent.model.ppf.PpfPriceRule;
import com.holley.wxemcp.ent.model.ppf.PpfPriceRuleOther;

public interface DataService {

    // obj_sub_euu
    List<ObjSubeuu> selectSubeuuByExample(ObjSubeuuExample example);

    List<SubEuuFirst> selectFirstSubeuuByExample(ObjSubeuuExample example);

    // ppf_price_rule
    PpfPriceRule selectPriceRuleByPrimaryKey(Integer priceid);

    List<PpfPriceRule> selectPriceRuleByIdList(List<Integer> idList);

    // ppf_price_rule_other
    PpfPriceRuleOther selectPriceRuleOtherByPrimaryKey(Integer priceid);

    List<PpfPriceRuleOther> selectPriceRuleOtherByIdList(List<Integer> idList);

    // ppf_customer_fee_month
    PpfCustomerFeeMonth selectFeeMonthByPrimaryKey(Map<String, Object> param);

    // ppf_customer_fee_month_other
    PpfCustomerFeeMonthOther selectFeeMonthOtherByPrimaryKey(Map<String, Object> param);

    // real
    List<RealVo> selectRealElecByPage(Map<String, Object> param);

    List<RealVo> selectRealWaterByPage(Map<String, Object> param);

    // query
    List<QueryVo> selectHistoryElecByPage(Map<String, Object> param, Integer extendEid);

    List<QueryVo> selectHistoryWaterByPage(Map<String, Object> param);

    // fee
    List<FeeVo> selectCurMonthElecFeeByPage(Map<String, Object> param);

    List<FeeVo> selectPastMonthElecFeeByPage(Map<String, Object> param);

    List<FeeVo> selectCurMonthWaterFeeByPage(Map<String, Object> param);

    List<FeeVo> selectPastMonthWaterFeeByPage(Map<String, Object> param);

    // detail
    DataElecDetail selectBaseMonthPastDetailElecByParam(Map<String, Object> param);

    DataElecDetail selectBaseMonthCurDetailElecByParam(Map<String, Object> param);

    List<DetailElecVo> selectDetailElecMonthBillByCustomerId(Map<String, Object> param);

    DataWaterDetail selectBaseMonthPastDetailWaterByParam(Map<String, Object> param);

    DataWaterDetail selectBaseMonthCurDetailWaterByParam(Map<String, Object> param);

    List<DetailWaterVo> selectDetailWaterMonthBillByCustomerId(Map<String, Object> param);

    // count
    int countUnRealPointElecByEid(Integer eid);

    int countUnRealPointWaterByEid(Integer eid);

    DataCount selectOtherCountByEid(Map<String, Object> param);

    PpfEnterpriseWechat selectPpfEnterpriseWechatByPrimaryKey(String openId);

    int insertPpfEnterpriseWechat(PpfEnterpriseWechat record);

    int updateEnterpriseWechatByPrimaryKeySelective(PpfEnterpriseWechat record);
}
