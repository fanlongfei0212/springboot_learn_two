package com.yinghuaicc.stars.service.cqrs.triangle.dto.response;

import java.math.BigDecimal;

/**
 * 查询所有区域下客流量、销售额
 */
public class AllSalePassengerFlowResponseDTO {

    private String areaName;
    private BigDecimal passengerFlow;
    private BigDecimal saleroom;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public BigDecimal getPassengerFlow() {
        return passengerFlow;
    }

    public void setPassengerFlow(BigDecimal passengerFlow) {
        this.passengerFlow = passengerFlow;
    }

    public BigDecimal getSaleroom() {
        return saleroom;
    }

    public void setSaleroom(BigDecimal saleroom) {
        this.saleroom = saleroom;
    }
}
