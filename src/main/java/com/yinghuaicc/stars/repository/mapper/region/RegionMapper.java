package com.yinghuaicc.stars.repository.mapper.region;

import com.yinghuaicc.stars.repository.model.region.*;
import com.yinghuaicc.stars.repository.model.tissue.Employee;
import com.yinghuaicc.stars.repository.model.tissue.EmployeeProjectData;
import com.yinghuaicc.stars.repository.model.tissue.EmployeeProjectRelationTeam;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.TriangeConditionRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.TriangeConditionResponseDTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/27 上午1:10
 * @Description: 行政区
 * @Modified:
 */
@Repository
public interface RegionMapper {

    /**
     *@Author:Fly Created in 2018/7/5 上午1:52
     *@Description: 查询所有项目
     */
    @Select("select * from yhcc_project")
    List<Project> findProjectAll();

    /**
     *@Author:Fly Created in 2018/7/4 上午12:07
     *@Description: 添加项目
     */
    @Insert("insert into yhcc_project " +
            "values(#{id}, #{num}, #{areaId}, #{companyId}, " +
            "#{name}, #{projectHeadId}, #{projectAuditId}, " +
            "#{state}, #{acreage}, #{createTime}, #{modifyTime}, " +
            "#{createUser}, #{modifyUser})")
    void saveProject(Project project);

    /**
     *@Author:Fly Created in 2018/7/4 上午12:09
     *@Description: 通过项目id查询项目
     */
    @Select("select * from yhcc_project where id = #{id}")
    Project findProjectById(String id);

    /**
     *@Author:Fly Created in 2018/7/5 下午3:47
     *@Description: 通过项目批量查询项目
     */
    @Select("<script> " +
            "select * from yhcc_project where id in " +
            "<foreach item='item' collection='list' open='(' close=')' separator=','> " +
            "#{item}" +
            "</foreach> " +
            "</script> ")
    List<Project> findProjectListById(List<String> ids);

    /**
     *@Author:Fly Created in 2018/7/4 上午12:13
     *@Description: 修改项目
     */
    @Update("update yhcc_project set num = #{num}, area_id = #{areaId}, company_id = #{companyId}, " +
            "name = #{name}, project_head_id = #{projectHeadId}, project_audit_id = #{projectAuditId}, " +
            "state = #{state}, acreage = #{acreage}, create_time = #{createTime}, modify_time = #{modifyTime}, " +
            "create_user = #{createUser}, modify_user = #{modifyUser} " +
            "where id = #{id}")
    void editProject(Project project);

    /**
     *@Author:Fly Created in 2018/7/11 下午2:08
     *@Description: 删除项目
     */
    @Delete("delete from yhcc_project where id = #{id}")
    void removeProject(String id);

    /**
     *@Author:Fly Created in 2018/7/11 下午2:30
     *@Description: 按照公司id查询项目
     */
    @Select("select * from yhcc_project where company_id = #{companyId}")
    List<Project> findProjectByCompanyId(String companyId);

    /**
     *@Author:Fly Created in 2018/7/20 上午10:08
     *@Description: 按照区域查询项目
     */
    @Select("select * from yhcc_project where area_id = #{areaId}")
    List<Project> findProjectByAreaId(String areaId);

    /**
     *@Author:Fly Created in 2018/7/5 上午10:06
     *@Description: 按照项目查询项目组员
     */
    @Select("select * from yhcc_employee_project_relation_team where project_id = #{id}")
    List<EmployeeProjectRelationTeam> findEmployeeProjectRelationTeamByProjectId(String projectId);

    /**
     *@Author:Fly Created in 2018/7/4 上午12:40
     *@Description: 添加项目负责人组员
     */
    @Insert("<script> " +
            "insert into yhcc_employee_project_relation_team " +
            "values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.employeeId}, #{item.projectId}, #{item.createTime}, " +
            "#{item.modifyTime}, #{item.createUser}, #{item.modifyUser}) " +
            "</foreach> " +
            "</script>")
    void saveEmployeeProjectRelationTeam(List<EmployeeProjectRelationTeam> employeeProjectRelationTeam);

    /**
     *@Author:Fly Created in 2018/7/4 上午11:18
     *@Description: 删除项目负责组员
     */
    @Delete("delete from yhcc_employee_project_relation_team where project_id = #{projectId}")
    void removeEmployeeProjectRelationTeam(String projectId);

    /**
     *@Author:Fly Created in 2018/7/5 上午10:17
     *@Description: 根据项目查询项目图片
     */
    @Select("select * from yhcc_project_image where project_id = #{projectId}")
    List<ProjectImage> findProjectImageByProjectId(String projectId);

    /**
     *@Author:Fly Created in 2018/7/4 下午1:16
     *@Description: 删除项目图片
     */
    @Delete("delete from yhcc_project_image where project_id = #{projectId}")
    void removeProjectImageByProjectId(String projectId);

    /**
     *@Author:Fly Created in 2018/7/4 下午1:37
     *@Description: 添加项目图片
     */
    @Insert("<script> " +
            "insert into yhcc_project_image " +
            "values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.projectId}, #{item.url}, " +
            "#{item.createTime}, #{item.modifyTime}, " +
            "#{item.createUser}, #{item.modifyUser}) " +
            "</foreach> " +
            "</script>")
    void saveProjectImage(List<ProjectImage> projectImages);

    /**
     *@Author:Fly Created in 2018/7/4 下午4:36
     *@Description: 添加公司
     */
    @Insert("<script> " +
            "insert into yhcc_company values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.num}, #{item.name}, #{item.parentId}, #{item.type}, " +
            "#{item.createTime}, #{item.modifyTime}, #{item.createUser}, #{item.modifyUser} )" +
            "</foreach> " +
            "</script>")
    void saveCompany(List<Company> companies);

    /**
     *@Author:Fly Created in 2018/7/4 下午4:56
     *@Description: 查询所有区域，除总部
     */
    @Select("select * from yhcc_area where level = 2")
    List<Area> findAreaAll();

    /**
     *@Author:Fly Created in 2018/7/4 下午5:03
     *@Description: 按照区域id查询公司
     */
    @Select("select * from yhcc_company where area_id = #{areaId}")
    List<Company> findCompanyByAreaId(String areaId);

    /**
     *@Author:Fly Created in 2018/7/27 下午3:25
     *@Description: 查询所有公司
     */
    @Select("select * from yhcc_company")
    List<Company> findCompany();

    /**
     *@Author:Fly Created in 2018/7/6 下午4:41
     *@Description: 按照公司id查询公司
     */
    @Select("select * from yhcc_company where id = #{id}")
    Company findCompanyById(String id);

    /**
     *@Author:Fly Created in 2018/7/18 上午10:51
     *@Description: 批量删除外部系统公司数据
     */
    @Delete("<script> " +
            "delete from yhcc_company where id in" +
            "<foreach item='item' collection='list' open='(' close=')' separator=','> " +
            "#{item}" +
            "</foreach> " +
            "and type = 2 " +
            "</script> ")
    void removeCompanyByIds(List<String> ids);

    /**
     *@Author:Fly Created in 2018/7/18 上午11:13
     *@Description: 查询所有公司
     */
    @Select("select * from yhcc_company")
    List<Company> findCompanyAll();

    /**
     *@Author:Fly Created in 2018/7/11 下午12:53
     *@Description: 添加楼栋
     */
    @Insert("<script> " +
            "insert into yhcc_building values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.num}, #{item.companyId}, #{item.projectId}, #{item.name}, " +
            "#{item.createTime}, #{item.modifyTime}, #{item.createUser}, #{item.modifyUser}) " +
            "</foreach> " +
            "</script>")
    void saveBuilding(List<Building> building);

    /**
     *@Author:Fly Created in 2018/7/11 下午1:53
     *@Description: 删除项目楼栋
     */
    @Delete("delete from yhcc_building where id = #{projectId}")
    void removeBuilding(String projectId);

    /**
     *@Author:Fly Created in 2018/7/11 下午1:56
     *@Description: 按照项目查询是否存在楼栋
     */
    @Select("select count(*) from yhcc_building where project_id = #{projectId}")
    Integer countBuildingByProjectId(String projectId);

    /**
     *@Author:Fly Created in 2018/7/11 下午10:54
     *@Description: 根据项目查询楼栋信息
     */
    @Select("select * from yhcc_building where project_id = #{projectId}")
    List<Building> findBuildingByProjectId(String projectId);

    /**
     *@Author:Fly Created in 2018/7/11 下午3:49
     *@Description: 按照楼栋id查询楼栋
     */
    @Select("select * from yhcc_building where id = #{id}")
    Building findBuildingById(String id);

    /**
     *@Author:Fly Created in 2018/7/11 下午2:12
     *@Description: 添加层
     */
    @Insert("<script> " +
            "insert into yhcc_floor values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.num}, #{item.companyId}, #{item.projectId}, #{item.buildingId}, #{item.name}, #{item.location}, " +
            "#{item.acreage}, #{item.state}, #{item.createTime}, #{item.modifyTime}, #{item.createUser}, #{item.modifyUser} ) " +
            "</foreach> " +
            "</script>")
    void saveFloor(List<Floor> floor);

    /**
     *@Author:Fly Created in 2018/7/11 下午2:19
     *@Description: 编辑层
     */
    @Update("update yhcc_floor set num = #{num}, company_id = #{companyId}, project_id = #{projectId}, building_id = #{buildingId}, name = #{name}, " +
            "location = #{location}, acreage = #{acreage}, state = #{state}, create_time = #{createTime}, modify_time = #{modifyTime}, " +
            "create_user = #{createUser}, modify_user = #{modifyUser} where id = #{id}")
    void editFloor(Floor floor);

    /**
     *@Author:Fly Created in 2018/7/11 下午2:20
     *@Description: 删除层
     */
    @Delete("delete from yhcc_floor where id = #{id}")
    void removeFloor(String id);

    /**
     *@Author:Fly Created in 2018/7/11 下午2:25
     *@Description: 根据id查询层
     */
    @Select("select * from yhcc_floor where id = #{id}")
    Floor findFloorById(String id);

    /**
     *@Author:Fly Created in 2018/7/11 下午5:31
     *@Description: 按照项目查询层
     */
    @Select("select * from yhcc_floor where project_id = #{projectId}")
    List<Floor> findFloorByProjectId(String projectId);

    /**
     *@Author:Fly Created in 2018/7/11 下午11:16
     *@Description: 按照楼栋查询层
     */
    @Select("select * from yhcc_floor where building_id = #{buildingId}")
    List<Floor> findFloorByBuildingId(String buildingId);

    /**
     *@Author:Fly Created in 2018/7/11 下午9:09
     *@Description: 统计项目中的层数量
     */
    @Select("select count(*) from yhcc_floor where project_id = #{projectId}")
    Integer countFloorByProjectId(String projectId);

    /**
     *@Author:Fly Created in 2018/7/11 下午9:09
     *@Description: 统计楼层下商铺的数量
     */
    @Select("select count(*) from yhcc_room where floor_id = #{floorId}")
    Integer countRoomByFloorId(String floorId);

    /**
     *@Author:Fly Created in 2018/7/11 下午11:26
     *@Description: 添加铺位信息
     */
    @Insert("<script> " +
            "insert into yhcc_room values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.num}, #{item.name}, #{item.companyId}, #{item.projectId}, #{item.buildingId}, " +
            "#{item.floorId}, #{item.state}, #{item.acreage}, #{item.createTime}, " +
            "#{item.modifyTime}, #{item.createUser}, #{item.modifyUser}) " +
            "</foreach> " +
            "</script>")
    void saveRoom(List<Room> rooms);

    /**
     *@Author:Fly Created in 2018/7/11 下午11:31
     *@Description: 编辑铺位信息
     */
    @Update("update yhcc_room set " +
            "num = #{num}, name = #{name}, company_id = #{companyId}, project_id = #{projectId}, building_id = #{buildingId}, " +
            "floor_id = #{floorId}, state = #{state}, acreage = #{acreage}, create_time = #{createTime}, modify_time = #{modifyTime}, create_user = #{createUser}, modify_user = #{modifyUser} " +
            "where id = #{id} ")
    void editRoom(Room room);

    /**
     *@Author:Fly Created in 2018/7/11 下午11:35
     *@Description: 删除铺位信息
     */
    @Delete("delete from yhcc_room where id = #{id} ")
    void removeRoom(String id);

    /**
     *@Author:Fly Created in 2018/7/12 上午1:17
     *@Description: 按照铺位id查询铺位
     */
    @Select("select * from yhcc_room where id = #{id}")
    Room findRoomById(String id);

    /**
     *@Author:Fly Created in 2018/7/16 下午1:35
     *@Description: 按照层查询铺位
     */
    @Select("select * from yhcc_room where floor_id = #{floorId}")
    List<Room> findRoomByFloorId(String floorId);

    /**
     * 通过条件查询业态list
     * @param triangeConditionRequestDTO
     * @return
     */
    @Select("<script> " +
            " select e.id as conditionId,e.name as conditionName " +
            " from yhcc_contract a " +
            " LEFT JOIN yhcc_project b on a.project_id = b.id " +
            " LEFT JOIN yhcc_floor c ON c.id = a.floor_id " +
            " LEFT JOIN yhcc_brand d ON d.id = a.brand_id " +
            " LEFT JOIN yhcc_business_form e ON e.id = d.business_form_id " +
            " <where> "  +
            "<bind name='search.projectId' value='search.projectId' /> " +
            "<bind name='search.floorId' value='search.floorId' /> " +
            "<if test='search.projectId != null and search.projectId !=\"\"'>AND a.project_id = #{search.projectId}</if> " +
            "<if test='search.floorId != null and search.floorId !=\"\"'>AND a.floor_Id = #{search.floorId}</if> " +
            " </where>" +
            " GROUP BY e.id " +
            "</script>")
    List<TriangeConditionResponseDTO> findConditionlistByOtherId(@Param("search") TriangeConditionRequestDTO triangeConditionRequestDTO);

}
