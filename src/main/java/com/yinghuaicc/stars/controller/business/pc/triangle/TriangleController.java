package com.yinghuaicc.stars.controller.business.pc.triangle;


import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.controller.config.aop.pc.AopResourceEmployeeBean;
import com.yinghuaicc.stars.service.cqrs.triangle.TriangleCQRSService;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.BrandTriangleRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/19 上午10:30
 * @Description: 动态三角形
 * @Modified:
 */
@RestController
@RequestMapping(value = "/pctriangle")
public class TriangleController {


    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private TriangleCQRSService triangleCQRSService;
    /**
     * 通过项目id查询三角理论
     * @param brandTriangleRequestDTO
     * @return
     */
    @GetMapping(value = "/find/triangleproject/byprojectId")
    public JsonResult findProjectTriangleByProjectId(@RequestBody BrandTriangleRequestDTO brandTriangleRequestDTO){

        return JsonResult.success(triangleCQRSService.findBrandTriangleByProjectId(brandTriangleRequestDTO));
    }

    /**
     * 通过项目id、楼层id查询三角理论
     * @param brandTriangleRequestDTO
     * @return
     */
    @GetMapping(value = "/find/trianglefloor/byfloorId")
    public JsonResult findProjectTriangleByFloorId(@RequestBody BrandTriangleRequestDTO brandTriangleRequestDTO){

        return JsonResult.success(triangleCQRSService.findBrandTriangleByFloorId(brandTriangleRequestDTO));
    }



    /**
     * 通过项目id、业态id、业种id查询三角理论
     * @param brandTriangleRequestDTO
     * @return
     */
   @PostMapping(value = "/find/trianglecondition/byconditionId")
    public JsonResult findProjectTriangleByConditionId(@RequestBody BrandTriangleRequestDTO brandTriangleRequestDTO){

        return JsonResult.success(triangleCQRSService.findBrandTriangleByConditionId(brandTriangleRequestDTO));
    }

    /**
     * 通过品牌id查询三角理论
     * @param brandTriangleRequestDTO
     * @return
     */
    @PostMapping(value = "/find/trianglebrand/byBrandId")
    public JsonResult findProjectTriangleByBrandId(@RequestBody BrandTriangleRequestDTO brandTriangleRequestDTO){

        return JsonResult.success(triangleCQRSService.findBrandTriangleByBrandId(brandTriangleRequestDTO));
    }


    /**
     * 查询全国各区域客流量、销售量
     */
    @GetMapping(value = "/find/salepassengerflow/all")
    public JsonResult findProjectTriangleByBrandId(){
        return JsonResult.success(triangleCQRSService.findSalePassengerFlowAll());
    }

}
