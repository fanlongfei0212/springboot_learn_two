package com.yinghuaicc.stars.service.cqrs.standard.dto.response;

/**
 * Created by 你看见过我吗？你想一想在回答。 on 2018/7/29.
 */
public class StandardFittedExportResponseDTO {
    private String id;//签约ID
    private String projectId;//项目ID
    private String projectName;//项目名称
    private String floorName;//楼层名称
    private String businessName; //业态名称
    private String speciesName;//业种名称

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }
}
