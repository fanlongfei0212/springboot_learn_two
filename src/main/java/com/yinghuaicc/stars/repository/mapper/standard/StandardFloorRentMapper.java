package com.yinghuaicc.stars.repository.mapper.standard;

import com.yinghuaicc.stars.repository.model.standard.StandardFloorRent;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardFloorRentRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardFloorRentResponseDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StandardFloorRentMapper {




    @Select("<script>select * from yhcc_standard_floor_rent " +
            " <where> " +
            "<bind name='search.projectId' value='search.projectId' /> " +
            "<bind name='search.floorId' value='search.floorId' /> " +
            "<bind name='search.floorName' value='search.floorName' /> " +
            "<if test='search.projectId != null'>AND project_id = #{search.projectId}</if> " +
            "<if test='search.floorId != null'>AND floor_id = #{search.floorId}</if> " +
            "<if test='search.floorName != null'>AND floor_name = #{search.floorName}</if> " +
            "</where> " +
            "</script>")
    List<StandardFloorRentResponseDTO> findStandardFloorRentByStandardFloorRentCQRS(@Param("search") StandardFloorRentRequestDTO standardFloorRentRequestDTO);

    /**
     * 通过项目id、楼层id查询 标准三角形楼层溢租率
     * @param projectId
     * @param floorId
     * @return
     */
    @Select("select * from yhcc_standard_floor_rent where project_id = #{projectId} and floor_id = #{floorId}")
    StandardFloorRentResponseDTO findStandardFloorRentByProjectIdAndFloorId(@Param("projectId") String projectId, @Param("floorId") String floorId);

    /**
     * 导入楼层溢租率
     * @param standardFloorRent
     */
    @Insert("insert into  yhcc_standard_floor_rent" +
            "values(#{id},#{standardVerssionId},#{standardVerssionName},#{projectId},#{projectName},#{floorId},#{floorName},#{rent},#{createTime},#{modifyTime},#{createUser},#{modifyUser},#{status})")
    void saveStandardFloorRent(StandardFloorRent standardFloorRent);

}
