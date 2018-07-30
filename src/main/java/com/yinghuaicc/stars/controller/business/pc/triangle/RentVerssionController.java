package com.yinghuaicc.stars.controller.business.pc.triangle;


import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.cqrs.triangle.RentVerssionService;

import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.RentVerssionRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/rantverssion")
public class RentVerssionController {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private RentVerssionService rentVerssionService;

    @PostMapping(value = "/find/rantverssion/list")
    public JsonResult findRantVerssionList(@RequestBody RentVerssionRequestDTO rentVerssionRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                rentVerssionService.findRentVerssionByRantVersionCQRS(
                        rentVerssionRequestDTO,
                        pageParam));
    }



}
