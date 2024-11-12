package com.ruoyi.party.building.tale.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.party.building.tale.domain.Tale;
import com.ruoyi.party.building.tale.service.ITaleService;
import com.ruoyi.system.service.ISysDeptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 小组故事Controller
 *
 * @author ruoyi
 * @date 2020-05-09
 */
@Controller
@RequestMapping("/module/tale")
public class TaleController extends BaseController {
    private String prefix = "module/tale";

    @Autowired
    private ITaleService taleService;
    @Autowired
    private ISysDeptService deptService;

    @RequiresPermissions("module:tale:view")
    @GetMapping()
    public String tale(ModelMap mmap) {
        //所有部门
        List<SysDept> deptList = deptService.selectDeptList(new SysDept());
        mmap.put("deptList", deptList);
        return prefix + "/tale";
    }

    /**
     * 查询小组故事列表
     */
    @RequiresPermissions("module:tale:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Tale tale) {
        startPage();
        List<Tale> list = taleService.selectTaleList(tale);
        return getDataTable(list);
    }

    /**
     * 导出小组故事列表
     */
    @RequiresPermissions("module:tale:export")
    @Log(title = "小组故事", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Tale tale) {
        List<Tale> list = taleService.selectTaleList(tale);
        ExcelUtil<Tale> util = new ExcelUtil<Tale>(Tale.class);
        return util.exportExcel(list, "tale");
    }

    /**
     * 新增小组故事
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(new Date());
        mmap.put("time", time);
        return prefix + "/add";
    }

    /**
     * 新增保存小组故事
     */
    @RequiresPermissions("module:tale:add")
    @Log(title = "小组故事", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Tale tale) {
        tale.setUserId(ShiroUtils.getSysUser().getUserId());
        tale.setTaleTime(DateUtils.getNowDate());
        return toAjax(taleService.insertTale(tale));
    }

    /**
     * 修改小组故事
     */
    @GetMapping("/edit/{taleId}")
    public String edit(@PathVariable("taleId") Long taleId, ModelMap mmap) {
        Tale tale = taleService.selectTaleById(taleId);
        mmap.put("tale", tale);

        if (tale.getTaleVideo() != null) {
            String[] videos = tale.getTaleVideo().split(",");
            mmap.put("videos", videos);
        }

        return prefix + "/edit";
    }

    /**
     * 修改保存小组故事
     */
    @RequiresPermissions("module:tale:edit")
    @Log(title = "小组故事", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Tale tale) {
        return toAjax(taleService.updateTale(tale));
    }

    /**
     * 删除小组故事
     */
    @RequiresPermissions("module:tale:remove")
    @Log(title = "小组故事", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(taleService.deleteTaleByIds(ids));
    }


    @GetMapping("/detail/{taleId}")
    public String detail(@PathVariable("taleId") Long taleId, ModelMap mmap) {
        Tale tale = taleService.selectTaleById(taleId);
        mmap.put("tale", tale);

        if (tale.getTaleVideo() != null) {
            String[] videos = tale.getTaleVideo().split(",");
            mmap.put("videos", videos);
        }
        return prefix + "/detail";
    }
}
