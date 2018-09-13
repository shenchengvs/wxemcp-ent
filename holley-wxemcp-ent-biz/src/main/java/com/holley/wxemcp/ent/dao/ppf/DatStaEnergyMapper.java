package com.holley.wxemcp.ent.dao.ppf;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.wxemcp.ent.model.def.DepartmentUseDetailsVo;
import com.holley.wxemcp.ent.model.def.DepartmentUseVo;
import com.holley.wxemcp.ent.model.ppf.DatStaEnergy;
import com.holley.wxemcp.ent.model.ppf.DatStaEnergyExample;
import com.holley.wxemcp.ent.model.ppf.DatStaEnergyKey;

public interface DatStaEnergyMapper {

    int countByExample(DatStaEnergyExample example);

    int deleteByExample(DatStaEnergyExample example);

    int deleteByPrimaryKey(DatStaEnergyKey key);

    int insert(DatStaEnergy record);

    int insertSelective(DatStaEnergy record);

    List<DatStaEnergy> selectByExample(DatStaEnergyExample example);

    DatStaEnergy selectByPrimaryKey(DatStaEnergyKey key);

    int updateByExampleSelective(@Param("record") DatStaEnergy record, @Param("example") DatStaEnergyExample example);

    int updateByExample(@Param("record") DatStaEnergy record, @Param("example") DatStaEnergyExample example);

    int updateByPrimaryKeySelective(DatStaEnergy record);

    int updateByPrimaryKey(DatStaEnergy record);

    Double queryNowSum(Map<String, Object> param);

    Double queryLastSum(Map<String, Object> param);

    Double queryLaLaSum(Map<String, Object> param);

    int CreateCiJi(Map<String, Object> param);

    List<DepartmentUseVo> queryDepartmentUse(Map<String, Object> param);

    int dropCiJi(Map<String, Object> param);

    List<DepartmentUseDetailsVo> queryAllDepartmentUseDetailsOne(Map<String, Object> param);

    List<DepartmentUseDetailsVo> queryAllDepartmentUseDetailsToday(Map<String, Object> param);

    List<DepartmentUseDetailsVo> selectCurStaEnergyByDateTime(Map<String, Object> param);

    Double queryNowSumTwo(Map<String, Object> param);

    List<DepartmentUseVo> queryDepartmentUseNow(Map<String, Object> param);
}
