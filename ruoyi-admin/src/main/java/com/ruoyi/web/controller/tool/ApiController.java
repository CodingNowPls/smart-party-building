package com.ruoyi.web.controller.tool;


import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.shiro.service.SysPasswordService;
import com.ruoyi.system.domain.SysNotice;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysNoticeService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.web.controller.module.answer.domain.PagerAnswer;
import com.ruoyi.web.controller.module.answer.service.IPagerAnswerService;
import com.ruoyi.web.controller.module.article.domain.Article;
import com.ruoyi.web.controller.module.article.service.IArticleService;
import com.ruoyi.web.controller.module.award.domain.Award;
import com.ruoyi.web.controller.module.award.service.IAwardService;
import com.ruoyi.web.controller.module.deed.domain.Deed;
import com.ruoyi.web.controller.module.deed.service.IDeedService;
import com.ruoyi.web.controller.module.detail.domain.UserDetail;
import com.ruoyi.web.controller.module.detail.service.IUserDetailService;
import com.ruoyi.web.controller.module.exchange.domain.Exchange;
import com.ruoyi.web.controller.module.exchange.service.IExchangeService;
import com.ruoyi.web.controller.module.feel.domain.Feel;
import com.ruoyi.web.controller.module.feel.service.IFeelService;
import com.ruoyi.web.controller.module.inspect.domain.Inspect;
import com.ruoyi.web.controller.module.inspect.service.IInspectService;
import com.ruoyi.web.controller.module.learn.domain.Learn;
import com.ruoyi.web.controller.module.learn.service.ILearnService;
import com.ruoyi.web.controller.module.light.domain.Light;
import com.ruoyi.web.controller.module.light.service.ILightService;
import com.ruoyi.web.controller.module.news.domain.News;
import com.ruoyi.web.controller.module.news.service.INewsService;
import com.ruoyi.web.controller.module.pager.domain.PagerInfo;
import com.ruoyi.web.controller.module.pager.service.IPagerService;
import com.ruoyi.web.controller.module.pageruser.domain.PagerUser;
import com.ruoyi.web.controller.module.pageruser.service.IPagerUserService;
import com.ruoyi.web.controller.module.picture.domain.Picture;
import com.ruoyi.web.controller.module.picture.service.IPictureService;
import com.ruoyi.web.controller.module.plan.domain.Plan;
import com.ruoyi.web.controller.module.plan.service.IPlanService;
import com.ruoyi.web.controller.module.problem.domain.Problem;
import com.ruoyi.web.controller.module.problem.service.IProblemService;
import com.ruoyi.web.controller.module.question.domain.Question;
import com.ruoyi.web.controller.module.question.service.IQuestionService;
import com.ruoyi.web.controller.module.record.domain.Record;
import com.ruoyi.web.controller.module.record.service.IRecordService;
import com.ruoyi.web.controller.module.story.domain.Story;
import com.ruoyi.web.controller.module.story.service.IStoryService;
import com.ruoyi.web.controller.module.tale.domain.Tale;
import com.ruoyi.web.controller.module.tale.service.ITaleService;
import com.ruoyi.web.controller.module.type.domain.NewsType;
import com.ruoyi.web.controller.module.type.service.INewsTypeService;
import com.ruoyi.web.controller.module.violate.domain.Violate;
import com.ruoyi.web.controller.module.violate.service.IViolateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Api("手机端接口")
@RestController
@RequestMapping("/api/*")
public class ApiController extends BaseController {

    @Autowired
    private ISysUserService userService;
    @Autowired
    private ISysDeptService deptService;
    @Autowired
    private IUserDetailService userDetailService;
    @Autowired
    private INewsTypeService newsTypeService;
    @Autowired
    private INewsService newsService;
    @Autowired
    private ISysNoticeService noticeService;
    @Autowired
    private IInspectService inspectService;
    @Autowired
    private IExchangeService exchangeService;
    @Autowired
    private IAwardService awardService;
    @Autowired
    private IStoryService storyService;
    @Autowired
    private IDeedService deedService;
    @Autowired
    private ILightService lightService;
    @Autowired
    private IRecordService recordService;
    @Autowired
    private IPlanService planService;
    @Autowired
    private IFeelService feelService;
    @Autowired
    private IArticleService articleService;
    @Autowired
    private ITaleService taleService;
    @Autowired
    private IProblemService problemService;
    @Autowired
    private ILearnService learnService;
    @Autowired
    private IPictureService pictureService;
    @Autowired
    private SysPasswordService passwordService;
    @Autowired
    private IPagerService pagerService;
    @Autowired
    private IQuestionService questionService;
    @Autowired
    private IPagerAnswerService pagerAnswerService;
    @Autowired
    private IPagerUserService pagerUserService;
    @Autowired
    private IViolateService violateService;


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
    @GetMapping("getDeptList")
    public AjaxResult getDeptList() {
        SysDept dept = new SysDept();
        dept.setStatus("0");
        //List<SysDept> deptList = deptService.selectDeptListNoParent(dept);
        AjaxResult ajaxResult = AjaxResult.success();
        //ajaxResult.put("deptList", deptList);
        return ajaxResult;
    }

    @ApiOperation("组织结构下的成员")
    @GetMapping("getUserByDeptId")
    public AjaxResult getUserByDeptId(String deptId) {
        SysUser user = new SysUser();
        user.setDeptId(Long.valueOf(deptId));
        List<SysUser> userList = userService.selectUserList(user);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("userList", userList);
        return ajaxResult;
    }

    @ApiOperation("成员详细信息")
    @GetMapping("getUserInfo")
    public AjaxResult getUserInfo(String userId) {
        SysUser user = userService.selectUserById(Long.valueOf(userId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("user", user);
        return ajaxResult;
    }

    @ApiOperation("成员履历")
    @GetMapping("getUserDetail")
    public AjaxResult getUserDetail(String userId) {
        UserDetail detail = new UserDetail();
        detail.setUserId(Long.valueOf(userId));
        List<UserDetail> list = userDetailService.selectUserDetailList(detail);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("最新资讯")
    @GetMapping("getNewsList")
    public AjaxResult getNewsList() {
        News news = new News();
        news.setStatus("2");
        news.setType("1");
        List<News> newsList = newsService.selectNewsListLimit(news);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("newsList", newsList);
        return ajaxResult;
    }

    @ApiOperation("资讯分类")
    @GetMapping("/getNewTypeList")
    public AjaxResult getNewTypeList() {
        NewsType type = new NewsType();
        type.setType("1");
        List<NewsType> typeList = newsTypeService.selectNewsTypeList(type);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("typeList", typeList);
        return ajaxResult;
    }

    @ApiOperation("资讯分类下的资讯新闻")
    @GetMapping("/getNewsByTypeId")
    public AjaxResult getNewsByTypeId(String typeId) {
        News news = new News();
        news.setNewTypeId(typeId);
        news.setStatus("2");
        news.setType("1");
        List<News> newsList = newsService.selectNewsList(news);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("newsList", newsList);
        return ajaxResult;
    }


    @ApiOperation("在线学习分类")
    @GetMapping("/getLearnTypeList")
    public AjaxResult getLearnTypeList() {
        NewsType type = new NewsType();
        type.setType("2");
        List<NewsType> typeList = newsTypeService.selectNewsTypeList(type);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("typeList", typeList);
        return ajaxResult;
    }

    @ApiOperation("学习分类下的新闻内容")
    @GetMapping("/getLearnByTypeId")
    public AjaxResult getLearnByTypeId(String typeId) {
        News news = new News();
        news.setNewTypeId(typeId);
        news.setStatus("2");
        news.setType("2");
        List<News> newsList = newsService.selectNewsList(news);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("newsList", newsList);
        return ajaxResult;
    }

    @ApiOperation("资讯详细信息")
    @GetMapping("getNewsInfo")
    public AjaxResult getNewsInfo(String newId) {
        News news = newsService.selectNewsById(Long.valueOf(newId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("news", news);
        return ajaxResult;
    }

    @ApiOperation("资讯公告")
    @GetMapping("getNoticeList")
    public AjaxResult getNoticeList() {
        SysNotice notice = new SysNotice();
        notice.setStatus("2");
        List<SysNotice> noticeList = noticeService.selectNoticeList(notice);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("noticeList", noticeList);
        return ajaxResult;
    }

    @ApiOperation("资讯公告信息")
    @GetMapping("getNoticeInfo")
    public AjaxResult getNoticeInfo(String noticeId) {
        SysNotice notice = noticeService.selectNoticeById(Long.valueOf(noticeId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("notice", notice);
        return ajaxResult;
    }

    @ApiOperation("判断是否是审核人")
    @PostMapping("isReviewer")
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

    @ApiOperation("资讯审核内容(状态：1 待审核 2 已审核)")
    @GetMapping("getNewsByStatus")
    public AjaxResult getNewsByStatus(String status) {
        News news = new News();
        news.setStatus(status);
        List<News> newsList = newsService.selectNewsList(news);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("newsList", newsList);
        return ajaxResult;
    }

    @ApiOperation("公告审核内容 (状态：1 待审核 2 已审核)")
    @GetMapping("getNoticesByStatus")
    public AjaxResult getNoticesByStatus(String status) {
        SysNotice notice = new SysNotice();
        notice.setStatus(status);
        List<SysNotice> noticeList = noticeService.selectNoticeList(notice);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("noticeList", noticeList);
        return ajaxResult;
    }

    @ApiOperation("资讯审核 (传值 newId 和 status=2)")
    @PostMapping("approvalNews")
    public AjaxResult approvalNews(@RequestBody News news) {
        System.out.println(news);
        int result = newsService.updateNews(news);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("审核成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("审核失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("公告审核 (传值noticeId和status=2)")
    @PostMapping("approvalNotice")
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

    @ApiOperation("文件上传")
    @PostMapping("upload")
    public AjaxResult upload(MultipartFile file) {
        try {
            //if (!file.isEmpty()) {
            //    String fileUrl = QiNiuUtils.uploadQiNiu(file);
            //    if (StringUtils.isNotEmpty(fileUrl)) {
            //        AjaxResult ajax = AjaxResult.success();
            //        ajax.put("src", fileUrl);
            //        return ajax;
            //    } else {
            //        AjaxResult ajax = AjaxResult.error("上传失败");
            //        return ajax;
            //    }
            //} else {
            AjaxResult ajax = AjaxResult.error("上传失败");
            return ajax;
            //}
        } catch (Exception e) {
            AjaxResult ajax = AjaxResult.error("上传失败");
            return ajax;
        }
    }

    @ApiOperation("领导视察")
    @GetMapping("getInspectList")
    public AjaxResult getInspectList() {
        List<Inspect> list = inspectService.selectInspectList(new Inspect());
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("领导视察详情")
    @GetMapping("getInspectInfo")
    public AjaxResult getInspectInfo(String inspectId) {
        Inspect inspect = inspectService.selectInspectById(Long.valueOf(inspectId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("inspect", inspect);
        return ajaxResult;
    }

    @ApiOperation("单位交流")
    @GetMapping("getExchangeList")
    public AjaxResult getExchangeList() {
        List<Exchange> list = exchangeService.selectExchangeList(new Exchange());
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("单位交流详情")
    @GetMapping("getExchangeInfo")
    public AjaxResult getExchangeInfo(String exchangeId) {
        Exchange exchange = exchangeService.selectExchangeById(Long.valueOf(exchangeId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("exchange", exchange);
        return ajaxResult;
    }

    @ApiOperation("荣誉奖项")
    @GetMapping("getAwardList")
    public AjaxResult getAwardList() {
        List<Award> list = awardService.selectAwardList(new Award());
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("荣誉奖项详情")
    @GetMapping("getAwardInfo")
    public AjaxResult getAwardInfo(String awardId) {
        Award award = awardService.selectAwardById(Long.valueOf(awardId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("award", award);
        return ajaxResult;
    }


    @ApiOperation("暖心故事")
    @GetMapping("getStoryList")
    public AjaxResult getStoryList() {
        List<Story> list = storyService.selectStoryList(new Story());
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("暖心故事详情")
    @GetMapping("getStoryInfo")
    public AjaxResult getStoryInfo(String storyId) {
        Story story = storyService.selectStoryById(Long.valueOf(storyId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("story", story);
        return ajaxResult;
    }

    @ApiOperation("典型事迹")
    @GetMapping("getDeedList")
    public AjaxResult getDeedList() {
        List<Deed> list = deedService.selectDeedList(new Deed());
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("典型事迹详情")
    @GetMapping("getDeedInfo")
    public AjaxResult getDeedInfo(String deedId) {
        Deed deed = deedService.selectDeedById(Long.valueOf(deedId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("deed", deed);
        return ajaxResult;
    }

    @ApiOperation("十大亮点")
    @GetMapping("getLightList")
    public AjaxResult getLightList() {
        List<Light> list = lightService.selectLightList(new Light());
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("十大亮点详情")
    @GetMapping("getLightInfo")
    public AjaxResult getLightInfo(String lightId) {
        Light light = lightService.selectLightById(Long.valueOf(lightId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("light", light);
        return ajaxResult;
    }

    @ApiOperation("会议记录添加")
    @PostMapping("addRecord")
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
    @PostMapping("editRecord")
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
    @GetMapping("getRecordList")
    public AjaxResult getRecordList(String deptId) {
        Record record = new Record();
        record.setDeptId(Long.valueOf(deptId));
        List<Record> list = recordService.selectRecordList(record);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("会议记录详情")
    @GetMapping("getRecordInfo")
    public AjaxResult getRecordInfo(String recordId) {
        Record record = recordService.selectRecordById(Long.valueOf(recordId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("record", record);
        return ajaxResult;
    }


    @ApiOperation("学习计划添加")
    @PostMapping("addPlan")
    public AjaxResult addPlan(@RequestBody Plan plan) {
        int result = planService.insertPlan(plan);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("提交成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("提交失败！");
            return ajaxResult;
        }
    }


    @ApiOperation("学习计划编辑")
    @PostMapping("editPlan")
    public AjaxResult editPlan(@RequestBody Plan plan) {
        int result = planService.updatePlan(plan);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("编辑成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("编辑失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("学习计划删除")
    @PostMapping("removePlan")
    public AjaxResult removePlan(String ids) {
        int result = planService.deletePlanByIds(ids);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("删除成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("删除失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("学习计划列表 自己提交的")
    @GetMapping("getPlanList")
    public AjaxResult getPlanList(String deptId) {
        Plan plan = new Plan();
        plan.setDeptId(Long.valueOf(deptId));
        // plan.setUserId(Long.valueOf(userId));
        List<Plan> list = planService.selectPlanList(plan);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("学习计划详情")
    @GetMapping("getPlanInfo")
    public AjaxResult getPlanInfo(String planId) {
        Plan plan = planService.selectPlanById(Long.valueOf(planId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("plan", plan);
        return ajaxResult;
    }

    @ApiOperation("心得体会添加")
    @PostMapping("addFeel")
    public AjaxResult addFeel(@RequestBody Feel feel) {
        int result = feelService.insertFeel(feel);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("提交成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("提交失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("心得体会编辑")
    @PostMapping("editFeel")
    public AjaxResult editFeel(@RequestBody Feel feel) {
        int result = feelService.updateFeel(feel);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("编辑成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("编辑失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("心得体会列表")
    @GetMapping("getFeelList")
    public AjaxResult getFeelList(String deptId) {
        Feel feel = new Feel();
        feel.setDeptId(Long.valueOf(deptId));
        List<Feel> list = feelService.selectFeelList(feel);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("心得体会详情")
    @GetMapping("getFeelInfo")
    public AjaxResult getFeelInfo(String feelId) {
        Feel feel = feelService.selectFeelById(Long.valueOf(feelId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("feel", feel);
        return ajaxResult;
    }

    @ApiOperation("分享美文添加")
    @PostMapping("addArticle")
    public AjaxResult addArticle(@RequestBody Article article) {
        int result = articleService.insertArticle(article);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("提交成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("提交失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("分享美文编辑")
    @PostMapping("editArticle")
    public AjaxResult editArticle(@RequestBody Article article) {
        int result = articleService.updateArticle(article);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("编辑成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("编辑失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("分享美文列表")
    @GetMapping("getArticleList")
    public AjaxResult getArticleList(String deptId) {
        Article article = new Article();
        article.setDeptId(Long.valueOf(deptId));
        List<Article> list = articleService.selectArticleList(article);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("分享美文详情")
    @GetMapping("getArticleInfo")
    public AjaxResult getArticleInfo(String articleId) {
        Article article = articleService.selectArticleById(Long.valueOf(articleId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("article", article);
        return ajaxResult;
    }

    @ApiOperation("小组故事添加")
    @PostMapping("addTale")
    public AjaxResult addTale(@RequestBody Tale tale) {
        int result = taleService.insertTale(tale);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("提交成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("提交失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("小组故事编辑")
    @PostMapping("editTale")
    public AjaxResult editTale(@RequestBody Tale tale) {
        int result = taleService.updateTale(tale);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("编辑成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("编辑失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("小组故事列表")
    @GetMapping("getTaleList")
    public AjaxResult getTaleList(String deptId) {
        Tale tale = new Tale();
        tale.setDeptId(Long.valueOf(deptId));
        List<Tale> list = taleService.selectTaleList(tale);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("小组故事详情")
    @GetMapping("getTaleInfo")
    public AjaxResult getTaleInfo(String taleId) {
        Tale tale = taleService.selectTaleById(Long.valueOf(taleId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("tale", tale);
        return ajaxResult;
    }

    @ApiOperation("问题墙添加")
    @PostMapping("addProblem")
    public AjaxResult addProblem(@RequestBody Problem problem) {
        int result = problemService.insertProblem(problem);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("提交成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("提交失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("问题墙编辑")
    @PostMapping("editProblem")
    public AjaxResult editProblem(@RequestBody Problem problem) {
        int result = problemService.updateProblem(problem);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("编辑成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("编辑失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("问题墙列表")
    @GetMapping("getProblemList")
    public AjaxResult getProblemList(String deptId) {
        Problem problem = new Problem();
        problem.setDeptId(Long.valueOf(deptId));
        List<Problem> list = problemService.selectProblemList(problem);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("问题墙详情")
    @GetMapping("getProblemInfo")
    public AjaxResult getProblemInfo(String problemId) {
        Problem problem = problemService.selectProblemById(Long.valueOf(problemId));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("problem", problem);
        return ajaxResult;
    }

    @ApiOperation("学分添加")
    @PostMapping("addLearn")
    public AjaxResult addLearn(@RequestBody Learn learn) {
        int result = learnService.insertLearn(learn);
        if (result > 0) {
            AjaxResult ajaxResult = AjaxResult.success("编辑成功！");
            return ajaxResult;
        } else {
            AjaxResult ajaxResult = AjaxResult.error("编辑失败！");
            return ajaxResult;
        }
    }

    @ApiOperation("成员学分排行")
    @GetMapping("getUserRankList")
    public AjaxResult getUserRankList(String deptId) {
        Learn learn = new Learn();
        learn.setDeptId(Long.valueOf(deptId));
        List<Learn> list = learnService.selectUserRankList(learn);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("小组学分排行")
    @GetMapping("getDeptRankList")
    public AjaxResult getDeptRankList() {
        Learn learn = new Learn();
        List<Learn> list = learnService.selectDeptRankList(learn);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }


    @ApiOperation("成员学分记录")
    @GetMapping("getLearnInfo")
    public AjaxResult getLearnInfo(String userId) {
        Learn learn = new Learn();
        learn.setUserId(Long.valueOf(userId));
        List<Learn> list = learnService.selectLearnList(learn);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("轮播图片")
    @GetMapping("getPictureList")
    public AjaxResult getPictureList() {
        Picture picture = new Picture();
        List<Picture> list = pictureService.selectPictureList(picture);
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

    @ApiOperation("考试列表 userId 考试对象")
    @PostMapping("getPagerList")
    @ResponseBody
    public AjaxResult getPagerList(@RequestParam("userId") String userId) {
        PagerUser pagerUser = new PagerUser();
        pagerUser.setUserId(Long.valueOf(userId));
        pagerUser.setPagerStatus("1");
        pagerUser.setStatus("2");
        List<PagerUser> list = pagerUserService.selectPagerUserList(pagerUser);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }


    @ApiOperation("试卷详情 ")
    @PostMapping("getPagerInfo")
    public AjaxResult getPagerInfo(@RequestParam("pagerId") String pagerId) {
        List<Question> questionList = new ArrayList<>();
        List<PagerInfo> infoList = new ArrayList<>();

        AjaxResult ajaxResult = AjaxResult.success();
        if (pagerId != null) {
            questionList = questionService.selectQuetionByPagerId(Long.valueOf(pagerId));
            if (questionList != null && questionList.size() > 0) {
                for (Question q : questionList) {
                    List<PagerInfo.QuestionOption> optionList = new ArrayList();
                    PagerInfo.QuestionOption option1 = new PagerInfo.QuestionOption();
                    PagerInfo.QuestionOption option2 = new PagerInfo.QuestionOption();
                    PagerInfo.QuestionOption option3 = new PagerInfo.QuestionOption();
                    PagerInfo.QuestionOption option4 = new PagerInfo.QuestionOption();
                    if (q.getAnswerA() != null) {
                        option1.setId("A");
                        option1.setContent(q.getAnswerA());
                        optionList.add(option1);
                    }

                    if (q.getAnswerB() != null) {
                        option2.setId("B");
                        option2.setContent(q.getAnswerB());
                        optionList.add(option2);
                    }
                    if (q.getAnswerC() != null) {
                        option3.setId("C");
                        option3.setContent(q.getAnswerC());
                        optionList.add(option3);
                    }
                    if (q.getAnswerD() != null) {
                        option4.setId("D");
                        option4.setContent(q.getAnswerD());
                        optionList.add(option4);
                    }
                    PagerInfo pagerInfo = new PagerInfo();
                    pagerInfo.setQuestionId(q.getId());
                    pagerInfo.setTitle(q.getTitle());
                    pagerInfo.setType(q.getQuestionType());
                    pagerInfo.setAnswer(q.getAnswer());
                    pagerInfo.setUserAnswer("");
                    pagerInfo.setExplain(q.getIntroduce());
                    pagerInfo.setOptionList(optionList);
                    infoList.add(pagerInfo);
                }
            }
            ajaxResult.put("list", infoList);
        }
        return ajaxResult;
    }

    @ApiOperation("开始考试")
    @PostMapping("startPager")
    @ResponseBody
    public AjaxResult startPager(@RequestBody PagerUser user) {
        List<PagerUser> list = pagerUserService.selectPagerUserList(user);
        AjaxResult ajaxResult = null;
        if (list != null && list.size() > 0) {
            Long id = list.get(0).getId();
            Long userId = list.get(0).getUserId();
            PagerUser user1 = new PagerUser();
            user1.setId(id);
            user1.setUserId(userId);
            user1.setStatus("1");
            int result = pagerUserService.updatePagerUser(user1);
            if (result > 0) {
                ajaxResult = AjaxResult.success("成功！");
            } else {
                ajaxResult = AjaxResult.error("失败！");
            }
        }
        return ajaxResult;
    }

    @ApiOperation("添加考试答案")
    @PostMapping("addPagerAnswer")
    @Transactional
    @ResponseBody
    public AjaxResult addPagerAnswer(@RequestBody List<PagerAnswer> answerList) {
        AjaxResult ajaxResult = null;
        List<PagerAnswer> list = new ArrayList<>();
        if (answerList != null && answerList.size() > 0) {
            for (PagerAnswer pagerAnswer : answerList) {
                if (pagerAnswer.getQuestionId() != null) {
                    Question question = questionService.selectQuestionById(pagerAnswer.getQuestionId());
                    String answer = question.getAnswer();
                    Long score = question.getScore();
                    Long questionType = question.getQuestionType();
                    if (pagerAnswer.getAnswer() != null && pagerAnswer.getAnswer() != "") {
                        //不是简答题 打分
                        if (questionType != 4) {
                            if (pagerAnswer.getAnswer().equalsIgnoreCase(answer.trim())) {
                                pagerAnswer.setIsRight("1");
                                pagerAnswer.setMark(score);
                            } else {
                                pagerAnswer.setIsRight("2");
                                long mark = 0;
                                pagerAnswer.setMark(mark);
                            }
                        } else {
                            pagerAnswer.setIsRight("3"); //简答题
                        }
                        pagerAnswer.setCreateTime(DateUtils.getNowDate());
                    }
                    list.add(pagerAnswer);
                }
            }
            if (list.size() > 0) {
                int result = pagerAnswerService.insertPagerBatch(list);
                if (result > 0) {
                    //修改试卷用户的状态 为完成
                    Long userId = answerList.get(0).getUserId();
                    Long pagerId = answerList.get(0).getPagerId();
                    PagerUser pagerUser = new PagerUser();
                    pagerUser.setUserId(userId);
                    pagerUser.setPagerId(pagerId);
                    List<PagerUser> userList = pagerUserService.selectPagerUserList(pagerUser);
                    if (userList != null && userList.size() > 0) {
                        Long id = userList.get(0).getId();
                        pagerUser.setId(id);
                        pagerUser.setStatus("2");
                        pagerUserService.updatePagerUser(pagerUser);
                        ajaxResult = AjaxResult.success("提交成功！");
                    } else {
                        ajaxResult = AjaxResult.error("提交失败！");

                    }
                }
            }
        }
        return ajaxResult;
    }

    @ApiOperation("我的考试 已考的")
    @PostMapping("myPager")
    @ResponseBody
    public AjaxResult myPager(@RequestParam("userId") String userId) {
        PagerUser pagerUser = new PagerUser();
        pagerUser.setUserId(Long.valueOf(userId));
        pagerUser.setPagerStatus("1");
        pagerUser.setStatus("2");
        List<PagerUser> list = pagerUserService.selectPagerUserListOver(pagerUser);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }


    @ApiOperation("获取考试分数")
    @PostMapping("/getScore")
    @ResponseBody
    public AjaxResult getScore(@RequestParam("pagerId") String pagerId, @RequestParam("userId") String userId) {
        AjaxResult ajaxResult = null;
        PagerAnswer answer = new PagerAnswer();
        answer.setPagerId(Long.valueOf(pagerId));
        answer.setUserId(Long.valueOf(userId));
        answer.setConfirm("1");
        List<PagerAnswer> list = pagerAnswerService.selectTotal(answer);
        if (list != null && list.size() > 0) {
            PagerAnswer answer1 = list.get(0);
            ajaxResult = AjaxResult.success();
            ajaxResult.put("data", answer1);

        } else {
            ajaxResult = AjaxResult.error("请稍等，批改试卷中！");
        }

        return ajaxResult;
    }


    @ApiOperation("违规违纪列表 ")
    @PostMapping("getViolateList")
    public AjaxResult getViolateList() {
        Violate violate = new Violate();
        List<Violate> list = violateService.selectViolateList(violate);
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("list", list);
        return ajaxResult;
    }

    @ApiOperation("违规违纪详情")
    @GetMapping("getViolateInfo")
    public AjaxResult getViolateInfo(String id) {
        Violate violate = violateService.selectViolateById(Long.valueOf(id));
        AjaxResult ajaxResult = AjaxResult.success();
        ajaxResult.put("violate", violate);
        return ajaxResult;
    }

    @ApiOperation("版本更新")
    @PostMapping("checkUpdate")
    @ResponseBody
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
