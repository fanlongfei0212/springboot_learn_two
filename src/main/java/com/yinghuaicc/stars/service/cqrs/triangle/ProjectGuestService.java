package com.yinghuaicc.stars.service.cqrs.triangle;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.model.triangle.ProjectGuest;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.ProjectGuestRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.ProjectGuestResponseDTO;

public interface ProjectGuestService {

    /**
     * 通过条件查询项目客销度列表
     * @param projectGuestRequestDTO
     * @param pageParam
     * @return
     */
    ResultPageList<ProjectGuestResponseDTO> findProjectGuestByProjectGuestCQRS(ProjectGuestRequestDTO projectGuestRequestDTO, PageParam pageParam);

    /**
     * 添加项目客销度
     * @param projectGuest
     */
    void saveProjectGuest(ProjectGuest projectGuest);
}
