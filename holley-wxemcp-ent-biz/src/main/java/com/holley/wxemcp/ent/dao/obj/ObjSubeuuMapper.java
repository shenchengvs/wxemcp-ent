package com.holley.wxemcp.ent.dao.obj;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.holley.wxemcp.ent.model.def.SubEuuFirst;
import com.holley.wxemcp.ent.model.obj.ObjSubeuu;
import com.holley.wxemcp.ent.model.obj.ObjSubeuuExample;

public interface ObjSubeuuMapper {

    int countByExample(ObjSubeuuExample example);

    int deleteByExample(ObjSubeuuExample example);

    int deleteByPrimaryKey(Integer subeuuid);

    int insert(ObjSubeuu record);

    int insertSelective(ObjSubeuu record);

    List<ObjSubeuu> selectByExample(ObjSubeuuExample example);

    ObjSubeuu selectByPrimaryKey(Integer subeuuid);

    int updateByExampleSelective(@Param("record") ObjSubeuu record, @Param("example") ObjSubeuuExample example);

    int updateByExample(@Param("record") ObjSubeuu record, @Param("example") ObjSubeuuExample example);

    int updateByPrimaryKeySelective(ObjSubeuu record);

    int updateByPrimaryKey(ObjSubeuu record);
    
    List<SubEuuFirst> selectFirstSubeuuByExample(ObjSubeuuExample example);
}
