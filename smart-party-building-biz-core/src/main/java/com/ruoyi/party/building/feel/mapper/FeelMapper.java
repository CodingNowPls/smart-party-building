package com.ruoyi.party.building.feel.mapper;

import com.ruoyi.party.building.feel.domain.Feel;

import java.util.List;

/**
 * 心得体会Mapper接口
 *
 * @author ruoyi
 * @date 2020-05-09
 */
public interface FeelMapper {
    /**
     * 查询心得体会
     *
     * @param feelId 心得体会ID
     * @return 心得体会
     */
    public Feel selectFeelById(Long feelId);

    /**
     * 查询心得体会列表
     *
     * @param feel 心得体会
     * @return 心得体会集合
     */
    public List<Feel> selectFeelList(Feel feel);

    /**
     * 新增心得体会
     *
     * @param feel 心得体会
     * @return 结果
     */
    public int insertFeel(Feel feel);

    /**
     * 修改心得体会
     *
     * @param feel 心得体会
     * @return 结果
     */
    public int updateFeel(Feel feel);

    /**
     * 删除心得体会
     *
     * @param feelId 心得体会ID
     * @return 结果
     */
    public int deleteFeelById(Long feelId);

    /**
     * 批量删除心得体会
     *
     * @param feelIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteFeelByIds(String[] feelIds);
}
