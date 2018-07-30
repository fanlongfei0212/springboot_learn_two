package com.yinghuaicc.stars.repository.mapper.standard;

import com.yinghuaicc.stars.repository.model.standard.StandardProjectRent;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardProjectRentRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardProjectRentResponseDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StandardProjectRentMapper {


    /**
     * 标准三角形通过项目id获取项目溢租率
     * @param standardProjectRentRequestDTO
     * @return
     */
    @Select("<script>select * from yhcc_standard_project_rent " +
            " <where> " +
            "<bind name='search.projectId' value='search.projectId' /> " +
            "<if test='search.projectId != null'>AND project_id = #{search.projectId}</if> " +
            "</where> " +
            "</script>")
    List<StandardProjectRentResponseDTO> findStandardProjectRentByStandardProjectRentCQRS(@Param("search") StandardProjectRentRequestDTO standardProjectRentRequestDTO);


    /**
     * 通过项目id查询标准三角形溢租率
     * @param projectId
     * @return
     */
    @Select("select * from yhcc_standard_project_rent where project_id = #{projectId}")
    StandardProjectRentResponseDTO findStandardProjectRentByProjectId(@Param("projectId") String projectId);

    /**
     * 新增项目溢租率
     * @param standardProjectRent
     */
    @Insert("insert into yhcc_standard_project_rent " +
            "values(#{id},#{standardVerssionId}},#{standardVerssionName}},#{projectId}},#{projectName}},#{rent}},#{createTime}},#{modifyTime}},#{createUser}},#{modifyUser}},#{status})")
    void saveStandardProjectRent(StandardProjectRent standardProjectRent);

}
