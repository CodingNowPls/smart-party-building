package com.ruoyi.web.controller.module.deed.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;


/**
 * 事迹对象 tb_deed
 *
 * @author ruoyi
 * @date 2020-05-08
 */
@Data
public class Deed extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long deedId;

    /**
     * 事迹标题
     */
    @Excel(name = "事迹标题")
    private String deedTitle;

    /**
     * 封面图
     */
    @Excel(name = "封面图")
    private String deedPic;

    /**
     * 事迹内容
     */
    @Excel(name = "事迹内容")
    private String deedContent;

    /**
     * 状态（0正常 1关闭）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;

}
