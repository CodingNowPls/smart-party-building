package com.ruoyi.party.building.pageruser.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.module.pageruser.domain.PagerUser;
import com.ruoyi.web.controller.module.pageruser.service.IPagerUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import java.util.List;


/**
 * 考试对象Controller
 *
 * @author ruoyi
 * @date 2020-06-19
 */
@Controller
@RequestMapping("/module/pageruser")
public class PagerUserController extends BaseController {
    private String prefix = "module/pageruser";

    @Autowired
    private IPagerUserService pagerUserService;

    @RequiresPermissions("module:pageruser:view")
    @GetMapping()
    public String pageruser() {
        return prefix + "/pageruser";
    }

    /**
     * 查询考试对象列表
     */
    @RequiresPermissions("module:pageruser:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PagerUser pagerUser) {
        startPage();
        List<PagerUser> list = pagerUserService.selectPagerUserList(pagerUser);
        return getDataTable(list);
    }

    /**
     * 导出考试对象列表
     */
    @RequiresPermissions("module:pageruser:export")
    @Log(title = "考试对象", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PagerUser pagerUser) {
        List<PagerUser> list = pagerUserService.selectPagerUserList(pagerUser);
        ExcelUtil<PagerUser> util = new ExcelUtil<PagerUser>(PagerUser.class);
        return util.exportExcel(list, "pageruser");
    }

    /**
     * 新增考试对象
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存考试对象
     */
    @RequiresPermissions("module:pageruser:add")
    @Log(title = "考试对象", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PagerUser pagerUser) {
        return toAjax(pagerUserService.insertPagerUser(pagerUser));
    }

    /**
     * 修改考试对象
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        PagerUser pagerUser = pagerUserService.selectPagerUserById(id);
        mmap.put("pagerUser", pagerUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存考试对象
     */
    @RequiresPermissions("module:pageruser:edit")
    @Log(title = "考试对象", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PagerUser pagerUser) {
        return toAjax(pagerUserService.updatePagerUser(pagerUser));
    }

    /**
     * 删除考试对象
     */
    @RequiresPermissions("module:pageruser:remove")
    @Log(title = "考试对象", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(pagerUserService.deletePagerUserByIds(ids));
    }

    /**
     * 确认分数
     */
    @PostMapping("/confirm")
    @ResponseBody
    public AjaxResult confirm(PagerUser pagerUser) {
        int result = 0;
        List<PagerUser> pagerUserList = pagerUserService.selectPagerUserList(pagerUser);
        if (pagerUserList != null && pagerUserList.size() > 0) {
            Long id = pagerUserList.get(0).getId();
            pagerUser.setId(id);
            pagerUser.setConfirm("1");
            result = pagerUserService.updatePagerUser(pagerUser);
        }
        return toAjax(result);
    }
}
