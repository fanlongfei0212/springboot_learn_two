package com.yinghuaicc.stars.repository.mapper.triangle;

import com.yinghuaicc.stars.repository.model.triangle.FloorGuest;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.FloorGuestRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.FloorGuestResponseDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorGuestMapper {

    @Select("<script>select * from yhcc_floor_guest " +
            " <where> " +
            "<bind name='search.guestVerssionId' value='search.guestVerssionId' /> " +
            "<if test='search.guestVerssionId != null'>AND guest_verssion_id = #{search.guestVerssionId}</if> " +
            "</where> " +
            "</script>")
    List<FloorGuestResponseDTO> findFloorGuestByFloorGuestCQRS(@Param("search") FloorGuestRequestDTO floorGuestRequestDTO);


    @Select("select * from yhcc_floor_guest where project_id = #{projectId} and floor_id = #{floorId}")
    FloorGuestResponseDTO  findFloorGuestByProjectId(@Param("projectId") String projectId, @Param("floorId") String floorId);


    /**
     * 保存楼层客销度
     * @param floorGuest
     */
    @Insert("insert into yhcc_floor_guest " +
            "values(#{id},#{guestVerssionId},#{contractId},#{projectId},#{projectName},#{floorId},#{floorName},#{passengerFlow},#{createTime},#{modifyTime},#{createUser},#{modifyUser},#{status})")
    void saveFloorGuest(FloorGuest floorGuest);


}
