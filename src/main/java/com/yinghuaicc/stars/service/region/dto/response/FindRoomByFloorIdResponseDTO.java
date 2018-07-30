package com.yinghuaicc.stars.service.region.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/16 下午1:33
 * @Description: 根据层查询铺位
 * @Modified:
 */
public class FindRoomByFloorIdResponseDTO {

    //id
    private String id;

    //铺位名称
    private String name;

    public String getId() {
        return id;
    }

    public FindRoomByFloorIdResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FindRoomByFloorIdResponseDTO setName(String name) {
        this.name = name;
        return this;
    }
}
