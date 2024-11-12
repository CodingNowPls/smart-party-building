package com.ruoyi.web.controller.module.workdist.mapper;

import com.ruoyi.web.controller.module.workdist.domain.WorkDist;

import java.util.List;

/**
 * 任务分配Mapper接口
 *
 * @author ruoyi
 * @date 2020-06-01
 */
public interface WorkDistMapper {
    /**
     * 查询任务分配
     *
     * @param id 任务分配ID
     * @return 任务分配
     */
    public WorkDist selectWorkDistById(Long id);

    /**
     * 查询任务分配列表
     *
     * @param workDist 任务分配
     * @return 任务分配集合
     */
    public List<WorkDist> selectWorkDistList(WorkDist workDist);

    /**
     * 新增任务分配
     *
     * @param workDist 任务分配
     * @return 结果
     */
    public int insertWorkDist(WorkDist workDist);

    /**
     * 修改任务分配
     *
     * @param workDist 任务分配
     * @return 结果
     */
    public int updateWorkDist(WorkDist workDist);

    /**
     * 删除任务分配
     *
     * @param id 任务分配ID
     * @return 结果
     */
    public int deleteWorkDistById(Long id);

    /**
     * 批量删除任务分配
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWorkDistByIds(String[] ids);

    /**
     * 批量插入
     */
    public int addDistBatch(List<WorkDist> list);

    public WorkDist selectWorkDistByWorkId(Long workId);

    public List<WorkDist> selectWorkDistListAndStatus(WorkDist workDist);
}
