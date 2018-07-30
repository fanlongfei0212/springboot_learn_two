package com.yinghuaicc.stars.service.cqrs.standard.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 标准三角形品牌客销度
 */
public class StandardBrandSaleResponseDTO {
    //id
    private String id;
    //版本名称
    private String saleVessionId;
    //版本名称
    private String saleVessionName;
    //签约id
    private String contractId;
    private String projectId;
    private String projectName;
    //品牌名称
    private String contractName;
    //业态id
    private String conditionId;
    private String conditionName;
    //业种id
    private String majoId;
    private String majoName;
    private BigDecimal grossRate;
    private BigDecimal perSale;
    private String signStatus;

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

    public String getSaleVessionId() {
        return saleVessionId;
    }

    public void setSaleVessionId(String saleVessionId) {
        this.saleVessionId = saleVessionId;
    }

    public String getSaleVessionName() {
        return saleVessionName;
    }

    public void setSaleVessionName(String saleVessionName) {
        this.saleVessionName = saleVessionName;
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

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getConditionId() {
        return conditionId;
    }

    public void setConditionId(String conditionId) {
        this.conditionId = conditionId;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getMajoId() {
        return majoId;
    }

    public void setMajoId(String majoId) {
        this.majoId = majoId;
    }

    public String getMajoName() {
        return majoName;
    }

    public void setMajoName(String majoName) {
        this.majoName = majoName;
    }

    public BigDecimal getGrossRate() {
        return grossRate;
    }

    public void setGrossRate(BigDecimal grossRate) {
        this.grossRate = grossRate;
    }

    public BigDecimal getPerSale() {
        return perSale;
    }

    public void setPerSale(BigDecimal perSale) {
        this.perSale = perSale;
    }

    public String getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(String signStatus) {
        this.signStatus = signStatus;
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
