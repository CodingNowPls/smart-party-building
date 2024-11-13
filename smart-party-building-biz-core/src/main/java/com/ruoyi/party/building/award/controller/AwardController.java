package com.ruoyi.party.building.award.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.party.building.award.domain.Award;
import com.ruoyi.party.building.award.service.IAwardService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 奖项Controller
 *
 * @author ruoyi
 * @date 2020-05-08
 */
@Controller
@RequestMapping("/module/award")
public class AwardController extends BaseController {
    private String prefix = "module/award";

    @Autowired
    private IAwardService awardService;

    @RequiresPermissions("module:award:view")
    @GetMapping()
    public String award() {
        return prefix + "/award";
    }

    /**
     * 查询奖项列表
     */
    @RequiresPermissions("module:award:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Award award) {
        startPage();
        List<Award> list = awardService.selectAwardList(award);
        return getDataTable(list);
    }

    /**
     * 导出奖项列表
     */
    @RequiresPermissions("module:award:export")
    @Log(title = "奖项", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Award award) {
        List<Award> list = awardService.selectAwardList(award);
        ExcelUtil<Award> util = new ExcelUtil<Award>(Award.class);
        return util.exportExcel(list, "award");
    }

    /**
     * 新增奖项
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存奖项
     */
    @RequiresPermissions("module:award:add")
    @Log(title = "奖项", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Award award) {
        return toAjax(awardService.insertAward(award));
    }

    /**
     * 修改奖项
     */
    @GetMapping("/edit/{awardId}")
    public String edit(@PathVariable("awardId") Long awardId, ModelMap mmap) {
        Award award = awardService.selectAwardById(awardId);
        mmap.put("award", award);
        return prefix + "/edit";
    }

    /**
     * 修改保存奖项
     */
    @RequiresPermissions("module:award:edit")
    @Log(title = "奖项", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Award award) {
        return toAjax(awardService.updateAward(award));
    }

    /**
     * 删除奖项
     */
    @RequiresPermissions("module:award:remove")
    @Log(title = "奖项", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(awardService.deleteAwardByIds(ids));
    }


    /**
     * 详情
     */
    @GetMapping("/detail/{awardId}")
    public String detail(@PathVariable("awardId") Long awardId, ModelMap mmap) {
        Award award = awardService.selectAwardById(awardId);
        mmap.put("award", award);
        return prefix + "/detail";
    }
}
