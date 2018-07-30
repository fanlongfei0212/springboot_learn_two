package com.yinghuaicc.stars.repository.model.triangle;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 每天品牌动态三角形
 */
public class DayTriangle {

    //id
    private String id;
    //签约id
    private String contractId;
    //溢租率
    private BigDecimal rentRedio;
    //客销度
    private  Integer guestDegrees;
    //适配值
    private Integer fitted;
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

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public BigDecimal getRentRedio() {
        return rentRedio;
    }

    public void setRentRedio(BigDecimal rentRedio) {
        this.rentRedio = rentRedio;
    }

    public Integer getGuestDegrees() {
        return guestDegrees;
    }

    public void setGuestDegrees(Integer guestDegrees) {
        this.guestDegrees = guestDegrees;
    }

    public Integer getFitted() {
        return fitted;
    }

    public void setFitted(Integer fitted) {
        this.fitted = fitted;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
