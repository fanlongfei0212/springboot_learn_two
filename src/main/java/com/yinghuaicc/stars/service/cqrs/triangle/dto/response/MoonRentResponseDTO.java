package com.yinghuaicc.stars.service.cqrs.triangle.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class MoonRentResponseDTO {

    //id
    private String id;
    //签约id
    private String contractId;
    //版本id
    private String rentVerssionId;

    //租金
    private BigDecimal rent;
    //物业费
    private BigDecimal propertyFee;
    //员工成本
    private BigDecimal  staffEmp;
    //装修折旧
    private BigDecimal fitment;
    //代理费
    private BigDecimal  agencyFee;
    //净利润
    private BigDecimal profit;

    //溢租率年月
    private LocalDateTime yearsmoon;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
    private String createUser;
    private  String modifyUser;
    //状态 1：未审核，2：审核成功，3：审核失败
    private  String status;
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

    public String getRentVerssionId() {
        return rentVerssionId;
    }

    public void setRentVerssionId(String rentVerssionId) {
        this.rentVerssionId = rentVerssionId;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public BigDecimal getPropertyFee() {
        return propertyFee;
    }

    public void setPropertyFee(BigDecimal propertyFee) {
        this.propertyFee = propertyFee;
    }

    public BigDecimal getStaffEmp() {
        return staffEmp;
    }

    public void setStaffEmp(BigDecimal staffEmp) {
        this.staffEmp = staffEmp;
    }

    public BigDecimal getFitment() {
        return fitment;
    }

    public void setFitment(BigDecimal fitment) {
        this.fitment = fitment;
    }

    public BigDecimal getAgencyFee() {
        return agencyFee;
    }

    public void setAgencyFee(BigDecimal agencyFee) {
        this.agencyFee = agencyFee;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
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

    public LocalDateTime getYearsmoon() {
        return yearsmoon;
    }

    public void setYearsmoon(LocalDateTime yearsmoon) {
        this.yearsmoon = yearsmoon;
    }
}
