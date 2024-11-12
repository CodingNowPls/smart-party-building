package com.ruoyi.party.building.plan.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.party.building.plan.domain.Plan;
import com.ruoyi.party.building.plan.service.IPlanService;
import com.ruoyi.system.service.ISysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 学习计划Controller
 *
 * @author ruoyi
 * @date 2020-05-09
 */
@Controller
@RequestMapping("/module/plan")
public class PlanController extends BaseController {
    private String prefix = "module/plan";

    @Autowired
    private IPlanService planService;
    @Autowired
    private ISysDeptService deptService;

    @RequiresPermissions("module:plan:view")
    @GetMapping()
    public String plan(ModelMap mmap) {
        //所有部门
        List<SysDept> deptList = deptService.selectDeptList(new SysDept());
        mmap.put("deptList", deptList);
        return prefix + "/plan";
    }

    /**
     * 查询学习计划列表
     */
    @RequiresPermissions("module:plan:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Plan plan) {
        startPage();
        List<Plan> list = planService.selectPlanList(plan);
        return getDataTable(list);
    }

    /**
     * 导出学习计划列表
     */
    @RequiresPermissions("module:plan:export")
    @Log(title = "学习计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Plan plan) {
        List<Plan> list = planService.selectPlanList(plan);
        ExcelUtil<Plan> util = new ExcelUtil<Plan>(Plan.class);
        return util.exportExcel(list, "plan");
    }

    /**
     * 新增学习计划
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(new Date());
        mmap.put("time", time);
        return prefix + "/add";
    }

    /**
     * 新增保存学习计划
     */
    @RequiresPermissions("module:plan:add")
    @Log(title = "学习计划", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Plan plan) {
        plan.setUserId(ShiroUtils.getSysUser().getUserId());
        plan.setUserName(ShiroUtils.getSysUser().getUserName());
        plan.setPlanTime(DateUtils.getNowDate());
        return toAjax(planService.insertPlan(plan));
    }

    /**
     * 修改学习计划
     */
    @GetMapping("/edit/{planId}")
    public String edit(@PathVariable("planId") Long planId, ModelMap mmap) {
        Plan plan = planService.selectPlanById(planId);
        mmap.put("plan", plan);

        if (plan.getPlanVideo() != null) {
            String[] videos = plan.getPlanVideo().split(",");
            mmap.put("videos", videos);
        }
        return prefix + "/edit";
    }

    /**
     * 修改保存学习计划
     */
    @RequiresPermissions("module:plan:edit")
    @Log(title = "学习计划", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Plan plan) {
        return toAjax(planService.updatePlan(plan));
    }

    /**
     * 删除学习计划
     */
    @RequiresPermissions("module:plan:remove")
    @Log(title = "学习计划", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(planService.deletePlanByIds(ids));
    }

    /**
     * 详情
     *
     * @param mmap
     * @return
     */
    @GetMapping("/detail/{planId}")
    public String detail(@PathVariable("planId") Long planId, ModelMap mmap) {
        Plan plan = planService.selectPlanById(planId);
        mmap.put("plan", plan);

        if (plan.getPlanVideo() != null) {
            String[] videos = plan.getPlanVideo().split(",");
            mmap.put("videos", videos);
        }

        return prefix + "/detail";
    }
}
