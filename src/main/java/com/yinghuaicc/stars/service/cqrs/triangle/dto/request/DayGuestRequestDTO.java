package com.yinghuaicc.stars.service.cqrs.triangle.dto.request;

/**
 * 每日客销度参数类
 */
public class DayGuestRequestDTO {
    //客销度版本id
    private String guestVerssionId;

    public String getGuestVerssionId() {
        return guestVerssionId;
    }

    public void setGuestVerssionId(String guestVerssionId) {
        this.guestVerssionId = guestVerssionId;
    }
}
