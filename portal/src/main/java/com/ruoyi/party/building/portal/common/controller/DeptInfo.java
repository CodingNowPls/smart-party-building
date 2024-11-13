package com.ruoyi.party.building.portal.common.controller;

import lombok.Data;

import java.util.List;

@Data
public class DeptInfo {
    private Long id;
    private String name;
    private Long parentId;
    private List<DeptInfo> children;

}
