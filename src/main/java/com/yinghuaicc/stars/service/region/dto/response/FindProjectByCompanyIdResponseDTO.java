package com.yinghuaicc.stars.service.region.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/11 下午2:33
 * @Description: 按照公司id查询项目
 * @Modified:
 */
public class FindProjectByCompanyIdResponseDTO {

    //项目id
    private String id;

    //项目名称
    private String name;

    public String getId() {
        return id;
    }

    public FindProjectByCompanyIdResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FindProjectByCompanyIdResponseDTO setName(String name) {
        this.name = name;
        return this;
    }
}
