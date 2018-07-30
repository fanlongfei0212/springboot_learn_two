package com.yinghuaicc.stars.repository.mapper.standard;

import com.yinghuaicc.stars.repository.model.standard.StandardProjectFitted;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardProjectFittedRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardProjectRentRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardProjectFittedResponseDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardProjectRentResponseDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 标准三角形项目适配值
 */
@Repository
public interface StandardProjectFittedMapper {




    @Select("<script>select * from yhcc_standard_project_fitted " +
            " <where> " +
            "<bind name='search.projectId' value='search.projectId' /> " +
            "<if test='search.projectId != null'>AND project_id = #{search.projectId}</if> " +
            "</where> " +
            "</script>")
    List<StandardProjectFittedResponseDTO> findStandardProjectFittedByStandardProjectFittedCQRS(@Param("search") StandardProjectFittedRequestDTO standardProjectFittedRequestDTO);

    /**
     * 通过项目id查询标准三角形项目适配值
     * @param projectId
     * @return
     */
    @Select("select * from yhcc_standard_project_fitted where project_id = #{projectId}")
    StandardProjectFittedResponseDTO findstandardProjectFittedByProjectId(@Param("projectId") String projectId);

    /**
     * 保存标准三角形项目适配度
     * @param standardProjectFitted
     */
    @Insert("insert into yhcc_standard_project_fitted " +
            "values(#{id},#{standardVerssionId},#{standardVerssionName},#{projectId},#{projectName},#{fitted},#{createTime},#{modifyTime},#{createUser},#{modifyUser},#{status})")
    void saveStandardProjectFitted(StandardProjectFitted standardProjectFitted);



}
