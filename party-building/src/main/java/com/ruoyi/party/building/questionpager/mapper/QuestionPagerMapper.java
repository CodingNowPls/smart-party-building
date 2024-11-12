package com.ruoyi.party.building.questionpager.mapper;

import com.ruoyi.web.controller.module.questionpager.domain.QuestionPager;

import java.util.List;

/**
 * 题目试卷关联Mapper接口
 *
 * @author ruoyi
 * @date 2020-06-06
 */
public interface QuestionPagerMapper {
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
     * 删除题目试卷关联
     *
     * @param id 题目试卷关联ID
     * @return 结果
     */
    public int deleteQuestionPagerById(Long id);

    /**
     * 批量删除题目试卷关联
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteQuestionPagerByIds(String[] ids);

    public int deleteQuestionPagerByPagerId(Long pagerId);

    /**
     * 批量添加
     */
    public int batchQutionPager(List<QuestionPager> list);
}
