package com.ruoyi.web.controller.module.news.service;

import com.ruoyi.web.controller.module.news.domain.News;

import java.util.List;

/**
 * 资讯Service接口
 *
 * @author ruoyi
 * @date 2020-05-06
 */
public interface INewsService {
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
     * 批量删除资讯
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNewsByIds(String ids);

    /**
     * 删除资讯信息
     *
     * @param newId 资讯ID
     * @return 结果
     */
    public int deleteNewsById(Long newId);

    /**
     * 最新资讯列表
     *
     * @param news 资讯
     * @return 资讯集合
     */
    public List<News> selectNewsListLimit(News news);
}
