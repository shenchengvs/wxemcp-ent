package com.holley.wxemcp.ent.dao.ppf;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.holley.wxemcp.ent.model.ppf.PpfPriceRuleOther;
import com.holley.wxemcp.ent.model.ppf.PpfPriceRuleOtherExample;

public interface PpfPriceRuleOtherMapper {
    int countByExample(PpfPriceRuleOtherExample example);

    int deleteByExample(PpfPriceRuleOtherExample example);

    int deleteByPrimaryKey(Integer priceid);

    int insert(PpfPriceRuleOther record);

    int insertSelective(PpfPriceRuleOther record);

    List<PpfPriceRuleOther> selectByExample(PpfPriceRuleOtherExample example);

    PpfPriceRuleOther selectByPrimaryKey(Integer priceid);

    int updateByExampleSelective(@Param("record") PpfPriceRuleOther record, @Param("example") PpfPriceRuleOtherExample example);

    int updateByExample(@Param("record") PpfPriceRuleOther record, @Param("example") PpfPriceRuleOtherExample example);

    int updateByPrimaryKeySelective(PpfPriceRuleOther record);

    int updateByPrimaryKey(PpfPriceRuleOther record);
    
    List<PpfPriceRuleOther> selectByIdList(List<Integer> idList);
}