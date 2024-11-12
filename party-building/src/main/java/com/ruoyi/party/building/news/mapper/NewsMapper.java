package com.ruoyi.party.building.news.mapper;

import com.ruoyi.web.controller.module.news.domain.News;

import java.util.List;

/**
 * 资讯Mapper接口
 *
 * @author ruoyi
 * @date 2020-05-06
 */
public interface NewsMapper {
    /**
     * 查询资讯
     *
     * @param newId 资讯ID
     * @return 资讯
     */
    public News selectNewsById(Long newId);

    /**
     * 查询资讯列表
     *
     * @param news 资讯
     * @return 资讯集合
     */
    public List<News> selectNewsList(News news);

    /**
     * 新增资讯
     *
     * @param news 资讯
     * @return 结果
     */
    public int insertNews(News news);

    /**
     * 修改资讯
     *
     * @param news 资讯
     * @return 结果
     */
    public int updateNews(News news);

    /**
     * 删除资讯
     *
     * @param newId 资讯ID
     * @return 结果
     */
    public int deleteNewsById(Long newId);

    /**
     * 批量删除资讯
     *
     * @param newIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteNewsByIds(String[] newIds);

    /**
     * 最新资讯列表
     *
     * @param news 资讯
     * @return 资讯集合
     */
    public List<News> selectNewsListLimit(News news);
}
