package com.ruoyi.party.building.workdist.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.module.workdist.domain.WorkDist;
import com.ruoyi.web.controller.module.workdist.service.IWorkDistService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import java.util.List;


/**
 * 任务分配Controller
 *
 * @author ruoyi
 * @date 2020-06-01
 */
@Controller
@RequestMapping("/module/dist")
public class WorkDistController extends BaseController {
    private String prefix = "module/dist";

    @Autowired
    private IWorkDistService workDistService;

    @RequiresPermissions("module:dist:view")
    @GetMapping()
    public String dist() {
        return prefix + "/dist";
    }

    /**
     * 查询任务分配列表
     */
    @RequiresPermissions("module:dist:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WorkDist workDist) {
        startPage();
        List<WorkDist> list = workDistService.selectWorkDistList(workDist);
        return getDataTable(list);
    }

    /**
     * 导出任务分配列表
     */
    @RequiresPermissions("module:dist:export")
    @Log(title = "任务分配", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WorkDist workDist) {
        List<WorkDist> list = workDistService.selectWorkDistList(workDist);
        ExcelUtil<WorkDist> util = new ExcelUtil<WorkDist>(WorkDist.class);
        return util.exportExcel(list, "dist");
    }

    /**
     * 新增任务分配
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存任务分配
     */
    @RequiresPermissions("module:dist:add")
    @Log(title = "任务分配", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WorkDist workDist) {
        return toAjax(workDistService.insertWorkDist(workDist));
    }

    /**
     * 修改任务分配
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        WorkDist workDist = workDistService.selectWorkDistById(id);
        mmap.put("workDist", workDist);
        return prefix + "/edit";
    }

    /**
     * 修改保存任务分配
     */
    @RequiresPermissions("module:dist:edit")
    @Log(title = "任务分配", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WorkDist workDist) {
        return toAjax(workDistService.updateWorkDist(workDist));
    }

    /**
     * 删除任务分配
     */
    @RequiresPermissions("module:dist:remove")
    @Log(title = "任务分配", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(workDistService.deleteWorkDistByIds(ids));
    }
}
