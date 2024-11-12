package com.ruoyi.party.building.questiontype.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.controller.module.questiontype.domain.QuestionType;
import com.ruoyi.web.controller.module.questiontype.mapper.QuestionTypeMapper;
import com.ruoyi.web.controller.module.questiontype.service.IQuestionTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 题库分类Service业务层处理
 *
 * @author ruoyi
 * @date 2020-06-04
 */
@Service
public class QuestionTypeServiceImpl implements IQuestionTypeService {
    @Autowired
    private QuestionTypeMapper questionTypeMapper;

    /**
     * 查询题库分类
     *
     * @param id 题库分类ID
     * @return 题库分类
     */
    @Override
    public QuestionType selectQuestionTypeById(Long id) {
        return questionTypeMapper.selectQuestionTypeById(id);
    }

    /**
     * 查询题库分类列表
     *
     * @param questionType 题库分类
     * @return 题库分类
     */
    @Override
    public List<QuestionType> selectQuestionTypeList(QuestionType questionType) {
        return questionTypeMapper.selectQuestionTypeList(questionType);
    }

    /**
     * 新增题库分类
     *
     * @param questionType 题库分类
     * @return 结果
     */
    @Override
    public int insertQuestionType(QuestionType questionType) {
        questionType.setCreateTime(DateUtils.getNowDate());
        return questionTypeMapper.insertQuestionType(questionType);
    }

    /**
     * 修改题库分类
     *
     * @param questionType 题库分类
     * @return 结果
     */
    @Override
    public int updateQuestionType(QuestionType questionType) {
        questionType.setUpdateTime(DateUtils.getNowDate());
        return questionTypeMapper.updateQuestionType(questionType);
    }

    /**
     * 删除题库分类对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteQuestionTypeByIds(String ids) {
        return questionTypeMapper.deleteQuestionTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除题库分类信息
     *
     * @param id 题库分类ID
     * @return 结果
     */
    @Override
    public int deleteQuestionTypeById(Long id) {
        return questionTypeMapper.deleteQuestionTypeById(id);
    }
}
