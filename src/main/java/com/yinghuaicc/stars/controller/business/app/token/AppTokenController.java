package com.yinghuaicc.stars.controller.business.app.token;

import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/25 下午4:49
 * @Description: AppTokenController
 * @Modified:
 */
@RestController
@RequestMapping(value = "/app/token")
public class AppTokenController {

    @Autowired
    private TokenService tokenService;

    /**
     *@Author:Fly Created in 2018/7/25 下午4:50
     *@Description: 刷新RefreshToken
     */
    @GetMapping(value = "/refresh/token/{refreshToken}")
    public JsonResult refreshAppToken(@PathVariable String refreshToken){

        return JsonResult.success(
                tokenService.refreshAppToken(refreshToken));
    }
}
