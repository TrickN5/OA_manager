package com.oa.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class ExpenseExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ExpenseExample() {
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

        public Criteria andExpidIsNull() {
            addCriterion("expid is null");
            return (Criteria) this;
        }

        public Criteria andExpidIsNotNull() {
            addCriterion("expid is not null");
            return (Criteria) this;
        }

        public Criteria andExpidEqualTo(Integer value) {
            addCriterion("expid =", value, "expid");
            return (Criteria) this;
        }

        public Criteria andExpidNotEqualTo(Integer value) {
            addCriterion("expid <>", value, "expid");
            return (Criteria) this;
        }

        public Criteria andExpidGreaterThan(Integer value) {
            addCriterion("expid >", value, "expid");
            return (Criteria) this;
        }

        public Criteria andExpidGreaterThanOrEqualTo(Integer value) {
            addCriterion("expid >=", value, "expid");
            return (Criteria) this;
        }

        public Criteria andExpidLessThan(Integer value) {
            addCriterion("expid <", value, "expid");
            return (Criteria) this;
        }

        public Criteria andExpidLessThanOrEqualTo(Integer value) {
            addCriterion("expid <=", value, "expid");
            return (Criteria) this;
        }

        public Criteria andExpidIn(List<Integer> values) {
            addCriterion("expid in", values, "expid");
            return (Criteria) this;
        }

        public Criteria andExpidNotIn(List<Integer> values) {
            addCriterion("expid not in", values, "expid");
            return (Criteria) this;
        }

        public Criteria andExpidBetween(Integer value1, Integer value2) {
            addCriterion("expid between", value1, value2, "expid");
            return (Criteria) this;
        }

        public Criteria andExpidNotBetween(Integer value1, Integer value2) {
            addCriterion("expid not between", value1, value2, "expid");
            return (Criteria) this;
        }

        public Criteria andEmpidIsNull() {
            addCriterion("empid is null");
            return (Criteria) this;
        }

        public Criteria andEmpidIsNotNull() {
            addCriterion("empid is not null");
            return (Criteria) this;
        }

        public Criteria andEmpidEqualTo(String value) {
            addCriterion("empid =", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotEqualTo(String value) {
            addCriterion("empid <>", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThan(String value) {
            addCriterion("empid >", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidGreaterThanOrEqualTo(String value) {
            addCriterion("empid >=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThan(String value) {
            addCriterion("empid <", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLessThanOrEqualTo(String value) {
            addCriterion("empid <=", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidLike(String value) {
            addCriterion("empid like", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotLike(String value) {
            addCriterion("empid not like", value, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidIn(List<String> values) {
            addCriterion("empid in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotIn(List<String> values) {
            addCriterion("empid not in", values, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidBetween(String value1, String value2) {
            addCriterion("empid between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andEmpidNotBetween(String value1, String value2) {
            addCriterion("empid not between", value1, value2, "empid");
            return (Criteria) this;
        }

        public Criteria andTotalamountIsNull() {
            addCriterion("totalamount is null");
            return (Criteria) this;
        }

        public Criteria andTotalamountIsNotNull() {
            addCriterion("totalamount is not null");
            return (Criteria) this;
        }

        public Criteria andTotalamountEqualTo(Double value) {
            addCriterion("totalamount =", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountNotEqualTo(Double value) {
            addCriterion("totalamount <>", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountGreaterThan(Double value) {
            addCriterion("totalamount >", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountGreaterThanOrEqualTo(Double value) {
            addCriterion("totalamount >=", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountLessThan(Double value) {
            addCriterion("totalamount <", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountLessThanOrEqualTo(Double value) {
            addCriterion("totalamount <=", value, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountIn(List<Double> values) {
            addCriterion("totalamount in", values, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountNotIn(List<Double> values) {
            addCriterion("totalamount not in", values, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountBetween(Double value1, Double value2) {
            addCriterion("totalamount between", value1, value2, "totalamount");
            return (Criteria) this;
        }

        public Criteria andTotalamountNotBetween(Double value1, Double value2) {
            addCriterion("totalamount not between", value1, value2, "totalamount");
            return (Criteria) this;
        }

        public Criteria andExptimeIsNull() {
            addCriterion("exptime is null");
            return (Criteria) this;
        }

        public Criteria andExptimeIsNotNull() {
            addCriterion("exptime is not null");
            return (Criteria) this;
        }

        public Criteria andExptimeEqualTo(Date value) {
            addCriterionForJDBCDate("exptime =", value, "exptime");
            return (Criteria) this;
        }

        public Criteria andExptimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("exptime <>", value, "exptime");
            return (Criteria) this;
        }

        public Criteria andExptimeGreaterThan(Date value) {
            addCriterionForJDBCDate("exptime >", value, "exptime");
            return (Criteria) this;
        }

        public Criteria andExptimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("exptime >=", value, "exptime");
            return (Criteria) this;
        }

        public Criteria andExptimeLessThan(Date value) {
            addCriterionForJDBCDate("exptime <", value, "exptime");
            return (Criteria) this;
        }

        public Criteria andExptimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("exptime <=", value, "exptime");
            return (Criteria) this;
        }

        public Criteria andExptimeIn(List<Date> values) {
            addCriterionForJDBCDate("exptime in", values, "exptime");
            return (Criteria) this;
        }

        public Criteria andExptimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("exptime not in", values, "exptime");
            return (Criteria) this;
        }

        public Criteria andExptimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("exptime between", value1, value2, "exptime");
            return (Criteria) this;
        }

        public Criteria andExptimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("exptime not between", value1, value2, "exptime");
            return (Criteria) this;
        }

        public Criteria andExpdescIsNull() {
            addCriterion("expdesc is null");
            return (Criteria) this;
        }

        public Criteria andExpdescIsNotNull() {
            addCriterion("expdesc is not null");
            return (Criteria) this;
        }

        public Criteria andExpdescEqualTo(String value) {
            addCriterion("expdesc =", value, "expdesc");
            return (Criteria) this;
        }

        public Criteria andExpdescNotEqualTo(String value) {
            addCriterion("expdesc <>", value, "expdesc");
            return (Criteria) this;
        }

        public Criteria andExpdescGreaterThan(String value) {
            addCriterion("expdesc >", value, "expdesc");
            return (Criteria) this;
        }

        public Criteria andExpdescGreaterThanOrEqualTo(String value) {
            addCriterion("expdesc >=", value, "expdesc");
            return (Criteria) this;
        }

        public Criteria andExpdescLessThan(String value) {
            addCriterion("expdesc <", value, "expdesc");
            return (Criteria) this;
        }

        public Criteria andExpdescLessThanOrEqualTo(String value) {
            addCriterion("expdesc <=", value, "expdesc");
            return (Criteria) this;
        }

        public Criteria andExpdescLike(String value) {
            addCriterion("expdesc like", value, "expdesc");
            return (Criteria) this;
        }

        public Criteria andExpdescNotLike(String value) {
            addCriterion("expdesc not like", value, "expdesc");
            return (Criteria) this;
        }

        public Criteria andExpdescIn(List<String> values) {
            addCriterion("expdesc in", values, "expdesc");
            return (Criteria) this;
        }

        public Criteria andExpdescNotIn(List<String> values) {
            addCriterion("expdesc not in", values, "expdesc");
            return (Criteria) this;
        }

        public Criteria andExpdescBetween(String value1, String value2) {
            addCriterion("expdesc between", value1, value2, "expdesc");
            return (Criteria) this;
        }

        public Criteria andExpdescNotBetween(String value1, String value2) {
            addCriterion("expdesc not between", value1, value2, "expdesc");
            return (Criteria) this;
        }

        public Criteria andNextauditorIsNull() {
            addCriterion("nextauditor is null");
            return (Criteria) this;
        }

        public Criteria andNextauditorIsNotNull() {
            addCriterion("nextauditor is not null");
            return (Criteria) this;
        }

        public Criteria andNextauditorEqualTo(String value) {
            addCriterion("nextauditor =", value, "nextauditor");
            return (Criteria) this;
        }

        public Criteria andNextauditorNotEqualTo(String value) {
            addCriterion("nextauditor <>", value, "nextauditor");
            return (Criteria) this;
        }

        public Criteria andNextauditorGreaterThan(String value) {
            addCriterion("nextauditor >", value, "nextauditor");
            return (Criteria) this;
        }

        public Criteria andNextauditorGreaterThanOrEqualTo(String value) {
            addCriterion("nextauditor >=", value, "nextauditor");
            return (Criteria) this;
        }

        public Criteria andNextauditorLessThan(String value) {
            addCriterion("nextauditor <", value, "nextauditor");
            return (Criteria) this;
        }

        public Criteria andNextauditorLessThanOrEqualTo(String value) {
            addCriterion("nextauditor <=", value, "nextauditor");
            return (Criteria) this;
        }

        public Criteria andNextauditorLike(String value) {
            addCriterion("nextauditor like", value, "nextauditor");
            return (Criteria) this;
        }

        public Criteria andNextauditorNotLike(String value) {
            addCriterion("nextauditor not like", value, "nextauditor");
            return (Criteria) this;
        }

        public Criteria andNextauditorIn(List<String> values) {
            addCriterion("nextauditor in", values, "nextauditor");
            return (Criteria) this;
        }

        public Criteria andNextauditorNotIn(List<String> values) {
            addCriterion("nextauditor not in", values, "nextauditor");
            return (Criteria) this;
        }

        public Criteria andNextauditorBetween(String value1, String value2) {
            addCriterion("nextauditor between", value1, value2, "nextauditor");
            return (Criteria) this;
        }

        public Criteria andNextauditorNotBetween(String value1, String value2) {
            addCriterion("nextauditor not between", value1, value2, "nextauditor");
            return (Criteria) this;
        }

        public Criteria andLastresultIsNull() {
            addCriterion("lastResult is null");
            return (Criteria) this;
        }

        public Criteria andLastresultIsNotNull() {
            addCriterion("lastResult is not null");
            return (Criteria) this;
        }

        public Criteria andLastresultEqualTo(String value) {
            addCriterion("lastResult =", value, "lastresult");
            return (Criteria) this;
        }

        public Criteria andLastresultNotEqualTo(String value) {
            addCriterion("lastResult <>", value, "lastresult");
            return (Criteria) this;
        }

        public Criteria andLastresultGreaterThan(String value) {
            addCriterion("lastResult >", value, "lastresult");
            return (Criteria) this;
        }

        public Criteria andLastresultGreaterThanOrEqualTo(String value) {
            addCriterion("lastResult >=", value, "lastresult");
            return (Criteria) this;
        }

        public Criteria andLastresultLessThan(String value) {
            addCriterion("lastResult <", value, "lastresult");
            return (Criteria) this;
        }

        public Criteria andLastresultLessThanOrEqualTo(String value) {
            addCriterion("lastResult <=", value, "lastresult");
            return (Criteria) this;
        }

        public Criteria andLastresultLike(String value) {
            addCriterion("lastResult like", value, "lastresult");
            return (Criteria) this;
        }

        public Criteria andLastresultNotLike(String value) {
            addCriterion("lastResult not like", value, "lastresult");
            return (Criteria) this;
        }

        public Criteria andLastresultIn(List<String> values) {
            addCriterion("lastResult in", values, "lastresult");
            return (Criteria) this;
        }

        public Criteria andLastresultNotIn(List<String> values) {
            addCriterion("lastResult not in", values, "lastresult");
            return (Criteria) this;
        }

        public Criteria andLastresultBetween(String value1, String value2) {
            addCriterion("lastResult between", value1, value2, "lastresult");
            return (Criteria) this;
        }

        public Criteria andLastresultNotBetween(String value1, String value2) {
            addCriterion("lastResult not between", value1, value2, "lastresult");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
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