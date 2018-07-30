package com.yinghuaicc.stars.repository.model.external;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/17 下午3:10
 * @Description: 人员
 * @Modified:
 */
public class ExternalEmployee {

    private String id;

    //真实姓名
    private String realName;

    //登录名称
    private String loginName;

    //邮箱
    private String email;

    //电话
    private String mobile;

    //所属组织id
    private String belongOrgId;

    //状态
    private String status;

    private boolean delflag;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    //创建用户
    private String createUser;

    //修改用户
    private String modifyUser;

    public String getId() {
        return id;
    }

    public ExternalEmployee setId(String id) {
        this.id = id;
        return this;
    }

    public String getRealName() {
        return realName;
    }

    public ExternalEmployee setRealName(String realName) {
        this.realName = realName;
        return this;
    }

    public String getLoginName() {
        return loginName;
    }

    public ExternalEmployee setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ExternalEmployee setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMobile() {
        return mobile;
    }

    public ExternalEmployee setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public String getBelongOrgId() {
        return belongOrgId;
    }

    public ExternalEmployee setBelongOrgId(String belongOrgId) {
        this.belongOrgId = belongOrgId;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ExternalEmployee setStatus(String status) {
        this.status = status;
        return this;
    }

    public boolean isDelflag() {
        return delflag;
    }

    public ExternalEmployee setDelflag(boolean delflag) {
        this.delflag = delflag;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ExternalEmployee setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public ExternalEmployee setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public ExternalEmployee setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public ExternalEmployee setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
