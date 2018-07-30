package com.yinghuaicc.stars.controller.business.pc.help;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.controller.config.aop.pc.AopResourceEmployeeBean;
import com.yinghuaicc.stars.service.cqrs.help.HelpCQRSService;
import com.yinghuaicc.stars.service.cqrs.help.dto.request.FindHelpPlanFloorListCQRSRequestDTO;
import com.yinghuaicc.stars.service.cqrs.help.dto.request.FindHelpPlanProjectListCQRSRequestDTO;
import com.yinghuaicc.stars.service.help.HelpService;
import com.yinghuaicc.stars.service.help.dto.request.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/19 下午5:11
 * @Description: 帮扶计划Controller
 * @Modified:
 */
@RestController
@RequestMapping(value = "/help")
public class HelpController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private HelpService helpService;

    @Autowired
    private HelpCQRSService helpCQRSService;

    /**
     *@Author:Fly Created in 2018/7/19 下午5:12
     *@Description: 添加帮扶内容
     */
    @PostMapping(value = "/save/help/context")
    public JsonResult saveHelpContext(@Validated @RequestBody SaveHelpContextRequestDTO saveHelpContextRequestDTO){

        helpService.saveHelpContext(
                saveHelpContextRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/19 下午5:16
     *@Description: 编辑帮扶内容
     */
    @PostMapping(value = "/edit/help/context")
    public JsonResult editHelpContext(@Validated @RequestBody EditHelpContextRequestDTO editHelpContextRequestDTO){

        helpService.editHelpContext(
                editHelpContextRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/19 下午5:17
     *@Description: 删除帮扶内容
     */
    @GetMapping(value = "/remove/help/context/{id}")
    public JsonResult removeHelpContext(@PathVariable String id){

        helpService.removeHelpContext(id);

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/19 下午5:20
     *@Description: 查询帮扶内容列表
     */
    @PostMapping(value = "/find/help/context/list")
    public JsonResult findHelpContextList(@RequestBody Map map, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                helpService.findHelpContextList(pageParam,
                        Objects.nonNull(map.get("type")) ? Integer.parseInt(map.get("type").toString()) : null));
    }

    /**
     *@Author:Fly Created in 2018/7/29 下午5:09
     *@Description: 帮扶内容全部
     */
    @PostMapping(value = "/find/help/context/all")
    public JsonResult findHelpContextAll(@RequestBody Map map){

        return JsonResult.success(helpService.findHelpContextAll(
                Objects.nonNull(map.get("type")) ? Integer.parseInt(map.get("type").toString()) : null));
    }

    /**
     *@Author:Fly Created in 2018/7/20 下午2:37
     *@Description: 添加项目帮扶计划
     */
    @PostMapping(value = "/save/help/plan/project")
    public JsonResult saveHelpPlanProject(@Validated @RequestBody SaveHelpPlanProjectRequestDTO saveHelpPlanProjectRequestDTO){

        helpService.saveHelpPlanProject(
                saveHelpPlanProjectRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/20 下午8:27
     *@Description: 查询项目帮扶计划列表
     */
    @PostMapping(value = "/find/help/plan/project/list")
    public JsonResult findHelpPlanProjectList(@RequestBody FindHelpPlanProjectListCQRSRequestDTO findHelpPlanProjectListCQRSRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                helpCQRSService.findHelpPlanProjectListCQRS(findHelpPlanProjectListCQRSRequestDTO, pageParam));
    }

    /**
     *@Author:Fly Created in 2018/7/20 下午8:34
     *@Description: 添加层帮扶计划
     */
    @PostMapping(value = "/save/help/plan/floor")
    public JsonResult saveHelpPlanFloor(@Validated @RequestBody SaveHelpPlanFloorRequestDTO saveHelpPlanFloorRequestDTO){

        helpService.saveHelpPlanFloor(
                saveHelpPlanFloorRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/20 下午8:40
     *@Description: 查询层帮扶计划列表
     */
    @PostMapping(value = "/find/help/plan/floor/list")
    public JsonResult findHelpPlanFloorList(@RequestBody FindHelpPlanFloorListCQRSRequestDTO findHelpPlanFloorListCQRSRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(helpCQRSService.findHelpPlanFloorListCQRS(findHelpPlanFloorListCQRSRequestDTO, pageParam));
    }

    /**
     *@Author:Fly Created in 2018/7/21 下午2:02
     *@Description: 添加业种帮扶计划
     */
    @PostMapping(value = "/save/help/plan/business/species")
    public JsonResult saveHelpPlanBusinessSpecies(@Validated @RequestBody SaveHelpPlanBusinessSpeciesRequestDTO saveHelpPlanBusinessSpeciesRequestDTO){

        helpService.saveHelpPlanHelpPlanBusinessSpecies(
                saveHelpPlanBusinessSpeciesRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/21 下午2:03
     *@Description: 业种帮扶计划列表
     */
    @PostMapping(value = "/find/help/plan/business/species/list")
    public JsonResult findHelpPlanBusinessSpeciesList(@RequestBody Map map, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                helpCQRSService.findHelpPlanBusinessSpeciesListCQRS(
                        Objects.nonNull(map.get("projectId")) ? map.get("projectId").toString() : null, pageParam));
    }

}
