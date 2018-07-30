package com.yinghuaicc.stars.repository.model.standard.mult;


import java.math.BigDecimal;

/**
 * 导入Excel标准三角形业态客销度
 */
public class StandConditionGuestExcel {

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
    //业种名称
    private String majoName;
    //签约状态
    private String signStatus;
    //毛利率
    private BigDecimal grossRate;
    //客单价
    private BigDecimal perSale;

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

    public String getMajoName() {
        return majoName;
    }

    public void setMajoName(String majoName) {
        this.majoName = majoName;
    }

    public String getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(String signStatus) {
        this.signStatus = signStatus;
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
}
