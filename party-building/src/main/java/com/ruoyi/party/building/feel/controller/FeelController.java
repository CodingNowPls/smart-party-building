package com.ruoyi.party.building.feel.controller;

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
import com.ruoyi.web.controller.module.feel.domain.Feel;
import com.ruoyi.web.controller.module.feel.service.IFeelService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 心得体会Controller
 *
 * @author ruoyi
 * @date 2020-05-09
 */
@Controller
@RequestMapping("/module/feel")
public class FeelController extends BaseController {
    private String prefix = "module/feel";

    @Autowired
    private IFeelService feelService;
    @Autowired
    private ISysDeptService deptService;

    @RequiresPermissions("module:feel:view")
    @GetMapping()
    public String feel(ModelMap mmap) {
        //所有部门
        List<SysDept> deptList = deptService.selectDeptList(new SysDept());
        mmap.put("deptList", deptList);
        return prefix + "/feel";
    }

    /**
     * 查询心得体会列表
     */
    @RequiresPermissions("module:feel:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Feel feel) {
        startPage();
        List<Feel> list = feelService.selectFeelList(feel);
        return getDataTable(list);
    }

    /**
     * 导出心得体会列表
     */
    @RequiresPermissions("module:feel:export")
    @Log(title = "心得体会", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Feel feel) {
        List<Feel> list = feelService.selectFeelList(feel);
        ExcelUtil<Feel> util = new ExcelUtil<Feel>(Feel.class);
        return util.exportExcel(list, "feel");
    }

    /**
     * 新增心得体会
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(new Date());
        mmap.put("time", time);
        return prefix + "/add";
    }

    /**
     * 新增保存心得体会
     */
    @RequiresPermissions("module:feel:add")
    @Log(title = "心得体会", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Feel feel) {
        feel.setUserId(ShiroUtils.getSysUser().getUserId());
        feel.setFeelTime(DateUtils.getNowDate());
        return toAjax(feelService.insertFeel(feel));
    }

    /**
     * 修改心得体会
     */
    @GetMapping("/edit/{feelId}")
    public String edit(@PathVariable("feelId") Long feelId, ModelMap mmap) {
        Feel feel = feelService.selectFeelById(feelId);
        mmap.put("feel", feel);

        if (feel.getFeelVideo() != null) {
            String[] videos = feel.getFeelVideo().split(",");
            mmap.put("videos", videos);
        }

        return prefix + "/edit";
    }

    /**
     * 修改保存心得体会
     */
    @RequiresPermissions("module:feel:edit")
    @Log(title = "心得体会", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Feel feel) {
        return toAjax(feelService.updateFeel(feel));
    }

    /**
     * 删除心得体会
     */
    @RequiresPermissions("module:feel:remove")
    @Log(title = "心得体会", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(feelService.deleteFeelByIds(ids));
    }


    @GetMapping("/detail/{feelId}")
    public String detail(@PathVariable("feelId") Long feelId, ModelMap mmap) {
        Feel feel = feelService.selectFeelById(feelId);
        mmap.put("feel", feel);

        if (feel.getFeelVideo() != null) {
            String[] videos = feel.getFeelVideo().split(",");
            mmap.put("videos", videos);
        }

        return prefix + "/detail";
    }
}
