package com.holley.wxemcp.ent.model.dic;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class DicCityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DicCityExample() {
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

        public Criteria andCityidIsNull() {
            addCriterion("CITYID is null");
            return (Criteria) this;
        }

        public Criteria andCityidIsNotNull() {
            addCriterion("CITYID is not null");
            return (Criteria) this;
        }

        public Criteria andCityidEqualTo(Short value) {
            addCriterion("CITYID =", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotEqualTo(Short value) {
            addCriterion("CITYID <>", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidGreaterThan(Short value) {
            addCriterion("CITYID >", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidGreaterThanOrEqualTo(Short value) {
            addCriterion("CITYID >=", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLessThan(Short value) {
            addCriterion("CITYID <", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidLessThanOrEqualTo(Short value) {
            addCriterion("CITYID <=", value, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidIn(List<Short> values) {
            addCriterion("CITYID in", values, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotIn(List<Short> values) {
            addCriterion("CITYID not in", values, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidBetween(Short value1, Short value2) {
            addCriterion("CITYID between", value1, value2, "cityid");
            return (Criteria) this;
        }

        public Criteria andCityidNotBetween(Short value1, Short value2) {
            addCriterion("CITYID not between", value1, value2, "cityid");
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

        public Criteria andFatheridIsNull() {
            addCriterion("FATHERID is null");
            return (Criteria) this;
        }

        public Criteria andFatheridIsNotNull() {
            addCriterion("FATHERID is not null");
            return (Criteria) this;
        }

        public Criteria andFatheridEqualTo(Short value) {
            addCriterion("FATHERID =", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotEqualTo(Short value) {
            addCriterion("FATHERID <>", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridGreaterThan(Short value) {
            addCriterion("FATHERID >", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridGreaterThanOrEqualTo(Short value) {
            addCriterion("FATHERID >=", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridLessThan(Short value) {
            addCriterion("FATHERID <", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridLessThanOrEqualTo(Short value) {
            addCriterion("FATHERID <=", value, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridIn(List<Short> values) {
            addCriterion("FATHERID in", values, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotIn(List<Short> values) {
            addCriterion("FATHERID not in", values, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridBetween(Short value1, Short value2) {
            addCriterion("FATHERID between", value1, value2, "fatherid");
            return (Criteria) this;
        }

        public Criteria andFatheridNotBetween(Short value1, Short value2) {
            addCriterion("FATHERID not between", value1, value2, "fatherid");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("RANK is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("RANK is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(Short value) {
            addCriterion("RANK =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(Short value) {
            addCriterion("RANK <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(Short value) {
            addCriterion("RANK >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(Short value) {
            addCriterion("RANK >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(Short value) {
            addCriterion("RANK <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(Short value) {
            addCriterion("RANK <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<Short> values) {
            addCriterion("RANK in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<Short> values) {
            addCriterion("RANK not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(Short value1, Short value2) {
            addCriterion("RANK between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(Short value1, Short value2) {
            addCriterion("RANK not between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("LONGITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("LONGITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(BigDecimal value) {
            addCriterion("LONGITUDE =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("LONGITUDE <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(BigDecimal value) {
            addCriterion("LONGITUDE >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LONGITUDE >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(BigDecimal value) {
            addCriterion("LONGITUDE <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LONGITUDE <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<BigDecimal> values) {
            addCriterion("LONGITUDE in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("LONGITUDE not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LONGITUDE between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LONGITUDE not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("LATITUDE is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("LATITUDE is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(BigDecimal value) {
            addCriterion("LATITUDE =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("LATITUDE <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(BigDecimal value) {
            addCriterion("LATITUDE >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("LATITUDE >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(BigDecimal value) {
            addCriterion("LATITUDE <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("LATITUDE <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<BigDecimal> values) {
            addCriterion("LATITUDE in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("LATITUDE not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LATITUDE between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("LATITUDE not between", value1, value2, "latitude");
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