package com.yinghuaicc.stars.service.tissue;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sun.org.apache.regexp.internal.RE;
import com.yinghuaicc.stars.common.config.base.BaseConfig;
import com.yinghuaicc.stars.common.utils.exception.ExceptionUtil;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.common.utils.uuid.UuidUtil;
import com.yinghuaicc.stars.config.base.BusinessNum;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.region.RegionMapper;
import com.yinghuaicc.stars.repository.mapper.tissue.TissueMapper;
import com.yinghuaicc.stars.repository.mapper.token.TokenMapper;
import com.yinghuaicc.stars.repository.model.tissue.Department;
import com.yinghuaicc.stars.repository.model.tissue.Employee;
import com.yinghuaicc.stars.repository.model.tissue.EmployeeProjectData;
import com.yinghuaicc.stars.repository.model.tissue.EmployeeRoleRelation;
import com.yinghuaicc.stars.repository.model.token.Token;
import com.yinghuaicc.stars.service.tissue.dto.request.*;
import com.yinghuaicc.stars.service.tissue.dto.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/2 上午3:42
 * @Description: 组织架构服务
 * @Modified:
 */
@Service
public class TissueServiceImpl implements TissueService{

    @Autowired
    private ExceptionUtil exceptionUtil;

    @Autowired
    private TissueMapper tissueMapper;

    @Autowired
    private TokenMapper tokenMapper;

    @Autowired
    private RegionMapper regionMapper;

    /**
     *@Author:Fly Created in 2018/7/2 上午3:43
     *@Description: 设置员工角色
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void confEmployeeRole(ConfEmployeeRoleRequestDTO confEmployeeRoleRequestDTO, String loginEmployeeId) {

        if (confEmployeeRoleRequestDTO.getRoleIds().size() == 0){

            throw exceptionUtil.throwCustomException("TISSUE_CONF_EMPLOYEE_ROLE_002");
        }

        //清除员工原有角色
        tissueMapper.removeEmployeeRoleRelationByEmployeeId(confEmployeeRoleRequestDTO.getEmployeeId());

        List<EmployeeRoleRelation> employeeRoleRelations = new ArrayList<EmployeeRoleRelation>();

        confEmployeeRoleRequestDTO.getRoleIds().stream().forEach(roleId -> {

            employeeRoleRelations.add(
                    new EmployeeRoleRelation()
                            .setId(UuidUtil.randomUUID())
                            .setRoleId(roleId)
                            .setEmployeeId(confEmployeeRoleRequestDTO.getEmployeeId())
                            .setCreateUser(loginEmployeeId)
                            .setModifyUser(loginEmployeeId)
                            .setCreateTime(LocalDateTime.now())
                            .setModifyTime(LocalDateTime.now()));
        });

        //为员工添加新的角色
        tissueMapper.saveEmployeeRoleRelation(employeeRoleRelations);
    }

    /**
     *@Author:Fly Created in 2018/7/2 下午7:08
     *@Description: 员工登录
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public EmployeeLoginTokenResponseDTO employeeLogin(EmployeeLoginRequestDTO employeeLoginRequestDTO) {

        Employee employee =
                tissueMapper.findEmployeeByUserNameAndPassword(
                        employeeLoginRequestDTO.getUserName(), employeeLoginRequestDTO.getUserPassword());

        this.checkEmployeeLogin(employee);

        //清空此用户之前的Token
        tokenMapper.removeTokenByEmployeeId(employee.getId());

        List<String> uuids = UuidUtil.batchRandomUUID(3);

        //生成新的Token信息
        Token token = new Token()
                .setId(uuids.get(0))
                .setAccessToken(uuids.get(1))
                .setRefreshToken(uuids.get(2))
                .setEmployeeId(employee.getId())
                .setCreateUser(employee.getId())
                .setModifyUser(employee.getId())
                .setCreateTime(LocalDateTime.now())
                .setModifyTime(LocalDateTime.now());
        tokenMapper.saveToken(token);

        return new EmployeeLoginTokenResponseDTO()
                .setAccessToken(token.getAccessToken())
                .setRefreshToken(token.getRefreshToken())
                .setEmployeeLoginInfoResponseDTO(
                        MapperFactoryUtil.mapperObject(employee, EmployeeLoginInfoResponseDTO.class));
    }

    /**
     *@Author:Fly Created in 2018/7/3 上午10:14
     *@Description: 用户信息
     */
    @Override
    public EmployeeLoginInfoResponseDTO employeeInfo(String loginEmployeeId) {

        return MapperFactoryUtil.mapperObject(
                tissueMapper.findEmployeeById(loginEmployeeId), EmployeeLoginInfoResponseDTO.class);
    }

    /**
     *@Author:Fly Created in 2018/7/3 下午2:08
     *@Description: 员工退出登录
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void employeeOutLogin(String loginEmployeeId) {

        tokenMapper.removeTokenByEmployeeId(loginEmployeeId);
    }

    /**
     *@Author:Fly Created in 2018/7/5 下午3:48
     *@Description: 编辑员工项目数据权限
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editEmployeeProjectData(EditEmployeeProjectDataRequestDTO editEmployeeProjectDataRequestDTO, String loginEmployeeId) {

        if (editEmployeeProjectDataRequestDTO.getProjectIds().size()==0){

            throw exceptionUtil.throwCustomException("TISSUE_EDIT_EMPLOYEE_PROJECT_DATA_001");
        }

        if (Objects.isNull(tissueMapper.findEmployeeById(editEmployeeProjectDataRequestDTO.getEmployeeId()))){

            throw exceptionUtil.throwCustomException("TISSUE_EDIT_EMPLOYEE_PROJECT_DATA_003");
        }

        //删除员工之前的数据权限
        tissueMapper.removeEmployeeProjectDataByEmployeeId(editEmployeeProjectDataRequestDTO.getEmployeeId());

        //添加新的数据权限
        List<EmployeeProjectData> employeeProjectData = new ArrayList<EmployeeProjectData>();

        editEmployeeProjectDataRequestDTO.getProjectIds().stream().forEach(str -> {

            employeeProjectData.add(
                    new EmployeeProjectData()
                            .setId(UuidUtil.randomUUID())
                            .setEmployeeId(editEmployeeProjectDataRequestDTO.getEmployeeId())
                            .setProjectId(str)
                            .setModifyUser(loginEmployeeId)
                            .setCreateUser(loginEmployeeId)
                            .setModifyTime(LocalDateTime.now())
                            .setCreateTime(LocalDateTime.now()));
        });

        tissueMapper.editEmployeeProjectData(employeeProjectData);
    }

    /**
     *@Author:Fly Created in 2018/7/5 下午3:49
     *@Description: 查询员工项目数据权限
     */
    @Override
    public List<FindEmployeeProjectDataByEmployeeIdResponseDTO> findEmployeeProjectDataByEmployeeId(String employeeId) {

        List<EmployeeProjectData> employeeProjectData = tissueMapper.findEmployeeProjectDataByEmployeeId(employeeId);

        if (Objects.isNull(employeeProjectData)||employeeProjectData.size()==0){

            return null;
        }

        return MapperFactoryUtil.mapperList(
                regionMapper.findProjectListById(
                        employeeProjectData.stream().map(employeeProjectData1 -> employeeProjectData1.getProjectId()).collect(Collectors.toList())),
                FindEmployeeProjectDataByEmployeeIdResponseDTO.class);
    }

    /**
     *@Author:Fly Created in 2018/7/6 下午4:00
     *@Description: 添加部门
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveDepartment(SaveDepartmentRequestDTO saveDepartmentRequestDTO, String loginEmployeeId) {

//        if (Objects.isNull(tissueMapper.findDepartmentByParentId(saveDepartmentRequestDTO.getParentId()))||tissueMapper.findDepartmentByParentId(saveDepartmentRequestDTO.getParentId()).size()==0){
//
//            throw exceptionUtil.throwCustomException("TISSUE_SAVE_DEPARTMENT_003");
//        }

        tissueMapper.saveDepartment(
                Stream.of(MapperFactoryUtil.mapperObject(saveDepartmentRequestDTO, Department.class)
                        .setId(UuidUtil.randomUUID())
                        .setParentId(saveDepartmentRequestDTO.getParentId())
                        .setNum(BusinessNum.DEPARTMENT+UuidUtil.randomUUID())
                        .setType(1)
                        .setCreateUser(loginEmployeeId)
                        .setModifyUser(loginEmployeeId)
                        .setModifyTime(LocalDateTime.now())
                        .setCreateTime(LocalDateTime.now())).collect(Collectors.toList()));
    }

    /**
     *@Author:Fly Created in 2018/7/6 下午4:01
     *@Description: 编辑部门
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editDepartment(EditDepartmentRequestDTO editDepartmentRequestDTO, String loginEmployeeId) {

        Department department =
                tissueMapper.findDepartmentById(editDepartmentRequestDTO.getId());

        if (Objects.isNull(department)){

            throw exceptionUtil.throwCustomException("TISSUE_EDIT_DEPARTMENT_004");
        }

        if (Objects.isNull(regionMapper.findCompanyById(editDepartmentRequestDTO.getCompanyId()))){

            throw exceptionUtil.throwCustomException("TISSUE_EDIT_DEPARTMENT_005");
        }

        tissueMapper.editDepartment(
                department
                        .setParentId(editDepartmentRequestDTO.getParentId())
                        .setName(editDepartmentRequestDTO.getName())
                        .setModifyTime(LocalDateTime.now())
                        .setModifyUser(loginEmployeeId));
    }

    /**
     *@Author:Fly Created in 2018/7/6 下午4:01
     *@Description: 删除部门
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeDepartment(String departmentId) {

        if (tissueMapper.countEmployeeDepartmentRelationByDepartmentId(departmentId)>0){

            throw exceptionUtil.throwCustomException("TISSUE_REMOVE_DEPARTMENT_001");
        }

        tissueMapper.removeDepartment(departmentId);
    }

    /**
     *@Author:Fly Created in 2018/7/18 下午2:24
     *@Description: 分页查询机构员工
     */
    @Override
    public ResultPageList<FindEmployeeByOrgIdResponseDTO> findEmployeeByOrgId(String orgId, PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<Employee> employees = tissueMapper.findEmployeeByOrgId(orgId);

        return new ResultPageList<FindEmployeeByOrgIdResponseDTO>()
                .setResultList(MapperFactoryUtil.mapperList(employees, FindEmployeeByOrgIdResponseDTO.class))
                .setCountPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    /**
     *@Author:Fly Created in 2018/7/28 下午1:10
     *@Description: 按照父id查询部门信息
     */
    public List<Department> findDepartmentByParentId(String parentId){

        return tissueMapper.findDepartmentByParentId(parentId);
    }

    /**
     *@Author:Fly Created in 2018/7/29 下午4:45
     *@Description:
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void stateEmployee(StateEmployeeRequestDTO stateEmployeeRequestDTO, String loginEmployeeId) {

        Employee employee = tissueMapper.findEmployeeById(stateEmployeeRequestDTO.getId());

        if (Objects.isNull(employee)){

            throw exceptionUtil.throwCustomException("STATE_EMPLOYEE_003");
        }

        tissueMapper.editEmployeeById(employee.setState(stateEmployeeRequestDTO.isState()));
    }

    /**
     *@Author:Fly Created in 2018/7/2 下午8:11
     *@Description: 检测员工登录
     */
    private void checkEmployeeLogin(Employee employee){

        if (Objects.isNull(employee)){

            throw exceptionUtil.throwCustomException("TISSUE_EMPLOYEE_LOGIN_003");
        }

        if (!employee.isState()){

            throw exceptionUtil.throwCustomException("TISSUE_EMPLOYEE_LOGIN_004");
        }
    }
}
