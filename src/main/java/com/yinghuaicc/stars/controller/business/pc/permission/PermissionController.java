package com.yinghuaicc.stars.controller.business.pc.permission;

import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.controller.config.aop.pc.AopResourceEmployeeBean;
import com.yinghuaicc.stars.service.permission.PermissionService;
import com.yinghuaicc.stars.service.permission.dto.request.ConfRoleMenuRequestDTO;
import com.yinghuaicc.stars.service.permission.dto.request.PackagingConfRoleMenuRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @Author:Fly
 * @Date:Create in 2018/6/27 下午11:55
 * @Description: 权限
 * @Modified:
 */
@RestController
@RequestMapping(value = "/permission")
public class PermissionController {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private PermissionService permissionService;

    /**
     *@Author:Fly Created in 2018/6/27 下午11:57
     *@Description: 查询员工登录菜单
     */
    @GetMapping(value = "/login/menus")
    public JsonResult loginMenus(){

        return JsonResult.success(
                permissionService.loginMenus(
                        applicationContext.getBean(AopResourceEmployeeBean.class).getId()));
    }

    /**
     *@Author:Fly Created in 2018/7/2 上午2:04
     *@Description: 查询员工所有角色
     */
    @GetMapping(value = "/employee/role")
    public JsonResult employeeRole(){

        return JsonResult.success(
                permissionService.employeeRole(
                        applicationContext.getBean(AopResourceEmployeeBean.class).getId()));
    }

    /**
     *@Author:Fly Created in 2018/7/29 下午8:47
     *@Description: 查询指定员工角色
     */
    @GetMapping(value = "/employee/role/by{id}")
    public JsonResult employeeRoleBy(@PathVariable String id){

        return JsonResult.success(permissionService.employeeRole(id));
    }

    /**
     *@Author:Fly Created in 2018/7/2 上午3:29
     *@Description: 查询所有角色
     */
    @GetMapping(value = "/role/all")
    public JsonResult roleAll(){

        return JsonResult.success(permissionService.roleAll());
    }

    /**
     *@Author:Fly Created in 2018/7/2 上午4:45
     *@Description: 查询所有菜单信息
     */
    @GetMapping(value = "/menu/all")
    public JsonResult menuAll(){

        return JsonResult.success(permissionService.menuAll());
    }

    /**
     *@Author:Fly Created in 2018/7/2 上午4:31
     *@Description: 查询所有角色菜单信息
     */
    @GetMapping(value = "/role/menu/all")
    public JsonResult roleMenuAll(){

        return JsonResult.success(permissionService.roleAllMenu());
    }

    /**
     *@Author:Fly Created in 2018/7/2 上午6:00
     *@Description: 设置角色菜单信息
     */
    @PostMapping(value = "/conf/role/menu")
    public JsonResult confRoleMenu(@Validated @RequestBody PackagingConfRoleMenuRequestDTO packagingConfRoleMenuRequestDTO){

        permissionService.confRoleMenu(
                packagingConfRoleMenuRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/5 下午2:08
     *@Description: 添加角色信息
     */
    @GetMapping(value = "/save/role/{roleName}")
    public JsonResult saveRole(@PathVariable String roleName){

        permissionService.saveRole(
                roleName, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/29 下午6:01
     *@Description: 某一角色菜单
     */
    @GetMapping(value = "/role/menu/{roleId}")
    public JsonResult roleMenu(@PathVariable String roleId){

        return JsonResult.success(permissionService.roleMenu(roleId));
    }

}
