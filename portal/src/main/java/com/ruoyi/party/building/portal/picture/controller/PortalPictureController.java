package com.ruoyi.party.building.portal.picture.controller;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.party.building.picture.domain.Picture;
import com.ruoyi.party.building.picture.service.IPictureService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@RestController
@RequestMapping("/api")
public class PortalPictureController {

    @Autowired
    private IPictureService pictureService;

    @ApiOperation("轮播图片")
    @GetMapping("/getPictureList")
    public AjaxResult getPictureList() {
        Picture picture = new Picture();
        List<Picture> list = pictureService.selectPictureList(picture);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

}
