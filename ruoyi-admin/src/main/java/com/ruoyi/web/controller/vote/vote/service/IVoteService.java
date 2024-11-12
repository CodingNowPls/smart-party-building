package com.ruoyi.web.controller.vote.vote.service;

import com.ruoyi.web.controller.vote.vote.domain.Vote;

import java.util.List;

/**
 * 选举任务Service接口
 *
 * @author ruoyi
 * @date 2020-06-30
 */
public interface IVoteService {
    /**
     * 查询选举任务
     *
     * @param id 选举任务ID
     * @return 选举任务
     */
    public Vote selectVoteById(Long id);

    /**
     * 查询选举任务列表
     *
     * @param vote 选举任务
     * @return 选举任务集合
     */
    public List<Vote> selectVoteList(Vote vote);

    /**
     * 新增选举任务
     *
     * @param vote 选举任务
     * @return 结果
     */
    public int insertVote(Vote vote);

    /**
     * 修改选举任务
     *
     * @param vote 选举任务
     * @return 结果
     */
    public int updateVote(Vote vote);

    /**
     * 批量删除选举任务
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVoteByIds(String ids);

    /**
     * 删除选举任务信息
     *
     * @param id 选举任务ID
     * @return 结果
     */
    public int deleteVoteById(Long id);
}
