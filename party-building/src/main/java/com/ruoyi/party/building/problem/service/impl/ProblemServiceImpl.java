package com.ruoyi.party.building.problem.service.impl;

import com.ruoyi.common.annotation.DataScope;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.web.controller.module.problem.domain.Problem;
import com.ruoyi.web.controller.module.problem.mapper.ProblemMapper;
import com.ruoyi.web.controller.module.problem.service.IProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 问题墙Service业务层处理
 *
 * @author ruoyi
 * @date 2020-05-11
 */
@Service
public class ProblemServiceImpl implements IProblemService {
    @Autowired
    private ProblemMapper problemMapper;

    /**
     * 查询问题墙
     *
     * @param problemId 问题墙ID
     * @return 问题墙
     */
    @Override
    public Problem selectProblemById(Long problemId) {
        return problemMapper.selectProblemById(problemId);
    }

    /**
     * 查询问题墙列表
     *
     * @param problem 问题墙
     * @return 问题墙
     */
    @Override
    @DataScope(deptAlias = "p")
    public List<Problem> selectProblemList(Problem problem) {
        return problemMapper.selectProblemList(problem);
    }

    /**
     * 新增问题墙
     *
     * @param problem 问题墙
     * @return 结果
     */
    @Override
    public int insertProblem(Problem problem) {
        problem.setCreateTime(DateUtils.getNowDate());
        return problemMapper.insertProblem(problem);
    }

    /**
     * 修改问题墙
     *
     * @param problem 问题墙
     * @return 结果
     */
    @Override
    public int updateProblem(Problem problem) {
        problem.setUpdateTime(DateUtils.getNowDate());
        return problemMapper.updateProblem(problem);
    }

    /**
     * 删除问题墙对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteProblemByIds(String ids) {
        return problemMapper.deleteProblemByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除问题墙信息
     *
     * @param problemId 问题墙ID
     * @return 结果
     */
    @Override
    public int deleteProblemById(Long problemId) {
        return problemMapper.deleteProblemById(problemId);
    }
}
