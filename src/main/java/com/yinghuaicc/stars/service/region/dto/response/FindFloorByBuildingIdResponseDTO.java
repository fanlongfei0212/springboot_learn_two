package com.yinghuaicc.stars.service.region.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/11 下午11:12
 * @Description: 根据楼栋查询层
 * @Modified:
 */
public class FindFloorByBuildingIdResponseDTO {

    //层id
    private String id;

    //层名称
    private String name;

    public String getId() {
        return id;
    }

    public FindFloorByBuildingIdResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FindFloorByBuildingIdResponseDTO setName(String name) {
        this.name = name;
        return this;
    }
}
