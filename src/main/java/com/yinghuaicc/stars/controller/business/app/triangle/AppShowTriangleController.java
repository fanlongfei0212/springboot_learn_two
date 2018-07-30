package com.yinghuaicc.stars.controller.business.app.triangle;

import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.cqrs.triangle.TriangleCQRSService;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.BrandTriangleRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/showtriangle")
public class AppShowTriangleController {


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
    @PostMapping(value = "/find/trianglefloor/byconditionId")
    public JsonResult findProjectTriangleByConditionId(@RequestBody BrandTriangleRequestDTO brandTriangleRequestDTO){

        return JsonResult.success(triangleCQRSService.findBrandTriangleByConditionId(brandTriangleRequestDTO));
    }

    /**
     * 通过品牌id查询三角理论
     * @param brandTriangleRequestDTO
     * @return
     */
    @PostMapping(value = "/find/trianglefloor/byBrandId")
    public JsonResult findProjectTriangleByBrandId(@RequestBody BrandTriangleRequestDTO brandTriangleRequestDTO){
        return JsonResult.success(triangleCQRSService.findBrandTriangleByBrandId(brandTriangleRequestDTO));
    }



}
