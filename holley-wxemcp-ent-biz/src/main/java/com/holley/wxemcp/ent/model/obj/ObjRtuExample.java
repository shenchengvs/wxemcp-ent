package com.holley.wxemcp.ent.model.obj;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjRtuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ObjRtuExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andRtuidIsNull() {
            addCriterion("RTUID is null");
            return (Criteria) this;
        }

        public Criteria andRtuidIsNotNull() {
            addCriterion("RTUID is not null");
            return (Criteria) this;
        }

        public Criteria andRtuidEqualTo(Integer value) {
            addCriterion("RTUID =", value, "rtuid");
            return (Criteria) this;
        }

        public Criteria andRtuidNotEqualTo(Integer value) {
            addCriterion("RTUID <>", value, "rtuid");
            return (Criteria) this;
        }

        public Criteria andRtuidGreaterThan(Integer value) {
            addCriterion("RTUID >", value, "rtuid");
            return (Criteria) this;
        }

        public Criteria andRtuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("RTUID >=", value, "rtuid");
            return (Criteria) this;
        }

        public Criteria andRtuidLessThan(Integer value) {
            addCriterion("RTUID <", value, "rtuid");
            return (Criteria) this;
        }

        public Criteria andRtuidLessThanOrEqualTo(Integer value) {
            addCriterion("RTUID <=", value, "rtuid");
            return (Criteria) this;
        }

        public Criteria andRtuidIn(List<Integer> values) {
            addCriterion("RTUID in", values, "rtuid");
            return (Criteria) this;
        }

        public Criteria andRtuidNotIn(List<Integer> values) {
            addCriterion("RTUID not in", values, "rtuid");
            return (Criteria) this;
        }

        public Criteria andRtuidBetween(Integer value1, Integer value2) {
            addCriterion("RTUID between", value1, value2, "rtuid");
            return (Criteria) this;
        }

        public Criteria andRtuidNotBetween(Integer value1, Integer value2) {
            addCriterion("RTUID not between", value1, value2, "rtuid");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("CODE is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("CODE is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("CODE =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("CODE <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("CODE >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CODE >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("CODE <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("CODE <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("CODE like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("CODE not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("CODE in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("CODE not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("CODE between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("CODE not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("NAME is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("NAME is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("NAME =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("NAME <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("NAME >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("NAME >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("NAME <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("NAME <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("NAME like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("NAME not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("NAME in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("NAME not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("NAME between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("NAME not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andEuuidIsNull() {
            addCriterion("EUUID is null");
            return (Criteria) this;
        }

        public Criteria andEuuidIsNotNull() {
            addCriterion("EUUID is not null");
            return (Criteria) this;
        }

        public Criteria andEuuidEqualTo(Integer value) {
            addCriterion("EUUID =", value, "euuid");
            return (Criteria) this;
        }

        public Criteria andEuuidNotEqualTo(Integer value) {
            addCriterion("EUUID <>", value, "euuid");
            return (Criteria) this;
        }

        public Criteria andEuuidGreaterThan(Integer value) {
            addCriterion("EUUID >", value, "euuid");
            return (Criteria) this;
        }

        public Criteria andEuuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("EUUID >=", value, "euuid");
            return (Criteria) this;
        }

        public Criteria andEuuidLessThan(Integer value) {
            addCriterion("EUUID <", value, "euuid");
            return (Criteria) this;
        }

        public Criteria andEuuidLessThanOrEqualTo(Integer value) {
            addCriterion("EUUID <=", value, "euuid");
            return (Criteria) this;
        }

        public Criteria andEuuidIn(List<Integer> values) {
            addCriterion("EUUID in", values, "euuid");
            return (Criteria) this;
        }

        public Criteria andEuuidNotIn(List<Integer> values) {
            addCriterion("EUUID not in", values, "euuid");
            return (Criteria) this;
        }

        public Criteria andEuuidBetween(Integer value1, Integer value2) {
            addCriterion("EUUID between", value1, value2, "euuid");
            return (Criteria) this;
        }

        public Criteria andEuuidNotBetween(Integer value1, Integer value2) {
            addCriterion("EUUID not between", value1, value2, "euuid");
            return (Criteria) this;
        }

        public Criteria andCommaddrIsNull() {
            addCriterion("COMMADDR is null");
            return (Criteria) this;
        }

        public Criteria andCommaddrIsNotNull() {
            addCriterion("COMMADDR is not null");
            return (Criteria) this;
        }

        public Criteria andCommaddrEqualTo(String value) {
            addCriterion("COMMADDR =", value, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrNotEqualTo(String value) {
            addCriterion("COMMADDR <>", value, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrGreaterThan(String value) {
            addCriterion("COMMADDR >", value, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrGreaterThanOrEqualTo(String value) {
            addCriterion("COMMADDR >=", value, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrLessThan(String value) {
            addCriterion("COMMADDR <", value, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrLessThanOrEqualTo(String value) {
            addCriterion("COMMADDR <=", value, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrLike(String value) {
            addCriterion("COMMADDR like", value, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrNotLike(String value) {
            addCriterion("COMMADDR not like", value, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrIn(List<String> values) {
            addCriterion("COMMADDR in", values, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrNotIn(List<String> values) {
            addCriterion("COMMADDR not in", values, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrBetween(String value1, String value2) {
            addCriterion("COMMADDR between", value1, value2, "commaddr");
            return (Criteria) this;
        }

        public Criteria andCommaddrNotBetween(String value1, String value2) {
            addCriterion("COMMADDR not between", value1, value2, "commaddr");
            return (Criteria) this;
        }

        public Criteria andProtocolidIsNull() {
            addCriterion("PROTOCOLID is null");
            return (Criteria) this;
        }

        public Criteria andProtocolidIsNotNull() {
            addCriterion("PROTOCOLID is not null");
            return (Criteria) this;
        }

        public Criteria andProtocolidEqualTo(Short value) {
            addCriterion("PROTOCOLID =", value, "protocolid");
            return (Criteria) this;
        }

        public Criteria andProtocolidNotEqualTo(Short value) {
            addCriterion("PROTOCOLID <>", value, "protocolid");
            return (Criteria) this;
        }

        public Criteria andProtocolidGreaterThan(Short value) {
            addCriterion("PROTOCOLID >", value, "protocolid");
            return (Criteria) this;
        }

        public Criteria andProtocolidGreaterThanOrEqualTo(Short value) {
            addCriterion("PROTOCOLID >=", value, "protocolid");
            return (Criteria) this;
        }

        public Criteria andProtocolidLessThan(Short value) {
            addCriterion("PROTOCOLID <", value, "protocolid");
            return (Criteria) this;
        }

        public Criteria andProtocolidLessThanOrEqualTo(Short value) {
            addCriterion("PROTOCOLID <=", value, "protocolid");
            return (Criteria) this;
        }

        public Criteria andProtocolidIn(List<Short> values) {
            addCriterion("PROTOCOLID in", values, "protocolid");
            return (Criteria) this;
        }

        public Criteria andProtocolidNotIn(List<Short> values) {
            addCriterion("PROTOCOLID not in", values, "protocolid");
            return (Criteria) this;
        }

        public Criteria andProtocolidBetween(Short value1, Short value2) {
            addCriterion("PROTOCOLID between", value1, value2, "protocolid");
            return (Criteria) this;
        }

        public Criteria andProtocolidNotBetween(Short value1, Short value2) {
            addCriterion("PROTOCOLID not between", value1, value2, "protocolid");
            return (Criteria) this;
        }

        public Criteria andSchemeidIsNull() {
            addCriterion("SCHEMEID is null");
            return (Criteria) this;
        }

        public Criteria andSchemeidIsNotNull() {
            addCriterion("SCHEMEID is not null");
            return (Criteria) this;
        }

        public Criteria andSchemeidEqualTo(Integer value) {
            addCriterion("SCHEMEID =", value, "schemeid");
            return (Criteria) this;
        }

        public Criteria andSchemeidNotEqualTo(Integer value) {
            addCriterion("SCHEMEID <>", value, "schemeid");
            return (Criteria) this;
        }

        public Criteria andSchemeidGreaterThan(Integer value) {
            addCriterion("SCHEMEID >", value, "schemeid");
            return (Criteria) this;
        }

        public Criteria andSchemeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("SCHEMEID >=", value, "schemeid");
            return (Criteria) this;
        }

        public Criteria andSchemeidLessThan(Integer value) {
            addCriterion("SCHEMEID <", value, "schemeid");
            return (Criteria) this;
        }

        public Criteria andSchemeidLessThanOrEqualTo(Integer value) {
            addCriterion("SCHEMEID <=", value, "schemeid");
            return (Criteria) this;
        }

        public Criteria andSchemeidIn(List<Integer> values) {
            addCriterion("SCHEMEID in", values, "schemeid");
            return (Criteria) this;
        }

        public Criteria andSchemeidNotIn(List<Integer> values) {
            addCriterion("SCHEMEID not in", values, "schemeid");
            return (Criteria) this;
        }

        public Criteria andSchemeidBetween(Integer value1, Integer value2) {
            addCriterion("SCHEMEID between", value1, value2, "schemeid");
            return (Criteria) this;
        }

        public Criteria andSchemeidNotBetween(Integer value1, Integer value2) {
            addCriterion("SCHEMEID not between", value1, value2, "schemeid");
            return (Criteria) this;
        }

        public Criteria andChannelid1IsNull() {
            addCriterion("CHANNELID1 is null");
            return (Criteria) this;
        }

        public Criteria andChannelid1IsNotNull() {
            addCriterion("CHANNELID1 is not null");
            return (Criteria) this;
        }

        public Criteria andChannelid1EqualTo(Short value) {
            addCriterion("CHANNELID1 =", value, "channelid1");
            return (Criteria) this;
        }

        public Criteria andChannelid1NotEqualTo(Short value) {
            addCriterion("CHANNELID1 <>", value, "channelid1");
            return (Criteria) this;
        }

        public Criteria andChannelid1GreaterThan(Short value) {
            addCriterion("CHANNELID1 >", value, "channelid1");
            return (Criteria) this;
        }

        public Criteria andChannelid1GreaterThanOrEqualTo(Short value) {
            addCriterion("CHANNELID1 >=", value, "channelid1");
            return (Criteria) this;
        }

        public Criteria andChannelid1LessThan(Short value) {
            addCriterion("CHANNELID1 <", value, "channelid1");
            return (Criteria) this;
        }

        public Criteria andChannelid1LessThanOrEqualTo(Short value) {
            addCriterion("CHANNELID1 <=", value, "channelid1");
            return (Criteria) this;
        }

        public Criteria andChannelid1In(List<Short> values) {
            addCriterion("CHANNELID1 in", values, "channelid1");
            return (Criteria) this;
        }

        public Criteria andChannelid1NotIn(List<Short> values) {
            addCriterion("CHANNELID1 not in", values, "channelid1");
            return (Criteria) this;
        }

        public Criteria andChannelid1Between(Short value1, Short value2) {
            addCriterion("CHANNELID1 between", value1, value2, "channelid1");
            return (Criteria) this;
        }

        public Criteria andChannelid1NotBetween(Short value1, Short value2) {
            addCriterion("CHANNELID1 not between", value1, value2, "channelid1");
            return (Criteria) this;
        }

        public Criteria andIpIsNull() {
            addCriterion("IP is null");
            return (Criteria) this;
        }

        public Criteria andIpIsNotNull() {
            addCriterion("IP is not null");
            return (Criteria) this;
        }

        public Criteria andIpEqualTo(String value) {
            addCriterion("IP =", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotEqualTo(String value) {
            addCriterion("IP <>", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThan(String value) {
            addCriterion("IP >", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpGreaterThanOrEqualTo(String value) {
            addCriterion("IP >=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThan(String value) {
            addCriterion("IP <", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLessThanOrEqualTo(String value) {
            addCriterion("IP <=", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpLike(String value) {
            addCriterion("IP like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotLike(String value) {
            addCriterion("IP not like", value, "ip");
            return (Criteria) this;
        }

        public Criteria andIpIn(List<String> values) {
            addCriterion("IP in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotIn(List<String> values) {
            addCriterion("IP not in", values, "ip");
            return (Criteria) this;
        }

        public Criteria andIpBetween(String value1, String value2) {
            addCriterion("IP between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andIpNotBetween(String value1, String value2) {
            addCriterion("IP not between", value1, value2, "ip");
            return (Criteria) this;
        }

        public Criteria andPortIsNull() {
            addCriterion("PORT is null");
            return (Criteria) this;
        }

        public Criteria andPortIsNotNull() {
            addCriterion("PORT is not null");
            return (Criteria) this;
        }

        public Criteria andPortEqualTo(Integer value) {
            addCriterion("PORT =", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotEqualTo(Integer value) {
            addCriterion("PORT <>", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThan(Integer value) {
            addCriterion("PORT >", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortGreaterThanOrEqualTo(Integer value) {
            addCriterion("PORT >=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThan(Integer value) {
            addCriterion("PORT <", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortLessThanOrEqualTo(Integer value) {
            addCriterion("PORT <=", value, "port");
            return (Criteria) this;
        }

        public Criteria andPortIn(List<Integer> values) {
            addCriterion("PORT in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotIn(List<Integer> values) {
            addCriterion("PORT not in", values, "port");
            return (Criteria) this;
        }

        public Criteria andPortBetween(Integer value1, Integer value2) {
            addCriterion("PORT between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andPortNotBetween(Integer value1, Integer value2) {
            addCriterion("PORT not between", value1, value2, "port");
            return (Criteria) this;
        }

        public Criteria andRtuipIsNull() {
            addCriterion("RTUIP is null");
            return (Criteria) this;
        }

        public Criteria andRtuipIsNotNull() {
            addCriterion("RTUIP is not null");
            return (Criteria) this;
        }

        public Criteria andRtuipEqualTo(String value) {
            addCriterion("RTUIP =", value, "rtuip");
            return (Criteria) this;
        }

        public Criteria andRtuipNotEqualTo(String value) {
            addCriterion("RTUIP <>", value, "rtuip");
            return (Criteria) this;
        }

        public Criteria andRtuipGreaterThan(String value) {
            addCriterion("RTUIP >", value, "rtuip");
            return (Criteria) this;
        }

        public Criteria andRtuipGreaterThanOrEqualTo(String value) {
            addCriterion("RTUIP >=", value, "rtuip");
            return (Criteria) this;
        }

        public Criteria andRtuipLessThan(String value) {
            addCriterion("RTUIP <", value, "rtuip");
            return (Criteria) this;
        }

        public Criteria andRtuipLessThanOrEqualTo(String value) {
            addCriterion("RTUIP <=", value, "rtuip");
            return (Criteria) this;
        }

        public Criteria andRtuipLike(String value) {
            addCriterion("RTUIP like", value, "rtuip");
            return (Criteria) this;
        }

        public Criteria andRtuipNotLike(String value) {
            addCriterion("RTUIP not like", value, "rtuip");
            return (Criteria) this;
        }

        public Criteria andRtuipIn(List<String> values) {
            addCriterion("RTUIP in", values, "rtuip");
            return (Criteria) this;
        }

        public Criteria andRtuipNotIn(List<String> values) {
            addCriterion("RTUIP not in", values, "rtuip");
            return (Criteria) this;
        }

        public Criteria andRtuipBetween(String value1, String value2) {
            addCriterion("RTUIP between", value1, value2, "rtuip");
            return (Criteria) this;
        }

        public Criteria andRtuipNotBetween(String value1, String value2) {
            addCriterion("RTUIP not between", value1, value2, "rtuip");
            return (Criteria) this;
        }

        public Criteria andChannelid2IsNull() {
            addCriterion("CHANNELID2 is null");
            return (Criteria) this;
        }

        public Criteria andChannelid2IsNotNull() {
            addCriterion("CHANNELID2 is not null");
            return (Criteria) this;
        }

        public Criteria andChannelid2EqualTo(Short value) {
            addCriterion("CHANNELID2 =", value, "channelid2");
            return (Criteria) this;
        }

        public Criteria andChannelid2NotEqualTo(Short value) {
            addCriterion("CHANNELID2 <>", value, "channelid2");
            return (Criteria) this;
        }

        public Criteria andChannelid2GreaterThan(Short value) {
            addCriterion("CHANNELID2 >", value, "channelid2");
            return (Criteria) this;
        }

        public Criteria andChannelid2GreaterThanOrEqualTo(Short value) {
            addCriterion("CHANNELID2 >=", value, "channelid2");
            return (Criteria) this;
        }

        public Criteria andChannelid2LessThan(Short value) {
            addCriterion("CHANNELID2 <", value, "channelid2");
            return (Criteria) this;
        }

        public Criteria andChannelid2LessThanOrEqualTo(Short value) {
            addCriterion("CHANNELID2 <=", value, "channelid2");
            return (Criteria) this;
        }

        public Criteria andChannelid2In(List<Short> values) {
            addCriterion("CHANNELID2 in", values, "channelid2");
            return (Criteria) this;
        }

        public Criteria andChannelid2NotIn(List<Short> values) {
            addCriterion("CHANNELID2 not in", values, "channelid2");
            return (Criteria) this;
        }

        public Criteria andChannelid2Between(Short value1, Short value2) {
            addCriterion("CHANNELID2 between", value1, value2, "channelid2");
            return (Criteria) this;
        }

        public Criteria andChannelid2NotBetween(Short value1, Short value2) {
            addCriterion("CHANNELID2 not between", value1, value2, "channelid2");
            return (Criteria) this;
        }

        public Criteria andReadschemeidIsNull() {
            addCriterion("READSCHEMEID is null");
            return (Criteria) this;
        }

        public Criteria andReadschemeidIsNotNull() {
            addCriterion("READSCHEMEID is not null");
            return (Criteria) this;
        }

        public Criteria andReadschemeidEqualTo(Short value) {
            addCriterion("READSCHEMEID =", value, "readschemeid");
            return (Criteria) this;
        }

        public Criteria andReadschemeidNotEqualTo(Short value) {
            addCriterion("READSCHEMEID <>", value, "readschemeid");
            return (Criteria) this;
        }

        public Criteria andReadschemeidGreaterThan(Short value) {
            addCriterion("READSCHEMEID >", value, "readschemeid");
            return (Criteria) this;
        }

        public Criteria andReadschemeidGreaterThanOrEqualTo(Short value) {
            addCriterion("READSCHEMEID >=", value, "readschemeid");
            return (Criteria) this;
        }

        public Criteria andReadschemeidLessThan(Short value) {
            addCriterion("READSCHEMEID <", value, "readschemeid");
            return (Criteria) this;
        }

        public Criteria andReadschemeidLessThanOrEqualTo(Short value) {
            addCriterion("READSCHEMEID <=", value, "readschemeid");
            return (Criteria) this;
        }

        public Criteria andReadschemeidIn(List<Short> values) {
            addCriterion("READSCHEMEID in", values, "readschemeid");
            return (Criteria) this;
        }

        public Criteria andReadschemeidNotIn(List<Short> values) {
            addCriterion("READSCHEMEID not in", values, "readschemeid");
            return (Criteria) this;
        }

        public Criteria andReadschemeidBetween(Short value1, Short value2) {
            addCriterion("READSCHEMEID between", value1, value2, "readschemeid");
            return (Criteria) this;
        }

        public Criteria andReadschemeidNotBetween(Short value1, Short value2) {
            addCriterion("READSCHEMEID not between", value1, value2, "readschemeid");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("MODEL is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("MODEL is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("MODEL =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("MODEL <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("MODEL >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("MODEL <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("MODEL <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("MODEL like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("MODEL not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("MODEL in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("MODEL not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("MODEL between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("MODEL not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andQtidIsNull() {
            addCriterion("QTID is null");
            return (Criteria) this;
        }

        public Criteria andQtidIsNotNull() {
            addCriterion("QTID is not null");
            return (Criteria) this;
        }

        public Criteria andQtidEqualTo(Short value) {
            addCriterion("QTID =", value, "qtid");
            return (Criteria) this;
        }

        public Criteria andQtidNotEqualTo(Short value) {
            addCriterion("QTID <>", value, "qtid");
            return (Criteria) this;
        }

        public Criteria andQtidGreaterThan(Short value) {
            addCriterion("QTID >", value, "qtid");
            return (Criteria) this;
        }

        public Criteria andQtidGreaterThanOrEqualTo(Short value) {
            addCriterion("QTID >=", value, "qtid");
            return (Criteria) this;
        }

        public Criteria andQtidLessThan(Short value) {
            addCriterion("QTID <", value, "qtid");
            return (Criteria) this;
        }

        public Criteria andQtidLessThanOrEqualTo(Short value) {
            addCriterion("QTID <=", value, "qtid");
            return (Criteria) this;
        }

        public Criteria andQtidIn(List<Short> values) {
            addCriterion("QTID in", values, "qtid");
            return (Criteria) this;
        }

        public Criteria andQtidNotIn(List<Short> values) {
            addCriterion("QTID not in", values, "qtid");
            return (Criteria) this;
        }

        public Criteria andQtidBetween(Short value1, Short value2) {
            addCriterion("QTID between", value1, value2, "qtid");
            return (Criteria) this;
        }

        public Criteria andQtidNotBetween(Short value1, Short value2) {
            addCriterion("QTID not between", value1, value2, "qtid");
            return (Criteria) this;
        }

        public Criteria andPassword1IsNull() {
            addCriterion("PASSWORD1 is null");
            return (Criteria) this;
        }

        public Criteria andPassword1IsNotNull() {
            addCriterion("PASSWORD1 is not null");
            return (Criteria) this;
        }

        public Criteria andPassword1EqualTo(String value) {
            addCriterion("PASSWORD1 =", value, "password1");
            return (Criteria) this;
        }

        public Criteria andPassword1NotEqualTo(String value) {
            addCriterion("PASSWORD1 <>", value, "password1");
            return (Criteria) this;
        }

        public Criteria andPassword1GreaterThan(String value) {
            addCriterion("PASSWORD1 >", value, "password1");
            return (Criteria) this;
        }

        public Criteria andPassword1GreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD1 >=", value, "password1");
            return (Criteria) this;
        }

        public Criteria andPassword1LessThan(String value) {
            addCriterion("PASSWORD1 <", value, "password1");
            return (Criteria) this;
        }

        public Criteria andPassword1LessThanOrEqualTo(String value) {
            addCriterion("PASSWORD1 <=", value, "password1");
            return (Criteria) this;
        }

        public Criteria andPassword1Like(String value) {
            addCriterion("PASSWORD1 like", value, "password1");
            return (Criteria) this;
        }

        public Criteria andPassword1NotLike(String value) {
            addCriterion("PASSWORD1 not like", value, "password1");
            return (Criteria) this;
        }

        public Criteria andPassword1In(List<String> values) {
            addCriterion("PASSWORD1 in", values, "password1");
            return (Criteria) this;
        }

        public Criteria andPassword1NotIn(List<String> values) {
            addCriterion("PASSWORD1 not in", values, "password1");
            return (Criteria) this;
        }

        public Criteria andPassword1Between(String value1, String value2) {
            addCriterion("PASSWORD1 between", value1, value2, "password1");
            return (Criteria) this;
        }

        public Criteria andPassword1NotBetween(String value1, String value2) {
            addCriterion("PASSWORD1 not between", value1, value2, "password1");
            return (Criteria) this;
        }

        public Criteria andPassword2IsNull() {
            addCriterion("PASSWORD2 is null");
            return (Criteria) this;
        }

        public Criteria andPassword2IsNotNull() {
            addCriterion("PASSWORD2 is not null");
            return (Criteria) this;
        }

        public Criteria andPassword2EqualTo(String value) {
            addCriterion("PASSWORD2 =", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2NotEqualTo(String value) {
            addCriterion("PASSWORD2 <>", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2GreaterThan(String value) {
            addCriterion("PASSWORD2 >", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2GreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD2 >=", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2LessThan(String value) {
            addCriterion("PASSWORD2 <", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2LessThanOrEqualTo(String value) {
            addCriterion("PASSWORD2 <=", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2Like(String value) {
            addCriterion("PASSWORD2 like", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2NotLike(String value) {
            addCriterion("PASSWORD2 not like", value, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2In(List<String> values) {
            addCriterion("PASSWORD2 in", values, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2NotIn(List<String> values) {
            addCriterion("PASSWORD2 not in", values, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2Between(String value1, String value2) {
            addCriterion("PASSWORD2 between", value1, value2, "password2");
            return (Criteria) this;
        }

        public Criteria andPassword2NotBetween(String value1, String value2) {
            addCriterion("PASSWORD2 not between", value1, value2, "password2");
            return (Criteria) this;
        }

        public Criteria andFactoryidIsNull() {
            addCriterion("FACTORYID is null");
            return (Criteria) this;
        }

        public Criteria andFactoryidIsNotNull() {
            addCriterion("FACTORYID is not null");
            return (Criteria) this;
        }

        public Criteria andFactoryidEqualTo(Short value) {
            addCriterion("FACTORYID =", value, "factoryid");
            return (Criteria) this;
        }

        public Criteria andFactoryidNotEqualTo(Short value) {
            addCriterion("FACTORYID <>", value, "factoryid");
            return (Criteria) this;
        }

        public Criteria andFactoryidGreaterThan(Short value) {
            addCriterion("FACTORYID >", value, "factoryid");
            return (Criteria) this;
        }

        public Criteria andFactoryidGreaterThanOrEqualTo(Short value) {
            addCriterion("FACTORYID >=", value, "factoryid");
            return (Criteria) this;
        }

        public Criteria andFactoryidLessThan(Short value) {
            addCriterion("FACTORYID <", value, "factoryid");
            return (Criteria) this;
        }

        public Criteria andFactoryidLessThanOrEqualTo(Short value) {
            addCriterion("FACTORYID <=", value, "factoryid");
            return (Criteria) this;
        }

        public Criteria andFactoryidIn(List<Short> values) {
            addCriterion("FACTORYID in", values, "factoryid");
            return (Criteria) this;
        }

        public Criteria andFactoryidNotIn(List<Short> values) {
            addCriterion("FACTORYID not in", values, "factoryid");
            return (Criteria) this;
        }

        public Criteria andFactoryidBetween(Short value1, Short value2) {
            addCriterion("FACTORYID between", value1, value2, "factoryid");
            return (Criteria) this;
        }

        public Criteria andFactoryidNotBetween(Short value1, Short value2) {
            addCriterion("FACTORYID not between", value1, value2, "factoryid");
            return (Criteria) this;
        }

        public Criteria andInstalltimeIsNull() {
            addCriterion("INSTALLTIME is null");
            return (Criteria) this;
        }

        public Criteria andInstalltimeIsNotNull() {
            addCriterion("INSTALLTIME is not null");
            return (Criteria) this;
        }

        public Criteria andInstalltimeEqualTo(Date value) {
            addCriterion("INSTALLTIME =", value, "installtime");
            return (Criteria) this;
        }

        public Criteria andInstalltimeNotEqualTo(Date value) {
            addCriterion("INSTALLTIME <>", value, "installtime");
            return (Criteria) this;
        }

        public Criteria andInstalltimeGreaterThan(Date value) {
            addCriterion("INSTALLTIME >", value, "installtime");
            return (Criteria) this;
        }

        public Criteria andInstalltimeGreaterThanOrEqualTo(Date value) {
            addCriterion("INSTALLTIME >=", value, "installtime");
            return (Criteria) this;
        }

        public Criteria andInstalltimeLessThan(Date value) {
            addCriterion("INSTALLTIME <", value, "installtime");
            return (Criteria) this;
        }

        public Criteria andInstalltimeLessThanOrEqualTo(Date value) {
            addCriterion("INSTALLTIME <=", value, "installtime");
            return (Criteria) this;
        }

        public Criteria andInstalltimeIn(List<Date> values) {
            addCriterion("INSTALLTIME in", values, "installtime");
            return (Criteria) this;
        }

        public Criteria andInstalltimeNotIn(List<Date> values) {
            addCriterion("INSTALLTIME not in", values, "installtime");
            return (Criteria) this;
        }

        public Criteria andInstalltimeBetween(Date value1, Date value2) {
            addCriterion("INSTALLTIME between", value1, value2, "installtime");
            return (Criteria) this;
        }

        public Criteria andInstalltimeNotBetween(Date value1, Date value2) {
            addCriterion("INSTALLTIME not between", value1, value2, "installtime");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("ADDRESS =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("ADDRESS <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("ADDRESS >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("ADDRESS >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("ADDRESS <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("ADDRESS <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("ADDRESS like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("ADDRESS not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("ADDRESS in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("ADDRESS not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("ADDRESS between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("ADDRESS not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andRegistetypeIsNull() {
            addCriterion("REGISTETYPE is null");
            return (Criteria) this;
        }

        public Criteria andRegistetypeIsNotNull() {
            addCriterion("REGISTETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andRegistetypeEqualTo(Short value) {
            addCriterion("REGISTETYPE =", value, "registetype");
            return (Criteria) this;
        }

        public Criteria andRegistetypeNotEqualTo(Short value) {
            addCriterion("REGISTETYPE <>", value, "registetype");
            return (Criteria) this;
        }

        public Criteria andRegistetypeGreaterThan(Short value) {
            addCriterion("REGISTETYPE >", value, "registetype");
            return (Criteria) this;
        }

        public Criteria andRegistetypeGreaterThanOrEqualTo(Short value) {
            addCriterion("REGISTETYPE >=", value, "registetype");
            return (Criteria) this;
        }

        public Criteria andRegistetypeLessThan(Short value) {
            addCriterion("REGISTETYPE <", value, "registetype");
            return (Criteria) this;
        }

        public Criteria andRegistetypeLessThanOrEqualTo(Short value) {
            addCriterion("REGISTETYPE <=", value, "registetype");
            return (Criteria) this;
        }

        public Criteria andRegistetypeIn(List<Short> values) {
            addCriterion("REGISTETYPE in", values, "registetype");
            return (Criteria) this;
        }

        public Criteria andRegistetypeNotIn(List<Short> values) {
            addCriterion("REGISTETYPE not in", values, "registetype");
            return (Criteria) this;
        }

        public Criteria andRegistetypeBetween(Short value1, Short value2) {
            addCriterion("REGISTETYPE between", value1, value2, "registetype");
            return (Criteria) this;
        }

        public Criteria andRegistetypeNotBetween(Short value1, Short value2) {
            addCriterion("REGISTETYPE not between", value1, value2, "registetype");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}