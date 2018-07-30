package com.yinghuaicc.stars.service.cqrs.triangle.dto.response;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 品牌三角形返回值
 */
public class BrandTriangleResponseDTO {

    //品牌名称

    //动态三角形溢租率
    private BigDecimal triangleRent;
    //动态三角形适配值
    private BigDecimal triangleFitted;
    //动态三角形客销度
    private BigDecimal triangleGuest;
    //标准三角形溢租率
    private BigDecimal standardRent;
    //标准三角形适配值
    private BigDecimal StandardFitted;
    //标准三角形客销度
    private BigDecimal StandardGuest;
    //区间设置溢租率
    private Map<String ,Integer> intervalRent;
    //区间设置适配值
    private Map<String ,Integer> intervalFitted;
    //区间设置客销度
    private Map<String ,Integer> intervalGuest;
    //帮扶计划客销度
    private String guestContent;
    //帮扶计划溢租率
    private String rentContent;
    //帮扶计划适配值
    private String fittedContent;

    public BigDecimal getTriangleRent() {
        return triangleRent;
    }

    public void setTriangleRent(BigDecimal triangleRent) {
        this.triangleRent = triangleRent;
    }

    public BigDecimal getTriangleFitted() {
        return triangleFitted;
    }

    public void setTriangleFitted(BigDecimal triangleFitted) {
        this.triangleFitted = triangleFitted;
    }

    public BigDecimal getTriangleGuest() {
        return triangleGuest;
    }

    public void setTriangleGuest(BigDecimal triangleGuest) {
        this.triangleGuest = triangleGuest;
    }

    public BigDecimal getStandardRent() {
        return standardRent;
    }

    public void setStandardRent(BigDecimal standardRent) {
        this.standardRent = standardRent;
    }

    public BigDecimal getStandardFitted() {
        return StandardFitted;
    }

    public void setStandardFitted(BigDecimal standardFitted) {
        StandardFitted = standardFitted;
    }

    public BigDecimal getStandardGuest() {
        return StandardGuest;
    }

    public void setStandardGuest(BigDecimal standardGuest) {
        StandardGuest = standardGuest;
    }

    public Map<String, Integer> getIntervalRent() {
        return intervalRent;
    }

    public void setIntervalRent(Map<String, Integer> intervalRent) {
        this.intervalRent = intervalRent;
    }

    public Map<String, Integer> getIntervalFitted() {
        return intervalFitted;
    }

    public void setIntervalFitted(Map<String, Integer> intervalFitted) {
        this.intervalFitted = intervalFitted;
    }

    public Map<String, Integer> getIntervalGuest() {
        return intervalGuest;
    }

    public void setIntervalGuest(Map<String, Integer> intervalGuest) {
        this.intervalGuest = intervalGuest;
    }

    public String getGuestContent() {
        return guestContent;
    }

    public void setGuestContent(String guestContent) {
        this.guestContent = guestContent;
    }

    public String getRentContent() {
        return rentContent;
    }

    public void setRentContent(String rentContent) {
        this.rentContent = rentContent;
    }

    public String getFittedContent() {
        return fittedContent;
    }

    public void setFittedContent(String fittedContent) {
        this.fittedContent = fittedContent;
    }
}
