package com.ruoyi.party.building.inspect.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.party.building.inspect.domain.Inspect;
import com.ruoyi.party.building.inspect.mapper.InspectMapper;
import com.ruoyi.party.building.inspect.service.IInspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 视察Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-07
 */
@Service
public class InspectServiceImpl implements IInspectService {
    @Autowired
    private InspectMapper inspectMapper;

    /**
     * 查询视察
     *
     * @param inspectId 视察ID
     * @return 视察
     */
    @Override
    public Inspect selectInspectById(Long inspectId) {
        return inspectMapper.selectInspectById(inspectId);
    }

    /**
     * 查询视察列表
     *
     * @param inspect 视察
     * @return 视察
     */
    @Override
    public List<Inspect> selectInspectList(Inspect inspect) {
        return inspectMapper.selectInspectList(inspect);
    }

    /**
     * 新增视察
     *
     * @param inspect 视察
     * @return 结果
     */
    @Override
    public int insertInspect(Inspect inspect) {
        inspect.setCreateBy(ShiroUtils.getLoginName());
        inspect.setCreateTime(DateUtils.getNowDate());
        return inspectMapper.insertInspect(inspect);
    }

    /**
     * 修改视察
     *
     * @param inspect 视察
     * @return 结果
     */
    @Override
    public int updateInspect(Inspect inspect) {
        inspect.setUpdateBy(ShiroUtils.getLoginName());
        inspect.setUpdateTime(DateUtils.getNowDate());
        return inspectMapper.updateInspect(inspect);
    }

    /**
     * 删除视察对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteInspectByIds(String ids) {
        return inspectMapper.deleteInspectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除视察信息
     *
     * @param inspectId 视察ID
     * @return 结果
     */
    @Override
    public int deleteInspectById(Long inspectId) {
        return inspectMapper.deleteInspectById(inspectId);
    }
}
