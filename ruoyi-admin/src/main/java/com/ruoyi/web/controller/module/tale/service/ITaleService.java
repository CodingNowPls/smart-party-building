package com.ruoyi.web.controller.module.tale.service;

import com.ruoyi.web.controller.module.tale.domain.Tale;

import java.util.List;

/**
 * 小组故事Service接口
 *
 * @author ruoyi
 * @date 2020-05-09
 */
public interface ITaleService {
    /**
     * 查询小组故事
     *
     * @param taleId 小组故事ID
     * @return 小组故事
     */
    public Tale selectTaleById(Long taleId);

    /**
     * 查询小组故事列表
     *
     * @param tale 小组故事
     * @return 小组故事集合
     */
    public List<Tale> selectTaleList(Tale tale);

    /**
     * 新增小组故事
     *
     * @param tale 小组故事
     * @return 结果
     */
    public int insertTale(Tale tale);

    /**
     * 修改小组故事
     *
     * @param tale 小组故事
     * @return 结果
     */
    public int updateTale(Tale tale);

    /**
     * 批量删除小组故事
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTaleByIds(String ids);

    /**
     * 删除小组故事信息
     *
     * @param taleId 小组故事ID
     * @return 结果
     */
    public int deleteTaleById(Long taleId);
}
