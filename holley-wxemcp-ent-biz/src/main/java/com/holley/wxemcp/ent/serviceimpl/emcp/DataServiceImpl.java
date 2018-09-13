package com.holley.wxemcp.ent.serviceimpl.emcp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.holley.wxemcp.ent.common.data.DataMapper;
import com.holley.wxemcp.ent.dao.obj.ObjSubeuuMapper;
import com.holley.wxemcp.ent.dao.ppf.PpfCustomerFeeMonthMapper;
import com.holley.wxemcp.ent.dao.ppf.PpfCustomerFeeMonthOtherMapper;
import com.holley.wxemcp.ent.dao.ppf.PpfEnterpriseWechatMapper;
import com.holley.wxemcp.ent.dao.ppf.PpfPriceRuleMapper;
import com.holley.wxemcp.ent.dao.ppf.PpfPriceRuleOtherMapper;
import com.holley.wxemcp.ent.model.def.DataCount;
import com.holley.wxemcp.ent.model.def.DataElecDetail;
import com.holley.wxemcp.ent.model.def.DataWaterDetail;
import com.holley.wxemcp.ent.model.def.DetailElecVo;
import com.holley.wxemcp.ent.model.def.DetailWaterVo;
import com.holley.wxemcp.ent.model.def.ExtendPowerBmEid;
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
import com.holley.wxemcp.ent.service.emcp.DataService;

public class DataServiceImpl implements DataService {

    @Resource
    private ObjSubeuuMapper                objSubeuuMapper;
    @Resource
    private PpfPriceRuleMapper             ppfPriceRuleMapper;
    @Resource
    private PpfPriceRuleOtherMapper        ppfPriceRuleMapperOther;
    @Resource
    private PpfCustomerFeeMonthMapper      ppfCustomerFeeMonthMapper;
    @Resource
    private PpfCustomerFeeMonthOtherMapper ppfCustomerFeeMonthOtherMapper;
    @Resource
    private DataMapper                     dataMapper;
    @Resource
    private PpfEnterpriseWechatMapper      ppfEnterpriseWechatMapper;

    @Override
    public List<ObjSubeuu> selectSubeuuByExample(ObjSubeuuExample example) {
        return objSubeuuMapper.selectByExample(example);
    }

    @Override
    public List<SubEuuFirst> selectFirstSubeuuByExample(ObjSubeuuExample example) {
        return objSubeuuMapper.selectFirstSubeuuByExample(example);
    }

    @Override
    public PpfPriceRule selectPriceRuleByPrimaryKey(Integer priceid) {
        return ppfPriceRuleMapper.selectByPrimaryKey(priceid);
    }

    @Override
    public List<PpfPriceRule> selectPriceRuleByIdList(List<Integer> idList) {
        return ppfPriceRuleMapper.selectByIdList(idList);
    }

    @Override
    public PpfPriceRuleOther selectPriceRuleOtherByPrimaryKey(Integer priceid) {
        return ppfPriceRuleMapperOther.selectByPrimaryKey(priceid);
    }

    @Override
    public List<PpfPriceRuleOther> selectPriceRuleOtherByIdList(List<Integer> idList) {
        return ppfPriceRuleMapperOther.selectByIdList(idList);
    }

    @Override
    public PpfCustomerFeeMonth selectFeeMonthByPrimaryKey(Map<String, Object> param) {
        return ppfCustomerFeeMonthMapper.selectByPrimaryKey(param);
    }

    @Override
    public PpfCustomerFeeMonthOther selectFeeMonthOtherByPrimaryKey(Map<String, Object> param) {
        return ppfCustomerFeeMonthOtherMapper.selectByPrimaryKey(param);
    }

    @Override
    public List<RealVo> selectRealElecByPage(Map<String, Object> param) {
        return dataMapper.selectRealElecByPage(param);
    }

    @Override
    public List<RealVo> selectRealWaterByPage(Map<String, Object> param) {
        return dataMapper.selectRealWaterByPage(param);
    }

    @Override
    public List<QueryVo> selectHistoryElecByPage(Map<String, Object> param, Integer extendEid) {
        wrapExtendEid(param, extendEid);
        return dataMapper.selectHistoryElecByPage(param);
    }

    @Override
    public List<QueryVo> selectHistoryWaterByPage(Map<String, Object> param) {
        return dataMapper.selectHistoryWaterByPage(param);
    }

    @Override
    public List<FeeVo> selectCurMonthElecFeeByPage(Map<String, Object> param) {
        return dataMapper.selectCurMonthElecFeeByPage(param);
    }

    @Override
    public List<FeeVo> selectPastMonthElecFeeByPage(Map<String, Object> param) {
        return dataMapper.selectPastMonthElecFeeByPage(param);
    }

    @Override
    public List<FeeVo> selectCurMonthWaterFeeByPage(Map<String, Object> param) {
        return dataMapper.selectCurMonthWaterFeeByPage(param);
    }

    @Override
    public List<FeeVo> selectPastMonthWaterFeeByPage(Map<String, Object> param) {
        return dataMapper.selectPastMonthWaterFeeByPage(param);
    }

    @Override
    public DataElecDetail selectBaseMonthPastDetailElecByParam(Map<String, Object> param) {
        return dataMapper.selectBaseMonthPastDetailElecByParam(param);
    }

    @Override
    public DataElecDetail selectBaseMonthCurDetailElecByParam(Map<String, Object> param) {
        return dataMapper.selectBaseMonthCurDetailElecByParam(param);
    }

    @Override
    public List<DetailElecVo> selectDetailElecMonthBillByCustomerId(Map<String, Object> param) {
        return dataMapper.selectDetailElecMonthBillByCustomerId(param);
    }

    @Override
    public DataWaterDetail selectBaseMonthPastDetailWaterByParam(Map<String, Object> param) {
        return dataMapper.selectBaseMonthPastDetailWaterByParam(param);
    }

    @Override
    public DataWaterDetail selectBaseMonthCurDetailWaterByParam(Map<String, Object> param) {
        return dataMapper.selectBaseMonthCurDetailWaterByParam(param);
    }

    @Override
    public List<DetailWaterVo> selectDetailWaterMonthBillByCustomerId(Map<String, Object> param) {
        return dataMapper.selectDetailWaterMonthBillByCustomerId(param);
    }

    @Override
    public int countUnRealPointElecByEid(Integer eid) {
        return dataMapper.countUnRealPointElecByEid(eid);
    }

    @Override
    public int countUnRealPointWaterByEid(Integer eid) {
        return dataMapper.countUnRealPointWaterByEid(eid);
    }

    @Override
    public DataCount selectOtherCountByEid(Map<String, Object> param) {
        return dataMapper.selectOtherCountByEid(param);
    }

    @Override
    public PpfEnterpriseWechat selectPpfEnterpriseWechatByPrimaryKey(String openId) {
        return ppfEnterpriseWechatMapper.selectByPrimaryKey(openId);
    }

    @Override
    public int insertPpfEnterpriseWechat(PpfEnterpriseWechat record) {
        return ppfEnterpriseWechatMapper.insert(record);
    }

    @Override
    public int updateEnterpriseWechatByPrimaryKeySelective(PpfEnterpriseWechat record) {
        return ppfEnterpriseWechatMapper.updateByPrimaryKeySelective(record);
    }

    private void wrapExtendEid(Map<String, Object> map, Integer extendEid) {
        if (ExtendPowerBmEid.IS_USED) {
            map.put(ExtendPowerBmEid.EXTEND_EID, extendEid);
        }
    }

}
