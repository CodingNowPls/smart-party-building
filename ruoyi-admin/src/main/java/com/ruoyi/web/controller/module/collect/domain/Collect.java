package com.ruoyi.web.controller.module.collect.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 学习收藏对象 tb_collect
 *
 * @author ruoyi
 * @date 2020-07-10
 */
@Data
public class Collect extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;
    private String userName;

    /**
     * 学习id
     */
    @Excel(name = "学习id")
    private Long newId;

    private String newTitle; //标题
    /**
     * 状态
     */
    @Excel(name = "状态")
    private String status;

}
