package com.yinghuaicc.stars.service.tissue.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/2 下午8:02
 * @Description: 用户登录Token返回
 * @Modified:
 */
public class EmployeeLoginTokenResponseDTO {

    //AccessToken
    private String accessToken;

    //RefreshToken
    private String refreshToken;

    //用户登录信息
    private EmployeeLoginInfoResponseDTO employeeLoginInfoResponseDTO;

    public String getAccessToken() {
        return accessToken;
    }

    public EmployeeLoginTokenResponseDTO setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public EmployeeLoginTokenResponseDTO setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public EmployeeLoginInfoResponseDTO getEmployeeLoginInfoResponseDTO() {
        return employeeLoginInfoResponseDTO;
    }

    public EmployeeLoginTokenResponseDTO setEmployeeLoginInfoResponseDTO(EmployeeLoginInfoResponseDTO employeeLoginInfoResponseDTO) {
        this.employeeLoginInfoResponseDTO = employeeLoginInfoResponseDTO;
        return this;
    }
}
