package com.ruoyi.web.controller.module.questionpager.service;

import java.util.List;

import com.ruoyi.web.controller.module.questionpager.domain.QuestionPager;

/**
 * 题目试卷关联Service接口
 *
 * @author ruoyi
 * @date 2020-06-06
 */
public interface IQuestionPagerService {
    /**
     * 查询题目试卷关联
     *
     * @param id 题目试卷关联ID
     * @return 题目试卷关联
     */
    public QuestionPager selectQuestionPagerById(Long id);

    /**
     * 查询题目试卷关联列表
     *
     * @param questionPager 题目试卷关联
     * @return 题目试卷关联集合
     */
    public List<QuestionPager> selectQuestionPagerList(QuestionPager questionPager);

    /**
     * 新增题目试卷关联
     *
     * @param questionPager 题目试卷关联
     * @return 结果
     */
    public int insertQuestionPager(QuestionPager questionPager);

    /**
     * 修改题目试卷关联
     *
     * @param questionPager 题目试卷关联
     * @return 结果
     */
    public int updateQuestionPager(QuestionPager questionPager);

    /**
     * 批量删除题目试卷关联
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteQuestionPagerByIds(String ids);

    /**
     * 删除题目试卷关联信息
     *
     * @param id 题目试卷关联ID
     * @return 结果
     */
    public int deleteQuestionPagerById(Long id);
}
