package com.ruoyi.web.controller.module.flow.service;

import com.ruoyi.web.controller.module.flow.domain.WorkFlow;

import java.util.List;

/**
 * 任务流程Service接口
 *
 * @author ruoyi
 * @date 2020-05-18
 */
public interface IWorkFlowService {
    /**
     * 查询任务流程
     *
     * @param flowId 任务流程ID
     * @return 任务流程
     */
    public WorkFlow selectWorkFlowById(Long flowId);

    /**
     * 查询任务流程列表
     *
     * @param workFlow 任务流程
     * @return 任务流程集合
     */
    public List<WorkFlow> selectWorkFlowList(WorkFlow workFlow);

    /**
     * 新增任务流程
     *
     * @param workFlow 任务流程
     * @return 结果
     */
    public int insertWorkFlow(WorkFlow workFlow);

    /**
     * 修改任务流程
     *
     * @param workFlow 任务流程
     * @return 结果
     */
    public int updateWorkFlow(WorkFlow workFlow);

    /**
     * 批量删除任务流程
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWorkFlowByIds(String ids);

    /**
     * 删除任务流程信息
     *
     * @param flowId 任务流程ID
     * @return 结果
     */
    public int deleteWorkFlowById(Long flowId);
}
