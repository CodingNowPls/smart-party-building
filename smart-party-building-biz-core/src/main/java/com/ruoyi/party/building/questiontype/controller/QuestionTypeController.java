package com.ruoyi.party.building.questiontype.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.party.building.questiontype.domain.QuestionType;
import com.ruoyi.party.building.questiontype.service.IQuestionTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 题库分类Controller
 *
 * @author ruoyi
 * @date 2020-06-04
 */
@Controller
@RequestMapping("/module/questiontype")
public class QuestionTypeController extends BaseController {
    private String prefix = "module/questiontype";

    @Autowired
    private IQuestionTypeService questionTypeService;

    @RequiresPermissions("module:questiontype:view")
    @GetMapping()
    public String questiontype() {
        return prefix + "/questiontype";
    }

    /**
     * 查询题库分类列表
     */
    @RequiresPermissions("module:questiontype:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(QuestionType questionType) {
        startPage();
        List<QuestionType> list = questionTypeService.selectQuestionTypeList(questionType);
        return getDataTable(list);
    }

    /**
     * 导出题库分类列表
     */
    @RequiresPermissions("module:questiontype:export")
    @Log(title = "题库分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(QuestionType questionType) {
        List<QuestionType> list = questionTypeService.selectQuestionTypeList(questionType);
        ExcelUtil<QuestionType> util = new ExcelUtil<QuestionType>(QuestionType.class);
        return util.exportExcel(list, "questiontype");
    }

    /**
     * 新增题库分类
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存题库分类
     */
    @RequiresPermissions("module:questiontype:add")
    @Log(title = "题库分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(QuestionType questionType) {
        questionType.setCreateBy(ShiroUtils.getLoginName());
        questionType.setCreateTime(DateUtils.getNowDate());
        return toAjax(questionTypeService.insertQuestionType(questionType));
    }

    /**
     * 修改题库分类
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        QuestionType questionType = questionTypeService.selectQuestionTypeById(id);
        mmap.put("questionType", questionType);
        return prefix + "/edit";
    }

    /**
     * 修改保存题库分类
     */
    @RequiresPermissions("module:questiontype:edit")
    @Log(title = "题库分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(QuestionType questionType) {
        questionType.setUpdateBy(ShiroUtils.getLoginName());
        questionType.setUpdateTime(DateUtils.getNowDate());
        return toAjax(questionTypeService.updateQuestionType(questionType));
    }

    /**
     * 删除题库分类
     */
    @RequiresPermissions("module:questiontype:remove")
    @Log(title = "题库分类", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(questionTypeService.deleteQuestionTypeByIds(ids));
    }
}
