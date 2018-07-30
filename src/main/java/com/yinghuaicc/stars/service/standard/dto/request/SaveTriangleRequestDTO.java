package com.yinghuaicc.stars.service.standard.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/10 下午3:35
 * @Description: 添加标准三角形
 * @Modified:
 */
public class SaveTriangleRequestDTO {

    //维度(1:客销度、2:溢租率、3:适配值)
    @NotNull(message = "STANDARD_SAVE_TRIANGLE_001")
    private Integer dimension;

    //业态id
    @NotEmpty(message = "STANDARD_SAVE_TRIANGLE_002")
    private String businessFormId;

    //业种id
    @NotEmpty(message = "STANDARD_SAVE_TRIANGLE_003")
    private String businessSpeciesId;

    //毛利率
    @NotNull(message = "STANDARD_SAVE_TRIANGLE_004")
    private BigDecimal probablyProfits;

    //客单价
    @NotNull(message = "STANDARD_SAVE_TRIANGLE_005")
    private BigDecimal price;

    //溢租率
    @NotNull(message = "STANDARD_SAVE_TRIANGLE_006")
    private BigDecimal rentRatio;

    //适配值
    @NotNull(message = "STANDARD_SAVE_TRIANGLE_007")
    private BigDecimal adapter;

    public Integer getDimension() {
        return dimension;
    }

    public SaveTriangleRequestDTO setDimension(Integer dimension) {
        this.dimension = dimension;
        return this;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public SaveTriangleRequestDTO setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public String getBusinessSpeciesId() {
        return businessSpeciesId;
    }

    public SaveTriangleRequestDTO setBusinessSpeciesId(String businessSpeciesId) {
        this.businessSpeciesId = businessSpeciesId;
        return this;
    }

    public BigDecimal getProbablyProfits() {
        return probablyProfits;
    }

    public SaveTriangleRequestDTO setProbablyProfits(BigDecimal probablyProfits) {
        this.probablyProfits = probablyProfits;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public SaveTriangleRequestDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getRentRatio() {
        return rentRatio;
    }

    public SaveTriangleRequestDTO setRentRatio(BigDecimal rentRatio) {
        this.rentRatio = rentRatio;
        return this;
    }

    public BigDecimal getAdapter() {
        return adapter;
    }

    public SaveTriangleRequestDTO setAdapter(BigDecimal adapter) {
        this.adapter = adapter;
        return this;
    }
}
