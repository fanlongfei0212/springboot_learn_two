package com.yinghuaicc.stars.service.base.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/5 上午10:45
 * @Description: 全部城市
 * @Modified:
 */
public class FindCityAllResponseDTO {

    //id
    private String id;

    //城市名称
    private String name;

    public String getId() {
        return id;
    }

    public FindCityAllResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FindCityAllResponseDTO setName(String name) {
        this.name = name;
        return this;
    }
}
