package com.yinghuaicc.stars.service.contract;

import com.yinghuaicc.stars.service.contract.dto.request.SaveContractRequestDTO;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/16 下午4:26
 * @Description: 签约
 * @Modified:
 */
public interface ContractService {

    /**
     *@Author:Fly Created in 2018/7/16 下午4:30
     *@Description: 添加签约信息
     */
    void saveContract(SaveContractRequestDTO saveContractRequestDTO, String loginEmployeeId);

    /**
     *@Author:Fly Created in 2018/7/16 下午4:32
     *@Description: 解约
     */
    void dispelContract(String id, String loginEmployeeId);
}
