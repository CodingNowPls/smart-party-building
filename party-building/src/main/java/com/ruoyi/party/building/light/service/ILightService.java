package com.ruoyi.party.building.light.service;

import com.ruoyi.web.controller.module.light.domain.Light;

import java.util.List;

/**
 * 亮点Service接口
 *
 * @author ruoyi
 * @date 2020-05-08
 */
public interface ILightService {
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
     * 批量删除亮点
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLightByIds(String ids);

    /**
     * 删除亮点信息
     *
     * @param lightId 亮点ID
     * @return 结果
     */
    public int deleteLightById(Long lightId);
}
