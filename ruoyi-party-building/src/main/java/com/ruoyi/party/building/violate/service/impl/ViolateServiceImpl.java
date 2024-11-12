package com.ruoyi.party.building.violate.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.party.building.violate.domain.Violate;
import com.ruoyi.party.building.violate.mapper.ViolateMapper;
import com.ruoyi.party.building.violate.service.IViolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 违规违纪Service业务层处理
 *
 * @author ruoyi
 * @date 2020-06-22
 */
@Service
public class ViolateServiceImpl implements IViolateService {
    @Autowired
    private ViolateMapper violateMapper;

    /**
     * 查询违规违纪
     *
     * @param id 违规违纪ID
     * @return 违规违纪
     */
    @Override
    public Violate selectViolateById(Long id) {
        return violateMapper.selectViolateById(id);
    }

    /**
     * 查询违规违纪列表
     *
     * @param violate 违规违纪
     * @return 违规违纪
     */
    @Override
    public List<Violate> selectViolateList(Violate violate) {
        return violateMapper.selectViolateList(violate);
    }

    /**
     * 新增违规违纪
     *
     * @param violate 违规违纪
     * @return 结果
     */
    @Override
    public int insertViolate(Violate violate) {
        violate.setCreateTime(DateUtils.getNowDate());
        return violateMapper.insertViolate(violate);
    }

    /**
     * 修改违规违纪
     *
     * @param violate 违规违纪
     * @return 结果
     */
    @Override
    public int updateViolate(Violate violate) {
        violate.setUpdateTime(DateUtils.getNowDate());
        return violateMapper.updateViolate(violate);
    }

    /**
     * 删除违规违纪对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteViolateByIds(String ids) {
        return violateMapper.deleteViolateByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除违规违纪信息
     *
     * @param id 违规违纪ID
     * @return 结果
     */
    @Override
    public int deleteViolateById(Long id) {
        return violateMapper.deleteViolateById(id);
    }
}
