package com.ruoyi.party.building.portal.tale.controller;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.party.building.tale.domain.Tale;
import com.ruoyi.party.building.tale.service.ITaleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 小组故事接口
 *
 * @author : gao
 * @date 2024年11月13日
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
@Api("portal-小组故事接口")
@RequiresGuest
@RestController
@RequestMapping("/api")
public class PortalTaleController {


    @Autowired
    private ITaleService taleService;

    @ApiOperation("小组故事添加")
    @PostMapping("/addTale")
    public AjaxResult addTale(@RequestBody Tale tale) {
        int result = taleService.insertTale(tale);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("提交成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("提交失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("小组故事编辑")
    @PostMapping("/editTale")
    public AjaxResult editTale(@RequestBody Tale tale) {
        int result = taleService.updateTale(tale);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("编辑成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("编辑失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("小组故事列表")
    @GetMapping("/getTaleList")
    public AjaxResult getTaleList(String deptId) {
        Tale tale = new Tale();
        tale.setDeptId(Long.valueOf(deptId));
        List<Tale> list = taleService.selectTaleList(tale);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("小组故事详情")
    @GetMapping("/getTaleInfo")
    public AjaxResult getTaleInfo(String taleId) {
        Tale tale = taleService.selectTaleById(Long.valueOf(taleId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("tale", tale);
        return ajaxResult;
    }

}
