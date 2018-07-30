package com.yinghuaicc.stars.service.permission;

import com.yinghuaicc.stars.service.permission.dto.request.PackagingConfRoleMenuRequestDTO;
import com.yinghuaicc.stars.service.permission.dto.response.EmployeeRoleResponseDTO;
import com.yinghuaicc.stars.service.permission.dto.response.LoginMenuResponseDTO;
import com.yinghuaicc.stars.service.permission.dto.response.RoleAllResponseDTO;
import com.yinghuaicc.stars.service.permission.dto.response.RoleAllMenuResponseDTO;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/27 下午10:18
 * @Description: 权限
 * @Modified:
 */
public interface PermissionService {

    /**
     *@Author:Fly Created in 2018/6/27 下午10:44
     *@Description: 查询员工登录菜单
     */
    List<LoginMenuResponseDTO> loginMenus(String employeeId);

    /**
     *@Author:Fly Created in 2018/7/2 上午1:53
     *@Description: 查询员工角色
     */
    List<EmployeeRoleResponseDTO> employeeRole(String employeeId);

    /**
     *@Author:Fly Created in 2018/7/2 上午3:31
     *@Description: 查询所有角色
     */
    List<RoleAllResponseDTO> roleAll();

    /**
     *@Author:Fly Created in 2018/7/2 上午4:45
     *@Description: 查询所有菜单信息
     */
    List<LoginMenuResponseDTO> menuAll();

    /**
     *@Author:Fly Created in 2018/7/2 上午4:37
     *@Description: 所有角色菜单信息
     */
    List<RoleAllMenuResponseDTO> roleAllMenu();

    /**
     *@Author:Fly Created in 2018/7/2 上午6:03
     *@Description: 设置角色菜单
     */
    void confRoleMenu(PackagingConfRoleMenuRequestDTO packagingConfRoleMenuRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/5 下午2:11
     *@Description: 添加角色信息
     */
    void saveRole(String roleName, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/29 下午5:55
     *@Description: 查询
     */
    List<RoleAllMenuResponseDTO> roleMenu(String id);
}
