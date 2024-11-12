package com.ruoyi.party.building.problem.mapper;

import com.ruoyi.web.controller.module.problem.domain.Problem;

import java.util.List;

/**
 * 问题墙Mapper接口
 *
 * @author ruoyi
 * @date 2020-05-11
 */
public interface ProblemMapper {
    /**
     * 查询问题墙
     *
     * @param problemId 问题墙ID
     * @return 问题墙
     */
    public Problem selectProblemById(Long problemId);

    /**
     * 查询问题墙列表
     *
     * @param problem 问题墙
     * @return 问题墙集合
     */
    public List<Problem> selectProblemList(Problem problem);

    /**
     * 新增问题墙
     *
     * @param problem 问题墙
     * @return 结果
     */
    public int insertProblem(Problem problem);

    /**
     * 修改问题墙
     *
     * @param problem 问题墙
     * @return 结果
     */
    public int updateProblem(Problem problem);

    /**
     * 删除问题墙
     *
     * @param problemId 问题墙ID
     * @return 结果
     */
    public int deleteProblemById(Long problemId);

    /**
     * 批量删除问题墙
     *
     * @param problemIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteProblemByIds(String[] problemIds);
}
