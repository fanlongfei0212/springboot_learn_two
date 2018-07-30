package com.yinghuaicc.stars.service.region.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/4 下午5:00
 * @Description: 按照区域id查询公司
 * @Modified:
 */
public class FindCompanyByAreaIdResponseDTO {

    //公司id
    private String id;

    //公司名称
    private String name;

    public String getId() {
        return id;
    }

    public FindCompanyByAreaIdResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FindCompanyByAreaIdResponseDTO setName(String name) {
        this.name = name;
        return this;
    }
}
