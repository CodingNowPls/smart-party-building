package com.ruoyi.web.controller.module.problem.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 问题墙对象 tb_problem
 *
 * @author ruoyi
 * @date 2020-05-11
 */
public class Problem extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long problemId;

    /**
     * 部门id
     */
    @Excel(name = "部门id")
    private Long deptId;

    private String deptName;

    /**
     * 提交人id
     */
    @Excel(name = "提交人id")
    private Long userId;

    /**
     * 提交人姓名
     */
    @Excel(name = "提交人姓名")
    private String userName;

    /**
     * 提交时间
     */
    @Excel(name = "提交时间", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date problemTime;

    /**
     * 问题标题
     */
    @Excel(name = "问题标题")
    private String problemTitle;

    /**
     * 问题描述
     */
    @Excel(name = "问题描述")
    private String problemContent;

    /**
     * 问题图片
     */
    @Excel(name = "问题图片")
    private String problemImg;

    /**
     * 问题视频
     */
    @Excel(name = "问题视频")
    private String problemVideo;

    /**
     * 状态（0正常 1关闭）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;

    public Long getProblemId() {
        return problemId;
    }

    public void setProblemId(Long problemId) {
        this.problemId = problemId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getProblemTime() {
        return problemTime;
    }

    public void setProblemTime(Date problemTime) {
        this.problemTime = problemTime;
    }

    public String getProblemTitle() {
        return problemTitle;
    }

    public void setProblemTitle(String problemTitle) {
        this.problemTitle = problemTitle;
    }

    public String getProblemContent() {
        return problemContent;
    }

    public void setProblemContent(String problemContent) {
        this.problemContent = problemContent;
    }

    public String getProblemImg() {
        return problemImg;
    }

    public void setProblemImg(String problemImg) {
        this.problemImg = problemImg;
    }

    public String getProblemVideo() {
        return problemVideo;
    }

    public void setProblemVideo(String problemVideo) {
        this.problemVideo = problemVideo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("problemId", getProblemId())
                .append("deptId", getDeptId())
                .append("userId", getUserId())
                .append("userName", getUserName())
                .append("problemTime", getProblemTime())
                .append("problemTitle", getProblemTitle())
                .append("problemContent", getProblemContent())
                .append("problemImg", getProblemImg())
                .append("problemVideo", getProblemVideo())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
