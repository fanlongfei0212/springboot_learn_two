package com.yinghuaicc.stars.repository.model.base;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/9 上午11:48
 * @Description: 业态
 * @Modified:
 */
public class BusinessForm {

    //业态id
    private String id;

    //业态编号
    private String num;

    //业态名称
    private String name;

    //修改时间
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

    public BusinessForm setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public BusinessForm setNum(String num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public BusinessForm setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public BusinessForm setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public BusinessForm setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public BusinessForm setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public BusinessForm setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
