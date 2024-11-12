package com.ruoyi.party.building.article.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.party.building.article.domain.Article;
import com.ruoyi.party.building.article.mapper.ArticleMapper;
import com.ruoyi.party.building.article.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 分享美文Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-09
 */
@Service
public class ArticleServiceImpl implements IArticleService {
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 查询分享美文
     *
     * @param articleId 分享美文ID
     * @return 分享美文
     */
    @Override
    public Article selectArticleById(Long articleId) {
        return articleMapper.selectArticleById(articleId);
    }

    /**
     * 查询分享美文列表
     *
     * @param article 分享美文
     * @return 分享美文
     */
    @Override
    @DataScope(deptAlias = "a")
    public List<Article> selectArticleList(Article article) {
        return articleMapper.selectArticleList(article);
    }

    /**
     * 新增分享美文
     *
     * @param article 分享美文
     * @return 结果
     */
    @Override
    public int insertArticle(Article article) {
        article.setCreateTime(DateUtils.getNowDate());
        return articleMapper.insertArticle(article);
    }

    /**
     * 修改分享美文
     *
     * @param article 分享美文
     * @return 结果
     */
    @Override
    public int updateArticle(Article article) {
        article.setUpdateTime(DateUtils.getNowDate());
        return articleMapper.updateArticle(article);
    }

    /**
     * 删除分享美文对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteArticleByIds(String ids) {
        return articleMapper.deleteArticleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除分享美文信息
     *
     * @param articleId 分享美文ID
     * @return 结果
     */
    @Override
    public int deleteArticleById(Long articleId) {
        return articleMapper.deleteArticleById(articleId);
    }
}
