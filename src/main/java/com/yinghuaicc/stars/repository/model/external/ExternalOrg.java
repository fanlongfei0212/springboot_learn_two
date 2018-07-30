package com.yinghuaicc.stars.repository.model.external;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/17 下午1:40
 * @Description: 外部组织架构数据
 * @Modified:
 */
public class ExternalOrg {

    private String id;

    //名称
    private String name;

    //上级 parentId
    private String parentId;

    //类型
    private String type;

    private String code;

    private String status;

    private boolean delflag;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    //创建用户
    private String createUser;

    //修改用户
    private String modifyUser;

    public String getId() {
        return id;
    }

    public ExternalOrg setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ExternalOrg setName(String name) {
        this.name = name;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public ExternalOrg setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public String getType() {
        return type;
    }

    public ExternalOrg setType(String type) {
        this.type = type;
        return this;
    }

    public String getCode() {
        return code;
    }

    public ExternalOrg setCode(String code) {
        this.code = code;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ExternalOrg setStatus(String status) {
        this.status = status;
        return this;
    }

    public boolean isDelflag() {
        return delflag;
    }

    public ExternalOrg setDelflag(boolean delflag) {
        this.delflag = delflag;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ExternalOrg setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public ExternalOrg setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public ExternalOrg setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public ExternalOrg setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
