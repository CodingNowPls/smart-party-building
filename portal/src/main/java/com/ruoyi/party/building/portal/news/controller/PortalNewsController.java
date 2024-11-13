package com.ruoyi.party.building.portal.news.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.party.building.news.domain.News;
import com.ruoyi.party.building.news.service.INewsService;
import com.ruoyi.party.building.type.domain.NewsType;
import com.ruoyi.party.building.type.service.INewsTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资讯接口
 *
 * @author : gao
 * @date 2024年11月13日
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
@Api("portal-资讯接口")
@RequiresGuest
@RestController
@RequestMapping("/api")
public class PortalNewsController {

    @Autowired
    private INewsService newsService;
    @Autowired
    private INewsTypeService newsTypeService;


    @ApiOperation("资讯详细信息")
    @GetMapping("/getNewsInfo")
    public AjaxResult getNewsInfo(String newId) {
        News news = newsService.selectNewsById(Long.valueOf(newId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("news", news);
        return ajaxResult;
    }

    @ApiOperation("最新资讯")
    @GetMapping("/getNewsList")
    public AjaxResult getNewsList() {
        News news = new News();
        news.setStatus("2");
        news.setType("1");
        List<News> newsList = newsService.selectNewsListLimit(news);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("newsList", newsList);
        return ajaxResult;
    }

    @ApiOperation("资讯分类")
    @GetMapping("/getNewTypeList")
    public AjaxResult getNewTypeList() {
        NewsType type = new NewsType();
        type.setType("1");
        List<NewsType> typeList = newsTypeService.selectNewsTypeList(type);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("typeList", typeList);
        return ajaxResult;
    }

    @ApiOperation("资讯分类下的资讯新闻")
    @GetMapping("/getNewsByTypeId")
    public AjaxResult getNewsByTypeId(String typeId) {
        News news = new News();
        news.setNewTypeId(typeId);
        news.setStatus("2");
        news.setType("1");
        List<News> newsList = newsService.selectNewsList(news);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("newsList", newsList);
        return ajaxResult;
    }

    @ApiOperation("资讯审核 (传值 newId 和 status=2)")
    @PostMapping("/approvalNews")
    public AjaxResult approvalNews(@RequestBody News news) {
        System.out.println(news);
        int result = newsService.updateNews(news);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("审核成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("审核失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("资讯审核内容(状态：1 待审核 2 已审核)")
    @GetMapping("/getNewsByStatus")
    public AjaxResult getNewsByStatus(String status) {
        News news = new News();
        news.setStatus(status);
        List<News> newsList = newsService.selectNewsList(news);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("newsList", newsList);
        return ajaxResult;
    }

    @ApiOperation("学习分类下的新闻内容")
    @GetMapping("/getLearnByTypeId")
    public AjaxResult getLearnByTypeId(String typeId) {
        News news = new News();
        news.setNewTypeId(typeId);
        news.setStatus("2");
        news.setType("2");
        List<News> newsList = newsService.selectNewsList(news);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("newsList", newsList);
        return ajaxResult;
    }


    @ApiOperation("在线学习分类")
    @GetMapping("/getLearnTypeList")
    public AjaxResult getLearnTypeList() {
        NewsType type = new NewsType();
        type.setType("2");
        List<NewsType> typeList = newsTypeService.selectNewsTypeList(type);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("typeList", typeList);
        return ajaxResult;
    }

}
