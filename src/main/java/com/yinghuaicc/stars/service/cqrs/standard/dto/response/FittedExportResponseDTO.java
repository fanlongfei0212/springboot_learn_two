package com.yinghuaicc.stars.service.cqrs.standard.dto.response;

/**
 * Created by 你看见过我吗？你想一想在回答。 on 2018/7/29.
 */
public class FittedExportResponseDTO {
    private String id;//签约ID
    private String projectName;//项目名称
    private String floorName;//楼层名称
    private String roomName; //铺位号
    private String brandName;//品牌名称
    private String businessName; //业态名称
    private String sate;//签约状态

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getSate() {
        return sate;
    }

    public void setSate(String sate) {
        this.sate = sate;
    }
}
