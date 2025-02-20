package com.ruoyi.party.building.learn.service;

import com.ruoyi.party.building.learn.domain.Learn;

import java.util.List;

/**
 * 学习Service接口
 *
 * @author ruoyi
 * @date 2020-05-21
 */
public interface ILearnService {
    /**
     * 查询学习
     *
     * @param id 学习ID
     * @return 学习
     */
    public Learn selectLearnById(Long id);

    /**
     * 查询学习列表
     *
     * @param learn 学习
     * @return 学习集合
     */
    public List<Learn> selectLearnList(Learn learn);

    /**
     * 新增学习
     *
     * @param learn 学习
     * @return 结果
     */
    public int insertLearn(Learn learn);

    /**
     * 修改学习
     *
     * @param learn 学习
     * @return 结果
     */
    public int updateLearn(Learn learn);

    /**
     * 批量删除学习
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLearnByIds(String ids);

    /**
     * 删除学习信息
     *
     * @param id 学习ID
     * @return 结果
     */
    public int deleteLearnById(Long id);

    /**
     * 成员排行
     */
    public List<Learn> selectUserRankList(Learn learn);

    /**
     * 组排行
     */
    public List<Learn> selectDeptRankList(Learn learn);
}
