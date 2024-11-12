package com.ruoyi.web.controller.module.questionpager.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 题目试卷关联对象 tb_question_pager
 *
 * @author ruoyi
 * @date 2020-06-06
 */
public class QuestionPager extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 题目id
     */
    @Excel(name = "题目id")
    private Long questionId;

    /**
     * 试卷id
     */
    @Excel(name = "试卷id")
    private Long pagerId;

    /**
     * 排序
     *
     * @param id
     */
    private Long rank;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getPagerId() {
        return pagerId;
    }

    public void setPagerId(Long pagerId) {
        this.pagerId = pagerId;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("questionId", getQuestionId())
                .append("pagerId", getPagerId())
                .toString();
    }
}
