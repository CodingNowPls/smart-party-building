package com.ruoyi.web.controller.module.inspect.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 视察对象 tb_inspect
 *
 * @author ruoyi
 * @date 2020-05-07
 */
@Data
public class Inspect extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long inspectId;

    /**
     * 视察标题
     */
    @Excel(name = "视察标题")
    private String inspectTitle;

    /**
     * 封面图
     */
    @Excel(name = "封面图")
    private String inspectPic;

    /**
     * 视察内容
     */
    @Excel(name = "视察内容")
    private String inspectContent;

    /**
     * 状态（0正常 1关闭）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;

}
