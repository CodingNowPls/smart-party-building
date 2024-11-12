package com.ruoyi.party.building.answer.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.web.controller.module.question.domain.Question;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 试卷答案对象 tb_pager_answer
 *
 * @author ruoyi
 * @date 2020-06-08
 */
public class PagerAnswer extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 试卷id
     */
    @Excel(name = "试卷id")
    private Long pagerId;

    /**
     * 题目id
     */
    @Excel(name = "题目id")
    private Long questionId;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;

    /**
     * 用户答案
     */
    @Excel(name = "用户答案")
    private String answer;

    /**
     * 答案是否正确
     */
    @Excel(name = "答案是否正确")
    private String isRight;

    /**
     * 得分
     */
    @Excel(name = "得分")
    private Long mark;

    /**
     * 批改状态 0待批改 1 错误 2 正确
     */
    @Excel(name = "批改状态 0待批改 1 错误 2 正确  ")
    private String status;

    private String pagerName; //试卷名称
    private String userName; //用户名称
    private Long totalScore; //总分
    private Long totalCount; //总题目
    private Long rightCount; //做对题目数
    private Long errorCount; //做错题目数
    private Long answerCount; //待批改题目属

    private Question question;

    private String rightAnswer;
    private String confirm;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPagerId() {
        return pagerId;
    }

    public void setPagerId(Long pagerId) {
        this.pagerId = pagerId;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getIsRight() {
        return isRight;
    }

    public void setIsRight(String isRight) {
        this.isRight = isRight;
    }

    public Long getMark() {
        return mark;
    }

    public void setMark(Long mark) {
        this.mark = mark;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPagerName() {
        return pagerName;
    }

    public void setPagerName(String pagerName) {
        this.pagerName = pagerName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Long totalScore) {
        this.totalScore = totalScore;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public Long getRightCount() {
        return rightCount;
    }

    public void setRightCount(Long rightCount) {
        this.rightCount = rightCount;
    }

    public Long getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Long errorCount) {
        this.errorCount = errorCount;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }


    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public Long getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(Long answerCount) {
        this.answerCount = answerCount;
    }

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("pagerId", getPagerId())
                .append("questionId", getQuestionId())
                .append("userId", getUserId())
                .append("answer", getAnswer())
                .append("isRight", getIsRight())
                .append("mark", getMark())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
