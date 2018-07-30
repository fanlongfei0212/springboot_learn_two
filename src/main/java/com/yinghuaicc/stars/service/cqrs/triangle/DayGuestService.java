package com.yinghuaicc.stars.service.cqrs.triangle;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.model.triangle.DayGuest;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.DayGuestRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.DayGuestResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface DayGuestService {
    /**
     * 根据版本获取每日客销度
     * @param dayGuestRequestDTO
     * @param pageParam
     * @return
     */
    ResultPageList<DayGuestResponseDTO> findDayGuestByDayGuestCQRS(DayGuestRequestDTO dayGuestRequestDTO, PageParam pageParam);

    /**
     * 通过签约id查询客销度
     * @param contractId
     * @param time
     * @return
     */
    DayGuestResponseDTO findDayGuestByDayGuestByContractId(String contractId, LocalDateTime time);

    /**
     * 保存日客销度
     * @param dayGuest
     */
    void saveDayGuest(DayGuest dayGuest);

    /**
     * 查询全国客流量
     * @return
     */
    BigDecimal findPassengerFlowAll();
    /**
     * 查询全国销售额
     * @return
     */
    BigDecimal findSaleroomAll();
}
