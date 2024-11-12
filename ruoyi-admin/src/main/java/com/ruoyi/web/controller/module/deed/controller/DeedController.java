package com.ruoyi.web.controller.module.deed.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.module.deed.domain.Deed;
import com.ruoyi.web.controller.module.deed.service.IDeedService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 事迹Controller
 *
 * @author ruoyi
 * @date 2020-05-08
 */
@Controller
@RequestMapping("/module/deed")
public class DeedController extends BaseController {
    private String prefix = "module/deed";

    @Autowired
    private IDeedService deedService;

    @RequiresPermissions("module:deed:view")
    @GetMapping()
    public String deed() {
        return prefix + "/deed";
    }

    /**
     * 查询事迹列表
     */
    @RequiresPermissions("module:deed:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Deed deed) {
        startPage();
        List<Deed> list = deedService.selectDeedList(deed);
        return getDataTable(list);
    }

    /**
     * 导出事迹列表
     */
    @RequiresPermissions("module:deed:export")
    @Log(title = "事迹", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Deed deed) {
        List<Deed> list = deedService.selectDeedList(deed);
        ExcelUtil<Deed> util = new ExcelUtil<Deed>(Deed.class);
        return util.exportExcel(list, "deed");
    }

    /**
     * 新增事迹
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存事迹
     */
    @RequiresPermissions("module:deed:add")
    @Log(title = "事迹", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Deed deed) {
        return toAjax(deedService.insertDeed(deed));
    }

    /**
     * 修改事迹
     */
    @GetMapping("/edit/{deedId}")
    public String edit(@PathVariable("deedId") Long deedId, ModelMap mmap) {
        Deed deed = deedService.selectDeedById(deedId);
        mmap.put("deed", deed);
        return prefix + "/edit";
    }

    /**
     * 修改保存事迹
     */
    @RequiresPermissions("module:deed:edit")
    @Log(title = "事迹", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Deed deed) {
        return toAjax(deedService.updateDeed(deed));
    }

    /**
     * 删除事迹
     */
    @RequiresPermissions("module:deed:remove")
    @Log(title = "事迹", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(deedService.deleteDeedByIds(ids));
    }

    /**
     * 详情
     */
    @GetMapping("/detail/{deedId}")
    public String detail(@PathVariable("deedId") Long deedId, ModelMap mmap) {
        Deed deed = deedService.selectDeedById(deedId);
        mmap.put("deed", deed);
        return prefix + "/detail";
    }
}
