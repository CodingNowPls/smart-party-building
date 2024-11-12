package com.ruoyi.party.building.pageruser.service;

import com.ruoyi.web.controller.module.pageruser.domain.PagerUser;

import java.util.List;

/**
 * 考试对象Service接口
 *
 * @author ruoyi
 * @date 2020-06-19
 */
public interface IPagerUserService {
    /**
     * 查询考试对象
     *
     * @param id 考试对象ID
     * @return 考试对象
     */
    public PagerUser selectPagerUserById(Long id);

    /**
     * 查询考试对象列表
     *
     * @param pagerUser 考试对象
     * @return 考试对象集合
     */
    public List<PagerUser> selectPagerUserList(PagerUser pagerUser);

    /**
     * 新增考试对象
     *
     * @param pagerUser 考试对象
     * @return 结果
     */
    public int insertPagerUser(PagerUser pagerUser);

    /**
     * 修改考试对象
     *
     * @param pagerUser 考试对象
     * @return 结果
     */
    public int updatePagerUser(PagerUser pagerUser);

    /**
     * 批量删除考试对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deletePagerUserByIds(String ids);

    /**
     * 删除考试对象信息
     *
     * @param id 考试对象ID
     * @return 结果
     */
    public int deletePagerUserById(Long id);

    /**
     * 已考列表
     *
     * @return 考试对象集合
     */
    public List<PagerUser> selectPagerUserListOver(PagerUser pagerUser);
}
