package com.ruoyi.party.building.portal.common.controller;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api("PC端接口")
@Anonymous
@RestController
@RequestMapping("/portal")
public class PortalCommonController extends BaseController {
    @Autowired
    private ServerConfig serverConfig;


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




}
