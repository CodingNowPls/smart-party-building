package com.ruoyi.web.controller.module.story.controller;

import java.util.List;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.web.controller.module.story.domain.Story;
import com.ruoyi.web.controller.module.story.service.IStoryService;


import com.ruoyi.common.utils.poi.ExcelUtil;


/**
 * 故事Controller
 *
 * @author ruoyi
 * @date 2020-05-08
 */
@Controller
@RequestMapping("/module/story")
public class StoryController extends BaseController {
    private String prefix = "module/story";

    @Autowired
    private IStoryService storyService;

    @RequiresPermissions("module:story:view")
    @GetMapping()
    public String story() {
        return prefix + "/story";
    }

    /**
     * 查询故事列表
     */
    @RequiresPermissions("module:story:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Story story) {
        startPage();
        List<Story> list = storyService.selectStoryList(story);
        return getDataTable(list);
    }

    /**
     * 导出故事列表
     */
    @RequiresPermissions("module:story:export")
    @Log(title = "故事", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Story story) {
        List<Story> list = storyService.selectStoryList(story);
        ExcelUtil<Story> util = new ExcelUtil<Story>(Story.class);
        return util.exportExcel(list, "story");
    }

    /**
     * 新增故事
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存故事
     */
    @RequiresPermissions("module:story:add")
    @Log(title = "故事", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Story story) {
        return toAjax(storyService.insertStory(story));
    }

    /**
     * 修改故事
     */
    @GetMapping("/edit/{storyId}")
    public String edit(@PathVariable("storyId") Long storyId, ModelMap mmap) {
        Story story = storyService.selectStoryById(storyId);
        mmap.put("story", story);
        return prefix + "/edit";
    }

    /**
     * 修改保存故事
     */
    @RequiresPermissions("module:story:edit")
    @Log(title = "故事", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Story story) {
        return toAjax(storyService.updateStory(story));
    }

    /**
     * 删除故事
     */
    @RequiresPermissions("module:story:remove")
    @Log(title = "故事", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(storyService.deleteStoryByIds(ids));
    }

    /**
     * 详情
     *
     * @param storyId
     * @param mmap
     * @return
     */
    @GetMapping("/detail/{storyId}")
    public String detail(@PathVariable("storyId") Long storyId, ModelMap mmap) {
        Story story = storyService.selectStoryById(storyId);
        mmap.put("story", story);
        return prefix + "/detail";
    }
}
