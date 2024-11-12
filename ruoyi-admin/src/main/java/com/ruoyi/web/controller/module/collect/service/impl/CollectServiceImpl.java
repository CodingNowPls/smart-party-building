package com.ruoyi.web.controller.module.collect.service.impl;

import java.util.List;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.controller.module.collect.domain.Collect;
import com.ruoyi.web.controller.module.collect.service.ICollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.controller.module.collect.mapper.CollectMapper;


/**
 * 学习收藏Service业务层处理
 *
 * @author ruoyi
 * @date 2020-07-10
 */
@Service
public class CollectServiceImpl implements ICollectService {
    @Autowired
    private CollectMapper collectMapper;

    /**
     * 查询学习收藏
     *
     * @param id 学习收藏ID
     * @return 学习收藏
     */
    @Override
    public Collect selectCollectById(Long id) {
        return collectMapper.selectCollectById(id);
    }

    /**
     * 查询学习收藏列表
     *
     * @param collect 学习收藏
     * @return 学习收藏
     */
    @Override
    public List<Collect> selectCollectList(Collect collect) {
        return collectMapper.selectCollectList(collect);
    }

    /**
     * 新增学习收藏
     *
     * @param collect 学习收藏
     * @return 结果
     */
    @Override
    public int insertCollect(Collect collect) {
        collect.setCreateTime(DateUtils.getNowDate());
        return collectMapper.insertCollect(collect);
    }

    /**
     * 修改学习收藏
     *
     * @param collect 学习收藏
     * @return 结果
     */
    @Override
    public int updateCollect(Collect collect) {
        collect.setUpdateTime(DateUtils.getNowDate());
        return collectMapper.updateCollect(collect);
    }

    /**
     * 删除学习收藏对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCollectByIds(String ids) {
        return collectMapper.deleteCollectByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除学习收藏信息
     *
     * @param id 学习收藏ID
     * @return 结果
     */
    @Override
    public int deleteCollectById(Long id) {
        return collectMapper.deleteCollectById(id);
    }
}
