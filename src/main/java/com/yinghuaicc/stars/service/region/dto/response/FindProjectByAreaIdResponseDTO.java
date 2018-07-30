package com.yinghuaicc.stars.service.region.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/20 上午10:09
 * @Description: 按照区域查询项目
 * @Modified:
 */
public class FindProjectByAreaIdResponseDTO {

    //项目id
    private String id;

    //项目名称
    private String name;

    public String getId() {
        return id;
    }

    public FindProjectByAreaIdResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FindProjectByAreaIdResponseDTO setName(String name) {
        this.name = name;
        return this;
    }
}
