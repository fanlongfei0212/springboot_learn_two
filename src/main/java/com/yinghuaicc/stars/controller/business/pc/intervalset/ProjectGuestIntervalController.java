package com.yinghuaicc.stars.controller.business.pc.intervalset;

import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.cqrs.Intervalset.ProjectGuestIntervalService;
import com.yinghuaicc.stars.service.cqrs.Intervalset.dto.request.ProjectGuestIntervalRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

/**
 * 区间设置-项目客销度
 */
@RestController
@RequestMapping(value="/projectguestinterval")
public class ProjectGuestIntervalController {


    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private ProjectGuestIntervalService projectGuestIntervalService;

    @PostMapping(value = "/find/projectguestinterval/list")
    public JsonResult findProjectGuestIntervalList(@RequestBody ProjectGuestIntervalRequestDTO projectGuestIntervalRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                projectGuestIntervalService.findProjectGuestIntervalByProjectGuestIntervalCQRS(projectGuestIntervalRequestDTO, pageParam));
    }

}
