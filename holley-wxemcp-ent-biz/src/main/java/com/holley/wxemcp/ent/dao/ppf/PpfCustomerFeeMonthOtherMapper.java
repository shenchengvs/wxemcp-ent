package com.holley.wxemcp.ent.dao.ppf;

import com.holley.wxemcp.ent.model.ppf.PpfCustomerFeeMonthOther;
import com.holley.wxemcp.ent.model.ppf.PpfCustomerFeeMonthOtherExample;
import com.holley.wxemcp.ent.model.ppf.PpfCustomerFeeMonthOtherKey;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PpfCustomerFeeMonthOtherMapper {
    int countByExample(PpfCustomerFeeMonthOtherExample example);

    int deleteByExample(PpfCustomerFeeMonthOtherExample example);

    int deleteByPrimaryKey(PpfCustomerFeeMonthOtherKey key);

    int insert(PpfCustomerFeeMonthOther record);

    int insertSelective(PpfCustomerFeeMonthOther record);

    List<PpfCustomerFeeMonthOther> selectByExample(PpfCustomerFeeMonthOtherExample example);

    PpfCustomerFeeMonthOther selectByPrimaryKey(Map<String, Object> param);

    int updateByExampleSelective(@Param("record") PpfCustomerFeeMonthOther record, @Param("example") PpfCustomerFeeMonthOtherExample example);

    int updateByExample(@Param("record") PpfCustomerFeeMonthOther record, @Param("example") PpfCustomerFeeMonthOtherExample example);

    int updateByPrimaryKeySelective(PpfCustomerFeeMonthOther record);

    int updateByPrimaryKey(PpfCustomerFeeMonthOther record);
}