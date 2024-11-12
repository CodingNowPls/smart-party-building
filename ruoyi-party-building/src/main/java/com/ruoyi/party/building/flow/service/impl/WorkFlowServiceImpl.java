package com.ruoyi.party.building.flow.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.party.building.flow.domain.WorkFlow;
import com.ruoyi.party.building.flow.mapper.WorkFlowMapper;
import com.ruoyi.party.building.flow.service.IWorkFlowService;
import com.ruoyi.party.building.work.mapper.WorkMapper;
import com.ruoyi.party.building.workdist.domain.WorkDist;
import com.ruoyi.party.building.workdist.mapper.WorkDistMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 任务流程Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-18
 */
@Service
public class WorkFlowServiceImpl implements IWorkFlowService {
    @Autowired
    private WorkFlowMapper workFlowMapper;
    @Autowired
    private WorkMapper workMapper;
    @Autowired
    private WorkDistMapper distMapper;

    /**
     * 查询任务流程
     *
     * @param flowId 任务流程ID
     * @return 任务流程
     */
    @Override
    public WorkFlow selectWorkFlowById(Long flowId) {
        return workFlowMapper.selectWorkFlowById(flowId);
    }

    /**
     * 查询任务流程列表
     *
     * @param workFlow 任务流程
     * @return 任务流程
     */
    @Override
    public List<WorkFlow> selectWorkFlowList(WorkFlow workFlow) {
        return workFlowMapper.selectWorkFlowList(workFlow);
    }

    /**
     * 新增任务流程
     *
     * @param workFlow 任务流程
     * @return 结果
     */
    @Override
    @Transactional
    public int insertWorkFlow(WorkFlow workFlow) {
        workFlow.setCreateTime(DateUtils.getNowDate());
        int result = workFlowMapper.insertWorkFlow(workFlow);
        //修改任务状态
        if (result > 0) {
            WorkDist workDist = new WorkDist();
            workDist.setId(Long.valueOf(workFlow.getDistId()));
            if (null != workFlow.getDealStatus()) {
                if ("1".equals(workFlow.getDealStatus())) { //执行中
                    workDist.setStatus("2");
                } else if ("2".equals(workFlow.getDealStatus())) { //已完成
                    workDist.setStatus("3");
                } else if ("3".equals(workFlow.getDealStatus())) {
                    workDist.setStatus("4");//不同意
                } else if ("4".equals(workFlow.getDealStatus())) { //同意
                    workDist.setStatus("5");//同意
                }

            }
            distMapper.updateWorkDist(workDist);
        }
        return result;
    }

    /**
     * 修改任务流程
     *
     * @param workFlow 任务流程
     * @return 结果
     */
    @Override
    public int updateWorkFlow(WorkFlow workFlow) {
        workFlow.setUpdateTime(DateUtils.getNowDate());
        return workFlowMapper.updateWorkFlow(workFlow);
    }

    /**
     * 删除任务流程对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWorkFlowByIds(String ids) {
        return workFlowMapper.deleteWorkFlowByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除任务流程信息
     *
     * @param flowId 任务流程ID
     * @return 结果
     */
    @Override
    public int deleteWorkFlowById(Long flowId) {
        return workFlowMapper.deleteWorkFlowById(flowId);
    }
}
