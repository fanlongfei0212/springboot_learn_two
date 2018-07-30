package com.yinghuaicc.stars.repository.model.triangle;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 项目客销度
 */
public class ProjectGuest {

    //id
    private String id;
    //签约id
    private String contractId;
    //项目id
    private String projectId;
    //项目名称
    private String projectName;
    //签约状态
    private String  contractStatus;
    //客销度版本id
    private String guestVerssionId;
    //客流量
    private BigDecimal passengerFlow;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
    private String createUser;
    private  String modifyUser;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public String getGuestVerssionId() {
        return guestVerssionId;
    }

    public void setGuestVerssionId(String guestVerssionId) {
        this.guestVerssionId = guestVerssionId;
    }

    public BigDecimal getPassengerFlow() {
        return passengerFlow;
    }

    public void setPassengerFlow(BigDecimal passengerFlow) {
        this.passengerFlow = passengerFlow;
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
