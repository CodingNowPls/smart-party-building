package com.ruoyi.web.controller.vote.voterecord.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.controller.vote.userby.mapper.VoteUserByMapper;
import com.ruoyi.web.controller.vote.voterecord.domain.VoteRecord;
import com.ruoyi.web.controller.vote.voterecord.mapper.VoteRecordMapper;
import com.ruoyi.web.controller.vote.voterecord.service.IVoteRecordService;
import com.ruoyi.web.controller.vote.voteuser.domain.VoteUser;
import com.ruoyi.web.controller.vote.voteuser.mapper.VoteUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 投票记录Service业务层处理
 *
 * @author ruoyi
 * @date 2020-07-01
 */
@Service
public class VoteRecordServiceImpl implements IVoteRecordService {
    @Autowired
    private VoteRecordMapper voteRecordMapper;
    @Autowired
    private VoteUserMapper voteUserMapper;
    @Autowired
    private VoteUserByMapper voteUserByMapper;

    /**
     * 查询投票记录
     *
     * @param id 投票记录ID
     * @return 投票记录
     */
    @Override
    public VoteRecord selectVoteRecordById(Long id) {
        return voteRecordMapper.selectVoteRecordById(id);
    }

    /**
     * 查询投票记录列表
     *
     * @param voteRecord 投票记录
     * @return 投票记录
     */
    @Override
    public List<VoteRecord> selectVoteRecordList(VoteRecord voteRecord) {
        return voteRecordMapper.selectVoteRecordList(voteRecord);
    }

    /**
     * 新增投票记录
     *
     * @param voteRecord 投票记录
     * @return 结果
     */
    @Override
    @Transactional
    public int insertVoteRecord(VoteRecord voteRecord) {
        long count = 1;
        voteRecord.setVoteCount(count); //默认1票
        voteRecord.setCreateTime(DateUtils.getNowDate());
        int result = voteRecordMapper.insertVoteRecord(voteRecord);
        if (result > 0) {
            //修改选举人状态为已投票
            VoteUser voteUser = new VoteUser();
            if (voteRecord.getVoteUserId() != null) {
                voteUser.setId(voteRecord.getVoteUserId());
                voteUser.setStatus("1");
                voteUserMapper.updateVoteUser(voteUser);
            }

            //统计被选举人票数
//            VoteUserBy userBy = new VoteUserBy();
//            if(voteRecord.getVoteUserById()!=null){
//                userBy.setId(voteRecord.getVoteUserById());
//                VoteRecord record = new VoteRecord();
//                record.setVoteId(voteRecord.getVoteId());
//                record.setVoteUserById(voteRecord.getVoteUserById());
//                int totalCount = voteRecordMapper.getTotalCount(record);
//                userBy.setVoteCount((long)totalCount); //票数
//                voteUserByMapper.updateVoteUserBy(userBy);
//            }

        }
        return result;
    }

    /**
     * 修改投票记录
     *
     * @param voteRecord 投票记录
     * @return 结果
     */
    @Override
    public int updateVoteRecord(VoteRecord voteRecord) {
        voteRecord.setUpdateTime(DateUtils.getNowDate());
        return voteRecordMapper.updateVoteRecord(voteRecord);
    }

    /**
     * 删除投票记录对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteVoteRecordByIds(String ids) {
        return voteRecordMapper.deleteVoteRecordByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除投票记录信息
     *
     * @param id 投票记录ID
     * @return 结果
     */
    @Override
    public int deleteVoteRecordById(Long id) {
        return voteRecordMapper.deleteVoteRecordById(id);
    }

    @Override
    public int getTotalCount(VoteRecord voteRecord) {
        return voteRecordMapper.getTotalCount(voteRecord);
    }
}
