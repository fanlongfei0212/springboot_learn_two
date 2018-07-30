package com.yinghuaicc.stars.repository.model.tissue;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/27 下午6:09
 * @Description: 员工
 * @Modified:
 */
public class Employee {

    //id
    private String id;

    //编号
    private String num;

    //名称
    private String name;

    //手机
    private String phone;

    //邮箱
    private String email;

    //用户名
    private String userName;

    //密码
    private String password;

    //是否启用（true：启用，false：禁用）
    private boolean state;

    //类型(1:内部，2：外部，外部系统同步数据)
    private Integer type;

    //所属机构id
    private String orgId;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    //创建人
    private String createUser;

    //修改人
    private String modifyUser;

    public String getId() {
        return id;
    }

    public Employee setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public Employee setNum(String num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Employee setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Employee setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public Employee setPassword(String password) {
        this.password = password;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public Employee setState(boolean state) {
        this.state = state;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public Employee setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getOrgId() {
        return orgId;
    }

    public Employee setOrgId(String orgId) {
        this.orgId = orgId;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Employee setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public Employee setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Employee setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public Employee setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
