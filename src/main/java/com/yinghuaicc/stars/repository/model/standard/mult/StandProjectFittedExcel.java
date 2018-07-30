package com.yinghuaicc.stars.repository.model.standard.mult;

import java.math.BigDecimal;

/**
 * 导入Excel标准三角形项目适配值
 */
public class StandProjectFittedExcel {

    //项目id
    private String projectId;
    //项目名称
    private String projectName;
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

    public BigDecimal getFitted() {
        return fitted;
    }

    public void setFitted(BigDecimal fitted) {
        this.fitted = fitted;
    }
}
