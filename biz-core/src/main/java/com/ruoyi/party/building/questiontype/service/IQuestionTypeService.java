package com.ruoyi.party.building.questiontype.service;


import com.ruoyi.party.building.questiontype.domain.QuestionType;

import java.util.List;

/**
 * 题库分类Service接口
 *
 * @author ruoyi
 * @date 2020-06-04
 */
public interface IQuestionTypeService {
    /**
     * 查询题库分类
     *
     * @param id 题库分类ID
     * @return 题库分类
     */
    public QuestionType selectQuestionTypeById(Long id);

    /**
     * 查询题库分类列表
     *
     * @param questionType 题库分类
     * @return 题库分类集合
     */
    public List<QuestionType> selectQuestionTypeList(QuestionType questionType);

    /**
     * 新增题库分类
     *
     * @param questionType 题库分类
     * @return 结果
     */
    public int insertQuestionType(QuestionType questionType);

    /**
     * 修改题库分类
     *
     * @param questionType 题库分类
     * @return 结果
     */
    public int updateQuestionType(QuestionType questionType);

    /**
     * 批量删除题库分类
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteQuestionTypeByIds(String ids);

    /**
     * 删除题库分类信息
     *
     * @param id 题库分类ID
     * @return 结果
     */
    public int deleteQuestionTypeById(Long id);
}
