package com.yinghuaicc.stars.repository.model.triangle.mult;

import java.math.BigDecimal;

/**
 * 动态三角形楼层客销度导入
 */
public class FloorGuestExcel {

    //签约id
    private String constractId;
    //项目名称
    private String projectName;
    //楼层名称
    private String floorName;
    //客流量
    private BigDecimal passengerFlow;

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

    public BigDecimal getPassengerFlow() {
        return passengerFlow;
    }

    public void setPassengerFlow(BigDecimal passengerFlow) {
        this.passengerFlow = passengerFlow;
    }
}
