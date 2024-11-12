package com.ruoyi.web.controller.module.learn.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;


/**
 * 学习对象 tb_learn
 *
 * @author ruoyi
 * @date 2020-05-21
 */
@Data
public class Learn extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    @Excel(name = "用户id")
    private Long userId;

    /**
     * 用户姓名
     */
    @Excel(name = "用户姓名")
    private String userName;

    private Long deptId;
    private String deptName;


    /**
     * 学分类型 (1 学习 2 签到)
     */
    @Excel(name = "学分类型 (1 学习 2 签到)")
    private String type;

    /**
     * 资讯id
     */
    @Excel(name = "资讯id")
    private Long newId;

    private String newTitle;

    /**
     * 状态 (1 未学习 (未签到) 2 已学习 (已签到))
     */
    @Excel(name = "状态 (1 未学习 (未签到) 2 已学习 (已签到))")
    private String status;


    /**
     * 学分
     */
    @Excel(name = "学分")
    private Long score;

    /**
     * 签到时间
     */
    @Excel(name = "签到时间")
    private String signTime;

}
