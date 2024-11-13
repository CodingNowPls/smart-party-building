package com.ruoyi.party.building.portal.story.controller;


import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.party.building.story.domain.Story;
import com.ruoyi.party.building.story.service.IStoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 暖心故事接口
 *
 * @author : gao
 * @date 2024年11月13日
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
@Api("portal-暖心故事接口")
@Anonymous
@RestController
@RequestMapping("/portal")
public class PortalStoryController {

    @Autowired
    private IStoryService storyService;


    @ApiOperation("暖心故事")
    @GetMapping("/getStoryList")
    public AjaxResult getStoryList() {
        List<Story> list = storyService.selectStoryList(new Story());
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("暖心故事详情")
    @GetMapping("/getStoryInfo")
    public AjaxResult getStoryInfo(String storyId) {
        Story story = storyService.selectStoryById(Long.valueOf(storyId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("story", story);
        return ajaxResult;
    }

}
