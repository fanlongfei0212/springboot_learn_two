package com.yinghuaicc.stars.repository.mapper.standard;

import com.yinghuaicc.stars.repository.model.standard.StandardConditionFitted;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardConditionFittedRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardConditionFittedResponseDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StandardConditionFittedMapper {


    /**
     * 根据条件查询
     * @param standardConditionFittedRequestDTO
     * @return
     */
    @Select("<script>select * from yhcc_standard_condition_fitted " +
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
    List<StandardConditionFittedResponseDTO> findStandardConditionFittedByStandardConditionFittedCQRS(@Param("search") StandardConditionFittedRequestDTO standardConditionFittedRequestDTO);

    /**
     * 添加业态适配值
     * @param standardConditionFitted
     */
    @Insert("insert into yhcc_standard_condition_fitted " +
            "values(#{id},#{standardVerssionId},#{standardVerssionName},#{projectId},#{projectName},#{conditionId}," +
            "#{conditionName},#{majoId},#{majoName},#{fitted},#{createTime},#{modifyTime},#{createUser},#{modifyUser},#{status})")
    void saveStandardConditionFitted(StandardConditionFitted standardConditionFitted);


}
