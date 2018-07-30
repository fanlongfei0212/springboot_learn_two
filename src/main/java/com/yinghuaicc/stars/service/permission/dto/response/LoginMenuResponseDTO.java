package com.yinghuaicc.stars.service.permission.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yinghuaicc.stars.repository.model.permission.MenuType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/27 下午10:30
 * @Description: 员工登录后返回的菜单
 * @Modified:
 */
public class LoginMenuResponseDTO implements Comparable<LoginMenuResponseDTO>{

    //id
    private String id;

    //菜单名称
    private String name;

    //是否是根目录
    private boolean isRoot;

    //父菜单id
    private String parentId;

    //菜单类型（一级、二级）
    private MenuType menuType;

    //菜单Url地址
    private String url;

    //排序
    private Integer sort;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    //创建人
    private String createUser;

    //修改人
    private String modifyUser;

    //子集菜单
    private List<LoginMenuResponseDTO> childMenus = new ArrayList<LoginMenuResponseDTO>();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LoginMenuResponseDTO menuResponseDTO = (LoginMenuResponseDTO) o;
        return Objects.equals(id, menuResponseDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getId() {
        return id;
    }

    public LoginMenuResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public LoginMenuResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public LoginMenuResponseDTO setRoot(boolean root) {
        isRoot = root;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public LoginMenuResponseDTO setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public LoginMenuResponseDTO setMenuType(MenuType menuType) {
        this.menuType = menuType;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public LoginMenuResponseDTO setUrl(String url) {
        this.url = url;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public LoginMenuResponseDTO setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public LoginMenuResponseDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public LoginMenuResponseDTO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public LoginMenuResponseDTO setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public LoginMenuResponseDTO setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }

    public List<LoginMenuResponseDTO> getChildMenus() {
        return childMenus;
    }

    public LoginMenuResponseDTO setChildMenus(List<LoginMenuResponseDTO> childMenus) {
        this.childMenus = childMenus;
        return this;
    }


    @Override
    public int compareTo(LoginMenuResponseDTO o) {

        return o.getSort().compare(this.getSort(), o.sort);
    }
}
