package com.yinghuaicc.stars.controller.business.pc.region;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.controller.config.aop.pc.AopResourceEmployeeBean;
import com.yinghuaicc.stars.service.cqrs.region.RegionCQRSService;
import com.yinghuaicc.stars.service.cqrs.region.dto.request.FindRoomByProjectCQRSRequestDTO;
import com.yinghuaicc.stars.service.cqrs.region.dto.request.FloorCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.region.dto.request.ProjectCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.region.dto.request.RoomCQRSListRequestDTO;
import com.yinghuaicc.stars.service.region.RegionService;
import com.yinghuaicc.stars.service.region.dto.request.*;
import com.yinghuaicc.stars.service.tissue.TissueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/27 上午1:29
 * @Description: 区域Controller
 * @Modified:
 */
@RestController
@RequestMapping(value = "/region")
public class RegionController {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private RegionCQRSService regionCQRSService;

    @Autowired
    private RegionService regionService;

    @Autowired
    private TissueService tissueService;

    /**
     *@Author:Fly Created in 2018/7/3 下午8:13
     *@Description: 查询项目列表
     */
    @PostMapping(value = "/find/project/list")
    public JsonResult findProjectList(@RequestBody ProjectCQRSListRequestDTO projectCQRSListRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                regionCQRSService.projectList(
                        projectCQRSListRequestDTO,
                        applicationContext.getBean(AopResourceEmployeeBean.class),
                        pageParam));
    }

    /**
     *@Author:Fly Created in 2018/7/4 上午1:28
     *@Description: 添加项目
     */
    @PostMapping(value = "/save/project")
    public JsonResult saveProject(@Validated @RequestBody SaveProjectRequestDTO saveProjectRequestDTO){

        regionService.saveProject(
                saveProjectRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/4 上午1:31
     *@Description: 编辑项目
     */
    @PostMapping(value = "/edit/project")
    public JsonResult editProject(@Validated @RequestBody EditProjectRequestDTO editProjectRequestDTO){

        regionService.editProject(
                editProjectRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/4 下午1:57
     *@Description: 项目详情
     */
    @GetMapping(value = "/find/project/by/{projectId}")
    public JsonResult findProjectById(@PathVariable String projectId){

        return JsonResult.success(
                regionCQRSService.projectInfo(projectId));
    }

    /**
     *@Author:Fly Created in 2018/7/11 下午2:42
     *@Description: 按照公司id查询项目
     */
    @GetMapping(value = "/find/project/by/company/{companyId}")
    public JsonResult findProjectByCompanyId(@PathVariable String companyId){

        return JsonResult.success(regionService.findProjectByCompanyId(companyId));
    }

    /**
     *@Author:Fly Created in 2018/7/20 上午10:14
     *@Description: 按照区域id查询项目
     */
    @GetMapping(value = "/find/project/by/area/{areaId}")
    public JsonResult findProjectByAreaId(@PathVariable String areaId){

        return JsonResult.success(regionService.findProjectByAreaId(areaId));
    }

    /**
     *@Author:Fly Created in 2018/7/27 下午4:46
     *@Description: 删除项目
     */
    @GetMapping(value = "/remove/project/{projectId}")
    public JsonResult removeProject(@PathVariable String projectId){

        regionService.removeProject(projectId);

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/4 下午4:46
     *@Description: 添加公司
     */
    @PostMapping(value = "/save/company")
    public JsonResult saveCompany(@Validated @RequestBody SaveCompanyRequestDTO saveCompanyRequestDTO){

        regionService.saveCompany(
                saveCompanyRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/4 下午5:37
     *@Description: 查询所有区域
     */
    @GetMapping(value = "/find/area/all")
    public JsonResult findAreaAll(){

        return JsonResult.success(regionService.findAreaAll());
    }

    /**
     *@Author:Fly Created in 2018/7/4 下午5:39
     *@Description: 按照区域id查询公司
     */
    @GetMapping(value = "/find/company/area/{areaId}")
    public JsonResult findCompanyByAreaId(@PathVariable String areaId){

        return JsonResult.success(regionService.findCompanyByAreaId(areaId));
    }

    /**
     *@Author:Fly Created in 2018/7/27 下午3:26
     *@Description: 查询所有公司
     */
    @GetMapping(value = "/find/company/all")
    public JsonResult findCompanyAll(){

        return JsonResult.success(regionService.findCompanyAll());
    }

    /**
     *@Author:Fly Created in 2018/7/5 下午3:18
     *@Description: 查询所有项目数据权限
     */
    @GetMapping(value = "/find/project/all")
    public JsonResult findProjectAll(){

        return JsonResult.success(regionService.findProjectAll());
    }

    /**
     *@Author:Fly Created in 2018/7/11 下午10:57
     *@Description: 根据项目查询楼栋信息
     */
    @GetMapping(value = "/find/building/project/{projectId}")
    public JsonResult findBuildingByProjectId(@PathVariable String projectId){

        return JsonResult.success(regionService.findBuildingByProjectId(projectId));
    }

    /**
     *@Author:Fly Created in 2018/7/11 下午5:42
     *@Description: 添加楼层
     */
    @RequestMapping(value = "/save/floor")
    public JsonResult saveFloor(@Validated @RequestBody SaveFloorRequestDTO saveFloorRequestDTO){

        regionService.saveFloor(
                saveFloorRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/11 下午5:43
     *@Description: 编辑楼层
     */
    @RequestMapping(value = "/edit/floor")
    public JsonResult editFloor(@Validated @RequestBody EditFloorRequestDTO editFloorRequestDTO){

        regionService.editFloor(
                editFloorRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/11 下午5:45
     *@Description: 层详情
     */
    @RequestMapping(value = "/find/floor/by/{id}")
    public JsonResult findFloorById(@PathVariable String id){

        return JsonResult.success(regionCQRSService.floorInfo(id));
    }

    /**
     *@Author:Fly Created in 2018/7/11 下午5:48
     *@Description: 层列表
     */
    @RequestMapping(value = "/find/floor/list")
    public JsonResult findFloorList(@RequestBody FloorCQRSListRequestDTO floorCQRSListRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(regionCQRSService.floorList(floorCQRSListRequestDTO, pageParam));
    }

    /**
     *@Author:Fly Created in 2018/7/11 下午10:56
     *@Description: 删除层
     */
    @RequestMapping(value = "/remove/floor/{id}")
    public JsonResult removeFloor(@PathVariable String id){

        regionService.removeFloor(id);

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/11 下午11:11
     *@Description: 按照楼栋id查询层
     */
    @GetMapping(value = "/find/floor/by/building/{building}")
    public JsonResult findFloorByBuildingId(@PathVariable String building){

        return JsonResult.success(regionService.findFloorByBuildingId(building));
    }

    /**
     *@Author:Fly Created in 2018/7/11 下午11:20
     *@Description: 添加铺位
     */
    @PostMapping(value = "/save/room")
    public JsonResult saveRoom(@Validated @RequestBody SaveRoomRequestDTO saveRoomRequestDTO){

        regionService.saveRoom(
                saveRoomRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/12 上午1:37
     *@Description: 编辑铺位
     */
    @PostMapping(value = "/edit/room")
    public JsonResult editRoom(@Validated @RequestBody EditRoomRequestDTO editRoomRequestDTO){

        regionService.editRoom(
                editRoomRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/12 上午1:40
     *@Description: 删除铺位
     */
    @GetMapping(value = "/remove/room/{id}")
    public JsonResult removeRoom(@PathVariable String id){

        regionService.removeRoom(id);

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/12 上午1:40
     *@Description: 查询铺位详情
     */
    @GetMapping(value = "/find/room/by/{id}")
    public JsonResult findRoomById(@PathVariable String id){

        return JsonResult.success(regionCQRSService.roomInfo(id));
    }

    /**
     *@Author:Fly Created in 2018/7/12 上午1:43
     *@Description: 铺位列表
     */
    @PostMapping(value = "/find/room/list")
    public JsonResult findRoomList(@RequestBody RoomCQRSListRequestDTO roomCQRSListRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                regionCQRSService.roomList(roomCQRSListRequestDTO, pageParam));
    }

    /**
     *@Author:Fly Created in 2018/7/16 下午1:31
     *@Description: 按照层查询铺位
     */
    @GetMapping(value = "/find/room/by/floor/{floorId}")
    public JsonResult findRoomByFloorId(@PathVariable String floorId){

        return JsonResult.success(regionService.findRoomByFloorId(floorId));
    }

    /**
     *@Author:Fly Created in 2018/7/17 上午10:53
     *@Description: 查询项目下未签约的铺位
     */
    @PostMapping(value = "/find/room/by/project")
    public JsonResult findRoomByProjectId(@Validated @RequestBody FindRoomByProjectCQRSRequestDTO findRoomByProjectCQRSRequestDTO){

        return JsonResult.success(
                regionCQRSService.roomByProject(
                        findRoomByProjectCQRSRequestDTO.getProjectId(), findRoomByProjectCQRSRequestDTO.getRoomName()));
    }

    /**
     *@Author:Fly Created in 2018/7/18 下午12:38
     *@Description: 组织机构树
     */
    @GetMapping(value = "/find/org/tree")
    public JsonResult findOrgTree(){

        return JsonResult.success(regionService.orgTreeAll());
    }

    /**
     *@Author:Fly Created in 2018/7/28 下午1:12
     *@Description: 按照部门父id查询部门
     */
    @GetMapping(value = "/find/department/by/parent/{parentId}")
    public JsonResult findDepartmentByParentId(@PathVariable String parentId){

        return JsonResult.success(tissueService.findDepartmentByParentId(parentId));
    }
}
