package com.ruoyi.web.controller.module.work.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;


/**
 * 任务对象 tb_work
 *
 * @author ruoyi
 * @date 2020-05-15
 */
@Data
public class Work extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long workId;

    /**
     * 标题
     */
    @Excel(name = "标题")
    private String title;

    /**
     * 等级
     */
    @Excel(name = "等级")
    private String grade;

    /**
     * 说明
     */
    @Excel(name = "说明")
    private String introduce;

    /**
     * 开始时间
     */
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm")
    private String startTime;

    /**
     * 截至时间
     */
    @Excel(name = "截至时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm")
    private String endTime;

    /**
     * 操作人id
     */
    @Excel(name = "操作人id")
    private Long userId;

    /**
     * 操作人姓名
     */
    @Excel(name = "操作人姓名")
    private String userName;

    /**
     * 操作时间
     */
    @Excel(name = "操作时间", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date userTime;

    /**
     * 分配给id
     */
    @Excel(name = "分配给id")
    private Long distId;
    private String distIds;

    /**
     * 分配给
     */
    @Excel(name = "分配给")
    private String distName;

    /**
     * 分值
     */
    @Excel(name = "分值")
    private String score;

    /**
     * 文件
     */
    @Excel(name = "文件")
    private String workFile;

    /**
     * 状态(1 待执行 2 执行中3 已完成 4 待验证 5 退回)
     */
    @Excel(name = "状态(1 待执行 2 执行中3 已完成 4 待验证 5 退回)")
    private String status;

}
