package com.yinghuaicc.stars.controller.business.pc.triangle;


import com.yinghuaicc.stars.config.page.PageParam;
import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.cqrs.triangle.ProjectGuestService;
import com.yinghuaicc.stars.service.cqrs.triangle.dto.request.ProjectGuestRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

/**
 * 项目客销度controller
 */
@RestController
@RequestMapping(value = "/projectguest")
public class ProjectGuestController {

    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private ProjectGuestService projectGuestService;

    @PostMapping(value = "/find/projectguest/list")
    public JsonResult findProjectGuestList(@RequestBody ProjectGuestRequestDTO projectGuestRequestDTO, @ModelAttribute PageParam pageParam){

        return JsonResult.success(
                projectGuestService.findProjectGuestByProjectGuestCQRS(projectGuestRequestDTO, pageParam));
    }


}
