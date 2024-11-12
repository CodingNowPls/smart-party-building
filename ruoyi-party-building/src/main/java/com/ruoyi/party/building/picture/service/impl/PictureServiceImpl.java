package com.ruoyi.party.building.picture.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.party.building.picture.domain.Picture;
import com.ruoyi.party.building.picture.mapper.PictureMapper;
import com.ruoyi.party.building.picture.service.IPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 首页轮播图Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-25
 */
@Service
public class PictureServiceImpl implements IPictureService {
    @Autowired
    private PictureMapper pictureMapper;

    /**
     * 查询首页轮播图
     *
     * @param id 首页轮播图ID
     * @return 首页轮播图
     */
    @Override
    public Picture selectPictureById(Long id) {
        return pictureMapper.selectPictureById(id);
    }

    /**
     * 查询首页轮播图列表
     *
     * @param picture 首页轮播图
     * @return 首页轮播图
     */
    @Override
    public List<Picture> selectPictureList(Picture picture) {
        return pictureMapper.selectPictureList(picture);
    }

    /**
     * 新增首页轮播图
     *
     * @param picture 首页轮播图
     * @return 结果
     */
    @Override
    public int insertPicture(Picture picture) {
        picture.setCreateTime(DateUtils.getNowDate());
        return pictureMapper.insertPicture(picture);
    }

    /**
     * 修改首页轮播图
     *
     * @param picture 首页轮播图
     * @return 结果
     */
    @Override
    public int updatePicture(Picture picture) {
        picture.setUpdateTime(DateUtils.getNowDate());
        return pictureMapper.updatePicture(picture);
    }

    /**
     * 删除首页轮播图对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePictureByIds(String ids) {
        return pictureMapper.deletePictureByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除首页轮播图信息
     *
     * @param id 首页轮播图ID
     * @return 结果
     */
    @Override
    public int deletePictureById(Long id) {
        return pictureMapper.deletePictureById(id);
    }
}
