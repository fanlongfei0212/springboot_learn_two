package com.yinghuaicc.stars.controller.business.pc.triangle;


import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.cqrs.triangle.DayRentService;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.DayRentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/dayrent")
public class DayRentController {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private DayRentService dayRentService;

    @PostMapping(value = "/find/dayrent/list")
    public JsonResult findMoonRantList(@RequestBody DayRentRequestDTO dayRentRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                dayRentService.findDayRentByDayRentCQRS(dayRentRequestDTO, pageParam));
    }
}
