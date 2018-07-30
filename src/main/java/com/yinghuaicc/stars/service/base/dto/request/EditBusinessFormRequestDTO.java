package com.yinghuaicc.stars.service.base.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/9 下午12:34
 * @Description: 编辑业态
 * @Modified:
 */
public class EditBusinessFormRequestDTO {

    //业态id
    @NotEmpty(message = "BASE_EDIT_BUSINESS_FORM_001")
    private String id;

    //业态名称
    @NotEmpty(message = "BASE_EDIT_BUSINESS_FORM_002")
    private String name;

    public String getId() {
        return id;
    }

    public EditBusinessFormRequestDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public EditBusinessFormRequestDTO setName(String name) {
        this.name = name;
        return this;
    }
}
