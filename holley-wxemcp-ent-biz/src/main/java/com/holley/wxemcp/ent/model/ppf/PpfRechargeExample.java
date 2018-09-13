package com.holley.wxemcp.ent.model.ppf;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PpfRechargeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PpfRechargeExample() {
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

        public Criteria andRechargeidIsNull() {
            addCriterion("RECHARGEID is null");
            return (Criteria) this;
        }

        public Criteria andRechargeidIsNotNull() {
            addCriterion("RECHARGEID is not null");
            return (Criteria) this;
        }

        public Criteria andRechargeidEqualTo(Integer value) {
            addCriterion("RECHARGEID =", value, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidNotEqualTo(Integer value) {
            addCriterion("RECHARGEID <>", value, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidGreaterThan(Integer value) {
            addCriterion("RECHARGEID >", value, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidGreaterThanOrEqualTo(Integer value) {
            addCriterion("RECHARGEID >=", value, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidLessThan(Integer value) {
            addCriterion("RECHARGEID <", value, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidLessThanOrEqualTo(Integer value) {
            addCriterion("RECHARGEID <=", value, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidIn(List<Integer> values) {
            addCriterion("RECHARGEID in", values, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidNotIn(List<Integer> values) {
            addCriterion("RECHARGEID not in", values, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidBetween(Integer value1, Integer value2) {
            addCriterion("RECHARGEID between", value1, value2, "rechargeid");
            return (Criteria) this;
        }

        public Criteria andRechargeidNotBetween(Integer value1, Integer value2) {
            addCriterion("RECHARGEID not between", value1, value2, "rechargeid");
            return (Criteria) this;
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

        public Criteria andPayMoneyIsNull() {
            addCriterion("PAY_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIsNotNull() {
            addCriterion("PAY_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andPayMoneyEqualTo(BigDecimal value) {
            addCriterion("PAY_MONEY =", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotEqualTo(BigDecimal value) {
            addCriterion("PAY_MONEY <>", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyGreaterThan(BigDecimal value) {
            addCriterion("PAY_MONEY >", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("PAY_MONEY >=", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLessThan(BigDecimal value) {
            addCriterion("PAY_MONEY <", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("PAY_MONEY <=", value, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyIn(List<BigDecimal> values) {
            addCriterion("PAY_MONEY in", values, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotIn(List<BigDecimal> values) {
            addCriterion("PAY_MONEY not in", values, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAY_MONEY between", value1, value2, "payMoney");
            return (Criteria) this;
        }

        public Criteria andPayMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("PAY_MONEY not between", value1, value2, "payMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyIsNull() {
            addCriterion("ACTUAL_MONEY is null");
            return (Criteria) this;
        }

        public Criteria andActualMoneyIsNotNull() {
            addCriterion("ACTUAL_MONEY is not null");
            return (Criteria) this;
        }

        public Criteria andActualMoneyEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_MONEY =", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyNotEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_MONEY <>", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyGreaterThan(BigDecimal value) {
            addCriterion("ACTUAL_MONEY >", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_MONEY >=", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyLessThan(BigDecimal value) {
            addCriterion("ACTUAL_MONEY <", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ACTUAL_MONEY <=", value, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_MONEY in", values, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyNotIn(List<BigDecimal> values) {
            addCriterion("ACTUAL_MONEY not in", values, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_MONEY between", value1, value2, "actualMoney");
            return (Criteria) this;
        }

        public Criteria andActualMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ACTUAL_MONEY not between", value1, value2, "actualMoney");
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

        public Criteria andAccountIsNull() {
            addCriterion("ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("ACCOUNT =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("ACCOUNT <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("ACCOUNT >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("ACCOUNT <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("ACCOUNT like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("ACCOUNT not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("ACCOUNT in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("ACCOUNT not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("ACCOUNT between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT not between", value1, value2, "account");
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

        public Criteria andPaywayIsNull() {
            addCriterion("PAYWAY is null");
            return (Criteria) this;
        }

        public Criteria andPaywayIsNotNull() {
            addCriterion("PAYWAY is not null");
            return (Criteria) this;
        }

        public Criteria andPaywayEqualTo(Short value) {
            addCriterion("PAYWAY =", value, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayNotEqualTo(Short value) {
            addCriterion("PAYWAY <>", value, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayGreaterThan(Short value) {
            addCriterion("PAYWAY >", value, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayGreaterThanOrEqualTo(Short value) {
            addCriterion("PAYWAY >=", value, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayLessThan(Short value) {
            addCriterion("PAYWAY <", value, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayLessThanOrEqualTo(Short value) {
            addCriterion("PAYWAY <=", value, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayIn(List<Short> values) {
            addCriterion("PAYWAY in", values, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayNotIn(List<Short> values) {
            addCriterion("PAYWAY not in", values, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayBetween(Short value1, Short value2) {
            addCriterion("PAYWAY between", value1, value2, "payway");
            return (Criteria) this;
        }

        public Criteria andPaywayNotBetween(Short value1, Short value2) {
            addCriterion("PAYWAY not between", value1, value2, "payway");
            return (Criteria) this;
        }

        public Criteria andTradenoIsNull() {
            addCriterion("TRADENO is null");
            return (Criteria) this;
        }

        public Criteria andTradenoIsNotNull() {
            addCriterion("TRADENO is not null");
            return (Criteria) this;
        }

        public Criteria andTradenoEqualTo(String value) {
            addCriterion("TRADENO =", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoNotEqualTo(String value) {
            addCriterion("TRADENO <>", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoGreaterThan(String value) {
            addCriterion("TRADENO >", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoGreaterThanOrEqualTo(String value) {
            addCriterion("TRADENO >=", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoLessThan(String value) {
            addCriterion("TRADENO <", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoLessThanOrEqualTo(String value) {
            addCriterion("TRADENO <=", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoLike(String value) {
            addCriterion("TRADENO like", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoNotLike(String value) {
            addCriterion("TRADENO not like", value, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoIn(List<String> values) {
            addCriterion("TRADENO in", values, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoNotIn(List<String> values) {
            addCriterion("TRADENO not in", values, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoBetween(String value1, String value2) {
            addCriterion("TRADENO between", value1, value2, "tradeno");
            return (Criteria) this;
        }

        public Criteria andTradenoNotBetween(String value1, String value2) {
            addCriterion("TRADENO not between", value1, value2, "tradeno");
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