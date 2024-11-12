package com.ruoyi.party.building.vote.mapper;

import com.ruoyi.party.building.vote.doamin.VoteUser;

import java.util.List;

/**
 * 选举人Mapper接口
 *
 * @author ruoyi
 * @date 2020-07-01
 */
public interface VoteUserMapper {
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
     * 删除选举人
     *
     * @param id 选举人ID
     * @return 结果
     */
    public int deleteVoteUserById(Long id);

    public int deleteVoteUserByVoteId(Long voteId);

    /**
     * 批量删除选举人
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVoteUserByIds(String[] ids);

    /**
     * 批量添加对象
     */
    public int addUserBatch(List<VoteUser> list);
}
