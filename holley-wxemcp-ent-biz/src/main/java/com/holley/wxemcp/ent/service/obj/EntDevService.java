package com.holley.wxemcp.ent.service.obj;

import java.util.List;

import com.holley.platform.model.def.EntBaseInfo;
import com.holley.platform.model.def.LogInfo;
import com.holley.wxemcp.ent.model.def.Enterprise;
import com.holley.wxemcp.ent.model.obj.ObjEnterprise;
import com.holley.wxemcp.ent.model.obj.ObjEnterpriseExample;

public interface EntDevService {

    // common--------------------------------

    // obj_enterprise--------------------------
    ObjEnterprise selectEnterpriseByPK(Integer eid);

    List<ObjEnterprise> selectEnterpriseByExample(ObjEnterpriseExample emp);

    int insertEnterprise(ObjEnterprise record, LogInfo logInfo);

    String deleteEnterprise(Integer eid);

    // 根据eid 查询子企业的所有信息 不包括自己
    List<Enterprise> selectChildEidSelf(Integer eid);

    // 根据eid，查询子企业，包括自己
    List<EntBaseInfo> selectGetChildEidSelf(Integer eid);

    // 根据eid，查询子企业，不包括自己
    List<EntBaseInfo> selectGetChildEid(Integer eid);

    int updateByPrimaryKeySelective(ObjEnterprise record, LogInfo logInfo);

    Enterprise selectSingleEntById(Integer eid);

    List<Enterprise> selectEntInfoByEid(Integer eid);

}
