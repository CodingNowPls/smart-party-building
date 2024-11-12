package com.ruoyi.party.building.vote.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * 选举任务对象 tb_vote
 *
 * @author ruoyi
 * @date 2020-06-30
 */
@Data
@ToString
public class Vote extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String title;

    /**
     * 内容
     */
    @Excel(name = "内容")
    private String content;

    /**
     * 发布状态（0未开始 1进行中 2 已结束）
     */
    @Excel(name = "发布状态", readConverterExp = "0=未开始,1=进行中,2=,已=结束")
    private String status;

    /**
     * 类型(1 党代表管理  2换届管理)
     */
    private String type;
    /**
     * 被选举人
     *
     * @param id
     */
    private String userByIds;

    /**
     * 选择人id
     *
     * @param id
     */
    private String userIds;

}
