package com.ruoyi.web.controller.module.picture.controller;

import java.util.List;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.web.controller.module.picture.domain.Picture;
import com.ruoyi.web.controller.module.picture.service.IPictureService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.web.controller.module.picture.domain.Picture;
import com.ruoyi.web.controller.module.picture.service.IPictureService;


import com.ruoyi.common.utils.poi.ExcelUtil;


/**
 * 首页轮播图Controller
 *
 * @author ruoyi
 * @date 2020-05-25
 */
@Controller
@RequestMapping("/module/picture")
public class PictureController extends BaseController {
    private String prefix = "module/picture";

    @Autowired
    private IPictureService pictureService;

    @RequiresPermissions("module:picture:view")
    @GetMapping()
    public String picture() {
        return prefix + "/picture";
    }

    /**
     * 查询首页轮播图列表
     */
    @RequiresPermissions("module:picture:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Picture picture) {
        startPage();
        List<Picture> list = pictureService.selectPictureList(picture);
        return getDataTable(list);
    }

    /**
     * 导出首页轮播图列表
     */
    @RequiresPermissions("module:picture:export")
    @Log(title = "首页轮播图", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Picture picture) {
        List<Picture> list = pictureService.selectPictureList(picture);
        ExcelUtil<Picture> util = new ExcelUtil<Picture>(Picture.class);
        return util.exportExcel(list, "picture");
    }

    /**
     * 新增首页轮播图
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存首页轮播图
     */
    @RequiresPermissions("module:picture:add")
    @Log(title = "首页轮播图", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Picture picture) {
        return toAjax(pictureService.insertPicture(picture));
    }

    /**
     * 修改首页轮播图
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Picture picture = pictureService.selectPictureById(id);
        mmap.put("picture", picture);
        return prefix + "/edit";
    }

    /**
     * 修改保存首页轮播图
     */
    @RequiresPermissions("module:picture:edit")
    @Log(title = "首页轮播图", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Picture picture) {
        return toAjax(pictureService.updatePicture(picture));
    }

    /**
     * 删除首页轮播图
     */
    @RequiresPermissions("module:picture:remove")
    @Log(title = "首页轮播图", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(pictureService.deletePictureByIds(ids));
    }
}
