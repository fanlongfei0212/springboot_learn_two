package com.yinghuaicc.stars.repository.mapper.Intervalset;

import com.yinghuaicc.stars.repository.model.Intervalset.ProjectGuestInterval;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.request.ProjectGuestIntervalRequestDTO;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.response.ProjectGuestIntervalResponseDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *  客销度项目区间设置
 */
@Repository
public interface ProjectGuestIntervalMapper {

    @Select("<script>select * from yhcc_project_guest_interval " +
            " <where> " +
            "<bind name='search.guestVerssionId' value='search.guestVerssionId' /> " +
            "<if test='search.guestVerssionId != null'>AND guest_verssion_id = #{search.guestVerssionId}</if> " +
            "</where> " +
            "</script>")
    List<ProjectGuestIntervalResponseDTO> findProjectGuestIntervalByProjectGuestIntervalCQRS(@Param("search") ProjectGuestIntervalRequestDTO projectGuestIntervalRequestDTO);

    /**
     * 通过项目id查询客销度项目区间设置
     * @param projectId
     * @return
     */
    @Select("select * from yhcc_project_guest_interval where project_id = #{projectId}")
    ProjectGuestIntervalResponseDTO findProjectGuestIntervalByProjectId(@Param("projectId") String projectId);

    /**
     *@Description: 添加客销度项目区间设置
     */
    @Insert("insert into yhcc_project_guest_interval " +
            "values(#{id}, #{contractId}, #{projectId}, #{projectName}, " +
            "#{maxvalue}, #{intervalRate}, #{yx}, " +
            "#{lh}, #{ts}, #{hl}, #{ks} #{createTime}, #{modifyTime}, " +
            "#{createUser}, #{modifyUser})")
    void saveProject(ProjectGuestInterval projectGuestInterval);

    /**
     *@Description: 通过项目id查询项目客销度区间设置
     */
    @Select("select * from yhcc_project_guest_interval where project_Id = #{projectId} ")
    ProjectGuestInterval findProjectByProjectId(String projectId);

    /**
     * @Description: 通过项目id修改项目
     */
    @Update("update yhcc_project_guest_interval set contract_Id = #{contractId}, project_Id = #{projectId}, project_name = #{projectName}, " +
            "maxvalue = #{maxvalue}, interval_rate = #{intervalRate}, yx = #{yx}, " +
            "lh = #{lh}, ts = #{ts}, hl = #{hl}, ks = #{ks}, " +
            "create_user = #{createUser}, modify_user = #{modifyUser} " +
            "where project_id = #{projectId}")
    void editProject(ProjectGuestInterval projectGuestInterval);
}
