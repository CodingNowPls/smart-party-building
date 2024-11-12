package com.ruoyi.web.controller.module.award.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.web.controller.module.award.domain.Award;
import com.ruoyi.web.controller.module.award.mapper.AwardMapper;
import com.ruoyi.web.controller.module.award.service.IAwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 奖项Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-08
 */
@Service
public class AwardServiceImpl implements IAwardService {
    @Autowired
    private AwardMapper awardMapper;

    /**
     * 查询奖项
     *
     * @param awardId 奖项ID
     * @return 奖项
     */
    @Override
    public Award selectAwardById(Long awardId) {
        return awardMapper.selectAwardById(awardId);
    }

    /**
     * 查询奖项列表
     *
     * @param award 奖项
     * @return 奖项
     */
    @Override
    public List<Award> selectAwardList(Award award) {
        return awardMapper.selectAwardList(award);
    }

    /**
     * 新增奖项
     *
     * @param award 奖项
     * @return 结果
     */
    @Override
    public int insertAward(Award award) {
        award.setCreateBy(ShiroUtils.getLoginName());
        award.setCreateTime(DateUtils.getNowDate());
        return awardMapper.insertAward(award);
    }

    /**
     * 修改奖项
     *
     * @param award 奖项
     * @return 结果
     */
    @Override
    public int updateAward(Award award) {
        award.setUpdateBy(ShiroUtils.getLoginName());
        award.setUpdateTime(DateUtils.getNowDate());
        return awardMapper.updateAward(award);
    }

    /**
     * 删除奖项对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteAwardByIds(String ids) {
        return awardMapper.deleteAwardByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除奖项信息
     *
     * @param awardId 奖项ID
     * @return 结果
     */
    @Override
    public int deleteAwardById(Long awardId) {
        return awardMapper.deleteAwardById(awardId);
    }
}
