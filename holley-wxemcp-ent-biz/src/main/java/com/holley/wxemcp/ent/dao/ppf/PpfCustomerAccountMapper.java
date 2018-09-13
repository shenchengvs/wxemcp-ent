package com.holley.wxemcp.ent.dao.ppf;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.wxemcp.ent.model.ppf.PpfCustomerAccount;
import com.holley.wxemcp.ent.model.ppf.PpfCustomerAccountExample;

public interface PpfCustomerAccountMapper {

    int countByExample(PpfCustomerAccountExample example);

    int deleteByExample(PpfCustomerAccountExample example);

    int deleteByPrimaryKey(Integer customerid);

    int insert(PpfCustomerAccount record);

    int insertSelective(PpfCustomerAccount record);

    List<PpfCustomerAccount> selectByExample(PpfCustomerAccountExample example);

    PpfCustomerAccount selectByPrimaryKey(Integer customerid);

    int updateByExampleSelective(@Param("record") PpfCustomerAccount record, @Param("example") PpfCustomerAccountExample example);

    int updateByExample(@Param("record") PpfCustomerAccount record, @Param("example") PpfCustomerAccountExample example);

    int updateByPrimaryKeySelective(PpfCustomerAccount record);

    int updateByPrimaryKey(PpfCustomerAccount record);

    int queryOwingMoneyCstomer(Map<String, Object> param);

    Double queryAllOwingMoney(Map<String, Object> param);

    Double queryAllRemainingMoney(Map<String, Object> param);
}
