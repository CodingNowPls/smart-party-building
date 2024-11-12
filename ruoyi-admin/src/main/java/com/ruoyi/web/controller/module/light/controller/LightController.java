package com.ruoyi.web.controller.module.light.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.module.light.domain.Light;
import com.ruoyi.web.controller.module.light.service.ILightService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 亮点Controller
 *
 * @author ruoyi
 * @date 2020-05-08
 */
@Controller
@RequestMapping("/module/light")
public class LightController extends BaseController {
    private String prefix = "module/light";

    @Autowired
    private ILightService lightService;

    @RequiresPermissions("module:light:view")
    @GetMapping()
    public String light() {
        return prefix + "/light";
    }

    /**
     * 查询亮点列表
     */
    @RequiresPermissions("module:light:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Light light) {
        startPage();
        List<Light> list = lightService.selectLightList(light);
        return getDataTable(list);
    }

    /**
     * 导出亮点列表
     */
    @RequiresPermissions("module:light:export")
    @Log(title = "亮点", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Light light) {
        List<Light> list = lightService.selectLightList(light);
        ExcelUtil<Light> util = new ExcelUtil<Light>(Light.class);
        return util.exportExcel(list, "light");
    }

    /**
     * 新增亮点
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存亮点
     */
    @RequiresPermissions("module:light:add")
    @Log(title = "亮点", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Light light) {
        return toAjax(lightService.insertLight(light));
    }

    /**
     * 修改亮点
     */
    @GetMapping("/edit/{lightId}")
    public String edit(@PathVariable("lightId") Long lightId, ModelMap mmap) {
        Light light = lightService.selectLightById(lightId);
        mmap.put("light", light);
        return prefix + "/edit";
    }

    /**
     * 修改保存亮点
     */
    @RequiresPermissions("module:light:edit")
    @Log(title = "亮点", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Light light) {
        return toAjax(lightService.updateLight(light));
    }

    /**
     * 删除亮点
     */
    @RequiresPermissions("module:light:remove")
    @Log(title = "亮点", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(lightService.deleteLightByIds(ids));
    }

    /**
     * 查看详情
     */
    @GetMapping("/detail/{lightId}")
    public String detail(@PathVariable("lightId") Long lightId, ModelMap mmap) {
        Light light = lightService.selectLightById(lightId);
        mmap.put("light", light);
        return prefix + "/detail";
    }
}
