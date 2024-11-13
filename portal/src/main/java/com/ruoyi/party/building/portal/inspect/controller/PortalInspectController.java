package com.ruoyi.party.building.portal.inspect.controller;


import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.party.building.inspect.domain.Inspect;
import com.ruoyi.party.building.inspect.service.IInspectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 领导视察接口
 *
 * @author : gao
 * @date 2024年11月13日
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
@Api("portal-领导视察接口")
@RestController
@Anonymous
@RequestMapping("/portal")
public class PortalInspectController {
    @Autowired
    private IInspectService inspectService;

    @ApiOperation("领导视察")
    @GetMapping("/getInspectList")
    public AjaxResult getInspectList() {
        List<Inspect> list = inspectService.selectInspectList(new Inspect());
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("领导视察详情")
    @GetMapping("/getInspectInfo")
    public AjaxResult getInspectInfo(String inspectId) {
        Inspect inspect = inspectService.selectInspectById(Long.valueOf(inspectId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("inspect", inspect);
        return ajaxResult;
    }

}
