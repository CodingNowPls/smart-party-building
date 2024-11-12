package com.ruoyi.web.controller.module.problem.service;

import java.util.List;

import com.ruoyi.web.controller.module.problem.domain.Problem;

/**
 * 问题墙Service接口
 *
 * @author ruoyi
 * @date 2020-05-11
 */
public interface IProblemService {
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
     * 批量删除问题墙
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteProblemByIds(String ids);

    /**
     * 删除问题墙信息
     *
     * @param problemId 问题墙ID
     * @return 结果
     */
    public int deleteProblemById(Long problemId);
}
