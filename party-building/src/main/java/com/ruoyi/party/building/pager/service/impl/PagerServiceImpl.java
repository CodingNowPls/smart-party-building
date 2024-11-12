package com.ruoyi.party.building.pager.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.controller.module.pager.domain.Pager;
import com.ruoyi.web.controller.module.pager.mapper.PagerMapper;
import com.ruoyi.web.controller.module.pager.service.IPagerService;
import com.ruoyi.web.controller.module.pageruser.domain.PagerUser;
import com.ruoyi.web.controller.module.pageruser.mapper.PagerUserMapper;
import com.ruoyi.web.controller.module.questionpager.domain.QuestionPager;
import com.ruoyi.web.controller.module.questionpager.mapper.QuestionPagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 试卷Service业务层处理
 *
 * @author ruoyi
 * @date 2020-06-05
 */
@Service
public class PagerServiceImpl implements IPagerService {
    @Autowired
    private PagerMapper pagerMapper;
    @Autowired
    private QuestionPagerMapper questionPagerMapper;
    @Autowired
    private PagerUserMapper pagerUserMapper;

    /**
     * 查询试卷
     *
     * @param id 试卷ID
     * @return 试卷
     */
    @Override
    public Pager selectPagerById(Long id) {
        return pagerMapper.selectPagerById(id);
    }

    /**
     * 查询试卷列表
     *
     * @param pager 试卷
     * @return 试卷
     */
    @Override
    public List<Pager> selectPagerList(Pager pager) {
        return pagerMapper.selectPagerList(pager);
    }

    /**
     * 新增试卷
     *
     * @param pager 试卷
     * @return 结果
     */
    @Override
    @Transactional
    public int insertPager(Pager pager) {
        pager.setCreateTime(DateUtils.getNowDate());
        int result = pagerMapper.insertPager(pager);

        //新增试卷用户表
        if (StringUtils.isNotEmpty(pager.getUserId())) {
            List<PagerUser> userList = new ArrayList<>();
            String[] userIds = pager.getUserId().split(",");
            if (userIds != null && userIds.length > 0) {
                for (String userId : userIds) {
                    PagerUser pagerUser = new PagerUser();
                    pagerUser.setUserId(Long.valueOf(userId));
                    pagerUser.setPagerId(pager.getId());
                    long mark = 0;
                    pagerUser.setMark(mark);
                    pagerUser.setStatus("0");
                    pagerUser.setCreateBy(ShiroUtils.getLoginName());
                    pagerUser.setCreateTime(DateUtils.getNowDate());
                    userList.add(pagerUser);
                }
            }
            if (userList.size() > 0) {
                pagerUserMapper.addUserBatch(userList);
            }
        }
        //新增试卷与题目关联表
        if (StringUtils.isNotEmpty(pager.getQuestionIds())) {
            List<QuestionPager> list = new ArrayList<QuestionPager>();
            String[] ids = pager.getQuestionIds().split(",");
            if (ids != null && ids.length > 0) {
                for (String id : ids) {
                    QuestionPager qp = new QuestionPager();
                    qp.setPagerId(pager.getId());
                    qp.setQuestionId(Long.valueOf(id));
                    Long rank = Long.valueOf(1);
                    qp.setRank(rank);
                    list.add(qp);
                }
            }
            if (list.size() > 0) {
                questionPagerMapper.batchQutionPager(list);
            }
        }
        return result;
    }

    /**
     * 修改试卷
     *
     * @param pager 试卷
     * @return 结果
     */
    @Override
    public int updatePager(Pager pager) {
        pager.setUpdateTime(DateUtils.getNowDate());
        return pagerMapper.updatePager(pager);
    }

    /**
     * 删除试卷对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    @Transactional
    public int deletePagerByIds(String ids) {
        Long[] pagerIds = Convert.toLongArray(ids);
        for (Long pagerId : pagerIds) {
            //删除试卷与考试人关联表
            pagerUserMapper.deletePagerUserByPagerId(pagerId);
            //删除试卷与题目关联表
            questionPagerMapper.deleteQuestionPagerByPagerId(pagerId);
        }
        return pagerMapper.deletePagerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除试卷信息
     *
     * @param id 试卷ID
     * @return 结果
     */
    @Override
    public int deletePagerById(Long id) {
        return pagerMapper.deletePagerById(id);
    }


}
