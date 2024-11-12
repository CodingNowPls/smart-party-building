package com.ruoyi.party.building.question.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.party.building.question.domain.Question;
import com.ruoyi.party.building.question.mapper.QuestionMapper;
import com.ruoyi.party.building.question.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 题目Service业务层处理
 *
 * @author ruoyi
 * @date 2020-06-04
 */
@Service
public class QuestionServiceImpl implements IQuestionService {
    @Autowired
    private QuestionMapper questionMapper;

    /**
     * 查询题目
     *
     * @param id 题目ID
     * @return 题目
     */
    @Override
    public Question selectQuestionById(Long id) {
        return questionMapper.selectQuestionById(id);
    }

    /**
     * 查询题目列表
     *
     * @param question 题目
     * @return 题目
     */
    @Override
    public List<Question> selectQuestionList(Question question) {
        return questionMapper.selectQuestionList(question);
    }

    /**
     * 新增题目
     *
     * @param question 题目
     * @return 结果
     */
    @Override
    public int insertQuestion(Question question) {
        question.setCreateTime(DateUtils.getNowDate());
        return questionMapper.insertQuestion(question);
    }

    /**
     * 修改题目
     *
     * @param question 题目
     * @return 结果
     */
    @Override
    public int updateQuestion(Question question) {
        question.setUpdateTime(DateUtils.getNowDate());
        return questionMapper.updateQuestion(question);
    }

    /**
     * 删除题目对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteQuestionByIds(String ids) {
        return questionMapper.deleteQuestionByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除题目信息
     *
     * @param id 题目ID
     * @return 结果
     */
    @Override
    public int deleteQuestionById(Long id) {
        return questionMapper.deleteQuestionById(id);
    }

    /**
     * 通过试卷id获取题目列表
     *
     * @param id
     */
    @Override
    public List<Question> selectQuetionByPagerId(Long id) {
        return questionMapper.selectQuetionByPagerId(id);
    }
}
