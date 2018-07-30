package com.yinghuaicc.stars.service.cqrs.Intervalset;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.model.Intervalset.ProjectGuestInterval;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.request.ProjectGuestIntervalRequestDTO;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.response.ProjectGuestIntervalResponseDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface ProjectGuestIntervalService {

    /**
     * 通过条件查询项目客销度列表
     * @param projectGuestIntervalRequestDTO
     * @param pageParam
     * @return
     */
    ResultPageList<ProjectGuestIntervalResponseDTO> findProjectGuestIntervalByProjectGuestIntervalCQRS(ProjectGuestIntervalRequestDTO projectGuestIntervalRequestDTO, PageParam pageParam);

    /**
     *@Description: 添加客销度项目区间设置
     */
    void saveProject(ProjectGuestInterval projectGuestInterval);

    /**
     *@Description: 通过项目id查询项目客销度区间设置
     */
    ProjectGuestInterval findProjectByProjectId(String projectId);

    /**
     * @Description: 通过项目id修改项目
     */
    void editProject(ProjectGuestInterval projectGuestInterval);
}
