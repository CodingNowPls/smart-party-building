package com.ruoyi.party.building.plan.service;

import com.ruoyi.web.controller.module.plan.domain.Plan;

import java.util.List;

/**
 * 学习计划Service接口
 *
 * @author ruoyi
 * @date 2020-05-09
 */
public interface IPlanService {
    /**
     * 查询学习计划
     *
     * @param planId 学习计划ID
     * @return 学习计划
     */
    public Plan selectPlanById(Long planId);

    /**
     * 查询学习计划列表
     *
     * @param plan 学习计划
     * @return 学习计划集合
     */
    public List<Plan> selectPlanList(Plan plan);

    /**
     * 新增学习计划
     *
     * @param plan 学习计划
     * @return 结果
     */
    public int insertPlan(Plan plan);

    /**
     * 修改学习计划
     *
     * @param plan 学习计划
     * @return 结果
     */
    public int updatePlan(Plan plan);

    /**
     * 批量删除学习计划
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePlanByIds(String ids);

    /**
     * 删除学习计划信息
     *
     * @param planId 学习计划ID
     * @return 结果
     */
    public int deletePlanById(Long planId);
}
