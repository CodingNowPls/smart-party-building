package com.ruoyi.web.controller.module.upload.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 资讯上传对象 tb_news_upload
 *
 * @author ruoyi
 * @date 2020-05-13
 */
@Data
public class NewsUpload extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long id;

    /**
     * 资讯id
     */
    @Excel(name = "资讯id")
    private Long newId;

    /**
     * 上传文件地址
     */
    @Excel(name = "上传文件地址")
    private String newFile;

    /**
     * 上传视频地址
     */
    @Excel(name = "上传视频地址")
    private String newVideo;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private String status;

}
