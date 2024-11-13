package com.ruoyi.party.building.portal.collect.controller;


import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.party.building.collect.domain.Collect;
import com.ruoyi.party.building.collect.service.ICollectService;
import com.ruoyi.party.building.news.domain.News;
import com.ruoyi.party.building.news.service.INewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@Anonymous
@RestController
@RequestMapping("/portal")
public class PortalCollectController extends BaseController {

    @Autowired
    private ICollectService collectService;
    @Autowired
    private INewsService newsService;


    @ApiOperation("加入收藏")
    @PostMapping("/addCollect")
    @ResponseBody
    public AjaxResult addCollect(@RequestBody Collect collect) {
        //判断是否收藏
        AjaxResult ajaxResult = null;
        List<Collect> collectList = collectService.selectCollectList(collect);
        if (collectList != null && collectList.size() > 0) {
            return success("已收藏!");
        } else {
            int result = collectService.insertCollect(collect);
            if (result > 0) {
                ajaxResult = success("收藏成功");
            } else {
                ajaxResult = error("收藏失败");
            }
        }
        return ajaxResult;
    }

    @ApiOperation("我的学习收藏列表")
    @PostMapping("/getCollectList")
    @ResponseBody
    public AjaxResult getCollectList(@RequestParam("userId") String userId) {
        Collect collect = new Collect();
        if (userId != null) {
            collect.setUserId(Long.valueOf(userId));
        }
        List<Collect> list = collectService.selectCollectList(collect);
        AjaxResult result = AjaxResult.success();
        result.put("list", list);
        return result;
    }


    @ApiOperation("查看详情")
    @PostMapping("/getNewsInfo")
    @ResponseBody
    public AjaxResult getCollectInfo(@RequestParam("id") String id) {
        AjaxResult result = null;
        if (id != null) {
            Collect collect = collectService.selectCollectById(Long.valueOf(id));
            if (collect != null) {
                Long newId = collect.getNewId();
                News news = newsService.selectNewsById(Long.valueOf(newId));
                result = AjaxResult.success();
                result.put("news", news);
            }
        }
        return result;
    }

    @ApiOperation("收藏移除")
    @PostMapping("/removeCollect")
    @ResponseBody
    public AjaxResult removeCollect(@RequestParam("id") String id) {
        AjaxResult ajaxResult = null;
        int result = collectService.deleteCollectById(Long.valueOf(id));
        if (result > 0) {
            ajaxResult = success("删除成功！");
        } else {
            ajaxResult = error("删除失败！");
        }
        return ajaxResult;
    }
}
