package com.holley.wxemcp.ent.serviceimpl.emcp;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.holley.wxemcp.ent.dao.dat.DatEvtHisMapper;
import com.holley.wxemcp.ent.dao.obj.ObjEnterpriseMapper;
import com.holley.wxemcp.ent.dao.obj.ObjPointMapper;
import com.holley.wxemcp.ent.dao.obj.ObjRtuMapper;
import com.holley.wxemcp.ent.dao.ppf.DatStaEnergyMapper;
import com.holley.wxemcp.ent.dao.ppf.DatStaItemUsedMapper;
import com.holley.wxemcp.ent.dao.ppf.EvtRecordMapper;
import com.holley.wxemcp.ent.dao.ppf.PpfControlCmdMapper;
import com.holley.wxemcp.ent.dao.ppf.PpfCustomerAccountMapper;
import com.holley.wxemcp.ent.dao.ppf.PpfEnterpriseWechatMapper;
import com.holley.wxemcp.ent.dao.ppf.PpfRechargeMapper;
import com.holley.wxemcp.ent.dao.ppf.PpfSmsSendMapper;
import com.holley.wxemcp.ent.model.dat.DatEvtHis;
import com.holley.wxemcp.ent.model.dat.DatEvtHisKey;
import com.holley.wxemcp.ent.model.def.DepartmentUseDetailsVo;
import com.holley.wxemcp.ent.model.def.DepartmentUseVo;
import com.holley.wxemcp.ent.model.def.EnergyUseDetailsVo;
import com.holley.wxemcp.ent.model.def.EnergyUserBlockVo;
import com.holley.wxemcp.ent.model.def.EvtRecordVo;
import com.holley.wxemcp.ent.model.def.EvtWxSendVo;
import com.holley.wxemcp.ent.model.def.MessageVo;
import com.holley.wxemcp.ent.model.def.PpfControlCmdVo;
import com.holley.wxemcp.ent.model.def.RechargeVo;
import com.holley.wxemcp.ent.model.def.RtuStatusInfoVo;
import com.holley.wxemcp.ent.model.obj.ObjPoint;
import com.holley.wxemcp.ent.model.obj.ObjRtu;
import com.holley.wxemcp.ent.model.ppf.EvtRecord;
import com.holley.wxemcp.ent.model.ppf.EvtRecordKey;
import com.holley.wxemcp.ent.model.ppf.PpfEnterpriseWechat;
import com.holley.wxemcp.ent.model.ppf.PpfEnterpriseWechatExample;
import com.holley.wxemcp.ent.service.emcp.RecordService;

public class RecordServiceImpl implements RecordService {

    @Resource
    private PpfRechargeMapper         ppfRechargeMapper;
    @Resource
    private ObjEnterpriseMapper       objEnterpriseMapper;
    @Resource
    private EvtRecordMapper           evtRecordMapper;
    @Resource
    private PpfControlCmdMapper       ppfControlCmdMapper;
    @Resource
    private PpfSmsSendMapper          ppfSmsSendMapper;
    @Resource
    private DatStaEnergyMapper        datStaEnergyMapper;
    @Resource
    private DatStaItemUsedMapper      datStaItemUsedMapper;
    @Resource
    private DatEvtHisMapper           datEvtHisMapper;
    @Resource
    private PpfCustomerAccountMapper  ppfCustomerAccountMapper;
    @Resource
    private ObjPointMapper            objPointMapper;
    @Resource
    private ObjRtuMapper              objRtuMapper;
    @Resource
    private PpfEnterpriseWechatMapper ppfEnterpriseWechatMapper;

    @Override
    public List<MessageVo> selectMessagesByPage(Map<String, Object> param) {
        return ppfSmsSendMapper.selectMessagesByPage(param);
    }

    @Override
    public List<RechargeVo> selectRecordByPage(Map<String, Object> param) {
        return ppfRechargeMapper.selectRecordByPage(param);
    }

    @Override
    public List<PpfControlCmdVo> selectRemotesByPage(Map<String, Object> param) {
        return ppfControlCmdMapper.selectRemotesByPage(param);
    }

    @Override
    public List<EvtRecordVo> selectEvtRecordByPage(Map<String, Object> param) {
        return evtRecordMapper.selectEvtRecordByPage(param);
    }

    @Override
    public int countLastEvtRecord(Map<String, Object> param) {

        return evtRecordMapper.countLastEvtRecord(param);
    }

    @Override
    public int countTodayEvtRecord(Map<String, Object> param) {

        return evtRecordMapper.countTodayEvtRecord(param);
    }

    @Override
    public double queryMoneyCount(Map<String, Object> param) {
        Double value = ppfRechargeMapper.queryMoneyCount(param);
        return value != null ? value : 0.0;
    }

    @Override
    public double queryLaMoneyCount(Map<String, Object> param) {
        Double value = ppfRechargeMapper.queryLaMoneyCount(param);
        return value != null ? value : 0.0;
    }

    @Override
    public double queryLaLaMoneyCount(Map<String, Object> param) {
        Double value = ppfRechargeMapper.queryLaLaMoneyCount(param);
        return value != null ? value : 0.0;
    }

    @Override
    public int queryRechargeCount(Map<String, Object> param) {
        return ppfRechargeMapper.queryRechargeCount(param);
    }

    @Override
    public int queryCuifeiCount(Map<String, Object> param) {
        return ppfSmsSendMapper.queryCuifeiCount(param);
    }

    @Override
    public int queryLazhaCount(Map<String, Object> param) {
        return ppfControlCmdMapper.queryLazhaCount(param);
    }

    @Override
    public double queryNowSum(Map<String, Object> param) {
        Double value = datStaEnergyMapper.queryNowSum(param);
        return value != null ? value : 0.0;
    }

    @Override
    public double queryLastSum(Map<String, Object> param) {
        Double value = datStaEnergyMapper.queryLastSum(param);
        return value != null ? value : 0.0;
    }

    @Override
    public double queryLaLaSum(Map<String, Object> param) {
        Double value = datStaEnergyMapper.queryLaLaSum(param);
        return value != null ? value : 0.0;
    }

    @Override
    public List<EnergyUserBlockVo> queryEnergyUser(Map<String, Object> param) {
        return datStaItemUsedMapper.queryEnergyUser(param);
    }

    @Override
    public double queryEnergyUserSum(Map<String, Object> param) {
        Double value = datStaItemUsedMapper.queryEnergyUserSum(param);
        return value != null ? value : 0.0;
    }

    @Override
    public int CreateCiJi(Map<String, Object> param) {
        return datStaEnergyMapper.CreateCiJi(param);
    }

    @Override
    public List<DepartmentUseVo> queryDepartmentUse(Map<String, Object> param) {
        return datStaEnergyMapper.queryDepartmentUse(param);
    }

    @Override
    public int queryLALazhaCount(Map<String, Object> param) {
        return ppfControlCmdMapper.queryLAlazhaCount(param);
    }

    @Override
    public int queryLALALazhaCount(Map<String, Object> param) {
        return ppfControlCmdMapper.queryLALAlazhaCount(param);
    }

    @Override
    public int queryChongZhiCount(Map<String, Object> param) {
        return ppfRechargeMapper.queryCount(param);
    }

    @Override
    public int queryLaChongZhiCount(Map<String, Object> param) {
        return ppfRechargeMapper.queryLaCount(param);
    }

    @Override
    public int queryLaLaChongZhiCount(Map<String, Object> param) {
        return ppfRechargeMapper.queryLaLaCount(param);
    }

    @Override
    public int queryLACuiFeiCount(Map<String, Object> param) {
        return ppfSmsSendMapper.queryLACuiFeiCount(param);
    }

    @Override
    public int queryLALACuiFeiCount(Map<String, Object> param) {
        return ppfSmsSendMapper.queryLALACuiFeiCount(param);
    }

    @Override
    public int queryOwingMoneyCstomer(Map<String, Object> param) {
        return ppfCustomerAccountMapper.queryOwingMoneyCstomer(param);
    }

    @Override
    public double queryAllOwingMoney(Map<String, Object> param) {
        Double value = ppfCustomerAccountMapper.queryAllOwingMoney(param);
        return value != null ? value : 0.0;
    }

    @Override
    public double queryAllRemainingMoney(Map<String, Object> param) {
        Double value = ppfCustomerAccountMapper.queryAllRemainingMoney(param);
        return value != null ? value : 0.0;
    }

    @Override
    public int queryNewMessageCount(Map<String, Object> param) {
        return ppfSmsSendMapper.queryNewMessageCount(param);
    }

    @Override
    public int queryNewRechargeCount(Map<String, Object> param) {
        return ppfRechargeMapper.queryNewRechargeCount(param);
    }

    @Override
    public int queryNewRemoteCount(Map<String, Object> param) {
        return ppfControlCmdMapper.queryNewRemoteCount(param);
    }

    @Override
    public List<DepartmentUseDetailsVo> queryAllDepartmentUseDetailsToday(Map<String, Object> param) {
        return datStaEnergyMapper.queryAllDepartmentUseDetailsToday(param);
    }

    @Override
    public List<DepartmentUseDetailsVo> queryAllDepartmentUseDetailsOne(Map<String, Object> param) {
        return datStaEnergyMapper.queryAllDepartmentUseDetailsOne(param);
    }

    @Override
    public List<EnergyUseDetailsVo> queryEnergyUseDetailsOne(Map<String, Object> param) {
        return datStaItemUsedMapper.queryEnergyUseDetailsOne(param);
    }

    @Override
    public List<DepartmentUseDetailsVo> selectCurStaEnergyByDateTime(Map<String, Object> param) {
        return datStaEnergyMapper.selectCurStaEnergyByDateTime(param);
    }

    @Override
    public List<EnergyUseDetailsVo> queryEnergyUseDetailsToday(Map<String, Object> param) {
        return datStaItemUsedMapper.queryEnergyUseDetailsToday(param);
    }

    @Override
    public double queryNowSumTwo(Map<String, Object> param) {
        Double value = datStaEnergyMapper.queryNowSumTwo(param);
        return value != null ? value : 0.0;
    }

    @Override
    public List<DepartmentUseVo> queryDepartmentUseNow(Map<String, Object> param) {
        return datStaEnergyMapper.queryDepartmentUseNow(param);
    }

    @Override
    public int countTodayEvtHis(Map<String, Object> param) {
        return evtRecordMapper.countTodayEvtHis(param);
    }

    @Override
    public int countLastEvtHis(Map<String, Object> param) {
        return evtRecordMapper.countLastEvtHis(param);
    }

    @Override
    public EvtRecord selectEvtRecordByPrimaryKey(EvtRecordKey key) {
        return evtRecordMapper.selectByPrimaryKey(key);
    }

    @Override
    public DatEvtHis selectDatEvtHisByPrimaryKey(DatEvtHisKey key) {
        return datEvtHisMapper.selectByPrimaryKey(key);
    }

    @Override
    public ObjPoint selectObjPointByPrimaryKey(Integer pointid) {
        return objPointMapper.selectByPrimaryKey(pointid);
    }

    @Override
    public ObjRtu selectObjRtuByPrimaryKey(Integer rtuid) {
        return objRtuMapper.selectByPrimaryKey(rtuid);
    }

    @Override
    public List<EvtWxSendVo> selectPointWxSendEvent(Map<String, Object> map) {
        return datEvtHisMapper.selectPointWxSendEvent(map);
    }

    @Override
    public List<EvtWxSendVo> selectRtuWxSendEvent(Map<String, Object> map) {
        return datEvtHisMapper.selectRtuWxSendEvent(map);
    }

    @Override
    public List<PpfEnterpriseWechat> selectPpfEnterpriseWechatByExample(PpfEnterpriseWechatExample example) {
        return ppfEnterpriseWechatMapper.selectByExample(example);
    }

    @Override
    public List<RtuStatusInfoVo> selectRtuStatusInfosByPage(Map<String, Object> param) {
        return objRtuMapper.selectRtuStatusInfosByPage(param);
    }

}
