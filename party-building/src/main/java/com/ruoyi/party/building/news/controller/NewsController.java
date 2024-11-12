package com.ruoyi.party.building.news.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysNoticeService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.controller.module.news.domain.News;
import com.ruoyi.web.controller.module.news.service.INewsService;
import com.ruoyi.web.controller.module.type.domain.NewsType;
import com.ruoyi.web.controller.module.type.service.INewsTypeService;
import com.ruoyi.web.controller.module.upload.service.INewsUploadService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * 资讯Controller
 *
 * @author ruoyi
 * @date 2020-05-06
 */
@Controller
@RequestMapping("/module/news")
public class NewsController extends BaseController {
    private String prefix = "module/news";

    @Autowired
    private INewsService newsService;
    @Autowired
    private INewsTypeService newsTypeService;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysNoticeService noticeService;
    @Autowired
    private ISysDeptService deptService;
    @Autowired
    private INewsUploadService uploadService;

    @RequiresPermissions("module:news:view")
    @GetMapping()
    public String news(ModelMap mmap) {
        //所有分类
        NewsType type = new NewsType();
        type.setType("1"); //资讯分类
        List<NewsType> typeList = newsTypeService.selectNewsTypeList(type);

        //所有部门
        List<SysDept> deptList = deptService.selectDeptList(new SysDept());
        mmap.put("typeList", typeList);
        mmap.put("deptList", deptList);
        return prefix + "/news";
    }

    /**
     * 查询资讯列表
     */
    @RequiresPermissions("module:news:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(News news) {
        startPage();
        List<News> list = newsService.selectNewsList(news);
        return getDataTable(list);
    }

    /**
     * 导出资讯列表
     */
    @RequiresPermissions("module:news:export")
    @Log(title = "资讯", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(News news) {
        List<News> list = newsService.selectNewsList(news);
        ExcelUtil<News> util = new ExcelUtil<News>(News.class);
        return util.exportExcel(list, "news");
    }

    /**
     * 新增资讯
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
        //查询资讯分类列表
        NewsType type = new NewsType();
        type.setType("1"); //资讯分类
        List<NewsType> typeList = newsTypeService.selectNewsTypeList(type);
        mmap.put("typeList", typeList);

        //上传时间
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = dateFormat.format(new Date());
        mmap.put("createTime", time);

        //默认管理员审核
        SysUser user = userService.selectUserById((long) 1);
        mmap.put("userId", 1);
        mmap.put("userName", user.getUserName());
        return prefix + "/add";
    }

    /**
     * 新增保存资讯
     */
    @RequiresPermissions("module:news:add")
    @Log(title = "资讯", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(News news) {
        return toAjax(newsService.insertNews(news));
    }

    /**
     * 修改资讯
     */
    @GetMapping("/edit/{newId}")
    public String edit(@PathVariable("newId") Long newId, ModelMap mmap) {
        News news = newsService.selectNewsById(newId);
        mmap.put("news", news);

        //查询资讯分类列表
        NewsType type = new NewsType();
        type.setType("1"); //资讯分类
        List<NewsType> typeList = newsTypeService.selectNewsTypeList(type);
        mmap.put("typeList", typeList);

        return prefix + "/edit";
    }

    /**
     * 修改保存资讯
     */
    @RequiresPermissions("module:news:edit")
    @Log(title = "资讯", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(News news) {
        return toAjax(newsService.updateNews(news));
    }

    /**
     * 删除资讯
     */
    @RequiresPermissions("module:news:remove")
    @Log(title = "资讯", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(newsService.deleteNewsByIds(ids));
    }


    /**
     * 我的审批
     *
     * @return
     */
    @RequiresPermissions("module:news:view")
    @GetMapping("/approval")
    public String approval() {
        return prefix + "/approval";
    }


    @RequiresPermissions("module:news:view")
    @GetMapping("/approvalNews")
    public String approvalNews() {
        return prefix + "/approvalNews";
    }


    @RequiresPermissions("module:news:view")
    @GetMapping("/approvalNotice")
    public String approvalNotice() {
        return prefix + "/approvalNotice";
    }


    /**
     * 资讯审批
     *
     * @param news
     * @return
     */
    @RequiresPermissions("module:news:list")
    @PostMapping("/approvalList")
    @ResponseBody
    public TableDataInfo approvalList(News news) {
        startPage();
        news.setType("1");
        news.setUserId(ShiroUtils.getSysUser().getUserId());
        List<News> list = newsService.selectNewsList(news);
        return getDataTable(list);
    }

    /**
     * 公告审批
     */

    @RequiresPermissions("module:news:list")
    @PostMapping("/noticeList")
    @ResponseBody
    public TableDataInfo noticeList(SysNotice notice) {
        startPage();
        //notice.setUserId(ShiroUtils.getSysUser().getUserId());
        List<SysNotice> list = noticeService.selectNoticeList(notice);
        return getDataTable(list);
    }

    /**
     * 上传
     */
    @GetMapping("/upload")
    public String upload(News news, ModelMap mmap) {
        mmap.put("newId", news.getNewId());
        return prefix + "/newUpload";
    }


    /**
     * 查看详情
     *
     * @param newId
     * @param mmap
     * @return
     */
    @GetMapping("/detail/{newId}")
    public String detail(@PathVariable("newId") Long newId, ModelMap mmap) {
        News news = newsService.selectNewsById(newId);
        mmap.put("news", news);


        if (news.getNewVideo() != null) {
            String[] videos = news.getNewVideo().split(",");
            mmap.put("videos", videos);
        }

        return prefix + "/detail";
    }

}
