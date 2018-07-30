package com.yinghuaicc.stars.repository.mapper.triangle;

import com.yinghuaicc.stars.repository.model.triangle.DayGuest;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.DayGuestRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.AllSalePassengerFlowResponseDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.DayGuestResponseDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 每日客销度
 */
@Repository
public interface DayGuestMapper {


    @Select("<script>select * from yhcc_day_guest " +
            " <where> " +
            "<bind name='search.guestVerssionId' value='search.guestVerssionId' /> " +
            "<if test='search.guestVerssionId != null'>AND guest_verssion_id = #{search.guestVerssionId}</if> " +
            "</where> " +
            "</script>")
    List<DayGuestResponseDTO> findDayGuestByDayGuestCQRS(@Param("search") DayGuestRequestDTO dayGuestRequestDTO);

    /**
     * 通过签约id与时间查询客销度
     * @param contractId
     * @param time
     * @return
     */
    @Select("select * from yhcc_day_guest where contract_id = #{contractId} and create_time =#{createTime}")
    DayGuestResponseDTO findDayGuestByDayGuestByContractId(String contractId, LocalDateTime time);

    /**
     * 保存天客销度
     * @param dayGuest
     */
    @Insert("insert into yhcc_day_guest " +
            "values(#{id},#{guestVerssionId},#{contractId},#{projectName},#{floorName},#{roomName},#{contractName}," +
            "#{conditionName},#{majoName},#{passengerFlow},#{saleroom},#{profits},#{createTime},#{modifyTime},#{createUser},#{modifyUser},#{status})")
    void saveDayGuest(DayGuest dayGuest);


    /**
     * 查询全国客流量
     * @return
     */
    @Select("select sum(passenger_flow) from yhcc_day_guest")
    BigDecimal findPassengerFlowAll();
    /**
     * 查询全国销售额
     * @return
     */
    @Select("select sum(saleroom) from yhcc_day_guest")
    BigDecimal findSaleroomAll();


    /**
     * 全国区域排名销售额、客销度
     * @return
     */
    @Select("SELECT b.name as 'areaName',SUM(d.passenger_flow) as 'passengerFlow',SUM(d.saleroom) as 'saleroom' FROM yhcc_project a LEFT JOIN yhcc_area b ON b.id = a.area_id\n" +
            "LEFT JOIN yhcc_contract c ON c.project_id = a.id " +
            "LEFT JOIN yhcc_day_guest d ON d.contract_id = c.id " +
            "GROUP BY b.name")
    List<AllSalePassengerFlowResponseDTO> findSalePassengerFlowAll();


}
