package com.holley.wxemcp.ent.dao.obj;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.platform.model.def.EntBaseInfo;
import com.holley.wxemcp.ent.model.def.EntInfo;
import com.holley.wxemcp.ent.model.def.Enterprise;
import com.holley.wxemcp.ent.model.obj.ObjEnterprise;
import com.holley.wxemcp.ent.model.obj.ObjEnterpriseExample;

public interface ObjEnterpriseMapper {

    int countByExample(ObjEnterpriseExample example);

    int deleteByExample(ObjEnterpriseExample example);

    int deleteByPrimaryKey(Integer eid);

    int insert(ObjEnterprise record);

    int insertSelective(ObjEnterprise record);

    List<ObjEnterprise> selectByExample(ObjEnterpriseExample example);

    ObjEnterprise selectByPrimaryKey(Integer eid);

    int updateByExampleSelective(@Param("record") ObjEnterprise record, @Param("example") ObjEnterpriseExample example);

    int updateByExample(@Param("record") ObjEnterprise record, @Param("example") ObjEnterpriseExample example);

    int updateByPrimaryKeySelective(ObjEnterprise record);

    int updateByPrimaryKey(ObjEnterprise record);

    // // 根据eid，查询子企业，包括自己
    List<EntBaseInfo> selectChildEntSelf(Integer eid);

    // 根据eid，查询子企业，不包括自己
    List<EntBaseInfo> selectChildEnt(Integer eid);

    // 根据eid，查询子企业全部，不包括自己
    List<Enterprise> selectChildEntInfoByEid(Integer eid);

    List<EntInfo> searchEnterpriseByPage(Map<String, Object> params);

    List<EntBaseInfo> selectEidSelf(Integer ownerid);

    // ADD BY SC
    // 根据eid，分页查询子企业，包括自己
    List<EntBaseInfo> selectChildEntSelfByPage(Map<String, Object> map);

    Enterprise selectSingleEntById(Integer eid);

    List<Enterprise> selectEntInfoByEid(Integer eid);

}
