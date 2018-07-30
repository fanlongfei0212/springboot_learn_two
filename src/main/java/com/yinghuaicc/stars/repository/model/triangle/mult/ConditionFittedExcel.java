package com.yinghuaicc.stars.repository.model.triangle.mult;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 动态三角形业态客销度导入
 */
public class ConditionFittedExcel {

    //签约id
    private String constractId;
    //项目名称
    private String projectName;
    //楼层名称
    private String floorName;
    //铺位名称
    private String roomName;
    //品牌名称
    private String brandName;
    //业态名称
    private String conditionName;
    //签约状态
    private String signStatus;
    //市场定位
    private Integer marketPosition;
    //品牌地位
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


    public String getConstractId() {
        return constractId;
    }

    public void setConstractId(String constractId) {
        this.constractId = constractId;
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

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(String signStatus) {
        this.signStatus = signStatus;
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
}
