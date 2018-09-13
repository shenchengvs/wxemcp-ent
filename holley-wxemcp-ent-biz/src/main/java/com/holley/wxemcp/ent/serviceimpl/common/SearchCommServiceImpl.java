package com.holley.wxemcp.ent.serviceimpl.common;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.holley.wxemcp.ent.dao.obj.ObjEnterpriseMapper;
import com.holley.wxemcp.ent.dao.obj.ObjSubeuuMapper;
import com.holley.wxemcp.ent.model.def.EntInfo;
import com.holley.wxemcp.ent.model.obj.ObjSubeuu;
import com.holley.wxemcp.ent.model.obj.ObjSubeuuExample;
import com.holley.wxemcp.ent.service.common.SearchCommService;

public class SearchCommServiceImpl implements SearchCommService {

    @Resource
    ObjEnterpriseMapper objEnterpriseMapper;
    @Resource
    ObjSubeuuMapper     objSubeuuMapper;

    @Override
    public List<EntInfo> searchEnterpriseByPage(Map<String, Object> param) {
        return objEnterpriseMapper.searchEnterpriseByPage(param);
    }

    @Override
    public List<ObjSubeuu> selectSubeuuByExample(ObjSubeuuExample example) {
        return objSubeuuMapper.selectByExample(example);
    }

}
