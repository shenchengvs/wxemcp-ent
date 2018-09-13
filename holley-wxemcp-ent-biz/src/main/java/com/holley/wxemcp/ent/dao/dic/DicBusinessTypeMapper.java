package com.holley.wxemcp.ent.dao.dic;

import com.holley.wxemcp.ent.model.dic.DicBusinessType;
import com.holley.wxemcp.ent.model.dic.DicBusinessTypeExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DicBusinessTypeMapper {
    int countByExample(DicBusinessTypeExample example);

    int deleteByExample(DicBusinessTypeExample example);

    int deleteByPrimaryKey(Short businesstypeid);

    int insert(DicBusinessType record);

    int insertSelective(DicBusinessType record);

    List<DicBusinessType> selectByExample(DicBusinessTypeExample example);

    DicBusinessType selectByPrimaryKey(Short businesstypeid);

    int updateByExampleSelective(@Param("record") DicBusinessType record, @Param("example") DicBusinessTypeExample example);

    int updateByExample(@Param("record") DicBusinessType record, @Param("example") DicBusinessTypeExample example);

    int updateByPrimaryKeySelective(DicBusinessType record);

    int updateByPrimaryKey(DicBusinessType record);
}