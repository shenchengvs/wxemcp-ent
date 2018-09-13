package com.holley.wxemcp.ent.model.ppf;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PpfPriceRuleOtherExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PpfPriceRuleOtherExample() {
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

        public Criteria andPriceidIsNull() {
            addCriterion("PRICEID is null");
            return (Criteria) this;
        }

        public Criteria andPriceidIsNotNull() {
            addCriterion("PRICEID is not null");
            return (Criteria) this;
        }

        public Criteria andPriceidEqualTo(Integer value) {
            addCriterion("PRICEID =", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidNotEqualTo(Integer value) {
            addCriterion("PRICEID <>", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidGreaterThan(Integer value) {
            addCriterion("PRICEID >", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidGreaterThanOrEqualTo(Integer value) {
            addCriterion("PRICEID >=", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidLessThan(Integer value) {
            addCriterion("PRICEID <", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidLessThanOrEqualTo(Integer value) {
            addCriterion("PRICEID <=", value, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidIn(List<Integer> values) {
            addCriterion("PRICEID in", values, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidNotIn(List<Integer> values) {
            addCriterion("PRICEID not in", values, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidBetween(Integer value1, Integer value2) {
            addCriterion("PRICEID between", value1, value2, "priceid");
            return (Criteria) this;
        }

        public Criteria andPriceidNotBetween(Integer value1, Integer value2) {
            addCriterion("PRICEID not between", value1, value2, "priceid");
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

        public Criteria andTypeIsNull() {
            addCriterion("TYPE is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Short value) {
            addCriterion("TYPE =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Short value) {
            addCriterion("TYPE <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Short value) {
            addCriterion("TYPE >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Short value) {
            addCriterion("TYPE >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Short value) {
            addCriterion("TYPE <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Short value) {
            addCriterion("TYPE <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Short> values) {
            addCriterion("TYPE in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Short> values) {
            addCriterion("TYPE not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Short value1, Short value2) {
            addCriterion("TYPE between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Short value1, Short value2) {
            addCriterion("TYPE not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andEnergytypeIsNull() {
            addCriterion("ENERGYTYPE is null");
            return (Criteria) this;
        }

        public Criteria andEnergytypeIsNotNull() {
            addCriterion("ENERGYTYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEnergytypeEqualTo(Short value) {
            addCriterion("ENERGYTYPE =", value, "energytype");
            return (Criteria) this;
        }

        public Criteria andEnergytypeNotEqualTo(Short value) {
            addCriterion("ENERGYTYPE <>", value, "energytype");
            return (Criteria) this;
        }

        public Criteria andEnergytypeGreaterThan(Short value) {
            addCriterion("ENERGYTYPE >", value, "energytype");
            return (Criteria) this;
        }

        public Criteria andEnergytypeGreaterThanOrEqualTo(Short value) {
            addCriterion("ENERGYTYPE >=", value, "energytype");
            return (Criteria) this;
        }

        public Criteria andEnergytypeLessThan(Short value) {
            addCriterion("ENERGYTYPE <", value, "energytype");
            return (Criteria) this;
        }

        public Criteria andEnergytypeLessThanOrEqualTo(Short value) {
            addCriterion("ENERGYTYPE <=", value, "energytype");
            return (Criteria) this;
        }

        public Criteria andEnergytypeIn(List<Short> values) {
            addCriterion("ENERGYTYPE in", values, "energytype");
            return (Criteria) this;
        }

        public Criteria andEnergytypeNotIn(List<Short> values) {
            addCriterion("ENERGYTYPE not in", values, "energytype");
            return (Criteria) this;
        }

        public Criteria andEnergytypeBetween(Short value1, Short value2) {
            addCriterion("ENERGYTYPE between", value1, value2, "energytype");
            return (Criteria) this;
        }

        public Criteria andEnergytypeNotBetween(Short value1, Short value2) {
            addCriterion("ENERGYTYPE not between", value1, value2, "energytype");
            return (Criteria) this;
        }

        public Criteria andValue1IsNull() {
            addCriterion("VALUE1 is null");
            return (Criteria) this;
        }

        public Criteria andValue1IsNotNull() {
            addCriterion("VALUE1 is not null");
            return (Criteria) this;
        }

        public Criteria andValue1EqualTo(BigDecimal value) {
            addCriterion("VALUE1 =", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1NotEqualTo(BigDecimal value) {
            addCriterion("VALUE1 <>", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1GreaterThan(BigDecimal value) {
            addCriterion("VALUE1 >", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("VALUE1 >=", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1LessThan(BigDecimal value) {
            addCriterion("VALUE1 <", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("VALUE1 <=", value, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1In(List<BigDecimal> values) {
            addCriterion("VALUE1 in", values, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1NotIn(List<BigDecimal> values) {
            addCriterion("VALUE1 not in", values, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("VALUE1 between", value1, value2, "value1");
            return (Criteria) this;
        }

        public Criteria andValue1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VALUE1 not between", value1, value2, "value1");
            return (Criteria) this;
        }

        public Criteria andValue2IsNull() {
            addCriterion("VALUE2 is null");
            return (Criteria) this;
        }

        public Criteria andValue2IsNotNull() {
            addCriterion("VALUE2 is not null");
            return (Criteria) this;
        }

        public Criteria andValue2EqualTo(BigDecimal value) {
            addCriterion("VALUE2 =", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2NotEqualTo(BigDecimal value) {
            addCriterion("VALUE2 <>", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2GreaterThan(BigDecimal value) {
            addCriterion("VALUE2 >", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("VALUE2 >=", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2LessThan(BigDecimal value) {
            addCriterion("VALUE2 <", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2LessThanOrEqualTo(BigDecimal value) {
            addCriterion("VALUE2 <=", value, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2In(List<BigDecimal> values) {
            addCriterion("VALUE2 in", values, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2NotIn(List<BigDecimal> values) {
            addCriterion("VALUE2 not in", values, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("VALUE2 between", value1, value2, "value2");
            return (Criteria) this;
        }

        public Criteria andValue2NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VALUE2 not between", value1, value2, "value2");
            return (Criteria) this;
        }

        public Criteria andValue3IsNull() {
            addCriterion("VALUE3 is null");
            return (Criteria) this;
        }

        public Criteria andValue3IsNotNull() {
            addCriterion("VALUE3 is not null");
            return (Criteria) this;
        }

        public Criteria andValue3EqualTo(BigDecimal value) {
            addCriterion("VALUE3 =", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3NotEqualTo(BigDecimal value) {
            addCriterion("VALUE3 <>", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3GreaterThan(BigDecimal value) {
            addCriterion("VALUE3 >", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("VALUE3 >=", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3LessThan(BigDecimal value) {
            addCriterion("VALUE3 <", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3LessThanOrEqualTo(BigDecimal value) {
            addCriterion("VALUE3 <=", value, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3In(List<BigDecimal> values) {
            addCriterion("VALUE3 in", values, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3NotIn(List<BigDecimal> values) {
            addCriterion("VALUE3 not in", values, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("VALUE3 between", value1, value2, "value3");
            return (Criteria) this;
        }

        public Criteria andValue3NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VALUE3 not between", value1, value2, "value3");
            return (Criteria) this;
        }

        public Criteria andValue4IsNull() {
            addCriterion("VALUE4 is null");
            return (Criteria) this;
        }

        public Criteria andValue4IsNotNull() {
            addCriterion("VALUE4 is not null");
            return (Criteria) this;
        }

        public Criteria andValue4EqualTo(BigDecimal value) {
            addCriterion("VALUE4 =", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4NotEqualTo(BigDecimal value) {
            addCriterion("VALUE4 <>", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4GreaterThan(BigDecimal value) {
            addCriterion("VALUE4 >", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("VALUE4 >=", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4LessThan(BigDecimal value) {
            addCriterion("VALUE4 <", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4LessThanOrEqualTo(BigDecimal value) {
            addCriterion("VALUE4 <=", value, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4In(List<BigDecimal> values) {
            addCriterion("VALUE4 in", values, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4NotIn(List<BigDecimal> values) {
            addCriterion("VALUE4 not in", values, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("VALUE4 between", value1, value2, "value4");
            return (Criteria) this;
        }

        public Criteria andValue4NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VALUE4 not between", value1, value2, "value4");
            return (Criteria) this;
        }

        public Criteria andValue5IsNull() {
            addCriterion("VALUE5 is null");
            return (Criteria) this;
        }

        public Criteria andValue5IsNotNull() {
            addCriterion("VALUE5 is not null");
            return (Criteria) this;
        }

        public Criteria andValue5EqualTo(BigDecimal value) {
            addCriterion("VALUE5 =", value, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5NotEqualTo(BigDecimal value) {
            addCriterion("VALUE5 <>", value, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5GreaterThan(BigDecimal value) {
            addCriterion("VALUE5 >", value, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("VALUE5 >=", value, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5LessThan(BigDecimal value) {
            addCriterion("VALUE5 <", value, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5LessThanOrEqualTo(BigDecimal value) {
            addCriterion("VALUE5 <=", value, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5In(List<BigDecimal> values) {
            addCriterion("VALUE5 in", values, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5NotIn(List<BigDecimal> values) {
            addCriterion("VALUE5 not in", values, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("VALUE5 between", value1, value2, "value5");
            return (Criteria) this;
        }

        public Criteria andValue5NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("VALUE5 not between", value1, value2, "value5");
            return (Criteria) this;
        }

        public Criteria andEnergy1IsNull() {
            addCriterion("ENERGY1 is null");
            return (Criteria) this;
        }

        public Criteria andEnergy1IsNotNull() {
            addCriterion("ENERGY1 is not null");
            return (Criteria) this;
        }

        public Criteria andEnergy1EqualTo(Long value) {
            addCriterion("ENERGY1 =", value, "energy1");
            return (Criteria) this;
        }

        public Criteria andEnergy1NotEqualTo(Long value) {
            addCriterion("ENERGY1 <>", value, "energy1");
            return (Criteria) this;
        }

        public Criteria andEnergy1GreaterThan(Long value) {
            addCriterion("ENERGY1 >", value, "energy1");
            return (Criteria) this;
        }

        public Criteria andEnergy1GreaterThanOrEqualTo(Long value) {
            addCriterion("ENERGY1 >=", value, "energy1");
            return (Criteria) this;
        }

        public Criteria andEnergy1LessThan(Long value) {
            addCriterion("ENERGY1 <", value, "energy1");
            return (Criteria) this;
        }

        public Criteria andEnergy1LessThanOrEqualTo(Long value) {
            addCriterion("ENERGY1 <=", value, "energy1");
            return (Criteria) this;
        }

        public Criteria andEnergy1In(List<Long> values) {
            addCriterion("ENERGY1 in", values, "energy1");
            return (Criteria) this;
        }

        public Criteria andEnergy1NotIn(List<Long> values) {
            addCriterion("ENERGY1 not in", values, "energy1");
            return (Criteria) this;
        }

        public Criteria andEnergy1Between(Long value1, Long value2) {
            addCriterion("ENERGY1 between", value1, value2, "energy1");
            return (Criteria) this;
        }

        public Criteria andEnergy1NotBetween(Long value1, Long value2) {
            addCriterion("ENERGY1 not between", value1, value2, "energy1");
            return (Criteria) this;
        }

        public Criteria andEnergy2IsNull() {
            addCriterion("ENERGY2 is null");
            return (Criteria) this;
        }

        public Criteria andEnergy2IsNotNull() {
            addCriterion("ENERGY2 is not null");
            return (Criteria) this;
        }

        public Criteria andEnergy2EqualTo(Long value) {
            addCriterion("ENERGY2 =", value, "energy2");
            return (Criteria) this;
        }

        public Criteria andEnergy2NotEqualTo(Long value) {
            addCriterion("ENERGY2 <>", value, "energy2");
            return (Criteria) this;
        }

        public Criteria andEnergy2GreaterThan(Long value) {
            addCriterion("ENERGY2 >", value, "energy2");
            return (Criteria) this;
        }

        public Criteria andEnergy2GreaterThanOrEqualTo(Long value) {
            addCriterion("ENERGY2 >=", value, "energy2");
            return (Criteria) this;
        }

        public Criteria andEnergy2LessThan(Long value) {
            addCriterion("ENERGY2 <", value, "energy2");
            return (Criteria) this;
        }

        public Criteria andEnergy2LessThanOrEqualTo(Long value) {
            addCriterion("ENERGY2 <=", value, "energy2");
            return (Criteria) this;
        }

        public Criteria andEnergy2In(List<Long> values) {
            addCriterion("ENERGY2 in", values, "energy2");
            return (Criteria) this;
        }

        public Criteria andEnergy2NotIn(List<Long> values) {
            addCriterion("ENERGY2 not in", values, "energy2");
            return (Criteria) this;
        }

        public Criteria andEnergy2Between(Long value1, Long value2) {
            addCriterion("ENERGY2 between", value1, value2, "energy2");
            return (Criteria) this;
        }

        public Criteria andEnergy2NotBetween(Long value1, Long value2) {
            addCriterion("ENERGY2 not between", value1, value2, "energy2");
            return (Criteria) this;
        }

        public Criteria andEnergy3IsNull() {
            addCriterion("ENERGY3 is null");
            return (Criteria) this;
        }

        public Criteria andEnergy3IsNotNull() {
            addCriterion("ENERGY3 is not null");
            return (Criteria) this;
        }

        public Criteria andEnergy3EqualTo(Long value) {
            addCriterion("ENERGY3 =", value, "energy3");
            return (Criteria) this;
        }

        public Criteria andEnergy3NotEqualTo(Long value) {
            addCriterion("ENERGY3 <>", value, "energy3");
            return (Criteria) this;
        }

        public Criteria andEnergy3GreaterThan(Long value) {
            addCriterion("ENERGY3 >", value, "energy3");
            return (Criteria) this;
        }

        public Criteria andEnergy3GreaterThanOrEqualTo(Long value) {
            addCriterion("ENERGY3 >=", value, "energy3");
            return (Criteria) this;
        }

        public Criteria andEnergy3LessThan(Long value) {
            addCriterion("ENERGY3 <", value, "energy3");
            return (Criteria) this;
        }

        public Criteria andEnergy3LessThanOrEqualTo(Long value) {
            addCriterion("ENERGY3 <=", value, "energy3");
            return (Criteria) this;
        }

        public Criteria andEnergy3In(List<Long> values) {
            addCriterion("ENERGY3 in", values, "energy3");
            return (Criteria) this;
        }

        public Criteria andEnergy3NotIn(List<Long> values) {
            addCriterion("ENERGY3 not in", values, "energy3");
            return (Criteria) this;
        }

        public Criteria andEnergy3Between(Long value1, Long value2) {
            addCriterion("ENERGY3 between", value1, value2, "energy3");
            return (Criteria) this;
        }

        public Criteria andEnergy3NotBetween(Long value1, Long value2) {
            addCriterion("ENERGY3 not between", value1, value2, "energy3");
            return (Criteria) this;
        }

        public Criteria andEnergy4IsNull() {
            addCriterion("ENERGY4 is null");
            return (Criteria) this;
        }

        public Criteria andEnergy4IsNotNull() {
            addCriterion("ENERGY4 is not null");
            return (Criteria) this;
        }

        public Criteria andEnergy4EqualTo(Long value) {
            addCriterion("ENERGY4 =", value, "energy4");
            return (Criteria) this;
        }

        public Criteria andEnergy4NotEqualTo(Long value) {
            addCriterion("ENERGY4 <>", value, "energy4");
            return (Criteria) this;
        }

        public Criteria andEnergy4GreaterThan(Long value) {
            addCriterion("ENERGY4 >", value, "energy4");
            return (Criteria) this;
        }

        public Criteria andEnergy4GreaterThanOrEqualTo(Long value) {
            addCriterion("ENERGY4 >=", value, "energy4");
            return (Criteria) this;
        }

        public Criteria andEnergy4LessThan(Long value) {
            addCriterion("ENERGY4 <", value, "energy4");
            return (Criteria) this;
        }

        public Criteria andEnergy4LessThanOrEqualTo(Long value) {
            addCriterion("ENERGY4 <=", value, "energy4");
            return (Criteria) this;
        }

        public Criteria andEnergy4In(List<Long> values) {
            addCriterion("ENERGY4 in", values, "energy4");
            return (Criteria) this;
        }

        public Criteria andEnergy4NotIn(List<Long> values) {
            addCriterion("ENERGY4 not in", values, "energy4");
            return (Criteria) this;
        }

        public Criteria andEnergy4Between(Long value1, Long value2) {
            addCriterion("ENERGY4 between", value1, value2, "energy4");
            return (Criteria) this;
        }

        public Criteria andEnergy4NotBetween(Long value1, Long value2) {
            addCriterion("ENERGY4 not between", value1, value2, "energy4");
            return (Criteria) this;
        }

        public Criteria andEnergy5IsNull() {
            addCriterion("ENERGY5 is null");
            return (Criteria) this;
        }

        public Criteria andEnergy5IsNotNull() {
            addCriterion("ENERGY5 is not null");
            return (Criteria) this;
        }

        public Criteria andEnergy5EqualTo(Long value) {
            addCriterion("ENERGY5 =", value, "energy5");
            return (Criteria) this;
        }

        public Criteria andEnergy5NotEqualTo(Long value) {
            addCriterion("ENERGY5 <>", value, "energy5");
            return (Criteria) this;
        }

        public Criteria andEnergy5GreaterThan(Long value) {
            addCriterion("ENERGY5 >", value, "energy5");
            return (Criteria) this;
        }

        public Criteria andEnergy5GreaterThanOrEqualTo(Long value) {
            addCriterion("ENERGY5 >=", value, "energy5");
            return (Criteria) this;
        }

        public Criteria andEnergy5LessThan(Long value) {
            addCriterion("ENERGY5 <", value, "energy5");
            return (Criteria) this;
        }

        public Criteria andEnergy5LessThanOrEqualTo(Long value) {
            addCriterion("ENERGY5 <=", value, "energy5");
            return (Criteria) this;
        }

        public Criteria andEnergy5In(List<Long> values) {
            addCriterion("ENERGY5 in", values, "energy5");
            return (Criteria) this;
        }

        public Criteria andEnergy5NotIn(List<Long> values) {
            addCriterion("ENERGY5 not in", values, "energy5");
            return (Criteria) this;
        }

        public Criteria andEnergy5Between(Long value1, Long value2) {
            addCriterion("ENERGY5 between", value1, value2, "energy5");
            return (Criteria) this;
        }

        public Criteria andEnergy5NotBetween(Long value1, Long value2) {
            addCriterion("ENERGY5 not between", value1, value2, "energy5");
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