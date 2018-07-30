package com.yinghuaicc.stars.service.cqrs.triangle.dto.response;

import com.yinghuaicc.stars.repository.model.triangle.mult.*;

import java.util.List;

/**
 * 动态三角形导入客销度
 */
public class GuestImportExcelResponseDTO {

    //项目客销度
    List<ProjectGuestExcel> projectGuestExcels;
    //楼层客销度
    List<FloorGuestExcel> floorGuestExcels;
    //业态客销度
    List<ConditionGuestExcel> conditionGuestExcels ;

    public List<ProjectGuestExcel> getProjectGuestExcels() {
        return projectGuestExcels;
    }

    public void setProjectGuestExcels(List<ProjectGuestExcel> projectGuestExcels) {
        this.projectGuestExcels = projectGuestExcels;
    }

    public List<FloorGuestExcel> getFloorGuestExcels() {
        return floorGuestExcels;
    }

    public void setFloorGuestExcels(List<FloorGuestExcel> floorGuestExcels) {
        this.floorGuestExcels = floorGuestExcels;
    }

    public List<ConditionGuestExcel> getConditionGuestExcels() {
        return conditionGuestExcels;
    }

    public void setConditionGuestExcels(List<ConditionGuestExcel> conditionGuestExcels) {
        this.conditionGuestExcels = conditionGuestExcels;
    }
}
