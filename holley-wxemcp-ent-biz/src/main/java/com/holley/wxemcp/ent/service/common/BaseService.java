package com.holley.wxemcp.ent.service.common;


public interface BaseService {

    <T> T getMapperBean(Class<T> clazz);
}
