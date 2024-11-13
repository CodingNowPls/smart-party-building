package com.ruoyi.party.building.portal.violate.controller;


import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.party.building.violate.domain.Violate;
import com.ruoyi.party.building.violate.service.IViolateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@Api("portal-违规违纪接口")
@Anonymous
@RestController
@RequestMapping("/portal")
public class PortalViolateController {


    @Autowired
    private IViolateService violateService;


    @ApiOperation("违规违纪列表 ")
    @PostMapping("/getViolateList")
    public AjaxResult getViolateList() {
        Violate violate = new Violate();
        List<Violate> list = violateService.selectViolateList(violate);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("违规违纪详情")
    @GetMapping("/getViolateInfo")
    public AjaxResult getViolateInfo(String id) {
        Violate violate = violateService.selectViolateById(Long.valueOf(id));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("violate", violate);
        return ajaxResult;
    }

}
