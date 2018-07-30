package com.yinghuaicc.stars.controller.business.pc.token;

import com.yinghuaicc.stars.config.response.JsonResult;
import com.yinghuaicc.stars.service.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/3 上午9:49
 * @Description: Token
 * @Modified:
 */
@RestController
@RequestMapping(value = "/token")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    /**
     *@Author:Fly Created in 2018/7/3 上午9:50
     *@Description: 刷新AccessToken
     */
    @RequestMapping(value = "/refresh/token/{refreshToken}")
    public JsonResult refreshToken(@PathVariable String refreshToken){

        return JsonResult.success(tokenService.refreshToken(refreshToken));
    }
}
