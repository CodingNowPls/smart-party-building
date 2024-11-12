package com.ruoyi.party.building.detail.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 个人履历对象 tb_user_detail
 *
 * @author ruoyi
 * @date 2020-05-14
 */
@Data
public class UserDetail extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long detailId;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;

    private String userName;

    /**
     * 履历文件
     */
    @Excel(name = "履历文件")
    private String userFile;

    /**
     * 开始时间
     */
    @Excel(name = "开始时间")
    private String startTime;

    /**
     * 结束时间
     */
    @Excel(name = "结束时间")
    private String endTime;

    /**
     * 履历介绍
     */
    @Excel(name = "履历介绍")
    private String introduce;

    /**
     * 状态（0正常 1关闭）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserFile() {
        return userFile;
    }

    public void setUserFile(String userFile) {
        this.userFile = userFile;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("detailId", getDetailId())
                .append("userId", getUserId())
                .append("userFile", getUserFile())
                .append("startTime", getStartTime())
                .append("endTime", getEndTime())
                .append("introduce", getIntroduce())
                .append("status", getStatus())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
