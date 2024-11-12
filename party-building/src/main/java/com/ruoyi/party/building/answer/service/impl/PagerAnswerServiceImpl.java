package com.ruoyi.party.building.answer.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.controller.module.answer.domain.PagerAnswer;
import com.ruoyi.web.controller.module.answer.mapper.PagerAnswerMapper;
import com.ruoyi.web.controller.module.answer.service.IPagerAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 试卷答案Service业务层处理
 *
 * @author ruoyi
 * @date 2020-06-08
 */
@Service
public class PagerAnswerServiceImpl implements IPagerAnswerService {
    @Autowired
    private PagerAnswerMapper pagerAnswerMapper;

    /**
     * 查询试卷答案
     *
     * @param id 试卷答案ID
     * @return 试卷答案
     */
    @Override
    public PagerAnswer selectPagerAnswerById(Long id) {
        return pagerAnswerMapper.selectPagerAnswerById(id);
    }

    /**
     * 查询试卷答案列表
     *
     * @param pagerAnswer 试卷答案
     * @return 试卷答案
     */
    @Override
    public List<PagerAnswer> selectPagerAnswerList(PagerAnswer pagerAnswer) {
        return pagerAnswerMapper.selectPagerAnswerList(pagerAnswer);
    }

    /**
     * 新增试卷答案
     *
     * @param pagerAnswer 试卷答案
     * @return 结果
     */
    @Override
    public int insertPagerAnswer(PagerAnswer pagerAnswer) {
        pagerAnswer.setCreateTime(DateUtils.getNowDate());
        return pagerAnswerMapper.insertPagerAnswer(pagerAnswer);
    }

    /**
     * 修改试卷答案
     *
     * @param pagerAnswer 试卷答案
     * @return 结果
     */
    @Override
    public int updatePagerAnswer(PagerAnswer pagerAnswer) {
        pagerAnswer.setUpdateTime(DateUtils.getNowDate());
        return pagerAnswerMapper.updatePagerAnswer(pagerAnswer);
    }

    /**
     * 删除试卷答案对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePagerAnswerByIds(String ids) {
        return pagerAnswerMapper.deletePagerAnswerByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除试卷答案信息
     *
     * @param id 试卷答案ID
     * @return 结果
     */
    @Override
    public int deletePagerAnswerById(Long id) {
        return pagerAnswerMapper.deletePagerAnswerById(id);
    }

    /**
     * 试卷得分总计列表
     *
     * @return
     */
    public List<PagerAnswer> selectTotal(PagerAnswer pagerAnswer) {
        return pagerAnswerMapper.selectTotal(pagerAnswer);
    }

    /**
     * 查看试卷
     *
     * @param pagerAnswer
     * @return
     */
    public List<PagerAnswer> selectPagerAnswerByPagerId(PagerAnswer pagerAnswer) {
        return pagerAnswerMapper.selectPagerAnswerByPagerId(pagerAnswer);
    }

    /**
     * 批量添加
     */
    public int insertPagerBatch(List<PagerAnswer> list) {
        return pagerAnswerMapper.insertPagerBatch(list);
    }
}
