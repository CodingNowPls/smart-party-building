package com.ruoyi.party.building.exchange.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;


/**
 * 交流对象 tb_exchange
 *
 * @author ruoyi
 * @date 2020-05-08
 */
@Data
public class Exchange extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long exchangeId;

    /**
     * 交流标题
     */
    @Excel(name = "交流标题")
    private String exchangeTitle;

    /**
     * 封面图
     */
    @Excel(name = "封面图")
    private String exchangePic;

    /**
     * 交流内容
     */
    @Excel(name = "交流内容")
    private String exchangeContent;

    /**
     * 状态（0正常 1关闭）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;

}
