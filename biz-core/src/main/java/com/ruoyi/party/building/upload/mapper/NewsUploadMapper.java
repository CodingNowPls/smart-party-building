package com.ruoyi.party.building.upload.mapper;


import com.ruoyi.party.building.upload.domain.NewsUpload;

import java.util.List;

/**
 * 资讯上传Mapper接口
 *
 * @author ruoyi
 * @date 2020-05-13
 */
public interface NewsUploadMapper {
    /**
     * 查询资讯上传
     *
     * @param id 资讯上传ID
     * @return 资讯上传
     */
    public NewsUpload selectNewsUploadById(Long id);

    /**
     * 查询资讯上传列表
     *
     * @param newsUpload 资讯上传
     * @return 资讯上传集合
     */
    public List<NewsUpload> selectNewsUploadList(NewsUpload newsUpload);

    /**
     * 新增资讯上传
     *
     * @param newsUpload 资讯上传
     * @return 结果
     */
    public int insertNewsUpload(NewsUpload newsUpload);

    /**
     * 修改资讯上传
     *
     * @param newsUpload 资讯上传
     * @return 结果
     */
    public int updateNewsUpload(NewsUpload newsUpload);

    /**
     * 删除资讯上传
     *
     * @param id 资讯上传ID
     * @return 结果
     */
    public int deleteNewsUploadById(Long id);

    /**
     * 批量删除资讯上传
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteNewsUploadByIds(String[] ids);
}
