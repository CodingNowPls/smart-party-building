package com.ruoyi.party.building.portal.award.controller;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.party.building.award.domain.Award;
import com.ruoyi.party.building.award.service.IAwardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@Api("portal-接口")
@RequiresGuest
@RestController
@RequestMapping("/api")
public class PortalAwardController {

    @Autowired
    private IAwardService awardService;

    @ApiOperation("荣誉奖项")
    @GetMapping("/getAwardList")
    public AjaxResult getAwardList() {
        List<Award> list = awardService.selectAwardList(new Award());
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("荣誉奖项详情")
    @GetMapping("/getAwardInfo")
    public AjaxResult getAwardInfo(String awardId) {
        Award award = awardService.selectAwardById(Long.valueOf(awardId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("award", award);
        return ajaxResult;
    }


}
