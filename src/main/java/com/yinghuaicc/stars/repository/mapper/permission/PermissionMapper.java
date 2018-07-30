package com.yinghuaicc.stars.repository.mapper.permission;

import com.yinghuaicc.stars.repository.model.permission.Menu;
import com.yinghuaicc.stars.repository.model.permission.Role;
import com.yinghuaicc.stars.repository.model.permission.RoleMenuRelation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/27 下午5:02
 * @Description: 权限
 * @Modified:
 */
@Repository
public interface PermissionMapper {

    /**
     *@Author:Fly Created in 2018/6/27 下午11:08
     *@Description: 根据角色查询菜单
     */
    @Select("<script> " +
            "select * from yhcc_role_menu_relation where role_id in " +
            "<foreach item='item' collection='list' open='(' close=')' separator=','> " +
            "#{item} " +
            "</foreach> " +
            "</script>")
    List<RoleMenuRelation> findRoleMenuRelationByRoleId(List<String> roleId);

    /**
     *@Author:Fly Created in 2018/6/27 下午11:16
     *@Description: 根据菜单id集合查询菜单集合
     */
    @Select("<script> " +
            "select * from yhcc_menu where id in " +
            "<foreach item='item' collection='list' open='(' close=')' separator=','> " +
            "#{item} " +
            "</foreach> " +
            "</script>")
    List<Menu> findMenuByMenuId(List<String> menuIds);

    /**
     *@Author:Fly Created in 2018/6/28 上午1:51
     *@Description: 查询所有菜单
     */
    @Select("select * from yhcc_menu")
    List<Menu> findMenuAll();

    /**
     *@Author:Fly Created in 2018/7/2 上午1:49
     *@Description: 根据角色id查询所有角色
     */
    @Select("<script> " +
            "select * from yhcc_role where id in " +
            "<foreach item='item' collection='list' open='(' close=')' separator=','> " +
            "#{item} " +
            "</foreach> " +
            "</script> " )
    List<Role> findRoleByEmployeeId(List<String> id);

    /**
     *@Author:Fly Created in 2018/7/2 上午3:28
     *@Description: 查询所有角色
     */
    @Select("select * from yhcc_role")
    List<Role> findRoleAll();

    /**
     *@Author:Fly Created in 2018/7/2 下午1:30
     *@Description: 删除角色菜单信息
     */
    @Delete("<script> " +
            "delete from yhcc_role_menu_relation where role_id in " +
            "<foreach item='item' collection='list' open='(' close=')' separator=','> " +
            "#{item} " +
            "</foreach> " +
            "</script> ")
    void removeRoleMenuRelationByRoleId(List<String> roleId);
    
    /**
     *@Author:Fly Created in 2018/7/2 下午1:38
     *@Description: 添加角色菜单信息
     */
    @Insert("<script>" +
            "INSERT INTO yhcc_role_menu_relation VALUES " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','>" +
            "(#{item.id}, #{item.roleId}, #{item.menuId}, #{item.createTime}, #{item.modifyTime}, #{item.createUser}, #{item.modifyUser})" +
            "</foreach>" +
            "</script>")
    void saveRoleMenuRelation(List<RoleMenuRelation> roleMenuRelations);


    /**
     *@Author:Fly Created in 2018/7/5 下午2:05
     *@Description: 添加角色信息
     */
    @Insert("insert into yhcc_role values(#{id}, #{name}, #{createTime}, #{modifyTime}, #{createUser}, #{modifyUser})")
    void saveRole(Role role);
}
