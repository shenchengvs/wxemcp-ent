package com.holley.wxemcp.ent.dao.obj;

import com.holley.wxemcp.ent.model.obj.ObjPoint;
import com.holley.wxemcp.ent.model.obj.ObjPointExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ObjPointMapper {
    int countByExample(ObjPointExample example);

    int deleteByExample(ObjPointExample example);

    int deleteByPrimaryKey(Integer pointid);

    int insert(ObjPoint record);

    int insertSelective(ObjPoint record);

    List<ObjPoint> selectByExample(ObjPointExample example);

    ObjPoint selectByPrimaryKey(Integer pointid);

    int updateByExampleSelective(@Param("record") ObjPoint record, @Param("example") ObjPointExample example);

    int updateByExample(@Param("record") ObjPoint record, @Param("example") ObjPointExample example);

    int updateByPrimaryKeySelective(ObjPoint record);

    int updateByPrimaryKey(ObjPoint record);
}