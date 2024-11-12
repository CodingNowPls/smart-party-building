package com.ruoyi.web.controller.module.learn.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.module.learn.domain.Learn;
import com.ruoyi.web.controller.module.learn.service.ILearnService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 学习Controller
 *
 * @author ruoyi
 * @date 2020-05-21
 */
@Controller
@RequestMapping("/module/learn")
public class LearnController extends BaseController {
    private String prefix = "module/learn";

    @Autowired
    private ILearnService learnService;

    @RequiresPermissions("module:learn:view")
    @GetMapping()
    public String learn(Learn learn, ModelMap mmap) {
        mmap.put("userId", learn.getUserId());
        return prefix + "/learn";
    }

    /**
     * 查询学习列表
     */
    @RequiresPermissions("module:learn:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Learn learn) {
        startPage();
        List<Learn> list = learnService.selectLearnList(learn);
        return getDataTable(list);
    }

    /**
     * 导出学习列表
     */
    @RequiresPermissions("module:learn:export")
    @Log(title = "学习", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Learn learn) {
        List<Learn> list = learnService.selectLearnList(learn);
        ExcelUtil<Learn> util = new ExcelUtil<Learn>(Learn.class);
        return util.exportExcel(list, "learn");
    }

    /**
     * 新增学习
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存学习
     */
    @RequiresPermissions("module:learn:add")
    @Log(title = "学习", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Learn learn) {
        return toAjax(learnService.insertLearn(learn));
    }

    /**
     * 修改学习
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Learn learn = learnService.selectLearnById(id);
        mmap.put("learn", learn);
        return prefix + "/edit";
    }

    /**
     * 修改保存学习
     */
    @RequiresPermissions("module:learn:edit")
    @Log(title = "学习", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Learn learn) {
        return toAjax(learnService.updateLearn(learn));
    }

    /**
     * 删除学习
     */
    @RequiresPermissions("module:learn:remove")
    @Log(title = "学习", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(learnService.deleteLearnByIds(ids));
    }


    /**
     * 同组成员排行
     */
    @RequiresPermissions("module:learn:view")
    @GetMapping("/userRank")
    public String userRank() {
        return prefix + "/userRank";
    }

    /**
     * 查询学习列表
     */
    @RequiresPermissions("module:learn:list")
    @PostMapping("/userList")
    @ResponseBody
    public TableDataInfo userList(Learn learn) {
        startPage();
        List<Learn> list = learnService.selectUserRankList(learn);
        return getDataTable(list);
    }

    /**
     * 不同组排行
     */
    @RequiresPermissions("module:learn:view")
    @GetMapping("/deptRank")
    public String deptRank() {
        return prefix + "/deptRank";
    }

    /**
     * 查询学习列表
     */
    @RequiresPermissions("module:learn:list")
    @PostMapping("/deptList")
    @ResponseBody
    public TableDataInfo deptList(Learn learn) {
        startPage();
        List<Learn> list = learnService.selectDeptRankList(learn);
        return getDataTable(list);
    }
}
