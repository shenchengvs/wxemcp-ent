package com.holley.wxemcp.ent.dao.ppf;

import com.holley.wxemcp.ent.model.def.RechargeVo;
import com.holley.wxemcp.ent.model.ppf.PpfRecharge;
import com.holley.wxemcp.ent.model.ppf.PpfRechargeExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface PpfRechargeMapper {
    int countByExample(PpfRechargeExample example);

    int deleteByExample(PpfRechargeExample example);

    int deleteByPrimaryKey(Integer rechargeid);

    int insert(PpfRecharge record);

    int insertSelective(PpfRecharge record);

    List<PpfRecharge> selectByExample(PpfRechargeExample example);

    PpfRecharge selectByPrimaryKey(Integer rechargeid);

    int updateByExampleSelective(@Param("record") PpfRecharge record, @Param("example") PpfRechargeExample example);

    int updateByExample(@Param("record") PpfRecharge record, @Param("example") PpfRechargeExample example);

    int updateByPrimaryKeySelective(PpfRecharge record);

    int updateByPrimaryKey(PpfRecharge record);
    
    List<RechargeVo> selectRecordByPage(Map<String, Object> param);

    Double queryMoneyCount(Map<String, Object> param);

    Double queryLaMoneyCount(Map<String, Object> param);

    Double queryLaLaMoneyCount(Map<String, Object> param);

    int queryCount(Map<String, Object> param);

    int queryLaCount(Map<String, Object> param);

    int queryLaLaCount(Map<String, Object> param);

    int queryRechargeCount(Map<String, Object> param);

    int queryNewRechargeCount(Map<String, Object> param);
}