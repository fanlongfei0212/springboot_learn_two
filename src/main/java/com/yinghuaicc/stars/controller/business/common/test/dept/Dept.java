package com.yinghuaicc.stars.controller.business.common.test.dept;

import com.yinghuaicc.stars.common.utils.excel.Excel;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/23 下午6:20
 * @Description:
 * @Modified:
 */
public class Dept {

    //id
    @Excel(name = "id")
    private String id;

    //编号
    @Excel(name = "编号")
    private String num;

    //部门名称
    @Excel(name = "部门名称")
    private String name;

    //父id
    @Excel(name = "父id")
    private String parentId;

    //类型（1：内部，2外部：外部系统数据）
    @Excel(name = "类型（1：内部，2外部：外部系统数据）")
    private Integer type;

    //创建时间
    @Excel(name = "创建时间")
    private LocalDateTime createTime;

    //修改时间
    @Excel(name = "修改时间")
    private LocalDateTime modifyTime;

    //创建人
    @Excel(name = "创建人")
    private String createUser;

    //修改人
    @Excel(name = "修改人")
    private String modifyUser;

    public String getId() {
        return id;
    }

    public Dept setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public Dept setNum(String num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public Dept setName(String name) {
        this.name = name;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public Dept setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Dept setType(Integer type) {
        this.type = type;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Dept setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public Dept setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Dept setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public Dept setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
