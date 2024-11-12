package com.ruoyi.party.building.question.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 题目对象 tb_question
 *
 * @author ruoyi
 * @date 2020-06-04
 */
public class Question extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 题库分类id
     */
    @Excel(name = "题库分类id")
    private Long typeId;
    private String typeName;

    /**
     * 1.单选题  2.多选题  3.判断题 4.简答题
     */
    @Excel(name = "1.单选题  2.多选题  3.判断题 4.简答题")
    private Long questionType;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String title;

    /**
     * 题目难度
     */
    private String difficult;

    /**
     * 答案A
     */
    @Excel(name = "答案A")
    private String answerA;

    /**
     * 答案B
     */
    @Excel(name = "答案B")
    private String answerB;

    /**
     * 答案C
     */
    @Excel(name = "答案C")
    private String answerC;

    /**
     * 答案D
     */
    @Excel(name = "答案D")
    private String answerD;

    /**
     * 答案E
     */

    private String answerE;

    /**
     * 答案
     */
    @Excel(name = "答案")
    private String answer;

    /**
     * 题内容
     */
    private String content;

    /**
     * 解析
     */
    @Excel(name = "解析")
    private String introduce;

    /**
     * 分数
     */
    @Excel(name = "分数")
    private Long score;

    private String pagerName;
    private String ksTime;
    private Long rank; //排序
    private Long qpId; //试卷与题目关联表id


    /**
     * 状态（0正常 1关闭）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getQuestionType() {
        return questionType;
    }

    public void setQuestionType(Long questionType) {
        this.questionType = questionType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDifficult() {
        return difficult;
    }

    public void setDifficult(String difficult) {
        this.difficult = difficult;
    }

    public String getAnswerA() {
        return answerA;
    }

    public void setAnswerA(String answerA) {
        this.answerA = answerA;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public String getAnswerE() {
        return answerE;
    }

    public void setAnswerE(String answerE) {
        this.answerE = answerE;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
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

    public String getKsTime() {
        return ksTime;
    }

    public void setKsTime(String ksTime) {
        this.ksTime = ksTime;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Long getQpId() {
        return qpId;
    }

    public void setQpId(Long qpId) {
        this.qpId = qpId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("typeId", getTypeId())
                .append("questionType", getQuestionType())
                .append("title", getTitle())
                .append("difficult", getDifficult())
                .append("answerA", getAnswerA())
                .append("answerB", getAnswerB())
                .append("answerC", getAnswerC())
                .append("answerD", getAnswerD())
                .append("answerE", getAnswerE())
                .append("answer", getAnswer())
                .append("content", getContent())
                .append("score", getScore())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
