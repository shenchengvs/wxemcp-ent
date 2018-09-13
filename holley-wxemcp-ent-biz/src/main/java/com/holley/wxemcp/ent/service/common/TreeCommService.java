package com.holley.wxemcp.ent.service.common;

import java.util.List;

import com.holley.platform.model.def.EntBaseInfo;

public interface TreeCommService {

    // 查询企业包括自己
    List<EntBaseInfo> selectChildEntSelf(Integer eid);

    // 查询企业不包括自己
    List<EntBaseInfo> selectChildEnt(Integer eid);

}
