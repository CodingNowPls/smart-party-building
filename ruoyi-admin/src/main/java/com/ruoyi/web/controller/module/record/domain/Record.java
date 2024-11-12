package com.ruoyi.web.controller.module.record.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


import java.util.Date;

/**
 * 会议记录对象 tb_record
 *
 * @author ruoyi
 * @date 2020-05-09
 */
@Data
public class Record extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long recordId;

    /**
     * 部门id
     */
    @Excel(name = "部门id")
    private Long deptId;

    private String deptName;

    /**
     * 记录人id
     */
    @Excel(name = "记录人id")
    private Long userId;

    /**
     * 记录人姓名
     */
    @Excel(name = "记录人姓名")
    private String userName;

    /**
     * 记录时间
     */
    @Excel(name = "记录时间", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date recordTime;

    /**
     * 会议记录标题
     */
    @Excel(name = "会议记录标题")
    private String recordTitle;

    /**
     * 会议记录内容
     */
    @Excel(name = "会议记录内容")
    private String recordContent;

    /**
     * 记录图片
     */
    @Excel(name = "记录图片")
    private String recordImg;

    /**
     * 记录视频
     */
    @Excel(name = "记录视频")
    private String recordVideo;

    /**
     * 状态（0正常 1关闭）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;

}
