package com.ruoyi.party.building.pageruser.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.party.building.pageruser.domain.PagerUser;
import com.ruoyi.party.building.pageruser.mapper.PagerUserMapper;
import com.ruoyi.party.building.pageruser.service.IPagerUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 考试对象Service业务层处理
 *
 * @author ruoyi
 * @date 2020-06-19
 */
@Service
public class PagerUserServiceImpl implements IPagerUserService {
    @Autowired
    private PagerUserMapper pagerUserMapper;

    /**
     * 查询考试对象
     *
     * @param id 考试对象ID
     * @return 考试对象
     */
    @Override
    public PagerUser selectPagerUserById(Long id) {
        return pagerUserMapper.selectPagerUserById(id);
    }

    /**
     * 查询考试对象列表
     *
     * @param pagerUser 考试对象
     * @return 考试对象
     */
    @Override
    public List<PagerUser> selectPagerUserList(PagerUser pagerUser) {
        return pagerUserMapper.selectPagerUserList(pagerUser);
    }

    /**
     * 新增考试对象
     *
     * @param pagerUser 考试对象
     * @return 结果
     */
    @Override
    public int insertPagerUser(PagerUser pagerUser) {
        pagerUser.setCreateTime(DateUtils.getNowDate());
        return pagerUserMapper.insertPagerUser(pagerUser);
    }

    /**
     * 修改考试对象
     *
     * @param pagerUser 考试对象
     * @return 结果
     */
    @Override
    public int updatePagerUser(PagerUser pagerUser) {
        pagerUser.setUpdateTime(DateUtils.getNowDate());
        return pagerUserMapper.updatePagerUser(pagerUser);
    }

    /**
     * 删除考试对象对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deletePagerUserByIds(String ids) {
        return pagerUserMapper.deletePagerUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除考试对象信息
     *
     * @param id 考试对象ID
     * @return 结果
     */
    @Override
    public int deletePagerUserById(Long id) {
        return pagerUserMapper.deletePagerUserById(id);
    }

    /**
     * 已考列表
     *
     * @return 考试对象集合
     */
    @Override
    public List<PagerUser> selectPagerUserListOver(PagerUser pagerUser) {
        return pagerUserMapper.selectPagerUserListOver(pagerUser);
    }

}
