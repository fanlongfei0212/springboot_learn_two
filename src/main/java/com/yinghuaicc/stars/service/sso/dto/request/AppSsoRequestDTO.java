package com.yinghuaicc.stars.service.sso.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/25 下午4:55
 * @Description: App单点登录
 * @Modified:
 */
public class AppSsoRequestDTO {

    //为加密后的用户登录名
    @NotEmpty(message = "APP_SSO_LOGIN_001")
    private String thirdUserName;

    //当前用户在平台登录的sessionId，业务系统可通过此参数进行判断用户登录状态，此参数非必需
    private String sessionId;

    public String getThirdUserName() {
        return thirdUserName;
    }

    public AppSsoRequestDTO setThirdUserName(String thirdUserName) {
        this.thirdUserName = thirdUserName;
        return this;
    }

    public String getSessionId() {
        return sessionId;
    }

    public AppSsoRequestDTO setSessionId(String sessionId) {
        this.sessionId = sessionId;
        return this;
    }
}
