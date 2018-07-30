package com.yinghuaicc.stars.controller.config.aop.app;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/3 上午10:50
 * @Description: App员工资源Bean
 * @Modified:
 */
@Component
@RequestScope
public class AppAopResourceEmployeeBean {

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

    //用户数据权限
    private List<String> projectIds = new ArrayList<String>();

    public String getId() {
        return id;
    }

    public AppAopResourceEmployeeBean setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public AppAopResourceEmployeeBean setNum(String num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public AppAopResourceEmployeeBean setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public AppAopResourceEmployeeBean setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public AppAopResourceEmployeeBean setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public List<String> getProjectIds() {
        return projectIds;
    }

    public AppAopResourceEmployeeBean setProjectIds(List<String> projectIds) {
        this.projectIds = projectIds;
        return this;
    }
}
