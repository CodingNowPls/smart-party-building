package com.ruoyi.party.building.vote.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.party.building.vote.domain.VoteUser;
import com.ruoyi.party.building.vote.service.IVoteUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 选举人Controller
 *
 * @author ruoyi
 * @date 2020-07-01
 */
@Controller
@RequestMapping("/vote/voteuser")
public class VoteUserController extends BaseController {
    private String prefix = "vote/voteuser";

    @Autowired
    private IVoteUserService voteUserService;

    @RequiresPermissions("vote:voteuser:view")
    @GetMapping()
    public String voteuser() {
        return prefix + "/voteuser";
    }

    /**
     * 查询选举人列表
     */
    @RequiresPermissions("vote:voteuser:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(VoteUser voteUser) {
        startPage();
        List<VoteUser> list = voteUserService.selectVoteUserList(voteUser);
        return getDataTable(list);
    }

    /**
     * 导出选举人列表
     */
    @RequiresPermissions("vote:voteuser:export")
    @Log(title = "选举人", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(VoteUser voteUser) {
        List<VoteUser> list = voteUserService.selectVoteUserList(voteUser);
        ExcelUtil<VoteUser> util = new ExcelUtil<VoteUser>(VoteUser.class);
        return util.exportExcel(list, "voteuser");
    }

    /**
     * 新增选举人
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存选举人
     */
    @RequiresPermissions("vote:voteuser:add")
    @Log(title = "选举人", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(VoteUser voteUser) {
        return toAjax(voteUserService.insertVoteUser(voteUser));
    }

    /**
     * 修改选举人
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        VoteUser voteUser = voteUserService.selectVoteUserById(id);
        mmap.put("voteUser", voteUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存选举人
     */
    @RequiresPermissions("vote:voteuser:edit")
    @Log(title = "选举人", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(VoteUser voteUser) {
        return toAjax(voteUserService.updateVoteUser(voteUser));
    }

    /**
     * 删除选举人
     */
    @RequiresPermissions("vote:voteuser:remove")
    @Log(title = "选举人", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(voteUserService.deleteVoteUserByIds(ids));
    }
}
