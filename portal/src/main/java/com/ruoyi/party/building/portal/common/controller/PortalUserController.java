package com.ruoyi.party.building.portal.common.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.party.building.detail.domain.UserDetail;
import com.ruoyi.party.building.detail.service.IUserDetailService;
import com.ruoyi.system.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户接口
 *
 * @author : gao
 * @date 2024年11月13日
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
@Api("portal-用户接口")
@RestController
@RequestMapping("/api")
public class PortalUserController extends BaseController {

    @Autowired
    private ISysUserService userService;

    @Autowired
    private IUserDetailService userDetailService;

    @Autowired
    private SysPasswordService passwordService;

    @ApiOperation("组织结构下的成员")
    @GetMapping("/getUserByDeptId")
    public AjaxResult getUserByDeptId(String deptId) {
        SysUser user = new SysUser();
        user.setDeptId(Long.valueOf(deptId));
        List<SysUser> userList = userService.selectUserList(user);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("userList", userList);
        return ajaxResult;
    }

    @ApiOperation("成员详细信息")
    @GetMapping("/getUserInfo")
    public AjaxResult getUserInfo(String userId) {
        SysUser user = userService.selectUserById(Long.valueOf(userId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("user", user);
        return ajaxResult;
    }

    @ApiOperation("成员履历")
    @GetMapping("/getUserDetail")
    public AjaxResult getUserDetail(String userId) {
        UserDetail detail = new UserDetail();
        detail.setUserId(Long.valueOf(userId));
        List<UserDetail> list = userDetailService.selectUserDetailList(detail);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }


    @ApiOperation("修改密码")
    @PostMapping("resetPassword")
    public AjaxResult resetPassword(String userId, String oldPassword, String newPassword) {
        SysUser user = userService.selectUserById(Long.valueOf(userId));

        if (StringUtils.isEmpty(oldPassword)) {
            return error("请输入原密码");
        }
        if (StringUtils.isEmpty(newPassword)) {
            return error("请输入新密码");
        }
        if (newPassword.length() < 6) {
            return error("密码不能小于6个字符");
        }
        if (newPassword.length() > 20) {
            return error("密码不能大于20个字符");
        }
        if (StringUtils.isNotEmpty(newPassword) && passwordService.matches(user, oldPassword)) {
            user.setPassword(newPassword);
            if (userService.resetUserPwd(user) > 0) {
                setSysUser(userService.selectUserById(user.getUserId()));
                return success();
            }
            return error();
        } else {
            return error("旧密码错误");
        }
    }

    @ApiOperation("修改头像 只传值(userId 用户id,avatar 头像)")
    @PostMapping("editAvatar")
    public AjaxResult editAvatar(@RequestBody SysUser user) {
        int result = userService.updateUserInfo(user);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("修改成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("修改失败！");
            return ajaxResult;
        }
    }
}
