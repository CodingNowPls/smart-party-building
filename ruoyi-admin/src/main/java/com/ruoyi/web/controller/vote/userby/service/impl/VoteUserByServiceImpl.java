package com.ruoyi.web.controller.vote.userby.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.controller.vote.userby.domain.VoteUserBy;
import com.ruoyi.web.controller.vote.userby.mapper.VoteUserByMapper;
import com.ruoyi.web.controller.vote.userby.service.IVoteUserByService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 被选举人Service业务层处理
 *
 * @author ruoyi
 * @date 2020-07-01
 */
@Service
public class VoteUserByServiceImpl implements IVoteUserByService {
    @Autowired
    private VoteUserByMapper voteUserByMapper;

    /**
     * 查询被选举人
     *
     * @param id 被选举人ID
     * @return 被选举人
     */
    @Override
    public VoteUserBy selectVoteUserByById(Long id) {
        return voteUserByMapper.selectVoteUserByById(id);
    }

    /**
     * 查询被选举人列表
     *
     * @param voteUserBy 被选举人
     * @return 被选举人
     */
    @Override
    public List<VoteUserBy> selectVoteUserByList(VoteUserBy voteUserBy) {
        return voteUserByMapper.selectVoteUserByList(voteUserBy);
    }

    /**
     * 新增被选举人
     *
     * @param voteUserBy 被选举人
     * @return 结果
     */
    @Override
    public int insertVoteUserBy(VoteUserBy voteUserBy) {
        voteUserBy.setCreateTime(DateUtils.getNowDate());
        return voteUserByMapper.insertVoteUserBy(voteUserBy);
    }

    /**
     * 修改被选举人
     *
     * @param voteUserBy 被选举人
     * @return 结果
     */
    @Override
    public int updateVoteUserBy(VoteUserBy voteUserBy) {
        voteUserBy.setUpdateTime(DateUtils.getNowDate());
        return voteUserByMapper.updateVoteUserBy(voteUserBy);
    }

    /**
     * 删除被选举人对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVoteUserByByIds(String ids) {
        return voteUserByMapper.deleteVoteUserByByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除被选举人信息
     *
     * @param id 被选举人ID
     * @return 结果
     */
    @Override
    public int deleteVoteUserByById(Long id) {
        return voteUserByMapper.deleteVoteUserByById(id);
    }
}
