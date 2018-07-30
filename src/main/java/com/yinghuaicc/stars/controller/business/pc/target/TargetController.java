package com.yinghuaicc.stars.controller.business.pc.target;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.controller.config.aop.pc.AopResourceEmployeeBean;
import com.yinghuaicc.stars.service.target.TargetService;
import com.yinghuaicc.stars.service.target.dto.request.EditTargetRequestDTO;
import com.yinghuaicc.stars.service.target.dto.request.FindTargetAllListRequestDTO;
import com.yinghuaicc.stars.service.target.dto.request.IsAbleTargetRequestDTO;
import com.yinghuaicc.stars.service.target.dto.request.SaveTargetRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/7 下午3:23
 * @Description: 指标
 * @Modified:
 */
@RestController
@RequestMapping(value = "/target")
public class TargetController {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private TargetService targetService;

    /**
     *@Author:Fly Created in 2018/7/7 下午3:28
     *@Description: 查询指标列表
     */
    @PostMapping(value = "/find/target/list")
    public JsonResult findTargetList(@RequestBody FindTargetAllListRequestDTO findTargetAllListRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                targetService.findTargetList(findTargetAllListRequestDTO, pageParam));
    }

    /**
     *@Author:Fly Created in 2018/7/7 下午3:30
     *@Description: 添加指标
     */
    @PostMapping(value = "/save/target")
    public JsonResult saveTarget(@Validated @RequestBody SaveTargetRequestDTO saveTargetRequestDTO){

        targetService.saveTarget(
                saveTargetRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/7 下午3:30
     *@Description: 编辑指标
     */
    @PostMapping(value = "/edit/target")
    public JsonResult editTarget(@Validated @RequestBody EditTargetRequestDTO editTargetRequestDTO){

        targetService.editTarget(
                editTargetRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/7 下午3:32
     *@Description: 删除指标
     */
    @GetMapping(value = "/remove/target/{targetId}")
    public JsonResult removeTarget(@PathVariable String targetId){

        targetService.removeTarget(targetId);

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/7 下午3:34
     *@Description: 禁用/开启指标
     */
    @PostMapping(value = "/is/able/target")
    public JsonResult isAbleTarget(@Validated @RequestBody IsAbleTargetRequestDTO isAbleTargetRequestDTO){

        targetService.isAbleTarget(
                isAbleTargetRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }
}
