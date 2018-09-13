package com.holley.wxemcp.ent.dao.sys;

import com.holley.wxemcp.ent.model.sys.SysUnregisterAccount;
import com.holley.wxemcp.ent.model.sys.SysUnregisterAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUnregisterAccountMapper {
    int countByExample(SysUnregisterAccountExample example);

    int deleteByExample(SysUnregisterAccountExample example);

    int deleteByPrimaryKey(String phone);

    int insert(SysUnregisterAccount record);

    int insertSelective(SysUnregisterAccount record);

    List<SysUnregisterAccount> selectByExample(SysUnregisterAccountExample example);

    SysUnregisterAccount selectByPrimaryKey(String phone);

    int updateByExampleSelective(@Param("record") SysUnregisterAccount record, @Param("example") SysUnregisterAccountExample example);

    int updateByExample(@Param("record") SysUnregisterAccount record, @Param("example") SysUnregisterAccountExample example);

    int updateByPrimaryKeySelective(SysUnregisterAccount record);

    int updateByPrimaryKey(SysUnregisterAccount record);
}