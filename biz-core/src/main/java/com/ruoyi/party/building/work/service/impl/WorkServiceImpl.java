package com.ruoyi.party.building.work.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.party.building.work.domain.Work;
import com.ruoyi.party.building.work.mapper.WorkMapper;
import com.ruoyi.party.building.work.service.IWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 任务Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-15
 */
@Service
public class WorkServiceImpl implements IWorkService {
    @Autowired
    private WorkMapper workMapper;

    /**
     * 查询任务
     *
     * @param workId 任务ID
     * @return 任务
     */
    @Override
    public Work selectWorkById(Long workId) {
        return workMapper.selectWorkById(workId);
    }

    /**
     * 查询任务列表
     *
     * @param work 任务
     * @return 任务
     */
    @Override
    public List<Work> selectWorkList(Work work) {
        return workMapper.selectWorkList(work);
    }

    /**
     * 新增任务
     *
     * @param work 任务
     * @return 结果
     */
    @Override
    public int insertWork(Work work) {
        return workMapper.insertWork(work);
    }

    /**
     * 修改任务
     *
     * @param work 任务
     * @return 结果
     */
    @Override
    public int updateWork(Work work) {
        return workMapper.updateWork(work);
    }

    /**
     * 删除任务对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWorkByIds(String ids) {
        return workMapper.deleteWorkByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除任务信息
     *
     * @param workId 任务ID
     * @return 结果
     */
    @Override
    public int deleteWorkById(Long workId) {
        return workMapper.deleteWorkById(workId);
    }
}
