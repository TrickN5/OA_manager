package com.oa.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AuditingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AuditingExample() {
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

        public Criteria andAuditidIsNull() {
            addCriterion("auditid is null");
            return (Criteria) this;
        }

        public Criteria andAuditidIsNotNull() {
            addCriterion("auditid is not null");
            return (Criteria) this;
        }

        public Criteria andAuditidEqualTo(Integer value) {
            addCriterion("auditid =", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidNotEqualTo(Integer value) {
            addCriterion("auditid <>", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidGreaterThan(Integer value) {
            addCriterion("auditid >", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidGreaterThanOrEqualTo(Integer value) {
            addCriterion("auditid >=", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidLessThan(Integer value) {
            addCriterion("auditid <", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidLessThanOrEqualTo(Integer value) {
            addCriterion("auditid <=", value, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidIn(List<Integer> values) {
            addCriterion("auditid in", values, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidNotIn(List<Integer> values) {
            addCriterion("auditid not in", values, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidBetween(Integer value1, Integer value2) {
            addCriterion("auditid between", value1, value2, "auditid");
            return (Criteria) this;
        }

        public Criteria andAuditidNotBetween(Integer value1, Integer value2) {
            addCriterion("auditid not between", value1, value2, "auditid");
            return (Criteria) this;
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

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andAuditdescIsNull() {
            addCriterion("auditdesc is null");
            return (Criteria) this;
        }

        public Criteria andAuditdescIsNotNull() {
            addCriterion("auditdesc is not null");
            return (Criteria) this;
        }

        public Criteria andAuditdescEqualTo(String value) {
            addCriterion("auditdesc =", value, "auditdesc");
            return (Criteria) this;
        }

        public Criteria andAuditdescNotEqualTo(String value) {
            addCriterion("auditdesc <>", value, "auditdesc");
            return (Criteria) this;
        }

        public Criteria andAuditdescGreaterThan(String value) {
            addCriterion("auditdesc >", value, "auditdesc");
            return (Criteria) this;
        }

        public Criteria andAuditdescGreaterThanOrEqualTo(String value) {
            addCriterion("auditdesc >=", value, "auditdesc");
            return (Criteria) this;
        }

        public Criteria andAuditdescLessThan(String value) {
            addCriterion("auditdesc <", value, "auditdesc");
            return (Criteria) this;
        }

        public Criteria andAuditdescLessThanOrEqualTo(String value) {
            addCriterion("auditdesc <=", value, "auditdesc");
            return (Criteria) this;
        }

        public Criteria andAuditdescLike(String value) {
            addCriterion("auditdesc like", value, "auditdesc");
            return (Criteria) this;
        }

        public Criteria andAuditdescNotLike(String value) {
            addCriterion("auditdesc not like", value, "auditdesc");
            return (Criteria) this;
        }

        public Criteria andAuditdescIn(List<String> values) {
            addCriterion("auditdesc in", values, "auditdesc");
            return (Criteria) this;
        }

        public Criteria andAuditdescNotIn(List<String> values) {
            addCriterion("auditdesc not in", values, "auditdesc");
            return (Criteria) this;
        }

        public Criteria andAuditdescBetween(String value1, String value2) {
            addCriterion("auditdesc between", value1, value2, "auditdesc");
            return (Criteria) this;
        }

        public Criteria andAuditdescNotBetween(String value1, String value2) {
            addCriterion("auditdesc not between", value1, value2, "auditdesc");
            return (Criteria) this;
        }

        public Criteria andTimeIsNull() {
            addCriterion("time is null");
            return (Criteria) this;
        }

        public Criteria andTimeIsNotNull() {
            addCriterion("time is not null");
            return (Criteria) this;
        }

        public Criteria andTimeEqualTo(Date value) {
            addCriterionForJDBCDate("time =", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("time <>", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("time >", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("time >=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThan(Date value) {
            addCriterionForJDBCDate("time <", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("time <=", value, "time");
            return (Criteria) this;
        }

        public Criteria andTimeIn(List<Date> values) {
            addCriterionForJDBCDate("time in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("time not in", values, "time");
            return (Criteria) this;
        }

        public Criteria andTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("time between", value1, value2, "time");
            return (Criteria) this;
        }

        public Criteria andTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("time not between", value1, value2, "time");
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