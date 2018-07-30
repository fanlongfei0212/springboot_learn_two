package com.yinghuaicc.stars.service.cqrs.triangle;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.model.triangle.FloorGuest;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.FloorGuestRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.FloorGuestResponseDTO;

public interface FloorGuestService {

    /**
     * 根据版本号获取楼层客销度
     * @param floorGuestRequestDTO
     * @param pageParam
     * @return
     */
    ResultPageList<FloorGuestResponseDTO> findFloorGuestByFloorGuestCQRS(FloorGuestRequestDTO floorGuestRequestDTO, PageParam pageParam);


    /**
     * 保存楼层客销度
     * @param floorGuest
     */
    void saveFloorGuest(FloorGuest floorGuest);
}
