package com.yinghuaicc.stars.service.cqrs.brand.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yinghuaicc.stars.common.utils.date.LocalDateTimeUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Description: App专用查询品牌列表
 * @Modified:
 */
public class AppBrandCQRSListRequestDTO {

    private String projectId;
    private String floorId;
    //业态id
    private String businessFormId;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public void setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
    }
}
