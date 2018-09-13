package com.holley.wxemcp.ent.dao.ppf;

import com.holley.wxemcp.ent.model.ppf.PpfPriceRule;
import com.holley.wxemcp.ent.model.ppf.PpfPriceRuleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PpfPriceRuleMapper {
    int countByExample(PpfPriceRuleExample example);

    int deleteByExample(PpfPriceRuleExample example);

    int deleteByPrimaryKey(Integer priceid);

    int insert(PpfPriceRule record);

    int insertSelective(PpfPriceRule record);

    List<PpfPriceRule> selectByExample(PpfPriceRuleExample example);

    PpfPriceRule selectByPrimaryKey(Integer priceid);

    int updateByExampleSelective(@Param("record") PpfPriceRule record, @Param("example") PpfPriceRuleExample example);

    int updateByExample(@Param("record") PpfPriceRule record, @Param("example") PpfPriceRuleExample example);

    int updateByPrimaryKeySelective(PpfPriceRule record);

    int updateByPrimaryKey(PpfPriceRule record);
    
    List<PpfPriceRule> selectByIdList(List<Integer> idList);
}