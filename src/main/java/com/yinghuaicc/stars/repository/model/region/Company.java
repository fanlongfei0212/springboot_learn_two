package com.yinghuaicc.stars.repository.model.region;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/26 下午2:59
 * @Description: 城市公司
 * @Modified:
 */
public class Company {

    //城市公司id
    private String id;

    //编号
    private String num;

    //城市公司名称
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

    public Company setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public Company setNum(String num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public Company setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Company setType(Integer type) {
        this.type = type;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Company setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public Company setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Company setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public Company setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
