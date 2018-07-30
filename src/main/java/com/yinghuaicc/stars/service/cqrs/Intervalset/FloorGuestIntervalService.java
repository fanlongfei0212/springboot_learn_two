package com.yinghuaicc.stars.service.cqrs.Intervalset;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.model.Intervalset.FloorGuestInterval;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.request.FloorGuestIntervalRequestDTO;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.response.FloorGuestIntervalResponseDTO;

/**
 * 区间设置-楼层客销度
 */
public interface FloorGuestIntervalService {

    /**
     * 通过条件查询客销度楼层区间
     * @param floorGuestIntervalRequestDTO
     * @param pageParam
     * @return
     */
    ResultPageList<FloorGuestIntervalResponseDTO> findFloorGuestIntervalByFloorGuestIntervalCQRS(FloorGuestIntervalRequestDTO floorGuestIntervalRequestDTO, PageParam pageParam);


    /**
     *@Description: 添加客销度楼层区间设置
     */
    void saveFloorGuestInterval(FloorGuestInterval floorGuestInterval);

    /**
     *@Description: 通过项目id查询楼层客销度区间设置
     */
    FloorGuestInterval findProjectByProjectId(String Id);

    /**
     * @Description: 通过项目id、楼层 id修改楼层
     */
    void editFloorGuestInterval(FloorGuestInterval floorGuestInterval);
}
