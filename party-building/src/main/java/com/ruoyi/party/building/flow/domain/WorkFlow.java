package com.ruoyi.party.building.flow.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;


/**
 * 任务流程对象 tb_work_flow
 *
 * @author ruoyi
 * @date 2020-05-18
 */
@Data
public class WorkFlow extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long flowId;

    /**
     * 任务id
     */
    @Excel(name = "任务id")
    private Long workId;

    private Long distId;

    /**
     * 处理人id
     */
    @Excel(name = "处理人id")
    private Long dealId;

    /**
     * 处理人姓名
     */
    @Excel(name = "处理人姓名")
    private String dealName;

    /**
     * 当前状态
     */
    @Excel(name = "当前状态")
    private String currentStatus;

    /**
     * 等级(1 执行人 2 验证人)
     */
    @Excel(name = "等级(1 执行人 2 验证人)")
    private String level;

    /**
     * 执行状态(1 执行中 2 已完成 3不同意  4 同意)
     */
    @Excel(name = "执行状态(1 执行中 2 已完成 3不同意  4 同意) ")
    private String dealStatus;

    /**
     * 动作(1执行人执行 2 提交人验证)
     */
    @Excel(name = "动作(1执行人执行 2 提交人验证)")
    private String actionName;

    /**
     * 执行说明
     */
    @Excel(name = "执行说明")
    private String dealExplain;

    /**
     * 执行时间
     */
    @Excel(name = "执行时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date dealTime;

}
