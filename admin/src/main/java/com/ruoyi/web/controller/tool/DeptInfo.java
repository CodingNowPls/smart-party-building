package com.ruoyi.web.controller.tool;

import lombok.Data;

import java.util.List;

@Data
public class DeptInfo {
    private Long id;
    private String name;
    private Long parentId;
    private List<DeptInfo> children;

}
