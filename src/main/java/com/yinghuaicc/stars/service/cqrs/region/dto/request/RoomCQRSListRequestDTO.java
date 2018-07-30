package com.yinghuaicc.stars.service.cqrs.region.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yinghuaicc.stars.common.utils.date.LocalDateTimeUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/12 上午12:31
 * @Description: 铺位列表
 * @Modified:
 */
public class RoomCQRSListRequestDTO {

    //区域id
    private String areaId = "";

    //公司id
    private String companyId = "";

    //项目id
    private String projectId = "";

    //铺位名称
    private String roomName = "";

    //状态
    private Integer state;

    //开始创建时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createTimeBegin;

    //结束创建时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createTimeEnd;

    public String getAreaId() {
        return areaId;
    }

    public RoomCQRSListRequestDTO setAreaId(String areaId) {
        this.areaId = areaId;
        return this;
    }

    public String getCompanyId() {
        return companyId;
    }

    public RoomCQRSListRequestDTO setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public RoomCQRSListRequestDTO setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getRoomName() {
        return roomName;
    }

    public RoomCQRSListRequestDTO setRoomName(String roomName) {
        this.roomName = roomName;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public RoomCQRSListRequestDTO setState(Integer state) {
        this.state = state;
        return this;
    }

    public LocalDateTime getCreateTimeBegin() {
        return LocalDateTimeUtils.customLocalDateTime(createTimeBegin,0,0,0);
    }

    public RoomCQRSListRequestDTO setCreateTimeBegin(LocalDate createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
        return this;
    }

    public LocalDateTime getCreateTimeEnd() {
        return LocalDateTimeUtils.customLocalDateTime(createTimeEnd,23,59,59);
    }

    public RoomCQRSListRequestDTO setCreateTimeEnd(LocalDate createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
        return this;
    }
}
