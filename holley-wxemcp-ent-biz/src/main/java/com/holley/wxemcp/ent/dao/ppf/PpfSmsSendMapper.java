package com.holley.wxemcp.ent.dao.ppf;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.holley.wxemcp.ent.model.def.MessageVo;
import com.holley.wxemcp.ent.model.ppf.PpfSmsSend;
import com.holley.wxemcp.ent.model.ppf.PpfSmsSendExample;

public interface PpfSmsSendMapper {

    int countByExample(PpfSmsSendExample example);

    int deleteByExample(PpfSmsSendExample example);

    int deleteByPrimaryKey(Integer smsid);

    int insert(PpfSmsSend record);

    int insertSelective(PpfSmsSend record);

    List<PpfSmsSend> selectByExample(PpfSmsSendExample example);

    PpfSmsSend selectByPrimaryKey(Integer smsid);

    int updateByExampleSelective(@Param("record") PpfSmsSend record, @Param("example") PpfSmsSendExample example);

    int updateByExample(@Param("record") PpfSmsSend record, @Param("example") PpfSmsSendExample example);

    int updateByPrimaryKeySelective(PpfSmsSend record);

    int updateByPrimaryKey(PpfSmsSend record);

    List<MessageVo> selectMessagesByPage(Map<String, Object> param);

    int queryCuifeiCount(Map<String, Object> param);

    int queryLACuiFeiCount(Map<String, Object> param);

    int queryLALACuiFeiCount(Map<String, Object> param);

    int queryNewMessageCount(Map<String, Object> param);
}
