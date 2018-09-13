package com.holley.wxemcp.ent.dao.dic;

import com.holley.wxemcp.ent.model.dic.DicCity;
import com.holley.wxemcp.ent.model.dic.DicCityExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DicCityMapper {
    int countByExample(DicCityExample example);

    int deleteByExample(DicCityExample example);

    int deleteByPrimaryKey(Short cityid);

    int insert(DicCity record);

    int insertSelective(DicCity record);

    List<DicCity> selectByExample(DicCityExample example);

    DicCity selectByPrimaryKey(Short cityid);

    int updateByExampleSelective(@Param("record") DicCity record, @Param("example") DicCityExample example);

    int updateByExample(@Param("record") DicCity record, @Param("example") DicCityExample example);

    int updateByPrimaryKeySelective(DicCity record);

    int updateByPrimaryKey(DicCity record);
}