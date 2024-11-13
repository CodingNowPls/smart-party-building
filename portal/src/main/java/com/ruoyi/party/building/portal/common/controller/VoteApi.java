package com.ruoyi.party.building.portal.common.controller;


import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.party.building.vote.service.IVoteRecordService;
import com.ruoyi.party.building.vote.service.IVoteService;
import com.ruoyi.party.building.vote.service.IVoteUserByService;
import com.ruoyi.party.building.vote.service.IVoteUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api("选举接口")
@RestController
@RequestMapping("/vote_api/*")
public class VoteApi extends BaseController {
    @Autowired
    private IVoteService voteService;
    @Autowired
    private IVoteUserService voteUserService;
    @Autowired
    private IVoteUserByService userByService;
    @Autowired
    private IVoteRecordService voteRecordService;
    //
    //@ApiOperation("选举任务列表  type:1党代表管理  2换届管理")
    //@PostMapping("/selectVoteList")
    //@ResponseBody
    //public AjaxResult selectVoteList(String userId, @RequestParam("type") String type) {
    //    AjaxResult ajax = AjaxResult.success();
    //    if (userId != null) {
    //        VoteUser voteUser = new VoteUser();
    //        voteUser.setUserId(Long.valueOf(userId));
    //        voteUser.setVoteStatus("1"); //任务进行中
    //        voteUser.setType(type);
    //        List<VoteUser> list = voteUserService.selectVoteUserList(voteUser);
    //        ajax.put("list", list);
    //    } else {
    //        Vote vote = new Vote();
    //        vote.setType(type);
    //        List<Vote> list = voteService.selectVoteList(vote);
    //        ajax.put("list", list);
    //    }
    //    return ajax;
    //}
    //
    //@ApiOperation("选举任务详情")
    //@PostMapping("/getVoteInfo")
    //@ResponseBody
    //public AjaxResult getVoteInfo(@RequestParam("voteId") String voteId) {
    //    //通过voteId获取任务详情
    //    AjaxResult ajaxResult = AjaxResult.success();
    //    Vote vote = voteService.selectVoteById(Long.valueOf(voteId));
    //    //通过voteId获取被选举人
    //    VoteUserBy by = new VoteUserBy();
    //    by.setVoteId(Long.valueOf(voteId));
    //    List<VoteUserBy> userByList = userByService.selectVoteUserByList(by);
    //    ajaxResult.put("userByList", userByList);
    //    ajaxResult.put("vote", vote);
    //    return ajaxResult;
    //}
    //
    //@ApiOperation("判断是否投票")
    //@PostMapping("checkVote")
    //@ResponseBody
    //public AjaxResult checkVote(@RequestParam("voteUserId") String voteUserId) {
    //    VoteUser user = voteUserService.selectVoteUserById(Long.valueOf(voteUserId));
    //    AjaxResult result = AjaxResult.success();
    //    if (user != null) {
    //        if ("1".equals(user.getStatus())) {
    //            result.put("vote", true);  //已投票
    //        } else {
    //            result.put("vote", false);  //未投票
    //        }
    //        return result;
    //    } else {
    //        AjaxResult err = AjaxResult.error();
    //        return err;
    //    }
    //}
    //
    //@ApiOperation("投票")
    //@PostMapping("/addVoteRecord")
    //@ResponseBody
    //public AjaxResult addVoteRecord(@RequestBody VoteRecord voteRecord) {
    //    AjaxResult ajaxResult = null;
    //    if (voteRecord != null) {
    //        int result = voteRecordService.insertVoteRecord(voteRecord);
    //        if (result > 0) {
    //            ajaxResult = AjaxResult.success("投票成功！");
    //        } else {
    //            ajaxResult = AjaxResult.error("投票失败！");
    //        }
    //    }
    //    return ajaxResult;
    //}
    //
    //@ApiOperation("我的选举 已结束的 type:1党代表管理  2换届管理")
    //@PostMapping("/myVote")
    //@ResponseBody
    //public AjaxResult myVote(String userId, @RequestParam("type") String type) {
    //    AjaxResult ajax = AjaxResult.success();
    //    if (userId != null) {
    //        VoteUser voteUser = new VoteUser();
    //        voteUser.setUserId(Long.valueOf(userId));
    //        voteUser.setVoteStatus("2"); //已结束
    //        voteUser.setType(type);
    //        List<VoteUser> list = voteUserService.selectVoteUserList(voteUser);
    //        ajax.put("list", list);
    //    } else {
    //        Vote vote = new Vote();
    //        vote.setType(type);
    //        List<Vote> list = voteService.selectVoteList(vote);
    //        ajax.put("list", list);
    //    }
    //
    //    return ajax;
    //}
    //
    //@ApiOperation("投票结果")
    //@PostMapping("/getVoteResult")
    //@ResponseBody
    //public AjaxResult getVoteResult(@RequestParam("voteId") String voteId) {
    //    VoteUserBy voteUserBy = new VoteUserBy();
    //    voteUserBy.setVoteId(Long.valueOf(voteId));
    //    List<VoteUserBy> list = userByService.selectVoteUserByList(voteUserBy);
    //    if (list != null && list.size() > 0) {
    //        for (VoteUserBy userBy : list) {
    //            VoteRecord record = new VoteRecord();
    //            record.setVoteId(userBy.getVoteId());
    //            record.setVoteUserById(userBy.getId());
    //            int totalCount = voteRecordService.getTotalCount(record);
    //            userBy.setVoteCount((long) totalCount); //总票数
    //        }
    //    }
    //    AjaxResult result = AjaxResult.success();
    //    result.put("list", list);
    //    return result;
    //}

}
