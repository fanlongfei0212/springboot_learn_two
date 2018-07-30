package com.yinghuaicc.stars.repository.model.permission;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/27 下午3:46
 * @Description: 菜单级别
 * @Modified:
 */
public enum MenuType {

    ONE("一级菜单"),
    TOW("二级菜单");

    String value;

    MenuType(){}

    MenuType(String value){

        this.value = value;
    }
}
