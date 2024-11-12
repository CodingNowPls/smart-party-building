package com.ruoyi.web.controller.vote.vote.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 选举任务对象 tb_vote
 *
 * @author ruoyi
 * @date 2020-06-30
 */
@Data
public class Vote extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String title;

    /**
     * 内容
     */
    @Excel(name = "内容")
    private String content;

    /**
     * 发布状态（0未开始 1进行中 2 已结束）
     */
    @Excel(name = "发布状态", readConverterExp = "0=未开始,1=进行中,2=,已=结束")
    private String status;

    /**
     * 类型(1 党代表管理  2换届管理)
     */
    private String type;
    /**
     * 被选举人
     *
     * @param id
     */
    private String userByIds; //被选举人id

    /**
     * 选择人id
     *
     * @param id
     */
    private String userIds; //选择人id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserByIds() {
        return userByIds;
    }

    public void setUserByIds(String userByIds) {
        this.userByIds = userByIds;
    }

    public String getUserIds() {
        return userIds;
    }

    public void setUserIds(String userIds) {
        this.userIds = userIds;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("content", getContent())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("type", getType())
                .toString();
    }
}
