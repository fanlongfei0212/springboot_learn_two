package com.yinghuaicc.stars.controller.business.pc.triangle;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.cqrs.triangle.GuestVerssionService;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.GuestVerssionRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/guestverssion")
public class GuestVerssionController {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private GuestVerssionService guestVerssionService;

    /**
     * 客销度版本列表
     * @param guestVerssionRequestDTO
     * @param pageParam
     * @return
     */
    @PostMapping(value = "/find/guestverssion/list")
    public JsonResult findGuestVerssionList(@RequestBody GuestVerssionRequestDTO guestVerssionRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                guestVerssionService.findGuestVerssionByGuestVerssionCQRS(guestVerssionRequestDTO, pageParam));
    }

}
