package com.holley.wxemcp.ent.model.obj;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjPointExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ObjPointExample() {
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

        public Criteria andPointidIsNull() {
            addCriterion("POINTID is null");
            return (Criteria) this;
        }

        public Criteria andPointidIsNotNull() {
            addCriterion("POINTID is not null");
            return (Criteria) this;
        }

        public Criteria andPointidEqualTo(Integer value) {
            addCriterion("POINTID =", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidNotEqualTo(Integer value) {
            addCriterion("POINTID <>", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidGreaterThan(Integer value) {
            addCriterion("POINTID >", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidGreaterThanOrEqualTo(Integer value) {
            addCriterion("POINTID >=", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidLessThan(Integer value) {
            addCriterion("POINTID <", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidLessThanOrEqualTo(Integer value) {
            addCriterion("POINTID <=", value, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidIn(List<Integer> values) {
            addCriterion("POINTID in", values, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidNotIn(List<Integer> values) {
            addCriterion("POINTID not in", values, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidBetween(Integer value1, Integer value2) {
            addCriterion("POINTID between", value1, value2, "pointid");
            return (Criteria) this;
        }

        public Criteria andPointidNotBetween(Integer value1, Integer value2) {
            addCriterion("POINTID not between", value1, value2, "pointid");
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

        public Criteria andOwneridIsNull() {
            addCriterion("OWNERID is null");
            return (Criteria) this;
        }

        public Criteria andOwneridIsNotNull() {
            addCriterion("OWNERID is not null");
            return (Criteria) this;
        }

        public Criteria andOwneridEqualTo(Integer value) {
            addCriterion("OWNERID =", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotEqualTo(Integer value) {
            addCriterion("OWNERID <>", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridGreaterThan(Integer value) {
            addCriterion("OWNERID >", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridGreaterThanOrEqualTo(Integer value) {
            addCriterion("OWNERID >=", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridLessThan(Integer value) {
            addCriterion("OWNERID <", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridLessThanOrEqualTo(Integer value) {
            addCriterion("OWNERID <=", value, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridIn(List<Integer> values) {
            addCriterion("OWNERID in", values, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotIn(List<Integer> values) {
            addCriterion("OWNERID not in", values, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridBetween(Integer value1, Integer value2) {
            addCriterion("OWNERID between", value1, value2, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwneridNotBetween(Integer value1, Integer value2) {
            addCriterion("OWNERID not between", value1, value2, "ownerid");
            return (Criteria) this;
        }

        public Criteria andOwnertypeIsNull() {
            addCriterion("OWNERTYPE is null");
            return (Criteria) this;
        }

        public Criteria andOwnertypeIsNotNull() {
            addCriterion("OWNERTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOwnertypeEqualTo(Short value) {
            addCriterion("OWNERTYPE =", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeNotEqualTo(Short value) {
            addCriterion("OWNERTYPE <>", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeGreaterThan(Short value) {
            addCriterion("OWNERTYPE >", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeGreaterThanOrEqualTo(Short value) {
            addCriterion("OWNERTYPE >=", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeLessThan(Short value) {
            addCriterion("OWNERTYPE <", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeLessThanOrEqualTo(Short value) {
            addCriterion("OWNERTYPE <=", value, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeIn(List<Short> values) {
            addCriterion("OWNERTYPE in", values, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeNotIn(List<Short> values) {
            addCriterion("OWNERTYPE not in", values, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeBetween(Short value1, Short value2) {
            addCriterion("OWNERTYPE between", value1, value2, "ownertype");
            return (Criteria) this;
        }

        public Criteria andOwnertypeNotBetween(Short value1, Short value2) {
            addCriterion("OWNERTYPE not between", value1, value2, "ownertype");
            return (Criteria) this;
        }

        public Criteria andEidIsNull() {
            addCriterion("EID is null");
            return (Criteria) this;
        }

        public Criteria andEidIsNotNull() {
            addCriterion("EID is not null");
            return (Criteria) this;
        }

        public Criteria andEidEqualTo(Integer value) {
            addCriterion("EID =", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotEqualTo(Integer value) {
            addCriterion("EID <>", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThan(Integer value) {
            addCriterion("EID >", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidGreaterThanOrEqualTo(Integer value) {
            addCriterion("EID >=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThan(Integer value) {
            addCriterion("EID <", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidLessThanOrEqualTo(Integer value) {
            addCriterion("EID <=", value, "eid");
            return (Criteria) this;
        }

        public Criteria andEidIn(List<Integer> values) {
            addCriterion("EID in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotIn(List<Integer> values) {
            addCriterion("EID not in", values, "eid");
            return (Criteria) this;
        }

        public Criteria andEidBetween(Integer value1, Integer value2) {
            addCriterion("EID between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andEidNotBetween(Integer value1, Integer value2) {
            addCriterion("EID not between", value1, value2, "eid");
            return (Criteria) this;
        }

        public Criteria andInputoutputIsNull() {
            addCriterion("INPUTOUTPUT is null");
            return (Criteria) this;
        }

        public Criteria andInputoutputIsNotNull() {
            addCriterion("INPUTOUTPUT is not null");
            return (Criteria) this;
        }

        public Criteria andInputoutputEqualTo(Short value) {
            addCriterion("INPUTOUTPUT =", value, "inputoutput");
            return (Criteria) this;
        }

        public Criteria andInputoutputNotEqualTo(Short value) {
            addCriterion("INPUTOUTPUT <>", value, "inputoutput");
            return (Criteria) this;
        }

        public Criteria andInputoutputGreaterThan(Short value) {
            addCriterion("INPUTOUTPUT >", value, "inputoutput");
            return (Criteria) this;
        }

        public Criteria andInputoutputGreaterThanOrEqualTo(Short value) {
            addCriterion("INPUTOUTPUT >=", value, "inputoutput");
            return (Criteria) this;
        }

        public Criteria andInputoutputLessThan(Short value) {
            addCriterion("INPUTOUTPUT <", value, "inputoutput");
            return (Criteria) this;
        }

        public Criteria andInputoutputLessThanOrEqualTo(Short value) {
            addCriterion("INPUTOUTPUT <=", value, "inputoutput");
            return (Criteria) this;
        }

        public Criteria andInputoutputIn(List<Short> values) {
            addCriterion("INPUTOUTPUT in", values, "inputoutput");
            return (Criteria) this;
        }

        public Criteria andInputoutputNotIn(List<Short> values) {
            addCriterion("INPUTOUTPUT not in", values, "inputoutput");
            return (Criteria) this;
        }

        public Criteria andInputoutputBetween(Short value1, Short value2) {
            addCriterion("INPUTOUTPUT between", value1, value2, "inputoutput");
            return (Criteria) this;
        }

        public Criteria andInputoutputNotBetween(Short value1, Short value2) {
            addCriterion("INPUTOUTPUT not between", value1, value2, "inputoutput");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Short value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Short value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Short value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Short value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Short value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Short> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Short> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Short value1, Short value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Short value1, Short value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andEnergytypeidIsNull() {
            addCriterion("ENERGYTYPEID is null");
            return (Criteria) this;
        }

        public Criteria andEnergytypeidIsNotNull() {
            addCriterion("ENERGYTYPEID is not null");
            return (Criteria) this;
        }

        public Criteria andEnergytypeidEqualTo(Short value) {
            addCriterion("ENERGYTYPEID =", value, "energytypeid");
            return (Criteria) this;
        }

        public Criteria andEnergytypeidNotEqualTo(Short value) {
            addCriterion("ENERGYTYPEID <>", value, "energytypeid");
            return (Criteria) this;
        }

        public Criteria andEnergytypeidGreaterThan(Short value) {
            addCriterion("ENERGYTYPEID >", value, "energytypeid");
            return (Criteria) this;
        }

        public Criteria andEnergytypeidGreaterThanOrEqualTo(Short value) {
            addCriterion("ENERGYTYPEID >=", value, "energytypeid");
            return (Criteria) this;
        }

        public Criteria andEnergytypeidLessThan(Short value) {
            addCriterion("ENERGYTYPEID <", value, "energytypeid");
            return (Criteria) this;
        }

        public Criteria andEnergytypeidLessThanOrEqualTo(Short value) {
            addCriterion("ENERGYTYPEID <=", value, "energytypeid");
            return (Criteria) this;
        }

        public Criteria andEnergytypeidIn(List<Short> values) {
            addCriterion("ENERGYTYPEID in", values, "energytypeid");
            return (Criteria) this;
        }

        public Criteria andEnergytypeidNotIn(List<Short> values) {
            addCriterion("ENERGYTYPEID not in", values, "energytypeid");
            return (Criteria) this;
        }

        public Criteria andEnergytypeidBetween(Short value1, Short value2) {
            addCriterion("ENERGYTYPEID between", value1, value2, "energytypeid");
            return (Criteria) this;
        }

        public Criteria andEnergytypeidNotBetween(Short value1, Short value2) {
            addCriterion("ENERGYTYPEID not between", value1, value2, "energytypeid");
            return (Criteria) this;
        }

        public Criteria andEnergypropIsNull() {
            addCriterion("ENERGYPROP is null");
            return (Criteria) this;
        }

        public Criteria andEnergypropIsNotNull() {
            addCriterion("ENERGYPROP is not null");
            return (Criteria) this;
        }

        public Criteria andEnergypropEqualTo(Short value) {
            addCriterion("ENERGYPROP =", value, "energyprop");
            return (Criteria) this;
        }

        public Criteria andEnergypropNotEqualTo(Short value) {
            addCriterion("ENERGYPROP <>", value, "energyprop");
            return (Criteria) this;
        }

        public Criteria andEnergypropGreaterThan(Short value) {
            addCriterion("ENERGYPROP >", value, "energyprop");
            return (Criteria) this;
        }

        public Criteria andEnergypropGreaterThanOrEqualTo(Short value) {
            addCriterion("ENERGYPROP >=", value, "energyprop");
            return (Criteria) this;
        }

        public Criteria andEnergypropLessThan(Short value) {
            addCriterion("ENERGYPROP <", value, "energyprop");
            return (Criteria) this;
        }

        public Criteria andEnergypropLessThanOrEqualTo(Short value) {
            addCriterion("ENERGYPROP <=", value, "energyprop");
            return (Criteria) this;
        }

        public Criteria andEnergypropIn(List<Short> values) {
            addCriterion("ENERGYPROP in", values, "energyprop");
            return (Criteria) this;
        }

        public Criteria andEnergypropNotIn(List<Short> values) {
            addCriterion("ENERGYPROP not in", values, "energyprop");
            return (Criteria) this;
        }

        public Criteria andEnergypropBetween(Short value1, Short value2) {
            addCriterion("ENERGYPROP between", value1, value2, "energyprop");
            return (Criteria) this;
        }

        public Criteria andEnergypropNotBetween(Short value1, Short value2) {
            addCriterion("ENERGYPROP not between", value1, value2, "energyprop");
            return (Criteria) this;
        }

        public Criteria andEnergyusetypeidIsNull() {
            addCriterion("ENERGYUSETYPEID is null");
            return (Criteria) this;
        }

        public Criteria andEnergyusetypeidIsNotNull() {
            addCriterion("ENERGYUSETYPEID is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyusetypeidEqualTo(Short value) {
            addCriterion("ENERGYUSETYPEID =", value, "energyusetypeid");
            return (Criteria) this;
        }

        public Criteria andEnergyusetypeidNotEqualTo(Short value) {
            addCriterion("ENERGYUSETYPEID <>", value, "energyusetypeid");
            return (Criteria) this;
        }

        public Criteria andEnergyusetypeidGreaterThan(Short value) {
            addCriterion("ENERGYUSETYPEID >", value, "energyusetypeid");
            return (Criteria) this;
        }

        public Criteria andEnergyusetypeidGreaterThanOrEqualTo(Short value) {
            addCriterion("ENERGYUSETYPEID >=", value, "energyusetypeid");
            return (Criteria) this;
        }

        public Criteria andEnergyusetypeidLessThan(Short value) {
            addCriterion("ENERGYUSETYPEID <", value, "energyusetypeid");
            return (Criteria) this;
        }

        public Criteria andEnergyusetypeidLessThanOrEqualTo(Short value) {
            addCriterion("ENERGYUSETYPEID <=", value, "energyusetypeid");
            return (Criteria) this;
        }

        public Criteria andEnergyusetypeidIn(List<Short> values) {
            addCriterion("ENERGYUSETYPEID in", values, "energyusetypeid");
            return (Criteria) this;
        }

        public Criteria andEnergyusetypeidNotIn(List<Short> values) {
            addCriterion("ENERGYUSETYPEID not in", values, "energyusetypeid");
            return (Criteria) this;
        }

        public Criteria andEnergyusetypeidBetween(Short value1, Short value2) {
            addCriterion("ENERGYUSETYPEID between", value1, value2, "energyusetypeid");
            return (Criteria) this;
        }

        public Criteria andEnergyusetypeidNotBetween(Short value1, Short value2) {
            addCriterion("ENERGYUSETYPEID not between", value1, value2, "energyusetypeid");
            return (Criteria) this;
        }

        public Criteria andAddrIsNull() {
            addCriterion("ADDR is null");
            return (Criteria) this;
        }

        public Criteria andAddrIsNotNull() {
            addCriterion("ADDR is not null");
            return (Criteria) this;
        }

        public Criteria andAddrEqualTo(String value) {
            addCriterion("ADDR =", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotEqualTo(String value) {
            addCriterion("ADDR <>", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThan(String value) {
            addCriterion("ADDR >", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrGreaterThanOrEqualTo(String value) {
            addCriterion("ADDR >=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThan(String value) {
            addCriterion("ADDR <", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLessThanOrEqualTo(String value) {
            addCriterion("ADDR <=", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrLike(String value) {
            addCriterion("ADDR like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotLike(String value) {
            addCriterion("ADDR not like", value, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrIn(List<String> values) {
            addCriterion("ADDR in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotIn(List<String> values) {
            addCriterion("ADDR not in", values, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrBetween(String value1, String value2) {
            addCriterion("ADDR between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAddrNotBetween(String value1, String value2) {
            addCriterion("ADDR not between", value1, value2, "addr");
            return (Criteria) this;
        }

        public Criteria andAutogatherIsNull() {
            addCriterion("AUTOGATHER is null");
            return (Criteria) this;
        }

        public Criteria andAutogatherIsNotNull() {
            addCriterion("AUTOGATHER is not null");
            return (Criteria) this;
        }

        public Criteria andAutogatherEqualTo(Short value) {
            addCriterion("AUTOGATHER =", value, "autogather");
            return (Criteria) this;
        }

        public Criteria andAutogatherNotEqualTo(Short value) {
            addCriterion("AUTOGATHER <>", value, "autogather");
            return (Criteria) this;
        }

        public Criteria andAutogatherGreaterThan(Short value) {
            addCriterion("AUTOGATHER >", value, "autogather");
            return (Criteria) this;
        }

        public Criteria andAutogatherGreaterThanOrEqualTo(Short value) {
            addCriterion("AUTOGATHER >=", value, "autogather");
            return (Criteria) this;
        }

        public Criteria andAutogatherLessThan(Short value) {
            addCriterion("AUTOGATHER <", value, "autogather");
            return (Criteria) this;
        }

        public Criteria andAutogatherLessThanOrEqualTo(Short value) {
            addCriterion("AUTOGATHER <=", value, "autogather");
            return (Criteria) this;
        }

        public Criteria andAutogatherIn(List<Short> values) {
            addCriterion("AUTOGATHER in", values, "autogather");
            return (Criteria) this;
        }

        public Criteria andAutogatherNotIn(List<Short> values) {
            addCriterion("AUTOGATHER not in", values, "autogather");
            return (Criteria) this;
        }

        public Criteria andAutogatherBetween(Short value1, Short value2) {
            addCriterion("AUTOGATHER between", value1, value2, "autogather");
            return (Criteria) this;
        }

        public Criteria andAutogatherNotBetween(Short value1, Short value2) {
            addCriterion("AUTOGATHER not between", value1, value2, "autogather");
            return (Criteria) this;
        }

        public Criteria andSampleintervalIsNull() {
            addCriterion("SAMPLEINTERVAL is null");
            return (Criteria) this;
        }

        public Criteria andSampleintervalIsNotNull() {
            addCriterion("SAMPLEINTERVAL is not null");
            return (Criteria) this;
        }

        public Criteria andSampleintervalEqualTo(String value) {
            addCriterion("SAMPLEINTERVAL =", value, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalNotEqualTo(String value) {
            addCriterion("SAMPLEINTERVAL <>", value, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalGreaterThan(String value) {
            addCriterion("SAMPLEINTERVAL >", value, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalGreaterThanOrEqualTo(String value) {
            addCriterion("SAMPLEINTERVAL >=", value, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalLessThan(String value) {
            addCriterion("SAMPLEINTERVAL <", value, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalLessThanOrEqualTo(String value) {
            addCriterion("SAMPLEINTERVAL <=", value, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalLike(String value) {
            addCriterion("SAMPLEINTERVAL like", value, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalNotLike(String value) {
            addCriterion("SAMPLEINTERVAL not like", value, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalIn(List<String> values) {
            addCriterion("SAMPLEINTERVAL in", values, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalNotIn(List<String> values) {
            addCriterion("SAMPLEINTERVAL not in", values, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalBetween(String value1, String value2) {
            addCriterion("SAMPLEINTERVAL between", value1, value2, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andSampleintervalNotBetween(String value1, String value2) {
            addCriterion("SAMPLEINTERVAL not between", value1, value2, "sampleinterval");
            return (Criteria) this;
        }

        public Criteria andDataitemflagIsNull() {
            addCriterion("DATAITEMFLAG is null");
            return (Criteria) this;
        }

        public Criteria andDataitemflagIsNotNull() {
            addCriterion("DATAITEMFLAG is not null");
            return (Criteria) this;
        }

        public Criteria andDataitemflagEqualTo(Short value) {
            addCriterion("DATAITEMFLAG =", value, "dataitemflag");
            return (Criteria) this;
        }

        public Criteria andDataitemflagNotEqualTo(Short value) {
            addCriterion("DATAITEMFLAG <>", value, "dataitemflag");
            return (Criteria) this;
        }

        public Criteria andDataitemflagGreaterThan(Short value) {
            addCriterion("DATAITEMFLAG >", value, "dataitemflag");
            return (Criteria) this;
        }

        public Criteria andDataitemflagGreaterThanOrEqualTo(Short value) {
            addCriterion("DATAITEMFLAG >=", value, "dataitemflag");
            return (Criteria) this;
        }

        public Criteria andDataitemflagLessThan(Short value) {
            addCriterion("DATAITEMFLAG <", value, "dataitemflag");
            return (Criteria) this;
        }

        public Criteria andDataitemflagLessThanOrEqualTo(Short value) {
            addCriterion("DATAITEMFLAG <=", value, "dataitemflag");
            return (Criteria) this;
        }

        public Criteria andDataitemflagIn(List<Short> values) {
            addCriterion("DATAITEMFLAG in", values, "dataitemflag");
            return (Criteria) this;
        }

        public Criteria andDataitemflagNotIn(List<Short> values) {
            addCriterion("DATAITEMFLAG not in", values, "dataitemflag");
            return (Criteria) this;
        }

        public Criteria andDataitemflagBetween(Short value1, Short value2) {
            addCriterion("DATAITEMFLAG between", value1, value2, "dataitemflag");
            return (Criteria) this;
        }

        public Criteria andDataitemflagNotBetween(Short value1, Short value2) {
            addCriterion("DATAITEMFLAG not between", value1, value2, "dataitemflag");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("RATE is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("RATE is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(BigDecimal value) {
            addCriterion("RATE =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(BigDecimal value) {
            addCriterion("RATE <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(BigDecimal value) {
            addCriterion("RATE >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("RATE >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(BigDecimal value) {
            addCriterion("RATE <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("RATE <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<BigDecimal> values) {
            addCriterion("RATE in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<BigDecimal> values) {
            addCriterion("RATE not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATE between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("RATE not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRatechangetimeIsNull() {
            addCriterion("RATECHANGETIME is null");
            return (Criteria) this;
        }

        public Criteria andRatechangetimeIsNotNull() {
            addCriterion("RATECHANGETIME is not null");
            return (Criteria) this;
        }

        public Criteria andRatechangetimeEqualTo(Date value) {
            addCriterion("RATECHANGETIME =", value, "ratechangetime");
            return (Criteria) this;
        }

        public Criteria andRatechangetimeNotEqualTo(Date value) {
            addCriterion("RATECHANGETIME <>", value, "ratechangetime");
            return (Criteria) this;
        }

        public Criteria andRatechangetimeGreaterThan(Date value) {
            addCriterion("RATECHANGETIME >", value, "ratechangetime");
            return (Criteria) this;
        }

        public Criteria andRatechangetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RATECHANGETIME >=", value, "ratechangetime");
            return (Criteria) this;
        }

        public Criteria andRatechangetimeLessThan(Date value) {
            addCriterion("RATECHANGETIME <", value, "ratechangetime");
            return (Criteria) this;
        }

        public Criteria andRatechangetimeLessThanOrEqualTo(Date value) {
            addCriterion("RATECHANGETIME <=", value, "ratechangetime");
            return (Criteria) this;
        }

        public Criteria andRatechangetimeIn(List<Date> values) {
            addCriterion("RATECHANGETIME in", values, "ratechangetime");
            return (Criteria) this;
        }

        public Criteria andRatechangetimeNotIn(List<Date> values) {
            addCriterion("RATECHANGETIME not in", values, "ratechangetime");
            return (Criteria) this;
        }

        public Criteria andRatechangetimeBetween(Date value1, Date value2) {
            addCriterion("RATECHANGETIME between", value1, value2, "ratechangetime");
            return (Criteria) this;
        }

        public Criteria andRatechangetimeNotBetween(Date value1, Date value2) {
            addCriterion("RATECHANGETIME not between", value1, value2, "ratechangetime");
            return (Criteria) this;
        }

        public Criteria andCapabilityIsNull() {
            addCriterion("CAPABILITY is null");
            return (Criteria) this;
        }

        public Criteria andCapabilityIsNotNull() {
            addCriterion("CAPABILITY is not null");
            return (Criteria) this;
        }

        public Criteria andCapabilityEqualTo(String value) {
            addCriterion("CAPABILITY =", value, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityNotEqualTo(String value) {
            addCriterion("CAPABILITY <>", value, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityGreaterThan(String value) {
            addCriterion("CAPABILITY >", value, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityGreaterThanOrEqualTo(String value) {
            addCriterion("CAPABILITY >=", value, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityLessThan(String value) {
            addCriterion("CAPABILITY <", value, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityLessThanOrEqualTo(String value) {
            addCriterion("CAPABILITY <=", value, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityLike(String value) {
            addCriterion("CAPABILITY like", value, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityNotLike(String value) {
            addCriterion("CAPABILITY not like", value, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityIn(List<String> values) {
            addCriterion("CAPABILITY in", values, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityNotIn(List<String> values) {
            addCriterion("CAPABILITY not in", values, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityBetween(String value1, String value2) {
            addCriterion("CAPABILITY between", value1, value2, "capability");
            return (Criteria) this;
        }

        public Criteria andCapabilityNotBetween(String value1, String value2) {
            addCriterion("CAPABILITY not between", value1, value2, "capability");
            return (Criteria) this;
        }

        public Criteria andMeasuremodeIsNull() {
            addCriterion("MEASUREMODE is null");
            return (Criteria) this;
        }

        public Criteria andMeasuremodeIsNotNull() {
            addCriterion("MEASUREMODE is not null");
            return (Criteria) this;
        }

        public Criteria andMeasuremodeEqualTo(Short value) {
            addCriterion("MEASUREMODE =", value, "measuremode");
            return (Criteria) this;
        }

        public Criteria andMeasuremodeNotEqualTo(Short value) {
            addCriterion("MEASUREMODE <>", value, "measuremode");
            return (Criteria) this;
        }

        public Criteria andMeasuremodeGreaterThan(Short value) {
            addCriterion("MEASUREMODE >", value, "measuremode");
            return (Criteria) this;
        }

        public Criteria andMeasuremodeGreaterThanOrEqualTo(Short value) {
            addCriterion("MEASUREMODE >=", value, "measuremode");
            return (Criteria) this;
        }

        public Criteria andMeasuremodeLessThan(Short value) {
            addCriterion("MEASUREMODE <", value, "measuremode");
            return (Criteria) this;
        }

        public Criteria andMeasuremodeLessThanOrEqualTo(Short value) {
            addCriterion("MEASUREMODE <=", value, "measuremode");
            return (Criteria) this;
        }

        public Criteria andMeasuremodeIn(List<Short> values) {
            addCriterion("MEASUREMODE in", values, "measuremode");
            return (Criteria) this;
        }

        public Criteria andMeasuremodeNotIn(List<Short> values) {
            addCriterion("MEASUREMODE not in", values, "measuremode");
            return (Criteria) this;
        }

        public Criteria andMeasuremodeBetween(Short value1, Short value2) {
            addCriterion("MEASUREMODE between", value1, value2, "measuremode");
            return (Criteria) this;
        }

        public Criteria andMeasuremodeNotBetween(Short value1, Short value2) {
            addCriterion("MEASUREMODE not between", value1, value2, "measuremode");
            return (Criteria) this;
        }

        public Criteria andIsprepaidIsNull() {
            addCriterion("ISPREPAID is null");
            return (Criteria) this;
        }

        public Criteria andIsprepaidIsNotNull() {
            addCriterion("ISPREPAID is not null");
            return (Criteria) this;
        }

        public Criteria andIsprepaidEqualTo(Short value) {
            addCriterion("ISPREPAID =", value, "isprepaid");
            return (Criteria) this;
        }

        public Criteria andIsprepaidNotEqualTo(Short value) {
            addCriterion("ISPREPAID <>", value, "isprepaid");
            return (Criteria) this;
        }

        public Criteria andIsprepaidGreaterThan(Short value) {
            addCriterion("ISPREPAID >", value, "isprepaid");
            return (Criteria) this;
        }

        public Criteria andIsprepaidGreaterThanOrEqualTo(Short value) {
            addCriterion("ISPREPAID >=", value, "isprepaid");
            return (Criteria) this;
        }

        public Criteria andIsprepaidLessThan(Short value) {
            addCriterion("ISPREPAID <", value, "isprepaid");
            return (Criteria) this;
        }

        public Criteria andIsprepaidLessThanOrEqualTo(Short value) {
            addCriterion("ISPREPAID <=", value, "isprepaid");
            return (Criteria) this;
        }

        public Criteria andIsprepaidIn(List<Short> values) {
            addCriterion("ISPREPAID in", values, "isprepaid");
            return (Criteria) this;
        }

        public Criteria andIsprepaidNotIn(List<Short> values) {
            addCriterion("ISPREPAID not in", values, "isprepaid");
            return (Criteria) this;
        }

        public Criteria andIsprepaidBetween(Short value1, Short value2) {
            addCriterion("ISPREPAID between", value1, value2, "isprepaid");
            return (Criteria) this;
        }

        public Criteria andIsprepaidNotBetween(Short value1, Short value2) {
            addCriterion("ISPREPAID not between", value1, value2, "isprepaid");
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