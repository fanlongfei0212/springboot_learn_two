package com.yinghuaicc.stars.service.region.dto.response;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/18 上午11:07
 * @Description: 组织机构树
 * @Modified:
 */
public class FindCompanyTreeResponseDTO {

    //id
    private String id;

    //类型(公司：company、部门：dept)
    private String type;

    //名称
    private String name;

    //父级id
    private String parentId;

    //子级机构
    List<FindCompanyTreeResponseDTO> childTree = new ArrayList<FindCompanyTreeResponseDTO>();

    public String getId() {
        return id;
    }

    public FindCompanyTreeResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getType() {
        return type;
    }

    public FindCompanyTreeResponseDTO setType(String type) {
        this.type = type;
        return this;
    }

    public String getName() {
        return name;
    }

    public FindCompanyTreeResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public FindCompanyTreeResponseDTO setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public List<FindCompanyTreeResponseDTO> getChildTree() {
        return childTree;
    }

    public FindCompanyTreeResponseDTO setChildTree(List<FindCompanyTreeResponseDTO> childTree) {
        this.childTree = childTree;
        return this;
    }
}
