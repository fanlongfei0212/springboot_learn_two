package com.yinghuaicc.stars.service.region.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/4 下午4:58
 * @Description: 所有区域
 * @Modified:
 */
public class FindAreaAllResponseDTO {

    //区域id
    private String id;

    //区域名称
    private String name;

    public String getId() {
        return id;
    }

    public FindAreaAllResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FindAreaAllResponseDTO setName(String name) {
        this.name = name;
        return this;
    }
}
