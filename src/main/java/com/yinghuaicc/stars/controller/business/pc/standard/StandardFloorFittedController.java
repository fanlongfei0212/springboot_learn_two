package com.yinghuaicc.stars.controller.business.pc.standard;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.cqrs.standard.StandardFloorFittedService;
import com.yinghuaicc.stars.service.cqrs.standard.StandardFloorRentService;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardFloorFittedRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardFloorRentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/standardfloorfitted")
public class StandardFloorFittedController {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private StandardFloorFittedService standardFloorFittedService;

    @PostMapping(value = "/find/standardfloorfitted/list")
    public JsonResult findStandardProjectRentList(@RequestBody StandardFloorFittedRequestDTO standardFloorFittedRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                standardFloorFittedService.findStandardFloorFittedByStandardFloorFittedCQRS(standardFloorFittedRequestDTO, pageParam));
    }

}
