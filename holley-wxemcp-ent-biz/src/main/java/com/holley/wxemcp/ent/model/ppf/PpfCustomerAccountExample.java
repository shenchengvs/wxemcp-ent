package com.holley.wxemcp.ent.model.ppf;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PpfCustomerAccountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PpfCustomerAccountExample() {
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

        public Criteria andCustomeridIsNull() {
            addCriterion("CUSTOMERID is null");
            return (Criteria) this;
        }

        public Criteria andCustomeridIsNotNull() {
            addCriterion("CUSTOMERID is not null");
            return (Criteria) this;
        }

        public Criteria andCustomeridEqualTo(Integer value) {
            addCriterion("CUSTOMERID =", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotEqualTo(Integer value) {
            addCriterion("CUSTOMERID <>", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridGreaterThan(Integer value) {
            addCriterion("CUSTOMERID >", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridGreaterThanOrEqualTo(Integer value) {
            addCriterion("CUSTOMERID >=", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridLessThan(Integer value) {
            addCriterion("CUSTOMERID <", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridLessThanOrEqualTo(Integer value) {
            addCriterion("CUSTOMERID <=", value, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridIn(List<Integer> values) {
            addCriterion("CUSTOMERID in", values, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotIn(List<Integer> values) {
            addCriterion("CUSTOMERID not in", values, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridBetween(Integer value1, Integer value2) {
            addCriterion("CUSTOMERID between", value1, value2, "customerid");
            return (Criteria) this;
        }

        public Criteria andCustomeridNotBetween(Integer value1, Integer value2) {
            addCriterion("CUSTOMERID not between", value1, value2, "customerid");
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

        public Criteria andTotalmoneyIsNull() {
            addCriterion("TOTALMONEY is null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIsNotNull() {
            addCriterion("TOTALMONEY is not null");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyEqualTo(BigDecimal value) {
            addCriterion("TOTALMONEY =", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotEqualTo(BigDecimal value) {
            addCriterion("TOTALMONEY <>", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThan(BigDecimal value) {
            addCriterion("TOTALMONEY >", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTALMONEY >=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThan(BigDecimal value) {
            addCriterion("TOTALMONEY <", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("TOTALMONEY <=", value, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyIn(List<BigDecimal> values) {
            addCriterion("TOTALMONEY in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotIn(List<BigDecimal> values) {
            addCriterion("TOTALMONEY not in", values, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTALMONEY between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andTotalmoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("TOTALMONEY not between", value1, value2, "totalmoney");
            return (Criteria) this;
        }

        public Criteria andUsablemoneyIsNull() {
            addCriterion("USABLEMONEY is null");
            return (Criteria) this;
        }

        public Criteria andUsablemoneyIsNotNull() {
            addCriterion("USABLEMONEY is not null");
            return (Criteria) this;
        }

        public Criteria andUsablemoneyEqualTo(BigDecimal value) {
            addCriterion("USABLEMONEY =", value, "usablemoney");
            return (Criteria) this;
        }

        public Criteria andUsablemoneyNotEqualTo(BigDecimal value) {
            addCriterion("USABLEMONEY <>", value, "usablemoney");
            return (Criteria) this;
        }

        public Criteria andUsablemoneyGreaterThan(BigDecimal value) {
            addCriterion("USABLEMONEY >", value, "usablemoney");
            return (Criteria) this;
        }

        public Criteria andUsablemoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("USABLEMONEY >=", value, "usablemoney");
            return (Criteria) this;
        }

        public Criteria andUsablemoneyLessThan(BigDecimal value) {
            addCriterion("USABLEMONEY <", value, "usablemoney");
            return (Criteria) this;
        }

        public Criteria andUsablemoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("USABLEMONEY <=", value, "usablemoney");
            return (Criteria) this;
        }

        public Criteria andUsablemoneyIn(List<BigDecimal> values) {
            addCriterion("USABLEMONEY in", values, "usablemoney");
            return (Criteria) this;
        }

        public Criteria andUsablemoneyNotIn(List<BigDecimal> values) {
            addCriterion("USABLEMONEY not in", values, "usablemoney");
            return (Criteria) this;
        }

        public Criteria andUsablemoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USABLEMONEY between", value1, value2, "usablemoney");
            return (Criteria) this;
        }

        public Criteria andUsablemoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USABLEMONEY not between", value1, value2, "usablemoney");
            return (Criteria) this;
        }

        public Criteria andFreezemoneyIsNull() {
            addCriterion("FREEZEMONEY is null");
            return (Criteria) this;
        }

        public Criteria andFreezemoneyIsNotNull() {
            addCriterion("FREEZEMONEY is not null");
            return (Criteria) this;
        }

        public Criteria andFreezemoneyEqualTo(BigDecimal value) {
            addCriterion("FREEZEMONEY =", value, "freezemoney");
            return (Criteria) this;
        }

        public Criteria andFreezemoneyNotEqualTo(BigDecimal value) {
            addCriterion("FREEZEMONEY <>", value, "freezemoney");
            return (Criteria) this;
        }

        public Criteria andFreezemoneyGreaterThan(BigDecimal value) {
            addCriterion("FREEZEMONEY >", value, "freezemoney");
            return (Criteria) this;
        }

        public Criteria andFreezemoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FREEZEMONEY >=", value, "freezemoney");
            return (Criteria) this;
        }

        public Criteria andFreezemoneyLessThan(BigDecimal value) {
            addCriterion("FREEZEMONEY <", value, "freezemoney");
            return (Criteria) this;
        }

        public Criteria andFreezemoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FREEZEMONEY <=", value, "freezemoney");
            return (Criteria) this;
        }

        public Criteria andFreezemoneyIn(List<BigDecimal> values) {
            addCriterion("FREEZEMONEY in", values, "freezemoney");
            return (Criteria) this;
        }

        public Criteria andFreezemoneyNotIn(List<BigDecimal> values) {
            addCriterion("FREEZEMONEY not in", values, "freezemoney");
            return (Criteria) this;
        }

        public Criteria andFreezemoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FREEZEMONEY between", value1, value2, "freezemoney");
            return (Criteria) this;
        }

        public Criteria andFreezemoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FREEZEMONEY not between", value1, value2, "freezemoney");
            return (Criteria) this;
        }

        public Criteria andFreezemoney2IsNull() {
            addCriterion("FREEZEMONEY2 is null");
            return (Criteria) this;
        }

        public Criteria andFreezemoney2IsNotNull() {
            addCriterion("FREEZEMONEY2 is not null");
            return (Criteria) this;
        }

        public Criteria andFreezemoney2EqualTo(BigDecimal value) {
            addCriterion("FREEZEMONEY2 =", value, "freezemoney2");
            return (Criteria) this;
        }

        public Criteria andFreezemoney2NotEqualTo(BigDecimal value) {
            addCriterion("FREEZEMONEY2 <>", value, "freezemoney2");
            return (Criteria) this;
        }

        public Criteria andFreezemoney2GreaterThan(BigDecimal value) {
            addCriterion("FREEZEMONEY2 >", value, "freezemoney2");
            return (Criteria) this;
        }

        public Criteria andFreezemoney2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FREEZEMONEY2 >=", value, "freezemoney2");
            return (Criteria) this;
        }

        public Criteria andFreezemoney2LessThan(BigDecimal value) {
            addCriterion("FREEZEMONEY2 <", value, "freezemoney2");
            return (Criteria) this;
        }

        public Criteria andFreezemoney2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("FREEZEMONEY2 <=", value, "freezemoney2");
            return (Criteria) this;
        }

        public Criteria andFreezemoney2In(List<BigDecimal> values) {
            addCriterion("FREEZEMONEY2 in", values, "freezemoney2");
            return (Criteria) this;
        }

        public Criteria andFreezemoney2NotIn(List<BigDecimal> values) {
            addCriterion("FREEZEMONEY2 not in", values, "freezemoney2");
            return (Criteria) this;
        }

        public Criteria andFreezemoney2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("FREEZEMONEY2 between", value1, value2, "freezemoney2");
            return (Criteria) this;
        }

        public Criteria andFreezemoney2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FREEZEMONEY2 not between", value1, value2, "freezemoney2");
            return (Criteria) this;
        }

        public Criteria andBilldateIsNull() {
            addCriterion("BILLDATE is null");
            return (Criteria) this;
        }

        public Criteria andBilldateIsNotNull() {
            addCriterion("BILLDATE is not null");
            return (Criteria) this;
        }

        public Criteria andBilldateEqualTo(Date value) {
            addCriterion("BILLDATE =", value, "billdate");
            return (Criteria) this;
        }

        public Criteria andBilldateNotEqualTo(Date value) {
            addCriterion("BILLDATE <>", value, "billdate");
            return (Criteria) this;
        }

        public Criteria andBilldateGreaterThan(Date value) {
            addCriterion("BILLDATE >", value, "billdate");
            return (Criteria) this;
        }

        public Criteria andBilldateGreaterThanOrEqualTo(Date value) {
            addCriterion("BILLDATE >=", value, "billdate");
            return (Criteria) this;
        }

        public Criteria andBilldateLessThan(Date value) {
            addCriterion("BILLDATE <", value, "billdate");
            return (Criteria) this;
        }

        public Criteria andBilldateLessThanOrEqualTo(Date value) {
            addCriterion("BILLDATE <=", value, "billdate");
            return (Criteria) this;
        }

        public Criteria andBilldateIn(List<Date> values) {
            addCriterion("BILLDATE in", values, "billdate");
            return (Criteria) this;
        }

        public Criteria andBilldateNotIn(List<Date> values) {
            addCriterion("BILLDATE not in", values, "billdate");
            return (Criteria) this;
        }

        public Criteria andBilldateBetween(Date value1, Date value2) {
            addCriterion("BILLDATE between", value1, value2, "billdate");
            return (Criteria) this;
        }

        public Criteria andBilldateNotBetween(Date value1, Date value2) {
            addCriterion("BILLDATE not between", value1, value2, "billdate");
            return (Criteria) this;
        }

        public Criteria andBilldate2IsNull() {
            addCriterion("BILLDATE2 is null");
            return (Criteria) this;
        }

        public Criteria andBilldate2IsNotNull() {
            addCriterion("BILLDATE2 is not null");
            return (Criteria) this;
        }

        public Criteria andBilldate2EqualTo(Date value) {
            addCriterion("BILLDATE2 =", value, "billdate2");
            return (Criteria) this;
        }

        public Criteria andBilldate2NotEqualTo(Date value) {
            addCriterion("BILLDATE2 <>", value, "billdate2");
            return (Criteria) this;
        }

        public Criteria andBilldate2GreaterThan(Date value) {
            addCriterion("BILLDATE2 >", value, "billdate2");
            return (Criteria) this;
        }

        public Criteria andBilldate2GreaterThanOrEqualTo(Date value) {
            addCriterion("BILLDATE2 >=", value, "billdate2");
            return (Criteria) this;
        }

        public Criteria andBilldate2LessThan(Date value) {
            addCriterion("BILLDATE2 <", value, "billdate2");
            return (Criteria) this;
        }

        public Criteria andBilldate2LessThanOrEqualTo(Date value) {
            addCriterion("BILLDATE2 <=", value, "billdate2");
            return (Criteria) this;
        }

        public Criteria andBilldate2In(List<Date> values) {
            addCriterion("BILLDATE2 in", values, "billdate2");
            return (Criteria) this;
        }

        public Criteria andBilldate2NotIn(List<Date> values) {
            addCriterion("BILLDATE2 not in", values, "billdate2");
            return (Criteria) this;
        }

        public Criteria andBilldate2Between(Date value1, Date value2) {
            addCriterion("BILLDATE2 between", value1, value2, "billdate2");
            return (Criteria) this;
        }

        public Criteria andBilldate2NotBetween(Date value1, Date value2) {
            addCriterion("BILLDATE2 not between", value1, value2, "billdate2");
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