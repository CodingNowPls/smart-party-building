package com.ruoyi.web.controller.module.picture.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * 首页轮播图对象 tb_picture
 *
 * @author ruoyi
 * @date 2020-05-25
 */
@Data
public class Picture extends BaseEntity {
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
     * 图片地址
     */
    @Excel(name = "图片地址")
    private String photo;

    /**
     * 内容详情
     */
    @Excel(name = "内容详情")
    private String content;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private String status;

}
