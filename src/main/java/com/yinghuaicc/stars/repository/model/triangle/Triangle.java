package com.yinghuaicc.stars.repository.model.triangle;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 三角理论
 */
public class Triangle {

    //id
    private String id;
    //签约id
    private String contractId;

    //租金
    private BigDecimal rant;
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
    //客流量
    private BigDecimal guestFlow;
    //销售额
    private BigDecimal sale;
    //适配值
    private Integer fitted;
    //状态
    private Integer status;
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

    public BigDecimal getRant() {
        return rant;
    }

    public void setRant(BigDecimal rant) {
        this.rant = rant;
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

    public BigDecimal getGuestFlow() {
        return guestFlow;
    }

    public void setGuestFlow(BigDecimal guestFlow) {
        this.guestFlow = guestFlow;
    }

    public BigDecimal getSale() {
        return sale;
    }

    public void setSale(BigDecimal sale) {
        this.sale = sale;
    }

    public Integer getFitted() {
        return fitted;
    }

    public void setFitted(Integer fitted) {
        this.fitted = fitted;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
