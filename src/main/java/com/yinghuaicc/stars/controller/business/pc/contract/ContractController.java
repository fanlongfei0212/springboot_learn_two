package com.yinghuaicc.stars.controller.business.pc.contract;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.controller.config.aop.pc.AopResourceEmployeeBean;
import com.yinghuaicc.stars.service.contract.ContractService;
import com.yinghuaicc.stars.service.contract.dto.request.SaveContractRequestDTO;
import com.yinghuaicc.stars.service.cqrs.contract.ContractCQRSService;
import com.yinghuaicc.stars.service.cqrs.contract.dto.request.ContractCQRSListRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/30 上午11:17
 * @Description: 签约
 * @Modified:
 */
@RestController
@RequestMapping(value = "/contract")
public class ContractController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private ContractCQRSService contractCQRSService;

    @Autowired
    private ContractService contractService;

    /**
     *@Author:Fly Created in 2018/7/30 上午11:18
     *@Description: 添加签约信息
     */
    @PostMapping(value = "/add/contract")
    public JsonResult addContract(@Validated @RequestBody SaveContractRequestDTO saveContractRequestDTO){

        contractService.saveContract(saveContractRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/30 上午11:21
     *@Description: 解约
     */
    @GetMapping(value = "/dispel/contract/{id}")
    public JsonResult dispelContract(@PathVariable String id){

        contractService.dispelContract(id, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/30 上午11:25
     *@Description: 列表
     */
    @PostMapping(value = "/contract/list")
    public JsonResult contractList(@RequestBody ContractCQRSListRequestDTO contractCQRSListRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(contractCQRSService.contractList(contractCQRSListRequestDTO, pageParam));
    }
}
