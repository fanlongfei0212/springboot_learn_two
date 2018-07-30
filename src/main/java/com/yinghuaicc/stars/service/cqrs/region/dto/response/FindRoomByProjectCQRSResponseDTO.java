package com.yinghuaicc.stars.service.cqrs.region.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/16 下午8:34
 * @Description: 根据项目查询未签约铺位
 * @Modified:
 */
public class FindRoomByProjectCQRSResponseDTO {

    //铺位id
    private String roomId;

    //铺位名称
    private String roomName;

    //层名称
    private String floorName;

    public String getRoomId() {
        return roomId;
    }

    public FindRoomByProjectCQRSResponseDTO setRoomId(String roomId) {
        this.roomId = roomId;
        return this;
    }

    public String getRoomName() {
        return roomName;
    }

    public FindRoomByProjectCQRSResponseDTO setRoomName(String roomName) {
        this.roomName = roomName;
        return this;
    }

    public String getFloorName() {
        return floorName;
    }

    public FindRoomByProjectCQRSResponseDTO setFloorName(String floorName) {
        this.floorName = floorName;
        return this;
    }
}
