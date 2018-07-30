package com.yinghuaicc.stars.service.base.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/9 下午12:38
 * @Description: 添加业种
 * @Modified:
 */
public class SaveBusinessSpeciesRequestDTO {

    //业态id
    @NotEmpty(message = "BASE_SAVE_BUSINESS_SPECIES_001")
    private String businessFormId;

    //业种名称
    @NotEmpty(message = "BASE_SAVE_BUSINESS_SPECIES_002")
    private String name;

    public String getBusinessFormId() {
        return businessFormId;
    }

    public SaveBusinessSpeciesRequestDTO setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public String getName() {
        return name;
    }

    public SaveBusinessSpeciesRequestDTO setName(String name) {
        this.name = name;
        return this;
    }
}
