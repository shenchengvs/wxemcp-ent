package com.holley.wxemcp.ent.dao.dic;

import com.holley.wxemcp.ent.model.dic.DicDetectorProtocol;
import com.holley.wxemcp.ent.model.dic.DicDetectorProtocolExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface DicDetectorProtocolMapper {
    int countByExample(DicDetectorProtocolExample example);

    int deleteByExample(DicDetectorProtocolExample example);

    int deleteByPrimaryKey(Short id);

    int insert(DicDetectorProtocol record);

    int insertSelective(DicDetectorProtocol record);

    List<DicDetectorProtocol> selectByExample(DicDetectorProtocolExample example);

    DicDetectorProtocol selectByPrimaryKey(Short id);

    int updateByExampleSelective(@Param("record") DicDetectorProtocol record, @Param("example") DicDetectorProtocolExample example);

    int updateByExample(@Param("record") DicDetectorProtocol record, @Param("example") DicDetectorProtocolExample example);

    int updateByPrimaryKeySelective(DicDetectorProtocol record);

    int updateByPrimaryKey(DicDetectorProtocol record);
}