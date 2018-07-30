package com.yinghuaicc.stars.repository.model.brand;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/26 下午4:22
 * @Description: 品牌
 * @Modified:
 */
public class Brand {

    //id
    private String id;

    //编号
    private String num;

    //名称
    private String name;

    //业态id
    private String businessFormId;

    //业种id
    private String businessSpeciesId;

    //经营方式(1:直营，2:代理)
    private Integer brandType;

    //状态（1：签约，2：停用）
    private Integer state;

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

    public Brand setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public Brand setNum(String num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public Brand setName(String name) {
        this.name = name;
        return this;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public Brand setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public String getBusinessSpeciesId() {
        return businessSpeciesId;
    }

    public Brand setBusinessSpeciesId(String businessSpeciesId) {
        this.businessSpeciesId = businessSpeciesId;
        return this;
    }

    public Integer getBrandType() {
        return brandType;
    }

    public Brand setBrandType(Integer brandType) {
        this.brandType = brandType;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public Brand setState(Integer state) {
        this.state = state;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Brand setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public Brand setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Brand setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public Brand setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
