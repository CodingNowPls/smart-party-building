package com.ruoyi.party.building.tale.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;

import java.util.Date;


/**
 * 小组故事对象 tb_tale
 *
 * @author ruoyi
 * @date 2020-05-09
 */
@Data
public class Tale extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long taleId;

    /**
     * 部门id
     */
    @Excel(name = "部门id")
    private Long deptId;

    private String deptName;

    /**
     * 提交人id
     */
    @Excel(name = "提交人id")
    private Long userId;

    /**
     * 提交人姓名
     */
    @Excel(name = "提交人姓名")
    private String userName;

    /**
     * 提交时间
     */
    @Excel(name = "提交时间", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date taleTime;

    /**
     * 故事标题
     */
    @Excel(name = "故事标题")
    private String taleTitle;

    /**
     * 故事内容
     */
    @Excel(name = "故事内容")
    private String taleContent;

    /**
     * 故事图片
     */
    @Excel(name = "故事图片")
    private String taleImg;

    /**
     * 故事视频
     */
    @Excel(name = "故事视频")
    private String taleVideo;

    /**
     * 状态（0正常 1关闭）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;

}
