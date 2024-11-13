package com.ruoyi.party.building.answer.mapper;


import com.ruoyi.party.building.answer.domain.PagerAnswer;

import java.util.List;

/**
 * 试卷答案Mapper接口
 *
 * @author ruoyi
 * @date 2020-06-08
 */
public interface PagerAnswerMapper {
    /**
     * 查询试卷答案
     *
     * @param id 试卷答案ID
     * @return 试卷答案
     */
    public PagerAnswer selectPagerAnswerById(Long id);

    /**
     * 查询试卷答案列表
     *
     * @param pagerAnswer 试卷答案
     * @return 试卷答案集合
     */
    public List<PagerAnswer> selectPagerAnswerList(PagerAnswer pagerAnswer);

    /**
     * 新增试卷答案
     *
     * @param pagerAnswer 试卷答案
     * @return 结果
     */
    public int insertPagerAnswer(PagerAnswer pagerAnswer);

    /**
     * 修改试卷答案
     *
     * @param pagerAnswer 试卷答案
     * @return 结果
     */
    public int updatePagerAnswer(PagerAnswer pagerAnswer);

    /**
     * 删除试卷答案
     *
     * @param id 试卷答案ID
     * @return 结果
     */
    public int deletePagerAnswerById(Long id);

    /**
     * 批量删除试卷答案
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePagerAnswerByIds(String[] ids);

    /**
     * 试卷得分总计列表
     *
     * @return
     */
    public List<PagerAnswer> selectTotal(PagerAnswer pagerAnswer);

    /**
     * 查看试卷
     *
     * @param pagerAnswer
     * @return
     */
    public List<PagerAnswer> selectPagerAnswerByPagerId(PagerAnswer pagerAnswer);

    /**
     * 批量添加
     */
    public int insertPagerBatch(List<PagerAnswer> list);
}
