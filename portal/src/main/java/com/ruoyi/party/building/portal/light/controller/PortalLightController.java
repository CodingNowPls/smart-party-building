package com.ruoyi.party.building.portal.light.controller;


import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.party.building.light.domain.Light;
import com.ruoyi.party.building.light.service.ILightService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 十大亮点接口
 *
 * @author : gao
 * @date 2024年11月13日
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
@Api("portal-十大亮点接口")
@Anonymous
@RestController
@RequestMapping("/portal")
public class PortalLightController {

    @Autowired
    private ILightService lightService;

    @ApiOperation("十大亮点")
    @GetMapping("/getLightList")
    public AjaxResult getLightList() {
        List<Light> list = lightService.selectLightList(new Light());
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("十大亮点详情")
    @GetMapping("/getLightInfo")
    public AjaxResult getLightInfo(String lightId) {
        Light light = lightService.selectLightById(Long.valueOf(lightId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("light", light);
        return ajaxResult;
    }


}
