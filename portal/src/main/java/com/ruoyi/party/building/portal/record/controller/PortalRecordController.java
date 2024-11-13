package com.ruoyi.party.building.portal.record.controller;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.party.building.record.domain.Record;
import com.ruoyi.party.building.record.service.IRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会议记录  接口
 *
 * @author : gao
 * @date 2024年11月13日
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
@Api("portal-会议记录接口")
@RequiresGuest
@RestController
@RequestMapping("/api")
public class PortalRecordController {


    @Autowired
    private IRecordService recordService;


    @ApiOperation("会议记录添加")
    @PostMapping("/addRecord")
    public AjaxResult addRecord(@RequestBody Record record) {
        int result = recordService.insertRecord(record);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("提交成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("提交失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("会议记录编辑")
    @PostMapping("/editRecord")
    public AjaxResult editRecord(@RequestBody Record record) {
        int result = recordService.updateRecord(record);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("编辑成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("编辑失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("会议记录列表")
    @GetMapping("/getRecordList")
    public AjaxResult getRecordList(String deptId) {
        Record record = new Record();
        record.setDeptId(Long.valueOf(deptId));
        List<Record> list = recordService.selectRecordList(record);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("会议记录详情")
    @GetMapping("/getRecordInfo")
    public AjaxResult getRecordInfo(String recordId) {
        Record record = recordService.selectRecordById(Long.valueOf(recordId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("record", record);
        return ajaxResult;
    }

}
