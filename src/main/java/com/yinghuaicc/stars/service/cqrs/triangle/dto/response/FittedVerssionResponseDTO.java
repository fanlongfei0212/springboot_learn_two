package com.yinghuaicc.stars.service.cqrs.triangle.dto.response;

import java.time.LocalDateTime;

/**
 * 适配值版本
 */
public class FittedVerssionResponseDTO {
    //id
    private String id;

    //版本名称
    private String  fittedVerssionName;
    //模板id
    private String tempId;
    //指标总数
    private Integer sumTarget;
    //已录入指标个数
    private Integer targetcount;
    //未录入指标个数
    private Integer untargetcount;
    //状态 1：未审核，2：审核成功，3：审核失败
    private  String status;

    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
    private String createUser;
    private  String modifyUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFittedVerssionName() {
        return fittedVerssionName;
    }

    public void setFittedVerssionName(String fittedVerssionName) {
        this.fittedVerssionName = fittedVerssionName;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
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
}
