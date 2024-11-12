package com.ruoyi.web.controller.module.upload.controller;

import java.util.List;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.web.controller.module.upload.service.INewsUploadService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.web.controller.module.upload.domain.NewsUpload;
import com.ruoyi.web.controller.module.upload.service.INewsUploadService;


import com.ruoyi.common.utils.poi.ExcelUtil;


/**
 * 资讯上传Controller
 *
 * @author ruoyi
 * @date 2020-05-13
 */
@Controller
@RequestMapping("/module/upload")
public class NewsUploadController extends BaseController {
    private String prefix = "module/upload";

    @Autowired
    private INewsUploadService newsUploadService;

    @RequiresPermissions("module:upload:view")
    @GetMapping()
    public String upload() {
        return prefix + "/upload";
    }

    /**
     * 查询资讯上传列表
     */
    @RequiresPermissions("module:upload:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NewsUpload newsUpload) {
        startPage();
        List<NewsUpload> list = newsUploadService.selectNewsUploadList(newsUpload);
        return getDataTable(list);
    }

    /**
     * 导出资讯上传列表
     */
    @RequiresPermissions("module:upload:export")
    @Log(title = "资讯上传", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NewsUpload newsUpload) {
        List<NewsUpload> list = newsUploadService.selectNewsUploadList(newsUpload);
        ExcelUtil<NewsUpload> util = new ExcelUtil<NewsUpload>(NewsUpload.class);
        return util.exportExcel(list, "upload");
    }

    /**
     * 新增资讯上传
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存资讯上传
     */
    @RequiresPermissions("module:upload:add")
    @Log(title = "资讯上传", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NewsUpload newsUpload) {
        return toAjax(newsUploadService.insertNewsUpload(newsUpload));
    }

    /**
     * 修改资讯上传
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        NewsUpload newsUpload = newsUploadService.selectNewsUploadById(id);
        mmap.put("newsUpload", newsUpload);
        return prefix + "/edit";
    }

    /**
     * 修改保存资讯上传
     */
    @RequiresPermissions("module:upload:edit")
    @Log(title = "资讯上传", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NewsUpload newsUpload) {
        return toAjax(newsUploadService.updateNewsUpload(newsUpload));
    }

    /**
     * 删除资讯上传
     */
    @RequiresPermissions("module:upload:remove")
    @Log(title = "资讯上传", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(newsUploadService.deleteNewsUploadByIds(ids));
    }
}
