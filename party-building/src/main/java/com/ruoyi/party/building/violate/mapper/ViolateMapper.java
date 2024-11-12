package com.ruoyi.party.building.violate.mapper;

import com.ruoyi.web.controller.module.violate.domain.Violate;

import java.util.List;

/**
 * 违规违纪Mapper接口
 *
 * @author ruoyi
 * @date 2020-06-22
 */
public interface ViolateMapper {
    /**
     * 查询违规违纪
     *
     * @param id 违规违纪ID
     * @return 违规违纪
     */
    public Violate selectViolateById(Long id);

    /**
     * 查询违规违纪列表
     *
     * @param violate 违规违纪
     * @return 违规违纪集合
     */
    public List<Violate> selectViolateList(Violate violate);

    /**
     * 新增违规违纪
     *
     * @param violate 违规违纪
     * @return 结果
     */
    public int insertViolate(Violate violate);

    /**
     * 修改违规违纪
     *
     * @param violate 违规违纪
     * @return 结果
     */
    public int updateViolate(Violate violate);

    /**
     * 删除违规违纪
     *
     * @param id 违规违纪ID
     * @return 结果
     */
    public int deleteViolateById(Long id);

    /**
     * 批量删除违规违纪
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteViolateByIds(String[] ids);
}
