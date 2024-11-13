package com.ruoyi.party.building.portal.problem.controller;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.party.building.problem.domain.Problem;
import com.ruoyi.party.building.problem.service.IProblemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 接口
 *
 * @author : gao
 * @date 2024年11月13日
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
@Api("portal-接口")
@RestController
@RequestMapping("/api")
public class PortalProblemController {


    @Autowired
    private IProblemService problemService;


    @ApiOperation("问题墙添加")
    @PostMapping("/addProblem")
    public AjaxResult addProblem(@RequestBody Problem problem) {
        int result = problemService.insertProblem(problem);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("提交成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("提交失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("问题墙编辑")
    @PostMapping("/editProblem")
    public AjaxResult editProblem(@RequestBody Problem problem) {
        int result = problemService.updateProblem(problem);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("编辑成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("编辑失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("问题墙列表")
    @GetMapping("/getProblemList")
    public AjaxResult getProblemList(String deptId) {
        Problem problem = new Problem();
        problem.setDeptId(Long.valueOf(deptId));
        List<Problem> list = problemService.selectProblemList(problem);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("问题墙详情")
    @GetMapping("getProblemInfo")
    public AjaxResult getProblemInfo(String problemId) {
        Problem problem = problemService.selectProblemById(Long.valueOf(problemId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("problem", problem);
        return ajaxResult;
    }


}
