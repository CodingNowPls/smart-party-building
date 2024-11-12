package com.ruoyi.party.building.vote.doamin;


import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * 被选举人对象 tb_vote_user_by
 *
 * @author ruoyi
 * @date 2020-07-01
 */
@Data
public class VoteUserBy extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 被选举人id
     */
    @Excel(name = "被选举人id")
    private Long userId;

    /**
     * 选举任务id
     */
    @Excel(name = "选举任务id")
    private Long voteId;

    private String userName;

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

}
