package com.ruoyi.party.building.detail.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.web.controller.module.detail.domain.UserDetail;
import com.ruoyi.web.controller.module.detail.mapper.UserDetailMapper;
import com.ruoyi.web.controller.module.detail.service.IUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 个人履历Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-14
 */
@Service
public class UserDetailServiceImpl implements IUserDetailService {
    @Autowired
    private UserDetailMapper userDetailMapper;

    /**
     * 查询个人履历
     *
     * @param detailId 个人履历ID
     * @return 个人履历
     */
    @Override
    public UserDetail selectUserDetailById(Long detailId) {
        return userDetailMapper.selectUserDetailById(detailId);
    }

    /**
     * 查询个人履历列表
     *
     * @param userDetail 个人履历
     * @return 个人履历
     */
    @Override
    public List<UserDetail> selectUserDetailList(UserDetail userDetail) {
        return userDetailMapper.selectUserDetailList(userDetail);
    }

    /**
     * 新增个人履历
     *
     * @param userDetail 个人履历
     * @return 结果
     */
    @Override
    public int insertUserDetail(UserDetail userDetail) {
        userDetail.setCreateBy(ShiroUtils.getLoginName());
        userDetail.setCreateTime(DateUtils.getNowDate());
        return userDetailMapper.insertUserDetail(userDetail);
    }

    /**
     * 修改个人履历
     *
     * @param userDetail 个人履历
     * @return 结果
     */
    @Override
    public int updateUserDetail(UserDetail userDetail) {
        userDetail.setUpdateBy(ShiroUtils.getLoginName());
        userDetail.setUpdateTime(DateUtils.getNowDate());
        return userDetailMapper.updateUserDetail(userDetail);
    }

    /**
     * 删除个人履历对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUserDetailByIds(String ids) {
        return userDetailMapper.deleteUserDetailByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除个人履历信息
     *
     * @param detailId 个人履历ID
     * @return 结果
     */
    @Override
    public int deleteUserDetailById(Long detailId) {
        return userDetailMapper.deleteUserDetailById(detailId);
    }
}
