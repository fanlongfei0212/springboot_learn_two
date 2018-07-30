package com.yinghuaicc.stars.service.brand.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/12 下午3:01
 * @Description: 编辑品牌
 * @Modified:
 */
public class EditBrandRequestDTO {

    //id
    @NotEmpty(message = "BRAND_EDIT_BRAND_007")
    private String id;

    //名称
    @NotEmpty(message = "BRAND_EDIT_BRAND_001")
    private String name;

    //业态id
    @NotEmpty(message = "BRAND_EDIT_BRAND_002")
    private String businessFormId;

    //业种id
    @NotEmpty(message = "BRAND_EDIT_BRAND_003")
    private String businessSpeciesId;

    //经营方式(1:直营，2:代理)
    @NotNull(message = "BRAND_EDIT_BRAND_004")
    private Integer brandType;

    public String getId() {
        return id;
    }

    public EditBrandRequestDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EditBrandRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public EditBrandRequestDTO setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public String getBusinessSpeciesId() {
        return businessSpeciesId;
    }

    public EditBrandRequestDTO setBusinessSpeciesId(String businessSpeciesId) {
        this.businessSpeciesId = businessSpeciesId;
        return this;
    }

    public Integer getBrandType() {
        return brandType;
    }

    public EditBrandRequestDTO setBrandType(Integer brandType) {
        this.brandType = brandType;
        return this;
    }

}
