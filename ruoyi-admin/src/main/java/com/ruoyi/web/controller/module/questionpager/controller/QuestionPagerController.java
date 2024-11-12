package com.ruoyi.web.controller.module.questionpager.controller;

import java.util.List;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.web.controller.module.questionpager.domain.QuestionPager;
import com.ruoyi.web.controller.module.questionpager.service.IQuestionPagerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.ruoyi.common.utils.poi.ExcelUtil;


/**
 * 题目试卷关联Controller
 *
 * @author ruoyi
 * @date 2020-06-06
 */
@Controller
@RequestMapping("/module/questionpager")
public class QuestionPagerController extends BaseController {
    private String prefix = "module/questionpager";

    @Autowired
    private IQuestionPagerService questionPagerService;

    @RequiresPermissions("module:questionpager:view")
    @GetMapping()
    public String questionpager() {
        return prefix + "/questionpager";
    }

    /**
     * 查询题目试卷关联列表
     */
    @RequiresPermissions("module:questionpager:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(QuestionPager questionPager) {
        startPage();
        List<QuestionPager> list = questionPagerService.selectQuestionPagerList(questionPager);
        return getDataTable(list);
    }

    /**
     * 导出题目试卷关联列表
     */
    @RequiresPermissions("module:questionpager:export")
    @Log(title = "题目试卷关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(QuestionPager questionPager) {
        List<QuestionPager> list = questionPagerService.selectQuestionPagerList(questionPager);
        ExcelUtil<QuestionPager> util = new ExcelUtil<QuestionPager>(QuestionPager.class);
        return util.exportExcel(list, "questionpager");
    }

    /**
     * 新增题目试卷关联
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存题目试卷关联
     */
    @RequiresPermissions("module:questionpager:add")
    @Log(title = "题目试卷关联", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(QuestionPager questionPager) {
        return toAjax(questionPagerService.insertQuestionPager(questionPager));
    }

    /**
     * 修改题目试卷关联
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        QuestionPager questionPager = questionPagerService.selectQuestionPagerById(id);
        mmap.put("questionPager", questionPager);
        return prefix + "/edit";
    }

    /**
     * 修改保存题目试卷关联
     */
    @RequiresPermissions("module:questionpager:edit")
    @Log(title = "题目试卷关联", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(QuestionPager questionPager) {
        return toAjax(questionPagerService.updateQuestionPager(questionPager));
    }

    /**
     * 删除题目试卷关联
     */
    @RequiresPermissions("module:questionpager:remove")
    @Log(title = "题目试卷关联", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(questionPagerService.deleteQuestionPagerByIds(ids));
    }
}
