package com.yinghuaicc.stars.controller.business.pc.intervalset;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.cqrs.Intervalset.FloorGuestIntervalService;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.request.FloorGuestIntervalRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

/**
 * 区间设置-客销度楼层
 */
@RestController
@RequestMapping(value="/floorguestinterval")
public class FloorGuestIntervalController {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private FloorGuestIntervalService floorGuestIntervalService;

    @PostMapping(value = "/find/floorguestinterval/list")
    public JsonResult findFloorGuestIntervalList(@RequestBody FloorGuestIntervalRequestDTO floorGuestIntervalRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                floorGuestIntervalService.findFloorGuestIntervalByFloorGuestIntervalCQRS(floorGuestIntervalRequestDTO, pageParam));
    }


}
