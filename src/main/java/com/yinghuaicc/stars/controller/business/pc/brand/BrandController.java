package com.yinghuaicc.stars.controller.business.pc.brand;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.controller.config.aop.pc.AopResourceEmployeeBean;
import com.yinghuaicc.stars.service.brand.BrandService;
import com.yinghuaicc.stars.service.brand.dto.request.EditBrandRequestDTO;
import com.yinghuaicc.stars.service.brand.dto.request.SaveBrandRequestDTO;
import com.yinghuaicc.stars.service.cqrs.brand.BrandCQRSService;
import com.yinghuaicc.stars.service.cqrs.brand.dto.request.BrandCQRSListRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/12 下午3:31
 * @Description: 品牌
 * @Modified:
 */
@RestController
@RequestMapping(value = "/brand")
public class BrandController {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private BrandService brandService;

    @Autowired
    private BrandCQRSService brandCQRSService;

    /**
     *@Author:Fly Created in 2018/7/12 下午3:33
     *@Description: 添加品牌
     */
    @PostMapping(value = "/save/brand")
    public JsonResult saveBrand(@Validated @RequestBody SaveBrandRequestDTO saveBrandRequestDTO){

        brandService.saveBrand(
                saveBrandRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/12 下午3:35
     *@Description: 编辑品牌
     */
    @PostMapping(value = "/edit/brand")
    public JsonResult editBrand(@Validated @RequestBody EditBrandRequestDTO editBrandRequestDTO){

        brandService.editBrand(
                editBrandRequestDTO, applicationContext.getBean(AopResourceEmployeeBean.class).getId());

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/12 下午3:36
     *@Description: 删除品牌
     */
    @GetMapping(value = "/remove/brand/{id}")
    public JsonResult removeBrand(@PathVariable String id){

        brandService.removeBrand(id);

        return JsonResult.success("OK");
    }

    /**
     *@Author:Fly Created in 2018/7/12 下午3:38
     *@Description: 品牌列表
     */
    @PostMapping(value = "/find/brand/list")
    public JsonResult findBrandList(@RequestBody BrandCQRSListRequestDTO brandCQRSListRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(brandCQRSService.brandListCQRS(brandCQRSListRequestDTO, pageParam));
    }

    /**
     *@Author:Fly Created in 2018/7/12 下午4:03
     *@Description: 品牌详情
     */
    @GetMapping(value = "/find/brand/by/{id}")
    public JsonResult findBrandById(@PathVariable String id){

        return JsonResult.success(brandCQRSService.brandInfoCQRS(id));
    }

    /**
     *@Author:Fly Created in 2018/7/16 下午12:42
     *@Description: 所有品牌
     */
    @GetMapping(value = "/brand/all")
    public JsonResult brandAll(){

        return JsonResult.success(brandService.brandAll());
    }

    /**
     *@Author:Fly Created in 2018/7/30 下午12:58
     *@Description: 根据业种查询品牌
     */
    @GetMapping(value = "/find/brand/by/businessSpecies/{businessSpeciesId}")
    public JsonResult findBrandByBusinessSpeciesId(@PathVariable String businessSpeciesId){

        return JsonResult.success(brandService.findBrandByBusinessSpeciesId(businessSpeciesId));
    }
}
