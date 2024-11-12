package com.ruoyi.web.controller.module.violate.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 违规违纪对象 tb_violate
 *
 * @author ruoyi
 * @date 2020-06-22
 */
@Data
public class Violate extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String name;

    /**
     * 事件
     */
    @Excel(name = "事件")
    private String event;

    /**
     * 处罚
     */
    @Excel(name = "处罚")
    private String punish;

    /**
     * 开始时间
     */
    @Excel(name = "开始时间")
    private String startTime;

    /**
     * 结束时间
     */
    @Excel(name = "结束时间")
    private String endTime;

    /**
     * 状态（0正常 1关闭）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;

}
