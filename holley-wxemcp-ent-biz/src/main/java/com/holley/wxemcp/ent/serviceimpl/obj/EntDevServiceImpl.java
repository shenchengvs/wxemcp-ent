package com.holley.wxemcp.ent.serviceimpl.obj;

import java.util.Date;
import java.util.List;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;

import com.holley.platform.common.constants.Globals;
import com.holley.platform.common.constants.LogOperatorEnum;
import com.holley.platform.common.util.JsonUtil;
import com.holley.platform.model.def.EntBaseInfo;
import com.holley.platform.model.def.LogInfo;
import com.holley.platform.util.HostLogUtils;
import com.holley.wxemcp.ent.dao.obj.ObjEnterpriseMapper;
import com.holley.wxemcp.ent.model.def.Enterprise;
import com.holley.wxemcp.ent.model.obj.ObjEnterprise;
import com.holley.wxemcp.ent.model.obj.ObjEnterpriseExample;
import com.holley.wxemcp.ent.service.obj.EntDevService;

public class EntDevServiceImpl implements EntDevService {

    @Autowired
    ObjEnterpriseMapper objEnterpriseMapper;

    // common-------------------------------------

    // obj_enterprise-----------------------------------------
    @Override
    public ObjEnterprise selectEnterpriseByPK(Integer eid) {
        return objEnterpriseMapper.selectByPrimaryKey(eid);
    }

    @Override
    public List<ObjEnterprise> selectEnterpriseByExample(ObjEnterpriseExample example) {
        return objEnterpriseMapper.selectByExample(example);
    }

    @Override
    public List<EntBaseInfo> selectGetChildEidSelf(Integer eid) {
        return objEnterpriseMapper.selectChildEntSelf(eid);
    }

    @Override
    public List<EntBaseInfo> selectGetChildEid(Integer eid) {
        return objEnterpriseMapper.selectChildEnt(eid);
    }

    @Override
    public List<Enterprise> selectChildEidSelf(Integer eid) {
        return objEnterpriseMapper.selectChildEntInfoByEid(eid);
    }

    @Override
    public int insertEnterprise(ObjEnterprise record, LogInfo logInfo) {
        int result = -1;
        if (objEnterpriseMapper.insertSelective(record) > 0) {
            result = record.getEid();
            String content = JSONObject.fromObject(record, JsonUtil.returnJosnConfig(false, Date.class)).toString();
            content = "表名:OBJ_ENTERPRISE;" + content;
            HostLogUtils.recordDocumentlog(logInfo.getAccount(), LogOperatorEnum.ADD, logInfo.getIp(), logInfo.getModuleid(), content);
        }
        return result;
    }

    @Override
    public String deleteEnterprise(Integer eid) {
        String msg = Globals.DEFAULT_MESSAGE;
        // 查询是否还有子企业
        ObjEnterpriseExample example = new ObjEnterpriseExample();
        ObjEnterpriseExample.Criteria cr = example.createCriteria();
        cr.andOwneridEqualTo(eid);
        List<ObjEnterprise> enList = objEnterpriseMapper.selectByExample(example);
        if (enList != null && enList.size() > 0) {
            return msg = "请先删除子企业";
        }
        objEnterpriseMapper.deleteByPrimaryKey(eid);
        return msg;
    }

    @Override
    public int updateByPrimaryKeySelective(ObjEnterprise record, LogInfo logInfo) {
        int count = objEnterpriseMapper.updateByPrimaryKeySelective(record);
        String content = "";
        if (count > 0 && logInfo != null) {
            content = JSONObject.fromObject(record, JsonUtil.returnJosnConfig(false, Date.class)).toString();
            content = "表名:OBJ_ENTERPRISE;" + content;
            HostLogUtils.recordDocumentlog(logInfo.getAccount(), LogOperatorEnum.MODIFY, logInfo.getIp(), logInfo.getModuleid(), content);

        }

        return count;
    }

    @Override
    public Enterprise selectSingleEntById(Integer eid) {
        return objEnterpriseMapper.selectSingleEntById(eid);
    }

    @Override
    public List<Enterprise> selectEntInfoByEid(Integer eid) {
        return objEnterpriseMapper.selectEntInfoByEid(eid);
    }

}
