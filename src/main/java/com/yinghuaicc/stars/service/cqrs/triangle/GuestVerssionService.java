package com.yinghuaicc.stars.service.cqrs.triangle;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.model.triangle.GuestVerssion;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.GuestVerssionRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.GuestVerssionResponseDTO;

public interface GuestVerssionService {

    /**
     * 查询客销度版本列表
     * @param guestVerssionRequestDTO
     * @param pageParam
     * @return
     */
    ResultPageList<GuestVerssionResponseDTO> findGuestVerssionByGuestVerssionCQRS(GuestVerssionRequestDTO guestVerssionRequestDTO, PageParam pageParam);

    /**
     * 保存客销度版本
     */
    void saveGuestVerssion(GuestVerssion guestVerssion);

}
