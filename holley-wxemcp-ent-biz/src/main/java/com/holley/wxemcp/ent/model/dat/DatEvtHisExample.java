package com.holley.wxemcp.ent.model.dat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatEvtHisExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DatEvtHisExample() {
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

        public Criteria andEventitemidIsNull() {
            addCriterion("EVENTITEMID is null");
            return (Criteria) this;
        }

        public Criteria andEventitemidIsNotNull() {
            addCriterion("EVENTITEMID is not null");
            return (Criteria) this;
        }

        public Criteria andEventitemidEqualTo(Short value) {
            addCriterion("EVENTITEMID =", value, "eventitemid");
            return (Criteria) this;
        }

        public Criteria andEventitemidNotEqualTo(Short value) {
            addCriterion("EVENTITEMID <>", value, "eventitemid");
            return (Criteria) this;
        }

        public Criteria andEventitemidGreaterThan(Short value) {
            addCriterion("EVENTITEMID >", value, "eventitemid");
            return (Criteria) this;
        }

        public Criteria andEventitemidGreaterThanOrEqualTo(Short value) {
            addCriterion("EVENTITEMID >=", value, "eventitemid");
            return (Criteria) this;
        }

        public Criteria andEventitemidLessThan(Short value) {
            addCriterion("EVENTITEMID <", value, "eventitemid");
            return (Criteria) this;
        }

        public Criteria andEventitemidLessThanOrEqualTo(Short value) {
            addCriterion("EVENTITEMID <=", value, "eventitemid");
            return (Criteria) this;
        }

        public Criteria andEventitemidIn(List<Short> values) {
            addCriterion("EVENTITEMID in", values, "eventitemid");
            return (Criteria) this;
        }

        public Criteria andEventitemidNotIn(List<Short> values) {
            addCriterion("EVENTITEMID not in", values, "eventitemid");
            return (Criteria) this;
        }

        public Criteria andEventitemidBetween(Short value1, Short value2) {
            addCriterion("EVENTITEMID between", value1, value2, "eventitemid");
            return (Criteria) this;
        }

        public Criteria andEventitemidNotBetween(Short value1, Short value2) {
            addCriterion("EVENTITEMID not between", value1, value2, "eventitemid");
            return (Criteria) this;
        }

        public Criteria andEventtimeIsNull() {
            addCriterion("EVENTTIME is null");
            return (Criteria) this;
        }

        public Criteria andEventtimeIsNotNull() {
            addCriterion("EVENTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andEventtimeEqualTo(Date value) {
            addCriterion("EVENTTIME =", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeNotEqualTo(Date value) {
            addCriterion("EVENTTIME <>", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeGreaterThan(Date value) {
            addCriterion("EVENTTIME >", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("EVENTTIME >=", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeLessThan(Date value) {
            addCriterion("EVENTTIME <", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeLessThanOrEqualTo(Date value) {
            addCriterion("EVENTTIME <=", value, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeIn(List<Date> values) {
            addCriterion("EVENTTIME in", values, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeNotIn(List<Date> values) {
            addCriterion("EVENTTIME not in", values, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeBetween(Date value1, Date value2) {
            addCriterion("EVENTTIME between", value1, value2, "eventtime");
            return (Criteria) this;
        }

        public Criteria andEventtimeNotBetween(Date value1, Date value2) {
            addCriterion("EVENTTIME not between", value1, value2, "eventtime");
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

        public Criteria andObjtypeEqualTo(Short value) {
            addCriterion("OBJTYPE =", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeNotEqualTo(Short value) {
            addCriterion("OBJTYPE <>", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeGreaterThan(Short value) {
            addCriterion("OBJTYPE >", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeGreaterThanOrEqualTo(Short value) {
            addCriterion("OBJTYPE >=", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeLessThan(Short value) {
            addCriterion("OBJTYPE <", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeLessThanOrEqualTo(Short value) {
            addCriterion("OBJTYPE <=", value, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeIn(List<Short> values) {
            addCriterion("OBJTYPE in", values, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeNotIn(List<Short> values) {
            addCriterion("OBJTYPE not in", values, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeBetween(Short value1, Short value2) {
            addCriterion("OBJTYPE between", value1, value2, "objtype");
            return (Criteria) this;
        }

        public Criteria andObjtypeNotBetween(Short value1, Short value2) {
            addCriterion("OBJTYPE not between", value1, value2, "objtype");
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

        public Criteria andEventnoteIsNull() {
            addCriterion("EVENTNOTE is null");
            return (Criteria) this;
        }

        public Criteria andEventnoteIsNotNull() {
            addCriterion("EVENTNOTE is not null");
            return (Criteria) this;
        }

        public Criteria andEventnoteEqualTo(String value) {
            addCriterion("EVENTNOTE =", value, "eventnote");
            return (Criteria) this;
        }

        public Criteria andEventnoteNotEqualTo(String value) {
            addCriterion("EVENTNOTE <>", value, "eventnote");
            return (Criteria) this;
        }

        public Criteria andEventnoteGreaterThan(String value) {
            addCriterion("EVENTNOTE >", value, "eventnote");
            return (Criteria) this;
        }

        public Criteria andEventnoteGreaterThanOrEqualTo(String value) {
            addCriterion("EVENTNOTE >=", value, "eventnote");
            return (Criteria) this;
        }

        public Criteria andEventnoteLessThan(String value) {
            addCriterion("EVENTNOTE <", value, "eventnote");
            return (Criteria) this;
        }

        public Criteria andEventnoteLessThanOrEqualTo(String value) {
            addCriterion("EVENTNOTE <=", value, "eventnote");
            return (Criteria) this;
        }

        public Criteria andEventnoteLike(String value) {
            addCriterion("EVENTNOTE like", value, "eventnote");
            return (Criteria) this;
        }

        public Criteria andEventnoteNotLike(String value) {
            addCriterion("EVENTNOTE not like", value, "eventnote");
            return (Criteria) this;
        }

        public Criteria andEventnoteIn(List<String> values) {
            addCriterion("EVENTNOTE in", values, "eventnote");
            return (Criteria) this;
        }

        public Criteria andEventnoteNotIn(List<String> values) {
            addCriterion("EVENTNOTE not in", values, "eventnote");
            return (Criteria) this;
        }

        public Criteria andEventnoteBetween(String value1, String value2) {
            addCriterion("EVENTNOTE between", value1, value2, "eventnote");
            return (Criteria) this;
        }

        public Criteria andEventnoteNotBetween(String value1, String value2) {
            addCriterion("EVENTNOTE not between", value1, value2, "eventnote");
            return (Criteria) this;
        }

        public Criteria andEventdataIsNull() {
            addCriterion("EVENTDATA is null");
            return (Criteria) this;
        }

        public Criteria andEventdataIsNotNull() {
            addCriterion("EVENTDATA is not null");
            return (Criteria) this;
        }

        public Criteria andEventdataEqualTo(String value) {
            addCriterion("EVENTDATA =", value, "eventdata");
            return (Criteria) this;
        }

        public Criteria andEventdataNotEqualTo(String value) {
            addCriterion("EVENTDATA <>", value, "eventdata");
            return (Criteria) this;
        }

        public Criteria andEventdataGreaterThan(String value) {
            addCriterion("EVENTDATA >", value, "eventdata");
            return (Criteria) this;
        }

        public Criteria andEventdataGreaterThanOrEqualTo(String value) {
            addCriterion("EVENTDATA >=", value, "eventdata");
            return (Criteria) this;
        }

        public Criteria andEventdataLessThan(String value) {
            addCriterion("EVENTDATA <", value, "eventdata");
            return (Criteria) this;
        }

        public Criteria andEventdataLessThanOrEqualTo(String value) {
            addCriterion("EVENTDATA <=", value, "eventdata");
            return (Criteria) this;
        }

        public Criteria andEventdataLike(String value) {
            addCriterion("EVENTDATA like", value, "eventdata");
            return (Criteria) this;
        }

        public Criteria andEventdataNotLike(String value) {
            addCriterion("EVENTDATA not like", value, "eventdata");
            return (Criteria) this;
        }

        public Criteria andEventdataIn(List<String> values) {
            addCriterion("EVENTDATA in", values, "eventdata");
            return (Criteria) this;
        }

        public Criteria andEventdataNotIn(List<String> values) {
            addCriterion("EVENTDATA not in", values, "eventdata");
            return (Criteria) this;
        }

        public Criteria andEventdataBetween(String value1, String value2) {
            addCriterion("EVENTDATA between", value1, value2, "eventdata");
            return (Criteria) this;
        }

        public Criteria andEventdataNotBetween(String value1, String value2) {
            addCriterion("EVENTDATA not between", value1, value2, "eventdata");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UPDATETIME =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UPDATETIME <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UPDATETIME >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UPDATETIME <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UPDATETIME in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UPDATETIME not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME not between", value1, value2, "updatetime");
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