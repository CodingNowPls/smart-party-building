package com.ruoyi.web.controller.module.news.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;


/**
 * 资讯对象 tb_news
 *
 * @author ruoyi
 * @date 2020-05-06
 */
@Data
public class News extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long newId;

    /**
     * 资讯标题
     */
    @Excel(name = "资讯标题")
    private String newTitle;

    /**
     * 封面图
     */
    @Excel(name = "封面图")
    private String newPic;

    /**
     * 资讯分类id
     */
    @Excel(name = "资讯分类id")
    private String newTypeId;
    private String typeName;

    /**
     * 上传至部门id
     */
    @Excel(name = "上传至部门id")
    private Long deptId;

    private String deptName;

    /**
     * 资讯内容
     */
    @Excel(name = "资讯内容")
    private String newContent;

    /**
     * 上传文件地址
     */
    @Excel(name = "上传文件地址")
    private String newFile;

    /**
     * 上传视频地址
     */
    @Excel(name = "上传视频地址")
    private String newVideo;

    /**
     * 审核人id
     */
    @Excel(name = "审核人id")
    private Long userId;

    /**
     * 审核人名称
     */
    @Excel(name = "审核人名称")
    private String userName;

    /**
     * 审核状态(1 待审核 2 审核通过  )
     */
    @Excel(name = "审核状态(1 待审核 2 审核通过  )")
    private String status;

    /**
     * 类型(1资讯 2在线学习)
     */
    @Excel(name = "类型(1资讯 2在线学习)")
    private String type;

    private String learnStatus;

}
