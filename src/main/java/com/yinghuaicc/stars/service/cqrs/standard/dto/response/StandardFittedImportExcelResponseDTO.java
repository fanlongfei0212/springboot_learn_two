package com.yinghuaicc.stars.service.cqrs.standard.dto.response;

import com.yinghuaicc.stars.repository.model.standard.mult.StandConditionFittedExcel;
import com.yinghuaicc.stars.repository.model.standard.mult.StandFloorFittedExcel;
import com.yinghuaicc.stars.repository.model.standard.mult.StandProjectFittedExcel;

import java.util.List;

/**
 * 标准三角形适配值导入
 */
public class StandardFittedImportExcelResponseDTO {

    //项目适配值
    List<StandProjectFittedExcel> standardProjectFitteds;
    //楼层适配值
    List<StandFloorFittedExcel> standardFloorFitteds;
    //业态适配值
    List<StandConditionFittedExcel> standardConditionFitteds;

    public List<StandProjectFittedExcel> getStandardProjectFitteds() {
        return standardProjectFitteds;
    }

    public void setStandardProjectFitteds(List<StandProjectFittedExcel> standardProjectFitteds) {
        this.standardProjectFitteds = standardProjectFitteds;
    }

    public List<StandFloorFittedExcel> getStandardFloorFitteds() {
        return standardFloorFitteds;
    }

    public void setStandardFloorFitteds(List<StandFloorFittedExcel> standardFloorFitteds) {
        this.standardFloorFitteds = standardFloorFitteds;
    }

    public List<StandConditionFittedExcel> getStandardConditionFitteds() {
        return standardConditionFitteds;
    }

    public void setStandardConditionFitteds(List<StandConditionFittedExcel> standardConditionFitteds) {
        this.standardConditionFitteds = standardConditionFitteds;
    }
}
