package com.ruoyi.party.building.feel.service;

import com.ruoyi.web.controller.module.feel.domain.Feel;

import java.util.List;

/**
 * 心得体会Service接口
 *
 * @author ruoyi
 * @date 2020-05-09
 */
public interface IFeelService {
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
     * 批量删除心得体会
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFeelByIds(String ids);

    /**
     * 删除心得体会信息
     *
     * @param feelId 心得体会ID
     * @return 结果
     */
    public int deleteFeelById(Long feelId);
}
