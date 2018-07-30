package com.yinghuaicc.stars.service.base.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/27 下午5:52
 * @Description: 业态下拉
 * @Modified:
 */
public class FindBusinessFormSelectResponseDTO {

    //业态id
    private String id;

    //业种id
    private String name;

    public String getId() {
        return id;
    }

    public FindBusinessFormSelectResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FindBusinessFormSelectResponseDTO setName(String name) {
        this.name = name;
        return this;
    }
}
