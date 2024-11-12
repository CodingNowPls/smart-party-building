package com.ruoyi.party.building.light.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.web.controller.module.light.domain.Light;
import com.ruoyi.web.controller.module.light.mapper.LightMapper;
import com.ruoyi.web.controller.module.light.service.ILightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 亮点Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-08
 */
@Service
public class LightServiceImpl implements ILightService {
    @Autowired
    private LightMapper lightMapper;

    /**
     * 查询亮点
     *
     * @param lightId 亮点ID
     * @return 亮点
     */
    @Override
    public Light selectLightById(Long lightId) {
        return lightMapper.selectLightById(lightId);
    }

    /**
     * 查询亮点列表
     *
     * @param light 亮点
     * @return 亮点
     */
    @Override
    public List<Light> selectLightList(Light light) {
        return lightMapper.selectLightList(light);
    }

    /**
     * 新增亮点
     *
     * @param light 亮点
     * @return 结果
     */
    @Override
    public int insertLight(Light light) {
        light.setCreateBy(ShiroUtils.getLoginName());
        light.setCreateTime(DateUtils.getNowDate());
        return lightMapper.insertLight(light);
    }

    /**
     * 修改亮点
     *
     * @param light 亮点
     * @return 结果
     */
    @Override
    public int updateLight(Light light) {
        light.setUpdateBy(ShiroUtils.getLoginName());
        light.setUpdateTime(DateUtils.getNowDate());
        return lightMapper.updateLight(light);
    }

    /**
     * 删除亮点对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteLightByIds(String ids) {
        return lightMapper.deleteLightByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除亮点信息
     *
     * @param lightId 亮点ID
     * @return 结果
     */
    @Override
    public int deleteLightById(Long lightId) {
        return lightMapper.deleteLightById(lightId);
    }
}
