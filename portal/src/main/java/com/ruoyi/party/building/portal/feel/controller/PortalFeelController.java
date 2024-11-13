package com.ruoyi.party.building.portal.feel.controller;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.party.building.feel.domain.Feel;
import com.ruoyi.party.building.feel.service.IFeelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 心得体会接口
 *
 * @author : gao
 * @date 2024年11月13日
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
@Api("portal-心得体会接口")
@RequiresGuest
@RestController
@RequestMapping("/api")
public class PortalFeelController {

    @Autowired
    private IFeelService feelService;


    @ApiOperation("心得体会添加")
    @PostMapping("/addFeel")
    public AjaxResult addFeel(@RequestBody Feel feel) {
        int result = feelService.insertFeel(feel);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("提交成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("提交失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("心得体会编辑")
    @PostMapping("/editFeel")
    public AjaxResult editFeel(@RequestBody Feel feel) {
        int result = feelService.updateFeel(feel);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("编辑成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("编辑失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("心得体会列表")
    @GetMapping("/getFeelList")
    public AjaxResult getFeelList(String deptId) {
        Feel feel = new Feel();
        feel.setDeptId(Long.valueOf(deptId));
        List<Feel> list = feelService.selectFeelList(feel);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("心得体会详情")
    @GetMapping("/getFeelInfo")
    public AjaxResult getFeelInfo(String feelId) {
        Feel feel = feelService.selectFeelById(Long.valueOf(feelId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("feel", feel);
        return ajaxResult;
    }

}
