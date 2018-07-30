package com.yinghuaicc.stars.service.base.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/9 下午12:40
 * @Description: 修改业种
 * @Modified:
 */
public class EditBusinessSpeciesRequestDTO {

    //业种id
    @NotEmpty(message="BASE_EDIT_BUSINESS_SPECIES_001")
    private String id;

    //业态id
    @NotEmpty(message="BASE_EDIT_BUSINESS_SPECIES_002")
    private String businessFormId;

    //业种名称
    @NotEmpty(message="BASE_EDIT_BUSINESS_SPECIES_003")
    private String name;

    public String getId() {
        return id;
    }

    public EditBusinessSpeciesRequestDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public EditBusinessSpeciesRequestDTO setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public String getName() {
        return name;
    }

    public EditBusinessSpeciesRequestDTO setName(String name) {
        this.name = name;
        return this;
    }
}
