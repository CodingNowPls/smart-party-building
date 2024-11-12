package com.ruoyi.web.controller.module.type.service;

import com.ruoyi.web.controller.module.type.domain.NewsType;

import java.util.List;

/**
 * 资讯分类Service接口
 *
 * @author ruoyi
 * @date 2020-05-06
 */
public interface INewsTypeService {
    /**
     * 查询资讯分类
     *
     * @param typeId 资讯分类ID
     * @return 资讯分类
     */
    public NewsType selectNewsTypeById(Long typeId);

    /**
     * 查询资讯分类列表
     *
     * @param newsType 资讯分类
     * @return 资讯分类集合
     */
    public List<NewsType> selectNewsTypeList(NewsType newsType);

    /**
     * 新增资讯分类
     *
     * @param newsType 资讯分类
     * @return 结果
     */
    public int insertNewsType(NewsType newsType);

    /**
     * 修改资讯分类
     *
     * @param newsType 资讯分类
     * @return 结果
     */
    public int updateNewsType(NewsType newsType);

    /**
     * 批量删除资讯分类
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNewsTypeByIds(String ids);

    /**
     * 删除资讯分类信息
     *
     * @param typeId 资讯分类ID
     * @return 结果
     */
    public int deleteNewsTypeById(Long typeId);
}
