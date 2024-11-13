package com.ruoyi.party.building.inspect.mapper;


import com.ruoyi.party.building.inspect.domain.Inspect;

import java.util.List;

/**
 * 视察Mapper接口
 *
 * @author ruoyi
 * @date 2020-05-07
 */
public interface InspectMapper {
    /**
     * 查询视察
     *
     * @param inspectId 视察ID
     * @return 视察
     */
    public Inspect selectInspectById(Long inspectId);

    /**
     * 查询视察列表
     *
     * @param inspect 视察
     * @return 视察集合
     */
    public List<Inspect> selectInspectList(Inspect inspect);

    /**
     * 新增视察
     *
     * @param inspect 视察
     * @return 结果
     */
    public int insertInspect(Inspect inspect);

    /**
     * 修改视察
     *
     * @param inspect 视察
     * @return 结果
     */
    public int updateInspect(Inspect inspect);

    /**
     * 删除视察
     *
     * @param inspectId 视察ID
     * @return 结果
     */
    public int deleteInspectById(Long inspectId);

    /**
     * 批量删除视察
     *
     * @param inspectIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteInspectByIds(String[] inspectIds);
}
