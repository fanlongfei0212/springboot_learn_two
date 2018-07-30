package com.yinghuaicc.stars.service.token.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/3 上午1:40
 * @Description: 刷新AccessToken
 * @Modified:
 */
public class RefreshTokenResponseDTO {

    //AccessToken
    private String accessToken;

    //RefreshToken
    private String refreshToken;

    public String getAccessToken() {
        return accessToken;
    }

    public RefreshTokenResponseDTO setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public RefreshTokenResponseDTO setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }
}
