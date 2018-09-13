package com.holley.wxemcp.ent.dao.ppf;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.wxemcp.ent.model.def.PpfControlCmdVo;
import com.holley.wxemcp.ent.model.ppf.PpfControlCmd;
import com.holley.wxemcp.ent.model.ppf.PpfControlCmdExample;
import com.holley.wxemcp.ent.model.ppf.PpfControlCmdKey;

public interface PpfControlCmdMapper {

    int countByExample(PpfControlCmdExample example);

    int deleteByExample(PpfControlCmdExample example);

    int deleteByPrimaryKey(PpfControlCmdKey key);

    int insert(PpfControlCmd record);

    int insertSelective(PpfControlCmd record);

    List<PpfControlCmd> selectByExample(PpfControlCmdExample example);

    PpfControlCmd selectByPrimaryKey(PpfControlCmdKey key);

    int updateByExampleSelective(@Param("record") PpfControlCmd record, @Param("example") PpfControlCmdExample example);

    int updateByExample(@Param("record") PpfControlCmd record, @Param("example") PpfControlCmdExample example);

    int updateByPrimaryKeySelective(PpfControlCmd record);

    int updateByPrimaryKey(PpfControlCmd record);

    List<PpfControlCmdVo> selectRemotesByPage(Map<String, Object> param);

    int queryLazhaCount(Map<String, Object> param);

    int queryLAlazhaCount(Map<String, Object> param);

    int queryLALAlazhaCount(Map<String, Object> param);

    int queryNewRemoteCount(Map<String, Object> param);
}
