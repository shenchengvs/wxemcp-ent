package com.holley.wxemcp.ent.model.ppf;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PpfCustomerFeeMonthExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PpfCustomerFeeMonthExample() {
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

        public Criteria andDatatimeIsNull() {
            addCriterion("DATATIME is null");
            return (Criteria) this;
        }

        public Criteria andDatatimeIsNotNull() {
            addCriterion("DATATIME is not null");
            return (Criteria) this;
        }

        public Criteria andDatatimeEqualTo(Date value) {
            addCriterion("DATATIME =", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeNotEqualTo(Date value) {
            addCriterion("DATATIME <>", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeGreaterThan(Date value) {
            addCriterion("DATATIME >", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DATATIME >=", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeLessThan(Date value) {
            addCriterion("DATATIME <", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeLessThanOrEqualTo(Date value) {
            addCriterion("DATATIME <=", value, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeIn(List<Date> values) {
            addCriterion("DATATIME in", values, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeNotIn(List<Date> values) {
            addCriterion("DATATIME not in", values, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeBetween(Date value1, Date value2) {
            addCriterion("DATATIME between", value1, value2, "datatime");
            return (Criteria) this;
        }

        public Criteria andDatatimeNotBetween(Date value1, Date value2) {
            addCriterion("DATATIME not between", value1, value2, "datatime");
            return (Criteria) this;
        }

        public Criteria andActualfeeIsNull() {
            addCriterion("ACTUALFEE is null");
            return (Criteria) this;
        }

        public Criteria andActualfeeIsNotNull() {
            addCriterion("ACTUALFEE is not null");
            return (Criteria) this;
        }

        public Criteria andActualfeeEqualTo(BigDecimal value) {
            addCriterion("ACTUALFEE =", value, "actualfee");
            return (Criteria) this;
        }

        public Criteria andActualfeeNotEqualTo(BigDecimal value) {
            addCriterion("ACTUALFEE <>", value, "actualfee");
            return (Criteria) this;
        }

        public Criteria andActualfeeGreaterThan(BigDecimal value) {
            addCriterion("ACTUALFEE >", value, "actualfee");
            return (Criteria) this;
        }

        public Criteria andActualfeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUALFEE >=", value, "actualfee");
            return (Criteria) this;
        }

        public Criteria andActualfeeLessThan(BigDecimal value) {
            addCriterion("ACTUALFEE <", value, "actualfee");
            return (Criteria) this;
        }

        public Criteria andActualfeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUALFEE <=", value, "actualfee");
            return (Criteria) this;
        }

        public Criteria andActualfeeIn(List<BigDecimal> values) {
            addCriterion("ACTUALFEE in", values, "actualfee");
            return (Criteria) this;
        }

        public Criteria andActualfeeNotIn(List<BigDecimal> values) {
            addCriterion("ACTUALFEE not in", values, "actualfee");
            return (Criteria) this;
        }

        public Criteria andActualfeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUALFEE between", value1, value2, "actualfee");
            return (Criteria) this;
        }

        public Criteria andActualfeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUALFEE not between", value1, value2, "actualfee");
            return (Criteria) this;
        }

        public Criteria andFeeIsNull() {
            addCriterion("FEE is null");
            return (Criteria) this;
        }

        public Criteria andFeeIsNotNull() {
            addCriterion("FEE is not null");
            return (Criteria) this;
        }

        public Criteria andFeeEqualTo(BigDecimal value) {
            addCriterion("FEE =", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotEqualTo(BigDecimal value) {
            addCriterion("FEE <>", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThan(BigDecimal value) {
            addCriterion("FEE >", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE >=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThan(BigDecimal value) {
            addCriterion("FEE <", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FEE <=", value, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeIn(List<BigDecimal> values) {
            addCriterion("FEE in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotIn(List<BigDecimal> values) {
            addCriterion("FEE not in", values, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FEE not between", value1, value2, "fee");
            return (Criteria) this;
        }

        public Criteria andBasefeeIsNull() {
            addCriterion("BASEFEE is null");
            return (Criteria) this;
        }

        public Criteria andBasefeeIsNotNull() {
            addCriterion("BASEFEE is not null");
            return (Criteria) this;
        }

        public Criteria andBasefeeEqualTo(BigDecimal value) {
            addCriterion("BASEFEE =", value, "basefee");
            return (Criteria) this;
        }

        public Criteria andBasefeeNotEqualTo(BigDecimal value) {
            addCriterion("BASEFEE <>", value, "basefee");
            return (Criteria) this;
        }

        public Criteria andBasefeeGreaterThan(BigDecimal value) {
            addCriterion("BASEFEE >", value, "basefee");
            return (Criteria) this;
        }

        public Criteria andBasefeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("BASEFEE >=", value, "basefee");
            return (Criteria) this;
        }

        public Criteria andBasefeeLessThan(BigDecimal value) {
            addCriterion("BASEFEE <", value, "basefee");
            return (Criteria) this;
        }

        public Criteria andBasefeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("BASEFEE <=", value, "basefee");
            return (Criteria) this;
        }

        public Criteria andBasefeeIn(List<BigDecimal> values) {
            addCriterion("BASEFEE in", values, "basefee");
            return (Criteria) this;
        }

        public Criteria andBasefeeNotIn(List<BigDecimal> values) {
            addCriterion("BASEFEE not in", values, "basefee");
            return (Criteria) this;
        }

        public Criteria andBasefeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BASEFEE between", value1, value2, "basefee");
            return (Criteria) this;
        }

        public Criteria andBasefeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("BASEFEE not between", value1, value2, "basefee");
            return (Criteria) this;
        }

        public Criteria andFundfeeIsNull() {
            addCriterion("FUNDFEE is null");
            return (Criteria) this;
        }

        public Criteria andFundfeeIsNotNull() {
            addCriterion("FUNDFEE is not null");
            return (Criteria) this;
        }

        public Criteria andFundfeeEqualTo(BigDecimal value) {
            addCriterion("FUNDFEE =", value, "fundfee");
            return (Criteria) this;
        }

        public Criteria andFundfeeNotEqualTo(BigDecimal value) {
            addCriterion("FUNDFEE <>", value, "fundfee");
            return (Criteria) this;
        }

        public Criteria andFundfeeGreaterThan(BigDecimal value) {
            addCriterion("FUNDFEE >", value, "fundfee");
            return (Criteria) this;
        }

        public Criteria andFundfeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FUNDFEE >=", value, "fundfee");
            return (Criteria) this;
        }

        public Criteria andFundfeeLessThan(BigDecimal value) {
            addCriterion("FUNDFEE <", value, "fundfee");
            return (Criteria) this;
        }

        public Criteria andFundfeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FUNDFEE <=", value, "fundfee");
            return (Criteria) this;
        }

        public Criteria andFundfeeIn(List<BigDecimal> values) {
            addCriterion("FUNDFEE in", values, "fundfee");
            return (Criteria) this;
        }

        public Criteria andFundfeeNotIn(List<BigDecimal> values) {
            addCriterion("FUNDFEE not in", values, "fundfee");
            return (Criteria) this;
        }

        public Criteria andFundfeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FUNDFEE between", value1, value2, "fundfee");
            return (Criteria) this;
        }

        public Criteria andFundfeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FUNDFEE not between", value1, value2, "fundfee");
            return (Criteria) this;
        }

        public Criteria andPffeeIsNull() {
            addCriterion("PFFEE is null");
            return (Criteria) this;
        }

        public Criteria andPffeeIsNotNull() {
            addCriterion("PFFEE is not null");
            return (Criteria) this;
        }

        public Criteria andPffeeEqualTo(BigDecimal value) {
            addCriterion("PFFEE =", value, "pffee");
            return (Criteria) this;
        }

        public Criteria andPffeeNotEqualTo(BigDecimal value) {
            addCriterion("PFFEE <>", value, "pffee");
            return (Criteria) this;
        }

        public Criteria andPffeeGreaterThan(BigDecimal value) {
            addCriterion("PFFEE >", value, "pffee");
            return (Criteria) this;
        }

        public Criteria andPffeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PFFEE >=", value, "pffee");
            return (Criteria) this;
        }

        public Criteria andPffeeLessThan(BigDecimal value) {
            addCriterion("PFFEE <", value, "pffee");
            return (Criteria) this;
        }

        public Criteria andPffeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PFFEE <=", value, "pffee");
            return (Criteria) this;
        }

        public Criteria andPffeeIn(List<BigDecimal> values) {
            addCriterion("PFFEE in", values, "pffee");
            return (Criteria) this;
        }

        public Criteria andPffeeNotIn(List<BigDecimal> values) {
            addCriterion("PFFEE not in", values, "pffee");
            return (Criteria) this;
        }

        public Criteria andPffeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PFFEE between", value1, value2, "pffee");
            return (Criteria) this;
        }

        public Criteria andPffeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PFFEE not between", value1, value2, "pffee");
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

        public Criteria andAddtimeIsNull() {
            addCriterion("ADDTIME is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("ADDTIME is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterion("ADDTIME =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterion("ADDTIME <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterion("ADDTIME >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ADDTIME >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterion("ADDTIME <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("ADDTIME <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterion("ADDTIME in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterion("ADDTIME not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterion("ADDTIME between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("ADDTIME not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andBilltimeIsNull() {
            addCriterion("BILLTIME is null");
            return (Criteria) this;
        }

        public Criteria andBilltimeIsNotNull() {
            addCriterion("BILLTIME is not null");
            return (Criteria) this;
        }

        public Criteria andBilltimeEqualTo(Date value) {
            addCriterion("BILLTIME =", value, "billtime");
            return (Criteria) this;
        }

        public Criteria andBilltimeNotEqualTo(Date value) {
            addCriterion("BILLTIME <>", value, "billtime");
            return (Criteria) this;
        }

        public Criteria andBilltimeGreaterThan(Date value) {
            addCriterion("BILLTIME >", value, "billtime");
            return (Criteria) this;
        }

        public Criteria andBilltimeGreaterThanOrEqualTo(Date value) {
            addCriterion("BILLTIME >=", value, "billtime");
            return (Criteria) this;
        }

        public Criteria andBilltimeLessThan(Date value) {
            addCriterion("BILLTIME <", value, "billtime");
            return (Criteria) this;
        }

        public Criteria andBilltimeLessThanOrEqualTo(Date value) {
            addCriterion("BILLTIME <=", value, "billtime");
            return (Criteria) this;
        }

        public Criteria andBilltimeIn(List<Date> values) {
            addCriterion("BILLTIME in", values, "billtime");
            return (Criteria) this;
        }

        public Criteria andBilltimeNotIn(List<Date> values) {
            addCriterion("BILLTIME not in", values, "billtime");
            return (Criteria) this;
        }

        public Criteria andBilltimeBetween(Date value1, Date value2) {
            addCriterion("BILLTIME between", value1, value2, "billtime");
            return (Criteria) this;
        }

        public Criteria andBilltimeNotBetween(Date value1, Date value2) {
            addCriterion("BILLTIME not between", value1, value2, "billtime");
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