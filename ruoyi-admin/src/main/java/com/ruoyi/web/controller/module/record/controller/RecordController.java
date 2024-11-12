package com.ruoyi.web.controller.module.record.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;


import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.web.controller.module.record.service.IRecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ruoyi.web.controller.module.record.domain.Record;


import com.ruoyi.common.utils.poi.ExcelUtil;


/**
 * 会议记录Controller
 *
 * @author ruoyi
 * @date 2020-05-09
 */
@Controller
@RequestMapping("/module/record")
public class RecordController extends BaseController {
    private String prefix = "module/record";

    @Autowired
    private IRecordService recordService;
    @Autowired
    private ISysDeptService deptService;

    @RequiresPermissions("module:record:view")
    @GetMapping()
    public String record(ModelMap mmap) {
        //所有部门
        List<SysDept> deptList = deptService.selectDeptList(new SysDept());
        mmap.put("deptList", deptList);
        return prefix + "/record";
    }

    /**
     * 查询会议记录列表
     */
    @RequiresPermissions("module:record:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Record record) {
        startPage();
        List<Record> list = recordService.selectRecordList(record);
        return getDataTable(list);
    }

    /**
     * 导出会议记录列表
     */
    @RequiresPermissions("module:record:export")
    @Log(title = "会议记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Record record) {
        List<Record> list = recordService.selectRecordList(record);
        ExcelUtil<Record> util = new ExcelUtil<Record>(Record.class);
        return util.exportExcel(list, "record");
    }

    /**
     * 新增会议记录
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(new Date());
        mmap.put("recordTime", time);
        return prefix + "/add";
    }

    /**
     * 新增保存会议记录
     */
    @RequiresPermissions("module:record:add")
    @Log(title = "会议记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Record record) {
        record.setUserId(ShiroUtils.getSysUser().getUserId());
        record.setRecordTime(DateUtils.getNowDate());
        return toAjax(recordService.insertRecord(record));
    }

    /**
     * 修改会议记录
     */
    @GetMapping("/edit/{recordId}")
    public String edit(@PathVariable("recordId") Long recordId, ModelMap mmap) {
        Record record = recordService.selectRecordById(recordId);
        mmap.put("record", record);

        if (record.getRecordVideo() != null) {
            String[] videos = record.getRecordVideo().split(",");
            mmap.put("videos", videos);
        }

        return prefix + "/edit";
    }

    /**
     * 修改保存会议记录
     */
    @RequiresPermissions("module:record:edit")
    @Log(title = "会议记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Record record) {
        return toAjax(recordService.updateRecord(record));
    }

    /**
     * 删除会议记录
     */
    @RequiresPermissions("module:record:remove")
    @Log(title = "会议记录", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(recordService.deleteRecordByIds(ids));
    }


    /**
     * 详情
     *
     * @param recordId
     * @param mmap
     * @return
     */
    @GetMapping("/detail/{recordId}")
    public String detail(@PathVariable("recordId") Long recordId, ModelMap mmap) {
        Record record = recordService.selectRecordById(recordId);
        mmap.put("record", record);

        if (record.getRecordVideo() != null) {
            String[] videos = record.getRecordVideo().split(",");
            mmap.put("videos", videos);
        }

        return prefix + "/detail";
    }
}
