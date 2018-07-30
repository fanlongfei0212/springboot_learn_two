package com.yinghuaicc.stars.controller.business.pc.triangle;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.cqrs.triangle.DayGuestService;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.DayGuestRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

/**
 * 每日客销度controller
 */
@RestController
@RequestMapping(value = "/dayguest")
public class DayGuestController {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private DayGuestService dayGuestService;

    @PostMapping(value = "/find/dayguest/list")
    public JsonResult findMoonRantList(@RequestBody DayGuestRequestDTO dayGuestResponseDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                dayGuestService.findDayGuestByDayGuestCQRS(dayGuestResponseDTO, pageParam));
    }

    /**
     * 查询全国客流量
     * @return
     */
    @PostMapping(value = "/find/passengerflowall/list")
    public JsonResult findPassengerFlowAll(){
        return JsonResult.success(dayGuestService.findPassengerFlowAll());
    }

    /**
     * 查询全国销售额
     * @return
     */
    @PostMapping(value = "/find/saleroomall/list")
    public JsonResult findSaleroomAll(){
        return JsonResult.success(dayGuestService.findSaleroomAll());

    }

}
