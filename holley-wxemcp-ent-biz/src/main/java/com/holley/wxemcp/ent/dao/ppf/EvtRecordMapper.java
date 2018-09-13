package com.holley.wxemcp.ent.dao.ppf;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.wxemcp.ent.model.def.EvtRecordVo;
import com.holley.wxemcp.ent.model.ppf.EvtRecord;
import com.holley.wxemcp.ent.model.ppf.EvtRecordExample;
import com.holley.wxemcp.ent.model.ppf.EvtRecordKey;

public interface EvtRecordMapper {

    int countByExample(EvtRecordExample example);

    int deleteByExample(EvtRecordExample example);

    int deleteByPrimaryKey(EvtRecordKey key);

    int insert(EvtRecord record);

    int insertSelective(EvtRecord record);

    List<EvtRecord> selectByExample(EvtRecordExample example);

    EvtRecord selectByPrimaryKey(EvtRecordKey key);

    int updateByExampleSelective(@Param("record") EvtRecord record, @Param("example") EvtRecordExample example);

    int updateByExample(@Param("record") EvtRecord record, @Param("example") EvtRecordExample example);

    int updateByPrimaryKeySelective(EvtRecord record);

    int updateByPrimaryKey(EvtRecord record);

    List<EvtRecordVo> selectEvtRecordByPage(Map<String, Object> param);

    int countLastEvtRecord(Map<String, Object> param);

    int countTodayEvtRecord(Map<String, Object> param);

    int countTodayEvtHis(Map<String, Object> param);

    int countLastEvtHis(Map<String, Object> param);

}
