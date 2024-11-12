package com.ruoyi.party.building.collect.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.module.collect.domain.Collect;
import com.ruoyi.web.controller.module.collect.service.ICollectService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 学习收藏Controller
 *
 * @author ruoyi
 * @date 2020-07-10
 */
@Controller
@RequestMapping("/module/collect")
public class CollectController extends BaseController {
    private String prefix = "module/collect";

    @Autowired
    private ICollectService collectService;

    @RequiresPermissions("module:collect:view")
    @GetMapping()
    public String collect() {
        return prefix + "/collect";
    }

    /**
     * 查询学习收藏列表
     */
    @RequiresPermissions("module:collect:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Collect collect) {
        startPage();
        List<Collect> list = collectService.selectCollectList(collect);
        return getDataTable(list);
    }

    /**
     * 导出学习收藏列表
     */
    @RequiresPermissions("module:collect:export")
    @Log(title = "学习收藏", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Collect collect) {
        List<Collect> list = collectService.selectCollectList(collect);
        ExcelUtil<Collect> util = new ExcelUtil<Collect>(Collect.class);
        return util.exportExcel(list, "collect");
    }

    /**
     * 新增学习收藏
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存学习收藏
     */
    @RequiresPermissions("module:collect:add")
    @Log(title = "学习收藏", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Collect collect) {
        return toAjax(collectService.insertCollect(collect));
    }

    /**
     * 修改学习收藏
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Collect collect = collectService.selectCollectById(id);
        mmap.put("collect", collect);
        return prefix + "/edit";
    }

    /**
     * 修改保存学习收藏
     */
    @RequiresPermissions("module:collect:edit")
    @Log(title = "学习收藏", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Collect collect) {
        return toAjax(collectService.updateCollect(collect));
    }

    /**
     * 删除学习收藏
     */
    @RequiresPermissions("module:collect:remove")
    @Log(title = "学习收藏", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(collectService.deleteCollectByIds(ids));
    }
}
