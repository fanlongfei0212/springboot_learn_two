package com.yinghuaicc.stars.controller.business.pc.standard;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.repository.model.standard.StandardProjectFitted;
import com.yinghuaicc.stars.service.cqrs.standard.StandardProjectFittedService;
import com.yinghuaicc.stars.service.cqrs.standard.StandardProjectRentService;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardProjectFittedRequestDTO;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardProjectRentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/standardprojectfitted")
public class StandardProjectFittedController {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private StandardProjectFittedService standardProjectFittedService;

    @PostMapping(value = "/find/standardprojectfitted/list")
    public JsonResult findStandardProjectFittedList(@RequestBody StandardProjectFittedRequestDTO standardProjectFittedRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                standardProjectFittedService.findStandardProjectFittedByStandardProjectFittedCQRS(standardProjectFittedRequestDTO, pageParam));
    }

}
