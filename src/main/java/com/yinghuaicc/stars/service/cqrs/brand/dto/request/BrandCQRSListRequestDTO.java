package com.yinghuaicc.stars.service.cqrs.brand.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yinghuaicc.stars.common.utils.date.LocalDateTimeUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/12 下午2:33
 * @Description: 品牌列表
 * @Modified:
 */
public class BrandCQRSListRequestDTO {

    //品牌名称
    private String name = "";

    //业态id
    private String businessFormId = "";

    //业种id
    private String businessSpeciesId = "";

    //开始创建时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createTimeBegin;

    //结束创建时间
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate createTimeEnd;

    public String getName() {
        return name;
    }

    public BrandCQRSListRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public BrandCQRSListRequestDTO setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public LocalDateTime getCreateTimeBegin() {
        return LocalDateTimeUtils.customLocalDateTime(createTimeBegin,0,0,0);
    }

    public BrandCQRSListRequestDTO setCreateTimeBegin(LocalDate createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
        return this;
    }

    public LocalDateTime getCreateTimeEnd() {
        return LocalDateTimeUtils.customLocalDateTime(createTimeEnd,23,59,59);
    }

    public BrandCQRSListRequestDTO setCreateTimeEnd(LocalDate createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
        return this;
    }

    public String getBusinessSpeciesId() {
        return businessSpeciesId;
    }

    public BrandCQRSListRequestDTO setBusinessSpeciesId(String businessSpeciesId) {
        this.businessSpeciesId = businessSpeciesId;
        return this;
    }
}
