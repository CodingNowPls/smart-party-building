package com.ruoyi.party.building.article.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.web.controller.module.article.domain.Article;
import com.ruoyi.web.controller.module.article.service.IArticleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 分享美文Controller
 *
 * @author ruoyi
 * @date 2020-05-09
 */
@Controller
@RequestMapping("/module/article")
public class ArticleController extends BaseController {
    private String prefix = "module/article";

    @Autowired
    private IArticleService articleService;
    @Autowired
    private ISysDeptService deptService;

    @RequiresPermissions("module:article:view")
    @GetMapping()
    public String article(ModelMap mmap) {
        //所有部门
        List<SysDept> deptList = deptService.selectDeptList(new SysDept());
        mmap.put("deptList", deptList);
        return prefix + "/article";
    }

    /**
     * 查询分享美文列表
     */
    @RequiresPermissions("module:article:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Article article) {
        startPage();
        List<Article> list = articleService.selectArticleList(article);
        return getDataTable(list);
    }

    /**
     * 导出分享美文列表
     */
    @RequiresPermissions("module:article:export")
    @Log(title = "分享美文", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Article article) {
        List<Article> list = articleService.selectArticleList(article);
        ExcelUtil<Article> util = new ExcelUtil<Article>(Article.class);
        return util.exportExcel(list, "article");
    }

    /**
     * 新增分享美文
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(new Date());
        mmap.put("time", time);
        return prefix + "/add";
    }

    /**
     * 新增保存分享美文
     */
    @RequiresPermissions("module:article:add")
    @Log(title = "分享美文", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Article article) {
        article.setUserId(ShiroUtils.getSysUser().getUserId());
        article.setArticleTime(DateUtils.getNowDate());
        return toAjax(articleService.insertArticle(article));
    }

    /**
     * 修改分享美文
     */
    @GetMapping("/edit/{articleId}")
    public String edit(@PathVariable("articleId") Long articleId, ModelMap mmap) {
        Article article = articleService.selectArticleById(articleId);
        mmap.put("article", article);


        if (article.getArticleVideo() != null) {
            String[] videos = article.getArticleVideo().split(",");
            mmap.put("videos", videos);
        }

        return prefix + "/edit";
    }

    /**
     * 修改保存分享美文
     */
    @RequiresPermissions("module:article:edit")
    @Log(title = "分享美文", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Article article) {
        return toAjax(articleService.updateArticle(article));
    }

    /**
     * 删除分享美文
     */
    @RequiresPermissions("module:article:remove")
    @Log(title = "分享美文", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(articleService.deleteArticleByIds(ids));
    }


    @GetMapping("/detail/{articleId}")
    public String detail(@PathVariable("articleId") Long articleId, ModelMap mmap) {
        Article article = articleService.selectArticleById(articleId);
        mmap.put("article", article);

        if (article.getArticleVideo() != null) {
            String[] videos = article.getArticleVideo().split(",");
            mmap.put("videos", videos);
        }

        return prefix + "/detail";
    }

}
