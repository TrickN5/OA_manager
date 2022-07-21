package com.oa.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DutyExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DutyExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andDtidIsNull() {
            addCriterion("dtid is null");
            return (Criteria) this;
        }

        public Criteria andDtidIsNotNull() {
            addCriterion("dtid is not null");
            return (Criteria) this;
        }

        public Criteria andDtidEqualTo(Integer value) {
            addCriterion("dtid =", value, "dtid");
            return (Criteria) this;
        }

        public Criteria andDtidNotEqualTo(Integer value) {
            addCriterion("dtid <>", value, "dtid");
            return (Criteria) this;
        }

        public Criteria andDtidGreaterThan(Integer value) {
            addCriterion("dtid >", value, "dtid");
            return (Criteria) this;
        }

        public Criteria andDtidGreaterThanOrEqualTo(Integer value) {
            addCriterion("dtid >=", value, "dtid");
            return (Criteria) this;
        }

        public Criteria andDtidLessThan(Integer value) {
            addCriterion("dtid <", value, "dtid");
            return (Criteria) this;
        }

        public Criteria andDtidLessThanOrEqualTo(Integer value) {
            addCriterion("dtid <=", value, "dtid");
            return (Criteria) this;
        }

        public Criteria andDtidIn(List<Integer> values) {
            addCriterion("dtid in", values, "dtid");
            return (Criteria) this;
        }

        public Criteria andDtidNotIn(List<Integer> values) {
            addCriterion("dtid not in", values, "dtid");
            return (Criteria) this;
        }

        public Criteria andDtidBetween(Integer value1, Integer value2) {
            addCriterion("dtid between", value1, value2, "dtid");
            return (Criteria) this;
        }

        public Criteria andDtidNotBetween(Integer value1, Integer value2) {
            addCriterion("dtid not between", value1, value2, "dtid");
            return (Criteria) this;
        }

        public Criteria andEmpridIsNull() {
            addCriterion("emprid is null");
            return (Criteria) this;
        }

        public Criteria andEmpridIsNotNull() {
            addCriterion("emprid is not null");
            return (Criteria) this;
        }

        public Criteria andEmpridEqualTo(String value) {
            addCriterion("emprid =", value, "emprid");
            return (Criteria) this;
        }

        public Criteria andEmpridNotEqualTo(String value) {
            addCriterion("emprid <>", value, "emprid");
            return (Criteria) this;
        }

        public Criteria andEmpridGreaterThan(String value) {
            addCriterion("emprid >", value, "emprid");
            return (Criteria) this;
        }

        public Criteria andEmpridGreaterThanOrEqualTo(String value) {
            addCriterion("emprid >=", value, "emprid");
            return (Criteria) this;
        }

        public Criteria andEmpridLessThan(String value) {
            addCriterion("emprid <", value, "emprid");
            return (Criteria) this;
        }

        public Criteria andEmpridLessThanOrEqualTo(String value) {
            addCriterion("emprid <=", value, "emprid");
            return (Criteria) this;
        }

        public Criteria andEmpridLike(String value) {
            addCriterion("emprid like", value, "emprid");
            return (Criteria) this;
        }

        public Criteria andEmpridNotLike(String value) {
            addCriterion("emprid not like", value, "emprid");
            return (Criteria) this;
        }

        public Criteria andEmpridIn(List<String> values) {
            addCriterion("emprid in", values, "emprid");
            return (Criteria) this;
        }

        public Criteria andEmpridNotIn(List<String> values) {
            addCriterion("emprid not in", values, "emprid");
            return (Criteria) this;
        }

        public Criteria andEmpridBetween(String value1, String value2) {
            addCriterion("emprid between", value1, value2, "emprid");
            return (Criteria) this;
        }

        public Criteria andEmpridNotBetween(String value1, String value2) {
            addCriterion("emprid not between", value1, value2, "emprid");
            return (Criteria) this;
        }

        public Criteria andDtdateIsNull() {
            addCriterion("dtdate is null");
            return (Criteria) this;
        }

        public Criteria andDtdateIsNotNull() {
            addCriterion("dtdate is not null");
            return (Criteria) this;
        }

        public Criteria andDtdateEqualTo(Date value) {
            addCriterionForJDBCDate("dtdate =", value, "dtdate");
            return (Criteria) this;
        }

        public Criteria andDtdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("dtdate <>", value, "dtdate");
            return (Criteria) this;
        }

        public Criteria andDtdateGreaterThan(Date value) {
            addCriterionForJDBCDate("dtdate >", value, "dtdate");
            return (Criteria) this;
        }

        public Criteria andDtdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dtdate >=", value, "dtdate");
            return (Criteria) this;
        }

        public Criteria andDtdateLessThan(Date value) {
            addCriterionForJDBCDate("dtdate <", value, "dtdate");
            return (Criteria) this;
        }

        public Criteria andDtdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("dtdate <=", value, "dtdate");
            return (Criteria) this;
        }

        public Criteria andDtdateIn(List<Date> values) {
            addCriterionForJDBCDate("dtdate in", values, "dtdate");
            return (Criteria) this;
        }

        public Criteria andDtdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("dtdate not in", values, "dtdate");
            return (Criteria) this;
        }

        public Criteria andDtdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dtdate between", value1, value2, "dtdate");
            return (Criteria) this;
        }

        public Criteria andDtdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("dtdate not between", value1, value2, "dtdate");
            return (Criteria) this;
        }

        public Criteria andSignintimeIsNull() {
            addCriterion("signintime is null");
            return (Criteria) this;
        }

        public Criteria andSignintimeIsNotNull() {
            addCriterion("signintime is not null");
            return (Criteria) this;
        }

        public Criteria andSignintimeEqualTo(String value) {
            addCriterion("signintime =", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeNotEqualTo(String value) {
            addCriterion("signintime <>", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeGreaterThan(String value) {
            addCriterion("signintime >", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeGreaterThanOrEqualTo(String value) {
            addCriterion("signintime >=", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeLessThan(String value) {
            addCriterion("signintime <", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeLessThanOrEqualTo(String value) {
            addCriterion("signintime <=", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeLike(String value) {
            addCriterion("signintime like", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeNotLike(String value) {
            addCriterion("signintime not like", value, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeIn(List<String> values) {
            addCriterion("signintime in", values, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeNotIn(List<String> values) {
            addCriterion("signintime not in", values, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeBetween(String value1, String value2) {
            addCriterion("signintime between", value1, value2, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignintimeNotBetween(String value1, String value2) {
            addCriterion("signintime not between", value1, value2, "signintime");
            return (Criteria) this;
        }

        public Criteria andSignouttimeIsNull() {
            addCriterion("signouttime is null");
            return (Criteria) this;
        }

        public Criteria andSignouttimeIsNotNull() {
            addCriterion("signouttime is not null");
            return (Criteria) this;
        }

        public Criteria andSignouttimeEqualTo(String value) {
            addCriterion("signouttime =", value, "signouttime");
            return (Criteria) this;
        }

        public Criteria andSignouttimeNotEqualTo(String value) {
            addCriterion("signouttime <>", value, "signouttime");
            return (Criteria) this;
        }

        public Criteria andSignouttimeGreaterThan(String value) {
            addCriterion("signouttime >", value, "signouttime");
            return (Criteria) this;
        }

        public Criteria andSignouttimeGreaterThanOrEqualTo(String value) {
            addCriterion("signouttime >=", value, "signouttime");
            return (Criteria) this;
        }

        public Criteria andSignouttimeLessThan(String value) {
            addCriterion("signouttime <", value, "signouttime");
            return (Criteria) this;
        }

        public Criteria andSignouttimeLessThanOrEqualTo(String value) {
            addCriterion("signouttime <=", value, "signouttime");
            return (Criteria) this;
        }

        public Criteria andSignouttimeLike(String value) {
            addCriterion("signouttime like", value, "signouttime");
            return (Criteria) this;
        }

        public Criteria andSignouttimeNotLike(String value) {
            addCriterion("signouttime not like", value, "signouttime");
            return (Criteria) this;
        }

        public Criteria andSignouttimeIn(List<String> values) {
            addCriterion("signouttime in", values, "signouttime");
            return (Criteria) this;
        }

        public Criteria andSignouttimeNotIn(List<String> values) {
            addCriterion("signouttime not in", values, "signouttime");
            return (Criteria) this;
        }

        public Criteria andSignouttimeBetween(String value1, String value2) {
            addCriterion("signouttime between", value1, value2, "signouttime");
            return (Criteria) this;
        }

        public Criteria andSignouttimeNotBetween(String value1, String value2) {
            addCriterion("signouttime not between", value1, value2, "signouttime");
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