package com.yinghuaicc.stars.repository.mapper.standard;

import com.yinghuaicc.stars.repository.model.standard.StandardFloorFitted;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardFloorFittedRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardFloorFittedResponseDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StandardFloorFittedMapper {




    @Select("<script>select * from yhcc_standard_floor_Fitted " +
            " <where> " +
            "<bind name='search.projectId' value='search.projectId' /> " +
            "<bind name='search.floorId' value='search.floorId' /> " +
            "<bind name='search.floorName' value='search.floorName' /> " +
            "<if test='search.projectId != null'>AND project_id = #{search.projectId}</if> " +
            "<if test='search.floorId != null'>AND floor_id = #{search.floorId}</if> " +
            "<if test='search.floorName != null'>AND floor_name = #{search.floorName}</if> " +
            "</where> " +
            "</script>")
    List<StandardFloorFittedResponseDTO> findStandardFloorFittedByStandardFloorFittedCQRS(@Param("search") StandardFloorFittedRequestDTO standardFloorFittedRequestDTO);

    /**
     * 通过项目id、楼层id 查询标准三角形楼层级适配值
     * @param projectId
     * @param floorId
     * @return
     */
    @Select("select * from yhcc_standard_floor_Fitted where project_id = #{projectId} and floor_id = #{floorId}")
    StandardFloorFittedResponseDTO findstandardFloorFittedByProjectIdAndFloorId(@Param("projectId") String projectId, @Param("floorId") String floorId);


    /**
     * 添加楼层适配值
     * @param standardFloorFitted
     */
    @Insert("insert into yhcc_standard_floor_Fitted " +
            "values(#{id},#{standardVerssionId},#{standardVerssionName},#{projectId},#{projectName}," +
            "#{floorId},#{floorName},#{fitted},#{createTime},#{createTime},#{modifyTime},#{createUser},#{modifyUser},#{status})")
    void saveStandardFloorFitted(StandardFloorFitted standardFloorFitted);


}
