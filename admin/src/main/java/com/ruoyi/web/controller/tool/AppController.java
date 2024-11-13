package com.ruoyi.web.controller.tool;


import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.party.building.collect.service.ICollectService;
import com.ruoyi.party.building.news.service.INewsService;
import com.ruoyi.system.service.ISysDeptService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("手机端接口")
@RestController
@RequestMapping("/app_api")
public class AppController extends BaseController {
    @Autowired
    private ICollectService collectService;
    @Autowired
    private INewsService newsService;
    @Autowired
    private ISysDeptService deptService;
    //
    //@ApiOperation("加入收藏")
    //@PostMapping("/addCollect")
    //@ResponseBody
    //public AjaxResult addCollect(@RequestBody Collect collect) {
    //    //判断是否收藏
    //    AjaxResult ajaxResult = null;
    //    List<Collect> collectList = collectService.selectCollectList(collect);
    //    if (collectList != null && collectList.size() > 0) {
    //        return success("已收藏!");
    //    } else {
    //        int result = collectService.insertCollect(collect);
    //        if (result > 0) {
    //            ajaxResult = success("收藏成功");
    //        } else {
    //            ajaxResult = error("收藏失败");
    //        }
    //    }
    //    return ajaxResult;
    //}
    //
    //@ApiOperation("我的学习收藏列表")
    //@PostMapping("/getCollectList")
    //@ResponseBody
    //public AjaxResult getCollectList(@RequestParam("userId") String userId) {
    //    Collect collect = new Collect();
    //    if (userId != null) {
    //        collect.setUserId(Long.valueOf(userId));
    //    }
    //    List<Collect> list = collectService.selectCollectList(collect);
    //    AjaxResult result = AjaxResult.success();
    //    result.put("list", list);
    //    return result;
    //}
    //
    //@ApiOperation("查看详情")
    //@PostMapping("/getNewsInfo")
    //@ResponseBody
    //public AjaxResult getCollectInfo(@RequestParam("id") String id) {
    //    AjaxResult result = null;
    //    if (id != null) {
    //        Collect collect = collectService.selectCollectById(Long.valueOf(id));
    //        if (collect != null) {
    //            Long newId = collect.getNewId();
    //            News news = newsService.selectNewsById(Long.valueOf(newId));
    //            result = AjaxResult.success();
    //            result.put("news", news);
    //        }
    //    }
    //    return result;
    //}
    //
    //@ApiOperation("收藏移除")
    //@PostMapping("/removeCollect")
    //@ResponseBody
    //public AjaxResult removeCollect(@RequestParam("id") String id) {
    //    AjaxResult ajaxResult = null;
    //    int result = collectService.deleteCollectById(Long.valueOf(id));
    //    if (result > 0) {
    //        ajaxResult = success("删除成功！");
    //    } else {
    //        ajaxResult = error("删除失败！");
    //    }
    //    return ajaxResult;
    //}
    //
    //@ApiOperation("组织结构图")
    //@PostMapping("/getDeptPicture")
    //@ResponseBody
    //public AjaxResult getDeptPicture() {
    //    List<DeptInfo> infoList = new ArrayList<>();
    //    SysDept dept = new SysDept();
    //    dept.setStatus("0");
    //    //获取所有数据
    //    List<SysDept> allList = deptService.selectDeptList(dept);
    //    List<DeptInfo> rootList = new ArrayList<>();
    //    if (allList != null && allList.size() > 0) {
    //        for (SysDept dept1 : allList) {
    //
    //            DeptInfo d = new DeptInfo();
    //            d.setId(dept1.getDeptId());
    //            d.setName(dept1.getDeptName());
    //            d.setParentId(dept1.getParentId());
    //            rootList.add(d);
    //
    //            //一级分类parentId是0
    //            if (dept1.getParentId() == 0) {
    //                DeptInfo info = new DeptInfo();
    //                info.setId(dept1.getDeptId());
    //                info.setName(dept1.getDeptName());
    //                info.setParentId(dept1.getParentId());
    //                infoList.add(info);
    //            }
    //
    //        }
    //        // 为一级菜单设置子菜单，getChild是递归调用的
    //        for (DeptInfo info : infoList) {
    //            info.setChildren(getChilde(info.getId(), rootList));
    //        }
    //    }
    //
    //    AjaxResult ajaxResult = AjaxResult.success();
    //    ajaxResult.put("data", infoList);
    //    return ajaxResult;
    //}
    //
    ///**
    // * 递归查找子菜单
    // *
    // * @param id       当前菜单id
    // * @param rootList 要查找的列表
    // * @return
    // */
    //private List<DeptInfo> getChilde(Long id, List<DeptInfo> rootList) {
    //    //子菜单
    //    List<DeptInfo> childList = new ArrayList<>();
    //    for (DeptInfo deptInfo : rootList) {
    //        // 遍历所有节点，将父菜单id与传过来的id比较
    //        if (deptInfo.getParentId().equals(id)) {
    //            childList.add(deptInfo);
    //        }
    //    }
    //
    //    // 把子菜单的子菜单再循环一遍
    //    for (DeptInfo deptInfo : childList) {
    //        deptInfo.setChildren(getChilde(deptInfo.getId(), rootList));
    //    }
    //    // 递归退出条件
    //    if (childList.size() == 0) {
    //        return null;
    //    }
    //    return childList;
    //}

}
