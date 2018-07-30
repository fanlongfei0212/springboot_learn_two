package com.yinghuaicc.stars.service.cqrs.standard;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.model.standard.StandardFloorRent;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardFloorRentRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.response.StandardFloorRentResponseDTO;

public interface StandardFloorRentService {


    /**
     * 通过项目id 查询标准三角形楼层溢租率
     * @param standardFloorRentRequestDTO
     * @param pageParam
     * @return
     */
    ResultPageList<StandardFloorRentResponseDTO> findStandardFloorRentByStandardFloorRentCQRS(StandardFloorRentRequestDTO standardFloorRentRequestDTO, PageParam pageParam);


    /**
     * 保存楼层溢租率
     * @param standardFloorRent
     */
    void saveStandardFloorRent(StandardFloorRent standardFloorRent);

}
