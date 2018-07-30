package com.yinghuaicc.stars.service.standard.dto.request;

import java.math.BigDecimal;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/10 下午3:37
 * @Description: 编辑标准三角形
 * @Modified:
 */
public class EditTriangleRequestDTO {

    //id
    private String id;

    //维度(1:客销度、2:溢租率、3:适配值)
    private Integer dimension;

    //业态id
    private String businessFormId;

    //业种id
    private String businessSpeciesId;

    //毛利率
    private BigDecimal probablyProfits;

    //客单价
    private BigDecimal price;

    //溢租率
    private BigDecimal rentRatio;

    //适配值
    private BigDecimal adapter;

    public String getId() {
        return id;
    }

    public EditTriangleRequestDTO setId(String id) {
        this.id = id;
        return this;
    }

    public Integer getDimension() {
        return dimension;
    }

    public EditTriangleRequestDTO setDimension(Integer dimension) {
        this.dimension = dimension;
        return this;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public EditTriangleRequestDTO setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public String getBusinessSpeciesId() {
        return businessSpeciesId;
    }

    public EditTriangleRequestDTO setBusinessSpeciesId(String businessSpeciesId) {
        this.businessSpeciesId = businessSpeciesId;
        return this;
    }

    public BigDecimal getProbablyProfits() {
        return probablyProfits;
    }

    public EditTriangleRequestDTO setProbablyProfits(BigDecimal probablyProfits) {
        this.probablyProfits = probablyProfits;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public EditTriangleRequestDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getRentRatio() {
        return rentRatio;
    }

    public EditTriangleRequestDTO setRentRatio(BigDecimal rentRatio) {
        this.rentRatio = rentRatio;
        return this;
    }

    public BigDecimal getAdapter() {
        return adapter;
    }

    public EditTriangleRequestDTO setAdapter(BigDecimal adapter) {
        this.adapter = adapter;
        return this;
    }
}
