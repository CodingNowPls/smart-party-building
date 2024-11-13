package com.ruoyi.party.building.portal.notice.controller;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.service.ISysNoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 资讯公告接口
 *
 * @author : gao
 * @date 2024年11月13日
 * -------------------------------------------<br>
 * <br>
 * <br>
 */

@Api("portal-资讯公告接口")
@RequiresGuest
@RestController
@RequestMapping("/api")
public class PortalNoticeController {

    @Autowired
    private ISysNoticeService noticeService;

    @ApiOperation("资讯公告")
    @GetMapping("/getNoticeList")
    public AjaxResult getNoticeList() {
        SysNotice notice = new SysNotice();
        notice.setStatus("2");
        List<SysNotice> noticeList = noticeService.selectNoticeList(notice);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("noticeList", noticeList);
        return ajaxResult;
    }

    @ApiOperation("资讯公告信息")
    @GetMapping("/getNoticeInfo")
    public AjaxResult getNoticeInfo(String noticeId) {
        SysNotice notice = noticeService.selectNoticeById(Long.valueOf(noticeId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("notice", notice);
        return ajaxResult;
    }

    @ApiOperation("公告审核 (传值noticeId和status=2)")
    @PostMapping("/approvalNotice")
    public AjaxResult approvalNotice(@RequestBody SysNotice notice) {
        int result = noticeService.updateNotice(notice);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("审核成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("审核失败！");
            return ajaxResult;
        }
    }


    @ApiOperation("公告审核内容 (状态：1 待审核 2 已审核)")
    @GetMapping("/getNoticesByStatus")
    public AjaxResult getNoticesByStatus(String status) {
        SysNotice notice = new SysNotice();
        notice.setStatus(status);
        List<SysNotice> noticeList = noticeService.selectNoticeList(notice);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("noticeList", noticeList);
        return ajaxResult;
    }


}
