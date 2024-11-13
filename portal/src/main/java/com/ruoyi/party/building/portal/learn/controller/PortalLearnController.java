package com.ruoyi.party.building.portal.learn.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.party.building.learn.domain.Learn;
import com.ruoyi.party.building.learn.service.ILearnService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : gao
 * @date 2024年11月13日
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
@Api("portal-学习接口")
@RestController
@RequestMapping("/api")
public class PortalLearnController {

    @Autowired
    private ILearnService learnService;


    @ApiOperation("学分添加")
    @PostMapping("addLearn")
    public AjaxResult addLearn(@RequestBody Learn learn) {
        int result = learnService.insertLearn(learn);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("编辑成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("编辑失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("成员学分排行")
    @GetMapping("/getUserRankList")
    public AjaxResult getUserRankList(String deptId) {
        Learn learn = new Learn();
        learn.setDeptId(Long.valueOf(deptId));
        List<Learn> list = learnService.selectUserRankList(learn);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("小组学分排行")
    @GetMapping("/getDeptRankList")
    public AjaxResult getDeptRankList() {
        Learn learn = new Learn();
        List<Learn> list = learnService.selectDeptRankList(learn);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }


    @ApiOperation("成员学分记录")
    @GetMapping("/getLearnInfo")
    public AjaxResult getLearnInfo(String userId) {
        Learn learn = new Learn();
        learn.setUserId(Long.valueOf(userId));
        List<Learn> list = learnService.selectLearnList(learn);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

}
