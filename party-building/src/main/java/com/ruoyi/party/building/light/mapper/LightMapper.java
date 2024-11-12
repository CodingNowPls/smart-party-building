package com.ruoyi.party.building.light.mapper;

import com.ruoyi.web.controller.module.light.domain.Light;

import java.util.List;

/**
 * 亮点Mapper接口
 *
 * @author ruoyi
 * @date 2020-05-08
 */
public interface LightMapper {
    /**
     * 查询亮点
     *
     * @param lightId 亮点ID
     * @return 亮点
     */
    public Light selectLightById(Long lightId);

    /**
     * 查询亮点列表
     *
     * @param light 亮点
     * @return 亮点集合
     */
    public List<Light> selectLightList(Light light);

    /**
     * 新增亮点
     *
     * @param light 亮点
     * @return 结果
     */
    public int insertLight(Light light);

    /**
     * 修改亮点
     *
     * @param light 亮点
     * @return 结果
     */
    public int updateLight(Light light);

    /**
     * 删除亮点
     *
     * @param lightId 亮点ID
     * @return 结果
     */
    public int deleteLightById(Long lightId);

    /**
     * 批量删除亮点
     *
     * @param lightIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteLightByIds(String[] lightIds);
}
