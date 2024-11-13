package com.ruoyi.party.building.deed.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.ShiroUtils;
import com.ruoyi.party.building.deed.domain.Deed;
import com.ruoyi.party.building.deed.mapper.DeedMapper;
import com.ruoyi.party.building.deed.service.IDeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 事迹Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-08
 */
@Service
public class DeedServiceImpl implements IDeedService {
    @Autowired
    private DeedMapper deedMapper;

    /**
     * 查询事迹
     *
     * @param deedId 事迹ID
     * @return 事迹
     */
    @Override
    public Deed selectDeedById(Long deedId) {
        return deedMapper.selectDeedById(deedId);
    }

    /**
     * 查询事迹列表
     *
     * @param deed 事迹
     * @return 事迹
     */
    @Override
    public List<Deed> selectDeedList(Deed deed) {
        return deedMapper.selectDeedList(deed);
    }

    /**
     * 新增事迹
     *
     * @param deed 事迹
     * @return 结果
     */
    @Override
    public int insertDeed(Deed deed) {
        deed.setCreateBy(ShiroUtils.getLoginName());
        deed.setCreateTime(DateUtils.getNowDate());
        return deedMapper.insertDeed(deed);
    }

    /**
     * 修改事迹
     *
     * @param deed 事迹
     * @return 结果
     */
    @Override
    public int updateDeed(Deed deed) {
        deed.setUpdateBy(ShiroUtils.getLoginName());
        deed.setUpdateTime(DateUtils.getNowDate());
        return deedMapper.updateDeed(deed);
    }

    /**
     * 删除事迹对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDeedByIds(String ids) {
        return deedMapper.deleteDeedByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除事迹信息
     *
     * @param deedId 事迹ID
     * @return 结果
     */
    @Override
    public int deleteDeedById(Long deedId) {
        return deedMapper.deleteDeedById(deedId);
    }
}
