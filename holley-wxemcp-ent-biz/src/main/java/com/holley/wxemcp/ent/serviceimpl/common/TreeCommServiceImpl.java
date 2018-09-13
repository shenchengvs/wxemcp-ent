package com.holley.wxemcp.ent.serviceimpl.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.holley.platform.model.def.EntBaseInfo;
import com.holley.wxemcp.ent.dao.obj.ObjEnterpriseMapper;
import com.holley.wxemcp.ent.service.common.TreeCommService;

public class TreeCommServiceImpl implements TreeCommService {

    @Autowired
    ObjEnterpriseMapper objEnterpriseMapper;

    @Override
    public List<EntBaseInfo> selectChildEntSelf(Integer eid) {
        return objEnterpriseMapper.selectChildEntSelf(eid);
    }

    @Override
    public List<EntBaseInfo> selectChildEnt(Integer eid) {
        return objEnterpriseMapper.selectChildEnt(eid);
    }

}
