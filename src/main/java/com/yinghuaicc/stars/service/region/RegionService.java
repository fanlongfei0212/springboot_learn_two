package com.yinghuaicc.stars.service.region;

import com.yinghuaicc.stars.repository.model.region.Floor;
import com.yinghuaicc.stars.repository.model.region.ProjectImage;
import com.yinghuaicc.stars.repository.model.tissue.Employee;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.TriangeConditionRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.TriangeConditionResponseDTO;
import com.yinghuaicc.stars.service.region.dto.request.*;
import com.yinghuaicc.stars.service.region.dto.response.*;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/27 上午1:12
 * @Description: 行政区服务
 * @Modified:
 */
public interface RegionService {

    /**
     *@Author:Fly Created in 2018/7/4 上午12:53
     *@Description: 添加项目
     */
    void saveProject(SaveProjectRequestDTO saveProjectRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/4 上午12:55
     *@Description: 编辑项目
     */
    void editProject(EditProjectRequestDTO editProjectRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/11 下午2:35
     *@Description: 根据公司查询项目
     */
    List<FindProjectByCompanyIdResponseDTO> findProjectByCompanyId(String companyId);

    /**
     *@Author:Fly Created in 2018/7/11 下午2:09
     *@Description: 删除项目
     */
    void removeProject(String id);

    /**
     *@Author:Fly Created in 2018/7/20 上午10:11
     *@Description: 按照区域查询项目
     */
    List<FindProjectByAreaIdResponseDTO> findProjectByAreaId(String areaId);

    /**
     *@Description: 根据项目查询项目图片
     */
    List<ProjectImage> findProjectImageByProjectId(String projectId);

    /**
     *@Author:Fly Created in 2018/7/11 下午3:19
     *@Description: 添加层
     */
    void saveFloor(SaveFloorRequestDTO saveFloorRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/11 下午3:19
     *@Description: 编辑层
     */
    void editFloor(EditFloorRequestDTO editFloorRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/11 下午5:27
     *@Description: 删除层
     */
    void removeFloor(String id);

    /**
     *@Author:Fly Created in 2018/7/12 上午12:54
     *@Description: 添加铺位
     */
    void saveRoom(SaveRoomRequestDTO saveRoomRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/12 上午1:05
     *@Description: 编辑铺位
     */
    void editRoom(EditRoomRequestDTO editRoomRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/12 上午1:06
     *@Description: 删除铺位
     */
    void removeRoom(String id);

    /**
     *@Author:Fly Created in 2018/7/16 下午1:34
     *@Description: 根据层查询铺位
     */
    List<FindRoomByFloorIdResponseDTO> findRoomByFloorId(String floorId);

    /**
     *@Author:Fly Created in 2018/7/11 下午11:13
     *@Description: 按照楼栋查询层
     */
    List<FindFloorByBuildingIdResponseDTO> findFloorByBuildingId(String id);

    /**
     *@Author:Fly Created in 2018/7/4 下午4:39
     *@Description: 添加公司
     */
    void saveCompany(SaveCompanyRequestDTO saveCompanyRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/11 下午10:51
     *@Description: 根据项目查询楼栋信息
     */
    List<FindBuildingByProjectIdResponseDTO> findBuildingByProjectId(String projectId);

    /**
     *@Author:Fly Created in 2018/7/4 下午4:59
     *@Description: 查询所有区域
     */
    List<FindAreaAllResponseDTO> findAreaAll();

    /**
     *@Author:Fly Created in 2018/7/4 下午5:01
     *@Description: 按照区域id查询公司
     */
    List<FindCompanyByAreaIdResponseDTO> findCompanyByAreaId(String areaId);

    /**
     *@Author:Fly Created in 2018/7/27 下午3:23
     *@Description: 查询所有公司
     */
    List<FindCompanyByAreaIdResponseDTO> findCompanyAll();

    /**
     *@Author:Fly Created in 2018/7/5 下午3:15
     *@Description: 查询所有项目数据权限
     */
    List<FindProjectAllResponseDTO> findProjectAll();

    /**
     *@Author:Fly Created in 2018/7/18 上午11:11
     *@Description: 所有组织机构树
     */
    List<FindCompanyTreeResponseDTO> orgTreeAll();

    /**
     *@Author:Fly Created in 2018/7/28 下午12:35
     *@Description: 查询公司下员工
     */
    List<Employee> findEmployeeByCompanyId(String companyId);

    /**
     * 通过条件查询业态list
     * @param triangeConditionRequestDTO
     * @return
     */
    List<TriangeConditionResponseDTO> findConditionlistByOtherId(TriangeConditionRequestDTO triangeConditionRequestDTO);

    /**
     * 通过项目id 查询楼层
     * @param projectId
     * @return
     */
    List<Floor> findFloorByProjectId(String projectId);

}
