package com.ruoyi.web.controller.module.feel.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;


/**
 * 心得体会对象 tb_feel
 *
 * @author ruoyi
 * @date 2020-05-09
 */
@Data
public class Feel extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long feelId;

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
    private Date feelTime;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String feelTitle;

    /**
     * 内容
     */
    @Excel(name = "内容")
    private String feelContent;

    /**
     * 图片
     */
    @Excel(name = "图片")
    private String feelImg;

    /**
     * 视频
     */
    @Excel(name = "视频")
    private String feelVideo;

    /**
     * 状态（0正常 1关闭）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;

}
