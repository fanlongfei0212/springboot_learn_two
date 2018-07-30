package com.yinghuaicc.stars.service.cqrs.triangle.dto.request;

public class RentVerssionRequestDTO {

    /**
     * 版本名称
     */
    private String rentVerssionName ="";
    /**
     * 版本开始时间
     */
    private String createTimeBegin;
    /**
     * 版本结束时间
     */
    private String createTimeEnd;

    public String getRentVerssionName() {
        return rentVerssionName;
    }

    public void setRentVerssionName(String rentVerssionName) {
        this.rentVerssionName = rentVerssionName;
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
