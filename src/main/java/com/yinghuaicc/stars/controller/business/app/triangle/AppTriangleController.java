package com.yinghuaicc.stars.controller.business.app.triangle;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.cqrs.brand.BrandCQRSService;
import com.yinghuaicc.stars.service.cqrs.brand.dto.request.AppBrandCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.brand.dto.request.BrandCQRSListRequestDTO;
import com.yinghuaicc.stars.service.cqrs.region.RegionCQRSService;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.TriangeConditionRequestDTO;
import com.yinghuaicc.stars.service.region.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;


/**
 * 移动端App三角理论接口
 */
@RestController
@RequestMapping(value="/apptriangle")
public class AppTriangleController {


    @Autowired
    private RegionCQRSService regionCQRSService;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private RegionService regionService;

    @Autowired
    private BrandCQRSService brandCQRSService;

    /**
     *@Author:Fly Created in 2018/7/4 下午5:37
     *@Description: 查询所有区域
     */
    @GetMapping(value = "/find/area/all")
    public JsonResult findAreaAll(){
        return JsonResult.success(regionService.findAreaAll());
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
     *@Author:Fly Created in 2018/7/11 下午10:57
     *@Description: 根据项目查询楼栋信息
     */
    @GetMapping(value = "/find/building/project/{projectId}")
    public JsonResult findBuildingByProjectId(@PathVariable String projectId){

        return JsonResult.success(regionService.findBuildingByProjectId(projectId));
    }

    /**
     * 根据项目id查询项目图片
     * @param projectId
     * @return
     */
    @GetMapping(value = "/find/projectimage/project/{projectId}")
    public JsonResult findProjectImageByProjectId(@PathVariable String projectId){
        return JsonResult.success(regionService.findProjectImageByProjectId(projectId));
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
     *@Author:Fly Created in 2018/7/11 下午11:11
     *@Description: 按照项目id查询层
     */
    @GetMapping(value = "/find/floor/by/project/{projectId}")
    public JsonResult findFloorByProjectId(@PathVariable String projectId){
        return JsonResult.success(regionService.findFloorByProjectId(projectId));
    }


    /**
     * 根据项目id、楼层id查询项目下业态
     * @param triangeConditionRequestDTO
     * @return
     */
    @PostMapping(value = "/find/Conditionlist/project")
    public  JsonResult findConditionlistByOtherId(@RequestBody TriangeConditionRequestDTO triangeConditionRequestDTO){
        return   JsonResult.success(regionService.findConditionlistByOtherId(triangeConditionRequestDTO));
    }


    /**
     *@Author:Fly Created in 2018/7/12 下午3:38
     *@Description: 根据条件查询品牌列表
     */
    @PostMapping(value = "/find/brand/list")
    public JsonResult findBrandList(@RequestBody BrandCQRSListRequestDTO brandCQRSListRequestDTO, @ModelAttribute PageParam pageParam){
        return JsonResult.success(brandCQRSService.brandListCQRS(brandCQRSListRequestDTO, pageParam));
    }

    /**
     * 专用查询品牌列表
     */
    @PostMapping(value = "/find/appbrand/list")
    public JsonResult findAppBrandList(@RequestBody AppBrandCQRSListRequestDTO appBrandCQRSListRequestDTO){
        return JsonResult.success(brandCQRSService.appBrandListCQRS(appBrandCQRSListRequestDTO));
    }

}
