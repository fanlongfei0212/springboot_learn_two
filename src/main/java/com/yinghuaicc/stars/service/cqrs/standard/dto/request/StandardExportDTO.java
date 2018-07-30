package com.yinghuaicc.stars.service.cqrs.standard.dto.request;

/**
 * Created by 你看见过我吗？你想一想在回答。 on 2018/7/29.
 */
public class StandardExportDTO {
    private String projectId; //项目ID
    private String floorId; //楼层ID

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
}
