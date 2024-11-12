package com.ruoyi.web.controller.module.workdist.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.web.controller.module.workdist.domain.WorkDist;
import com.ruoyi.web.controller.module.workdist.mapper.WorkDistMapper;
import com.ruoyi.web.controller.module.workdist.service.IWorkDistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 任务分配Service业务层处理
 *
 * @author ruoyi
 * @date 2020-06-01
 */
@Service
public class WorkDistServiceImpl implements IWorkDistService {
    @Autowired
    private WorkDistMapper workDistMapper;

    /**
     * 查询任务分配
     *
     * @param id 任务分配ID
     * @return 任务分配
     */
    @Override
    public WorkDist selectWorkDistById(Long id) {
        return workDistMapper.selectWorkDistById(id);
    }

    /**
     * 查询任务分配列表
     *
     * @param workDist 任务分配
     * @return 任务分配
     */
    @Override
    public List<WorkDist> selectWorkDistList(WorkDist workDist) {
        return workDistMapper.selectWorkDistList(workDist);
    }

    /**
     * 新增任务分配
     *
     * @param workDist 任务分配
     * @return 结果
     */
    @Override
    public int insertWorkDist(WorkDist workDist) {
        return workDistMapper.insertWorkDist(workDist);
    }

    /**
     * 修改任务分配
     *
     * @param workDist 任务分配
     * @return 结果
     */
    @Override
    public int updateWorkDist(WorkDist workDist) {
        return workDistMapper.updateWorkDist(workDist);
    }

    /**
     * 删除任务分配对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWorkDistByIds(String ids) {
        return workDistMapper.deleteWorkDistByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除任务分配信息
     *
     * @param id 任务分配ID
     * @return 结果
     */
    @Override
    public int deleteWorkDistById(Long id) {
        return workDistMapper.deleteWorkDistById(id);
    }

    /**
     * 批量插入
     */
    public int addDistBatch(List<WorkDist> list) {
        return workDistMapper.addDistBatch(list);
    }

    public WorkDist selectWorkDistByWorkId(Long workId) {
        return workDistMapper.selectWorkDistByWorkId(workId);
    }

    public List<WorkDist> selectWorkDistListAndStatus(WorkDist workDist) {
        return workDistMapper.selectWorkDistListAndStatus(workDist);
    }
}
