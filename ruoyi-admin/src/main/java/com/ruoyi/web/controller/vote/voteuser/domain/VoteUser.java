package com.ruoyi.web.controller.vote.voteuser.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

/**
 * 选举人对象 tb_vote_user
 *
 * @author ruoyi
 * @date 2020-07-01
 */
@Data
public class VoteUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 选举人id
     */
    @Excel(name = "选举人id")
    private Long userId;

    private String userName;

    /**
     * 选举任务id
     */
    @Excel(name = "选举任务id")
    private Long voteId;

    /**
     * 状态（0未投票 1已投票）
     */
    @Excel(name = "状态", readConverterExp = "0=未投票,1=已投票")
    private String status;

    /**
     * 类型(1 党代表管理  2换届管理)
     */
    private String type;

    private String title;
    private String voteStatus;

}
