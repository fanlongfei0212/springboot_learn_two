package com.yinghuaicc.stars.repository.mapper.Intervalset;

import com.yinghuaicc.stars.repository.model.Intervalset.ConditionGuestInterval;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.request.ConditionGuestIntervalRequestDTO;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.response.ConditionGuestIntervalResponseDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConditionGuestIntervalMapper {


    @Select("<script>select * from yhcc_condition_guest_interval " +
            " <where> " +
            "<bind name='search.guestVerssionId' value='search.guestVerssionId' /> " +
            "<bind name='search.projectId' value='search.projectId' /> " +
            "<bind name='search.conditionId' value='search.conditionId' /> " +
            "<bind name='search.majoId' value='search.majoId' /> " +
            "<if test='search.guestVerssionId != null'>AND guest_verssion_id = #{search.guestVerssionId}</if> " +
            "<if test='search.projectId != null'>AND project_id = #{search.projectId}</if> " +
            "<if test='search.conditionId != null'>AND condition_id = #{search.conditionId}</if> " +
            "<if test='search.majoId != null'>AND majo_id = #{search.majoId}</if> " +
            "</where> " +
            "</script>")
    List<ConditionGuestIntervalResponseDTO> findConditionGuestIntervalByConditionGuestIntervalCQRS(@Param("search") ConditionGuestIntervalRequestDTO conditionGuestIntervalRequestDTO);

    /**
     * 通过id 查询楼层级客销度区间
     * @param id
     * @return
     */
    @Select("select * from yhcc_condition_guest_interval where id = #{id}")
    ConditionGuestInterval findConditionGuestIntervalByProjectIdAndConditionId(@Param("id") String id);



    /**
     * 保存业态级客销度区间设置
     * @param conditionGuestInterval
     */
    @Insert("insert into yhcc_condition_guest_interval " +
            "values(#{id},#{contractId} ,#{projectId}  ,#{projectName} ,#{conditionId}) ,#{conditionName}  ,#{majoId} ,#{majoName} ,#{maxvalue} ,#{intervalRate} " +
            ",#{yx} ,#{lh} ,#{ts} ,#{hl} ,#{ks} ,#{createTime} ,#{modifyTime} ,#{createUser} ,#{modifyUser} )")
    void saveConditionGuestInterval(ConditionGuestInterval conditionGuestInterval);


    /**
     * @Description: 通过id修改业态
     */
    @Update("update yhcc_condition_guest_interval set contract_Id = #{contractId}, project_Id = #{projectId}, project_name = #{projectName}, condition_id = #{conditionId}, condition_name = #{conditionName}" +
            ", majo_Id = #{majoId}, majo_name = #{majoName}" +
            "maxvalue = #{maxvalue}, interval_rate = #{intervalRate}, yx = #{yx}, " +
            "lh = #{lh}, ts = #{ts}, hl = #{hl}, ks = #{ks}, " +
            "create_user = #{createUser}, modify_user = #{modifyUser} " +
            "where id = #{id}")
    void editConditionGuestInterval(ConditionGuestInterval conditionGuestInterval);

}
