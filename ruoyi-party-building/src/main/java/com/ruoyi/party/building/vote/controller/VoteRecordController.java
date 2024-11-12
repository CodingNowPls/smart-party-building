package com.ruoyi.party.building.vote.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.party.building.vote.domain.VoteRecord;
import com.ruoyi.party.building.vote.service.IVoteRecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 投票记录Controller
 *
 * @author ruoyi
 * @date 2020-07-01
 */
@Controller
@RequestMapping("/vote/voterecord")
public class VoteRecordController extends BaseController {
    private String prefix = "vote/voterecord";

    @Autowired
    private IVoteRecordService voteRecordService;

    @RequiresPermissions("vote:voterecord:view")
    @GetMapping()
    public String voterecord() {
        return prefix + "/voterecord";
    }

    /**
     * 查询投票记录列表
     */
    @RequiresPermissions("vote:voterecord:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VoteRecord voteRecord) {
        startPage();
        List<VoteRecord> list = voteRecordService.selectVoteRecordList(voteRecord);
        return getDataTable(list);
    }

    /**
     * 导出投票记录列表
     */
    @RequiresPermissions("vote:voterecord:export")
    @Log(title = "投票记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VoteRecord voteRecord) {
        List<VoteRecord> list = voteRecordService.selectVoteRecordList(voteRecord);
        ExcelUtil<VoteRecord> util = new ExcelUtil<VoteRecord>(VoteRecord.class);
        return util.exportExcel(list, "voterecord");
    }

    /**
     * 新增投票记录
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存投票记录
     */
    @RequiresPermissions("vote:voterecord:add")
    @Log(title = "投票记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VoteRecord voteRecord) {
        return toAjax(voteRecordService.insertVoteRecord(voteRecord));
    }

    /**
     * 修改投票记录
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        VoteRecord voteRecord = voteRecordService.selectVoteRecordById(id);
        mmap.put("voteRecord", voteRecord);
        return prefix + "/edit";
    }

    /**
     * 修改保存投票记录
     */
    @RequiresPermissions("vote:voterecord:edit")
    @Log(title = "投票记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VoteRecord voteRecord) {
        return toAjax(voteRecordService.updateVoteRecord(voteRecord));
    }

    /**
     * 删除投票记录
     */
    @RequiresPermissions("vote:voterecord:remove")
    @Log(title = "投票记录", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(voteRecordService.deleteVoteRecordByIds(ids));
    }
}
