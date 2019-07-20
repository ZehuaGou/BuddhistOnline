package com.buddhist.user.model;

import java.util.ArrayList;
import java.util.List;

public class OrderFormExample
{
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderFormExample() {
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

        public Criteria andOidIsNull() {
            addCriterion("oid is null");
            return (Criteria) this;
        }

        public Criteria andOidIsNotNull() {
            addCriterion("oid is not null");
            return (Criteria) this;
        }

        public Criteria andOidEqualTo(Integer value) {
            addCriterion("oid =", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotEqualTo(Integer value) {
            addCriterion("oid <>", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThan(Integer value) {
            addCriterion("oid >", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidGreaterThanOrEqualTo(Integer value) {
            addCriterion("oid >=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThan(Integer value) {
            addCriterion("oid <", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidLessThanOrEqualTo(Integer value) {
            addCriterion("oid <=", value, "oid");
            return (Criteria) this;
        }

        public Criteria andOidIn(List<Integer> values) {
            addCriterion("oid in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotIn(List<Integer> values) {
            addCriterion("oid not in", values, "oid");
            return (Criteria) this;
        }

        public Criteria andOidBetween(Integer value1, Integer value2) {
            addCriterion("oid between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andOidNotBetween(Integer value1, Integer value2) {
            addCriterion("oid not between", value1, value2, "oid");
            return (Criteria) this;
        }

        public Criteria andSidIsNull() {
            addCriterion("sid is null");
            return (Criteria) this;
        }

        public Criteria andSidIsNotNull() {
            addCriterion("sid is not null");
            return (Criteria) this;
        }

        public Criteria andSidEqualTo(Integer value) {
            addCriterion("sid =", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotEqualTo(Integer value) {
            addCriterion("sid <>", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThan(Integer value) {
            addCriterion("sid >", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidGreaterThanOrEqualTo(Integer value) {
            addCriterion("sid >=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThan(Integer value) {
            addCriterion("sid <", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidLessThanOrEqualTo(Integer value) {
            addCriterion("sid <=", value, "sid");
            return (Criteria) this;
        }

        public Criteria andSidIn(List<Integer> values) {
            addCriterion("sid in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotIn(List<Integer> values) {
            addCriterion("sid not in", values, "sid");
            return (Criteria) this;
        }

        public Criteria andSidBetween(Integer value1, Integer value2) {
            addCriterion("sid between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andSidNotBetween(Integer value1, Integer value2) {
            addCriterion("sid not between", value1, value2, "sid");
            return (Criteria) this;
        }

        public Criteria andXidIsNull() {
            addCriterion("xid is null");
            return (Criteria) this;
        }

        public Criteria andXidIsNotNull() {
            addCriterion("xid is not null");
            return (Criteria) this;
        }

        public Criteria andXidEqualTo(Integer value) {
            addCriterion("xid =", value, "xid");
            return (Criteria) this;
        }

        public Criteria andXidNotEqualTo(Integer value) {
            addCriterion("xid <>", value, "xid");
            return (Criteria) this;
        }

        public Criteria andXidGreaterThan(Integer value) {
            addCriterion("xid >", value, "xid");
            return (Criteria) this;
        }

        public Criteria andXidGreaterThanOrEqualTo(Integer value) {
            addCriterion("xid >=", value, "xid");
            return (Criteria) this;
        }

        public Criteria andXidLessThan(Integer value) {
            addCriterion("xid <", value, "xid");
            return (Criteria) this;
        }

        public Criteria andXidLessThanOrEqualTo(Integer value) {
            addCriterion("xid <=", value, "xid");
            return (Criteria) this;
        }

        public Criteria andXidIn(List<Integer> values) {
            addCriterion("xid in", values, "xid");
            return (Criteria) this;
        }

        public Criteria andXidNotIn(List<Integer> values) {
            addCriterion("xid not in", values, "xid");
            return (Criteria) this;
        }

        public Criteria andXidBetween(Integer value1, Integer value2) {
            addCriterion("xid between", value1, value2, "xid");
            return (Criteria) this;
        }

        public Criteria andXidNotBetween(Integer value1, Integer value2) {
            addCriterion("xid not between", value1, value2, "xid");
            return (Criteria) this;
        }

        public Criteria andDidIsNull() {
            addCriterion("did is null");
            return (Criteria) this;
        }

        public Criteria andDidIsNotNull() {
            addCriterion("did is not null");
            return (Criteria) this;
        }

        public Criteria andDidEqualTo(Integer value) {
            addCriterion("did =", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotEqualTo(Integer value) {
            addCriterion("did <>", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThan(Integer value) {
            addCriterion("did >", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidGreaterThanOrEqualTo(Integer value) {
            addCriterion("did >=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThan(Integer value) {
            addCriterion("did <", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidLessThanOrEqualTo(Integer value) {
            addCriterion("did <=", value, "did");
            return (Criteria) this;
        }

        public Criteria andDidIn(List<Integer> values) {
            addCriterion("did in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotIn(List<Integer> values) {
            addCriterion("did not in", values, "did");
            return (Criteria) this;
        }

        public Criteria andDidBetween(Integer value1, Integer value2) {
            addCriterion("did between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andDidNotBetween(Integer value1, Integer value2) {
            addCriterion("did not between", value1, value2, "did");
            return (Criteria) this;
        }

        public Criteria andAnswerOneIsNull() {
            addCriterion("answer_one is null");
            return (Criteria) this;
        }

        public Criteria andAnswerOneIsNotNull() {
            addCriterion("answer_one is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerOneEqualTo(String value) {
            addCriterion("answer_one =", value, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneNotEqualTo(String value) {
            addCriterion("answer_one <>", value, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneGreaterThan(String value) {
            addCriterion("answer_one >", value, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneGreaterThanOrEqualTo(String value) {
            addCriterion("answer_one >=", value, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneLessThan(String value) {
            addCriterion("answer_one <", value, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneLessThanOrEqualTo(String value) {
            addCriterion("answer_one <=", value, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneLike(String value) {
            addCriterion("answer_one like", value, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneNotLike(String value) {
            addCriterion("answer_one not like", value, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneIn(List<String> values) {
            addCriterion("answer_one in", values, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneNotIn(List<String> values) {
            addCriterion("answer_one not in", values, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneBetween(String value1, String value2) {
            addCriterion("answer_one between", value1, value2, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerOneNotBetween(String value1, String value2) {
            addCriterion("answer_one not between", value1, value2, "answerOne");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoIsNull() {
            addCriterion("answer_two is null");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoIsNotNull() {
            addCriterion("answer_two is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoEqualTo(String value) {
            addCriterion("answer_two =", value, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoNotEqualTo(String value) {
            addCriterion("answer_two <>", value, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoGreaterThan(String value) {
            addCriterion("answer_two >", value, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoGreaterThanOrEqualTo(String value) {
            addCriterion("answer_two >=", value, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoLessThan(String value) {
            addCriterion("answer_two <", value, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoLessThanOrEqualTo(String value) {
            addCriterion("answer_two <=", value, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoLike(String value) {
            addCriterion("answer_two like", value, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoNotLike(String value) {
            addCriterion("answer_two not like", value, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoIn(List<String> values) {
            addCriterion("answer_two in", values, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoNotIn(List<String> values) {
            addCriterion("answer_two not in", values, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoBetween(String value1, String value2) {
            addCriterion("answer_two between", value1, value2, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andAnswerTwoNotBetween(String value1, String value2) {
            addCriterion("answer_two not between", value1, value2, "answerTwo");
            return (Criteria) this;
        }

        public Criteria andRequireIsNull() {
            addCriterion("require is null");
            return (Criteria) this;
        }

        public Criteria andRequireIsNotNull() {
            addCriterion("require is not null");
            return (Criteria) this;
        }

        public Criteria andRequireEqualTo(String value) {
            addCriterion("require =", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireNotEqualTo(String value) {
            addCriterion("require <>", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireGreaterThan(String value) {
            addCriterion("require >", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireGreaterThanOrEqualTo(String value) {
            addCriterion("require >=", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireLessThan(String value) {
            addCriterion("require <", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireLessThanOrEqualTo(String value) {
            addCriterion("require <=", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireLike(String value) {
            addCriterion("require like", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireNotLike(String value) {
            addCriterion("require not like", value, "require");
            return (Criteria) this;
        }

        public Criteria andRequireIn(List<String> values) {
            addCriterion("require in", values, "require");
            return (Criteria) this;
        }

        public Criteria andRequireNotIn(List<String> values) {
            addCriterion("require not in", values, "require");
            return (Criteria) this;
        }

        public Criteria andRequireBetween(String value1, String value2) {
            addCriterion("require between", value1, value2, "require");
            return (Criteria) this;
        }

        public Criteria andRequireNotBetween(String value1, String value2) {
            addCriterion("require not between", value1, value2, "require");
            return (Criteria) this;
        }

        public Criteria andPlayUrlIsNull() {
            addCriterion("play_url is null");
            return (Criteria) this;
        }

        public Criteria andPlayUrlIsNotNull() {
            addCriterion("play_url is not null");
            return (Criteria) this;
        }

        public Criteria andPlayUrlEqualTo(String value) {
            addCriterion("play_url =", value, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlNotEqualTo(String value) {
            addCriterion("play_url <>", value, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlGreaterThan(String value) {
            addCriterion("play_url >", value, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlGreaterThanOrEqualTo(String value) {
            addCriterion("play_url >=", value, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlLessThan(String value) {
            addCriterion("play_url <", value, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlLessThanOrEqualTo(String value) {
            addCriterion("play_url <=", value, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlLike(String value) {
            addCriterion("play_url like", value, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlNotLike(String value) {
            addCriterion("play_url not like", value, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlIn(List<String> values) {
            addCriterion("play_url in", values, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlNotIn(List<String> values) {
            addCriterion("play_url not in", values, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlBetween(String value1, String value2) {
            addCriterion("play_url between", value1, value2, "playUrl");
            return (Criteria) this;
        }

        public Criteria andPlayUrlNotBetween(String value1, String value2) {
            addCriterion("play_url not between", value1, value2, "playUrl");
            return (Criteria) this;
        }

        public Criteria andFinishIsNull() {
            addCriterion("finish is null");
            return (Criteria) this;
        }

        public Criteria andFinishIsNotNull() {
            addCriterion("finish is not null");
            return (Criteria) this;
        }

        public Criteria andFinishEqualTo(String value) {
            addCriterion("finish =", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishNotEqualTo(String value) {
            addCriterion("finish <>", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishGreaterThan(String value) {
            addCriterion("finish >", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishGreaterThanOrEqualTo(String value) {
            addCriterion("finish >=", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishLessThan(String value) {
            addCriterion("finish <", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishLessThanOrEqualTo(String value) {
            addCriterion("finish <=", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishLike(String value) {
            addCriterion("finish like", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishNotLike(String value) {
            addCriterion("finish not like", value, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishIn(List<String> values) {
            addCriterion("finish in", values, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishNotIn(List<String> values) {
            addCriterion("finish not in", values, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishBetween(String value1, String value2) {
            addCriterion("finish between", value1, value2, "finish");
            return (Criteria) this;
        }

        public Criteria andFinishNotBetween(String value1, String value2) {
            addCriterion("finish not between", value1, value2, "finish");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(Integer value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(Integer value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(Integer value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(Integer value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(Integer value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<Integer> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<Integer> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(Integer value1, Integer value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsNull() {
            addCriterion("evaluate is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateIsNotNull() {
            addCriterion("evaluate is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateEqualTo(String value) {
            addCriterion("evaluate =", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotEqualTo(String value) {
            addCriterion("evaluate <>", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateGreaterThan(String value) {
            addCriterion("evaluate >", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateGreaterThanOrEqualTo(String value) {
            addCriterion("evaluate >=", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateLessThan(String value) {
            addCriterion("evaluate <", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateLessThanOrEqualTo(String value) {
            addCriterion("evaluate <=", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateLike(String value) {
            addCriterion("evaluate like", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotLike(String value) {
            addCriterion("evaluate not like", value, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateIn(List<String> values) {
            addCriterion("evaluate in", values, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotIn(List<String> values) {
            addCriterion("evaluate not in", values, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateBetween(String value1, String value2) {
            addCriterion("evaluate between", value1, value2, "evaluate");
            return (Criteria) this;
        }

        public Criteria andEvaluateNotBetween(String value1, String value2) {
            addCriterion("evaluate not between", value1, value2, "evaluate");
            return (Criteria) this;
        }

        public Criteria andMessageIsNull() {
            addCriterion("message is null");
            return (Criteria) this;
        }

        public Criteria andMessageIsNotNull() {
            addCriterion("message is not null");
            return (Criteria) this;
        }

        public Criteria andMessageEqualTo(String value) {
            addCriterion("message =", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotEqualTo(String value) {
            addCriterion("message <>", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThan(String value) {
            addCriterion("message >", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageGreaterThanOrEqualTo(String value) {
            addCriterion("message >=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThan(String value) {
            addCriterion("message <", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLessThanOrEqualTo(String value) {
            addCriterion("message <=", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageLike(String value) {
            addCriterion("message like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotLike(String value) {
            addCriterion("message not like", value, "message");
            return (Criteria) this;
        }

        public Criteria andMessageIn(List<String> values) {
            addCriterion("message in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotIn(List<String> values) {
            addCriterion("message not in", values, "message");
            return (Criteria) this;
        }

        public Criteria andMessageBetween(String value1, String value2) {
            addCriterion("message between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andMessageNotBetween(String value1, String value2) {
            addCriterion("message not between", value1, value2, "message");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("flag like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("flag not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("flag not between", value1, value2, "flag");
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