package com.holley.wxemcp.ent.model.ppf;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PpfControlCmdExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PpfControlCmdExample() {
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

        public Criteria andCmdtimeIsNull() {
            addCriterion("CMDTIME is null");
            return (Criteria) this;
        }

        public Criteria andCmdtimeIsNotNull() {
            addCriterion("CMDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andCmdtimeEqualTo(Date value) {
            addCriterion("CMDTIME =", value, "cmdtime");
            return (Criteria) this;
        }

        public Criteria andCmdtimeNotEqualTo(Date value) {
            addCriterion("CMDTIME <>", value, "cmdtime");
            return (Criteria) this;
        }

        public Criteria andCmdtimeGreaterThan(Date value) {
            addCriterion("CMDTIME >", value, "cmdtime");
            return (Criteria) this;
        }

        public Criteria andCmdtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CMDTIME >=", value, "cmdtime");
            return (Criteria) this;
        }

        public Criteria andCmdtimeLessThan(Date value) {
            addCriterion("CMDTIME <", value, "cmdtime");
            return (Criteria) this;
        }

        public Criteria andCmdtimeLessThanOrEqualTo(Date value) {
            addCriterion("CMDTIME <=", value, "cmdtime");
            return (Criteria) this;
        }

        public Criteria andCmdtimeIn(List<Date> values) {
            addCriterion("CMDTIME in", values, "cmdtime");
            return (Criteria) this;
        }

        public Criteria andCmdtimeNotIn(List<Date> values) {
            addCriterion("CMDTIME not in", values, "cmdtime");
            return (Criteria) this;
        }

        public Criteria andCmdtimeBetween(Date value1, Date value2) {
            addCriterion("CMDTIME between", value1, value2, "cmdtime");
            return (Criteria) this;
        }

        public Criteria andCmdtimeNotBetween(Date value1, Date value2) {
            addCriterion("CMDTIME not between", value1, value2, "cmdtime");
            return (Criteria) this;
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

        public Criteria andCmdtypeIsNull() {
            addCriterion("CMDTYPE is null");
            return (Criteria) this;
        }

        public Criteria andCmdtypeIsNotNull() {
            addCriterion("CMDTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andCmdtypeEqualTo(Short value) {
            addCriterion("CMDTYPE =", value, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andCmdtypeNotEqualTo(Short value) {
            addCriterion("CMDTYPE <>", value, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andCmdtypeGreaterThan(Short value) {
            addCriterion("CMDTYPE >", value, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andCmdtypeGreaterThanOrEqualTo(Short value) {
            addCriterion("CMDTYPE >=", value, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andCmdtypeLessThan(Short value) {
            addCriterion("CMDTYPE <", value, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andCmdtypeLessThanOrEqualTo(Short value) {
            addCriterion("CMDTYPE <=", value, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andCmdtypeIn(List<Short> values) {
            addCriterion("CMDTYPE in", values, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andCmdtypeNotIn(List<Short> values) {
            addCriterion("CMDTYPE not in", values, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andCmdtypeBetween(Short value1, Short value2) {
            addCriterion("CMDTYPE between", value1, value2, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andCmdtypeNotBetween(Short value1, Short value2) {
            addCriterion("CMDTYPE not between", value1, value2, "cmdtype");
            return (Criteria) this;
        }

        public Criteria andParamsIsNull() {
            addCriterion("PARAMS is null");
            return (Criteria) this;
        }

        public Criteria andParamsIsNotNull() {
            addCriterion("PARAMS is not null");
            return (Criteria) this;
        }

        public Criteria andParamsEqualTo(String value) {
            addCriterion("PARAMS =", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotEqualTo(String value) {
            addCriterion("PARAMS <>", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThan(String value) {
            addCriterion("PARAMS >", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsGreaterThanOrEqualTo(String value) {
            addCriterion("PARAMS >=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThan(String value) {
            addCriterion("PARAMS <", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLessThanOrEqualTo(String value) {
            addCriterion("PARAMS <=", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsLike(String value) {
            addCriterion("PARAMS like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotLike(String value) {
            addCriterion("PARAMS not like", value, "params");
            return (Criteria) this;
        }

        public Criteria andParamsIn(List<String> values) {
            addCriterion("PARAMS in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotIn(List<String> values) {
            addCriterion("PARAMS not in", values, "params");
            return (Criteria) this;
        }

        public Criteria andParamsBetween(String value1, String value2) {
            addCriterion("PARAMS between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andParamsNotBetween(String value1, String value2) {
            addCriterion("PARAMS not between", value1, value2, "params");
            return (Criteria) this;
        }

        public Criteria andOperatetypeIsNull() {
            addCriterion("OPERATETYPE is null");
            return (Criteria) this;
        }

        public Criteria andOperatetypeIsNotNull() {
            addCriterion("OPERATETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andOperatetypeEqualTo(Short value) {
            addCriterion("OPERATETYPE =", value, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeNotEqualTo(Short value) {
            addCriterion("OPERATETYPE <>", value, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeGreaterThan(Short value) {
            addCriterion("OPERATETYPE >", value, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeGreaterThanOrEqualTo(Short value) {
            addCriterion("OPERATETYPE >=", value, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeLessThan(Short value) {
            addCriterion("OPERATETYPE <", value, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeLessThanOrEqualTo(Short value) {
            addCriterion("OPERATETYPE <=", value, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeIn(List<Short> values) {
            addCriterion("OPERATETYPE in", values, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeNotIn(List<Short> values) {
            addCriterion("OPERATETYPE not in", values, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeBetween(Short value1, Short value2) {
            addCriterion("OPERATETYPE between", value1, value2, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetypeNotBetween(Short value1, Short value2) {
            addCriterion("OPERATETYPE not between", value1, value2, "operatetype");
            return (Criteria) this;
        }

        public Criteria andOperatetimeIsNull() {
            addCriterion("OPERATETIME is null");
            return (Criteria) this;
        }

        public Criteria andOperatetimeIsNotNull() {
            addCriterion("OPERATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andOperatetimeEqualTo(Date value) {
            addCriterion("OPERATETIME =", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeNotEqualTo(Date value) {
            addCriterion("OPERATETIME <>", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeGreaterThan(Date value) {
            addCriterion("OPERATETIME >", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OPERATETIME >=", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeLessThan(Date value) {
            addCriterion("OPERATETIME <", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeLessThanOrEqualTo(Date value) {
            addCriterion("OPERATETIME <=", value, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeIn(List<Date> values) {
            addCriterion("OPERATETIME in", values, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeNotIn(List<Date> values) {
            addCriterion("OPERATETIME not in", values, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeBetween(Date value1, Date value2) {
            addCriterion("OPERATETIME between", value1, value2, "operatetime");
            return (Criteria) this;
        }

        public Criteria andOperatetimeNotBetween(Date value1, Date value2) {
            addCriterion("OPERATETIME not between", value1, value2, "operatetime");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("RESULT is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(Short value) {
            addCriterion("RESULT =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(Short value) {
            addCriterion("RESULT <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(Short value) {
            addCriterion("RESULT >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(Short value) {
            addCriterion("RESULT >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(Short value) {
            addCriterion("RESULT <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(Short value) {
            addCriterion("RESULT <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<Short> values) {
            addCriterion("RESULT in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<Short> values) {
            addCriterion("RESULT not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(Short value1, Short value2) {
            addCriterion("RESULT between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(Short value1, Short value2) {
            addCriterion("RESULT not between", value1, value2, "result");
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