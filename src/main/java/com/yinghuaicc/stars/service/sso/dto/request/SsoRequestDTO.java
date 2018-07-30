package com.yinghuaicc.stars.service.sso.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/24 下午4:45
 * @Description: 单点登录
 * @Modified:
 */
public class SsoRequestDTO {

    //为加密后的用户登录名
    @NotEmpty(message = "SSO_LOGIN_001")
    private String userName;

    //当前用户在平台登录的sessionId，业务系统可通过此参数进行判断用户登录状态，此参数非必需
    private String DTL_SESSION_ID;

    public String getUserName() {
        return userName;
    }

    public SsoRequestDTO setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getDTL_SESSION_ID() {
        return DTL_SESSION_ID;
    }

    public SsoRequestDTO setDTL_SESSION_ID(String DTL_SESSION_ID) {
        this.DTL_SESSION_ID = DTL_SESSION_ID;
        return this;
    }
}
