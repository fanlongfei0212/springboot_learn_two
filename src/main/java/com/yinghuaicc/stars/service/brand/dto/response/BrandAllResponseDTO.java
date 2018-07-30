package com.yinghuaicc.stars.service.brand.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/16 下午12:44
 * @Description: 所有品牌
 * @Modified:
 */
public class BrandAllResponseDTO {

    //id
    private String id;

    //品牌名称
    private String name;

    public String getId() {
        return id;
    }

    public BrandAllResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public BrandAllResponseDTO setName(String name) {
        this.name = name;
        return this;
    }
}
