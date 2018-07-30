package com.yinghuaicc.stars.service.permission.dto.request;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/2 上午6:12
 * @Description: 设置角色菜单包装类
 * @Modified:
 */
public class PackagingConfRoleMenuRequestDTO {

    //数据集合
    @NotNull(message = "PERMISSION_CONF_ROLE_MENU_003")
    private List<ConfRoleMenuRequestDTO> roleMenus;

    public List<ConfRoleMenuRequestDTO> getRoleMenus() {
        return roleMenus;
    }

    public PackagingConfRoleMenuRequestDTO setRoleMenus(List<ConfRoleMenuRequestDTO> roleMenus) {
        this.roleMenus = roleMenus;
        return this;
    }
}
