package com.ruoyi.party.building.learn.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.controller.module.learn.domain.Learn;
import com.ruoyi.web.controller.module.learn.mapper.LearnMapper;
import com.ruoyi.web.controller.module.learn.service.ILearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 学习Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-21
 */
@Service
public class LearnServiceImpl implements ILearnService {
    @Autowired
    private LearnMapper learnMapper;

    /**
     * 查询学习
     *
     * @param id 学习ID
     * @return 学习
     */
    @Override
    public Learn selectLearnById(Long id) {
        return learnMapper.selectLearnById(id);
    }

    /**
     * 查询学习列表
     *
     * @param learn 学习
     * @return 学习
     */
    @Override
    public List<Learn> selectLearnList(Learn learn) {
        return learnMapper.selectLearnList(learn);
    }

    /**
     * 新增学习
     *
     * @param learn 学习
     * @return 结果
     */
    @Override
    public int insertLearn(Learn learn) {
        learn.setCreateTime(DateUtils.getNowDate());
        return learnMapper.insertLearn(learn);
    }

    /**
     * 修改学习
     *
     * @param learn 学习
     * @return 结果
     */
    @Override
    public int updateLearn(Learn learn) {
        learn.setUpdateTime(DateUtils.getNowDate());
        return learnMapper.updateLearn(learn);
    }

    /**
     * 删除学习对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLearnByIds(String ids) {
        return learnMapper.deleteLearnByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学习信息
     *
     * @param id 学习ID
     * @return 结果
     */
    @Override
    public int deleteLearnById(Long id) {
        return learnMapper.deleteLearnById(id);
    }

    /**
     * 成员排行
     */
    public List<Learn> selectUserRankList(Learn learn) {
        return learnMapper.selectUserRankList(learn);
    }

    /**
     * 组排行
     */
    public List<Learn> selectDeptRankList(Learn learn) {
        return learnMapper.selectDeptRankList(learn);
    }
}
