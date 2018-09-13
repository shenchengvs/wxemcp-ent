package com.holley.wxemcp.ent.model.obj;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjEnterpriseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ObjEnterpriseExample() {
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

        public Criteria andDiscIsNull() {
            addCriterion("DISC is null");
            return (Criteria) this;
        }

        public Criteria andDiscIsNotNull() {
            addCriterion("DISC is not null");
            return (Criteria) this;
        }

        public Criteria andDiscEqualTo(String value) {
            addCriterion("DISC =", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscNotEqualTo(String value) {
            addCriterion("DISC <>", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscGreaterThan(String value) {
            addCriterion("DISC >", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscGreaterThanOrEqualTo(String value) {
            addCriterion("DISC >=", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscLessThan(String value) {
            addCriterion("DISC <", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscLessThanOrEqualTo(String value) {
            addCriterion("DISC <=", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscLike(String value) {
            addCriterion("DISC like", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscNotLike(String value) {
            addCriterion("DISC not like", value, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscIn(List<String> values) {
            addCriterion("DISC in", values, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscNotIn(List<String> values) {
            addCriterion("DISC not in", values, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscBetween(String value1, String value2) {
            addCriterion("DISC between", value1, value2, "disc");
            return (Criteria) this;
        }

        public Criteria andDiscNotBetween(String value1, String value2) {
            addCriterion("DISC not between", value1, value2, "disc");
            return (Criteria) this;
        }

        public Criteria andAbbrIsNull() {
            addCriterion("ABBR is null");
            return (Criteria) this;
        }

        public Criteria andAbbrIsNotNull() {
            addCriterion("ABBR is not null");
            return (Criteria) this;
        }

        public Criteria andAbbrEqualTo(String value) {
            addCriterion("ABBR =", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrNotEqualTo(String value) {
            addCriterion("ABBR <>", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrGreaterThan(String value) {
            addCriterion("ABBR >", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrGreaterThanOrEqualTo(String value) {
            addCriterion("ABBR >=", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrLessThan(String value) {
            addCriterion("ABBR <", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrLessThanOrEqualTo(String value) {
            addCriterion("ABBR <=", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrLike(String value) {
            addCriterion("ABBR like", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrNotLike(String value) {
            addCriterion("ABBR not like", value, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrIn(List<String> values) {
            addCriterion("ABBR in", values, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrNotIn(List<String> values) {
            addCriterion("ABBR not in", values, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrBetween(String value1, String value2) {
            addCriterion("ABBR between", value1, value2, "abbr");
            return (Criteria) this;
        }

        public Criteria andAbbrNotBetween(String value1, String value2) {
            addCriterion("ABBR not between", value1, value2, "abbr");
            return (Criteria) this;
        }

        public Criteria andEcodeIsNull() {
            addCriterion("ECODE is null");
            return (Criteria) this;
        }

        public Criteria andEcodeIsNotNull() {
            addCriterion("ECODE is not null");
            return (Criteria) this;
        }

        public Criteria andEcodeEqualTo(String value) {
            addCriterion("ECODE =", value, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeNotEqualTo(String value) {
            addCriterion("ECODE <>", value, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeGreaterThan(String value) {
            addCriterion("ECODE >", value, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeGreaterThanOrEqualTo(String value) {
            addCriterion("ECODE >=", value, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeLessThan(String value) {
            addCriterion("ECODE <", value, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeLessThanOrEqualTo(String value) {
            addCriterion("ECODE <=", value, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeLike(String value) {
            addCriterion("ECODE like", value, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeNotLike(String value) {
            addCriterion("ECODE not like", value, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeIn(List<String> values) {
            addCriterion("ECODE in", values, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeNotIn(List<String> values) {
            addCriterion("ECODE not in", values, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeBetween(String value1, String value2) {
            addCriterion("ECODE between", value1, value2, "ecode");
            return (Criteria) this;
        }

        public Criteria andEcodeNotBetween(String value1, String value2) {
            addCriterion("ECODE not between", value1, value2, "ecode");
            return (Criteria) this;
        }

        public Criteria andCorporationidIsNull() {
            addCriterion("CORPORATIONID is null");
            return (Criteria) this;
        }

        public Criteria andCorporationidIsNotNull() {
            addCriterion("CORPORATIONID is not null");
            return (Criteria) this;
        }

        public Criteria andCorporationidEqualTo(String value) {
            addCriterion("CORPORATIONID =", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidNotEqualTo(String value) {
            addCriterion("CORPORATIONID <>", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidGreaterThan(String value) {
            addCriterion("CORPORATIONID >", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidGreaterThanOrEqualTo(String value) {
            addCriterion("CORPORATIONID >=", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidLessThan(String value) {
            addCriterion("CORPORATIONID <", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidLessThanOrEqualTo(String value) {
            addCriterion("CORPORATIONID <=", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidLike(String value) {
            addCriterion("CORPORATIONID like", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidNotLike(String value) {
            addCriterion("CORPORATIONID not like", value, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidIn(List<String> values) {
            addCriterion("CORPORATIONID in", values, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidNotIn(List<String> values) {
            addCriterion("CORPORATIONID not in", values, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidBetween(String value1, String value2) {
            addCriterion("CORPORATIONID between", value1, value2, "corporationid");
            return (Criteria) this;
        }

        public Criteria andCorporationidNotBetween(String value1, String value2) {
            addCriterion("CORPORATIONID not between", value1, value2, "corporationid");
            return (Criteria) this;
        }

        public Criteria andBusinessIsNull() {
            addCriterion("BUSINESS is null");
            return (Criteria) this;
        }

        public Criteria andBusinessIsNotNull() {
            addCriterion("BUSINESS is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessEqualTo(Short value) {
            addCriterion("BUSINESS =", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotEqualTo(Short value) {
            addCriterion("BUSINESS <>", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessGreaterThan(Short value) {
            addCriterion("BUSINESS >", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessGreaterThanOrEqualTo(Short value) {
            addCriterion("BUSINESS >=", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLessThan(Short value) {
            addCriterion("BUSINESS <", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessLessThanOrEqualTo(Short value) {
            addCriterion("BUSINESS <=", value, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessIn(List<Short> values) {
            addCriterion("BUSINESS in", values, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotIn(List<Short> values) {
            addCriterion("BUSINESS not in", values, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessBetween(Short value1, Short value2) {
            addCriterion("BUSINESS between", value1, value2, "business");
            return (Criteria) this;
        }

        public Criteria andBusinessNotBetween(Short value1, Short value2) {
            addCriterion("BUSINESS not between", value1, value2, "business");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("GRADE is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("GRADE is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(Short value) {
            addCriterion("GRADE =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(Short value) {
            addCriterion("GRADE <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(Short value) {
            addCriterion("GRADE >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(Short value) {
            addCriterion("GRADE >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(Short value) {
            addCriterion("GRADE <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(Short value) {
            addCriterion("GRADE <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<Short> values) {
            addCriterion("GRADE in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<Short> values) {
            addCriterion("GRADE not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(Short value1, Short value2) {
            addCriterion("GRADE between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(Short value1, Short value2) {
            addCriterion("GRADE not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andActivitiesIsNull() {
            addCriterion("ACTIVITIES is null");
            return (Criteria) this;
        }

        public Criteria andActivitiesIsNotNull() {
            addCriterion("ACTIVITIES is not null");
            return (Criteria) this;
        }

        public Criteria andActivitiesEqualTo(String value) {
            addCriterion("ACTIVITIES =", value, "activities");
            return (Criteria) this;
        }

        public Criteria andActivitiesNotEqualTo(String value) {
            addCriterion("ACTIVITIES <>", value, "activities");
            return (Criteria) this;
        }

        public Criteria andActivitiesGreaterThan(String value) {
            addCriterion("ACTIVITIES >", value, "activities");
            return (Criteria) this;
        }

        public Criteria andActivitiesGreaterThanOrEqualTo(String value) {
            addCriterion("ACTIVITIES >=", value, "activities");
            return (Criteria) this;
        }

        public Criteria andActivitiesLessThan(String value) {
            addCriterion("ACTIVITIES <", value, "activities");
            return (Criteria) this;
        }

        public Criteria andActivitiesLessThanOrEqualTo(String value) {
            addCriterion("ACTIVITIES <=", value, "activities");
            return (Criteria) this;
        }

        public Criteria andActivitiesLike(String value) {
            addCriterion("ACTIVITIES like", value, "activities");
            return (Criteria) this;
        }

        public Criteria andActivitiesNotLike(String value) {
            addCriterion("ACTIVITIES not like", value, "activities");
            return (Criteria) this;
        }

        public Criteria andActivitiesIn(List<String> values) {
            addCriterion("ACTIVITIES in", values, "activities");
            return (Criteria) this;
        }

        public Criteria andActivitiesNotIn(List<String> values) {
            addCriterion("ACTIVITIES not in", values, "activities");
            return (Criteria) this;
        }

        public Criteria andActivitiesBetween(String value1, String value2) {
            addCriterion("ACTIVITIES between", value1, value2, "activities");
            return (Criteria) this;
        }

        public Criteria andActivitiesNotBetween(String value1, String value2) {
            addCriterion("ACTIVITIES not between", value1, value2, "activities");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("CITY is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("CITY is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(Short value) {
            addCriterion("CITY =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(Short value) {
            addCriterion("CITY <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(Short value) {
            addCriterion("CITY >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(Short value) {
            addCriterion("CITY >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(Short value) {
            addCriterion("CITY <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(Short value) {
            addCriterion("CITY <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<Short> values) {
            addCriterion("CITY in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<Short> values) {
            addCriterion("CITY not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(Short value1, Short value2) {
            addCriterion("CITY between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(Short value1, Short value2) {
            addCriterion("CITY not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andRegisternumIsNull() {
            addCriterion("REGISTERNUM is null");
            return (Criteria) this;
        }

        public Criteria andRegisternumIsNotNull() {
            addCriterion("REGISTERNUM is not null");
            return (Criteria) this;
        }

        public Criteria andRegisternumEqualTo(String value) {
            addCriterion("REGISTERNUM =", value, "registernum");
            return (Criteria) this;
        }

        public Criteria andRegisternumNotEqualTo(String value) {
            addCriterion("REGISTERNUM <>", value, "registernum");
            return (Criteria) this;
        }

        public Criteria andRegisternumGreaterThan(String value) {
            addCriterion("REGISTERNUM >", value, "registernum");
            return (Criteria) this;
        }

        public Criteria andRegisternumGreaterThanOrEqualTo(String value) {
            addCriterion("REGISTERNUM >=", value, "registernum");
            return (Criteria) this;
        }

        public Criteria andRegisternumLessThan(String value) {
            addCriterion("REGISTERNUM <", value, "registernum");
            return (Criteria) this;
        }

        public Criteria andRegisternumLessThanOrEqualTo(String value) {
            addCriterion("REGISTERNUM <=", value, "registernum");
            return (Criteria) this;
        }

        public Criteria andRegisternumLike(String value) {
            addCriterion("REGISTERNUM like", value, "registernum");
            return (Criteria) this;
        }

        public Criteria andRegisternumNotLike(String value) {
            addCriterion("REGISTERNUM not like", value, "registernum");
            return (Criteria) this;
        }

        public Criteria andRegisternumIn(List<String> values) {
            addCriterion("REGISTERNUM in", values, "registernum");
            return (Criteria) this;
        }

        public Criteria andRegisternumNotIn(List<String> values) {
            addCriterion("REGISTERNUM not in", values, "registernum");
            return (Criteria) this;
        }

        public Criteria andRegisternumBetween(String value1, String value2) {
            addCriterion("REGISTERNUM between", value1, value2, "registernum");
            return (Criteria) this;
        }

        public Criteria andRegisternumNotBetween(String value1, String value2) {
            addCriterion("REGISTERNUM not between", value1, value2, "registernum");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressIsNull() {
            addCriterion("REGISTERADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressIsNotNull() {
            addCriterion("REGISTERADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressEqualTo(String value) {
            addCriterion("REGISTERADDRESS =", value, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressNotEqualTo(String value) {
            addCriterion("REGISTERADDRESS <>", value, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressGreaterThan(String value) {
            addCriterion("REGISTERADDRESS >", value, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressGreaterThanOrEqualTo(String value) {
            addCriterion("REGISTERADDRESS >=", value, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressLessThan(String value) {
            addCriterion("REGISTERADDRESS <", value, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressLessThanOrEqualTo(String value) {
            addCriterion("REGISTERADDRESS <=", value, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressLike(String value) {
            addCriterion("REGISTERADDRESS like", value, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressNotLike(String value) {
            addCriterion("REGISTERADDRESS not like", value, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressIn(List<String> values) {
            addCriterion("REGISTERADDRESS in", values, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressNotIn(List<String> values) {
            addCriterion("REGISTERADDRESS not in", values, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressBetween(String value1, String value2) {
            addCriterion("REGISTERADDRESS between", value1, value2, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andRegisteraddressNotBetween(String value1, String value2) {
            addCriterion("REGISTERADDRESS not between", value1, value2, "registeraddress");
            return (Criteria) this;
        }

        public Criteria andProductionaddressIsNull() {
            addCriterion("PRODUCTIONADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andProductionaddressIsNotNull() {
            addCriterion("PRODUCTIONADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andProductionaddressEqualTo(String value) {
            addCriterion("PRODUCTIONADDRESS =", value, "productionaddress");
            return (Criteria) this;
        }

        public Criteria andProductionaddressNotEqualTo(String value) {
            addCriterion("PRODUCTIONADDRESS <>", value, "productionaddress");
            return (Criteria) this;
        }

        public Criteria andProductionaddressGreaterThan(String value) {
            addCriterion("PRODUCTIONADDRESS >", value, "productionaddress");
            return (Criteria) this;
        }

        public Criteria andProductionaddressGreaterThanOrEqualTo(String value) {
            addCriterion("PRODUCTIONADDRESS >=", value, "productionaddress");
            return (Criteria) this;
        }

        public Criteria andProductionaddressLessThan(String value) {
            addCriterion("PRODUCTIONADDRESS <", value, "productionaddress");
            return (Criteria) this;
        }

        public Criteria andProductionaddressLessThanOrEqualTo(String value) {
            addCriterion("PRODUCTIONADDRESS <=", value, "productionaddress");
            return (Criteria) this;
        }

        public Criteria andProductionaddressLike(String value) {
            addCriterion("PRODUCTIONADDRESS like", value, "productionaddress");
            return (Criteria) this;
        }

        public Criteria andProductionaddressNotLike(String value) {
            addCriterion("PRODUCTIONADDRESS not like", value, "productionaddress");
            return (Criteria) this;
        }

        public Criteria andProductionaddressIn(List<String> values) {
            addCriterion("PRODUCTIONADDRESS in", values, "productionaddress");
            return (Criteria) this;
        }

        public Criteria andProductionaddressNotIn(List<String> values) {
            addCriterion("PRODUCTIONADDRESS not in", values, "productionaddress");
            return (Criteria) this;
        }

        public Criteria andProductionaddressBetween(String value1, String value2) {
            addCriterion("PRODUCTIONADDRESS between", value1, value2, "productionaddress");
            return (Criteria) this;
        }

        public Criteria andProductionaddressNotBetween(String value1, String value2) {
            addCriterion("PRODUCTIONADDRESS not between", value1, value2, "productionaddress");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNull() {
            addCriterion("LINKMAN is null");
            return (Criteria) this;
        }

        public Criteria andLinkmanIsNotNull() {
            addCriterion("LINKMAN is not null");
            return (Criteria) this;
        }

        public Criteria andLinkmanEqualTo(String value) {
            addCriterion("LINKMAN =", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotEqualTo(String value) {
            addCriterion("LINKMAN <>", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThan(String value) {
            addCriterion("LINKMAN >", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanGreaterThanOrEqualTo(String value) {
            addCriterion("LINKMAN >=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThan(String value) {
            addCriterion("LINKMAN <", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLessThanOrEqualTo(String value) {
            addCriterion("LINKMAN <=", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanLike(String value) {
            addCriterion("LINKMAN like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotLike(String value) {
            addCriterion("LINKMAN not like", value, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanIn(List<String> values) {
            addCriterion("LINKMAN in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotIn(List<String> values) {
            addCriterion("LINKMAN not in", values, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanBetween(String value1, String value2) {
            addCriterion("LINKMAN between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andLinkmanNotBetween(String value1, String value2) {
            addCriterion("LINKMAN not between", value1, value2, "linkman");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNull() {
            addCriterion("TELEPHONE is null");
            return (Criteria) this;
        }

        public Criteria andTelephoneIsNotNull() {
            addCriterion("TELEPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andTelephoneEqualTo(String value) {
            addCriterion("TELEPHONE =", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotEqualTo(String value) {
            addCriterion("TELEPHONE <>", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThan(String value) {
            addCriterion("TELEPHONE >", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("TELEPHONE >=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThan(String value) {
            addCriterion("TELEPHONE <", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLessThanOrEqualTo(String value) {
            addCriterion("TELEPHONE <=", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneLike(String value) {
            addCriterion("TELEPHONE like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotLike(String value) {
            addCriterion("TELEPHONE not like", value, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneIn(List<String> values) {
            addCriterion("TELEPHONE in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotIn(List<String> values) {
            addCriterion("TELEPHONE not in", values, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneBetween(String value1, String value2) {
            addCriterion("TELEPHONE between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andTelephoneNotBetween(String value1, String value2) {
            addCriterion("TELEPHONE not between", value1, value2, "telephone");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("MOBILE =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("MOBILE <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("MOBILE >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("MOBILE <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("MOBILE <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("MOBILE like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("MOBILE not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("MOBILE in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("MOBILE not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("MOBILE between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("MOBILE not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andFaxIsNull() {
            addCriterion("FAX is null");
            return (Criteria) this;
        }

        public Criteria andFaxIsNotNull() {
            addCriterion("FAX is not null");
            return (Criteria) this;
        }

        public Criteria andFaxEqualTo(String value) {
            addCriterion("FAX =", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotEqualTo(String value) {
            addCriterion("FAX <>", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThan(String value) {
            addCriterion("FAX >", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxGreaterThanOrEqualTo(String value) {
            addCriterion("FAX >=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThan(String value) {
            addCriterion("FAX <", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLessThanOrEqualTo(String value) {
            addCriterion("FAX <=", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxLike(String value) {
            addCriterion("FAX like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotLike(String value) {
            addCriterion("FAX not like", value, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxIn(List<String> values) {
            addCriterion("FAX in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotIn(List<String> values) {
            addCriterion("FAX not in", values, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxBetween(String value1, String value2) {
            addCriterion("FAX between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andFaxNotBetween(String value1, String value2) {
            addCriterion("FAX not between", value1, value2, "fax");
            return (Criteria) this;
        }

        public Criteria andZipcodeIsNull() {
            addCriterion("ZIPCODE is null");
            return (Criteria) this;
        }

        public Criteria andZipcodeIsNotNull() {
            addCriterion("ZIPCODE is not null");
            return (Criteria) this;
        }

        public Criteria andZipcodeEqualTo(String value) {
            addCriterion("ZIPCODE =", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotEqualTo(String value) {
            addCriterion("ZIPCODE <>", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeGreaterThan(String value) {
            addCriterion("ZIPCODE >", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeGreaterThanOrEqualTo(String value) {
            addCriterion("ZIPCODE >=", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLessThan(String value) {
            addCriterion("ZIPCODE <", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLessThanOrEqualTo(String value) {
            addCriterion("ZIPCODE <=", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeLike(String value) {
            addCriterion("ZIPCODE like", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotLike(String value) {
            addCriterion("ZIPCODE not like", value, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeIn(List<String> values) {
            addCriterion("ZIPCODE in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotIn(List<String> values) {
            addCriterion("ZIPCODE not in", values, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeBetween(String value1, String value2) {
            addCriterion("ZIPCODE between", value1, value2, "zipcode");
            return (Criteria) this;
        }

        public Criteria andZipcodeNotBetween(String value1, String value2) {
            addCriterion("ZIPCODE not between", value1, value2, "zipcode");
            return (Criteria) this;
        }

        public Criteria andLegalpersonIsNull() {
            addCriterion("LEGALPERSON is null");
            return (Criteria) this;
        }

        public Criteria andLegalpersonIsNotNull() {
            addCriterion("LEGALPERSON is not null");
            return (Criteria) this;
        }

        public Criteria andLegalpersonEqualTo(String value) {
            addCriterion("LEGALPERSON =", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonNotEqualTo(String value) {
            addCriterion("LEGALPERSON <>", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonGreaterThan(String value) {
            addCriterion("LEGALPERSON >", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonGreaterThanOrEqualTo(String value) {
            addCriterion("LEGALPERSON >=", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonLessThan(String value) {
            addCriterion("LEGALPERSON <", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonLessThanOrEqualTo(String value) {
            addCriterion("LEGALPERSON <=", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonLike(String value) {
            addCriterion("LEGALPERSON like", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonNotLike(String value) {
            addCriterion("LEGALPERSON not like", value, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonIn(List<String> values) {
            addCriterion("LEGALPERSON in", values, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonNotIn(List<String> values) {
            addCriterion("LEGALPERSON not in", values, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonBetween(String value1, String value2) {
            addCriterion("LEGALPERSON between", value1, value2, "legalperson");
            return (Criteria) this;
        }

        public Criteria andLegalpersonNotBetween(String value1, String value2) {
            addCriterion("LEGALPERSON not between", value1, value2, "legalperson");
            return (Criteria) this;
        }

        public Criteria andPassauthenticationIsNull() {
            addCriterion("PASSAUTHENTICATION is null");
            return (Criteria) this;
        }

        public Criteria andPassauthenticationIsNotNull() {
            addCriterion("PASSAUTHENTICATION is not null");
            return (Criteria) this;
        }

        public Criteria andPassauthenticationEqualTo(Short value) {
            addCriterion("PASSAUTHENTICATION =", value, "passauthentication");
            return (Criteria) this;
        }

        public Criteria andPassauthenticationNotEqualTo(Short value) {
            addCriterion("PASSAUTHENTICATION <>", value, "passauthentication");
            return (Criteria) this;
        }

        public Criteria andPassauthenticationGreaterThan(Short value) {
            addCriterion("PASSAUTHENTICATION >", value, "passauthentication");
            return (Criteria) this;
        }

        public Criteria andPassauthenticationGreaterThanOrEqualTo(Short value) {
            addCriterion("PASSAUTHENTICATION >=", value, "passauthentication");
            return (Criteria) this;
        }

        public Criteria andPassauthenticationLessThan(Short value) {
            addCriterion("PASSAUTHENTICATION <", value, "passauthentication");
            return (Criteria) this;
        }

        public Criteria andPassauthenticationLessThanOrEqualTo(Short value) {
            addCriterion("PASSAUTHENTICATION <=", value, "passauthentication");
            return (Criteria) this;
        }

        public Criteria andPassauthenticationIn(List<Short> values) {
            addCriterion("PASSAUTHENTICATION in", values, "passauthentication");
            return (Criteria) this;
        }

        public Criteria andPassauthenticationNotIn(List<Short> values) {
            addCriterion("PASSAUTHENTICATION not in", values, "passauthentication");
            return (Criteria) this;
        }

        public Criteria andPassauthenticationBetween(Short value1, Short value2) {
            addCriterion("PASSAUTHENTICATION between", value1, value2, "passauthentication");
            return (Criteria) this;
        }

        public Criteria andPassauthenticationNotBetween(Short value1, Short value2) {
            addCriterion("PASSAUTHENTICATION not between", value1, value2, "passauthentication");
            return (Criteria) this;
        }

        public Criteria andHascertificateIsNull() {
            addCriterion("HASCERTIFICATE is null");
            return (Criteria) this;
        }

        public Criteria andHascertificateIsNotNull() {
            addCriterion("HASCERTIFICATE is not null");
            return (Criteria) this;
        }

        public Criteria andHascertificateEqualTo(Short value) {
            addCriterion("HASCERTIFICATE =", value, "hascertificate");
            return (Criteria) this;
        }

        public Criteria andHascertificateNotEqualTo(Short value) {
            addCriterion("HASCERTIFICATE <>", value, "hascertificate");
            return (Criteria) this;
        }

        public Criteria andHascertificateGreaterThan(Short value) {
            addCriterion("HASCERTIFICATE >", value, "hascertificate");
            return (Criteria) this;
        }

        public Criteria andHascertificateGreaterThanOrEqualTo(Short value) {
            addCriterion("HASCERTIFICATE >=", value, "hascertificate");
            return (Criteria) this;
        }

        public Criteria andHascertificateLessThan(Short value) {
            addCriterion("HASCERTIFICATE <", value, "hascertificate");
            return (Criteria) this;
        }

        public Criteria andHascertificateLessThanOrEqualTo(Short value) {
            addCriterion("HASCERTIFICATE <=", value, "hascertificate");
            return (Criteria) this;
        }

        public Criteria andHascertificateIn(List<Short> values) {
            addCriterion("HASCERTIFICATE in", values, "hascertificate");
            return (Criteria) this;
        }

        public Criteria andHascertificateNotIn(List<Short> values) {
            addCriterion("HASCERTIFICATE not in", values, "hascertificate");
            return (Criteria) this;
        }

        public Criteria andHascertificateBetween(Short value1, Short value2) {
            addCriterion("HASCERTIFICATE between", value1, value2, "hascertificate");
            return (Criteria) this;
        }

        public Criteria andHascertificateNotBetween(Short value1, Short value2) {
            addCriterion("HASCERTIFICATE not between", value1, value2, "hascertificate");
            return (Criteria) this;
        }

        public Criteria andGettimeIsNull() {
            addCriterion("GETTIME is null");
            return (Criteria) this;
        }

        public Criteria andGettimeIsNotNull() {
            addCriterion("GETTIME is not null");
            return (Criteria) this;
        }

        public Criteria andGettimeEqualTo(String value) {
            addCriterion("GETTIME =", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeNotEqualTo(String value) {
            addCriterion("GETTIME <>", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeGreaterThan(String value) {
            addCriterion("GETTIME >", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeGreaterThanOrEqualTo(String value) {
            addCriterion("GETTIME >=", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeLessThan(String value) {
            addCriterion("GETTIME <", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeLessThanOrEqualTo(String value) {
            addCriterion("GETTIME <=", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeLike(String value) {
            addCriterion("GETTIME like", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeNotLike(String value) {
            addCriterion("GETTIME not like", value, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeIn(List<String> values) {
            addCriterion("GETTIME in", values, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeNotIn(List<String> values) {
            addCriterion("GETTIME not in", values, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeBetween(String value1, String value2) {
            addCriterion("GETTIME between", value1, value2, "gettime");
            return (Criteria) this;
        }

        public Criteria andGettimeNotBetween(String value1, String value2) {
            addCriterion("GETTIME not between", value1, value2, "gettime");
            return (Criteria) this;
        }

        public Criteria andAnnualsalesIsNull() {
            addCriterion("ANNUALSALES is null");
            return (Criteria) this;
        }

        public Criteria andAnnualsalesIsNotNull() {
            addCriterion("ANNUALSALES is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualsalesEqualTo(String value) {
            addCriterion("ANNUALSALES =", value, "annualsales");
            return (Criteria) this;
        }

        public Criteria andAnnualsalesNotEqualTo(String value) {
            addCriterion("ANNUALSALES <>", value, "annualsales");
            return (Criteria) this;
        }

        public Criteria andAnnualsalesGreaterThan(String value) {
            addCriterion("ANNUALSALES >", value, "annualsales");
            return (Criteria) this;
        }

        public Criteria andAnnualsalesGreaterThanOrEqualTo(String value) {
            addCriterion("ANNUALSALES >=", value, "annualsales");
            return (Criteria) this;
        }

        public Criteria andAnnualsalesLessThan(String value) {
            addCriterion("ANNUALSALES <", value, "annualsales");
            return (Criteria) this;
        }

        public Criteria andAnnualsalesLessThanOrEqualTo(String value) {
            addCriterion("ANNUALSALES <=", value, "annualsales");
            return (Criteria) this;
        }

        public Criteria andAnnualsalesLike(String value) {
            addCriterion("ANNUALSALES like", value, "annualsales");
            return (Criteria) this;
        }

        public Criteria andAnnualsalesNotLike(String value) {
            addCriterion("ANNUALSALES not like", value, "annualsales");
            return (Criteria) this;
        }

        public Criteria andAnnualsalesIn(List<String> values) {
            addCriterion("ANNUALSALES in", values, "annualsales");
            return (Criteria) this;
        }

        public Criteria andAnnualsalesNotIn(List<String> values) {
            addCriterion("ANNUALSALES not in", values, "annualsales");
            return (Criteria) this;
        }

        public Criteria andAnnualsalesBetween(String value1, String value2) {
            addCriterion("ANNUALSALES between", value1, value2, "annualsales");
            return (Criteria) this;
        }

        public Criteria andAnnualsalesNotBetween(String value1, String value2) {
            addCriterion("ANNUALSALES not between", value1, value2, "annualsales");
            return (Criteria) this;
        }

        public Criteria andAnnualtaxIsNull() {
            addCriterion("ANNUALTAX is null");
            return (Criteria) this;
        }

        public Criteria andAnnualtaxIsNotNull() {
            addCriterion("ANNUALTAX is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualtaxEqualTo(String value) {
            addCriterion("ANNUALTAX =", value, "annualtax");
            return (Criteria) this;
        }

        public Criteria andAnnualtaxNotEqualTo(String value) {
            addCriterion("ANNUALTAX <>", value, "annualtax");
            return (Criteria) this;
        }

        public Criteria andAnnualtaxGreaterThan(String value) {
            addCriterion("ANNUALTAX >", value, "annualtax");
            return (Criteria) this;
        }

        public Criteria andAnnualtaxGreaterThanOrEqualTo(String value) {
            addCriterion("ANNUALTAX >=", value, "annualtax");
            return (Criteria) this;
        }

        public Criteria andAnnualtaxLessThan(String value) {
            addCriterion("ANNUALTAX <", value, "annualtax");
            return (Criteria) this;
        }

        public Criteria andAnnualtaxLessThanOrEqualTo(String value) {
            addCriterion("ANNUALTAX <=", value, "annualtax");
            return (Criteria) this;
        }

        public Criteria andAnnualtaxLike(String value) {
            addCriterion("ANNUALTAX like", value, "annualtax");
            return (Criteria) this;
        }

        public Criteria andAnnualtaxNotLike(String value) {
            addCriterion("ANNUALTAX not like", value, "annualtax");
            return (Criteria) this;
        }

        public Criteria andAnnualtaxIn(List<String> values) {
            addCriterion("ANNUALTAX in", values, "annualtax");
            return (Criteria) this;
        }

        public Criteria andAnnualtaxNotIn(List<String> values) {
            addCriterion("ANNUALTAX not in", values, "annualtax");
            return (Criteria) this;
        }

        public Criteria andAnnualtaxBetween(String value1, String value2) {
            addCriterion("ANNUALTAX between", value1, value2, "annualtax");
            return (Criteria) this;
        }

        public Criteria andAnnualtaxNotBetween(String value1, String value2) {
            addCriterion("ANNUALTAX not between", value1, value2, "annualtax");
            return (Criteria) this;
        }

        public Criteria andAnnualaddedenergyIsNull() {
            addCriterion("ANNUALADDEDENERGY is null");
            return (Criteria) this;
        }

        public Criteria andAnnualaddedenergyIsNotNull() {
            addCriterion("ANNUALADDEDENERGY is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualaddedenergyEqualTo(BigDecimal value) {
            addCriterion("ANNUALADDEDENERGY =", value, "annualaddedenergy");
            return (Criteria) this;
        }

        public Criteria andAnnualaddedenergyNotEqualTo(BigDecimal value) {
            addCriterion("ANNUALADDEDENERGY <>", value, "annualaddedenergy");
            return (Criteria) this;
        }

        public Criteria andAnnualaddedenergyGreaterThan(BigDecimal value) {
            addCriterion("ANNUALADDEDENERGY >", value, "annualaddedenergy");
            return (Criteria) this;
        }

        public Criteria andAnnualaddedenergyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ANNUALADDEDENERGY >=", value, "annualaddedenergy");
            return (Criteria) this;
        }

        public Criteria andAnnualaddedenergyLessThan(BigDecimal value) {
            addCriterion("ANNUALADDEDENERGY <", value, "annualaddedenergy");
            return (Criteria) this;
        }

        public Criteria andAnnualaddedenergyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ANNUALADDEDENERGY <=", value, "annualaddedenergy");
            return (Criteria) this;
        }

        public Criteria andAnnualaddedenergyIn(List<BigDecimal> values) {
            addCriterion("ANNUALADDEDENERGY in", values, "annualaddedenergy");
            return (Criteria) this;
        }

        public Criteria andAnnualaddedenergyNotIn(List<BigDecimal> values) {
            addCriterion("ANNUALADDEDENERGY not in", values, "annualaddedenergy");
            return (Criteria) this;
        }

        public Criteria andAnnualaddedenergyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ANNUALADDEDENERGY between", value1, value2, "annualaddedenergy");
            return (Criteria) this;
        }

        public Criteria andAnnualaddedenergyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ANNUALADDEDENERGY not between", value1, value2, "annualaddedenergy");
            return (Criteria) this;
        }

        public Criteria andAnnualenergyIsNull() {
            addCriterion("ANNUALENERGY is null");
            return (Criteria) this;
        }

        public Criteria andAnnualenergyIsNotNull() {
            addCriterion("ANNUALENERGY is not null");
            return (Criteria) this;
        }

        public Criteria andAnnualenergyEqualTo(BigDecimal value) {
            addCriterion("ANNUALENERGY =", value, "annualenergy");
            return (Criteria) this;
        }

        public Criteria andAnnualenergyNotEqualTo(BigDecimal value) {
            addCriterion("ANNUALENERGY <>", value, "annualenergy");
            return (Criteria) this;
        }

        public Criteria andAnnualenergyGreaterThan(BigDecimal value) {
            addCriterion("ANNUALENERGY >", value, "annualenergy");
            return (Criteria) this;
        }

        public Criteria andAnnualenergyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ANNUALENERGY >=", value, "annualenergy");
            return (Criteria) this;
        }

        public Criteria andAnnualenergyLessThan(BigDecimal value) {
            addCriterion("ANNUALENERGY <", value, "annualenergy");
            return (Criteria) this;
        }

        public Criteria andAnnualenergyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ANNUALENERGY <=", value, "annualenergy");
            return (Criteria) this;
        }

        public Criteria andAnnualenergyIn(List<BigDecimal> values) {
            addCriterion("ANNUALENERGY in", values, "annualenergy");
            return (Criteria) this;
        }

        public Criteria andAnnualenergyNotIn(List<BigDecimal> values) {
            addCriterion("ANNUALENERGY not in", values, "annualenergy");
            return (Criteria) this;
        }

        public Criteria andAnnualenergyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ANNUALENERGY between", value1, value2, "annualenergy");
            return (Criteria) this;
        }

        public Criteria andAnnualenergyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ANNUALENERGY not between", value1, value2, "annualenergy");
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

        public Criteria andEtypeIsNull() {
            addCriterion("ETYPE is null");
            return (Criteria) this;
        }

        public Criteria andEtypeIsNotNull() {
            addCriterion("ETYPE is not null");
            return (Criteria) this;
        }

        public Criteria andEtypeEqualTo(Short value) {
            addCriterion("ETYPE =", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeNotEqualTo(Short value) {
            addCriterion("ETYPE <>", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeGreaterThan(Short value) {
            addCriterion("ETYPE >", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeGreaterThanOrEqualTo(Short value) {
            addCriterion("ETYPE >=", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeLessThan(Short value) {
            addCriterion("ETYPE <", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeLessThanOrEqualTo(Short value) {
            addCriterion("ETYPE <=", value, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeIn(List<Short> values) {
            addCriterion("ETYPE in", values, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeNotIn(List<Short> values) {
            addCriterion("ETYPE not in", values, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeBetween(Short value1, Short value2) {
            addCriterion("ETYPE between", value1, value2, "etype");
            return (Criteria) this;
        }

        public Criteria andEtypeNotBetween(Short value1, Short value2) {
            addCriterion("ETYPE not between", value1, value2, "etype");
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