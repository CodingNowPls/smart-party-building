package com.ruoyi.web.controller.module.pageruser.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 考试对象对象 tb_pager_user
 *
 * @author ruoyi
 * @date 2020-06-19
 */
@Data
public class PagerUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    /**
     * 考试对象
     */
    @Excel(name = "考试对象")
    private Long userId;
    private String userName;

    /**
     * 试卷id
     */
    @Excel(name = "试卷id")
    private Long pagerId;
    private String pagerName;

    private String pagerStatus;

    /**
     * 得分
     */
    @Excel(name = "得分")
    private Long mark;

    /**
     * 状态（0未开始 1进行中2 考试结束）
     */
    @Excel(name = "状态", readConverterExp = "0=未开始,1=进行中2,考=试结束")
    private String status;

    /**
     * 确认最后分数(0未确认 1已确认)
     */
    @Excel(name = "确认最后分数(0未确认 1已确认)")
    private String confirm;

}
