package com.yinghuaicc.stars.repository.mapper.help;

import com.yinghuaicc.stars.repository.model.help.HelpContext;
import com.yinghuaicc.stars.repository.model.help.HelpPlanBusinessSpecies;
import com.yinghuaicc.stars.repository.model.help.HelpPlanFloor;
import com.yinghuaicc.stars.repository.model.help.HelpPlanProject;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/19 下午3:34
 * @Description: 帮扶计划
 * @Modified:
 */
@Repository
public interface HelpMapper {

    /**
     *@Author:Fly Created in 2018/7/19 下午4:00
     *@Description: 添加帮扶内容
     */
    @Insert("<script> " +
            "insert into yhcc_help_context values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.context}, #{item.type}, #{item.createTime}, #{item.modifyTime}, " +
            "#{item.createUser}, #{item.modifyUser} )" +
            "</foreach> " +
            "</script> ")
    void saveHelpContext(List<HelpContext> helpContext);

    /**
     *@Author:Fly Created in 2018/7/19 下午4:06
     *@Description: 编辑帮扶内容
     */
    @Update("update yhcc_help_context set " +
            "context = #{context}, type = #{type}, create_time = #{createTime}, modify_time = #{modifyTime}, " +
            "create_user = #{createUser}, modify_user = #{modifyUser} " +
            "where id = #{id} ")
    void editHelpContext(HelpContext helpContext);

    /**
     *@Author:Fly Created in 2018/7/19 下午4:12
     *@Description: 删除帮扶内容
     */
    @Delete("delete from yhcc_help_context where id = #{id}")
    void removeHelpContext(String id);

    /**
     *@Author:Fly Created in 2018/7/19 下午4:14
     *@Description: 查询帮扶内容列表
     */
    @Select("<script> " +
            "select * from yhcc_help_context " +
            "<where> " +
            "<bind name='search' value='search' />" +
            "<if test='search != null '>AND yhcc_help_context.type = #{search}</if> " +
            "</where> " +
            "</script>")
    List<HelpContext> findHelpContextList(@Param("search") Integer type);

    /**
     *@Author:Fly Created in 2018/7/19 下午4:31
     *@Description: 根据id查询帮扶内容
     */
    @Select("select * from yhcc_help_context where id = #{id}")
    HelpContext findHelpContextById(String id);

    /**
     *@Author:Fly Created in 2018/7/20 下午2:13
     *@Description: 根据id批量查询帮扶内容
     */
    @Select("<script> " +
            "select * from yhcc_help_context where id in " +
            "<foreach item='item' collection='list' open='(' close=')' separator=','> " +
            "#{item}" +
            "</foreach> " +
            "</script> ")
    List<HelpContext> findHelpContextByIds(List<String> ids);

    /**
     *@Author:Fly Created in 2018/7/20 上午10:19
     *@Description: 添加项目帮扶计划
     */
    @Insert("<script> " +
            "insert into yhcc_help_project values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.projectId}, #{item.yxHelpContext}, " +
            "#{item.lhHelpContext}, #{item.tsHelpContext}, " +
            "#{item.hlHelpContext}, #{item.ksHelpContext}, " +
            "#{item.createTime}, #{item.modifyTime}, " +
            "#{item.createUser}, #{item.modifyUser} )" +
            "</foreach> " +
            "</script> ")
    void saveHelpPlanProject(List<HelpPlanProject> helpPlanProjects);

    /**
     *@Author:Fly Created in 2018/7/20 下午5:15
     *@Description: 修改项目帮扶计划
     */
    @Update("update yhcc_help_project set " +
            "project_id = #{projectId}, yx_help_context = #{yxHelpContext}, lh_help_context = #{lhHelpContext}, " +
            "ts_help_context = #{tsHelpContext}, hl_help_context = #{hlHelpContext}, ks_help_context = #{ksHelpContext}, " +
            "create_time = #{createTime}, modify_time = #{modifyTime}, create_user = #{createUser}, modify_user = #{modifyUser} " +
            "where project_id = #{projectId}")
    void updateHelpPlanProject(HelpPlanProject helpPlanProject);

    /**
     *@Author:Fly Created in 2018/7/20 上午10:30
     *@Description: 删除项目帮扶计划
     */
    @Delete("delete from yhcc_help_project where project_id = #{projectId}")
    void removeHelpPlanProject(String projectId);

    /**
     *@Author:Fly Created in 2018/7/20 下午1:45
     *@Description: 查询项目帮扶计划，通过项目id
     */
    @Select("select * from yhcc_help_project where project_id = #{projectId}")
    HelpPlanProject findHelpPlanProjectByProjectId(String projectId);

    /**
     *@Author:Fly Created in 2018/7/20 下午5:59
     *@Description: 根据项目id查询项目帮扶计划是否存在
     */
    @Select("select count(*) from yhcc_help_project where project_id = #{projectId}")
    Integer countHelpPlanProjectByProjectId(String projectId);

    /**
     *@Author:Fly Created in 2018/7/20 下午7:38
     *@Description: 添加层帮扶计划
     */
    @Insert("<script> " +
            "insert into yhcc_help_floor values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.projectId}, #{item.floorId}, #{item.yxHelpContext}, " +
            "#{item.lhHelpContext}, #{item.tsHelpContext}, " +
            "#{item.hlHelpContext}, #{item.ksHelpContext}, " +
            "#{item.createTime}, #{item.modifyTime}, " +
            "#{item.createUser}, #{item.modifyUser} )" +
            "</foreach> " +
            "</script> ")
    void saveHelpPlanFloor(List<HelpPlanFloor> helpPlanFloors);

    /**
     *@Author:Fly Created in 2018/7/20 下午7:52
     *@Description: 编辑层帮扶计划
     */
    @Update("update yhcc_help_floor set " +
            "project_id = #{projectId}, floor_id = #{floorId}, yx_help_context = #{yxHelpContext}, lh_help_context = #{lhHelpContext}, " +
            "ts_help_context = #{tsHelpContext}, hl_help_context = #{hlHelpContext}, ks_help_context = #{ksHelpContext}, " +
            "create_time = #{createTime}, modify_time = #{modifyTime}, create_user = #{createUser}, modify_user = #{modifyUser} " +
            "where project_id = #{projectId} and floor_id = #{floorId}")
    void editHelpPlanFloor(HelpPlanFloor helpPlanFloor);

    /**
     *@Author:Fly Created in 2018/7/20 下午7:54
     *@Description: 按照项目id和层id查询层帮扶计划
     */
    @Select("select * from yhcc_help_floor where project_id = #{projectId} and floor_id = #{floorId}")
    HelpPlanFloor findHelpPlanFloorByProjectIdAndFloorId(@Param("projectId") String projectId, @Param("floorId") String floorId);

    /**
     *@Author:Fly Created in 2018/7/20 下午7:55
     *@Description: 查询项目、楼层下是否存在楼层帮扶计划
     */
    @Select("select count(*) from yhcc_help_floor where project_id = #{projectId} and floor_id = #{floorId}")
    Integer countHelpPlanFloorByProjectIdAndFloorId(@Param("projectId") String projectId, @Param("floorId") String floorId);

    /**
     *@Author:Fly Created in 2018/7/20 下午7:57
     *@Description: 删除层帮扶计划
     */
    @Delete("delete from yhcc_help_floor where project_id = #{projectId} and floor_id = #{floorId}")
    void removeHelpPlanFloorByProjectIdAndFloorId(@Param("projectId") String projectId, @Param("floorId") String floorId);

    /**
     *@Author:Fly Created in 2018/7/21 下午1:14
     *@Description: 添加业种帮扶计划
     */
    @Insert("<script> " +
            "insert into yhcc_help_business_species values " +
            "<foreach item = 'item' index = 'index' collection='list' separator=','> " +
            "(#{item.id}, #{item.projectId}, #{item.businessFormId}, #{item.businessSpeciesId}, #{item.yxHelpContext}, " +
            "#{item.lhHelpContext}, #{item.tsHelpContext}, " +
            "#{item.hlHelpContext}, #{item.ksHelpContext}, " +
            "#{item.createTime}, #{item.modifyTime}, " +
            "#{item.createUser}, #{item.modifyUser} )" +
            "</foreach> " +
            "</script> ")
    void saveHelpPlanBusinessSpecies(List<HelpPlanBusinessSpecies> helpPlanBusinessSpecies);

    /**
     *@Author:Fly Created in 2018/7/21 下午1:18
     *@Description: 编辑业种帮扶计划
     */
    @Update("update yhcc_help_business_species set " +
            "project_id = #{projectId}, business_form_id = #{businessFormId}, business_species_id = #{businessSpeciesId}, yx_help_context = #{yxHelpContext}, lh_help_context = #{lhHelpContext}, " +
            "ts_help_context = #{tsHelpContext}, hl_help_context = #{hlHelpContext}, ks_help_context = #{ksHelpContext}, " +
            "create_time = #{createTime}, modify_time = #{modifyTime}, create_user = #{createUser}, modify_user = #{modifyUser} " +
            "where project_id = #{projectId} and business_form_id = #{businessFormId} and business_species_id = #{businessSpeciesId}")
    void editHelpPlanBusinessSpecies(HelpPlanBusinessSpecies helpPlanBusinessSpecies);

    /**
     *@Author:Fly Created in 2018/7/21 下午1:24
     *@Description: 查询项目、业态、业种下的帮扶计划
     */
    @Select("select * from yhcc_help_business_species " +
            "where project_id = #{projectId} and business_form_id = #{businessFormId} and business_species_id = #{businessSpeciesId}")
    HelpPlanBusinessSpecies findHelpPlanBusinessSpeciesByProjectIdAndBusinessFormIdAndBusinessSpeciesId(
            @Param("projectId") String projectId,
            @Param("businessFormId") String businessFormId,
            @Param("businessSpeciesId") String businessSpeciesId);

    /**
     *@Author:Fly Created in 2018/7/21 下午1:29
     *@Description: 查询项目、业态、业种下是否存在帮扶计划
     */
    @Select("select count(*) from yhcc_help_business_species " +
            "where project_id = #{projectId} and business_form_id = #{businessFormId} and business_species_id = #{businessSpeciesId}")
    Integer countHelpPlanBusinessSpeciesByProjectIdAndBusinessFormIdAndBusinessSpeciesId(
            @Param("projectId") String projectId,
            @Param("businessFormId") String businessFormId,
            @Param("businessSpeciesId") String businessSpeciesId);

    /**
     *@Author:Fly Created in 2018/7/21 下午1:33
     *@Description: 删除项目、业态、业种下帮扶计划
     */
    @Delete("delete from yhcc_help_business_species " +
            "where project_id = #{projectId} and business_form_id = #{businessFormId} and business_species_id = #{businessSpeciesId}")
    void removeHelpPlanBusinessSpeciesByProjectIdAndBusinessFormIdAndBusinessSpeciesId(
            @Param("projectId") String projectId,
            @Param("businessFormId") String businessFormId,
            @Param("businessSpeciesId") String businessSpeciesId);
}
