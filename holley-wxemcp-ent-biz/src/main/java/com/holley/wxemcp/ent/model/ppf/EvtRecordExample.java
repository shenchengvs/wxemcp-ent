package com.holley.wxemcp.ent.model.ppf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EvtRecordExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EvtRecordExample() {
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

        public Criteria andEventparamidIsNull() {
            addCriterion("EVENTPARAMID is null");
            return (Criteria) this;
        }

        public Criteria andEventparamidIsNotNull() {
            addCriterion("EVENTPARAMID is not null");
            return (Criteria) this;
        }

        public Criteria andEventparamidEqualTo(Integer value) {
            addCriterion("EVENTPARAMID =", value, "eventparamid");
            return (Criteria) this;
        }

        public Criteria andEventparamidNotEqualTo(Integer value) {
            addCriterion("EVENTPARAMID <>", value, "eventparamid");
            return (Criteria) this;
        }

        public Criteria andEventparamidGreaterThan(Integer value) {
            addCriterion("EVENTPARAMID >", value, "eventparamid");
            return (Criteria) this;
        }

        public Criteria andEventparamidGreaterThanOrEqualTo(Integer value) {
            addCriterion("EVENTPARAMID >=", value, "eventparamid");
            return (Criteria) this;
        }

        public Criteria andEventparamidLessThan(Integer value) {
            addCriterion("EVENTPARAMID <", value, "eventparamid");
            return (Criteria) this;
        }

        public Criteria andEventparamidLessThanOrEqualTo(Integer value) {
            addCriterion("EVENTPARAMID <=", value, "eventparamid");
            return (Criteria) this;
        }

        public Criteria andEventparamidIn(List<Integer> values) {
            addCriterion("EVENTPARAMID in", values, "eventparamid");
            return (Criteria) this;
        }

        public Criteria andEventparamidNotIn(List<Integer> values) {
            addCriterion("EVENTPARAMID not in", values, "eventparamid");
            return (Criteria) this;
        }

        public Criteria andEventparamidBetween(Integer value1, Integer value2) {
            addCriterion("EVENTPARAMID between", value1, value2, "eventparamid");
            return (Criteria) this;
        }

        public Criteria andEventparamidNotBetween(Integer value1, Integer value2) {
            addCriterion("EVENTPARAMID not between", value1, value2, "eventparamid");
            return (Criteria) this;
        }

        public Criteria andObjidIsNull() {
            addCriterion("OBJID is null");
            return (Criteria) this;
        }

        public Criteria andObjidIsNotNull() {
            addCriterion("OBJID is not null");
            return (Criteria) this;
        }

        public Criteria andObjidEqualTo(Integer value) {
            addCriterion("OBJID =", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidNotEqualTo(Integer value) {
            addCriterion("OBJID <>", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidGreaterThan(Integer value) {
            addCriterion("OBJID >", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidGreaterThanOrEqualTo(Integer value) {
            addCriterion("OBJID >=", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidLessThan(Integer value) {
            addCriterion("OBJID <", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidLessThanOrEqualTo(Integer value) {
            addCriterion("OBJID <=", value, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidIn(List<Integer> values) {
            addCriterion("OBJID in", values, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidNotIn(List<Integer> values) {
            addCriterion("OBJID not in", values, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidBetween(Integer value1, Integer value2) {
            addCriterion("OBJID between", value1, value2, "objid");
            return (Criteria) this;
        }

        public Criteria andObjidNotBetween(Integer value1, Integer value2) {
            addCriterion("OBJID not between", value1, value2, "objid");
            return (Criteria) this;
        }

        public Criteria andObjtypeIsNull() {
            addCriterion("OBJTYPE is null");
            return (Criteria) this;
        }

        public Criteria andObjtypeIsNotNull() {
            addCriterion("OBJTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andObjtypeEqualTo(Integer value) {
            addCriterion("OBJTYPE =", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeNotEqualTo(Integer value) {
            addCriterion("OBJTYPE <>", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeGreaterThan(Integer value) {
            addCriterion("OBJTYPE >", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("OBJTYPE >=", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeLessThan(Integer value) {
            addCriterion("OBJTYPE <", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeLessThanOrEqualTo(Integer value) {
            addCriterion("OBJTYPE <=", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeIn(List<Integer> values) {
            addCriterion("OBJTYPE in", values, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeNotIn(List<Integer> values) {
            addCriterion("OBJTYPE not in", values, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeBetween(Integer value1, Integer value2) {
            addCriterion("OBJTYPE between", value1, value2, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("OBJTYPE not between", value1, value2, "objtype");
            return (Criteria) this;
        }

        public Criteria andOccurtimeIsNull() {
            addCriterion("OCCURTIME is null");
            return (Criteria) this;
        }

        public Criteria andOccurtimeIsNotNull() {
            addCriterion("OCCURTIME is not null");
            return (Criteria) this;
        }

        public Criteria andOccurtimeEqualTo(Date value) {
            addCriterion("OCCURTIME =", value, "occurtime");
            return (Criteria) this;
        }

        public Criteria andOccurtimeNotEqualTo(Date value) {
            addCriterion("OCCURTIME <>", value, "occurtime");
            return (Criteria) this;
        }

        public Criteria andOccurtimeGreaterThan(Date value) {
            addCriterion("OCCURTIME >", value, "occurtime");
            return (Criteria) this;
        }

        public Criteria andOccurtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OCCURTIME >=", value, "occurtime");
            return (Criteria) this;
        }

        public Criteria andOccurtimeLessThan(Date value) {
            addCriterion("OCCURTIME <", value, "occurtime");
            return (Criteria) this;
        }

        public Criteria andOccurtimeLessThanOrEqualTo(Date value) {
            addCriterion("OCCURTIME <=", value, "occurtime");
            return (Criteria) this;
        }

        public Criteria andOccurtimeIn(List<Date> values) {
            addCriterion("OCCURTIME in", values, "occurtime");
            return (Criteria) this;
        }

        public Criteria andOccurtimeNotIn(List<Date> values) {
            addCriterion("OCCURTIME not in", values, "occurtime");
            return (Criteria) this;
        }

        public Criteria andOccurtimeBetween(Date value1, Date value2) {
            addCriterion("OCCURTIME between", value1, value2, "occurtime");
            return (Criteria) this;
        }

        public Criteria andOccurtimeNotBetween(Date value1, Date value2) {
            addCriterion("OCCURTIME not between", value1, value2, "occurtime");
            return (Criteria) this;
        }

        public Criteria andEventtypeIsNull() {
            addCriterion("EVENTTYPE is null");
            return (Criteria) this;
        }

        public Criteria andEventtypeIsNotNull() {
            addCriterion("EVENTTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEventtypeEqualTo(Short value) {
            addCriterion("EVENTTYPE =", value, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeNotEqualTo(Short value) {
            addCriterion("EVENTTYPE <>", value, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeGreaterThan(Short value) {
            addCriterion("EVENTTYPE >", value, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeGreaterThanOrEqualTo(Short value) {
            addCriterion("EVENTTYPE >=", value, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeLessThan(Short value) {
            addCriterion("EVENTTYPE <", value, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeLessThanOrEqualTo(Short value) {
            addCriterion("EVENTTYPE <=", value, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeIn(List<Short> values) {
            addCriterion("EVENTTYPE in", values, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeNotIn(List<Short> values) {
            addCriterion("EVENTTYPE not in", values, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeBetween(Short value1, Short value2) {
            addCriterion("EVENTTYPE between", value1, value2, "eventtype");
            return (Criteria) this;
        }

        public Criteria andEventtypeNotBetween(Short value1, Short value2) {
            addCriterion("EVENTTYPE not between", value1, value2, "eventtype");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNull() {
            addCriterion("SENDTIME is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("SENDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(Date value) {
            addCriterion("SENDTIME =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(Date value) {
            addCriterion("SENDTIME <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(Date value) {
            addCriterion("SENDTIME >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SENDTIME >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(Date value) {
            addCriterion("SENDTIME <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(Date value) {
            addCriterion("SENDTIME <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<Date> values) {
            addCriterion("SENDTIME in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<Date> values) {
            addCriterion("SENDTIME not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(Date value1, Date value2) {
            addCriterion("SENDTIME between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(Date value1, Date value2) {
            addCriterion("SENDTIME not between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andEventdescIsNull() {
            addCriterion("EVENTDESC is null");
            return (Criteria) this;
        }

        public Criteria andEventdescIsNotNull() {
            addCriterion("EVENTDESC is not null");
            return (Criteria) this;
        }

        public Criteria andEventdescEqualTo(String value) {
            addCriterion("EVENTDESC =", value, "eventdesc");
            return (Criteria) this;
        }

        public Criteria andEventdescNotEqualTo(String value) {
            addCriterion("EVENTDESC <>", value, "eventdesc");
            return (Criteria) this;
        }

        public Criteria andEventdescGreaterThan(String value) {
            addCriterion("EVENTDESC >", value, "eventdesc");
            return (Criteria) this;
        }

        public Criteria andEventdescGreaterThanOrEqualTo(String value) {
            addCriterion("EVENTDESC >=", value, "eventdesc");
            return (Criteria) this;
        }

        public Criteria andEventdescLessThan(String value) {
            addCriterion("EVENTDESC <", value, "eventdesc");
            return (Criteria) this;
        }

        public Criteria andEventdescLessThanOrEqualTo(String value) {
            addCriterion("EVENTDESC <=", value, "eventdesc");
            return (Criteria) this;
        }

        public Criteria andEventdescLike(String value) {
            addCriterion("EVENTDESC like", value, "eventdesc");
            return (Criteria) this;
        }

        public Criteria andEventdescNotLike(String value) {
            addCriterion("EVENTDESC not like", value, "eventdesc");
            return (Criteria) this;
        }

        public Criteria andEventdescIn(List<String> values) {
            addCriterion("EVENTDESC in", values, "eventdesc");
            return (Criteria) this;
        }

        public Criteria andEventdescNotIn(List<String> values) {
            addCriterion("EVENTDESC not in", values, "eventdesc");
            return (Criteria) this;
        }

        public Criteria andEventdescBetween(String value1, String value2) {
            addCriterion("EVENTDESC between", value1, value2, "eventdesc");
            return (Criteria) this;
        }

        public Criteria andEventdescNotBetween(String value1, String value2) {
            addCriterion("EVENTDESC not between", value1, value2, "eventdesc");
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