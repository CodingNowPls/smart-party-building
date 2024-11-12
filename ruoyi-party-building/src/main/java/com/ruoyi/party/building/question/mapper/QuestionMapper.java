package com.ruoyi.party.building.question.mapper;

import com.ruoyi.party.building.question.domain.Question;

import java.util.List;

/**
 * 题目Mapper接口
 *
 * @author ruoyi
 * @date 2020-06-04
 */
public interface QuestionMapper {
    /**
     * 查询题目
     *
     * @param id 题目ID
     * @return 题目
     */
    public Question selectQuestionById(Long id);

    /**
     * 查询题目列表
     *
     * @param question 题目
     * @return 题目集合
     */
    public List<Question> selectQuestionList(Question question);

    /**
     * 新增题目
     *
     * @param question 题目
     * @return 结果
     */
    public int insertQuestion(Question question);

    /**
     * 修改题目
     *
     * @param question 题目
     * @return 结果
     */
    public int updateQuestion(Question question);

    /**
     * 删除题目
     *
     * @param id 题目ID
     * @return 结果
     */
    public int deleteQuestionById(Long id);

    /**
     * 批量删除题目
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteQuestionByIds(String[] ids);

    /**
     * 通过试卷id获取题目列表
     *
     * @param id
     */
    public List<Question> selectQuetionByPagerId(Long id);
}
