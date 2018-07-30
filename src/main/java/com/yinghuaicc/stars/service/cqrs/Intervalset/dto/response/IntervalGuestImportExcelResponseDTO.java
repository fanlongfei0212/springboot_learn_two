package com.yinghuaicc.stars.service.cqrs.Intervalset.dto.response;

import com.yinghuaicc.stars.repository.model.Intervalset.mult.IntervalConditionGuestImportExcel;
import com.yinghuaicc.stars.repository.model.Intervalset.mult.IntervalFloorGuestImportExcel;
import com.yinghuaicc.stars.repository.model.Intervalset.mult.IntervalProjectGuestImportExcel;

import java.util.List;

/**
 * 区间设置客销度导入
 */
public class IntervalGuestImportExcelResponseDTO {

    List<IntervalProjectGuestImportExcel> intervalProjectGuestImportExcelList;

    List<IntervalFloorGuestImportExcel> intervalFloorGuestImportExcelList;

    List<IntervalConditionGuestImportExcel> intervalConditionGuestImportExcelList;

    public List<IntervalProjectGuestImportExcel> getIntervalProjectGuestImportExcelList() {
        return intervalProjectGuestImportExcelList;
    }

    public void setIntervalProjectGuestImportExcelList(List<IntervalProjectGuestImportExcel> intervalProjectGuestImportExcelList) {
        this.intervalProjectGuestImportExcelList = intervalProjectGuestImportExcelList;
    }

    public List<IntervalFloorGuestImportExcel> getIntervalFloorGuestImportExcelList() {
        return intervalFloorGuestImportExcelList;
    }

    public void setIntervalFloorGuestImportExcelList(List<IntervalFloorGuestImportExcel> intervalFloorGuestImportExcelList) {
        this.intervalFloorGuestImportExcelList = intervalFloorGuestImportExcelList;
    }

    public List<IntervalConditionGuestImportExcel> getIntervalConditionGuestImportExcelList() {
        return intervalConditionGuestImportExcelList;
    }

    public void setIntervalConditionGuestImportExcelList(List<IntervalConditionGuestImportExcel> intervalConditionGuestImportExcelList) {
        this.intervalConditionGuestImportExcelList = intervalConditionGuestImportExcelList;
    }
}
