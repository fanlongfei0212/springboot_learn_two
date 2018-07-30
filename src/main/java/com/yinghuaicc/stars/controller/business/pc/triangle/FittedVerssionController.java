package com.yinghuaicc.stars.controller.business.pc.triangle;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.cqrs.triangle.FittedVerssionService;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.FittedVerssionRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

/**
 * 适配值版本controller
 */
@RestController
@RequestMapping(value = "/fittedverssion")
public class FittedVerssionController {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private FittedVerssionService fittedVerssionService;

    @PostMapping(value = "/find/fittedverssion/list")
    public JsonResult findMoonRantList(@RequestBody FittedVerssionRequestDTO fittedVerssionRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                fittedVerssionService.findFittedVerssionByFittedVerssionCQRS(fittedVerssionRequestDTO, pageParam));
    }

}
