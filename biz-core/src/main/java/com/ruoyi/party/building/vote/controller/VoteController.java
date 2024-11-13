package com.ruoyi.party.building.vote.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.party.building.vote.domain.Vote;
import com.ruoyi.party.building.vote.domain.VoteRecord;
import com.ruoyi.party.building.vote.service.IVoteService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 选举任务Controller
 *
 * @author ruoyi
 * @date 2020-06-30
 */
@Controller
@RequestMapping("/vote/vote")
public class VoteController extends BaseController {
    private String prefix = "vote/vote";

    @Autowired
    private IVoteService voteService;

    /**
     * 党代表选举
     *
     * @return
     */
    @RequiresPermissions("vote:vote:view")
    @GetMapping()
    public String vote() {
        return prefix + "/vote";
    }


    /**
     * 查询选举任务列表
     */
    @RequiresPermissions("vote:vote:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Vote vote) {
        startPage();
        vote.setType("1");
        List<Vote> list = voteService.selectVoteList(vote);
        return getDataTable(list);
    }

    /**
     * 导出选举任务列表
     */
    @RequiresPermissions("vote:vote:export")
    @Log(title = "选举任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Vote vote) {
        List<Vote> list = voteService.selectVoteList(vote);
        ExcelUtil<Vote> util = new ExcelUtil<Vote>(Vote.class);
        return util.exportExcel(list, "vote");
    }

    /**
     * 新增选举任务
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存选举任务
     */
    @RequiresPermissions("vote:vote:add")
    @Log(title = "选举任务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Vote vote) {
        vote.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(voteService.insertVote(vote));
    }

    /**
     * 修改选举任务
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        Vote vote = voteService.selectVoteById(id);
        mmap.put("vote", vote);
        return prefix + "/edit";
    }

    /**
     * 修改保存选举任务
     */
    @RequiresPermissions("vote:vote:edit")
    @Log(title = "选举任务", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Vote vote) {
        vote.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(voteService.updateVote(vote));
    }

    /**
     * 删除选举任务
     */
    @RequiresPermissions("vote:vote:remove")
    @Log(title = "选举任务", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(voteService.deleteVoteByIds(ids));
    }


    /**
     * 被选举人列表
     *
     * @return
     */
    @RequiresPermissions("system:user:view")
    @GetMapping("/userByList")
    public String userByList() {
        return prefix + "/userByList";
    }

    /**
     * 选举人列表
     *
     * @return
     */
    @RequiresPermissions("system:user:view")
    @GetMapping("/userList")
    public String userList() {
        return prefix + "/userList";
    }


    @GetMapping("/detail")
    public String detail(VoteRecord record, ModelMap modelMap) {
        modelMap.put("userById", record.getVoteUserById());
        modelMap.put("voteId", record.getVoteId());
        return prefix + "/voteDetail";
    }
}
