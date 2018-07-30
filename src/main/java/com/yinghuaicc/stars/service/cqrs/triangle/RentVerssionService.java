package com.yinghuaicc.stars.service.cqrs.triangle;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.model.triangle.RentVerssion;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.RentVerssionRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.RentVerssionResponseDTO;

public interface RentVerssionService {

    /**
     *@Author:xjp Created in 2018/7/20
     *@Description: 分页查询溢租率版本信息
     */
    ResultPageList<RentVerssionResponseDTO> findRentVerssionByRantVersionCQRS(RentVerssionRequestDTO rentVerssionRequestDTO, PageParam pageParam);

    /**
     * 保存动态三角形溢租率版本信息
     * @param rentVerssion
     */
    void saveRentVerssion(RentVerssion rentVerssion);
}
