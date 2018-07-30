package com.yinghuaicc.stars.service.cqrs.contract;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.service.cqrs.contract.dto.request.ContractCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.contract.dto.request.ContractTriangleCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.contract.dto.response.ContractCQRSListResponseDTO;
import com.yinghuaicc.stars.service.cqrs.contract.dto.response.ContractTriangleCQRSListResponseDTO;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/16 下午5:02
 * @Description:
 * @Modified:
 */
public interface ContractCQRSService {

    /**
     *@Author:Fly Created in 2018/7/16 下午8:15
     *@Description: 签约列表
     */
    ResultPageList<ContractCQRSListResponseDTO> contractList(ContractCQRSListRequestDTO contractCQRSListRequestDTO, PageParam pageParam);

    /**
     * 通过条件查询签约表
     * @param contractTriangleCQRSListRequestDTO
     * @return
     */
    List<ContractTriangleCQRSListResponseDTO> findContractTriangleCQRSListResponseDTO(ContractTriangleCQRSListRequestDTO contractTriangleCQRSListRequestDTO);
}
