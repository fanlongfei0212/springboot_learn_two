package com.yinghuaicc.stars.service.region;

import com.yinghuaicc.stars.common.config.base.BaseConfig;
import com.yinghuaicc.stars.common.utils.exception.ExceptionUtil;
import com.yinghuaicc.stars.common.utils.mapper.MapperFactoryUtil;
import com.yinghuaicc.stars.common.utils.uuid.UuidUtil;
import com.yinghuaicc.stars.config.base.BusinessNum;
import com.yinghuaicc.stars.repository.mapper.region.RegionMapper;
import com.yinghuaicc.stars.repository.mapper.tissue.TissueMapper;
import com.yinghuaicc.stars.repository.model.region.*;
import com.yinghuaicc.stars.repository.model.tissue.Department;
import com.yinghuaicc.stars.repository.model.tissue.Employee;
import com.yinghuaicc.stars.repository.model.tissue.EmployeeProjectRelationTeam;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.TriangeConditionRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.TriangeConditionResponseDTO;
import com.yinghuaicc.stars.service.region.dto.request.*;
import com.yinghuaicc.stars.service.region.dto.response.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/27 上午1:13
 * @Description: 区域
 * @Modified:
 */
@Service
public class RegionServiceImpl implements RegionService {

    @Autowired
    private RegionMapper regionMapper;

    @Autowired
    private TissueMapper tissueMapper;

    @Autowired
    private ExceptionUtil exceptionUtil;


    /**
     *@Author:Fly Created in 2018/7/4 上午12:58
     *@Description: 添加项目
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveProject(SaveProjectRequestDTO saveProjectRequestDTO, String loginEmployeeId) {

        //添加项目
        Project project = MapperFactoryUtil.mapperObject(saveProjectRequestDTO, Project.class)
                .setId(UuidUtil.randomUUID())
                .setNum(BusinessNum.PROJECT+UuidUtil.randomUUID())
                .setCreateUser(loginEmployeeId)
                .setModifyUser(loginEmployeeId)
                .setModifyTime(LocalDateTime.now())
                .setCreateTime(LocalDateTime.now());

        regionMapper.saveProject(project);

        //如果此项目没有楼栋，默认添加楼栋
        if (regionMapper.countBuildingByProjectId(project.getId()) == 0){

            regionMapper.saveBuilding(
                    Stream.of(
                            new Building()
                                    .setId(UuidUtil.randomUUID())
                                    .setNum(BusinessNum.BUILDING+UuidUtil.randomUUID())
                                    .setName("A座")
                                    .setProjectId(project.getId())
                                    .setCompanyId(project.getCompanyId())
                                    .setModifyUser(loginEmployeeId)
                                    .setCreateUser(loginEmployeeId)
                                    .setModifyTime(LocalDateTime.now())
                                    .setCreateTime(LocalDateTime.now()))
                            .collect(Collectors.toList()));
        }

        //添加项目负责组员
//        this.saveEmployeeProjectRelationTeam(employeeProjectRelationTeamIds, project.getId(), loginEmployeeId);

        //添加项目图片
        List<String> urls = saveProjectRequestDTO.getProjectImages();

        if (Objects.nonNull(urls)&&urls.size()>0){

            this.saveProjectImages(urls, project.getId(), loginEmployeeId);
        }
    }

    /**
     *@Author:Fly Created in 2018/7/4 上午12:58
     *@Description: 编辑项目
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editProject(EditProjectRequestDTO editProjectRequestDTO, String loginEmployeeId) {

//        List<String> employeeProjectRelationTeamIds = editProjectRequestDTO.getEmployeeProjectTeamId();
//
//        if (Objects.isNull(employeeProjectRelationTeamIds)||employeeProjectRelationTeamIds.size()==0){
//
//            throw exceptionUtil.throwCustomException("REGION_EDIT_PROJECT_006");
//        }

        Project project = regionMapper.findProjectById(editProjectRequestDTO.getProjectId());

        if (Objects.isNull(project)){

            throw exceptionUtil.throwCustomException("REGION_EDIT_PROJECT_008");
        }

        //修改项目
        regionMapper.editProject(
                project
                        .setName(editProjectRequestDTO.getProjectName())
                        .setCompanyId(editProjectRequestDTO.getCompanyId())
                        .setState(editProjectRequestDTO.isState())
                        .setProjectHeadId(editProjectRequestDTO.getProjectHeadId())
                        .setAcreage(editProjectRequestDTO.getAcreage())
                        .setModifyUser(loginEmployeeId)
                        .setModifyTime(LocalDateTime.now()));

        //删除原负责小组人员，添加新负责小组人员
        regionMapper.removeEmployeeProjectRelationTeam(project.getId());

//        this.saveEmployeeProjectRelationTeam(editProjectRequestDTO.getEmployeeProjectTeamId(), project.getId(), loginEmployeeId);

        //删除原项目图片，添加新的项目图片
        regionMapper.removeProjectImageByProjectId(project.getId());

        List<String> urls = editProjectRequestDTO.getProjectImages();
        if (Objects.nonNull(urls)&&urls.size()>0){

            this.saveProjectImages(urls, project.getId(), loginEmployeeId);
        }
    }

    /**
     *@Author:Fly Created in 2018/7/11 下午2:35
     *@Description: 根据公司查询项目
     */
    @Override
    public List<FindProjectByCompanyIdResponseDTO> findProjectByCompanyId(String companyId) {

        return MapperFactoryUtil.mapperList(
                regionMapper.findProjectByCompanyId(companyId), FindProjectByCompanyIdResponseDTO.class);
    }

    /**
     *@Author:Fly Created in 2018/7/11 下午2:09
     *@Description: 删除项目
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeProject(String id) {

        if (regionMapper.countFloorByProjectId(id) > 0){

            throw exceptionUtil.throwCustomException("REGION_REMOVE_PROJECT_001");
        }

        //删除项目图片信息
        regionMapper.removeProjectImageByProjectId(id);

        //删除项目负责组员
        regionMapper.removeEmployeeProjectRelationTeam(id);

        //删除自动生成的楼栋
        regionMapper.removeBuilding(id);

        //删除项目
        regionMapper.removeProject(id);

        //删除拥有此项目的员工权限
        tissueMapper.removeEmployeeProjectDataByProjectId(id);
    }

    /**
     *@Author:Fly Created in 2018/7/20 上午10:11
     *@Description: 按照区域查询项目
     */
    @Override
    public List<FindProjectByAreaIdResponseDTO> findProjectByAreaId(String areaId) {

        return MapperFactoryUtil.mapperList(regionMapper.findProjectByAreaId(areaId), FindProjectByAreaIdResponseDTO.class);
    }

    /**
     *@Description: 根据项目查询项目图片
     */
    @Override
    public List<ProjectImage> findProjectImageByProjectId(String projectId) {
        return regionMapper.findProjectImageByProjectId(projectId);
    }

    /**
     *@Author:Fly Created in 2018/7/11 下午3:37
     *@Description: 添加层
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveFloor(SaveFloorRequestDTO saveFloorRequestDTO, String loginEmployeeId) {

        if (Objects.isNull(regionMapper.findBuildingById(saveFloorRequestDTO.getBuildingId()))){

            throw exceptionUtil.throwCustomException("REGION_SAVE_FLOOR_009");
        }

        regionMapper.saveFloor(
                Stream.of(MapperFactoryUtil.mapperObject(saveFloorRequestDTO, Floor.class)
                        .setId(UuidUtil.randomUUID())
                        .setNum(BusinessNum.FLOOR+UuidUtil.randomUUID())
                        .setModifyUser(loginEmployeeId)
                        .setCreateUser(loginEmployeeId)
                        .setModifyTime(LocalDateTime.now())
                        .setCreateTime(LocalDateTime.now())).collect(Collectors.toList()));
    }

    /**
     *@Author:Fly Created in 2018/7/11 下午3:37
     *@Description: 编辑层
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editFloor(EditFloorRequestDTO editFloorRequestDTO, String loginEmployeeId) {

        Floor floor = regionMapper.findFloorById(editFloorRequestDTO.getId());

        if (Objects.isNull(floor)){

            throw exceptionUtil.throwCustomException("REGION_EDIT_FLOOR_010");
        }

        regionMapper.editFloor(floor
                .setCompanyId(editFloorRequestDTO.getCompanyId())
                .setProjectId(editFloorRequestDTO.getProjectId())
                .setBuildingId(editFloorRequestDTO.getBuildingId())
                .setName(editFloorRequestDTO.getName())
                .setLocation(editFloorRequestDTO.getLocation())
                .setAcreage(editFloorRequestDTO.getAcreage())
                .setState(editFloorRequestDTO.isState())
                .setModifyTime(LocalDateTime.now())
                .setModifyUser(loginEmployeeId));
    }

    /**
     *@Author:Fly Created in 2018/7/11 下午5:28
     *@Description: 删除层
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeFloor(String id) {

        if (regionMapper.countRoomByFloorId(id) > 0){

            throw exceptionUtil.throwCustomException("REGION_REMOVE_FLOOR_001");
        }

        regionMapper.removeFloor(id);
    }

    /**
     *@Author:Fly Created in 2018/7/12 上午1:06
     *@Description: 添加铺位
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveRoom(SaveRoomRequestDTO saveRoomRequestDTO, String loginEmployeeId) {

        if (Objects.isNull(regionMapper.findFloorById(saveRoomRequestDTO.getFloorId()))){

            throw exceptionUtil.throwCustomException("REGION_SAVE_ROOM_009");
        }

        regionMapper.saveRoom(
                Stream.of(
                        MapperFactoryUtil.mapperObject(saveRoomRequestDTO, Room.class)
                                .setId(UuidUtil.randomUUID())
                                .setNum(BusinessNum.ROOM+UuidUtil.randomUUID())
                                .setModifyUser(loginEmployeeId)
                                .setCreateUser(loginEmployeeId)
                                .setModifyTime(LocalDateTime.now())
                                .setCreateTime(LocalDateTime.now()))
                        .collect(Collectors.toList()));
    }

    /**
     *@Author:Fly Created in 2018/7/12 上午1:07
     *@Description: 编辑铺位
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void editRoom(EditRoomRequestDTO editRoomRequestDTO, String loginEmployeeId) {

        Room room = regionMapper.findRoomById(editRoomRequestDTO.getId());

        if (Objects.isNull(room)){

            throw exceptionUtil.throwCustomException("REGION_EDIT_ROOM_010");
        }

        regionMapper.editRoom(room
                .setName(editRoomRequestDTO.getName())
                .setCompanyId(editRoomRequestDTO.getCompanyId())
                .setProjectId(editRoomRequestDTO.getProjectId())
                .setBuildingId(editRoomRequestDTO.getBuildingId())
                .setFloorId(editRoomRequestDTO.getFloorId())
                .setAcreage(editRoomRequestDTO.getAcreage())
                .setState(editRoomRequestDTO.getState())
                .setModifyUser(loginEmployeeId)
                .setModifyTime(LocalDateTime.now()));
    }

    /**
     *@Author:Fly Created in 2018/7/12 上午1:07
     *@Description: 删除铺位
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void removeRoom(String id) {
        regionMapper.removeRoom(id);
    }

    /**
     *@Author:Fly Created in 2018/7/16 下午1:34
     *@Description: 根据层查询铺位
     */
    @Override
    public List<FindRoomByFloorIdResponseDTO> findRoomByFloorId(String floorId) {

        return MapperFactoryUtil.mapperList(regionMapper.findRoomByFloorId(floorId), FindRoomByFloorIdResponseDTO.class);
    }

    /**
     *@Author:Fly Created in 2018/7/11 下午11:13
     *@Description: 按照楼栋查询层
     */
    @Override
    public List<FindFloorByBuildingIdResponseDTO> findFloorByBuildingId(String id) {

        return MapperFactoryUtil.mapperList(
                regionMapper.findFloorByBuildingId(id), FindFloorByBuildingIdResponseDTO.class);
    }

    /**
     *@Author:Fly Created in 2018/7/4 下午4:40
     *@Description: 添加公司
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveCompany(SaveCompanyRequestDTO saveCompanyRequestDTO, String loginEmployeeId) {

        regionMapper.saveCompany(
                Stream.of(MapperFactoryUtil.mapperObject(saveCompanyRequestDTO, Company.class)
                        .setId(UuidUtil.randomUUID())
                        .setNum(BusinessNum.COMPANY+UuidUtil.randomUUID())
                        .setParentId(saveCompanyRequestDTO.getParentId())
                        .setType(1)
                        .setCreateTime(LocalDateTime.now())
                        .setModifyTime(LocalDateTime.now())
                        .setCreateUser(loginEmployeeId)
                        .setModifyUser(loginEmployeeId)).collect(Collectors.toList()));
    }

    /**
     *@Author:Fly Created in 2018/7/11 下午10:51
     *@Description: 根据项目查询楼栋
     */
    @Override
    public List<FindBuildingByProjectIdResponseDTO> findBuildingByProjectId(String projectId) {

        return MapperFactoryUtil.mapperList(
                regionMapper.findBuildingByProjectId(projectId), FindBuildingByProjectIdResponseDTO.class);
    }

    /**
     *@Author:Fly Created in 2018/7/4 下午5:05
     *@Description: 查询所有区域
     */
    @Override
    public List<FindAreaAllResponseDTO> findAreaAll() {

        return MapperFactoryUtil.mapperList(
                regionMapper.findAreaAll(), FindAreaAllResponseDTO.class);
    }

    /**
     *@Author:Fly Created in 2018/7/4 下午5:05
     *@Description: 按照区域查询公司
     */
    @Override
    public List<FindCompanyByAreaIdResponseDTO> findCompanyByAreaId(String areaId) {

        List<Company> companies = regionMapper.findCompanyByAreaId(areaId);

        return Objects.isNull(companies)||companies.size()==0
                ?
                null
                :
                MapperFactoryUtil.mapperList(companies, FindCompanyByAreaIdResponseDTO.class);
    }

    /**
     *@Author:Fly Created in 2018/7/27 下午3:24
     *@Description: 查询所有公司
     */
    @Override
    public List<FindCompanyByAreaIdResponseDTO> findCompanyAll() {

        return MapperFactoryUtil.mapperList(regionMapper.findCompany(), FindCompanyByAreaIdResponseDTO.class);
    }

    /**
     *@Author:Fly Created in 2018/7/5 下午3:17
     *@Description: 查询所有项目数据权限
     */
    @Override
    public List<FindProjectAllResponseDTO> findProjectAll() {

        return MapperFactoryUtil.mapperList(
                regionMapper.findProjectAll(), FindProjectAllResponseDTO.class);
    }

    /**
     *@Author:Fly Created in 2018/7/18 上午11:11
     *@Description: 机构树
     */
    @Override
    public List<FindCompanyTreeResponseDTO> orgTreeAll() {

        List<Company> companies = regionMapper.findCompanyAll();

        List<Department> departments = tissueMapper.findDepartmentAll();

        List<FindCompanyTreeResponseDTO> findCompanyTreeResponseDTOS = new ArrayList<FindCompanyTreeResponseDTO>();

        findCompanyTreeResponseDTOS.addAll(companies.stream().map(company -> {

            return new FindCompanyTreeResponseDTO()
                    .setId(company.getId())
                    .setParentId(company.getParentId())
                    .setType("company")
                    .setName(company.getName());
        }).collect(Collectors.toList()));

        findCompanyTreeResponseDTOS.addAll(departments.stream().map(department -> {

            return new FindCompanyTreeResponseDTO()
                    .setId(department.getId())
                    .setParentId(department.getParentId())
                    .setType("dept")
                    .setName(department.getName());
        }).collect(Collectors.toList()));

        List<FindCompanyTreeResponseDTO> one =
                findCompanyTreeResponseDTOS.stream().filter(
                        findCompanyTreeResponseDTO -> StringUtils.isEmpty(findCompanyTreeResponseDTO.getParentId()))
                        .collect(Collectors.toList());

        List<FindCompanyTreeResponseDTO> child =
                findCompanyTreeResponseDTOS.stream().filter(
                        findCompanyTreeResponseDTO -> !StringUtils.isEmpty(findCompanyTreeResponseDTO.getParentId()))
                        .collect(Collectors.toList());



        return this.orgTree(one, child);
    }

    /**
     *@Author:Fly Created in 2018/7/28 下午12:35
     *@Description: 查询公司下员工
     */
    @Override
    public List<Employee> findEmployeeByCompanyId(String companyId) {


        return tissueMapper.findEmployeeByCompanyId(companyId);
    }

    @Override
    public List<TriangeConditionResponseDTO> findConditionlistByOtherId(TriangeConditionRequestDTO triangeConditionRequestDTO) {
        return regionMapper.findConditionlistByOtherId(triangeConditionRequestDTO);
    }

    @Override
    public List<Floor> findFloorByProjectId(String projectId) {
        return regionMapper.findFloorByProjectId(projectId);
    }

    /**
     *@Author:Fly Created in 2018/7/18 下午12:02
     *@Description: 组织机构树
     */
    private List<FindCompanyTreeResponseDTO> orgTree(List<FindCompanyTreeResponseDTO> one, List<FindCompanyTreeResponseDTO> child){

        one.stream().forEach(oneOrg -> {

            oneOrg.setChildTree(this.searchChild(oneOrg.getId(), child));
        });

        return one;
    }

    /**
     *@Author:Fly Created in 2018/7/18 下午12:07
     *@Description: 查找子机构的子机构
     */
    private List<FindCompanyTreeResponseDTO> searchChild(String parentId, List<FindCompanyTreeResponseDTO> child){

        List<FindCompanyTreeResponseDTO> childTree = new ArrayList<FindCompanyTreeResponseDTO>();

        child.stream().forEach(childOrg -> {

            if (parentId.equals(childOrg.getParentId())){

                childTree.add(childOrg);
            }
        });

        childTree.stream().forEach(childOrg -> {

            if (child.stream().anyMatch(c -> childOrg.getId().equals(c.getParentId()))){

                this.searchChild(childOrg.getId(), child);
            }
        });

        if (childTree.size() ==0){

            return null;
        }

        return childTree;
    }

    /**
     *@Author:Fly Created in 2018/7/4 下午3:31
     *@Description: 添加项目负责组员
     */
//    private void saveEmployeeProjectRelationTeam(List<String> employeeProjectRelationTeamIds, String projectId, String loginEmployeeId){
//
//        List<EmployeeProjectRelationTeam> employeeProjectRelationTeams = new ArrayList<EmployeeProjectRelationTeam>();
//
//        employeeProjectRelationTeamIds.stream().forEach(str -> {
//
//            employeeProjectRelationTeams.add(
//                    new EmployeeProjectRelationTeam()
//                            .setProjectId(projectId)
//                            .setEmployeeId(str)
//                            .setId(UuidUtil.randomUUID())
//                            .setCreateUser(loginEmployeeId)
//                            .setModifyUser(loginEmployeeId)
//                            .setModifyTime(LocalDateTime.now())
//                            .setCreateTime(LocalDateTime.now()));
//        });
//
//        regionMapper.saveEmployeeProjectRelationTeam(employeeProjectRelationTeams);
//    }

    /**
     *@Author:Fly Created in 2018/7/4 下午3:33
     *@Description: 添加项目图片
     */
    private void saveProjectImages(List<String> urls, String projectId, String loginEmployeeId){

        List<ProjectImage> projectImages = new ArrayList<ProjectImage>();

        urls.stream().forEach(str -> {

            projectImages.add(
                    new ProjectImage()
                            .setId(UuidUtil.randomUUID())
                            .setUrl(str)
                            .setProjectId(projectId)
                            .setCreateUser(loginEmployeeId)
                            .setModifyUser(loginEmployeeId)
                            .setModifyTime(LocalDateTime.now())
                            .setCreateTime(LocalDateTime.now()));
        });

        regionMapper.saveProjectImage(projectImages);
    }

}
