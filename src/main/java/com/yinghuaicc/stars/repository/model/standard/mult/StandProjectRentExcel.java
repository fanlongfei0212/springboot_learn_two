package com.yinghuaicc.stars.repository.model.standard.mult;

import java.math.BigDecimal;

/**
 * 导入Excel标准三角形项目溢租率
 */
public class StandProjectRentExcel {

    private String projectId;
    //项目名称
    private String projectName;
    //溢租率
    private BigDecimal rent;


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

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }
}
