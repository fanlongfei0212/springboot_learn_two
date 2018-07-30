package com.yinghuaicc.stars.service.region.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/11 下午10:49
 * @Description: 根据项目查询楼栋
 * @Modified:
 */
public class FindBuildingByProjectIdResponseDTO {

    //楼栋id
    private String id;

    //楼栋名称
    private String name;

    public String getId() {
        return id;
    }

    public FindBuildingByProjectIdResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FindBuildingByProjectIdResponseDTO setName(String name) {
        this.name = name;
        return this;
    }
}
