package com.yinghuaicc.stars.repository.model.standard.mult;

import java.math.BigDecimal;

/**
 * 导入Excel标准三角形楼层适配值
 */
public class StandFloorFittedExcel {
    //项目id
    private String projectId;
    //项目名称
    private String projectName;
    //楼层名称
    private String floorName;
    //适配值
    private BigDecimal fitted;

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

    public BigDecimal getFitted() {
        return fitted;
    }

    public void setFitted(BigDecimal fitted) {
        this.fitted = fitted;
    }
}
