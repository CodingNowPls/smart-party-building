package com.ruoyi.party.building.pager.mapper;

import com.ruoyi.party.building.pager.domain.Pager;

import java.util.List;

/**
 * 试卷Mapper接口
 *
 * @author ruoyi
 * @date 2020-06-05
 */
public interface PagerMapper {
    /**
     * 查询试卷
     *
     * @param id 试卷ID
     * @return 试卷
     */
    public Pager selectPagerById(Long id);

    /**
     * 查询试卷列表
     *
     * @param pager 试卷
     * @return 试卷集合
     */
    public List<Pager> selectPagerList(Pager pager);

    /**
     * 新增试卷
     *
     * @param pager 试卷
     * @return 结果
     */
    public int insertPager(Pager pager);

    /**
     * 修改试卷
     *
     * @param pager 试卷
     * @return 结果
     */
    public int updatePager(Pager pager);

    /**
     * 删除试卷
     *
     * @param id 试卷ID
     * @return 结果
     */
    public int deletePagerById(Long id);

    /**
     * 批量删除试卷
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePagerByIds(String[] ids);


}
