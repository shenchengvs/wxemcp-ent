package com.holley.wxemcp.ent.dao.dat;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.wxemcp.ent.model.dat.DatEvtHis;
import com.holley.wxemcp.ent.model.dat.DatEvtHisExample;
import com.holley.wxemcp.ent.model.dat.DatEvtHisKey;
import com.holley.wxemcp.ent.model.def.EvtWxSendVo;

public interface DatEvtHisMapper {

    int countByExample(DatEvtHisExample example);

    int deleteByExample(DatEvtHisExample example);

    int deleteByPrimaryKey(DatEvtHisKey key);

    int insert(DatEvtHis record);

    int insertSelective(DatEvtHis record);

    List<DatEvtHis> selectByExample(DatEvtHisExample example);

    DatEvtHis selectByPrimaryKey(DatEvtHisKey key);

    int updateByExampleSelective(@Param("record") DatEvtHis record, @Param("example") DatEvtHisExample example);

    int updateByExample(@Param("record") DatEvtHis record, @Param("example") DatEvtHisExample example);

    int updateByPrimaryKeySelective(DatEvtHis record);

    int updateByPrimaryKey(DatEvtHis record);

    List<EvtWxSendVo> selectPointWxSendEvent(Map<String, Object> map);

    List<EvtWxSendVo> selectRtuWxSendEvent(Map<String, Object> map);

    List<EvtWxSendVo> selectRtuWxSendEventByEid(Map<String, Object> map);

    List<EvtWxSendVo> selectPointWxSendEventByEid(Map<String, Object> map);
}
