package com.yinghuaicc.stars.service.cqrs.region.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/17 上午10:54
 * @Description: 查询项目下未签约的铺位
 * @Modified:
 */
public class FindRoomByProjectCQRSRequestDTO {

    @NotEmpty(message = "ROOM_CQRS_FIND_BY_PROJECT_001")
    private String projectId;

    private String roomName = "";

    public String getProjectId() {
        return projectId;
    }

    public FindRoomByProjectCQRSRequestDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getRoomName() {
        return roomName;
    }

    public FindRoomByProjectCQRSRequestDTO setRoomName(String roomName) {
        this.roomName = roomName;
        return this;
    }
}
