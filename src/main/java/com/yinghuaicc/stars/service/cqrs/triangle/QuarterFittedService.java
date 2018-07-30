package com.yinghuaicc.stars.service.cqrs.triangle;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.model.triangle.QuarterFitted;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.QuarterFittedRequestDTO;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.response.QuarterFittedResponseDTO;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;


/**
 * 季度适配值
 */
public interface QuarterFittedService {


    /**
     * 通过适配值版本id查询季度适配值列表
     * @param quarterFittedRequestDTO
     * @return
     */
    ResultPageList<QuarterFittedResponseDTO> findQuarterFittedCQRS(@Param("search") QuarterFittedRequestDTO quarterFittedRequestDTO, PageParam pageParam);

    /**
     * 通过签约id查询适配值
     * @param contractId 与时间
     * @return
     */
    QuarterFittedResponseDTO findQuarterFittedResponseDTOByContractId(String contractId, LocalDateTime time);


    /**
     * 保存动态三角形适配值
     * @param quarterFitted
     */
   void  saveQuarterFitted(QuarterFitted quarterFitted);

    /**
     * 修改动态三角形适配值
     * @param quarterFitted
     */
   void editQuarterFitted(QuarterFitted quarterFitted);



}
