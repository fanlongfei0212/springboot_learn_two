package com.yinghuaicc.stars.service.cqrs.triangle.dto.response;

import java.time.LocalDateTime;

public class GuestVerssionResponseDTO {
    //id
    private String id;
    //版本名称
    private String  guestVerssionName;
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
    //类别：1、项目 2、楼层、3、品牌
    private String different;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuestVerssionName() {
        return guestVerssionName;
    }

    public void setGuestVerssionName(String guestVerssionName) {
        this.guestVerssionName = guestVerssionName;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDifferent() {
        return different;
    }

    public void setDifferent(String different) {
        this.different = different;
    }
}
