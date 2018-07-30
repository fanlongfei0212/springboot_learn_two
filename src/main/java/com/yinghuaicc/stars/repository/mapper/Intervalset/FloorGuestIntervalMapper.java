package com.yinghuaicc.stars.repository.mapper.Intervalset;

import com.yinghuaicc.stars.repository.model.Intervalset.FloorGuestInterval;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.request.FloorGuestIntervalRequestDTO;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.response.FloorGuestIntervalResponseDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FloorGuestIntervalMapper {

    @Select("<script>select * from yhcc_floor_guest_interval " +
            " <where> " +
            "<bind name='search.guestVerssionId' value='search.guestVerssionId' /> " +
            "<if test='search.guestVerssionId != null'>AND guest_verssion_id = #{search.guestVerssionId}</if> " +
            "</where> " +
            "</script>")
    List<FloorGuestIntervalResponseDTO> findFloorGuestIntervalByFloorGuestIntervalCQRS(@Param("search") FloorGuestIntervalRequestDTO floorGuestIntervalRequestDTO);


    /**
     * 通过id 查询楼层级客销度区间
     * @param id
     * @return
     */
    @Select("select * from yhcc_floor_guest_interval where id = #{id}")
    FloorGuestIntervalResponseDTO findFloorGuestIntervalById(@Param("id") String id);



    /**
     * 通过项目id、楼层id 查询楼层级客销度区间
     * @param projectId
     * @param floorId
     * @return
     */
    @Select("select * from yhcc_floor_guest_interval where project_id = #{projectId} , floor_id = #{floorId}")
    FloorGuestIntervalResponseDTO findFloorGuestIntervalByProjectIdAndFloorId(@Param("projectId") String projectId, @Param("floorId") String floorId);

    /**
     * 保存楼层级客销度区间设置
     * @param floorGuestInterval
     */
    @Insert("insert into yhcc_floor_guest_interval " +
            "values(#{id},#{contractId} ,#{projectId}  ,#{projectName} ,#{floorId}) ,#{floorName}  ,#{maxvalue} ,#{intervalRate} " +
            ",#{yx} ,#{lh} ,#{ts} ,#{hl} ,#{ks} ,#{createTime} ,#{modifyTime} ,#{createUser} ,#{modifyUser} )")
    void saveFloorGuestInterval(FloorGuestInterval floorGuestInterval);


    /**
     * @Description: 通过项目id、楼层id修改项目
     */
    @Update("update yhcc_floor_guest_interval set contract_Id = #{contractId}, project_Id = #{projectId}, project_name = #{projectName}, floor_Id = #{floorId}, floor_name = #{floorName}" +
            "maxvalue = #{maxvalue}, interval_rate = #{intervalRate}, yx = #{yx}, " +
            "lh = #{lh}, ts = #{ts}, hl = #{hl}, ks = #{ks}, " +
            "create_user = #{createUser}, modify_user = #{modifyUser} " +
            "where id = #{id}}")
    void editFloorGuestInterval(FloorGuestInterval floorGuestInterval);

}
