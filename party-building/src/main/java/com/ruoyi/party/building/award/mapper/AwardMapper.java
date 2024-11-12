package com.ruoyi.party.building.award.mapper;

import com.ruoyi.web.controller.module.award.domain.Award;

import java.util.List;

/**
 * 奖项Mapper接口
 *
 * @author ruoyi
 * @date 2020-05-08
 */
public interface AwardMapper {
    /**
     * 查询奖项
     *
     * @param awardId 奖项ID
     * @return 奖项
     */
    public Award selectAwardById(Long awardId);

    /**
     * 查询奖项列表
     *
     * @param award 奖项
     * @return 奖项集合
     */
    public List<Award> selectAwardList(Award award);

    /**
     * 新增奖项
     *
     * @param award 奖项
     * @return 结果
     */
    public int insertAward(Award award);

    /**
     * 修改奖项
     *
     * @param award 奖项
     * @return 结果
     */
    public int updateAward(Award award);

    /**
     * 删除奖项
     *
     * @param awardId 奖项ID
     * @return 结果
     */
    public int deleteAwardById(Long awardId);

    /**
     * 批量删除奖项
     *
     * @param awardIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteAwardByIds(String[] awardIds);
}
