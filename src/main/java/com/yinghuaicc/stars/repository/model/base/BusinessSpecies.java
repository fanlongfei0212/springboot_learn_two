package com.yinghuaicc.stars.repository.model.base;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/12 下午3:15
 * @Description:
 * @Modified:
 */
public class BusinessSpecies {

    //id
    private String id;

    //编号
    private String num;

    //业态id
    private String businessFormId;

    //名称
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

    public BusinessSpecies setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public BusinessSpecies setNum(String num) {
        this.num = num;
        return this;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public BusinessSpecies setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public String getName() {
        return name;
    }

    public BusinessSpecies setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public BusinessSpecies setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public BusinessSpecies setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public BusinessSpecies setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public BusinessSpecies setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
