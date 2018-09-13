package com.holley.wxemcp.ent.service.emcp;

import java.util.List;
import java.util.Map;

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

public interface RecordService {

    /**
     * 分页查询短信记录
     * 
     * @param param
     * @return
     */
    List<MessageVo> selectMessagesByPage(Map<String, Object> param);

    List<RechargeVo> selectRecordByPage(Map<String, Object> param);

    List<PpfControlCmdVo> selectRemotesByPage(Map<String, Object> param);

    List<EvtRecordVo> selectEvtRecordByPage(Map<String, Object> param);

    int countLastEvtRecord(Map<String, Object> param);

    int countTodayEvtRecord(Map<String, Object> param);

    int countTodayEvtHis(Map<String, Object> param);

    int countLastEvtHis(Map<String, Object> param);

    List<DepartmentUseDetailsVo> queryAllDepartmentUseDetailsToday(Map<String, Object> param);

    double queryMoneyCount(Map<String, Object> param);

    double queryLaMoneyCount(Map<String, Object> param);

    double queryLaLaMoneyCount(Map<String, Object> param);

    int queryRechargeCount(Map<String, Object> param);

    int queryCuifeiCount(Map<String, Object> param);

    int queryLazhaCount(Map<String, Object> param);

    int queryLALazhaCount(Map<String, Object> param);

    int queryLALALazhaCount(Map<String, Object> param);

    int queryChongZhiCount(Map<String, Object> param);

    int queryLaChongZhiCount(Map<String, Object> param);

    int queryLaLaChongZhiCount(Map<String, Object> param);

    double queryNowSum(Map<String, Object> param);

    double queryLastSum(Map<String, Object> param);

    double queryLaLaSum(Map<String, Object> param);

    List<EnergyUserBlockVo> queryEnergyUser(Map<String, Object> param);

    double queryEnergyUserSum(Map<String, Object> param);

    int CreateCiJi(Map<String, Object> param);

    List<DepartmentUseVo> queryDepartmentUse(Map<String, Object> param);

    int queryLACuiFeiCount(Map<String, Object> param);

    int queryLALACuiFeiCount(Map<String, Object> param);

    int queryOwingMoneyCstomer(Map<String, Object> param);

    double queryAllOwingMoney(Map<String, Object> param);

    double queryAllRemainingMoney(Map<String, Object> param);

    List<DepartmentUseDetailsVo> queryAllDepartmentUseDetailsOne(Map<String, Object> param);

    List<EnergyUseDetailsVo> queryEnergyUseDetailsOne(Map<String, Object> param);

    int queryNewMessageCount(Map<String, Object> param);

    int queryNewRechargeCount(Map<String, Object> param);

    int queryNewRemoteCount(Map<String, Object> param);

    List<DepartmentUseDetailsVo> selectCurStaEnergyByDateTime(Map<String, Object> param);

    List<EnergyUseDetailsVo> queryEnergyUseDetailsToday(Map<String, Object> param);

    double queryNowSumTwo(Map<String, Object> param);

    List<DepartmentUseVo> queryDepartmentUseNow(Map<String, Object> param);

    EvtRecord selectEvtRecordByPrimaryKey(EvtRecordKey key);

    DatEvtHis selectDatEvtHisByPrimaryKey(DatEvtHisKey key);

    ObjPoint selectObjPointByPrimaryKey(Integer pointid);

    ObjRtu selectObjRtuByPrimaryKey(Integer rtuid);

    List<EvtWxSendVo> selectPointWxSendEvent(Map<String, Object> map);

    List<EvtWxSendVo> selectRtuWxSendEvent(Map<String, Object> map);

    List<PpfEnterpriseWechat> selectPpfEnterpriseWechatByExample(PpfEnterpriseWechatExample example);

    List<RtuStatusInfoVo> selectRtuStatusInfosByPage(Map<String, Object> param);
}
