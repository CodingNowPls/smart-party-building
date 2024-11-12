package com.ruoyi.web.controller.module.article.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;


import java.util.Date;


/**
 * 分享美文对象 tb_article
 *
 * @author ruoyi
 * @date 2020-05-09
 */
@Data
public class Article extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long articleId;

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
     * 分享时间
     */
    @Excel(name = "分享时间", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date articleTime;

    /**
     * 美文标题
     */
    @Excel(name = "美文标题")
    private String articleTitle;

    /**
     * 美文内容
     */
    @Excel(name = "美文内容")
    private String articleContent;

    /**
     * 美文图片
     */
    @Excel(name = "美文图片")
    private String articleImg;

    /**
     * 美文视频
     */
    @Excel(name = "美文视频")
    private String articleVideo;

    /**
     * 状态（0正常 1关闭）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;

}
