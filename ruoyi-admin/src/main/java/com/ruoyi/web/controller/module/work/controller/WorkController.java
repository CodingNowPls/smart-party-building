package com.ruoyi.web.controller.module.work.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.controller.module.flow.domain.WorkFlow;
import com.ruoyi.web.controller.module.flow.service.IWorkFlowService;
import com.ruoyi.web.controller.module.work.domain.Work;
import com.ruoyi.web.controller.module.work.service.IWorkService;
import com.ruoyi.web.controller.module.workdist.domain.WorkDist;
import com.ruoyi.web.controller.module.workdist.service.IWorkDistService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * 任务Controller
 *
 * @author ruoyi
 * @date 2020-05-15
 */
@Controller
@RequestMapping("/module/work")
public class WorkController extends BaseController {
    private String prefix = "module/work";

    @Autowired
    private IWorkService workService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private IWorkFlowService workFlowService;
    @Autowired
    private IWorkDistService distService;

    @RequiresPermissions("module:work:view")
    @GetMapping()
    public String work(ModelMap mmap) {
        //当前登录人
        Long userId = ShiroUtils.getSysUser().getUserId();
        mmap.put("userId", userId);
        return prefix + "/work";
    }

    /**
     * 查询任务列表
     */
    @RequiresPermissions("module:work:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Work work) {
        startPage();
        List<Work> list = workService.selectWorkList(work);
        return getDataTable(list);
    }

    /**
     * 导出任务列表
     */
    @RequiresPermissions("module:work:export")
    @Log(title = "任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Work work) {
        List<Work> list = workService.selectWorkList(work);
        ExcelUtil<Work> util = new ExcelUtil<Work>(Work.class);
        return util.exportExcel(list, "work");
    }

    /**
     * 新增任务
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        //获取所有用户
        SysUser user = new SysUser();
        user.setStatus("0");
        List<SysUser> userList = userService.selectUserList(user);
        mmap.put("userList", userList);
        return prefix + "/add";
    }

    /**
     * 新增保存任务
     */
    @Transactional
    @RequiresPermissions("module:work:add")
    @Log(title = "任务", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Work work) {
        work.setUserId(ShiroUtils.getSysUser().getUserId());
        work.setUserName(ShiroUtils.getSysUser().getUserName());
        work.setUserTime(DateUtils.getNowDate());

        int result = workService.insertWork(work);
        if (result > 0) {
            if (StringUtils.isNotEmpty(work.getDistIds())) {
                List<WorkDist> list = new ArrayList<>();
                String[] distIds = work.getDistIds().split(",");
                if (distIds != null && distIds.length > 0) {
                    for (int i = 0; i < distIds.length; i++) {
                        WorkDist dist = new WorkDist();
                        dist.setDistId(Long.valueOf(distIds[i]));
                        dist.setWorkId(Long.valueOf(work.getWorkId()));
                        dist.setStatus("1");
                        list.add(dist);
                    }
                }
                distService.addDistBatch(list);
            }
        }
        return toAjax(result);
    }

    /**
     * 修改任务
     */
    @GetMapping("/edit/{workId}")
    public String edit(@PathVariable("workId") Long workId, ModelMap mmap) {
        Work work = workService.selectWorkById(workId);
        mmap.put("work", work);

        //获取所有用户
        SysUser user = new SysUser();
        user.setStatus("0");
        List<SysUser> userList = userService.selectUserList(user);
        mmap.put("userList", userList);

        return prefix + "/edit";
    }

    /**
     * 修改保存任务
     */
    @RequiresPermissions("module:work:edit")
    @Log(title = "任务", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Work work) {
        return toAjax(workService.updateWork(work));
    }

    /**
     * 删除任务
     */
    @RequiresPermissions("module:work:remove")
    @Log(title = "任务", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(workService.deleteWorkByIds(ids));
    }


    /**
     * 流程处理 执行
     */
    @GetMapping("/deal")
    public String deal(WorkDist workDist, ModelMap mmap) {
        WorkDist dist = distService.selectWorkDistById(workDist.getId());
        mmap.put("work", dist);
        return prefix + "/deal";
    }

    /**
     * 流程处理 验证
     */
    @GetMapping("/check")
    public String check(WorkDist workDist, ModelMap mmap) {
        WorkDist dist = distService.selectWorkDistById(workDist.getId());
        mmap.put("work", dist);
        return prefix + "/check";
    }

    /**
     * 详情
     */
    @GetMapping("/detail")
    public String detail(WorkDist workDist, ModelMap mmap) {
        //分配表
        WorkDist dist = distService.selectWorkDistById(workDist.getId());
        mmap.put("work", dist);

        WorkFlow flow = new WorkFlow();
        flow.setDistId(workDist.getId());
        List<WorkFlow> list = workFlowService.selectWorkFlowList(flow);
        StringBuffer buffer = new StringBuffer();
        String result = "";
        if (null != list && list.size() > 0) {
            for (WorkFlow workFlow : list) {
                String str = "";
                String actionName = workFlow.getActionName();
                String dealName = workFlow.getDealName();
                String status = workFlow.getDealStatus();
                if ("1".equals(status)) {
                    str = "执行中";
                } else if ("2".equals(status)) {
                    str = "已完成";
                } else if ("3".equals(status)) {
                    str = "不同意";
                } else if ("4".equals(status)) {
                    str = "同意";
                }

                buffer.append(actionName);
                buffer.append("(");
                buffer.append(dealName);
                buffer.append(str);
                buffer.append(")");
                buffer.append("->");
            }
            result = buffer.substring(0, buffer.length() - 2);
        }

        mmap.put("buffer", result);
        return prefix + "/detail";
    }

    @PostMapping("/detailList")
    @ResponseBody
    public List<WorkFlow> detailList(WorkFlow workFlow) {
        List<WorkFlow> list = workFlowService.selectWorkFlowList(workFlow);
        return list;
    }

    /**
     * 我创建任务
     *
     * @param
     * @return
     */
    @RequiresPermissions("module:work:view")
    @GetMapping("/myWork")
    public String myWork(ModelMap mmap) {
        //当前登录人
        Long userId = ShiroUtils.getSysUser().getUserId();
        mmap.put("userId", userId);
        return prefix + "/myWork";
    }


    /**
     * 我创建任务
     *
     * @param
     * @return
     */
    @RequiresPermissions("module:work:list")
    @PostMapping("/myList")
    @ResponseBody
    public TableDataInfo myList(Work work) {
        startPage();
        Long userId = ShiroUtils.getSysUser().getUserId();
        work.setUserId(userId);
        List<Work> list = workService.selectWorkList(work);
        return getDataTable(list);
    }

    /**
     * 分配给我的任务
     *
     * @param
     * @return
     */
    @RequiresPermissions("module:work:view")
    @GetMapping("/toWork")
    public String toWork(ModelMap mmap) {
        //当前登录人
        Long userId = ShiroUtils.getSysUser().getUserId();
        mmap.put("userId", userId);
        return prefix + "/toMeWork";
    }


    /**
     * 分配给我任务
     *
     * @param workDist
     * @return
     */
    @RequiresPermissions("module:work:list")
    @PostMapping("/toMeList")
    @ResponseBody
    public TableDataInfo toMeList(WorkDist workDist) {
        startPage();
        workDist.setDistId(ShiroUtils.getSysUser().getUserId());
        List<WorkDist> list = distService.selectWorkDistListAndStatus(workDist);
        return getDataTable(list);
    }


}
