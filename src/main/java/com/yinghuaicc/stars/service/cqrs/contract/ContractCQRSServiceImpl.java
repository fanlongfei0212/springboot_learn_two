package com.yinghuaicc.stars.service.cqrs.contract;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.page.ResultPageList;
import com.yinghuaicc.stars.repository.mapper.cqrs.contract.ContractCQRSMapper;
import com.yinghuaicc.stars.service.cqrs.contract.dto.request.ContractCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.contract.dto.request.ContractTriangleCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.contract.dto.response.ContractCQRSListResponseDTO;
import com.yinghuaicc.stars.service.cqrs.contract.dto.response.ContractTriangleCQRSListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/16 下午5:03
 * @Description: 签约
 * @Modified:
 */
@Service
public class ContractCQRSServiceImpl implements ContractCQRSService{

    @Autowired
    private ContractCQRSMapper contractCQRSMapper;

    /**
     *@Author:Fly Created in 2018/7/16 下午8:16
     *@Description: 签约列表
     */
    @Override
    public ResultPageList<ContractCQRSListResponseDTO> contractList(ContractCQRSListRequestDTO contractCQRSListRequestDTO, PageParam pageParam) {

        Page page = PageHelper.startPage(pageParam.getP(), pageParam.getC());

        List<ContractCQRSListResponseDTO> result = contractCQRSMapper.contractList(contractCQRSListRequestDTO);


        return new ResultPageList<ContractCQRSListResponseDTO>()
                .setResultList(result)
                .setPage(pageParam.getP())
                .setSize(pageParam.getC())
                .setCountPage(page.getPages())
                .setCountSize(page.getTotal());
    }

    @Override
    public List<ContractTriangleCQRSListResponseDTO> findContractTriangleCQRSListResponseDTO(ContractTriangleCQRSListRequestDTO contractTriangleCQRSListRequestDTO) {
        List<ContractTriangleCQRSListResponseDTO> result =
                contractCQRSMapper.findContractTriangleCQRSListResponseDTO(contractTriangleCQRSListRequestDTO);
        return result;
    }


}
