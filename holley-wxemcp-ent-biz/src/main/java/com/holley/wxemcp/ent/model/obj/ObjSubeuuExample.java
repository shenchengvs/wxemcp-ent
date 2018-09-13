package com.holley.wxemcp.ent.model.obj;

import java.util.ArrayList;
import java.util.List;

public class ObjSubeuuExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ObjSubeuuExample() {
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

        public Criteria andSubeuuidIsNull() {
            addCriterion("SUBEUUID is null");
            return (Criteria) this;
        }

        public Criteria andSubeuuidIsNotNull() {
            addCriterion("SUBEUUID is not null");
            return (Criteria) this;
        }

        public Criteria andSubeuuidEqualTo(Integer value) {
            addCriterion("SUBEUUID =", value, "subeuuid");
            return (Criteria) this;
        }

        public Criteria andSubeuuidNotEqualTo(Integer value) {
            addCriterion("SUBEUUID <>", value, "subeuuid");
            return (Criteria) this;
        }

        public Criteria andSubeuuidGreaterThan(Integer value) {
            addCriterion("SUBEUUID >", value, "subeuuid");
            return (Criteria) this;
        }

        public Criteria andSubeuuidGreaterThanOrEqualTo(Integer value) {
            addCriterion("SUBEUUID >=", value, "subeuuid");
            return (Criteria) this;
        }

        public Criteria andSubeuuidLessThan(Integer value) {
            addCriterion("SUBEUUID <", value, "subeuuid");
            return (Criteria) this;
        }

        public Criteria andSubeuuidLessThanOrEqualTo(Integer value) {
            addCriterion("SUBEUUID <=", value, "subeuuid");
            return (Criteria) this;
        }

        public Criteria andSubeuuidIn(List<Integer> values) {
            addCriterion("SUBEUUID in", values, "subeuuid");
            return (Criteria) this;
        }

        public Criteria andSubeuuidNotIn(List<Integer> values) {
            addCriterion("SUBEUUID not in", values, "subeuuid");
            return (Criteria) this;
        }

        public Criteria andSubeuuidBetween(Integer value1, Integer value2) {
            addCriterion("SUBEUUID between", value1, value2, "subeuuid");
            return (Criteria) this;
        }

        public Criteria andSubeuuidNotBetween(Integer value1, Integer value2) {
            addCriterion("SUBEUUID not between", value1, value2, "subeuuid");
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