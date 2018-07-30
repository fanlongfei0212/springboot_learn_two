package com.yinghuaicc.stars.service.token;

import com.yinghuaicc.stars.service.token.dto.response.RefreshAppTokenResponseDTO;
import com.yinghuaicc.stars.service.token.dto.response.RefreshTokenResponseDTO;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/3 上午1:38
 * @Description: Token服务
 * @Modified:
 */
public interface TokenService {

    /**
     *@Author:Fly Created in 2018/7/3 上午1:42
     *@Description: 刷新AccessToken
     */
    RefreshTokenResponseDTO refreshToken(String refreshToken);


    /**
     *@Author:Fly Created in 2018/7/25 下午4:44
     *@Description: 刷新AppAccessToken
     */
    RefreshAppTokenResponseDTO refreshAppToken(String refreshToken);

}
