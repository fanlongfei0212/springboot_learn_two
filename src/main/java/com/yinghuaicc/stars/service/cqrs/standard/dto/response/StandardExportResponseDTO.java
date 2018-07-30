package com.yinghuaicc.stars.service.cqrs.standard.dto.response;

/**
 * Created by 你看见过我吗？你想一想在回答。 on 2018/7/29.
 */
public class StandardExportResponseDTO {
    private String contractId;//签约ID
    private String projectName;//项目名称
    private String floorName;//楼层
    private String roomName;//铺位号
    private String brandName;//品牌名称
    private String businessFormName;//业态名称
    private String state;//签约状态

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
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

    public String getBusinessFormName() {
        return businessFormName;
    }

    public void setBusinessFormName(String businessFormName) {
        this.businessFormName = businessFormName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
