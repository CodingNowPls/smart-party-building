package com.ruoyi.party.building.portal.pager.controller;


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.party.building.answer.domain.PagerAnswer;
import com.ruoyi.party.building.answer.service.IPagerAnswerService;
import com.ruoyi.party.building.pager.domain.PagerInfo;
import com.ruoyi.party.building.pageruser.domain.PagerUser;
import com.ruoyi.party.building.pageruser.service.IPagerUserService;
import com.ruoyi.party.building.question.domain.Question;
import com.ruoyi.party.building.question.service.IQuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 考试 接口
 *
 * @author : gao
 * @date 2024年11月13日
 * -------------------------------------------<br>
 * <br>
 * <br>
 */
@Api("portal-考试接口")
@RestController
@RequestMapping("/api")
public class PortalPagerController {

    @Autowired
    private IPagerAnswerService pagerAnswerService;

    @Autowired
    private IPagerUserService pagerUserService;

    @Autowired
    private IQuestionService questionService;


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

}
