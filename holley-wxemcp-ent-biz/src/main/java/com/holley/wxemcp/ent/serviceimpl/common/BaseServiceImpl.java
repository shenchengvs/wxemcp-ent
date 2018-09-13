package com.holley.wxemcp.ent.serviceimpl.common;

import org.springframework.context.support.ApplicationObjectSupport;

import com.holley.wxemcp.ent.service.common.BaseService;

public class BaseServiceImpl extends ApplicationObjectSupport implements BaseService {

    @Override
    public <T> T getMapperBean(Class<T> clazz) {
        return (T) getApplicationContext().getBean(toLowerCaseFirstOne(clazz.getSimpleName()));
    }

    // 首字母转小写
    private String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0))) {
            return s;
        } else {
            return new StringBuilder().append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
        }
    }
}
