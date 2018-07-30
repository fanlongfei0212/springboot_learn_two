package com.yinghuaicc.stars.controller.business.pc.triangle;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.cqrs.triangle.FloorGuestService;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.FloorGuestRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

/**
 * 楼层客销度
 */
@RestController
@RequestMapping(value = "/floorguest")
public class FloorGuestController {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private FloorGuestService floorGuestService;

    @PostMapping(value = "/find/floorguest/list")
    public JsonResult findFloorGuestList(@RequestBody FloorGuestRequestDTO floorGuestRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                floorGuestService.findFloorGuestByFloorGuestCQRS(floorGuestRequestDTO, pageParam));
    }
}
