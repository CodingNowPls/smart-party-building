package com.ruoyi.party.building.vote.service;

import com.ruoyi.party.building.vote.doamin.VoteUser;

import java.util.List;

/**
 * 选举人Service接口
 *
 * @author ruoyi
 * @date 2020-07-01
 */
public interface IVoteUserService {
    /**
     * 查询选举人
     *
     * @param id 选举人ID
     * @return 选举人
     */
    public VoteUser selectVoteUserById(Long id);

    /**
     * 查询选举人列表
     *
     * @param voteUser 选举人
     * @return 选举人集合
     */
    public List<VoteUser> selectVoteUserList(VoteUser voteUser);

    /**
     * 新增选举人
     *
     * @param voteUser 选举人
     * @return 结果
     */
    public int insertVoteUser(VoteUser voteUser);

    /**
     * 修改选举人
     *
     * @param voteUser 选举人
     * @return 结果
     */
    public int updateVoteUser(VoteUser voteUser);

    /**
     * 批量删除选举人
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVoteUserByIds(String ids);

    /**
     * 删除选举人信息
     *
     * @param id 选举人ID
     * @return 结果
     */
    public int deleteVoteUserById(Long id);
}
