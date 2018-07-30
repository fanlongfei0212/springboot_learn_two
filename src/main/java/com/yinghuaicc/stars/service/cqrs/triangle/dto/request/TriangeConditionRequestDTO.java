package com.yinghuaicc.stars.service.cqrs.triangle.dto.request;

/**
 * 通过项目id、楼层id查询业态list--参数类
 */
public class TriangeConditionRequestDTO {

    private String projectId;
    private String floorId;

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
