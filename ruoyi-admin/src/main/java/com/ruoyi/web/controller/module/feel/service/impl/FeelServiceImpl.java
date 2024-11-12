package com.ruoyi.web.controller.module.feel.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.controller.module.feel.domain.Feel;
import com.ruoyi.web.controller.module.feel.mapper.FeelMapper;
import com.ruoyi.web.controller.module.feel.service.IFeelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 心得体会Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-09
 */
@Service
public class FeelServiceImpl implements IFeelService {
    @Autowired
    private FeelMapper feelMapper;

    /**
     * 查询心得体会
     *
     * @param feelId 心得体会ID
     * @return 心得体会
     */
    @Override
    public Feel selectFeelById(Long feelId) {
        return feelMapper.selectFeelById(feelId);
    }

    /**
     * 查询心得体会列表
     *
     * @param feel 心得体会
     * @return 心得体会
     */
    @Override
    @DataScope(deptAlias = "f")
    public List<Feel> selectFeelList(Feel feel) {
        return feelMapper.selectFeelList(feel);
    }

    /**
     * 新增心得体会
     *
     * @param feel 心得体会
     * @return 结果
     */
    @Override
    public int insertFeel(Feel feel) {
        feel.setCreateTime(DateUtils.getNowDate());
        return feelMapper.insertFeel(feel);
    }

    /**
     * 修改心得体会
     *
     * @param feel 心得体会
     * @return 结果
     */
    @Override
    public int updateFeel(Feel feel) {
        feel.setUpdateTime(DateUtils.getNowDate());
        return feelMapper.updateFeel(feel);
    }

    /**
     * 删除心得体会对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFeelByIds(String ids) {
        return feelMapper.deleteFeelByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除心得体会信息
     *
     * @param feelId 心得体会ID
     * @return 结果
     */
    @Override
    public int deleteFeelById(Long feelId) {
        return feelMapper.deleteFeelById(feelId);
    }
}
