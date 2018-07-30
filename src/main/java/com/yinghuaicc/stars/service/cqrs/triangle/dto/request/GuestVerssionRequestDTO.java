package com.yinghuaicc.stars.service.cqrs.triangle.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 客销度版本参数类
 */
public class GuestVerssionRequestDTO {
    //版本名称
    private String guestVerssionName;
    //版本开始时间
    private BigDecimal createTimeBegin;
    //版本结束时间
    private LocalDateTime createTimeEnd;
    //类别：1、项目 2、楼层、3、品牌
    private String different;

    public String getGuestVerssionName() {
        return guestVerssionName;
    }

    public void setGuestVerssionName(String guestVerssionName) {
        this.guestVerssionName = guestVerssionName;
    }

    public BigDecimal getCreateTimeBegin() {
        return createTimeBegin;
    }

    public void setCreateTimeBegin(BigDecimal createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
    }

    public LocalDateTime getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(LocalDateTime createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    public String getDifferent() {
        return different;
    }

    public void setDifferent(String different) {
        this.different = different;
    }
}
