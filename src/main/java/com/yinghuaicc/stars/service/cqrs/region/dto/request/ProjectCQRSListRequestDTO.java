package com.yinghuaicc.stars.service.cqrs.region.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yinghuaicc.stars.common.utils.date.LocalDateTimeUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/3 下午5:20
 * @Description: 项目管理列表
 * @Modified:
 */
public class ProjectCQRSListRequestDTO {

    //区域id
    private String areaId;

    //公司id
    private String companyId;

    //项目名称
    private String projectName = "";

    //项目负责人名称
    private String employeeName = "";

    //开始时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createTimeBegin;

    //结束时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createTimeEnd;

    public String getAreaId() {
        return areaId;
    }

    public ProjectCQRSListRequestDTO setAreaId(String areaId) {
        this.areaId = areaId;
        return this;
    }

    public String getCompanyId() {
        return companyId;
    }

    public ProjectCQRSListRequestDTO setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getProjectName() {
        return projectName;
    }

    public ProjectCQRSListRequestDTO setProjectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public ProjectCQRSListRequestDTO setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
        return this;
    }

    public LocalDateTime getCreateTimeBegin() {
        return LocalDateTimeUtils.customLocalDateTime(createTimeBegin,0,0,0);
    }

    public ProjectCQRSListRequestDTO setCreateTimeBegin(LocalDate createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
        return this;
    }

    public LocalDateTime getCreateTimeEnd() {
        return LocalDateTimeUtils.customLocalDateTime(createTimeEnd,23,59,59);
    }

    public ProjectCQRSListRequestDTO setCreateTimeEnd(LocalDate createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
        return this;
    }
}
