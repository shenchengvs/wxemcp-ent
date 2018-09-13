package com.holley.wxemcp.ent.service.common;

import java.util.List;
import java.util.Map;

import com.holley.wxemcp.ent.model.def.EntInfo;
import com.holley.wxemcp.ent.model.obj.ObjSubeuu;
import com.holley.wxemcp.ent.model.obj.ObjSubeuuExample;

public interface SearchCommService {

    List<EntInfo> searchEnterpriseByPage(Map<String, Object> param);

    List<ObjSubeuu> selectSubeuuByExample(ObjSubeuuExample example);
}
