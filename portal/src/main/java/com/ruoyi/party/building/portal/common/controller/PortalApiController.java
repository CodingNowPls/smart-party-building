package com.ruoyi.party.building.portal.common.controller;


import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Api("PC端接口")
@Anonymous
@RestController
@RequestMapping("/portal")
public class PortalApiController extends BaseController {
    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private ISysUserService userService;

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


    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public AjaxResult upload(MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                // 上传文件路径
                String filePath = RuoYiConfig.getUploadPath();
                // 上传并返回新文件名称
                String fileName = FileUploadUtils.upload(filePath, file);
                String fileUrl = serverConfig.getUrl() + fileName;
                if (StringUtils.isNotEmpty(fileUrl)) {
                    AjaxResult ajax = AjaxResult.success();
                    ajax.put("src", fileUrl);
                    return ajax;
                } else {
                    AjaxResult ajax = AjaxResult.error("上传失败");
                    return ajax;
                }
            } else {
                AjaxResult ajax = AjaxResult.error("上传失败");
                return ajax;
            }
        } catch (Exception e) {
            AjaxResult ajax = AjaxResult.error("上传失败");
            return ajax;
        }
    }


    @ResponseBody
    @ApiOperation("版本更新")
    @PostMapping("/checkUpdate")
    public AjaxResult checkUpdate(int version) {
        AjaxResult result = null;
        int appVersion = 201;
        if (appVersion == version) {
            result = AjaxResult.success("当前已是最新版本");
            result.put("isUpdate", false);
        } else if (appVersion > version) {
            //版本升级
            result = AjaxResult.success();
            result.put("isUpdate", true);
            result.put("content", "更新版本");
            result.put("openUrl", "https://www.pgyer.com/KFgQ");
        }
        return result;
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
                info.setChildren(getChilde(info.getId(), rootList));
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
    private List<DeptInfo> getChilde(Long id, List<DeptInfo> rootList) {
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
            deptInfo.setChildren(getChilde(deptInfo.getId(), rootList));
        }
        // 递归退出条件
        if (childList.size() == 0) {
            return null;
        }
        return childList;
    }


}
