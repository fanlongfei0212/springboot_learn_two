package com.yinghuaicc.stars.controller.business.pc.standard;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.cqrs.standard.StandardProjectRentService;
import com.yinghuaicc.stars.service.cqrs.standard.dto.request.StandardProjectRentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/standardprojectrent")
public class StandardProjectRentController {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private StandardProjectRentService standardProjectRentService;

    @PostMapping(value = "/find/standardprojectrent/list")
    public JsonResult findStandardProjectRentList(@RequestBody StandardProjectRentRequestDTO standardProjectRentRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                standardProjectRentService.findStandardProjectRentByStandardProjectRentCQRS(standardProjectRentRequestDTO, pageParam));
    }

}
