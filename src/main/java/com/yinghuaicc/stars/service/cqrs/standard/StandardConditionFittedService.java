package com.yinghuaicc.stars.service.cqrs.standard;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.model.standard.StandardConditionFitted;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardConditionFittedRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardConditionFittedResponseDTO;

public interface StandardConditionFittedService {


    /**
     * 通过项目id 查询标准三角形业态适配值
     * @param standardConditionFittedRequestDTO
     * @param pageParam
     * @return
     */
    ResultPageList<StandardConditionFittedResponseDTO> findStandardConditionFittedByStandardConditionFittedCQRS(StandardConditionFittedRequestDTO standardConditionFittedRequestDTO, PageParam pageParam);


    /**
     * 添加标准三角形业态适配值
     * @param standardConditionFitted
     */
    void saveStandardConditionFitted(StandardConditionFitted standardConditionFitted);

}
