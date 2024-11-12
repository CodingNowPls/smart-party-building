package com.ruoyi.party.building.plan.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.controller.module.plan.domain.Plan;
import com.ruoyi.web.controller.module.plan.mapper.PlanMapper;
import com.ruoyi.web.controller.module.plan.service.IPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 学习计划Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-09
 */
@Service
public class PlanServiceImpl implements IPlanService {
    @Autowired
    private PlanMapper planMapper;

    /**
     * 查询学习计划
     *
     * @param planId 学习计划ID
     * @return 学习计划
     */
    @Override
    public Plan selectPlanById(Long planId) {
        return planMapper.selectPlanById(planId);
    }

    /**
     * 查询学习计划列表
     *
     * @param plan 学习计划
     * @return 学习计划
     */
    @Override
    @DataScope(deptAlias = "p")
    public List<Plan> selectPlanList(Plan plan) {
        return planMapper.selectPlanList(plan);
    }

    /**
     * 新增学习计划
     *
     * @param plan 学习计划
     * @return 结果
     */
    @Override
    public int insertPlan(Plan plan) {
        plan.setCreateTime(DateUtils.getNowDate());
        return planMapper.insertPlan(plan);
    }

    /**
     * 修改学习计划
     *
     * @param plan 学习计划
     * @return 结果
     */
    @Override
    public int updatePlan(Plan plan) {
        plan.setUpdateTime(DateUtils.getNowDate());
        return planMapper.updatePlan(plan);
    }

    /**
     * 删除学习计划对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePlanByIds(String ids) {
        return planMapper.deletePlanByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学习计划信息
     *
     * @param planId 学习计划ID
     * @return 结果
     */
    @Override
    public int deletePlanById(Long planId) {
        return planMapper.deletePlanById(planId);
    }
}
