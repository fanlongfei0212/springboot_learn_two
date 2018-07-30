package com.yinghuaicc.stars.controller.business.pc.standard;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.cqrs.standard.StandardConditionRentService;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardConditionRentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/standardconditionrent")
public class StandardConditionRentController {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private StandardConditionRentService standardConditionRentService;

    @PostMapping(value = "/find/standardconditionrent/list")
    public JsonResult findStandardConditionRentList(@RequestBody StandardConditionRentRequestDTO standardConditionRentRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                standardConditionRentService.findStandardConditionRentByStandardConditionRentCQRS(standardConditionRentRequestDTO, pageParam));
    }

}
