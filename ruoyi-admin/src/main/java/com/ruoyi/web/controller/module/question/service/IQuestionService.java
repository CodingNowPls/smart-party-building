package com.ruoyi.web.controller.module.question.service;

import java.util.List;

import com.ruoyi.web.controller.module.pager.domain.Pager;
import com.ruoyi.web.controller.module.question.domain.Question;
import com.ruoyi.web.controller.module.question.domain.Question;

/**
 * 题目Service接口
 *
 * @author ruoyi
 * @date 2020-06-04
 */
public interface IQuestionService {
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
     * 批量删除题目
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteQuestionByIds(String ids);

    /**
     * 删除题目信息
     *
     * @param id 题目ID
     * @return 结果
     */
    public int deleteQuestionById(Long id);

    /**
     * 通过试卷id获取题目列表
     *
     * @param id
     */
    public List<Question> selectQuetionByPagerId(Long id);
}
