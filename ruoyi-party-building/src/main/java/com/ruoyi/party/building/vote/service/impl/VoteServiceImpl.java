package com.ruoyi.party.building.vote.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.party.building.vote.doamin.Vote;
import com.ruoyi.party.building.vote.doamin.VoteUser;
import com.ruoyi.party.building.vote.doamin.VoteUserBy;
import com.ruoyi.party.building.vote.mapper.VoteMapper;
import com.ruoyi.party.building.vote.mapper.VoteUserByMapper;
import com.ruoyi.party.building.vote.mapper.VoteUserMapper;
import com.ruoyi.party.building.vote.service.IVoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 选举任务Service业务层处理
 *
 * @author ruoyi
 * @date 2020-06-30
 */
@Service
public class VoteServiceImpl implements IVoteService {
    @Autowired
    private VoteMapper voteMapper;
    @Autowired
    private VoteUserByMapper voteUserByMapper;
    @Autowired
    private VoteUserMapper voteUserMapper;

    /**
     * 查询选举任务
     *
     * @param id 选举任务ID
     * @return 选举任务
     */
    @Override
    public Vote selectVoteById(Long id) {
        return voteMapper.selectVoteById(id);
    }

    /**
     * 查询选举任务列表
     *
     * @param vote 选举任务
     * @return 选举任务
     */
    @Override
    public List<Vote> selectVoteList(Vote vote) {
        return voteMapper.selectVoteList(vote);
    }

    /**
     * 新增选举任务
     *
     * @param vote 选举任务
     * @return 结果
     */
    @Override
    @Transactional
    public int insertVote(Vote vote) {
        vote.setCreateTime(DateUtils.getNowDate());
        int result = voteMapper.insertVote(vote);

        //添加被选举人
        if (StringUtils.isNotEmpty(vote.getUserByIds())) {
            List<VoteUserBy> userByList = new ArrayList<>();
            String[] userByIds = vote.getUserByIds().split(",");
            if (userByIds != null && userByIds.length > 0) {
                for (String userById : userByIds) {
                    VoteUserBy by = new VoteUserBy();
                    by.setUserId(Long.valueOf(userById));
                    by.setVoteId(vote.getId());
                    long count = 0;
                    by.setVoteCount(count);
                    by.setStatus("0");
                    by.setType(vote.getType());
                    by.setCreateBy(ShiroUtils.getLoginName());
                    by.setCreateTime(DateUtils.getNowDate());
                    userByList.add(by);
                }
            }
            if (userByList.size() > 0) {
                voteUserByMapper.addUserBatch(userByList);
            }
        }

        //添加选举人
        if (StringUtils.isNotEmpty(vote.getUserIds())) {
            List<VoteUser> userList = new ArrayList<>();
            String[] userIds = vote.getUserIds().split(",");
            if (userIds != null && userIds.length > 0) {
                for (String userId : userIds) {
                    VoteUser user = new VoteUser();
                    user.setUserId(Long.valueOf(userId));
                    user.setVoteId(vote.getId());
                    user.setStatus("0");
                    user.setType(vote.getType());
                    user.setCreateBy(ShiroUtils.getLoginName());
                    user.setCreateTime(DateUtils.getNowDate());
                    userList.add(user);
                }
            }
            if (userList.size() > 0) {
                voteUserMapper.addUserBatch(userList);
            }
        }

        return result;
    }

    /**
     * 修改选举任务
     *
     * @param vote 选举任务
     * @return 结果
     */
    @Override
    public int updateVote(Vote vote) {
        vote.setUpdateTime(DateUtils.getNowDate());
        return voteMapper.updateVote(vote);
    }

    /**
     * 删除选举任务对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deleteVoteByIds(String ids) {
        Long[] voteIds = Convert.toLongArray(ids);
        for (Long voteId : voteIds) {
            //删除选举人关联表
            voteUserMapper.deleteVoteUserByVoteId(voteId);
            //删除被选举人关联表
            voteUserByMapper.deleteVoteUserByByVoteId(voteId);
        }
        return voteMapper.deleteVoteByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除选举任务信息
     *
     * @param id 选举任务ID
     * @return 结果
     */
    @Override
    public int deleteVoteById(Long id) {
        return voteMapper.deleteVoteById(id);
    }
}
