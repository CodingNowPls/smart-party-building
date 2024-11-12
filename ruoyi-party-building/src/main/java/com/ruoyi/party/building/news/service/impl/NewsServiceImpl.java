package com.ruoyi.party.building.news.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.party.building.news.domain.News;
import com.ruoyi.party.building.news.mapper.NewsMapper;
import com.ruoyi.party.building.news.service.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 资讯Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-06
 */
@Service
public class NewsServiceImpl implements INewsService {
    @Autowired
    private NewsMapper newsMapper;

    /**
     * 查询资讯
     *
     * @param newId 资讯ID
     * @return 资讯
     */
    @Override
    public News selectNewsById(Long newId) {
        return newsMapper.selectNewsById(newId);
    }

    /**
     * 查询资讯列表
     *
     * @param news 资讯
     * @return 资讯
     */
    @Override
    public List<News> selectNewsList(News news) {
        return newsMapper.selectNewsList(news);
    }

    /**
     * 新增资讯
     *
     * @param news 资讯
     * @return 结果
     */
    @Override
    public int insertNews(News news) {
        news.setCreateBy(ShiroUtils.getLoginName());
        return newsMapper.insertNews(news);
    }

    /**
     * 修改资讯
     *
     * @param news 资讯
     * @return 结果
     */
    @Override
    public int updateNews(News news) {
        news.setUpdateTime(DateUtils.getNowDate());
        return newsMapper.updateNews(news);
    }

    /**
     * 删除资讯对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNewsByIds(String ids) {
        return newsMapper.deleteNewsByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除资讯信息
     *
     * @param newId 资讯ID
     * @return 结果
     */
    @Override
    public int deleteNewsById(Long newId) {
        return newsMapper.deleteNewsById(newId);
    }

    /**
     * 最新资讯列表
     *
     * @param news 资讯
     * @return 资讯集合
     */
    @Override
    public List<News> selectNewsListLimit(News news) {
        return newsMapper.selectNewsListLimit(news);
    }
}
