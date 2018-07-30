package com.yinghuaicc.stars.service.tissue.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/5 下午3:40
 * @Description: 员工项目数据权限
 * @Modified:
 */
public class FindEmployeeProjectDataByEmployeeIdResponseDTO {

    //项目id
    private String id;

    //项目名称
    private String name;

    public String getId() {
        return id;
    }

    public FindEmployeeProjectDataByEmployeeIdResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public FindEmployeeProjectDataByEmployeeIdResponseDTO setName(String name) {
        this.name = name;
        return this;
    }
}
