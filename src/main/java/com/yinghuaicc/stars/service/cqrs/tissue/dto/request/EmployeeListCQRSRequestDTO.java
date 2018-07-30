package com.yinghuaicc.stars.service.cqrs.tissue.dto.request;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/18 下午2:43
 * @Description:
 * @Modified:
 */
public class EmployeeListCQRSRequestDTO {

    //真实姓名
    private String name = "";

    //用户名
    private String userName = "";

    public String getName() {
        return name;
    }

    public EmployeeListCQRSRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public EmployeeListCQRSRequestDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }
}
