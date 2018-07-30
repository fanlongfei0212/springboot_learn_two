package com.yinghuaicc.stars.service.base.dto.response;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/9 下午11:50
 * @Description: 业种详情
 * @Modified:
 */
public class FindBusinessSpeciesByIdResponseDTO {

    //业种id
    private String id;

    //编号
    private String num;

    //业态id
    private String businessFormId;

    //业种名称
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

    public FindBusinessSpeciesByIdResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public FindBusinessSpeciesByIdResponseDTO setNum(String num) {
        this.num = num;
        return this;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public FindBusinessSpeciesByIdResponseDTO setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public String getName() {
        return name;
    }

    public FindBusinessSpeciesByIdResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public FindBusinessSpeciesByIdResponseDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public FindBusinessSpeciesByIdResponseDTO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public FindBusinessSpeciesByIdResponseDTO setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public FindBusinessSpeciesByIdResponseDTO setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
