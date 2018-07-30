package com.yinghuaicc.stars.service.region.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/4 下午4:38
 * @Description: 添加公司
 * @Modified:
 */
public class SaveCompanyRequestDTO {

    //公司名称
    @NotEmpty(message = "REGION_SAVE_COMPANY_001")
    private String name;

    //父id
    private String parentId;

    public String getName() {
        return name;
    }

    public SaveCompanyRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public SaveCompanyRequestDTO setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }
}
