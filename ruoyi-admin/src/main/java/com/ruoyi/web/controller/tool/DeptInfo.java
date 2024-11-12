package com.ruoyi.web.controller.tool;

import lombok.Data;

import java.util.List;

@Data
public class DeptInfo {
    private Long id;
    private String name;
    private Long parentId;
    private List<DeptInfo> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DeptInfo> getChildren() {
        return children;
    }

    public void setChildren(List<DeptInfo> children) {
        this.children = children;
    }
}
