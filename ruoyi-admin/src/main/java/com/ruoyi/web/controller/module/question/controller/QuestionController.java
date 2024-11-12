package com.ruoyi.web.controller.module.question.controller;

import java.util.ArrayList;
import java.util.List;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;

import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.web.controller.module.questiontype.domain.QuestionType;
import com.ruoyi.web.controller.module.questiontype.service.IQuestionTypeService;
import com.ruoyi.web.controller.module.question.domain.Question;
import com.ruoyi.web.controller.module.question.service.IQuestionService;
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
 * 题目Controller
 *
 * @author ruoyi
 * @date 2020-06-04
 */
@Controller
@RequestMapping("/module/question")
public class QuestionController extends BaseController {
    private String prefix = "module/question";

    @Autowired
    private IQuestionService questionService;
    @Autowired
    private IQuestionTypeService questionTypeService;

    @RequiresPermissions("module:question:view")
    @GetMapping()
    public String question(ModelMap mmap) {
        QuestionType type = new QuestionType();
        List<QuestionType> typeList = questionTypeService.selectQuestionTypeList(type);
        mmap.put("typeList", typeList);
        return prefix + "/question";
    }

    /**
     * 查询题目列表
     */
    @RequiresPermissions("module:question:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Question question) {
        startPage();
        List<Question> list = questionService.selectQuestionList(question);
        return getDataTable(list);
    }

    /**
     * 导出题目列表
     */
    @RequiresPermissions("module:question:export")
    @Log(title = "题目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Question question) {
        List<Question> list = questionService.selectQuestionList(question);
        ExcelUtil<Question> util = new ExcelUtil<Question>(Question.class);
        return util.exportExcel(list, "question");
    }

    /**
     * 新增题目
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        //分类列表
        QuestionType type = new QuestionType();
        List<QuestionType> typeList = questionTypeService.selectQuestionTypeList(type);
        mmap.put("typeList", typeList);
        return prefix + "/add";
    }

    /**
     * 新增保存题目
     */
    @RequiresPermissions("module:question:add")
    @Log(title = "题目", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Question question) {
        question.setCreateBy(ShiroUtils.getLoginName());
        question.setCreateTime(DateUtils.getNowDate());
        return toAjax(questionService.insertQuestion(question));
    }

    /**
     * 修改题目
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Question question = questionService.selectQuestionById(id);
        mmap.put("question", question);

        //分类列表
        QuestionType type = new QuestionType();
        List<QuestionType> typeList = questionTypeService.selectQuestionTypeList(type);
        mmap.put("typeList", typeList);
        return prefix + "/edit";
    }

    /**
     * 修改保存题目
     */
    @RequiresPermissions("module:question:edit")
    @Log(title = "题目", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Question question) {
        question.setUpdateBy(ShiroUtils.getLoginName());
        question.setUpdateTime(DateUtils.getNowDate());
        return toAjax(questionService.updateQuestion(question));
    }

    /**
     * 删除题目
     */
    @RequiresPermissions("module:question:remove")
    @Log(title = "题目", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(questionService.deleteQuestionByIds(ids));
    }

    /**
     * 详情
     */
    @GetMapping("/detail/{id}")
    public String detail(@PathVariable("id") Long id, ModelMap mmap) {
        Question question = questionService.selectQuestionById(id);
        mmap.put("question", question);
        return prefix + "/detail";
    }

    /**
     * 查看题库列表
     *
     * @param mmap
     * @return
     */
    @RequiresPermissions("module:question:view")
    @GetMapping("/questionList")
    public String questionList(ModelMap mmap) {
        QuestionType type = new QuestionType();
        List<QuestionType> typeList = questionTypeService.selectQuestionTypeList(type);
        mmap.put("typeList", typeList);
        return prefix + "/questionList";
    }


    /**
     * 通过ids获取题目列表
     */
    @PostMapping("/getQuestionByIds")
    @ResponseBody
    public AjaxResult getQuestionByIds(String ids) {
        List<Question> questionList = new ArrayList<Question>();
        AjaxResult result = AjaxResult.success("");
        if (ids != null) {
            String[] ids1 = ids.split(",");
            for (int i = 0; i < ids1.length; i++) {
                Question question = questionService.selectQuestionById(Long.valueOf(ids1[i]));
                questionList.add(question);
            }
            result.put("list", questionList);
        } else {
            result.put("list", null);
        }
        return result;
    }


}
