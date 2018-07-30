package com.yinghuaicc.stars.service.region.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/5 下午3:14
 * @Description: 查询所有项目
 * @Modified:
 */
public class FindProjectAllResponseDTO {

    //项目id
    private String id;

    //项目名称
    private String name;

    public String getId() {
        return id;
    }

    public FindProjectAllResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FindProjectAllResponseDTO setName(String name) {
        this.name = name;
        return this;
    }
}
