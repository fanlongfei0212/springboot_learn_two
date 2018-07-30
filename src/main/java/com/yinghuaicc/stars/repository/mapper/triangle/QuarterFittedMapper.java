package com.yinghuaicc.stars.repository.mapper.triangle;

import com.yinghuaicc.stars.repository.model.triangle.QuarterFitted;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.QuarterFittedRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.QuarterFittedResponseDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 季度适配值
 */
@Repository
public interface QuarterFittedMapper {

    /**
     * 通过版本id查询季度适配值
     * @param quarterFittedRequestDTO
     * @return
     */
    @Select("<script>" +
            "select * from yhcc_quarter_fitted" +
            " <where> " +
            "<bind name='search.fittedVerssionId' value='search.fittedVerssionId' /> " +
            "<if test='search.fittedVerssionId != null'>AND fitted_verssion_id = #{search.fittedVerssionId}</if> " +
            "</where> " +
            "</script>")
    List<QuarterFittedResponseDTO> findQuarterFittedCQRS(@Param("search") QuarterFittedRequestDTO quarterFittedRequestDTO);


    /**
     * 通过签约id 查询适配值
     * @param contractId
     * @param time
     * @return
     */
    @Select("<script>" +
            "select * from yhcc_quarter_fitted" +
            " <where> " +
            "<bind name='contractId' value='contractId' /> " +
            "<bind name='time' value='time' /> " +
            "<if test='contractId!= null'>AND contract_id = #{contractId}</if> " +
            "<if test='time != null'>AND startTime &lt;= #{time}</if> " +
            "<if test='time != null'>AND endTime &gt;= #{time}</if> " +
            "</where> " +
            "</script>")
    QuarterFittedResponseDTO findQuarterFittedResponseDTOByContractId(String contractId, LocalDateTime time);

    /**
     * 保存动态三角形适配值
     * @param quarterFitted
     */
    @Insert("insert into yhcc_quarter_fitted" +
            "values( #{id}, #{contractId}, #{contractName}, #{projectName}, #{floorName}, #{roomName}, #{conditionName}, #{majoName}, #{contractStatus}, #{fittedVerssionId}, #{marketPosition}, #{brandPosition}" +
            ", #{brandImage}, #{rentalRate}, #{chainDegree}, #{complaintDegree}, #{layoutDegree}, #{startTime}, #{endTime}, #{createTime}, #{modifyTime}, #{createUser}, #{modifyUser}")
    void saveQuarterFitted(QuarterFitted quarterFitted);

    /**
     * 修改动态三角形适配值
     * @param quarterFitted
     */
    @Update("update yhcc_quarter_fitted set contract_id = #{contractId} ,contract_name = #{contractName} ,project_name = #{projectName} " +
            ",floor_name = #{floorName} ,condition_name = #{conditionName} ,majo_name = #{majoName} ,contract_status = #{contractStatus}" +
            " ,fitted_verssion_id = #{fittedVerssionId} ,market_position = #{marketPosition} ,brand_position = #{brandPosition} ,brand_image = #{brandImage}" +
            " ,rental_rate = #{rentalRate} ,chain_degree = #{chainDegree} ,complaint_degree = #{complaintDegree} ,layout_degree = #{layoutDegree}" +
            " ,startTime = #{startTime} ,endTime = #{endTime} ,createTime = #{createTime} ,modifyTime = #{modifyTime},createUser = #{createUser},modifyUser = #{modifyUser}")
    void editQuarterFitted(QuarterFitted quarterFitted);
}
