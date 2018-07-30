package com.yinghuaicc.stars.service.cqrs.standard;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.model.standard.StandardProjectFitted;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardProjectFittedRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardProjectRentRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardProjectFittedResponseDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardProjectRentResponseDTO;

public interface StandardProjectFittedService {


    /**
     * 通过项目id 查询标准三角形项目适配值
     * @param standardProjectFittedRequestDTO
     * @param pageParam
     * @return
     */
    ResultPageList<StandardProjectFittedResponseDTO> findStandardProjectFittedByStandardProjectFittedCQRS(StandardProjectFittedRequestDTO standardProjectFittedRequestDTO, PageParam pageParam);


    /**
     * 保存标准三角形项目适配值
     * @param standardProjectFitted
     */
    void saveStandardProjectFitted(StandardProjectFitted standardProjectFitted);

}
