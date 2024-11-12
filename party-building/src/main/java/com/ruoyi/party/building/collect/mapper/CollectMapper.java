package com.ruoyi.party.building.collect.mapper;

import com.ruoyi.web.controller.module.collect.domain.Collect;

import java.util.List;

/**
 * 学习收藏Mapper接口
 *
 * @author ruoyi
 * @date 2020-07-10
 */
public interface CollectMapper {
    /**
     * 查询学习收藏
     *
     * @param id 学习收藏ID
     * @return 学习收藏
     */
    public Collect selectCollectById(Long id);

    /**
     * 查询学习收藏列表
     *
     * @param collect 学习收藏
     * @return 学习收藏集合
     */
    public List<Collect> selectCollectList(Collect collect);

    /**
     * 新增学习收藏
     *
     * @param collect 学习收藏
     * @return 结果
     */
    public int insertCollect(Collect collect);

    /**
     * 修改学习收藏
     *
     * @param collect 学习收藏
     * @return 结果
     */
    public int updateCollect(Collect collect);

    /**
     * 删除学习收藏
     *
     * @param id 学习收藏ID
     * @return 结果
     */
    public int deleteCollectById(Long id);

    /**
     * 批量删除学习收藏
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCollectByIds(String[] ids);
}
