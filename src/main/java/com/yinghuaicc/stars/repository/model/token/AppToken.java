package com.yinghuaicc.stars.repository.model.token;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/25 下午4:22
 * @Description: AppToken
 * @Modified:
 */
public class AppToken {

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

    public AppToken setId(String id) {
        this.id = id;
        return this;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public AppToken setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public AppToken setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public AppToken setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public AppToken setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public AppToken setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public AppToken setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public AppToken setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }
}
