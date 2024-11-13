package com.ruoyi.party.building.portal.plan.controller;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.party.building.plan.domain.Plan;
import com.ruoyi.party.building.plan.service.IPlanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 学习计划接口
 *
 * @author : gao
 * @date 2024年11月13日
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
@Api("portal-学习计划接口")
@RequiresGuest
@RestController
@RequestMapping("/api")
public class PortalPlanController {


    @Autowired
    private IPlanService planService;

    @ApiOperation("学习计划添加")
    @PostMapping("/addPlan")
    public AjaxResult addPlan(@RequestBody Plan plan) {
        int result = planService.insertPlan(plan);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("提交成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("提交失败！");
            return ajaxResult;
        }
    }


    @ApiOperation("学习计划编辑")
    @PostMapping("/editPlan")
    public AjaxResult editPlan(@RequestBody Plan plan) {
        int result = planService.updatePlan(plan);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("编辑成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("编辑失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("学习计划删除")
    @PostMapping("/removePlan")
    public AjaxResult removePlan(String ids) {
        int result = planService.deletePlanByIds(ids);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("删除成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("删除失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("学习计划列表 自己提交的")
    @GetMapping("/getPlanList")
    public AjaxResult getPlanList(String deptId) {
        Plan plan = new Plan();
        plan.setDeptId(Long.valueOf(deptId));
        // plan.setUserId(Long.valueOf(userId));
        List<Plan> list = planService.selectPlanList(plan);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("学习计划详情")
    @GetMapping("/getPlanInfo")
    public AjaxResult getPlanInfo(String planId) {
        Plan plan = planService.selectPlanById(Long.valueOf(planId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("plan", plan);
        return ajaxResult;
    }

}
