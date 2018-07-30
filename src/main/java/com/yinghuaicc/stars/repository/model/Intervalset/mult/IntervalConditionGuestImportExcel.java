package com.yinghuaicc.stars.repository.model.Intervalset.mult;

import java.math.BigDecimal;

/**
 * 区间设置业态客销度导入类
 */
public class IntervalConditionGuestImportExcel {
    //id
    private String constractId;
    //项目名称
    private String projcetName;
    //业态名称
    private String conditionName;
    //业种名称
    private String majoName;

    //区间最大值
    private BigDecimal maxvalue;
    //区间增长百分比
    private BigDecimal intervalRate;

    public String getConstractId() {
        return constractId;
    }

    public void setConstractId(String constractId) {
        this.constractId = constractId;
    }

    public String getProjcetName() {
        return projcetName;
    }

    public void setProjcetName(String projcetName) {
        this.projcetName = projcetName;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getMajoName() {
        return majoName;
    }

    public void setMajoName(String majoName) {
        this.majoName = majoName;
    }

    public BigDecimal getMaxvalue() {
        return maxvalue;
    }

    public void setMaxvalue(BigDecimal maxvalue) {
        this.maxvalue = maxvalue;
    }

    public BigDecimal getIntervalRate() {
        return intervalRate;
    }

    public void setIntervalRate(BigDecimal intervalRate) {
        this.intervalRate = intervalRate;
    }
}
