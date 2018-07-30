package com.yinghuaicc.stars.service.cqrs.triangle.dto.response;

import com.yinghuaicc.stars.repository.model.triangle.mult.*;

import java.util.List;

/**
 * 动态三角形导入溢租率
 */
public class RentImportExcelResponseDTO {

    //租金
    List<RentalRentExcel> rentalRentExcels;
    //物业费
    List<PropertyRentExcel> propertyRentExcels;
    //装修折旧
    List<DecorateRentExcel> decorateRentExcels ;
    //代理
    List<LabourRentExcel> labourRentExcels;
    //人工
    List<AgentRentExcel> agentRentExcels;

    public List<RentalRentExcel> getRentalRentExcels() {
        return rentalRentExcels;
    }

    public void setRentalRentExcels(List<RentalRentExcel> rentalRentExcels) {
        this.rentalRentExcels = rentalRentExcels;
    }

    public List<PropertyRentExcel> getPropertyRentExcels() {
        return propertyRentExcels;
    }

    public void setPropertyRentExcels(List<PropertyRentExcel> propertyRentExcels) {
        this.propertyRentExcels = propertyRentExcels;
    }

    public List<DecorateRentExcel> getDecorateRentExcels() {
        return decorateRentExcels;
    }

    public void setDecorateRentExcels(List<DecorateRentExcel> decorateRentExcels) {
        this.decorateRentExcels = decorateRentExcels;
    }

    public List<LabourRentExcel> getLabourRentExcels() {
        return labourRentExcels;
    }

    public void setLabourRentExcels(List<LabourRentExcel> labourRentExcels) {
        this.labourRentExcels = labourRentExcels;
    }

    public List<AgentRentExcel> getAgentRentExcels() {
        return agentRentExcels;
    }

    public void setAgentRentExcels(List<AgentRentExcel> agentRentExcels) {
        this.agentRentExcels = agentRentExcels;
    }
}
