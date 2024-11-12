package com.ruoyi.party.building.flow.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.party.building.flow.domain.WorkFlow;
import com.ruoyi.party.building.flow.service.IWorkFlowService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 任务流程Controller
 *
 * @author ruoyi
 * @date 2020-05-18
 */
@Controller
@RequestMapping("/module/flow")
public class WorkFlowController extends BaseController {
    private String prefix = "module/flow";

    @Autowired
    private IWorkFlowService workFlowService;

    @RequiresPermissions("module:flow:view")
    @GetMapping()
    public String flow() {
        return prefix + "/flow";
    }

    /**
     * 查询任务流程列表
     */
    @RequiresPermissions("module:flow:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WorkFlow workFlow) {
        startPage();
        List<WorkFlow> list = workFlowService.selectWorkFlowList(workFlow);
        return getDataTable(list);
    }

    /**
     * 导出任务流程列表
     */
    @RequiresPermissions("module:flow:export")
    @Log(title = "任务流程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WorkFlow workFlow) {
        List<WorkFlow> list = workFlowService.selectWorkFlowList(workFlow);
        ExcelUtil<WorkFlow> util = new ExcelUtil<WorkFlow>(WorkFlow.class);
        return util.exportExcel(list, "flow");
    }

    /**
     * 新增任务流程
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存任务流程
     */
    @RequiresPermissions("module:flow:add")
    @Log(title = "任务流程", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WorkFlow workFlow) {
        workFlow.setDealTime(DateUtils.getNowDate());
        return toAjax(workFlowService.insertWorkFlow(workFlow));
    }

    /**
     * 修改任务流程
     */
    @GetMapping("/edit/{flowId}")
    public String edit(@PathVariable("flowId") Long flowId, ModelMap mmap) {
        WorkFlow workFlow = workFlowService.selectWorkFlowById(flowId);
        mmap.put("workFlow", workFlow);
        return prefix + "/edit";
    }

    /**
     * 修改保存任务流程
     */
    @RequiresPermissions("module:flow:edit")
    @Log(title = "任务流程", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WorkFlow workFlow) {
        return toAjax(workFlowService.updateWorkFlow(workFlow));
    }

    /**
     * 删除任务流程
     */
    @RequiresPermissions("module:flow:remove")
    @Log(title = "任务流程", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(workFlowService.deleteWorkFlowByIds(ids));
    }
}
