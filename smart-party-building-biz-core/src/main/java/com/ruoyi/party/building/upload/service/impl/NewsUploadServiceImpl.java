package com.ruoyi.party.building.upload.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.party.building.upload.domain.NewsUpload;
import com.ruoyi.party.building.upload.mapper.NewsUploadMapper;
import com.ruoyi.party.building.upload.service.INewsUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 资讯上传Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-13
 */
@Service
public class NewsUploadServiceImpl implements INewsUploadService {
    @Autowired
    private NewsUploadMapper newsUploadMapper;

    /**
     * 查询资讯上传
     *
     * @param id 资讯上传ID
     * @return 资讯上传
     */
    @Override
    public NewsUpload selectNewsUploadById(Long id) {
        return newsUploadMapper.selectNewsUploadById(id);
    }

    /**
     * 查询资讯上传列表
     *
     * @param newsUpload 资讯上传
     * @return 资讯上传
     */
    @Override
    public List<NewsUpload> selectNewsUploadList(NewsUpload newsUpload) {
        return newsUploadMapper.selectNewsUploadList(newsUpload);
    }

    /**
     * 新增资讯上传
     *
     * @param newsUpload 资讯上传
     * @return 结果
     */
    @Override
    public int insertNewsUpload(NewsUpload newsUpload) {
        newsUpload.setCreateBy(ShiroUtils.getLoginName());
        newsUpload.setCreateTime(DateUtils.getNowDate());
        return newsUploadMapper.insertNewsUpload(newsUpload);
    }

    /**
     * 修改资讯上传
     *
     * @param newsUpload 资讯上传
     * @return 结果
     */
    @Override
    public int updateNewsUpload(NewsUpload newsUpload) {
        newsUpload.setUpdateBy(ShiroUtils.getLoginName());
        newsUpload.setUpdateTime(DateUtils.getNowDate());
        return newsUploadMapper.updateNewsUpload(newsUpload);
    }

    /**
     * 删除资讯上传对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteNewsUploadByIds(String ids) {
        return newsUploadMapper.deleteNewsUploadByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除资讯上传信息
     *
     * @param id 资讯上传ID
     * @return 结果
     */
    @Override
    public int deleteNewsUploadById(Long id) {
        return newsUploadMapper.deleteNewsUploadById(id);
    }
}
