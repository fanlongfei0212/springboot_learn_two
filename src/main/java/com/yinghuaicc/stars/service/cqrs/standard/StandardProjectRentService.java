package com.yinghuaicc.stars.service.cqrs.standard;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.model.standard.StandardProjectRent;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardProjectRentRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardProjectRentResponseDTO;

public interface StandardProjectRentService {


    /**
     * 通过项目id 查询标准三角形项目溢租率
     * @param standardProjectRentRequestDTO
     * @param pageParam
     * @return
     */
    ResultPageList<StandardProjectRentResponseDTO> findStandardProjectRentByStandardProjectRentCQRS(StandardProjectRentRequestDTO standardProjectRentRequestDTO, PageParam pageParam);

    /**
     * 新增项目溢租率
     */
    void saveStandardProjectRent(StandardProjectRent standardProjectRent);

}
