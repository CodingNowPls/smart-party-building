package com.ruoyi.web.controller.module.plan.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;


/**
 * 学习计划对象 tb_plan
 *
 * @author ruoyi
 * @date 2020-05-09
 */
@Data
public class Plan extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long planId;

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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date planTime;

    /**
     * 学习计划标题
     */
    @Excel(name = "学习计划标题")
    private String planTitle;

    /**
     * 学习计划内容
     */
    @Excel(name = "学习计划内容")
    private String planContent;

    /**
     * 图片
     */
    @Excel(name = "图片")
    private String planImg;

    /**
     * 视频
     */
    @Excel(name = "视频")
    private String planVideo;

    /**
     * 状态（0正常 1关闭）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;

}
