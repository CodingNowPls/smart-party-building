package com.ruoyi.web.controller.module.deed.mapper;

import com.ruoyi.web.controller.module.deed.domain.Deed;

import java.util.List;

/**
 * 事迹Mapper接口
 *
 * @author ruoyi
 * @date 2020-05-08
 */
public interface DeedMapper {
    /**
     * 查询事迹
     *
     * @param deedId 事迹ID
     * @return 事迹
     */
    public Deed selectDeedById(Long deedId);

    /**
     * 查询事迹列表
     *
     * @param deed 事迹
     * @return 事迹集合
     */
    public List<Deed> selectDeedList(Deed deed);

    /**
     * 新增事迹
     *
     * @param deed 事迹
     * @return 结果
     */
    public int insertDeed(Deed deed);

    /**
     * 修改事迹
     *
     * @param deed 事迹
     * @return 结果
     */
    public int updateDeed(Deed deed);

    /**
     * 删除事迹
     *
     * @param deedId 事迹ID
     * @return 结果
     */
    public int deleteDeedById(Long deedId);

    /**
     * 批量删除事迹
     *
     * @param deedIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteDeedByIds(String[] deedIds);
}
