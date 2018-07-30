package com.yinghuaicc.stars.service.cqrs.Intervalset;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.model.Intervalset.ConditionGuestInterval;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.request.ConditionGuestIntervalRequestDTO;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.response.ConditionGuestIntervalResponseDTO;

public interface ConditionGuestIntervalService {

    /**
     * 通过条件查询业态业种区间设置
     * @param conditionGuestIntervalRequestDTO
     * @param pageParam
     * @return
     */
    ResultPageList<ConditionGuestIntervalResponseDTO> findConditionGuestIntervalByConditionGuestIntervalCQRS(ConditionGuestIntervalRequestDTO conditionGuestIntervalRequestDTO, PageParam pageParam);

    /**
     *@Description: 添加客销度楼层区间设置
     */
    void saveConditionGuestInterval(ConditionGuestInterval conditionGuestInterval);

    /**
     *@Description: 通过id查询楼层客销度区间设置
     */
    ConditionGuestInterval findConditionById(String id);

    /**
     * @Description: 通过项目id、楼层 id修改楼层
     */
    void editConditionGuestInterval(ConditionGuestInterval conditionGuestInterval);
}
