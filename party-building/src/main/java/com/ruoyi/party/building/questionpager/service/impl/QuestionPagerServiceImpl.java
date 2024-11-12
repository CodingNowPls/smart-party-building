package com.ruoyi.party.building.questionpager.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.web.controller.module.questionpager.domain.QuestionPager;
import com.ruoyi.web.controller.module.questionpager.mapper.QuestionPagerMapper;
import com.ruoyi.web.controller.module.questionpager.service.IQuestionPagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 题目试卷关联Service业务层处理
 *
 * @author ruoyi
 * @date 2020-06-06
 */
@Service
public class QuestionPagerServiceImpl implements IQuestionPagerService {
    @Autowired
    private QuestionPagerMapper questionPagerMapper;

    /**
     * 查询题目试卷关联
     *
     * @param id 题目试卷关联ID
     * @return 题目试卷关联
     */
    @Override
    public QuestionPager selectQuestionPagerById(Long id) {
        return questionPagerMapper.selectQuestionPagerById(id);
    }

    /**
     * 查询题目试卷关联列表
     *
     * @param questionPager 题目试卷关联
     * @return 题目试卷关联
     */
    @Override
    public List<QuestionPager> selectQuestionPagerList(QuestionPager questionPager) {
        return questionPagerMapper.selectQuestionPagerList(questionPager);
    }

    /**
     * 新增题目试卷关联
     *
     * @param questionPager 题目试卷关联
     * @return 结果
     */
    @Override
    public int insertQuestionPager(QuestionPager questionPager) {
        return questionPagerMapper.insertQuestionPager(questionPager);
    }

    /**
     * 修改题目试卷关联
     *
     * @param questionPager 题目试卷关联
     * @return 结果
     */
    @Override
    public int updateQuestionPager(QuestionPager questionPager) {
        return questionPagerMapper.updateQuestionPager(questionPager);
    }

    /**
     * 删除题目试卷关联对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteQuestionPagerByIds(String ids) {
        return questionPagerMapper.deleteQuestionPagerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除题目试卷关联信息
     *
     * @param id 题目试卷关联ID
     * @return 结果
     */
    @Override
    public int deleteQuestionPagerById(Long id) {
        return questionPagerMapper.deleteQuestionPagerById(id);
    }
}
