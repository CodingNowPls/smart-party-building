package com.ruoyi.party.building.picture.service;


import com.ruoyi.party.building.picture.domain.Picture;

import java.util.List;

/**
 * 首页轮播图Service接口
 *
 * @author ruoyi
 * @date 2020-05-25
 */
public interface IPictureService {
    /**
     * 查询首页轮播图
     *
     * @param id 首页轮播图ID
     * @return 首页轮播图
     */
    public Picture selectPictureById(Long id);

    /**
     * 查询首页轮播图列表
     *
     * @param picture 首页轮播图
     * @return 首页轮播图集合
     */
    public List<Picture> selectPictureList(Picture picture);

    /**
     * 新增首页轮播图
     *
     * @param picture 首页轮播图
     * @return 结果
     */
    public int insertPicture(Picture picture);

    /**
     * 修改首页轮播图
     *
     * @param picture 首页轮播图
     * @return 结果
     */
    public int updatePicture(Picture picture);

    /**
     * 批量删除首页轮播图
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePictureByIds(String ids);

    /**
     * 删除首页轮播图信息
     *
     * @param id 首页轮播图ID
     * @return 结果
     */
    public int deletePictureById(Long id);
}
