package com.holley.wxemcp.ent.serviceimpl.emcp;

import java.util.List;

import javax.annotation.Resource;

import com.holley.platform.dao.sys.SysAccountMapper;
import com.holley.platform.model.sys.SysAccount;
import com.holley.platform.model.sys.SysAccountExample;
import com.holley.wxemcp.ent.dao.obj.ObjEnterpriseMapper;
import com.holley.wxemcp.ent.dao.ppf.PpfEnterpriseWechatMapper;
import com.holley.wxemcp.ent.dao.sys.SysUnregisterAccountMapper;
import com.holley.wxemcp.ent.model.obj.ObjEnterprise;
import com.holley.wxemcp.ent.model.ppf.PpfEnterpriseWechat;
import com.holley.wxemcp.ent.model.sys.SysUnregisterAccount;
import com.holley.wxemcp.ent.service.emcp.AccountService;

public class AccountServiceImpl implements AccountService {

    @Resource
    private SysAccountMapper           sysAccountMapper;
    @Resource
    private ObjEnterpriseMapper        objEnterpriseMapper;
    @Resource
    private SysUnregisterAccountMapper sysUnregisterAccountMapper;
    @Resource
    private PpfEnterpriseWechatMapper  ppfEnterpriseWechatMapper;

    @Override
    public SysAccount selectAccountByPrimaryKey(String account) {
        return sysAccountMapper.selectByPrimaryKey(account);
    }

    @Override
    public ObjEnterprise selectEnterpriseByPrimaryKey(Integer eid) {
        return objEnterpriseMapper.selectByPrimaryKey(eid);
    }

    @Override
    public List<SysAccount> selecttAccountByExample(SysAccountExample example) {
        return sysAccountMapper.selectByExample(example);
    }

    @Override
    public SysUnregisterAccount selectUnregisterAccountByPrimaryKey(String phone) {
        return sysUnregisterAccountMapper.selectByPrimaryKey(phone);
    }

    @Override
    public int insertUnregisterAccountSelective(SysUnregisterAccount record) {
        return sysUnregisterAccountMapper.insertSelective(record);
    }

    @Override
    public int updateUnregisterAccountByPrimaryKeySelective(SysUnregisterAccount record) {
        return sysUnregisterAccountMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateEnterpriseWechatByPrimaryKeySelective(PpfEnterpriseWechat record) {
        return ppfEnterpriseWechatMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public PpfEnterpriseWechat selectEnterpriseWechatByPrimaryKey(String openId) {
        return ppfEnterpriseWechatMapper.selectByPrimaryKey(openId);
    }

}
