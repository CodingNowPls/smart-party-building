package com.ruoyi.party.building.portal.article.controller;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.party.building.article.domain.Article;
import com.ruoyi.party.building.article.service.IArticleService;
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
@RestController
@RequestMapping("/api")
public class PortalArticleController {


    @Autowired
    private IArticleService articleService;


    @ApiOperation("分享美文添加")
    @PostMapping("/addArticle")
    public AjaxResult addArticle(@RequestBody Article article) {
        int result = articleService.insertArticle(article);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("提交成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("提交失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("分享美文编辑")
    @PostMapping("/editArticle")
    public AjaxResult editArticle(@RequestBody Article article) {
        int result = articleService.updateArticle(article);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("编辑成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("编辑失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("分享美文列表")
    @GetMapping("/getArticleList")
    public AjaxResult getArticleList(String deptId) {
        Article article = new Article();
        article.setDeptId(Long.valueOf(deptId));
        List<Article> list = articleService.selectArticleList(article);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("分享美文详情")
    @GetMapping("/getArticleInfo")
    public AjaxResult getArticleInfo(String articleId) {
        Article article = articleService.selectArticleById(Long.valueOf(articleId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("article", article);
        return ajaxResult;
    }

}
