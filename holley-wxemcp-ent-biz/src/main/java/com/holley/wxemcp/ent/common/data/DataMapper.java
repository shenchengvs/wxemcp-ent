package com.holley.wxemcp.ent.common.data;

import java.util.List;
import java.util.Map;

import com.holley.wxemcp.ent.model.def.DataCount;
import com.holley.wxemcp.ent.model.def.DataElecDetail;
import com.holley.wxemcp.ent.model.def.DataWaterDetail;
import com.holley.wxemcp.ent.model.def.DetailElecVo;
import com.holley.wxemcp.ent.model.def.DetailWaterVo;
import com.holley.wxemcp.ent.model.def.FeeVo;
import com.holley.wxemcp.ent.model.def.QueryVo;
import com.holley.wxemcp.ent.model.def.RealVo;

public interface DataMapper {
	// real
	List<RealVo> selectRealElecByPage(Map<String, Object> param);

	List<RealVo> selectRealWaterByPage(Map<String, Object> param);

	// query
	List<QueryVo> selectHistoryElecByPage(Map<String, Object> param);

	List<QueryVo> selectHistoryWaterByPage(Map<String, Object> param);

	// fee
	List<FeeVo> selectCurMonthElecFeeByPage(Map<String, Object> param);

	List<FeeVo> selectPastMonthElecFeeByPage(Map<String, Object> param);

	List<FeeVo> selectCurMonthWaterFeeByPage(Map<String, Object> param);

	List<FeeVo> selectPastMonthWaterFeeByPage(Map<String, Object> param);

	// detail
	DataElecDetail selectBaseMonthPastDetailElecByParam(Map<String, Object> param);

	DataElecDetail selectBaseMonthCurDetailElecByParam(Map<String, Object> param);

	List<DetailElecVo> selectDetailElecMonthBillByCustomerId(Map<String, Object> param);

	DataWaterDetail selectBaseMonthPastDetailWaterByParam(Map<String, Object> param);

	DataWaterDetail selectBaseMonthCurDetailWaterByParam(Map<String, Object> param);

	List<DetailWaterVo> selectDetailWaterMonthBillByCustomerId(Map<String, Object> param);

	// count
	int countUnRealPointElecByEid(Integer eid);

	int countUnRealPointWaterByEid(Integer eid);

	DataCount selectOtherCountByEid(Map<String, Object> param);
}
