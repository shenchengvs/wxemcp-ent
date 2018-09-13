package com.holley.wxemcp.ent.dao.ppf;

import com.holley.wxemcp.ent.model.ppf.PpfEnterpriseWechat;
import com.holley.wxemcp.ent.model.ppf.PpfEnterpriseWechatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PpfEnterpriseWechatMapper {
    int countByExample(PpfEnterpriseWechatExample example);

    int deleteByExample(PpfEnterpriseWechatExample example);

    int deleteByPrimaryKey(String openId);

    int insert(PpfEnterpriseWechat record);

    int insertSelective(PpfEnterpriseWechat record);

    List<PpfEnterpriseWechat> selectByExample(PpfEnterpriseWechatExample example);

    PpfEnterpriseWechat selectByPrimaryKey(String openId);

    int updateByExampleSelective(@Param("record") PpfEnterpriseWechat record, @Param("example") PpfEnterpriseWechatExample example);

    int updateByExample(@Param("record") PpfEnterpriseWechat record, @Param("example") PpfEnterpriseWechatExample example);

    int updateByPrimaryKeySelective(PpfEnterpriseWechat record);

    int updateByPrimaryKey(PpfEnterpriseWechat record);
}