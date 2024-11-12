package com.ruoyi.web.controller.module.detail.controller;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.controller.module.detail.domain.UserDetail;
import com.ruoyi.web.controller.module.detail.service.IUserDetailService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 个人履历Controller
 *
 * @author ruoyi
 * @date 2020-05-14
 */
@Controller
@RequestMapping("/system/detail")
public class UserDetailController extends BaseController {
    private String prefix = "system/detail";

    @Autowired
    private IUserDetailService userDetailService;
    @Autowired
    private ISysUserService userService;

    @RequiresPermissions("system:detail:view")
    @GetMapping()
    public String detail(UserDetail detail, ModelMap mmap) {
        mmap.put("userId", detail.getUserId());
        return prefix + "/detail";
    }

    /**
     * 查询个人履历列表
     */
    @RequiresPermissions("system:detail:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserDetail userDetail) {
        startPage();
        List<UserDetail> list = userDetailService.selectUserDetailList(userDetail);
        return getDataTable(list);
    }

    /**
     * 导出个人履历列表
     */
    @RequiresPermissions("system:detail:export")
    @Log(title = "个人履历", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserDetail userDetail) {
        List<UserDetail> list = userDetailService.selectUserDetailList(userDetail);
        ExcelUtil<UserDetail> util = new ExcelUtil<UserDetail>(UserDetail.class);
        return util.exportExcel(list, "detail");
    }

    /**
     * 新增个人履历
     */
    @GetMapping("/add")
    public String add(Long userId, ModelMap mmap) {
        SysUser user = userService.selectUserById(userId);
        mmap.put("userId", userId);
        mmap.put("userName", user.getUserName());
        return prefix + "/add";
    }

    /**
     * 新增保存个人履历
     */
    @RequiresPermissions("system:detail:add")
    @Log(title = "个人履历", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserDetail userDetail) {
        return toAjax(userDetailService.insertUserDetail(userDetail));
    }

    /**
     * 修改个人履历
     */
    @GetMapping("/edit/{detailId}")
    public String edit(@PathVariable("detailId") Long detailId, ModelMap mmap) {
        UserDetail userDetail = userDetailService.selectUserDetailById(detailId);
        mmap.put("userDetail", userDetail);
        return prefix + "/edit";
    }

    /**
     * 修改保存个人履历
     */
    @RequiresPermissions("system:detail:edit")
    @Log(title = "个人履历", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserDetail userDetail) {
        return toAjax(userDetailService.updateUserDetail(userDetail));
    }

    /**
     * 删除个人履历
     */
    @RequiresPermissions("system:detail:remove")
    @Log(title = "个人履历", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(userDetailService.deleteUserDetailByIds(ids));
    }
}
