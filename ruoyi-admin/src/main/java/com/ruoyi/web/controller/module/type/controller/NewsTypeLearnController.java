package com.ruoyi.web.controller.module.type.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.module.type.domain.NewsType;
import com.ruoyi.web.controller.module.type.service.INewsTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资讯分类Controller
 *
 * @author ruoyi
 * @date 2020-05-06
 */
@Controller
@RequestMapping("/module/typeLearn")
public class NewsTypeLearnController extends BaseController {
    private String prefix = "module/typeLearn";

    @Autowired
    private INewsTypeService newsTypeService;

    @RequiresPermissions("module:type:view")
    @GetMapping()
    public String type() {
        return prefix + "/type";
    }

    /**
     * 查询资讯分类列表
     */
    @RequiresPermissions("module:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(NewsType newsType) {
        startPage();
        List<NewsType> list = newsTypeService.selectNewsTypeList(newsType);
        return getDataTable(list);
    }

    /**
     * 导出资讯分类列表
     */
    @RequiresPermissions("module:type:export")
    @Log(title = "资讯分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(NewsType newsType) {
        List<NewsType> list = newsTypeService.selectNewsTypeList(newsType);
        ExcelUtil<NewsType> util = new ExcelUtil<NewsType>(NewsType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增资讯分类
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存资讯分类
     */
    @RequiresPermissions("module:type:add")
    @Log(title = "资讯分类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(NewsType newsType) {
        return toAjax(newsTypeService.insertNewsType(newsType));
    }

    /**
     * 修改资讯分类
     */
    @GetMapping("/edit/{typeId}")
    public String edit(@PathVariable("typeId") Long typeId, ModelMap mmap) {
        NewsType newsType = newsTypeService.selectNewsTypeById(typeId);
        mmap.put("newsType", newsType);
        return prefix + "/edit";
    }

    /**
     * 修改保存资讯分类
     */
    @RequiresPermissions("module:type:edit")
    @Log(title = "资讯分类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(NewsType newsType) {
        return toAjax(newsTypeService.updateNewsType(newsType));
    }

    /**
     * 删除资讯分类
     */
    @RequiresPermissions("module:type:remove")
    @Log(title = "资讯分类", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(newsTypeService.deleteNewsTypeByIds(ids));
    }
}
