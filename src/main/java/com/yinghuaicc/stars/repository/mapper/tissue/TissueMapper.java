package com.yinghuaicc.stars.repository.mapper.tissue;

import com.yinghuaicc.stars.repository.model.permission.Role;
import com.yinghuaicc.stars.repository.model.tissue.Department;
import com.yinghuaicc.stars.repository.model.tissue.Employee;
import com.yinghuaicc.stars.repository.model.tissue.EmployeeProjectData;
import com.yinghuaicc.stars.repository.model.tissue.EmployeeRoleRelation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/27 下午11:01
 * @Description: 员工角色关系
 * @Modified:
 */
@Repository
public interface TissueMapper {

    /**
     *@Author:Fly Created in 2018/6/27 下午11:02
     *@Description: 根据员工id查询员工所有角色
     */
    @Select("select * from yhcc_employee_role_relation where employee_id = #{employeeId}")
    List<EmployeeRoleRelation> findEmployeeRoleRelationByEmployeeId(String employeeId);

    /**
     *@Author:Fly Created in 2018/7/2 上午3:09
     *@Description: 添加员工角色
     */
    @Insert("<script> " +
            "insert into yhcc_employee_role_relation values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.employeeId}, #{item.roleId}, #{item.createTime}, #{item.modifyTime}, #{item.createUser}, #{item.modifyUser}) " +
            "</foreach> " +
            "</script> ")
    void saveEmployeeRoleRelation(List<EmployeeRoleRelation> employeeRoleRelations);

    /**
     *@Author:Fly Created in 2018/7/2 上午3:08
     *@Description: 删除员工角色
     */
    @Delete("delete from yhcc_employee_role_relation where employee_id = #{employeeId}")
    void removeEmployeeRoleRelationByEmployeeId(String employeeId);

    /**
     *@Author:Fly Created in 2018/7/2 下午7:48
     *@Description: 根据用户名密码查询员工信息
     */
    @Select("select * from yhcc_employee where user_name = #{userName} and password = #{password}")
    Employee findEmployeeByUserNameAndPassword(@Param("userName") String userName, @Param("password") String password);

    /**
     *@Author:Fly Created in 2018/7/24 下午4:59
     *@Description: 根据用户名查询员工信息
     */
    @Select("select * from yhcc_employee where user_name = #{userName} ")
    List<Employee> findEmployeeByUserName(String userName);

    /**
     *@Author:Fly Created in 2018/7/3 上午10:15
     *@Description: 根据员工id查询员工信息
     */
    @Select("select * from yhcc_employee where id = #{id}")
    Employee findEmployeeById(String id);

    /**
     *@Author:Fly Created in 2018/7/5 上午2:10
     *@Description: 批量查询员工
     */
    @Select("<script> " +
            "select * from yhcc_employee where id in " +
            "<foreach item='item' collection='list' open='(' close=')' separator=','> " +
            "#{item} " +
            "</foreach> " +
            "</script>")
    List<Employee> findEmployeeListById(List<String> ids);

    /**
     *@Author:Fly Created in 2018/7/5 上午1:25
     *@Description: 根据员工id查询项目数据权限
     */
    @Select("select * from yhcc_employee_project_data where employee_id = #{employeeId}")
    List<EmployeeProjectData> findEmployeeProjectDataByEmployeeId(String employeeId);

    /**
     *@Author:Fly Created in 2018/7/17 下午4:14
     *@Description: 同步员工数据时，删除要同步的旧员工数据
     */
    @Delete("<script> " +
            "delete from yhcc_employee where id in " +
            "<foreach item='item' collection='list' open='(' close=')' separator=','> " +
            "#{item}" +
            "</foreach> " +
            "and type = 2" +
            "</script> ")
    void removeEmployeeByExternal(List<String> ids);

    /**
     *@Author:Fly Created in 2018/7/17 下午4:18
     *@Description: 添加员工
     */
    @Insert("<script> " +
            "insert into yhcc_employee values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.num}, #{item.name}, #{item.phone}, #{item.email}, " +
            "#{item.userName}, #{item.password}, #{item.state}, #{item.type}, #{item.orgId}, " +
            "#{item.createTime}, #{item.modifyTime}, #{item.createUser}, #{item.modifyUser} )" +
            "</foreach>" +
            "</script> ")
    void saveEmployeeByExternal(List<Employee> employees);

    /**
     *@Author:Fly Created in 2018/7/29 下午4:49
     *@Description: 编辑员工
     */
    @Update("update yhcc_employee set " +
            "num = #{num}, name = #{name}, phone = #{phone}, email = #{email}, user_name = #{userName}, " +
            "password = #{password}, state = #{state}, type = #{type}, org_id = #{orgId}, create_time = #{createTime}, " +
            "modify_time = #{modifyTime}, create_user = #{createUser}, modify_user = #{modifyUser} " +
            "where id = #{id}")
    void editEmployeeById(Employee employee);

    /**
     *@Author:Fly Created in 2018/7/18 下午2:15
     *@Description: 根据组织查询员工
     */
    @Select("select * from yhcc_employee where org_id = #{orgId} ")
    List<Employee> findEmployeeByOrgId(String orgId);

    /**
     *@Author:Fly Created in 2018/7/5 上午1:51
     *@Description: 添加数据权限
     */
    @Insert("<script> " +
            "insert into yhcc_employee_project_data values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.projectId}, #{item.employeeId}, #{item.createTime}, " +
            "#{item.modifyTime}, #{item.createUser}, #{item.modifyUser} )" +
            "</foreach> " +
            "</script> ")
    void editEmployeeProjectData(List<EmployeeProjectData> employeeProjectData);

    /**
     *@Author:Fly Created in 2018/7/5 上午1:56
     *@Description: 通过员工id删除项目数据权限
     */
    @Delete("delete from yhcc_employee_project_data where employee_id = #{employeeId}")
    void removeEmployeeProjectDataByEmployeeId(String employeeId);

    /**
     *@Author:Fly Created in 2018/7/11 下午5:39
     *@Description: 通过项目id删除员工项目数据权限
     */
    @Delete("delete from yhcc_employee_project_data where project_id = #{projectId}")
    void removeEmployeeProjectDataByProjectId(String projectId);

    /**
     *@Author:Fly Created in 2018/7/6 下午3:41
     *@Description: 添加部门
     */
    @Insert("<script> " +
            "insert into yhcc_department values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.num}, #{item.name}, #{item.parentId}, #{item.type}, " +
            "#{item.createTime}, #{item.modifyTime}, #{item.createUser}, #{item.modifyUser}) " +
            "</foreach>" +
            "</script>")
    void saveDepartment(List<Department> department);

    /**
     *@Author:Fly Created in 2018/7/6 下午3:51
     *@Description: 修改部门
     */
    @Update("update yhcc_department set " +
            "num = #{num}, name = #{name}, parent_id = #{parentId}, type = #{type}, " +
            "create_time = #{createTime}, modify_time = #{modifyTime}, create_user = #{createUser}, modify_user = #{modifyUser} " +
            "where id = #{id}")
    void editDepartment(Department department);

    /**
     *@Author:Fly Created in 2018/7/6 下午3:52
     *@Description: 根据部门id查询部门信息
     */
    @Select("select * from yhcc_department where id = #{id}")
    Department findDepartmentById(String id);

    /**
     *@Author:Fly Created in 2018/7/6 下午4:17
     *@Description: 删除部门
     */
    @Delete("delete from yhcc_department where id = #{id}")
    void removeDepartment(String id);

    /**
     *@Author:Fly Created in 2018/7/18 上午10:37
     *@Description: 批量删除外部系统部门数据
     */
    @Delete("<script> " +
            "delete from yhcc_department where id in" +
            "<foreach item='item' collection='list' open='(' close=')' separator=','> " +
            "#{item}" +
            "</foreach> " +
            "and type = 2 " +
            "</script> ")
    void removeDepartmentByIds(List<String> ids);

    /**
     *@Author:Fly Created in 2018/7/6 下午4:20
     *@Description: 根据部门id查询部门人数
     */
    @Select("select count(*) from yhcc_employee_department_relation where department_id = #{departmentId}")
    Integer countEmployeeDepartmentRelationByDepartmentId(String departmentId);

    /**
     *@Author:Fly Created in 2018/7/18 上午10:31
     *@Description: 按照部门上级查询部门信息
     */
    @Select("select * from yhcc_department where parent_id = #{parentId}")
    List<Department> findDepartmentByParentId(String parentId);

    /**
     *@Author:Fly Created in 2018/7/18 上午11:16
     *@Description: 查询所有部门
     */
    @Select("select * from yhcc_department ")
    List<Department> findDepartmentAll();

    /**
     *@Author:Fly Created in 2018/7/28 下午12:34
     *@Description: 按照公司查询员工
     */
    @Select("select * from yhcc_employee where org_id = #{companyId} ")
    List<Employee> findEmployeeByCompanyId(String companyId);

}
