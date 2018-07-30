package com.yinghuaicc.stars.repository.mapper.cqrs.region;

import com.yinghuaicc.stars.service.cqrs.region.dto.request.FloorCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.region.dto.request.ProjectCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.region.dto.request.RoomCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.region.dto.response.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/3 下午5:43
 * @Description: 区域
 * @Modified:
 */
@Repository
public interface RegionCQRSMapper {

    /**
     *@Author:Fly Created in 2018/7/3 下午7:17
     *@Description: 项目管理列表
     */
    @Select("<script> " +
            "select " +
            "p.id as projectId, " +
            "p.name as projectName, " +
            "a.name as areaName, " +
            "c.name as companyName, " +
            "p.create_time as createTime, " +
            "p.modify_time as modifyTime, " +
            "e.name as projectHeadName, " +
//            "er.name as projectAuditName, " +
            "p.state as state, " +
            "p.acreage as acreage " +
            "from yhcc_project as p " +
            "inner join yhcc_company as c on p.company_id = c.id " +
            "inner join yhcc_area as a on p.area_id = a.id " +
            "inner join yhcc_employee as e on e.id = p.project_head_id " +
//            "inner join yhcc_employee as er on er.id = p.project_audit_id " +
            "<where> " +
            "p.id in " +
            "<foreach item='item' collection='list' open='(' close=')' separator=','> " +
            "#{item} " +
            "</foreach> " +
            "<bind name='search.projectName' value=\"'%' + search.projectName + '%'\" /> " +
            "<bind name='search.employeeName' value=\"'%' + search.employeeName + '%'\" /> " +
            "<bind name='search.areaId' value='search.areaId' /> " +
            "<bind name='search.companyId' value='search.companyId' /> " +
            "<bind name='search.createTimeBegin' value='search.createTimeBegin' /> " +
            "<bind name='search.createTimeEnd' value='search.createTimeEnd' /> " +
            "<if test='search.projectName != null and search.projectName !=\"\" '>AND p.name like #{search.projectName}</if> " +
            "<if test='search.employeeName != null and search.employeeName !=\"\" '>AND e.name like #{search.employeeName}</if> " +
            "<if test='search.areaId != null and search.areaId !=\"\" '>AND a.id = #{search.areaId}</if> " +
            "<if test='search.companyId != null and search.companyId !=\"\" '>AND c.id = #{search.companyId}</if> " +
            "<if test='search.createTimeBegin != null'>AND p.create_time &gt; #{search.createTimeBegin}</if> " +
            "<if test='search.createTimeEnd != null'>AND p.create_time &lt; #{search.createTimeEnd}</if> " +
            "</where> " +
            "order by p.modify_time desc " +
            "</script>")
    List<ProjectCQRSListResponseDTO> findProjectCQRS(@Param("list") List<String> projectIds, @Param("search") ProjectCQRSListRequestDTO projectCQRSListRequestDTO);


    /**
     *@Author:Fly Created in 2018/7/4 下午2:13
     *@Description: 项目详情
     */
    @Select("select " +
            "p.id as projectId, " +
            "p.name as projectName, " +
            "a.name as areaName, " +
            "a.id as areaId, " +
            "c.id as companyId, " +
            "c.name as companyName, " +
            "e.name as employeeName, " +
            "e.phone as projectRelationPhone, " +
            "p.create_time as createTime, " +
            "p.modify_time as modifyTime, " +
            "e.name as projectHeadName, " +
            "e.id as projectHeadId, " +
            "d.id as deptId, " +
            "d.name as deptName, " +
            "p.state as state, " +
            "err.name as modifyUserName, " +
            "p.acreage as acreage " +
            "from yhcc_project as p " +
            "inner join yhcc_company as c on p.company_id = c.id " +
            "inner join yhcc_area as a on p.area_id = a.id " +
            "inner join yhcc_employee as e on e.id = p.project_head_id " +
            "inner join yhcc_employee as err on err.id = p.modify_user " +
            "inner join yhcc_department as d on d.id = e.org_id " +
            "where p.id = #{projectId}")
    ProjectCQRSInfoByIdResponseDTO findProjectByIdCQRS(String projectId);

    /**
     *@Author:Fly Created in 2018/7/11 下午3:27
     *@Description: 层详情
     */
    @Select("select " +
            "fl.id as id, " +
            "pr.area_id as areaId, " +
            "ar.name as areaName, " +
            "fl.company_id as companyId, " +
            "co.name as companyName, " +
            "fl.project_id as projectId, " +
            "pr.name as projectName, " +
            "fl.building_id as buildingId, " +
            "bu.name as buildingName, " +
            "fl.name as name, " +
            "fl.location as location, " +
            "fl.acreage as acreage, " +
            "fl.state as state, " +
            "fl.create_time as createTime, " +
            "fl.modify_time as modifyTime, " +
            "fl.create_user as createUser, " +
            "fl.modify_user as modifyUser, " +
            "em.name as createUserName, " +
            "emp.name as modifyUserName " +
            "from yhcc_floor as fl " +
            "inner join yhcc_company as co on fl.company_id = co.id " +
            "inner join yhcc_project as pr on fl.project_id = pr.id " +
            "inner join yhcc_building as bu on fl.building_id = bu.id " +
            "inner join yhcc_employee as em on fl.create_user = em.id " +
            "inner join yhcc_employee as emp on fl.modify_user = emp.id " +
            "inner join yhcc_area as ar on pr.area_id = ar.id " +
            "where fl.id = #{floorId}")
    FloorCQRSInfoByIdResponseDTO findFloorByIdCQRS(String floorId);

    /**
     *@Author:Fly Created in 2018/7/11 下午5:14
     *@Description: 查询层列表
     */
    @Select("<script> " +
            "select " +
            "fl.id as id, " +
            "fl.name as name, " +
            "pr.name as projectName, " +
            "bu.name as buildingName, " +
            "fl.name as name, " +
            "ar.name as areaName, " +
            "fl.location as location, " +
            "fl.acreage as acreage, " +
            "fl.state as state, " +
            "fl.create_time as createTime, " +
            "fl.modify_time as modifyTime, " +
            "fl.create_user as createUser, " +
            "fl.modify_user as modifyUser " +
            "from yhcc_floor as fl " +
            "inner join yhcc_project as pr on fl.project_id = pr.id " +
            "inner join yhcc_building as bu on fl.building_id = bu.id " +
            "inner join yhcc_area as ar on pr.area_id = ar.id " +
            "<where> " +
            "<bind name='areaId' value='areaId' /> " +
            "<bind name='companyId' value='companyId' /> " +
            "<bind name='projectName' value=\"'%' + projectName + '%'\" /> " +
            "<bind name='location' value='location' /> " +
            "<if test='areaId != null and areaId !=\"\" '>AND pr.area_id = #{areaId}</if> " +
            "<if test='companyId != null and companyId !=\"\" '>AND fl.company_id = #{companyId}</if> " +
            "<if test='projectName != null and projectName !=\"\" '>AND pr.name like #{projectName}</if> " +
            "<if test='location != null '>AND fl.location = #{location}</if> " +
            "order by fl.modify_time desc " +
            "</where> " +
            "</script>")
    List<FloorCQRSListResponseDTO> findFloorListCQRS(FloorCQRSListRequestDTO floorCQRSListRequestDTO);

    /**
     *@Author:Fly Created in 2018/7/11 下午11:54
     *@Description: 查询铺位详情
     */
    @Select("<script> " +
            "select " +
            "ro.id as id, " +
            "ro.name as name, " +
            "ar.id as areaId, " +
            "ar.name as areaName, " +
            "ro.company_id as companyId, " +
            "co.name as companyName, " +
            "ro.project_id as projectId, " +
            "pr.name as projectName, " +
            "ro.building_id as buildingId, " +
            "bu.name as buildingName, " +
            "ro.floor_id as floorId, " +
            "fl.name as floorName, " +
            "ro.acreage as acreage, " +
            "ro.state as state, " +
            "ro.create_time as createTime, " +
            "ro.modify_time as modifyTime, " +
            "ro.create_user as createUser, " +
            "ro.modify_User as modifyUser, " +
            "em.name as createUserName, " +
            "emp.name as modifyUserName " +
            "from yhcc_room as ro " +
            "inner join yhcc_company as co on ro.company_id = co.id " +
            "inner join yhcc_project as pr on ro.project_id = pr.id " +
            "inner join yhcc_area as ar on pr.area_id = ar.id " +
            "inner join yhcc_building as bu on ro.building_id = bu.id " +
            "inner join yhcc_floor as fl on ro.floor_id = fl.id " +
            "inner join yhcc_employee as em on ro.create_user = em.id " +
            "inner join yhcc_employee as emp on ro.modify_user = emp.id " +
            "where ro.id = #{roomId} " +
            "</script> ")
    RoomCQRSInfoByIdResponseDTO findRoomByIdCQRS(String roomId);

    /**
     *@Author:Fly Created in 2018/7/12 上午12:21
     *@Description: 查询铺位列表
     */
    @Select("<script> " +
            "select " +
            "ro.id as id, " +
            "ro.num as num, " +
            "ro.name as name, " +
            "ar.name as areaName, " +
            "co.name as companyName, " +
            "pr.name as projectName, " +
            "bu.name as buildingName, " +
            "fl.name as floorName, " +
            "ro.acreage as acreage, " +
            "ro.state as state, " +
            "ro.create_time as createTime, " +
            "ro.modify_time as modifyTime " +
            "from yhcc_room as ro " +
            "inner join yhcc_company as co on ro.company_id = co.id " +
            "inner join yhcc_project as pr on ro.project_id = pr.id " +
            "inner join yhcc_area as ar on pr.area_id = ar.id " +
            "inner join yhcc_building as bu on ro.building_id = bu.id " +
            "inner join yhcc_floor as fl on ro.floor_id = fl.id " +
            "inner join yhcc_employee as em on ro.create_user = em.id " +
            "inner join yhcc_employee as emp on ro.modify_user = emp.id " +
            "<where> " +
            "<bind name='search.areaId' value='search.areaId' /> " +
            "<bind name='search.companyId' value='search.companyId' /> " +
            "<bind name='search.projectId' value='search.projectId' /> " +
            "<bind name='search.roomName' value=\"'%' + search.roomName + '%'\" /> " +
            "<bind name='search.state' value='search.state' /> " +
            "<bind name='search.createTimeBegin' value='search.createTimeBegin' /> " +
            "<bind name='search.createTimeEnd' value='search.createTimeEnd' /> " +
            "<if test='search.areaId != null and search.areaId !=\"\" '>AND pr.area_id = #{search.areaId}</if> " +
            "<if test='search.companyId != null and search.companyId !=\"\" '>AND ro.company_id = #{search.companyId}</if> " +
            "<if test='search.projectId != null and search.projectId !=\"\" '>AND ro.project_id = #{search.projectId}</if> " +
            "<if test='search.roomName != null and search.roomName !=\"\" '>AND ro.name like #{search.roomName}</if> " +
            "<if test='search.state != null '>AND ro.state = #{search.state}</if> " +
            "<if test='search.createTimeBegin != null '>AND ro.create_time &gt; #{search.createTimeBegin}</if> " +
            "<if test='search.createTimeEnd != null '>AND ro.create_time &lt; #{search.createTimeEnd}</if> " +
            "</where> " +
            "order by ro.modify_time desc" +
            "</script> ")
    List<RoomCQRSListResponseDTO> findRoomListCQRS(@Param("search") RoomCQRSListRequestDTO roomCQRSListRequestDTO);

    /**
     *@Author:Fly Created in 2018/7/16 下午8:35
     *@Description: 根据项目查询未签约铺位
     */
    @Select("<script> " +
            "select " +
            "ro.id as roomId, " +
            "ro.name as roomName, " +
            "fl.name as floorName " +
            "from yhcc_room as ro " +
            "inner join yhcc_floor as fl on ro.floor_id = fl.id " +
            "<where> " +
            "<bind name='projectId' value='projectId' /> " +
            "<bind name='roomName' value=\"'%' + roomName + '%'\" /> " +
            "<if test='projectId != null and projectId !=\"\" '>AND ro.project_id = #{projectId} AND ro.state = 1 </if> " +
            "<if test='roomName != null and roomName !=\"\" '>AND ro.name like #{roomName}</if> " +
            "</where> " +
            "</script> ")
    List<FindRoomByProjectCQRSResponseDTO> findRoomByProjectCQRS(@Param("projectId") String projectId, @Param("roomName") String roomName);
}
