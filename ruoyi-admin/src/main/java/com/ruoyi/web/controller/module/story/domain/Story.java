package com.ruoyi.web.controller.module.story.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;


/**
 * 故事对象 tb_story
 *
 * @author ruoyi
 * @date 2020-05-08
 */
@Data
public class Story extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long storyId;

    /**
     * 故事标题
     */
    @Excel(name = "故事标题")
    private String storyTitle;

    /**
     * 封面图
     */
    @Excel(name = "封面图")
    private String storyPic;

    /**
     * 故事内容
     */
    @Excel(name = "故事内容")
    private String storyContent;

    /**
     * 状态（0正常 1关闭）
     */
    @Excel(name = "状态", readConverterExp = "0=正常,1=关闭")
    private String status;

}
