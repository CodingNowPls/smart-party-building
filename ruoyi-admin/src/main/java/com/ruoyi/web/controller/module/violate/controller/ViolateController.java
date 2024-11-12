package com.ruoyi.web.controller.module.violate.controller;

import java.util.List;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.web.controller.module.violate.domain.Violate;
import com.ruoyi.web.controller.module.violate.service.IViolateService;


import com.ruoyi.common.utils.poi.ExcelUtil;


/**
 * 违规违纪Controller
 *
 * @author ruoyi
 * @date 2020-06-22
 */
@Controller
@RequestMapping("/module/violate")
public class ViolateController extends BaseController {
    private String prefix = "module/violate";

    @Autowired
    private IViolateService violateService;

    @RequiresPermissions("module:violate:view")
    @GetMapping()
    public String violate() {
        return prefix + "/violate";
    }

    /**
     * 查询违规违纪列表
     */
    @RequiresPermissions("module:violate:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Violate violate) {
        startPage();
        List<Violate> list = violateService.selectViolateList(violate);
        return getDataTable(list);
    }

    /**
     * 导出违规违纪列表
     */
    @RequiresPermissions("module:violate:export")
    @Log(title = "违规违纪", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Violate violate) {
        List<Violate> list = violateService.selectViolateList(violate);
        ExcelUtil<Violate> util = new ExcelUtil<Violate>(Violate.class);
        return util.exportExcel(list, "violate");
    }

    /**
     * 新增违规违纪
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存违规违纪
     */
    @RequiresPermissions("module:violate:add")
    @Log(title = "违规违纪", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Violate violate) {
        violate.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(violateService.insertViolate(violate));
    }

    /**
     * 修改违规违纪
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Violate violate = violateService.selectViolateById(id);
        mmap.put("violate", violate);
        return prefix + "/edit";
    }

    /**
     * 修改保存违规违纪
     */
    @RequiresPermissions("module:violate:edit")
    @Log(title = "违规违纪", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Violate violate) {
        return toAjax(violateService.updateViolate(violate));
    }

    /**
     * 删除违规违纪
     */
    @RequiresPermissions("module:violate:remove")
    @Log(title = "违规违纪", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(violateService.deleteViolateByIds(ids));
    }


    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap) {
        Violate violate = violateService.selectViolateById(id);
        mmap.put("violate", violate);
        return prefix + "/detail";
    }
}
