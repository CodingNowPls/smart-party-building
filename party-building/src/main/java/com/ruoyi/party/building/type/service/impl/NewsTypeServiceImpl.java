package com.ruoyi.party.building.type.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.web.controller.module.type.domain.NewsType;
import com.ruoyi.web.controller.module.type.mapper.NewsTypeMapper;
import com.ruoyi.web.controller.module.type.service.INewsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 资讯分类Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-06
 */
@Service
public class NewsTypeServiceImpl implements INewsTypeService {
    @Autowired
    private NewsTypeMapper newsTypeMapper;

    /**
     * 查询资讯分类
     *
     * @param typeId 资讯分类ID
     * @return 资讯分类
     */
    @Override
    public NewsType selectNewsTypeById(Long typeId) {
        return newsTypeMapper.selectNewsTypeById(typeId);
    }

    /**
     * 查询资讯分类列表
     *
     * @param newsType 资讯分类
     * @return 资讯分类
     */
    @Override
    public List<NewsType> selectNewsTypeList(NewsType newsType) {
        return newsTypeMapper.selectNewsTypeList(newsType);
    }

    /**
     * 新增资讯分类
     *
     * @param newsType 资讯分类
     * @return 结果
     */
    @Override
    public int insertNewsType(NewsType newsType) {
        newsType.setCreateBy(ShiroUtils.getLoginName());
        newsType.setCreateTime(DateUtils.getNowDate());
        return newsTypeMapper.insertNewsType(newsType);
    }

    /**
     * 修改资讯分类
     *
     * @param newsType 资讯分类
     * @return 结果
     */
    @Override
    public int updateNewsType(NewsType newsType) {
        newsType.setUpdateBy(ShiroUtils.getLoginName());
        newsType.setUpdateTime(DateUtils.getNowDate());
        return newsTypeMapper.updateNewsType(newsType);
    }

    /**
     * 删除资讯分类对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNewsTypeByIds(String ids) {
        return newsTypeMapper.deleteNewsTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除资讯分类信息
     *
     * @param typeId 资讯分类ID
     * @return 结果
     */
    @Override
    public int deleteNewsTypeById(Long typeId) {
        return newsTypeMapper.deleteNewsTypeById(typeId);
    }
}
