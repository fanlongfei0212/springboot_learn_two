package com.yinghuaicc.stars.repository.model.permission;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/27 下午3:38
 * @Description: 菜单
 * @Modified:
 */
public class Menu {

    public Menu(){}

    public Menu(String id, String name, boolean isRoot, String parentId, MenuType menuType, String url, Integer sort, LocalDateTime createTime, LocalDateTime modifyTime, String createUser, String modifyUser) {
        this.id = id;
        this.name = name;
        this.isRoot = isRoot;
        this.parentId = parentId;
        this.menuType = menuType;
        this.url = url;
        this.sort = sort;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.createUser = createUser;
        this.modifyUser = modifyUser;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Menu menu = (Menu) o;
        return Objects.equals(id, menu.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String getId() {
        return id;
    }

    public Menu setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Menu setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public Menu setRoot(boolean root) {
        isRoot = root;
        return this;
    }

    public String getParentId() {
        return parentId;
    }

    public Menu setParentId(String parentId) {
        this.parentId = parentId;
        return this;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public Menu setMenuType(MenuType menuType) {
        this.menuType = menuType;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Menu setUrl(String url) {
        this.url = url;
        return this;
    }

    public Integer getSort() {
        return sort;
    }

    public Menu setSort(Integer sort) {
        this.sort = sort;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Menu setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public Menu setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Menu setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public Menu setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
