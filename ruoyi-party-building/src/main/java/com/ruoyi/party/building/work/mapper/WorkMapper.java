package com.ruoyi.party.building.work.mapper;


import com.ruoyi.party.building.work.domain.Work;

import java.util.List;

/**
 * 任务Mapper接口
 *
 * @author ruoyi
 * @date 2020-05-15
 */
public interface WorkMapper {
    /**
     * 查询任务
     *
     * @param workId 任务ID
     * @return 任务
     */
    public Work selectWorkById(Long workId);

    /**
     * 查询任务列表
     *
     * @param work 任务
     * @return 任务集合
     */
    public List<Work> selectWorkList(Work work);

    /**
     * 新增任务
     *
     * @param work 任务
     * @return 结果
     */
    public int insertWork(Work work);

    /**
     * 修改任务
     *
     * @param work 任务
     * @return 结果
     */
    public int updateWork(Work work);

    /**
     * 删除任务
     *
     * @param workId 任务ID
     * @return 结果
     */
    public int deleteWorkById(Long workId);

    /**
     * 批量删除任务
     *
     * @param workIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteWorkByIds(String[] workIds);
}
