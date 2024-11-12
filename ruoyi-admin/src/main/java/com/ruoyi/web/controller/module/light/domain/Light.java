package com.ruoyi.web.controller.module.light.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;


/**
 * 亮点对象 tb_light
 *
 * @author ruoyi
 * @date 2020-05-08
 */
@Data
public class Light extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long lightId;

    /**
     * 亮点标题
     */
    @Excel(name = "亮点标题")
    private String lightTitle;

    /**
     * 亮点主图
     */
    @Excel(name = "亮点主图")
    private String lightPic;

    /**
     * 亮点内容
     */
    @Excel(name = "亮点内容")
    private String lightContent;

    /**
     * 状态（0正常 1关闭）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;

}
