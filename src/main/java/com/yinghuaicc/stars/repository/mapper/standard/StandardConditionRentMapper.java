package com.yinghuaicc.stars.repository.mapper.standard;

import com.yinghuaicc.stars.repository.model.standard.StandardConditionRent;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardConditionRentRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardFloorRentRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardConditionRentResponseDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardProjectRentResponseDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StandardConditionRentMapper {




    @Select("<script>select * from yhcc_standard_condition_rent " +
            " <where> " +
            "<bind name='search.projectId' value='search.projectId' /> " +
            "<bind name='search.conditionId' value='search.conditionId' /> " +
            "<bind name='search.conditionName' value='search.conditionName' /> " +
            "<bind name='search.majoId' value='search.majoId' /> " +
            "<bind name='search.majoName' value='search.majoName' /> " +
            "<if test='search.projectId != null'>AND project_id = #{search.projectId}</if> " +
            "<if test='search.conditionId != null'>AND condition_id = #{search.conditionId}</if> " +
            "<if test='search.conditionName != null'>AND condition_name = #{search.conditionName}</if> " +
            "<if test='search.majoId != null'>AND majo_id = #{search.majoId}</if> " +
            "<if test='search.majoName != null'>AND majo_name = #{search.majoName}</if> " +
            "</where> " +
            "</script>")
    List<StandardConditionRentResponseDTO> findStandardConditionRentByStandardConditionRentCQRS(@Param("search") StandardConditionRentRequestDTO standardConditionRentRequestDTO);

    /**
     * 新增标准三角形业态溢租率
     * @param standardConditionRent
     */
    @Insert("insert into yhcc_standard_condition_rent " +
            "values(#{id},#{standardVerssionId},#{standardVerssionName},#{projectId},#{projectName},#{conditionId}," +
            "#{conditionName},#{majoId},#{majoName},#{rent},#{createTime},#{modifyTime},#{createUser},#{modifyUser},#{status})")
    void saveStandardConditionRent(StandardConditionRent standardConditionRent);


}
