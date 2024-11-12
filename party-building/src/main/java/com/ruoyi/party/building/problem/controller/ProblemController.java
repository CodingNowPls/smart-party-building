package com.ruoyi.party.building.problem.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.web.controller.module.problem.domain.Problem;
import com.ruoyi.web.controller.module.problem.service.IProblemService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 问题墙Controller
 *
 * @author ruoyi
 * @date 2020-05-11
 */
@Controller
@RequestMapping("/module/problem")
public class ProblemController extends BaseController {
    private String prefix = "module/problem";

    @Autowired
    private IProblemService problemService;
    @Autowired
    private ISysDeptService deptService;

    @RequiresPermissions("module:problem:view")
    @GetMapping()
    public String problem(ModelMap mmap) {
        //所有部门
        List<SysDept> deptList = deptService.selectDeptList(new SysDept());
        mmap.put("deptList", deptList);
        return prefix + "/problem";
    }

    /**
     * 查询问题墙列表
     */
    @RequiresPermissions("module:problem:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Problem problem) {
        startPage();
        List<Problem> list = problemService.selectProblemList(problem);
        return getDataTable(list);
    }

    /**
     * 导出问题墙列表
     */
    @RequiresPermissions("module:problem:export")
    @Log(title = "问题墙", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Problem problem) {
        List<Problem> list = problemService.selectProblemList(problem);
        ExcelUtil<Problem> util = new ExcelUtil<Problem>(Problem.class);
        return util.exportExcel(list, "problem");
    }

    /**
     * 新增问题墙
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(new Date());
        mmap.put("time", time);
        return prefix + "/add";
    }

    /**
     * 新增保存问题墙
     */
    @RequiresPermissions("module:problem:add")
    @Log(title = "问题墙", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Problem problem) {
        problem.setUserId(ShiroUtils.getSysUser().getUserId());
        problem.setProblemTime(DateUtils.getNowDate());
        return toAjax(problemService.insertProblem(problem));
    }

    /**
     * 修改问题墙
     */
    @GetMapping("/edit/{problemId}")
    public String edit(@PathVariable("problemId") Long problemId, ModelMap mmap) {
        Problem problem = problemService.selectProblemById(problemId);
        mmap.put("problem", problem);

        if (problem.getProblemVideo() != null) {
            String[] videos = problem.getProblemVideo().split(",");
            mmap.put("videos", videos);
        }

        return prefix + "/edit";
    }

    /**
     * 修改保存问题墙
     */
    @RequiresPermissions("module:problem:edit")
    @Log(title = "问题墙", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Problem problem) {
        return toAjax(problemService.updateProblem(problem));
    }

    /**
     * 删除问题墙
     */
    @RequiresPermissions("module:problem:remove")
    @Log(title = "问题墙", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(problemService.deleteProblemByIds(ids));
    }

    @GetMapping("/detail/{problemId}")
    public String detail(@PathVariable("problemId") Long problemId, ModelMap mmap) {
        Problem problem = problemService.selectProblemById(problemId);
        mmap.put("problem", problem);

        if (problem.getProblemVideo() != null) {
            String[] videos = problem.getProblemVideo().split(",");
            mmap.put("videos", videos);
        }

        return prefix + "/detail";
    }
}
