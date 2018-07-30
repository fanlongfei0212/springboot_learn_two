package com.yinghuaicc.stars.repository.mapper.triangle;

import com.yinghuaicc.stars.repository.model.triangle.ProjectGuest;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.ProjectGuestRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.ProjectGuestResponseDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 项目客销度
 */
@Repository
public interface ProjectGuestMapper {
    @Select("<script>select * from yhcc_project_guest " +
            " <where> " +
            "<bind name='search.guestVerssionId' value='search.guestVerssionId' /> " +
            "<if test='search.guestVerssionId != null'>AND guest_verssion_id = #{search.guestVerssionId}</if> " +
            "</where> " +
            "</script>")
    List<ProjectGuestResponseDTO> findProjectGuestByProjectGuestCQRS(@Param("search") ProjectGuestRequestDTO projectGuestRequestDTO);

    @Select("select * from yhcc_project_guest where project_id = #{projectId}")
    ProjectGuestResponseDTO  findProjectGuestByProjectId(String projectId);

    @Insert("insert into yhcc_project_guest " +
            "values(#{id},#{contractId},#{projectId},#{projectName},#{contractStatus},#{guestVerssionId},#{passengerFlow},#{createTime},#{modifyTime},#{createUser},#{modifyUser},#{status})")
    void saveProjectGuest(ProjectGuest projectGuest);


}
