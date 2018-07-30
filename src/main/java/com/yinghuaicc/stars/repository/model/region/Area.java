package com.yinghuaicc.stars.repository.model.region;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/26 下午2:54
 * @Description: 区域
 * @Modified:
 */
public class Area {

    //区域id
    private String id;

    //编号
    private String num;

    //区域名称
    private String name;

    //区域等级，1代表一级区域，2代表2级区域
    private Integer level;

    //负责人id
    private String employeeId;

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

    public Area setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public Area setNum(String num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public Area setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getLevel() {
        return level;
    }

    public Area setLevel(Integer level) {
        this.level = level;
        return this;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public Area setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Area setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public Area setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Area setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public Area setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
