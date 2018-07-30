package com.yinghuaicc.stars.service.cqrs.triangle.dto.request;

import java.time.LocalDateTime;

/**
 * 适配值版本
 */
public class FittedVerssionRequestDTO {

    /**
     * 版本名称
     */
    private String fittedVerssionName ="";
    /**
     * 版本开始时间
     */
    private String createTimeBegin;
    /**
     * 版本结束时间
     */
    private String createTimeEnd;

    public String getFittedVerssionName() {
        return fittedVerssionName;
    }

    public void setFittedVerssionName(String fittedVerssionName) {
        this.fittedVerssionName = fittedVerssionName;
    }

    public String getCreateTimeBegin() {
        return createTimeBegin;
    }

    public void setCreateTimeBegin(String createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
    }

    public String getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(String createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
}
