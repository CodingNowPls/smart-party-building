package com.ruoyi.web.controller.vote.userby.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.vote.userby.domain.VoteUserBy;
import com.ruoyi.web.controller.vote.userby.service.IVoteUserByService;
import com.ruoyi.web.controller.vote.voterecord.domain.VoteRecord;
import com.ruoyi.web.controller.vote.voterecord.service.IVoteRecordService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 被选举人Controller
 *
 * @author ruoyi
 * @date 2020-07-01
 */
@Controller
@RequestMapping("/vote/userby")
public class VoteUserByController extends BaseController {
    private String prefix = "vote/userby";

    @Autowired
    private IVoteUserByService voteUserByService;
    @Autowired
    private IVoteRecordService voteRecordService;

    @RequiresPermissions("vote:userby:view")
    @GetMapping()
    public String userby() {
        return prefix + "/userby";
    }

    /**
     * 查询被选举人列表
     */
    @RequiresPermissions("vote:userby:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VoteUserBy voteUserBy) {
        startPage();
        List<VoteUserBy> list = voteUserByService.selectVoteUserByList(voteUserBy);
        if (list != null && list.size() > 0) {
            for (VoteUserBy userBy : list) {
                VoteRecord record = new VoteRecord();
                record.setVoteId(userBy.getVoteId());
                record.setVoteUserById(userBy.getId());
                int totalCount = voteRecordService.getTotalCount(record);
                userBy.setVoteCount((long) totalCount); //总票数
            }
        }
        return getDataTable(list);
    }

    /**
     * 导出被选举人列表
     */
    @RequiresPermissions("vote:userby:export")
    @Log(title = "被选举人", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VoteUserBy voteUserBy) {
        List<VoteUserBy> list = voteUserByService.selectVoteUserByList(voteUserBy);
        ExcelUtil<VoteUserBy> util = new ExcelUtil<VoteUserBy>(VoteUserBy.class);
        return util.exportExcel(list, "userby");
    }

    /**
     * 新增被选举人
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存被选举人
     */
    @RequiresPermissions("vote:userby:add")
    @Log(title = "被选举人", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VoteUserBy voteUserBy) {
        return toAjax(voteUserByService.insertVoteUserBy(voteUserBy));
    }

    /**
     * 修改被选举人
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        VoteUserBy voteUserBy = voteUserByService.selectVoteUserByById(id);
        mmap.put("voteUserBy", voteUserBy);
        return prefix + "/edit";
    }

    /**
     * 修改保存被选举人
     */
    @RequiresPermissions("vote:userby:edit")
    @Log(title = "被选举人", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VoteUserBy voteUserBy) {
        return toAjax(voteUserByService.updateVoteUserBy(voteUserBy));
    }

    /**
     * 删除被选举人
     */
    @RequiresPermissions("vote:userby:remove")
    @Log(title = "被选举人", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(voteUserByService.deleteVoteUserByByIds(ids));
    }
}
