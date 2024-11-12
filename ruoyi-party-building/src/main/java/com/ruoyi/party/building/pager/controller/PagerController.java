package com.ruoyi.party.building.pager.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.party.building.pager.domain.Pager;
import com.ruoyi.party.building.pager.service.IPagerService;
import com.ruoyi.party.building.question.domain.Question;
import com.ruoyi.party.building.question.service.IQuestionService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 试卷Controller
 *
 * @author ruoyi
 * @date 2020-06-05
 */
@Controller
@RequestMapping("/module/pager")
public class PagerController extends BaseController {
    private String prefix = "module/pager";

    @Autowired
    private IPagerService pagerService;
    @Autowired
    private IQuestionService questionService;

    @RequiresPermissions("module:pager:view")
    @GetMapping()
    public String pager() {
        return prefix + "/pager";
    }

    /**
     * 查询试卷列表
     */
    @RequiresPermissions("module:pager:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Pager pager) {
        startPage();
        List<Pager> list = pagerService.selectPagerList(pager);
        return getDataTable(list);
    }

    /**
     * 导出试卷列表
     */
    @RequiresPermissions("module:pager:export")
    @Log(title = "试卷", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Pager pager) {
        List<Pager> list = pagerService.selectPagerList(pager);
        ExcelUtil<Pager> util = new ExcelUtil<Pager>(Pager.class);
        return util.exportExcel(list, "pager");
    }

    /**
     * 新增试卷
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存试卷
     */
    @RequiresPermissions("module:pager:add")
    @Log(title = "试卷", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Pager pager) {
        pager.setCreateBy(ShiroUtils.getLoginName());
        pager.setCreateTime(DateUtils.getNowDate());
        return toAjax(pagerService.insertPager(pager));
    }

    /**
     * 修改试卷
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Pager pager = pagerService.selectPagerById(id);
        mmap.put("pager", pager);
        return prefix + "/edit";
    }

    /**
     * 修改保存试卷
     */
    @RequiresPermissions("module:pager:edit")
    @Log(title = "试卷", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Pager pager) {
        pager.setUpdateBy(ShiroUtils.getLoginName());
        pager.setUpdateTime(DateUtils.getNowDate());
        return toAjax(pagerService.updatePager(pager));
    }

    /**
     * 删除试卷
     */
    @RequiresPermissions("module:pager:remove")
    @Log(title = "试卷", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(pagerService.deletePagerByIds(ids));
    }

    /**
     * 查看试卷
     */
    @GetMapping("/lookPager/{id}")
    public String lookPager(@PathVariable("id") Long id, ModelMap mmap) {
        List<Question> questionList = questionService.selectQuetionByPagerId(id);
        mmap.put("list", questionList);
        return prefix + "/lookPager";
    }

    /**
     * 试卷排序
     *
     * @param id
     * @param mmap
     * @return
     */
    @GetMapping("/rankPager/{id}")
    public String rankPager(@PathVariable("id") Long id, ModelMap mmap) {
        mmap.put("pagerId", id);
        return prefix + "/rankPager";
    }

    @RequiresPermissions("module:pager:list")
    @PostMapping("/rankList/{id}")
    @ResponseBody
    public TableDataInfo rankList(@PathVariable("id") Long id) {
        startPage();
        List<Question> questionList = questionService.selectQuetionByPagerId(id);
        return getDataTable(questionList);
    }

}
