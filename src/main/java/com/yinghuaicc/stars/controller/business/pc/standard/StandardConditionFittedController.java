package com.yinghuaicc.stars.controller.business.pc.standard;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.cqrs.standard.StandardConditionFittedService;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardConditionFittedRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/standardconditionfitted")
public class StandardConditionFittedController {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private StandardConditionFittedService standardConditionFittedService;

    @PostMapping(value = "/find/standardconditionrent/list")
    public JsonResult findStandardConditionFittedList(@RequestBody StandardConditionFittedRequestDTO standardConditionFittedRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                standardConditionFittedService.findStandardConditionFittedByStandardConditionFittedCQRS(standardConditionFittedRequestDTO, pageParam));
    }

}
