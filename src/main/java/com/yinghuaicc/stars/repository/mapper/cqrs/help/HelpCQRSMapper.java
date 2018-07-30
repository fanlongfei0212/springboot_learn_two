package com.yinghuaicc.stars.repository.mapper.cqrs.help;

import com.yinghuaicc.stars.service.cqrs.help.dto.request.FindHelpPlanFloorListCQRSRequestDTO;
import com.yinghuaicc.stars.service.cqrs.help.dto.request.FindHelpPlanProjectListCQRSRequestDTO;
import com.yinghuaicc.stars.service.cqrs.help.dto.response.FindHelpPlanBusinessSpeciesListCQRSResponseDTO;
import com.yinghuaicc.stars.service.cqrs.help.dto.response.FindHelpPlanFloorListCQRSResponseDTO;
import com.yinghuaicc.stars.service.cqrs.help.dto.response.FindHelpPlanProjectListCQRSResponseDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/20 上午10:35
 * @Description: 项目帮扶计划
 * @Modified:
 */
@Repository
public interface HelpCQRSMapper {

    /**
     *@Author:Fly Created in 2018/7/20 上午10:56
     *@Description: 项目帮扶计划列表
     */
    @Select("<script> " +
            "select " +
            "hp.project_id as projectId, " +
            "pr.name as projectName, " +
            "hp.yx_help_context as yx, " +
            "hp.lh_help_context as lh, " +
            "hp.ts_help_context as ts, " +
            "hp.hl_help_context as hl, " +
            "hp.ks_help_context as ks " +
            "from yhcc_help_project as hp " +
            "inner join yhcc_project as pr on hp.project_id = pr.id " +
            "inner join yhcc_area as ar on pr.area_id = ar.id " +
            "<where> " +
            "<bind name='search.areaId' value='search.areaId' /> " +
            "<bind name='search.projectId' value='search.projectId' /> " +
            "<if test='search.areaId != null and search.areaId !=\"\" '>AND pr.area_id = #{search.areaId}</if> " +
            "<if test='search.projectId != null and search.projectId !=\"\" '>AND hp.project_id = #{search.projectId}</if> " +
            "</where> " +
            "order by hp.modify_time desc " +
            "</script> ")
    List<FindHelpPlanProjectListCQRSResponseDTO> findHelpPlanCQRSList(@Param("search") FindHelpPlanProjectListCQRSRequestDTO findHelpPlanProjectListCQRSRequestDTO);

    /**
     *@Author:Fly Created in 2018/7/20 下午8:08
     *@Description: 层帮扶计划
     */
    @Select("<script> " +
            "select " +
            "hp.project_id as projectId, " +
            "pr.name as projectName, " +
            "fl.name as floorName, " +
            "hp.floor_id as floorId, " +
            "hp.yx_help_context as yx, " +
            "hp.lh_help_context as lh, " +
            "hp.ts_help_context as ts, " +
            "hp.hl_help_context as hl, " +
            "hp.ks_help_context as ks " +
            "from yhcc_help_floor as hp " +
            "inner join yhcc_project as pr on hp.project_id = pr.id " +
            "inner join yhcc_area as ar on pr.area_id = ar.id " +
            "inner join yhcc_floor as fl on hp.floor_id = fl.id " +
            "<where> " +
            "<bind name='search.areaId' value='search.areaId' /> " +
            "<bind name='search.projectId' value='search.projectId' /> " +
            "<bind name='search.floorId' value='search.floorId' /> " +
            "<if test='search.areaId != null and search.areaId !=\"\" '>AND pr.area_id = #{search.areaId}</if> " +
            "<if test='search.projectId != null and search.projectId !=\"\" '>AND hp.project_id = #{search.projectId}</if> " +
            "<if test='search.floorId != null and search.floorId !=\"\" '>AND hp.floor_id = #{search.floorId}</if> " +
            "</where> " +
            "order by hp.modify_time desc " +
            "</script> ")
    List<FindHelpPlanFloorListCQRSResponseDTO> findHelpPlanFloorCQRSList(@Param("search") FindHelpPlanFloorListCQRSRequestDTO findHelpPlanFloorListCQRSRequestDTO);

    /**
     *@Author:Fly Created in 2018/7/21 下午1:55
     *@Description: 业种帮扶计划
     */
    @Select("<script> " +
            "select " +
            "hp.project_id as projectId, " +
            "pr.name as projectName, " +
            "ar.id as businessFormId, " +
            "ar.name as businessFormName, " +
            "fl.id as businessSpeciesId, " +
            "fl.name as businessSpeciesName, " +
            "hp.yx_help_context as yx, " +
            "hp.lh_help_context as lh, " +
            "hp.ts_help_context as ts, " +
            "hp.hl_help_context as hl, " +
            "hp.ks_help_context as ks " +
            "from yhcc_help_business_species as hp " +
            "inner join yhcc_project as pr on hp.project_id = pr.id " +
            "inner join yhcc_business_form as ar on hp.business_form_id = ar.id " +
            "inner join yhcc_business_species as fl on hp.business_species_id = fl.id " +
            "<where> " +
            "<bind name='projectId' value='projectId' /> " +
            "<if test='projectId != null and projectId !=\"\" '>AND hp.project_id = #{projectId}</if> " +
            "</where> " +
            "order by hp.modify_time desc " +
            "</script> ")
    List<FindHelpPlanBusinessSpeciesListCQRSResponseDTO> findHelpPlanBusinessSpeciesCQRSList(@Param("projectId") String projectId);
}
