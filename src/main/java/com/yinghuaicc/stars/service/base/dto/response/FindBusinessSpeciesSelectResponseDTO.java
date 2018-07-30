package com.yinghuaicc.stars.service.base.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/27 下午5:53
 * @Description:
 * @Modified:
 */
public class FindBusinessSpeciesSelectResponseDTO {

    //业种id
    private String id;

    //业种id
    private String name;

    public String getId() {
        return id;
    }

    public FindBusinessSpeciesSelectResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FindBusinessSpeciesSelectResponseDTO setName(String name) {
        this.name = name;
        return this;
    }
}
