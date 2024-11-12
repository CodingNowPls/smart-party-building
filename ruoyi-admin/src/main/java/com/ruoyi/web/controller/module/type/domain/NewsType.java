package com.ruoyi.web.controller.module.type.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * 资讯分类对象 tb_news_type
 *
 * @author ruoyi
 * @date 2020-05-06
 */
@Data
public class NewsType extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long typeId;

    /**
     * 分类名称
     */
    @Excel(name = "分类名称")
    private String typeName;

    /**
     * 类型(1资讯 2在线学习)
     */
    @Excel(name = "类型(1资讯 2在线学习)")
    private String type;

}
