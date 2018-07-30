package com.yinghuaicc.stars.repository.model.tissue;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/27 下午6:16
 * @Description: 部门
 * @Modified:
 */
public class Department {

    //id
    private String id;

    //编号
    private String num;

    //部门名称
    private String name;

    //父id
    private String parentId;

    //类型（1：内部，2外部：外部系统数据）
    private Integer type;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    //创建人
    private String createUser;

    //修改人
    private String modifyUser;

    public String getId() {
        return id;
    }

    public Department setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public Department setNum(String num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public Department setName(String name) {
        this.name = name;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public Department setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Department setType(Integer type) {
        this.type = type;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Department setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public Department setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Department setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public Department setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
