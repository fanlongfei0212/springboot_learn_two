package com.yinghuaicc.stars.service.cqrs.region.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/4 下午3:07
 * @Description: 项目详情人员信息
 * @Modified:
 */
public class ProjectCQRSInfoEmployeeResponseDTO {

    //员工id
    private String id;

    //员工名称
    private String name;

    //员工电话
    private String phone;

    public String getId() {
        return id;
    }

    public ProjectCQRSInfoEmployeeResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProjectCQRSInfoEmployeeResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ProjectCQRSInfoEmployeeResponseDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }
}
