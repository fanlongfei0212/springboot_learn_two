package com.yinghuaicc.stars.service.cqrs.brand.dto.response;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/12 下午2:39
 * @Description: 品牌列表
 * @Modified:
 */
public class BrandCQRSListResponseDTO {

    //id
    private String id;

    //品牌名称
    private String name;

    //品牌编号
    private String num;

    //业态名称
    private String businessFormName;

    //业种名称
    private String businessSpeciesName;

    //经营方式
    private Integer brandType;

    //状态（1：签约，2：停用）
    private Integer state;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    public String getId() {
        return id;
    }

    public BrandCQRSListResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BrandCQRSListResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getNum() {
        return num;
    }

    public BrandCQRSListResponseDTO setNum(String num) {
        this.num = num;
        return this;
    }

    public String getBusinessFormName() {
        return businessFormName;
    }

    public BrandCQRSListResponseDTO setBusinessFormName(String businessFormName) {
        this.businessFormName = businessFormName;
        return this;
    }

    public String getBusinessSpeciesName() {
        return businessSpeciesName;
    }

    public BrandCQRSListResponseDTO setBusinessSpeciesName(String businessSpeciesName) {
        this.businessSpeciesName = businessSpeciesName;
        return this;
    }

    public Integer getBrandType() {
        return brandType;
    }

    public BrandCQRSListResponseDTO setBrandType(Integer brandType) {
        this.brandType = brandType;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public BrandCQRSListResponseDTO setState(Integer state) {
        this.state = state;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public BrandCQRSListResponseDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public BrandCQRSListResponseDTO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }
}
