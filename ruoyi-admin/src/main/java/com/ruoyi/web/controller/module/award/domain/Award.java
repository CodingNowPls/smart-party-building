package com.ruoyi.web.controller.module.award.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;


/**
 * 奖项对象 tb_award
 *
 * @author ruoyi
 * @date 2020-05-08
 */
@Data
public class Award extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long awardId;

    /**
     * 奖项标题
     */
    @Excel(name = "奖项标题")
    private String awardTitle;

    /**
     * 封面图
     */
    @Excel(name = "封面图")
    private String awardPic;

    /**
     * 奖项内容
     */
    @Excel(name = "奖项内容")
    private String awardContent;

    /**
     * 状态（0正常 1关闭）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;

}
