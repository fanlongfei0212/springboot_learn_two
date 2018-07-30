package com.yinghuaicc.stars.repository.model.token;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/2 下午6:52
 * @Description: Token
 * @Modified:
 */
public class Token {

    //id
    private String id;

    //AccessToken
    private String accessToken;

    //RefreshToken
    private String refreshToken;

    //员工id
    private String employeeId;

    //创建人
    private String createUser;

    //修改人
    private String modifyUser;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    public String getId() {
        return id;
    }

    public Token setId(String id) {
        this.id = id;
        return this;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public Token setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public Token setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Token setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Token setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public Token setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Token setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public Token setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }
}
