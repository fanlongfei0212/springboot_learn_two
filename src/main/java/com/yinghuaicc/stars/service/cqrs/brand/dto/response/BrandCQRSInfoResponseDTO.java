package com.yinghuaicc.stars.service.cqrs.brand.dto.response;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/12 下午3:55
 * @Description: 品牌详情
 * @Modified:
 */
public class BrandCQRSInfoResponseDTO {

    //品牌id
    private String id;

    //品牌名称
    private String name;

    //业态id
    private String businessFormId;

    //业态名称
    private String businessFormName;

    //业种id
    private String businessSpeciesId;

    //业种名称
    private String businessSpeciesName;

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

    //创建人名称
    private String createUserName;

    //修改人名称
    private String modifyUserName;

    public String getId() {
        return id;
    }

    public BrandCQRSInfoResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BrandCQRSInfoResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public BrandCQRSInfoResponseDTO setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public String getBusinessFormName() {
        return businessFormName;
    }

    public BrandCQRSInfoResponseDTO setBusinessFormName(String businessFormName) {
        this.businessFormName = businessFormName;
        return this;
    }

    public String getBusinessSpeciesId() {
        return businessSpeciesId;
    }

    public BrandCQRSInfoResponseDTO setBusinessSpeciesId(String businessSpeciesId) {
        this.businessSpeciesId = businessSpeciesId;
        return this;
    }

    public String getBusinessSpeciesName() {
        return businessSpeciesName;
    }

    public BrandCQRSInfoResponseDTO setBusinessSpeciesName(String businessSpeciesName) {
        this.businessSpeciesName = businessSpeciesName;
        return this;
    }

    public Integer getBrandType() {
        return brandType;
    }

    public BrandCQRSInfoResponseDTO setBrandType(Integer brandType) {
        this.brandType = brandType;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public BrandCQRSInfoResponseDTO setState(Integer state) {
        this.state = state;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public BrandCQRSInfoResponseDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public BrandCQRSInfoResponseDTO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public BrandCQRSInfoResponseDTO setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public BrandCQRSInfoResponseDTO setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public BrandCQRSInfoResponseDTO setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
        return this;
    }

    public String getModifyUserName() {
        return modifyUserName;
    }

    public BrandCQRSInfoResponseDTO setModifyUserName(String modifyUserName) {
        this.modifyUserName = modifyUserName;
        return this;
    }
}
