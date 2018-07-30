package com.yinghuaicc.stars.service.tissue.dto.response;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/2 下午8:04
 * @Description: 登录用户信息
 * @Modified:
 */
public class EmployeeLoginInfoResponseDTO {

    //id
    private String id;

    //编号
    private String num;

    //名称
    private String name;

    //手机
    private String phone;

    //用户名
    private String userName;


    public String getId() {
        return id;
    }

    public EmployeeLoginInfoResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public EmployeeLoginInfoResponseDTO setNum(String num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public EmployeeLoginInfoResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public EmployeeLoginInfoResponseDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public EmployeeLoginInfoResponseDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }
}
