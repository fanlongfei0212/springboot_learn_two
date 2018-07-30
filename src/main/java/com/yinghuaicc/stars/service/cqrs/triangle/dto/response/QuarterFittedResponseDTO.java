package com.yinghuaicc.stars.service.cqrs.triangle.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class QuarterFittedResponseDTO {
    //id
    private String id;
    //签约id
    private String contractId;
    //品牌名称
    private String contractName;
    //项目名称
    private String projectName;
    //楼层
    private String floorName;
    //铺位名称
    private String  roomName;
    //业态名称
    private String conditionName;
    //业种名称
    private String  majoName;
    //签约状态
    private String  contractStatus;
    //版本id
    private String fittedVerssionId;
    //市场定位
    private Integer marketPosition;
    //品牌定位
    private Integer brandPosition;
    //品牌形象
    private Integer brandImage;
    //租费收缴率
    private BigDecimal rentalRate;
    //连锁跟进度
    private BigDecimal chainDegree;
    //客服投诉率
    private BigDecimal complaintDegree;
    //企划配合度
    private BigDecimal layoutDegree;
    //开始时间
    private LocalDateTime startTime;
    //结束时间
    private LocalDateTime endTime;
    //创建时间
    private LocalDateTime createTime;
    //修改时间
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

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getMajoName() {
        return majoName;
    }

    public void setMajoName(String majoName) {
        this.majoName = majoName;
    }

    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    public String getFittedVerssionId() {
        return fittedVerssionId;
    }

    public void setFittedVerssionId(String fittedVerssionId) {
        this.fittedVerssionId = fittedVerssionId;
    }

    public Integer getMarketPosition() {
        return marketPosition;
    }

    public void setMarketPosition(Integer marketPosition) {
        this.marketPosition = marketPosition;
    }

    public Integer getBrandPosition() {
        return brandPosition;
    }

    public void setBrandPosition(Integer brandPosition) {
        this.brandPosition = brandPosition;
    }

    public Integer getBrandImage() {
        return brandImage;
    }

    public void setBrandImage(Integer brandImage) {
        this.brandImage = brandImage;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public BigDecimal getChainDegree() {
        return chainDegree;
    }

    public void setChainDegree(BigDecimal chainDegree) {
        this.chainDegree = chainDegree;
    }

    public BigDecimal getComplaintDegree() {
        return complaintDegree;
    }

    public void setComplaintDegree(BigDecimal complaintDegree) {
        this.complaintDegree = complaintDegree;
    }

    public BigDecimal getLayoutDegree() {
        return layoutDegree;
    }

    public void setLayoutDegree(BigDecimal layoutDegree) {
        this.layoutDegree = layoutDegree;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
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
