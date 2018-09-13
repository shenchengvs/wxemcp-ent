package com.holley.wxemcp.ent.dao.obj;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.wxemcp.ent.model.def.RtuStatusInfoVo;
import com.holley.wxemcp.ent.model.obj.ObjRtu;
import com.holley.wxemcp.ent.model.obj.ObjRtuExample;

public interface ObjRtuMapper {

    int countByExample(ObjRtuExample example);

    int deleteByExample(ObjRtuExample example);

    int deleteByPrimaryKey(Integer rtuid);

    int insert(ObjRtu record);

    int insertSelective(ObjRtu record);

    List<ObjRtu> selectByExample(ObjRtuExample example);

    ObjRtu selectByPrimaryKey(Integer rtuid);

    int updateByExampleSelective(@Param("record") ObjRtu record, @Param("example") ObjRtuExample example);

    int updateByExample(@Param("record") ObjRtu record, @Param("example") ObjRtuExample example);

    int updateByPrimaryKeySelective(ObjRtu record);

    int updateByPrimaryKey(ObjRtu record);

    List<RtuStatusInfoVo> selectRtuStatusInfosByPage(Map<String, Object> param);
}
