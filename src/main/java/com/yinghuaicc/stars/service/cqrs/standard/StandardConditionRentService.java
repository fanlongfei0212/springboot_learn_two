package com.yinghuaicc.stars.service.cqrs.standard;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.model.standard.StandardConditionRent;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardConditionRentRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardConditionRentResponseDTO;

public interface StandardConditionRentService {


    /**
     * 通过项目id 查询标准三角形业态溢租率
     * @param standardConditionRentRequestDTO
     * @param pageParam
     * @return
     */
    ResultPageList<StandardConditionRentResponseDTO> findStandardConditionRentByStandardConditionRentCQRS(StandardConditionRentRequestDTO standardConditionRentRequestDTO, PageParam pageParam);

    /**
     * 新增业态溢租率
     * @param standardConditionRent
     */
    void saveStandardConditionRent(StandardConditionRent standardConditionRent);

}
