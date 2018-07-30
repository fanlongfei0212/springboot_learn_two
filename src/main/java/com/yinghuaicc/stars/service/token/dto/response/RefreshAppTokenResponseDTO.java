package com.yinghuaicc.stars.service.token.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/25 下午4:43
 * @Description: AppToken服务
 * @Modified:
 */
public class RefreshAppTokenResponseDTO {

    //AccessToken
    private String accessToken;

    //RefreshToken
    private String refreshToken;

    public String getAccessToken() {
        return accessToken;
    }

    public RefreshAppTokenResponseDTO setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public RefreshAppTokenResponseDTO setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }
}
