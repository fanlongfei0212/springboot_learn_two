package com.yinghuaicc.stars.service.cqrs.standard.dto.response;

import com.yinghuaicc.stars.repository.model.standard.mult.*;

import java.util.List;

/**
 * 标准三角形溢租率导入
 */
public class StandardRentImportExcelResponseDTO {

    //项目溢租率
    List<StandProjectRentExcel> standProjectRentExcels;
    //楼层溢租率
    List<StandFloorRentExcel> standFloorRentExcels;
    //业态溢租率
    List<StandConditionRentExcel> standConditionRentExcels;

    public List<StandProjectRentExcel> getStandProjectRentExcels() {
        return standProjectRentExcels;
    }

    public void setStandProjectRentExcels(List<StandProjectRentExcel> standProjectRentExcels) {
        this.standProjectRentExcels = standProjectRentExcels;
    }

    public List<StandFloorRentExcel> getStandFloorRentExcels() {
        return standFloorRentExcels;
    }

    public void setStandFloorRentExcels(List<StandFloorRentExcel> standFloorRentExcels) {
        this.standFloorRentExcels = standFloorRentExcels;
    }

    public List<StandConditionRentExcel> getStandConditionRentExcels() {
        return standConditionRentExcels;
    }

    public void setStandConditionRentExcels(List<StandConditionRentExcel> standConditionRentExcels) {
        this.standConditionRentExcels = standConditionRentExcels;
    }
}
