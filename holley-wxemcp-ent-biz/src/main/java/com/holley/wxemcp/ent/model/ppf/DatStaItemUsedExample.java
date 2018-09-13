package com.holley.wxemcp.ent.model.ppf;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatStaItemUsedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DatStaItemUsedExample() {
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

        public Criteria andCircletypeidIsNull() {
            addCriterion("CIRCLETYPEID is null");
            return (Criteria) this;
        }

        public Criteria andCircletypeidIsNotNull() {
            addCriterion("CIRCLETYPEID is not null");
            return (Criteria) this;
        }

        public Criteria andCircletypeidEqualTo(Short value) {
            addCriterion("CIRCLETYPEID =", value, "circletypeid");
            return (Criteria) this;
        }

        public Criteria andCircletypeidNotEqualTo(Short value) {
            addCriterion("CIRCLETYPEID <>", value, "circletypeid");
            return (Criteria) this;
        }

        public Criteria andCircletypeidGreaterThan(Short value) {
            addCriterion("CIRCLETYPEID >", value, "circletypeid");
            return (Criteria) this;
        }

        public Criteria andCircletypeidGreaterThanOrEqualTo(Short value) {
            addCriterion("CIRCLETYPEID >=", value, "circletypeid");
            return (Criteria) this;
        }

        public Criteria andCircletypeidLessThan(Short value) {
            addCriterion("CIRCLETYPEID <", value, "circletypeid");
            return (Criteria) this;
        }

        public Criteria andCircletypeidLessThanOrEqualTo(Short value) {
            addCriterion("CIRCLETYPEID <=", value, "circletypeid");
            return (Criteria) this;
        }

        public Criteria andCircletypeidIn(List<Short> values) {
            addCriterion("CIRCLETYPEID in", values, "circletypeid");
            return (Criteria) this;
        }

        public Criteria andCircletypeidNotIn(List<Short> values) {
            addCriterion("CIRCLETYPEID not in", values, "circletypeid");
            return (Criteria) this;
        }

        public Criteria andCircletypeidBetween(Short value1, Short value2) {
            addCriterion("CIRCLETYPEID between", value1, value2, "circletypeid");
            return (Criteria) this;
        }

        public Criteria andCircletypeidNotBetween(Short value1, Short value2) {
            addCriterion("CIRCLETYPEID not between", value1, value2, "circletypeid");
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

        public Criteria andEnergyuseIsNull() {
            addCriterion("ENERGYUSE is null");
            return (Criteria) this;
        }

        public Criteria andEnergyuseIsNotNull() {
            addCriterion("ENERGYUSE is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyuseEqualTo(Short value) {
            addCriterion("ENERGYUSE =", value, "energyuse");
            return (Criteria) this;
        }

        public Criteria andEnergyuseNotEqualTo(Short value) {
            addCriterion("ENERGYUSE <>", value, "energyuse");
            return (Criteria) this;
        }

        public Criteria andEnergyuseGreaterThan(Short value) {
            addCriterion("ENERGYUSE >", value, "energyuse");
            return (Criteria) this;
        }

        public Criteria andEnergyuseGreaterThanOrEqualTo(Short value) {
            addCriterion("ENERGYUSE >=", value, "energyuse");
            return (Criteria) this;
        }

        public Criteria andEnergyuseLessThan(Short value) {
            addCriterion("ENERGYUSE <", value, "energyuse");
            return (Criteria) this;
        }

        public Criteria andEnergyuseLessThanOrEqualTo(Short value) {
            addCriterion("ENERGYUSE <=", value, "energyuse");
            return (Criteria) this;
        }

        public Criteria andEnergyuseIn(List<Short> values) {
            addCriterion("ENERGYUSE in", values, "energyuse");
            return (Criteria) this;
        }

        public Criteria andEnergyuseNotIn(List<Short> values) {
            addCriterion("ENERGYUSE not in", values, "energyuse");
            return (Criteria) this;
        }

        public Criteria andEnergyuseBetween(Short value1, Short value2) {
            addCriterion("ENERGYUSE between", value1, value2, "energyuse");
            return (Criteria) this;
        }

        public Criteria andEnergyuseNotBetween(Short value1, Short value2) {
            addCriterion("ENERGYUSE not between", value1, value2, "energyuse");
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

        public Criteria andUsedIsNull() {
            addCriterion("USED is null");
            return (Criteria) this;
        }

        public Criteria andUsedIsNotNull() {
            addCriterion("USED is not null");
            return (Criteria) this;
        }

        public Criteria andUsedEqualTo(BigDecimal value) {
            addCriterion("USED =", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotEqualTo(BigDecimal value) {
            addCriterion("USED <>", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThan(BigDecimal value) {
            addCriterion("USED >", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("USED >=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThan(BigDecimal value) {
            addCriterion("USED <", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedLessThanOrEqualTo(BigDecimal value) {
            addCriterion("USED <=", value, "used");
            return (Criteria) this;
        }

        public Criteria andUsedIn(List<BigDecimal> values) {
            addCriterion("USED in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotIn(List<BigDecimal> values) {
            addCriterion("USED not in", values, "used");
            return (Criteria) this;
        }

        public Criteria andUsedBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED between", value1, value2, "used");
            return (Criteria) this;
        }

        public Criteria andUsedNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("USED not between", value1, value2, "used");
            return (Criteria) this;
        }

        public Criteria andEnergyIsNull() {
            addCriterion("ENERGY is null");
            return (Criteria) this;
        }

        public Criteria andEnergyIsNotNull() {
            addCriterion("ENERGY is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyEqualTo(BigDecimal value) {
            addCriterion("ENERGY =", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotEqualTo(BigDecimal value) {
            addCriterion("ENERGY <>", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyGreaterThan(BigDecimal value) {
            addCriterion("ENERGY >", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ENERGY >=", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyLessThan(BigDecimal value) {
            addCriterion("ENERGY <", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ENERGY <=", value, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyIn(List<BigDecimal> values) {
            addCriterion("ENERGY in", values, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotIn(List<BigDecimal> values) {
            addCriterion("ENERGY not in", values, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENERGY between", value1, value2, "energy");
            return (Criteria) this;
        }

        public Criteria andEnergyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ENERGY not between", value1, value2, "energy");
            return (Criteria) this;
        }

        public Criteria andPropIsNull() {
            addCriterion("PROP is null");
            return (Criteria) this;
        }

        public Criteria andPropIsNotNull() {
            addCriterion("PROP is not null");
            return (Criteria) this;
        }

        public Criteria andPropEqualTo(Short value) {
            addCriterion("PROP =", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropNotEqualTo(Short value) {
            addCriterion("PROP <>", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropGreaterThan(Short value) {
            addCriterion("PROP >", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropGreaterThanOrEqualTo(Short value) {
            addCriterion("PROP >=", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropLessThan(Short value) {
            addCriterion("PROP <", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropLessThanOrEqualTo(Short value) {
            addCriterion("PROP <=", value, "prop");
            return (Criteria) this;
        }

        public Criteria andPropIn(List<Short> values) {
            addCriterion("PROP in", values, "prop");
            return (Criteria) this;
        }

        public Criteria andPropNotIn(List<Short> values) {
            addCriterion("PROP not in", values, "prop");
            return (Criteria) this;
        }

        public Criteria andPropBetween(Short value1, Short value2) {
            addCriterion("PROP between", value1, value2, "prop");
            return (Criteria) this;
        }

        public Criteria andPropNotBetween(Short value1, Short value2) {
            addCriterion("PROP not between", value1, value2, "prop");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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