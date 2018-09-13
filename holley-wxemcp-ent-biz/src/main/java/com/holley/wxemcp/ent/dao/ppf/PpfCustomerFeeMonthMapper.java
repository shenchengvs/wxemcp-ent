package com.holley.wxemcp.ent.dao.ppf;

import com.holley.wxemcp.ent.model.ppf.PpfCustomerFeeMonth;
import com.holley.wxemcp.ent.model.ppf.PpfCustomerFeeMonthExample;
import com.holley.wxemcp.ent.model.ppf.PpfCustomerFeeMonthKey;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PpfCustomerFeeMonthMapper {
    int countByExample(PpfCustomerFeeMonthExample example);

    int deleteByExample(PpfCustomerFeeMonthExample example);

    int deleteByPrimaryKey(PpfCustomerFeeMonthKey key);

    int insert(PpfCustomerFeeMonth record);

    int insertSelective(PpfCustomerFeeMonth record);

    List<PpfCustomerFeeMonth> selectByExample(PpfCustomerFeeMonthExample example);

    PpfCustomerFeeMonth selectByPrimaryKey(Map<String, Object> param);

    int updateByExampleSelective(@Param("record") PpfCustomerFeeMonth record, @Param("example") PpfCustomerFeeMonthExample example);

    int updateByExample(@Param("record") PpfCustomerFeeMonth record, @Param("example") PpfCustomerFeeMonthExample example);

    int updateByPrimaryKeySelective(PpfCustomerFeeMonth record);

    int updateByPrimaryKey(PpfCustomerFeeMonth record);
}