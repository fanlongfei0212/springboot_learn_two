package com.yinghuaicc.stars.service.brand.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/12 下午2:59
 * @Description: 添加品牌
 * @Modified:
 */
public class SaveBrandRequestDTO {

    //品牌名称
    @NotEmpty(message = "BRAND_SAVE_BRAND_001")
    private String name;

    //业态id
    @NotEmpty(message = "BRAND_SAVE_BRAND_002")
    private String businessFormId;

    //业种id
    @NotEmpty(message = "BRAND_SAVE_BRAND_003")
    private String businessSpeciesId;

    //经营方式(1:直营，2:代理)
    @NotNull(message = "BRAND_SAVE_BRAND_004")
    private Integer brandType;

    public String getName() {
        return name;
    }

    public SaveBrandRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public SaveBrandRequestDTO setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public String getBusinessSpeciesId() {
        return businessSpeciesId;
    }

    public SaveBrandRequestDTO setBusinessSpeciesId(String businessSpeciesId) {
        this.businessSpeciesId = businessSpeciesId;
        return this;
    }

    public Integer getBrandType() {
        return brandType;
    }

    public SaveBrandRequestDTO setBrandType(Integer brandType) {
        this.brandType = brandType;
        return this;
    }
}
