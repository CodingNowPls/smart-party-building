package com.ruoyi.party.building.pager.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;


/**
 * 试卷对象 tb_pager
 *
 * @author ruoyi
 * @date 2020-06-05
 */
@Data
public class Pager extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 试卷名称
     */
    @Excel(name = "试卷名称")
    private String name;

    /**
     * 考试对象
     */
    @Excel(name = "考试对象")
    private String userId;

    /**
     * 试卷开始时间
     */
    @Excel(name = "试卷开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /**
     * 试卷结束时间
     */
    @Excel(name = "试卷结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /**
     * 考试时间(分钟)
     */
    @Excel(name = "考试时间(分钟)")
    private Long ksTime;

    /**
     * 总分
     */
    @Excel(name = "总分")
    private Long score;

    /**
     * 合格分数
     */
    @Excel(name = "合格分数")
    private Long passScore;

    /**
     * 是否发布
     */
    @Excel(name = "是否发布")
    private Integer publish;

    /**
     * 状态（0正常 1关闭）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;

    private String questionIds;

}
