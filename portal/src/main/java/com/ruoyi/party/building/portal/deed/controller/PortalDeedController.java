package com.ruoyi.party.building.portal.deed.controller;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.party.building.deed.domain.Deed;
import com.ruoyi.party.building.deed.service.IDeedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 典型事迹 接口
 *
 * @author : gao
 * @date 2024年11月13日
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
@Api("portal-典型事迹接口")
@RestController
@RequestMapping("/api")
public class PortalDeedController {

    @Autowired
    private IDeedService deedService;

    @ApiOperation("典型事迹")
    @GetMapping("/getDeedList")
    public AjaxResult getDeedList() {
        List<Deed> list = deedService.selectDeedList(new Deed());
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("典型事迹详情")
    @GetMapping("/getDeedInfo")
    public AjaxResult getDeedInfo(String deedId) {
        Deed deed = deedService.selectDeedById(Long.valueOf(deedId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("deed", deed);
        return ajaxResult;
    }

}
