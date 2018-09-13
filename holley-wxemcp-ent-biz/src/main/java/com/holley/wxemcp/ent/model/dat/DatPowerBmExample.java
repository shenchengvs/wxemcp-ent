package com.holley.wxemcp.ent.model.dat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatPowerBmExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DatPowerBmExample() {
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

        public Criteria andPhasetypeIsNull() {
            addCriterion("PHASETYPE is null");
            return (Criteria) this;
        }

        public Criteria andPhasetypeIsNotNull() {
            addCriterion("PHASETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPhasetypeEqualTo(Short value) {
            addCriterion("PHASETYPE =", value, "phasetype");
            return (Criteria) this;
        }

        public Criteria andPhasetypeNotEqualTo(Short value) {
            addCriterion("PHASETYPE <>", value, "phasetype");
            return (Criteria) this;
        }

        public Criteria andPhasetypeGreaterThan(Short value) {
            addCriterion("PHASETYPE >", value, "phasetype");
            return (Criteria) this;
        }

        public Criteria andPhasetypeGreaterThanOrEqualTo(Short value) {
            addCriterion("PHASETYPE >=", value, "phasetype");
            return (Criteria) this;
        }

        public Criteria andPhasetypeLessThan(Short value) {
            addCriterion("PHASETYPE <", value, "phasetype");
            return (Criteria) this;
        }

        public Criteria andPhasetypeLessThanOrEqualTo(Short value) {
            addCriterion("PHASETYPE <=", value, "phasetype");
            return (Criteria) this;
        }

        public Criteria andPhasetypeIn(List<Short> values) {
            addCriterion("PHASETYPE in", values, "phasetype");
            return (Criteria) this;
        }

        public Criteria andPhasetypeNotIn(List<Short> values) {
            addCriterion("PHASETYPE not in", values, "phasetype");
            return (Criteria) this;
        }

        public Criteria andPhasetypeBetween(Short value1, Short value2) {
            addCriterion("PHASETYPE between", value1, value2, "phasetype");
            return (Criteria) this;
        }

        public Criteria andPhasetypeNotBetween(Short value1, Short value2) {
            addCriterion("PHASETYPE not between", value1, value2, "phasetype");
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

        public Criteria andTarriftypeidIsNull() {
            addCriterion("TARRIFTYPEID is null");
            return (Criteria) this;
        }

        public Criteria andTarriftypeidIsNotNull() {
            addCriterion("TARRIFTYPEID is not null");
            return (Criteria) this;
        }

        public Criteria andTarriftypeidEqualTo(Short value) {
            addCriterion("TARRIFTYPEID =", value, "tarriftypeid");
            return (Criteria) this;
        }

        public Criteria andTarriftypeidNotEqualTo(Short value) {
            addCriterion("TARRIFTYPEID <>", value, "tarriftypeid");
            return (Criteria) this;
        }

        public Criteria andTarriftypeidGreaterThan(Short value) {
            addCriterion("TARRIFTYPEID >", value, "tarriftypeid");
            return (Criteria) this;
        }

        public Criteria andTarriftypeidGreaterThanOrEqualTo(Short value) {
            addCriterion("TARRIFTYPEID >=", value, "tarriftypeid");
            return (Criteria) this;
        }

        public Criteria andTarriftypeidLessThan(Short value) {
            addCriterion("TARRIFTYPEID <", value, "tarriftypeid");
            return (Criteria) this;
        }

        public Criteria andTarriftypeidLessThanOrEqualTo(Short value) {
            addCriterion("TARRIFTYPEID <=", value, "tarriftypeid");
            return (Criteria) this;
        }

        public Criteria andTarriftypeidIn(List<Short> values) {
            addCriterion("TARRIFTYPEID in", values, "tarriftypeid");
            return (Criteria) this;
        }

        public Criteria andTarriftypeidNotIn(List<Short> values) {
            addCriterion("TARRIFTYPEID not in", values, "tarriftypeid");
            return (Criteria) this;
        }

        public Criteria andTarriftypeidBetween(Short value1, Short value2) {
            addCriterion("TARRIFTYPEID between", value1, value2, "tarriftypeid");
            return (Criteria) this;
        }

        public Criteria andTarriftypeidNotBetween(Short value1, Short value2) {
            addCriterion("TARRIFTYPEID not between", value1, value2, "tarriftypeid");
            return (Criteria) this;
        }

        public Criteria andZybmIsNull() {
            addCriterion("ZYBM is null");
            return (Criteria) this;
        }

        public Criteria andZybmIsNotNull() {
            addCriterion("ZYBM is not null");
            return (Criteria) this;
        }

        public Criteria andZybmEqualTo(BigDecimal value) {
            addCriterion("ZYBM =", value, "zybm");
            return (Criteria) this;
        }

        public Criteria andZybmNotEqualTo(BigDecimal value) {
            addCriterion("ZYBM <>", value, "zybm");
            return (Criteria) this;
        }

        public Criteria andZybmGreaterThan(BigDecimal value) {
            addCriterion("ZYBM >", value, "zybm");
            return (Criteria) this;
        }

        public Criteria andZybmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ZYBM >=", value, "zybm");
            return (Criteria) this;
        }

        public Criteria andZybmLessThan(BigDecimal value) {
            addCriterion("ZYBM <", value, "zybm");
            return (Criteria) this;
        }

        public Criteria andZybmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ZYBM <=", value, "zybm");
            return (Criteria) this;
        }

        public Criteria andZybmIn(List<BigDecimal> values) {
            addCriterion("ZYBM in", values, "zybm");
            return (Criteria) this;
        }

        public Criteria andZybmNotIn(List<BigDecimal> values) {
            addCriterion("ZYBM not in", values, "zybm");
            return (Criteria) this;
        }

        public Criteria andZybmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZYBM between", value1, value2, "zybm");
            return (Criteria) this;
        }

        public Criteria andZybmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZYBM not between", value1, value2, "zybm");
            return (Criteria) this;
        }

        public Criteria andFybmIsNull() {
            addCriterion("FYBM is null");
            return (Criteria) this;
        }

        public Criteria andFybmIsNotNull() {
            addCriterion("FYBM is not null");
            return (Criteria) this;
        }

        public Criteria andFybmEqualTo(BigDecimal value) {
            addCriterion("FYBM =", value, "fybm");
            return (Criteria) this;
        }

        public Criteria andFybmNotEqualTo(BigDecimal value) {
            addCriterion("FYBM <>", value, "fybm");
            return (Criteria) this;
        }

        public Criteria andFybmGreaterThan(BigDecimal value) {
            addCriterion("FYBM >", value, "fybm");
            return (Criteria) this;
        }

        public Criteria andFybmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FYBM >=", value, "fybm");
            return (Criteria) this;
        }

        public Criteria andFybmLessThan(BigDecimal value) {
            addCriterion("FYBM <", value, "fybm");
            return (Criteria) this;
        }

        public Criteria andFybmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FYBM <=", value, "fybm");
            return (Criteria) this;
        }

        public Criteria andFybmIn(List<BigDecimal> values) {
            addCriterion("FYBM in", values, "fybm");
            return (Criteria) this;
        }

        public Criteria andFybmNotIn(List<BigDecimal> values) {
            addCriterion("FYBM not in", values, "fybm");
            return (Criteria) this;
        }

        public Criteria andFybmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FYBM between", value1, value2, "fybm");
            return (Criteria) this;
        }

        public Criteria andFybmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FYBM not between", value1, value2, "fybm");
            return (Criteria) this;
        }

        public Criteria andZwbmIsNull() {
            addCriterion("ZWBM is null");
            return (Criteria) this;
        }

        public Criteria andZwbmIsNotNull() {
            addCriterion("ZWBM is not null");
            return (Criteria) this;
        }

        public Criteria andZwbmEqualTo(BigDecimal value) {
            addCriterion("ZWBM =", value, "zwbm");
            return (Criteria) this;
        }

        public Criteria andZwbmNotEqualTo(BigDecimal value) {
            addCriterion("ZWBM <>", value, "zwbm");
            return (Criteria) this;
        }

        public Criteria andZwbmGreaterThan(BigDecimal value) {
            addCriterion("ZWBM >", value, "zwbm");
            return (Criteria) this;
        }

        public Criteria andZwbmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ZWBM >=", value, "zwbm");
            return (Criteria) this;
        }

        public Criteria andZwbmLessThan(BigDecimal value) {
            addCriterion("ZWBM <", value, "zwbm");
            return (Criteria) this;
        }

        public Criteria andZwbmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ZWBM <=", value, "zwbm");
            return (Criteria) this;
        }

        public Criteria andZwbmIn(List<BigDecimal> values) {
            addCriterion("ZWBM in", values, "zwbm");
            return (Criteria) this;
        }

        public Criteria andZwbmNotIn(List<BigDecimal> values) {
            addCriterion("ZWBM not in", values, "zwbm");
            return (Criteria) this;
        }

        public Criteria andZwbmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZWBM between", value1, value2, "zwbm");
            return (Criteria) this;
        }

        public Criteria andZwbmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ZWBM not between", value1, value2, "zwbm");
            return (Criteria) this;
        }

        public Criteria andFwbmIsNull() {
            addCriterion("FWBM is null");
            return (Criteria) this;
        }

        public Criteria andFwbmIsNotNull() {
            addCriterion("FWBM is not null");
            return (Criteria) this;
        }

        public Criteria andFwbmEqualTo(BigDecimal value) {
            addCriterion("FWBM =", value, "fwbm");
            return (Criteria) this;
        }

        public Criteria andFwbmNotEqualTo(BigDecimal value) {
            addCriterion("FWBM <>", value, "fwbm");
            return (Criteria) this;
        }

        public Criteria andFwbmGreaterThan(BigDecimal value) {
            addCriterion("FWBM >", value, "fwbm");
            return (Criteria) this;
        }

        public Criteria andFwbmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FWBM >=", value, "fwbm");
            return (Criteria) this;
        }

        public Criteria andFwbmLessThan(BigDecimal value) {
            addCriterion("FWBM <", value, "fwbm");
            return (Criteria) this;
        }

        public Criteria andFwbmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FWBM <=", value, "fwbm");
            return (Criteria) this;
        }

        public Criteria andFwbmIn(List<BigDecimal> values) {
            addCriterion("FWBM in", values, "fwbm");
            return (Criteria) this;
        }

        public Criteria andFwbmNotIn(List<BigDecimal> values) {
            addCriterion("FWBM not in", values, "fwbm");
            return (Criteria) this;
        }

        public Criteria andFwbmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FWBM between", value1, value2, "fwbm");
            return (Criteria) this;
        }

        public Criteria andFwbmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FWBM not between", value1, value2, "fwbm");
            return (Criteria) this;
        }

        public Criteria andXx1bmIsNull() {
            addCriterion("XX1BM is null");
            return (Criteria) this;
        }

        public Criteria andXx1bmIsNotNull() {
            addCriterion("XX1BM is not null");
            return (Criteria) this;
        }

        public Criteria andXx1bmEqualTo(BigDecimal value) {
            addCriterion("XX1BM =", value, "xx1bm");
            return (Criteria) this;
        }

        public Criteria andXx1bmNotEqualTo(BigDecimal value) {
            addCriterion("XX1BM <>", value, "xx1bm");
            return (Criteria) this;
        }

        public Criteria andXx1bmGreaterThan(BigDecimal value) {
            addCriterion("XX1BM >", value, "xx1bm");
            return (Criteria) this;
        }

        public Criteria andXx1bmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("XX1BM >=", value, "xx1bm");
            return (Criteria) this;
        }

        public Criteria andXx1bmLessThan(BigDecimal value) {
            addCriterion("XX1BM <", value, "xx1bm");
            return (Criteria) this;
        }

        public Criteria andXx1bmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("XX1BM <=", value, "xx1bm");
            return (Criteria) this;
        }

        public Criteria andXx1bmIn(List<BigDecimal> values) {
            addCriterion("XX1BM in", values, "xx1bm");
            return (Criteria) this;
        }

        public Criteria andXx1bmNotIn(List<BigDecimal> values) {
            addCriterion("XX1BM not in", values, "xx1bm");
            return (Criteria) this;
        }

        public Criteria andXx1bmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XX1BM between", value1, value2, "xx1bm");
            return (Criteria) this;
        }

        public Criteria andXx1bmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XX1BM not between", value1, value2, "xx1bm");
            return (Criteria) this;
        }

        public Criteria andXx2bmIsNull() {
            addCriterion("XX2BM is null");
            return (Criteria) this;
        }

        public Criteria andXx2bmIsNotNull() {
            addCriterion("XX2BM is not null");
            return (Criteria) this;
        }

        public Criteria andXx2bmEqualTo(BigDecimal value) {
            addCriterion("XX2BM =", value, "xx2bm");
            return (Criteria) this;
        }

        public Criteria andXx2bmNotEqualTo(BigDecimal value) {
            addCriterion("XX2BM <>", value, "xx2bm");
            return (Criteria) this;
        }

        public Criteria andXx2bmGreaterThan(BigDecimal value) {
            addCriterion("XX2BM >", value, "xx2bm");
            return (Criteria) this;
        }

        public Criteria andXx2bmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("XX2BM >=", value, "xx2bm");
            return (Criteria) this;
        }

        public Criteria andXx2bmLessThan(BigDecimal value) {
            addCriterion("XX2BM <", value, "xx2bm");
            return (Criteria) this;
        }

        public Criteria andXx2bmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("XX2BM <=", value, "xx2bm");
            return (Criteria) this;
        }

        public Criteria andXx2bmIn(List<BigDecimal> values) {
            addCriterion("XX2BM in", values, "xx2bm");
            return (Criteria) this;
        }

        public Criteria andXx2bmNotIn(List<BigDecimal> values) {
            addCriterion("XX2BM not in", values, "xx2bm");
            return (Criteria) this;
        }

        public Criteria andXx2bmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XX2BM between", value1, value2, "xx2bm");
            return (Criteria) this;
        }

        public Criteria andXx2bmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XX2BM not between", value1, value2, "xx2bm");
            return (Criteria) this;
        }

        public Criteria andXx3bmIsNull() {
            addCriterion("XX3BM is null");
            return (Criteria) this;
        }

        public Criteria andXx3bmIsNotNull() {
            addCriterion("XX3BM is not null");
            return (Criteria) this;
        }

        public Criteria andXx3bmEqualTo(BigDecimal value) {
            addCriterion("XX3BM =", value, "xx3bm");
            return (Criteria) this;
        }

        public Criteria andXx3bmNotEqualTo(BigDecimal value) {
            addCriterion("XX3BM <>", value, "xx3bm");
            return (Criteria) this;
        }

        public Criteria andXx3bmGreaterThan(BigDecimal value) {
            addCriterion("XX3BM >", value, "xx3bm");
            return (Criteria) this;
        }

        public Criteria andXx3bmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("XX3BM >=", value, "xx3bm");
            return (Criteria) this;
        }

        public Criteria andXx3bmLessThan(BigDecimal value) {
            addCriterion("XX3BM <", value, "xx3bm");
            return (Criteria) this;
        }

        public Criteria andXx3bmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("XX3BM <=", value, "xx3bm");
            return (Criteria) this;
        }

        public Criteria andXx3bmIn(List<BigDecimal> values) {
            addCriterion("XX3BM in", values, "xx3bm");
            return (Criteria) this;
        }

        public Criteria andXx3bmNotIn(List<BigDecimal> values) {
            addCriterion("XX3BM not in", values, "xx3bm");
            return (Criteria) this;
        }

        public Criteria andXx3bmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XX3BM between", value1, value2, "xx3bm");
            return (Criteria) this;
        }

        public Criteria andXx3bmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XX3BM not between", value1, value2, "xx3bm");
            return (Criteria) this;
        }

        public Criteria andXx4bmIsNull() {
            addCriterion("XX4BM is null");
            return (Criteria) this;
        }

        public Criteria andXx4bmIsNotNull() {
            addCriterion("XX4BM is not null");
            return (Criteria) this;
        }

        public Criteria andXx4bmEqualTo(BigDecimal value) {
            addCriterion("XX4BM =", value, "xx4bm");
            return (Criteria) this;
        }

        public Criteria andXx4bmNotEqualTo(BigDecimal value) {
            addCriterion("XX4BM <>", value, "xx4bm");
            return (Criteria) this;
        }

        public Criteria andXx4bmGreaterThan(BigDecimal value) {
            addCriterion("XX4BM >", value, "xx4bm");
            return (Criteria) this;
        }

        public Criteria andXx4bmGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("XX4BM >=", value, "xx4bm");
            return (Criteria) this;
        }

        public Criteria andXx4bmLessThan(BigDecimal value) {
            addCriterion("XX4BM <", value, "xx4bm");
            return (Criteria) this;
        }

        public Criteria andXx4bmLessThanOrEqualTo(BigDecimal value) {
            addCriterion("XX4BM <=", value, "xx4bm");
            return (Criteria) this;
        }

        public Criteria andXx4bmIn(List<BigDecimal> values) {
            addCriterion("XX4BM in", values, "xx4bm");
            return (Criteria) this;
        }

        public Criteria andXx4bmNotIn(List<BigDecimal> values) {
            addCriterion("XX4BM not in", values, "xx4bm");
            return (Criteria) this;
        }

        public Criteria andXx4bmBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XX4BM between", value1, value2, "xx4bm");
            return (Criteria) this;
        }

        public Criteria andXx4bmNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("XX4BM not between", value1, value2, "xx4bm");
            return (Criteria) this;
        }

        public Criteria andZypropIsNull() {
            addCriterion("ZYPROP is null");
            return (Criteria) this;
        }

        public Criteria andZypropIsNotNull() {
            addCriterion("ZYPROP is not null");
            return (Criteria) this;
        }

        public Criteria andZypropEqualTo(Short value) {
            addCriterion("ZYPROP =", value, "zyprop");
            return (Criteria) this;
        }

        public Criteria andZypropNotEqualTo(Short value) {
            addCriterion("ZYPROP <>", value, "zyprop");
            return (Criteria) this;
        }

        public Criteria andZypropGreaterThan(Short value) {
            addCriterion("ZYPROP >", value, "zyprop");
            return (Criteria) this;
        }

        public Criteria andZypropGreaterThanOrEqualTo(Short value) {
            addCriterion("ZYPROP >=", value, "zyprop");
            return (Criteria) this;
        }

        public Criteria andZypropLessThan(Short value) {
            addCriterion("ZYPROP <", value, "zyprop");
            return (Criteria) this;
        }

        public Criteria andZypropLessThanOrEqualTo(Short value) {
            addCriterion("ZYPROP <=", value, "zyprop");
            return (Criteria) this;
        }

        public Criteria andZypropIn(List<Short> values) {
            addCriterion("ZYPROP in", values, "zyprop");
            return (Criteria) this;
        }

        public Criteria andZypropNotIn(List<Short> values) {
            addCriterion("ZYPROP not in", values, "zyprop");
            return (Criteria) this;
        }

        public Criteria andZypropBetween(Short value1, Short value2) {
            addCriterion("ZYPROP between", value1, value2, "zyprop");
            return (Criteria) this;
        }

        public Criteria andZypropNotBetween(Short value1, Short value2) {
            addCriterion("ZYPROP not between", value1, value2, "zyprop");
            return (Criteria) this;
        }

        public Criteria andFypropIsNull() {
            addCriterion("FYPROP is null");
            return (Criteria) this;
        }

        public Criteria andFypropIsNotNull() {
            addCriterion("FYPROP is not null");
            return (Criteria) this;
        }

        public Criteria andFypropEqualTo(Short value) {
            addCriterion("FYPROP =", value, "fyprop");
            return (Criteria) this;
        }

        public Criteria andFypropNotEqualTo(Short value) {
            addCriterion("FYPROP <>", value, "fyprop");
            return (Criteria) this;
        }

        public Criteria andFypropGreaterThan(Short value) {
            addCriterion("FYPROP >", value, "fyprop");
            return (Criteria) this;
        }

        public Criteria andFypropGreaterThanOrEqualTo(Short value) {
            addCriterion("FYPROP >=", value, "fyprop");
            return (Criteria) this;
        }

        public Criteria andFypropLessThan(Short value) {
            addCriterion("FYPROP <", value, "fyprop");
            return (Criteria) this;
        }

        public Criteria andFypropLessThanOrEqualTo(Short value) {
            addCriterion("FYPROP <=", value, "fyprop");
            return (Criteria) this;
        }

        public Criteria andFypropIn(List<Short> values) {
            addCriterion("FYPROP in", values, "fyprop");
            return (Criteria) this;
        }

        public Criteria andFypropNotIn(List<Short> values) {
            addCriterion("FYPROP not in", values, "fyprop");
            return (Criteria) this;
        }

        public Criteria andFypropBetween(Short value1, Short value2) {
            addCriterion("FYPROP between", value1, value2, "fyprop");
            return (Criteria) this;
        }

        public Criteria andFypropNotBetween(Short value1, Short value2) {
            addCriterion("FYPROP not between", value1, value2, "fyprop");
            return (Criteria) this;
        }

        public Criteria andZwpropIsNull() {
            addCriterion("ZWPROP is null");
            return (Criteria) this;
        }

        public Criteria andZwpropIsNotNull() {
            addCriterion("ZWPROP is not null");
            return (Criteria) this;
        }

        public Criteria andZwpropEqualTo(Short value) {
            addCriterion("ZWPROP =", value, "zwprop");
            return (Criteria) this;
        }

        public Criteria andZwpropNotEqualTo(Short value) {
            addCriterion("ZWPROP <>", value, "zwprop");
            return (Criteria) this;
        }

        public Criteria andZwpropGreaterThan(Short value) {
            addCriterion("ZWPROP >", value, "zwprop");
            return (Criteria) this;
        }

        public Criteria andZwpropGreaterThanOrEqualTo(Short value) {
            addCriterion("ZWPROP >=", value, "zwprop");
            return (Criteria) this;
        }

        public Criteria andZwpropLessThan(Short value) {
            addCriterion("ZWPROP <", value, "zwprop");
            return (Criteria) this;
        }

        public Criteria andZwpropLessThanOrEqualTo(Short value) {
            addCriterion("ZWPROP <=", value, "zwprop");
            return (Criteria) this;
        }

        public Criteria andZwpropIn(List<Short> values) {
            addCriterion("ZWPROP in", values, "zwprop");
            return (Criteria) this;
        }

        public Criteria andZwpropNotIn(List<Short> values) {
            addCriterion("ZWPROP not in", values, "zwprop");
            return (Criteria) this;
        }

        public Criteria andZwpropBetween(Short value1, Short value2) {
            addCriterion("ZWPROP between", value1, value2, "zwprop");
            return (Criteria) this;
        }

        public Criteria andZwpropNotBetween(Short value1, Short value2) {
            addCriterion("ZWPROP not between", value1, value2, "zwprop");
            return (Criteria) this;
        }

        public Criteria andFwpropIsNull() {
            addCriterion("FWPROP is null");
            return (Criteria) this;
        }

        public Criteria andFwpropIsNotNull() {
            addCriterion("FWPROP is not null");
            return (Criteria) this;
        }

        public Criteria andFwpropEqualTo(Short value) {
            addCriterion("FWPROP =", value, "fwprop");
            return (Criteria) this;
        }

        public Criteria andFwpropNotEqualTo(Short value) {
            addCriterion("FWPROP <>", value, "fwprop");
            return (Criteria) this;
        }

        public Criteria andFwpropGreaterThan(Short value) {
            addCriterion("FWPROP >", value, "fwprop");
            return (Criteria) this;
        }

        public Criteria andFwpropGreaterThanOrEqualTo(Short value) {
            addCriterion("FWPROP >=", value, "fwprop");
            return (Criteria) this;
        }

        public Criteria andFwpropLessThan(Short value) {
            addCriterion("FWPROP <", value, "fwprop");
            return (Criteria) this;
        }

        public Criteria andFwpropLessThanOrEqualTo(Short value) {
            addCriterion("FWPROP <=", value, "fwprop");
            return (Criteria) this;
        }

        public Criteria andFwpropIn(List<Short> values) {
            addCriterion("FWPROP in", values, "fwprop");
            return (Criteria) this;
        }

        public Criteria andFwpropNotIn(List<Short> values) {
            addCriterion("FWPROP not in", values, "fwprop");
            return (Criteria) this;
        }

        public Criteria andFwpropBetween(Short value1, Short value2) {
            addCriterion("FWPROP between", value1, value2, "fwprop");
            return (Criteria) this;
        }

        public Criteria andFwpropNotBetween(Short value1, Short value2) {
            addCriterion("FWPROP not between", value1, value2, "fwprop");
            return (Criteria) this;
        }

        public Criteria andXx1propIsNull() {
            addCriterion("XX1PROP is null");
            return (Criteria) this;
        }

        public Criteria andXx1propIsNotNull() {
            addCriterion("XX1PROP is not null");
            return (Criteria) this;
        }

        public Criteria andXx1propEqualTo(Short value) {
            addCriterion("XX1PROP =", value, "xx1prop");
            return (Criteria) this;
        }

        public Criteria andXx1propNotEqualTo(Short value) {
            addCriterion("XX1PROP <>", value, "xx1prop");
            return (Criteria) this;
        }

        public Criteria andXx1propGreaterThan(Short value) {
            addCriterion("XX1PROP >", value, "xx1prop");
            return (Criteria) this;
        }

        public Criteria andXx1propGreaterThanOrEqualTo(Short value) {
            addCriterion("XX1PROP >=", value, "xx1prop");
            return (Criteria) this;
        }

        public Criteria andXx1propLessThan(Short value) {
            addCriterion("XX1PROP <", value, "xx1prop");
            return (Criteria) this;
        }

        public Criteria andXx1propLessThanOrEqualTo(Short value) {
            addCriterion("XX1PROP <=", value, "xx1prop");
            return (Criteria) this;
        }

        public Criteria andXx1propIn(List<Short> values) {
            addCriterion("XX1PROP in", values, "xx1prop");
            return (Criteria) this;
        }

        public Criteria andXx1propNotIn(List<Short> values) {
            addCriterion("XX1PROP not in", values, "xx1prop");
            return (Criteria) this;
        }

        public Criteria andXx1propBetween(Short value1, Short value2) {
            addCriterion("XX1PROP between", value1, value2, "xx1prop");
            return (Criteria) this;
        }

        public Criteria andXx1propNotBetween(Short value1, Short value2) {
            addCriterion("XX1PROP not between", value1, value2, "xx1prop");
            return (Criteria) this;
        }

        public Criteria andXx2propIsNull() {
            addCriterion("XX2PROP is null");
            return (Criteria) this;
        }

        public Criteria andXx2propIsNotNull() {
            addCriterion("XX2PROP is not null");
            return (Criteria) this;
        }

        public Criteria andXx2propEqualTo(Short value) {
            addCriterion("XX2PROP =", value, "xx2prop");
            return (Criteria) this;
        }

        public Criteria andXx2propNotEqualTo(Short value) {
            addCriterion("XX2PROP <>", value, "xx2prop");
            return (Criteria) this;
        }

        public Criteria andXx2propGreaterThan(Short value) {
            addCriterion("XX2PROP >", value, "xx2prop");
            return (Criteria) this;
        }

        public Criteria andXx2propGreaterThanOrEqualTo(Short value) {
            addCriterion("XX2PROP >=", value, "xx2prop");
            return (Criteria) this;
        }

        public Criteria andXx2propLessThan(Short value) {
            addCriterion("XX2PROP <", value, "xx2prop");
            return (Criteria) this;
        }

        public Criteria andXx2propLessThanOrEqualTo(Short value) {
            addCriterion("XX2PROP <=", value, "xx2prop");
            return (Criteria) this;
        }

        public Criteria andXx2propIn(List<Short> values) {
            addCriterion("XX2PROP in", values, "xx2prop");
            return (Criteria) this;
        }

        public Criteria andXx2propNotIn(List<Short> values) {
            addCriterion("XX2PROP not in", values, "xx2prop");
            return (Criteria) this;
        }

        public Criteria andXx2propBetween(Short value1, Short value2) {
            addCriterion("XX2PROP between", value1, value2, "xx2prop");
            return (Criteria) this;
        }

        public Criteria andXx2propNotBetween(Short value1, Short value2) {
            addCriterion("XX2PROP not between", value1, value2, "xx2prop");
            return (Criteria) this;
        }

        public Criteria andXx3propIsNull() {
            addCriterion("XX3PROP is null");
            return (Criteria) this;
        }

        public Criteria andXx3propIsNotNull() {
            addCriterion("XX3PROP is not null");
            return (Criteria) this;
        }

        public Criteria andXx3propEqualTo(Short value) {
            addCriterion("XX3PROP =", value, "xx3prop");
            return (Criteria) this;
        }

        public Criteria andXx3propNotEqualTo(Short value) {
            addCriterion("XX3PROP <>", value, "xx3prop");
            return (Criteria) this;
        }

        public Criteria andXx3propGreaterThan(Short value) {
            addCriterion("XX3PROP >", value, "xx3prop");
            return (Criteria) this;
        }

        public Criteria andXx3propGreaterThanOrEqualTo(Short value) {
            addCriterion("XX3PROP >=", value, "xx3prop");
            return (Criteria) this;
        }

        public Criteria andXx3propLessThan(Short value) {
            addCriterion("XX3PROP <", value, "xx3prop");
            return (Criteria) this;
        }

        public Criteria andXx3propLessThanOrEqualTo(Short value) {
            addCriterion("XX3PROP <=", value, "xx3prop");
            return (Criteria) this;
        }

        public Criteria andXx3propIn(List<Short> values) {
            addCriterion("XX3PROP in", values, "xx3prop");
            return (Criteria) this;
        }

        public Criteria andXx3propNotIn(List<Short> values) {
            addCriterion("XX3PROP not in", values, "xx3prop");
            return (Criteria) this;
        }

        public Criteria andXx3propBetween(Short value1, Short value2) {
            addCriterion("XX3PROP between", value1, value2, "xx3prop");
            return (Criteria) this;
        }

        public Criteria andXx3propNotBetween(Short value1, Short value2) {
            addCriterion("XX3PROP not between", value1, value2, "xx3prop");
            return (Criteria) this;
        }

        public Criteria andXx4propIsNull() {
            addCriterion("XX4PROP is null");
            return (Criteria) this;
        }

        public Criteria andXx4propIsNotNull() {
            addCriterion("XX4PROP is not null");
            return (Criteria) this;
        }

        public Criteria andXx4propEqualTo(Short value) {
            addCriterion("XX4PROP =", value, "xx4prop");
            return (Criteria) this;
        }

        public Criteria andXx4propNotEqualTo(Short value) {
            addCriterion("XX4PROP <>", value, "xx4prop");
            return (Criteria) this;
        }

        public Criteria andXx4propGreaterThan(Short value) {
            addCriterion("XX4PROP >", value, "xx4prop");
            return (Criteria) this;
        }

        public Criteria andXx4propGreaterThanOrEqualTo(Short value) {
            addCriterion("XX4PROP >=", value, "xx4prop");
            return (Criteria) this;
        }

        public Criteria andXx4propLessThan(Short value) {
            addCriterion("XX4PROP <", value, "xx4prop");
            return (Criteria) this;
        }

        public Criteria andXx4propLessThanOrEqualTo(Short value) {
            addCriterion("XX4PROP <=", value, "xx4prop");
            return (Criteria) this;
        }

        public Criteria andXx4propIn(List<Short> values) {
            addCriterion("XX4PROP in", values, "xx4prop");
            return (Criteria) this;
        }

        public Criteria andXx4propNotIn(List<Short> values) {
            addCriterion("XX4PROP not in", values, "xx4prop");
            return (Criteria) this;
        }

        public Criteria andXx4propBetween(Short value1, Short value2) {
            addCriterion("XX4PROP between", value1, value2, "xx4prop");
            return (Criteria) this;
        }

        public Criteria andXx4propNotBetween(Short value1, Short value2) {
            addCriterion("XX4PROP not between", value1, value2, "xx4prop");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeIsNull() {
            addCriterion("OLDDATATIME is null");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeIsNotNull() {
            addCriterion("OLDDATATIME is not null");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeEqualTo(Date value) {
            addCriterion("OLDDATATIME =", value, "olddatatime");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeNotEqualTo(Date value) {
            addCriterion("OLDDATATIME <>", value, "olddatatime");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeGreaterThan(Date value) {
            addCriterion("OLDDATATIME >", value, "olddatatime");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OLDDATATIME >=", value, "olddatatime");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeLessThan(Date value) {
            addCriterion("OLDDATATIME <", value, "olddatatime");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeLessThanOrEqualTo(Date value) {
            addCriterion("OLDDATATIME <=", value, "olddatatime");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeIn(List<Date> values) {
            addCriterion("OLDDATATIME in", values, "olddatatime");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeNotIn(List<Date> values) {
            addCriterion("OLDDATATIME not in", values, "olddatatime");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeBetween(Date value1, Date value2) {
            addCriterion("OLDDATATIME between", value1, value2, "olddatatime");
            return (Criteria) this;
        }

        public Criteria andOlddatatimeNotBetween(Date value1, Date value2) {
            addCriterion("OLDDATATIME not between", value1, value2, "olddatatime");
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