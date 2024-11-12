package com.ruoyi.party.building.article.mapper;

import com.ruoyi.web.controller.module.article.domain.Article;

import java.util.List;

/**
 * 分享美文Mapper接口
 *
 * @author ruoyi
 * @date 2020-05-09
 */
public interface ArticleMapper {
    /**
     * 查询分享美文
     *
     * @param articleId 分享美文ID
     * @return 分享美文
     */
    public Article selectArticleById(Long articleId);

    /**
     * 查询分享美文列表
     *
     * @param article 分享美文
     * @return 分享美文集合
     */
    public List<Article> selectArticleList(Article article);

    /**
     * 新增分享美文
     *
     * @param article 分享美文
     * @return 结果
     */
    public int insertArticle(Article article);

    /**
     * 修改分享美文
     *
     * @param article 分享美文
     * @return 结果
     */
    public int updateArticle(Article article);

    /**
     * 删除分享美文
     *
     * @param articleId 分享美文ID
     * @return 结果
     */
    public int deleteArticleById(Long articleId);

    /**
     * 批量删除分享美文
     *
     * @param articleIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteArticleByIds(String[] articleIds);
}
