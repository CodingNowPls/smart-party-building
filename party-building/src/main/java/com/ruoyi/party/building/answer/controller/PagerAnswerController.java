package com.ruoyi.party.building.answer.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.module.answer.domain.PagerAnswer;
import com.ruoyi.web.controller.module.answer.service.IPagerAnswerService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import java.util.List;


/**
 * 试卷答案Controller
 *
 * @author ruoyi
 * @date 2020-06-08
 */
@Controller
@RequestMapping("/module/answer")
public class PagerAnswerController extends BaseController {
    private String prefix = "module/answer";

    @Autowired
    private IPagerAnswerService pagerAnswerService;

    @RequiresPermissions("module:answer:view")
    @GetMapping()
    public String answer() {
        return prefix + "/answer";
    }

    /**
     * 查询试卷答案列表
     */
    @RequiresPermissions("module:answer:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PagerAnswer pagerAnswer) {
        startPage();
        List<PagerAnswer> list = pagerAnswerService.selectPagerAnswerList(pagerAnswer);
        return getDataTable(list);
    }

    /**
     * 导出试卷答案列表
     */
    @RequiresPermissions("module:answer:export")
    @Log(title = "试卷答案", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PagerAnswer pagerAnswer) {
        List<PagerAnswer> list = pagerAnswerService.selectPagerAnswerList(pagerAnswer);
        ExcelUtil<PagerAnswer> util = new ExcelUtil<PagerAnswer>(PagerAnswer.class);
        return util.exportExcel(list, "answer");
    }

    /**
     * 新增试卷答案
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存试卷答案
     */
    @RequiresPermissions("module:answer:add")
    @Log(title = "试卷答案", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PagerAnswer pagerAnswer) {
        pagerAnswer.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(pagerAnswerService.insertPagerAnswer(pagerAnswer));
    }

    /**
     * 修改试卷答案
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        PagerAnswer pagerAnswer = pagerAnswerService.selectPagerAnswerById(id);
        mmap.put("pagerAnswer", pagerAnswer);
        return prefix + "/edit";
    }

    /**
     * 修改保存试卷答案
     */
    @RequiresPermissions("module:answer:edit")
    @Log(title = "试卷答案", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PagerAnswer pagerAnswer) {
        pagerAnswer.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(pagerAnswerService.updatePagerAnswer(pagerAnswer));
    }

    /**
     * 删除试卷答案
     */
    @RequiresPermissions("module:answer:remove")
    @Log(title = "试卷答案", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(pagerAnswerService.deletePagerAnswerByIds(ids));
    }


    /**
     * 试卷得分总计列表
     *
     * @return
     */
    @RequiresPermissions("module:answer:view")
    @GetMapping("/count")
    public String count() {
        return prefix + "/count";
    }

    @RequiresPermissions("module:answer:list")
    @PostMapping("/countList")
    @ResponseBody
    public TableDataInfo countList(PagerAnswer pagerAnswer) {
        startPage();
        List<PagerAnswer> list = pagerAnswerService.selectTotal(pagerAnswer);
        return getDataTable(list);
    }

    /**
     * 查看试卷
     */
    @GetMapping("/lookPager")
    public String lookPager(PagerAnswer pagerAnswer, ModelMap mmap) {
        List<PagerAnswer> questionList = pagerAnswerService.selectPagerAnswerByPagerId(pagerAnswer);
        mmap.put("list", questionList);
        return prefix + "/lookPager";
    }

    /**
     * 批改试卷
     */
    @GetMapping("/editPager")
    public String editPager(PagerAnswer pagerAnswer, ModelMap mmap) {
        List<PagerAnswer> questionList = pagerAnswerService.selectPagerAnswerByPagerId(pagerAnswer);
        mmap.put("list", questionList);
        return prefix + "/editPager";
    }

    /**
     * 批量修改分数
     */

    @PostMapping("/updateBatch")
    @ResponseBody
    public AjaxResult updateBatch(@RequestBody List<PagerAnswer> answerList) {
        AjaxResult ajax = AjaxResult.success();
        if (answerList != null && answerList.size() > 0) {
            for (PagerAnswer answer : answerList) {
                answer.setIsRight("1");
                pagerAnswerService.updatePagerAnswer(answer);
            }
        }
        return ajax;
    }
}
