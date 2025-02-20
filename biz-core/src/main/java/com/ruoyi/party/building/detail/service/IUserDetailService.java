package com.ruoyi.party.building.detail.service;


import com.ruoyi.party.building.detail.domain.UserDetail;

import java.util.List;

/**
 * 个人履历Service接口
 *
 * @author ruoyi
 * @date 2020-05-14
 */
public interface IUserDetailService {
    /**
     * 查询个人履历
     *
     * @param detailId 个人履历ID
     * @return 个人履历
     */
    public UserDetail selectUserDetailById(Long detailId);

    /**
     * 查询个人履历列表
     *
     * @param userDetail 个人履历
     * @return 个人履历集合
     */
    public List<UserDetail> selectUserDetailList(UserDetail userDetail);

    /**
     * 新增个人履历
     *
     * @param userDetail 个人履历
     * @return 结果
     */
    public int insertUserDetail(UserDetail userDetail);

    /**
     * 修改个人履历
     *
     * @param userDetail 个人履历
     * @return 结果
     */
    public int updateUserDetail(UserDetail userDetail);

    /**
     * 批量删除个人履历
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserDetailByIds(String ids);

    /**
     * 删除个人履历信息
     *
     * @param detailId 个人履历ID
     * @return 结果
     */
    public int deleteUserDetailById(Long detailId);
}
