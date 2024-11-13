package com.ruoyi.party.building.portal.common.controller;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.party.building.detail.domain.UserDetail;
import com.ruoyi.party.building.detail.service.IUserDetailService;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
@Anonymous
@RestController
@RequestMapping("/portal")
public class PortalUserController extends BaseController {

    @Autowired
    private ISysUserService userService;

    @Autowired
    private IUserDetailService userDetailService;

    @Autowired
    private SysPasswordService passwordService;

    @Autowired
    private ISysDeptService deptService;

    @ApiOperation("登录")
    @PostMapping("/login")
    @ResponseBody
    public AjaxResult login(@RequestParam("loginName") String loginName, @RequestParam("password") String password) {
        if (StringUtils.isEmpty(loginName)) {
            return error("用户名不能为空！");
        } else if (StringUtils.isEmpty(password)) {
            return error("密码不能为空!");
        } else {
            UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
            Subject subject = SecurityUtils.getSubject();
            try {
                subject.login(token);
                SysUser user = userService.selectUserByLoginName(loginName);
                AjaxResult ajaxResult = AjaxResult.success();
                ajaxResult.put("user", user);
                return ajaxResult;
            } catch (AuthenticationException e) {
                System.out.println(e.getMessage());
                String msg = "用户名或密码错误";
                if (StringUtils.isNotEmpty(e.getMessage())) {
                    msg = e.getMessage();
                }
                return success(msg);
            }
        }
    }

    @ApiOperation("组织结构")
    @GetMapping("/getDeptList")
    public AjaxResult getDeptList() {
        SysDept dept = new SysDept();
        dept.setStatus("0");
        List<SysDept> deptList = deptService.selectDeptListNoParent(dept);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("deptList", deptList);
        return ajaxResult;
    }

    @ApiOperation("判断是否是审核人")
    @PostMapping("/isReviewer")
    public AjaxResult isReviewer(@RequestParam("userId") String userId) {
        AjaxResult ajaxResult = AjaxResult.success();
        if (StringUtils.isNotEmpty(userId)) {
            //判断是否是审核人
            if ("1".equals(userId)) {
                ajaxResult.put("isReviewer", true);
            } else {
                ajaxResult.put("isReviewer", false);
            }
        }
        return ajaxResult;
    }

    @ApiOperation("组织结构图")
    @PostMapping("/getDeptPicture")
    @ResponseBody
    public AjaxResult getDeptPicture() {
        List<DeptInfo> infoList = new ArrayList<>();
        SysDept dept = new SysDept();
        dept.setStatus("0");
        //获取所有数据
        List<SysDept> allList = deptService.selectDeptList(dept);
        List<DeptInfo> rootList = new ArrayList<>();
        if (allList != null && allList.size() > 0) {
            for (SysDept dept1 : allList) {
                DeptInfo d = new DeptInfo();
                d.setId(dept1.getDeptId());
                d.setName(dept1.getDeptName());
                d.setParentId(dept1.getParentId());
                rootList.add(d);

                //一级分类parentId是0
                if (dept1.getParentId() == 0) {
                    DeptInfo info = new DeptInfo();
                    info.setId(dept1.getDeptId());
                    info.setName(dept1.getDeptName());
                    info.setParentId(dept1.getParentId());
                    infoList.add(info);
                }
            }
            // 为一级菜单设置子菜单，getChild是递归调用的
            for (DeptInfo info : infoList) {
                info.setChildren(getChild(info.getId(), rootList));
            }
        }

        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("data", infoList);
        return ajaxResult;
    }


    /**
     * 递归查找子菜单
     *
     * @param id       当前菜单id
     * @param rootList 要查找的列表
     * @return
     */
    private List<DeptInfo> getChild(Long id, List<DeptInfo> rootList) {
        //子菜单
        List<DeptInfo> childList = new ArrayList<>();
        for (DeptInfo deptInfo : rootList) {
            // 遍历所有节点，将父菜单id与传过来的id比较
            if (deptInfo.getParentId().equals(id)) {
                childList.add(deptInfo);
            }
        }

        // 把子菜单的子菜单再循环一遍
        for (DeptInfo deptInfo : childList) {
            deptInfo.setChildren(getChild(deptInfo.getId(), rootList));
        }
        // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }
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
