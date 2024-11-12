package com.ruoyi.party.building.tale.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.controller.module.tale.domain.Tale;
import com.ruoyi.web.controller.module.tale.mapper.TaleMapper;
import com.ruoyi.web.controller.module.tale.service.ITaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 小组故事Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-09
 */
@Service
public class TaleServiceImpl implements ITaleService {
    @Autowired
    private TaleMapper taleMapper;

    /**
     * 查询小组故事
     *
     * @param taleId 小组故事ID
     * @return 小组故事
     */
    @Override
    public Tale selectTaleById(Long taleId) {
        return taleMapper.selectTaleById(taleId);
    }

    /**
     * 查询小组故事列表
     *
     * @param tale 小组故事
     * @return 小组故事
     */
    @Override
    @DataScope(deptAlias = "t")
    public List<Tale> selectTaleList(Tale tale) {
        return taleMapper.selectTaleList(tale);
    }

    /**
     * 新增小组故事
     *
     * @param tale 小组故事
     * @return 结果
     */
    @Override
    public int insertTale(Tale tale) {
        tale.setCreateTime(DateUtils.getNowDate());
        return taleMapper.insertTale(tale);
    }

    /**
     * 修改小组故事
     *
     * @param tale 小组故事
     * @return 结果
     */
    @Override
    public int updateTale(Tale tale) {
        tale.setUpdateTime(DateUtils.getNowDate());
        return taleMapper.updateTale(tale);
    }

    /**
     * 删除小组故事对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTaleByIds(String ids) {
        return taleMapper.deleteTaleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小组故事信息
     *
     * @param taleId 小组故事ID
     * @return 结果
     */
    @Override
    public int deleteTaleById(Long taleId) {
        return taleMapper.deleteTaleById(taleId);
    }
}
