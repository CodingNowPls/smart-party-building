package com.ruoyi.party.building.type.mapper;

import com.ruoyi.party.building.type.domain.NewsType;

import java.util.List;

/**
 * 资讯分类Mapper接口
 *
 * @author ruoyi
 * @date 2020-05-06
 */
public interface NewsTypeMapper {
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
     * 删除资讯分类
     *
     * @param typeId 资讯分类ID
     * @return 结果
     */
    public int deleteNewsTypeById(Long typeId);

    /**
     * 批量删除资讯分类
     *
     * @param typeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteNewsTypeByIds(String[] typeIds);
}
