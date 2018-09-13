package com.holley.wxemcp.ent.dao.ppf;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.wxemcp.ent.model.def.EnergyUseDetailsVo;
import com.holley.wxemcp.ent.model.def.EnergyUserBlockVo;
import com.holley.wxemcp.ent.model.ppf.DatStaItemUsed;
import com.holley.wxemcp.ent.model.ppf.DatStaItemUsedExample;
import com.holley.wxemcp.ent.model.ppf.DatStaItemUsedKey;

public interface DatStaItemUsedMapper {

    int countByExample(DatStaItemUsedExample example);

    int deleteByExample(DatStaItemUsedExample example);

    int deleteByPrimaryKey(DatStaItemUsedKey key);

    int insert(DatStaItemUsed record);

    int insertSelective(DatStaItemUsed record);

    List<DatStaItemUsed> selectByExample(DatStaItemUsedExample example);

    DatStaItemUsed selectByPrimaryKey(DatStaItemUsedKey key);

    int updateByExampleSelective(@Param("record") DatStaItemUsed record, @Param("example") DatStaItemUsedExample example);

    int updateByExample(@Param("record") DatStaItemUsed record, @Param("example") DatStaItemUsedExample example);

    int updateByPrimaryKeySelective(DatStaItemUsed record);

    int updateByPrimaryKey(DatStaItemUsed record);

    List<EnergyUserBlockVo> queryEnergyUser(Map<String, Object> param);

    Double queryEnergyUserSum(Map<String, Object> param);

    List<EnergyUseDetailsVo> queryEnergyUseDetailsOne(Map<String, Object> param);

    List<EnergyUseDetailsVo> queryEnergyUseDetailsToday(Map<String, Object> param);
}
