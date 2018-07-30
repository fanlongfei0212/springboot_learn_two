package com.yinghuaicc.stars.task.dto;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/15 下午6:39
 * @Description: 组织机构返回DTO
 * @Modified:
 */
public class OrgResponseDTO {

    private String id;

    private String name;

    private String parentId;

    private String type;

    private String code;

    private String status;

    private boolean delflag;

    public String getId() {
        return id;
    }

    public OrgResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public OrgResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public OrgResponseDTO setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getType() {
        return type;
    }

    public OrgResponseDTO setType(String type) {
        this.type = type;
        return this;
    }

    public String getCode() {
        return code;
    }

    public OrgResponseDTO setCode(String code) {
        this.code = code;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public OrgResponseDTO setStatus(String status) {
        this.status = status;
        return this;
    }

    public boolean isDelflag() {
        return delflag;
    }

    public OrgResponseDTO setDelflag(boolean delflag) {
        this.delflag = delflag;
        return this;
    }
}
