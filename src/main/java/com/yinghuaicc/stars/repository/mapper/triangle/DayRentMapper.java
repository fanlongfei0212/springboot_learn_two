package com.yinghuaicc.stars.repository.mapper.triangle;

import com.yinghuaicc.stars.repository.model.triangle.DayRent;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.DayRentRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.DayRentResponseDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 每日溢租率
 */
@Repository
public interface DayRentMapper {

    @Select("<script>select * from yhcc_day_rent " +
            " <where> " +
            "<bind name='search.contractId' value='search.contractId' /> " +
            "<bind name='search.createTime' value='search.createTime ' /> " +
            "<if test='search.contractId != null'>AND contract_id = #{search.contractId}</if> " +
            "<if test='search.createTime != null'>AND create_time &gt; #{search.createTime}</if> " +
            "</where> " +
            "</script>")
    List<DayRent> findDayRentByDayRentCQRS(@Param("search") DayRentRequestDTO dayRentRequestDTO);


    /**
     * 通过签约id与时间查询溢租率
     * @param contractId
     * @param createTime
     * @return
     */
    @Select("select * from yhcc_day_rent where contract_id = #{contractId} and create_time =#{createTime}")
    DayRentResponseDTO findDayRentResponseDTOByContractId(@Param("contractId") String contractId, @Param("createTime") LocalDateTime createTime);


    /**
     * 保存按天溢租率
     * @param dayRent
     */
    @Insert("insert into yhcc_day_rent " +
            "values( #{id},#{contractId},#{moonRentid},#{rent},#{propertyFee},#{staffEmp},#{fitment},#{agencyFee},#{profit},#{status},#{createTime},#{modifyTime},#{createUser},#{modifyUser})")
    void saveDayRent(DayRent dayRent);
}
