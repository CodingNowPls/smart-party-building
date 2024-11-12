package com.ruoyi.web.controller.module.pager.domain;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 试卷详情 tb_pager
 *
 * @author ruoyi
 * @date 2020-06-05
 */
@Data
public class PagerInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long questionId; //题目id
    private String title; //题目标题

    private Long type; //题目类型 （1.单选题  2.判断题 3 多选题 .4.简答题）

    private List<QuestionOption> optionList; //题目选项

    private String answer; //题目答案

    private String userAnswer; //用户填的答案

    private boolean userFavor; //是否收藏

    private String explain; //答案解析


    public static class QuestionOption {
        private String id;

        private String content;

        public String getId() {
            return this.id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

}

