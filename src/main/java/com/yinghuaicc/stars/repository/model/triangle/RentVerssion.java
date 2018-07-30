package com.yinghuaicc.stars.repository.model.triangle;

import java.time.LocalDateTime;

/**
 * 版本表
 */
public class RentVerssion {

    //id
    private String id;
    //版本名称
    private String  rentVerssionName;
    //指标总数
    private Integer sumTarget;
    //已录入指标个数
    private Integer targetcount;
    //未录入指标个数
    private Integer untargetcount;

    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
    private String createUser;
    private  String modifyUser;

    //状态 1：未审核，2：审核成功，3：审核失败
    private  String status;

    public String getId() {
        return id;
    }

    public String getRentVerssionName() {
        return rentVerssionName;
    }

    public void setRentVerssionName(String rentVerssionName) {
        this.rentVerssionName = rentVerssionName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getSumTarget() {
        return sumTarget;
    }

    public void setSumTarget(Integer sumTarget) {
        this.sumTarget = sumTarget;
    }

    public Integer getTargetcount() {
        return targetcount;
    }

    public void setTargetcount(Integer targetcount) {
        this.targetcount = targetcount;
    }

    public Integer getUntargetcount() {
        return untargetcount;
    }

    public void setUntargetcount(Integer untargetcount) {
        this.untargetcount = untargetcount;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }
}
