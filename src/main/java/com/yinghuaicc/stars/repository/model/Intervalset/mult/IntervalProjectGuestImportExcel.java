package com.yinghuaicc.stars.repository.model.Intervalset.mult;

import java.math.BigDecimal;

/**
 * 区间设置项目客销度导入类
 */
public class IntervalProjectGuestImportExcel {

    //id
    private String constractId;
    //项目名称
    private String projcetName;
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
