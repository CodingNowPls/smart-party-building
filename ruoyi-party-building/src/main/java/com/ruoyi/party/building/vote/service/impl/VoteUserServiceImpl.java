package com.ruoyi.party.building.vote.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.party.building.vote.doamin.VoteUser;
import com.ruoyi.party.building.vote.mapper.VoteUserMapper;
import com.ruoyi.party.building.vote.service.IVoteUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 选举人Service业务层处理
 *
 * @author ruoyi
 * @date 2020-07-01
 */
@Service
public class VoteUserServiceImpl implements IVoteUserService {
    @Autowired
    private VoteUserMapper voteUserMapper;

    /**
     * 查询选举人
     *
     * @param id 选举人ID
     * @return 选举人
     */
    @Override
    public VoteUser selectVoteUserById(Long id) {
        return voteUserMapper.selectVoteUserById(id);
    }

    /**
     * 查询选举人列表
     *
     * @param voteUser 选举人
     * @return 选举人
     */
    @Override
    public List<VoteUser> selectVoteUserList(VoteUser voteUser) {
        return voteUserMapper.selectVoteUserList(voteUser);
    }

    /**
     * 新增选举人
     *
     * @param voteUser 选举人
     * @return 结果
     */
    @Override
    public int insertVoteUser(VoteUser voteUser) {
        voteUser.setCreateTime(DateUtils.getNowDate());
        return voteUserMapper.insertVoteUser(voteUser);
    }

    /**
     * 修改选举人
     *
     * @param voteUser 选举人
     * @return 结果
     */
    @Override
    public int updateVoteUser(VoteUser voteUser) {
        voteUser.setUpdateTime(DateUtils.getNowDate());
        return voteUserMapper.updateVoteUser(voteUser);
    }

    /**
     * 删除选举人对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVoteUserByIds(String ids) {
        return voteUserMapper.deleteVoteUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除选举人信息
     *
     * @param id 选举人ID
     * @return 结果
     */
    @Override
    public int deleteVoteUserById(Long id) {
        return voteUserMapper.deleteVoteUserById(id);
    }
}
