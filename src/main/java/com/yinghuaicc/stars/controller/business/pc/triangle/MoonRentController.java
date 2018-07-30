package com.yinghuaicc.stars.controller.business.pc.triangle;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.cqrs.triangle.MoonRentService;

import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.MoonRentRequestDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/moonrent")
public class MoonRentController {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private MoonRentService moonRentService;

    @PostMapping(value = "/find/moonrent/list")
    public JsonResult findMoonRantList(@RequestBody MoonRentRequestDTO moonRentRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                moonRentService.findRentVerssionByRantVersionCQRS(moonRentRequestDTO, pageParam));
    }

}
