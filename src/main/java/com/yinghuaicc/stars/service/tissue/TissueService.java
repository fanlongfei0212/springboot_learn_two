package com.yinghuaicc.stars.service.tissue;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.model.tissue.Department;
import com.yinghuaicc.stars.service.tissue.dto.request.*;
import com.yinghuaicc.stars.service.tissue.dto.response.*;

import java.util.List;


/**
 * @Author:Fly
 * @Date:Create in 2018/6/27 下午10:48
 * @Description: 组织架构
 * @Modified:
 */
public interface TissueService {

    /**
     *@Author:Fly Created in 2018/7/2 上午3:42
     *@Description: 设置员工角色
     */
    void confEmployeeRole(ConfEmployeeRoleRequestDTO confEmployeeRoleRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/2 下午7:08
     *@Description: 员工登录
     */
    EmployeeLoginTokenResponseDTO employeeLogin(EmployeeLoginRequestDTO employeeLoginRequestDTO);

    /**
     *@Author:Fly Created in 2018/7/3 上午10:13
     *@Description: 用户信息
     */
    EmployeeLoginInfoResponseDTO employeeInfo(String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/3 下午2:07
     *@Description: 员工退出登录
     */
    void employeeOutLogin(String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/5 下午3:38
     *@Description: 编辑员工项目数据权限
     */
    void editEmployeeProjectData(EditEmployeeProjectDataRequestDTO editEmployeeProjectDataRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/5 下午3:43
     *@Description: 查询员工数据权限
     */
    List<FindEmployeeProjectDataByEmployeeIdResponseDTO> findEmployeeProjectDataByEmployeeId(String employeeId);

    /**
     *@Author:Fly Created in 2018/7/6 下午3:54
     *@Description: 添加部门
     */
    void saveDepartment(SaveDepartmentRequestDTO saveDepartmentRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/6 下午3:58
     *@Description: 编辑部门
     */
    void editDepartment(EditDepartmentRequestDTO editDepartmentRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/6 下午4:00
     *@Description: 删除部门
     */
    void removeDepartment(String departmentId);

    /**
     *@Author:Fly Created in 2018/7/18 下午2:23
     *@Description: 分页查询机构员工
     */
    ResultPageList<FindEmployeeByOrgIdResponseDTO> findEmployeeByOrgId(String orgId, PageParam pageParam);

    /**
     *@Author:Fly Created in 2018/7/28 下午1:09
     *@Description: 按照父id查询部门信息
     */
    List<Department> findDepartmentByParentId(String parentId);

    /**
     *@Author:Fly Created in 2018/7/29 下午4:44
     *@Description: 与员工启用禁用
     */
    void stateEmployee(StateEmployeeRequestDTO stateEmployeeRequestDTO, String loginEmployeeId);

}
