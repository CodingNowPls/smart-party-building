package com.ruoyi.party.building.vote.mapper;

import com.ruoyi.party.building.vote.domain.VoteRecord;

import java.util.List;

/**
 * 投票记录Mapper接口
 *
 * @author ruoyi
 * @date 2020-07-01
 */
public interface VoteRecordMapper {
    /**
     * 查询投票记录
     *
     * @param id 投票记录ID
     * @return 投票记录
     */
    public VoteRecord selectVoteRecordById(Long id);

    /**
     * 查询投票记录列表
     *
     * @param voteRecord 投票记录
     * @return 投票记录集合
     */
    public List<VoteRecord> selectVoteRecordList(VoteRecord voteRecord);

    /**
     * 新增投票记录
     *
     * @param voteRecord 投票记录
     * @return 结果
     */
    public int insertVoteRecord(VoteRecord voteRecord);

    /**
     * 修改投票记录
     *
     * @param voteRecord 投票记录
     * @return 结果
     */
    public int updateVoteRecord(VoteRecord voteRecord);

    /**
     * 删除投票记录
     *
     * @param id 投票记录ID
     * @return 结果
     */
    public int deleteVoteRecordById(Long id);

    /**
     * 批量删除投票记录
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteVoteRecordByIds(String[] ids);

    /**
     * 获取选举人总票数
     */
    public int getTotalCount(VoteRecord voteRecord);
}
