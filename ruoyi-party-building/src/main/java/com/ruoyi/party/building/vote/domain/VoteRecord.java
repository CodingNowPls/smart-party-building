package com.ruoyi.party.building.vote.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.ToString;

/**
 * 投票记录对象 tb_vote_record
 *
 * @author ruoyi
 * @date 2020-07-01
 */
@Data
@ToString
public class VoteRecord extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 选择任务id
     */
    @Excel(name = "选择任务id")
    private Long voteId;

    /**
     * 选举人id
     */
    @Excel(name = "选举人id")
    private Long voteUserId;

    /**
     * 被选举人id
     */
    @Excel(name = "被选举人id")
    private Long voteUserById;

    /**
     * 票数
     */
    @Excel(name = "票数")
    private Long voteCount;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private String status;

    /**
     * 类型(1 党代表管理  2换届管理)
     */
    private String type;

    /**
     * 选择人姓名
     *
     * @param id
     */
    private String userName;

}
