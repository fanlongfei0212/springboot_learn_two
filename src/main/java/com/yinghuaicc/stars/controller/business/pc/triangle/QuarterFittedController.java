package com.yinghuaicc.stars.controller.business.pc.triangle;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.cqrs.triangle.QuarterFittedService;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.QuarterFittedRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/quarterfitted")
public class QuarterFittedController {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private QuarterFittedService quarterFittedService;

    @PostMapping(value = "/find/quarterfitted/list")
    public JsonResult findMoonRantList(@RequestBody QuarterFittedRequestDTO quarterFittedRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                quarterFittedService.findQuarterFittedCQRS(quarterFittedRequestDTO, pageParam));
    }

}
