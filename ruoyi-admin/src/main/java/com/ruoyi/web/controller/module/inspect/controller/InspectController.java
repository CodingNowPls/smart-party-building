package com.ruoyi.web.controller.module.inspect.controller;

import java.util.List;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.web.controller.module.inspect.service.IInspectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.web.controller.module.inspect.domain.Inspect;
import com.ruoyi.web.controller.module.inspect.service.IInspectService;


import com.ruoyi.common.utils.poi.ExcelUtil;


/**
 * 视察Controller
 *
 * @author ruoyi
 * @date 2020-05-07
 */
@Controller
@RequestMapping("/module/inspect")
public class InspectController extends BaseController {
    private String prefix = "module/inspect";

    @Autowired
    private IInspectService inspectService;

    @RequiresPermissions("module:inspect:view")
    @GetMapping()
    public String inspect() {
        return prefix + "/inspect";
    }

    /**
     * 查询视察列表
     */
    @RequiresPermissions("module:inspect:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Inspect inspect) {
        startPage();
        List<Inspect> list = inspectService.selectInspectList(inspect);
        return getDataTable(list);
    }

    /**
     * 导出视察列表
     */
    @RequiresPermissions("module:inspect:export")
    @Log(title = "视察", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Inspect inspect) {
        List<Inspect> list = inspectService.selectInspectList(inspect);
        ExcelUtil<Inspect> util = new ExcelUtil<Inspect>(Inspect.class);
        return util.exportExcel(list, "inspect");
    }

    /**
     * 新增视察
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存视察
     */
    @RequiresPermissions("module:inspect:add")
    @Log(title = "视察", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Inspect inspect) {
        return toAjax(inspectService.insertInspect(inspect));
    }

    /**
     * 修改视察
     */
    @GetMapping("/edit/{inspectId}")
    public String edit(@PathVariable("inspectId") Long inspectId, ModelMap mmap) {
        Inspect inspect = inspectService.selectInspectById(inspectId);
        mmap.put("inspect", inspect);
        return prefix + "/edit";
    }

    /**
     * 修改保存视察
     */
    @RequiresPermissions("module:inspect:edit")
    @Log(title = "视察", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Inspect inspect) {
        return toAjax(inspectService.updateInspect(inspect));
    }

    /**
     * 删除视察
     */
    @RequiresPermissions("module:inspect:remove")
    @Log(title = "视察", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(inspectService.deleteInspectByIds(ids));
    }


    /**
     * 详情
     *
     * @param inspectId
     * @param mmap
     * @return
     */
    @GetMapping("/detail/{inspectId}")
    public String detail(@PathVariable("inspectId") Long inspectId, ModelMap mmap) {
        Inspect inspect = inspectService.selectInspectById(inspectId);
        mmap.put("inspect", inspect);
        return prefix + "/detail";
    }
}
