package com.yinghuaicc.stars.controller.business.pc.standard;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.cqrs.standard.StandardFloorRentService;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardFloorRentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/standardfloorrent")
public class StandardFloorRentController {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private StandardFloorRentService standardFloorRentService;

    @PostMapping(value = "/find/standardfloorrent/list")
    public JsonResult findStandardProjectRentList(@RequestBody StandardFloorRentRequestDTO standardFloorRentRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                standardFloorRentService.findStandardFloorRentByStandardFloorRentCQRS(standardFloorRentRequestDTO, pageParam));
    }

}
