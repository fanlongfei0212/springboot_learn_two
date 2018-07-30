package com.yinghuaicc.stars.repository.model.triangle.mult;

import java.math.BigDecimal;

/**
 * 动态三角形业态客销度导入
 */
public class ConditionGuestExcel {

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
    //客流量
    private BigDecimal passengerFlow;
    //销售额
    private BigDecimal saleroom;

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

    public BigDecimal getPassengerFlow() {
        return passengerFlow;
    }

    public void setPassengerFlow(BigDecimal passengerFlow) {
        this.passengerFlow = passengerFlow;
    }

    public BigDecimal getSaleroom() {
        return saleroom;
    }

    public void setSaleroom(BigDecimal saleroom) {
        this.saleroom = saleroom;
    }
}
