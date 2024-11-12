package com.ruoyi.web.controller.vote.userby.service;

import com.ruoyi.web.controller.vote.userby.domain.VoteUserBy;

import java.util.List;

/**
 * 被选举人Service接口
 *
 * @author ruoyi
 * @date 2020-07-01
 */
public interface IVoteUserByService {
    /**
     * 查询被选举人
     *
     * @param id 被选举人ID
     * @return 被选举人
     */
    public VoteUserBy selectVoteUserByById(Long id);

    /**
     * 查询被选举人列表
     *
     * @param voteUserBy 被选举人
     * @return 被选举人集合
     */
    public List<VoteUserBy> selectVoteUserByList(VoteUserBy voteUserBy);

    /**
     * 新增被选举人
     *
     * @param voteUserBy 被选举人
     * @return 结果
     */
    public int insertVoteUserBy(VoteUserBy voteUserBy);

    /**
     * 修改被选举人
     *
     * @param voteUserBy 被选举人
     * @return 结果
     */
    public int updateVoteUserBy(VoteUserBy voteUserBy);

    /**
     * 批量删除被选举人
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVoteUserByByIds(String ids);

    /**
     * 删除被选举人信息
     *
     * @param id 被选举人ID
     * @return 结果
     */
    public int deleteVoteUserByById(Long id);
}
