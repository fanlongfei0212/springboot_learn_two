package com.yinghuaicc.stars.service.sso;

import com.yinghuaicc.stars.service.sso.dto.request.AppSsoRequestDTO;
import com.yinghuaicc.stars.service.sso.dto.request.SsoRequestDTO;
import com.yinghuaicc.stars.service.tissue.dto.response.EmployeeLoginTokenResponseDTO;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/24 下午4:44
 * @Description: 单点登录
 * @Modified:
 */
public interface SsoService {

    /**
     *@Author:Fly Created in 2018/7/24 下午4:52
     *@Description: 单点登录
     */
    EmployeeLoginTokenResponseDTO ssoLogin(SsoRequestDTO ssoRequestDTO);

    /**
     *@Author:Fly Created in 2018/7/25 下午5:00
     *@Description: 移动端单点登录
     */
    EmployeeLoginTokenResponseDTO appSsoLogin(AppSsoRequestDTO appSsoRequestDTO);
}
