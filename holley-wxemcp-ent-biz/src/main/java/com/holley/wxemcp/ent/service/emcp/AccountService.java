package com.holley.wxemcp.ent.service.emcp;

import java.util.List;

import com.holley.platform.model.sys.SysAccount;
import com.holley.platform.model.sys.SysAccountExample;
import com.holley.wxemcp.ent.model.obj.ObjEnterprise;
import com.holley.wxemcp.ent.model.ppf.PpfEnterpriseWechat;
import com.holley.wxemcp.ent.model.sys.SysUnregisterAccount;

public interface AccountService {

    // 查询用户信息
    SysAccount selectAccountByPrimaryKey(String account);

    // 查询企业
    ObjEnterprise selectEnterpriseByPrimaryKey(Integer eid);

    List<SysAccount> selecttAccountByExample(SysAccountExample example);

    SysUnregisterAccount selectUnregisterAccountByPrimaryKey(String phone);

    int insertUnregisterAccountSelective(SysUnregisterAccount record);

    int updateUnregisterAccountByPrimaryKeySelective(SysUnregisterAccount record);

    int updateEnterpriseWechatByPrimaryKeySelective(PpfEnterpriseWechat record);

    PpfEnterpriseWechat selectEnterpriseWechatByPrimaryKey(String openId);
}
