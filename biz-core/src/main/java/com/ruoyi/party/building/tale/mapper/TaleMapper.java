package com.ruoyi.party.building.tale.mapper;


import com.ruoyi.party.building.tale.domain.Tale;

import java.util.List;

/**
 * 小组故事Mapper接口
 *
 * @author ruoyi
 * @date 2020-05-09
 */
public interface TaleMapper {
    /**
     * 查询小组故事
     *
     * @param taleId 小组故事ID
     * @return 小组故事
     */
    public Tale selectTaleById(Long taleId);

    /**
     * 查询小组故事列表
     *
     * @param tale 小组故事
     * @return 小组故事集合
     */
    public List<Tale> selectTaleList(Tale tale);

    /**
     * 新增小组故事
     *
     * @param tale 小组故事
     * @return 结果
     */
    public int insertTale(Tale tale);

    /**
     * 修改小组故事
     *
     * @param tale 小组故事
     * @return 结果
     */
    public int updateTale(Tale tale);

    /**
     * 删除小组故事
     *
     * @param taleId 小组故事ID
     * @return 结果
     */
    public int deleteTaleById(Long taleId);

    /**
     * 批量删除小组故事
     *
     * @param taleIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteTaleByIds(String[] taleIds);
}
