package com.yinghuaicc.stars.controller.business.pc.base;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.controller.config.aop.pc.AopResourceEmployeeBean;
import com.yinghuaicc.stars.service.base.BaseService;
import com.yinghuaicc.stars.service.base.dto.request.EditBusinessFormRequestDTO;
import com.yinghuaicc.stars.service.base.dto.request.EditBusinessSpeciesRequestDTO;
import com.yinghuaicc.stars.service.base.dto.request.SaveBusinessSpeciesRequestDTO;
import com.yinghuaicc.stars.service.cqrs.base.BaseCQRSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/5 上午10:41
 * @Description: 基础数据Controller
 * @Modified:
 */
@RestController
@RequestMapping(value = "/base")
public class BaseController {

    @Autowired
    private BaseService baseService;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private BaseCQRSService baseCQRSService;

    /**
     *@Author:Fly Created in 2018/7/5 上午10:42
     *@Description: 查询所有城市
     */
    @GetMapping(value = "/find/city/all")
    public JsonResult findCityAll(){

        return JsonResult.success(baseService.findCityAll());
    }

    /**
     *@Author:Fly Created in 2018/7/9 下午1:19
     *@Description: 添加业态
     */
    @GetMapping(value = "/save/business/form/{name}")
    public JsonResult saveBusinessForm(@PathVariable String name){

        baseService.saveBusinessForm(
                name, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/9 下午1:21
     *@Description: 编辑业态
     */
    @PostMapping(value = "/edit/business/form")
    public JsonResult editBusinessForm(@Validated @RequestBody EditBusinessFormRequestDTO editBusinessFormRequestDTO){

        baseService.editBusinessForm(
                editBusinessFormRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/9 下午1:23
     *@Description: 删除业态
     */
    @GetMapping(value = "/remove/business/form/{id}")
    public JsonResult removeBusinessForm(@PathVariable String id){

        baseService.removeBusinessForm(id);

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/9 下午1:24
     *@Description: 业态列表
     */
    @GetMapping(value = "/find/business/form")
    public JsonResult findBusinessFormList(@ModelAttribute PageParam pageParam){

        return JsonResult.success(
                baseService.findBusinessFormList(pageParam));
    }

    /**
     *@Author:Fly Created in 2018/7/9 下午11:54
     *@Description: 业态详情
     */
    @GetMapping(value = "/find/Business/form/by/{id}")
    public JsonResult findBusinessFormById(@PathVariable String id){

        return JsonResult.success(baseService.findBusinessFormById(id));
    }

    /**
     *@Author:Fly Created in 2018/7/9 下午1:26
     *@Description: 添加业种
     */
    @PostMapping(value = "/save/business/species")
    public JsonResult saveBusinessSpecies(@Validated @RequestBody SaveBusinessSpeciesRequestDTO saveBusinessSpeciesRequestDTO){

        baseService.saveBusinessSpecies(
                saveBusinessSpeciesRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/9 下午1:28
     *@Description: 编辑业种
     */
    @PostMapping(value = "/edit/business/species")
    public JsonResult editBusinessSpecies(@Validated @RequestBody EditBusinessSpeciesRequestDTO editBusinessSpeciesRequestDTO){

        baseService.editBusinessSpecies(
                editBusinessSpeciesRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/9 下午1:29
     *@Description: 删除业种
     */
    @GetMapping(value = "/remove/business/species/{id}")
    public JsonResult removeBusinessSpecies(@PathVariable String id){

        baseService.removeBusinessSpecies(id);

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/9 下午1:31
     *@Description: 业种列表
     */
    @GetMapping(value = "/find/business/species")
    public JsonResult findBusinessSpeciesList(@ModelAttribute PageParam pageParam){

        return JsonResult.success(
                baseCQRSService.fundByBusinessSpeciesCQRSList(pageParam));
    }

    /**
     *@Author:Fly Created in 2018/7/9 下午11:56
     *@Description: 业种详情
     */
    @GetMapping(value = "/find/business/species/by/{id}")
    public JsonResult findBusinessSpeciesById(@PathVariable String id){

        return JsonResult.success(baseService.findBusinessSpeciesById(id));
    }

    /**
     *@Author:Fly Created in 2018/7/27 下午5:50
     *@Description: 业态下拉
     */
    @GetMapping(value = "/find/business/form/select")
    public JsonResult findBusinessFormSelect(){

        return JsonResult.success(baseService.findFindBusinessFormSelect());
    }

    /**
     *@Author:Fly Created in 2018/7/27 下午5:59
     *@Description: 业种下拉
     */
    @GetMapping(value = "/find/business/species/select/{businessFormId}")
    public JsonResult findBusinessSpeciesSelect(@PathVariable String businessFormId){

        return JsonResult.success(baseService.findBusinessSpeciesSelect(businessFormId));
    }
}
