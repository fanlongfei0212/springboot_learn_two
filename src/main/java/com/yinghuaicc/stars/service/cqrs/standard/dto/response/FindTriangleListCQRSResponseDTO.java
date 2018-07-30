package com.yinghuaicc.stars.service.cqrs.standard.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/10 下午3:27
 * @Description: 查询标准三角形
 * @Modified:
 */
public class FindTriangleListCQRSResponseDTO {

    //id
    private String id;

    //编号
    private String num;

    //维度(1:客销度、2:溢租率、3:适配值)
    private Integer dimension;

    //业态id
    private String businessFormName;

    //业种id
    private String businessSpeciesName;

    //毛利率
    private BigDecimal probablyProfits;

    //客单价
    private BigDecimal price;

    //溢租率
    private BigDecimal rentRatio;

    //客销度
    private BigDecimal gpDegree;

    //适配值
    private BigDecimal adapter;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    public String getId() {
        return id;
    }

    public FindTriangleListCQRSResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public FindTriangleListCQRSResponseDTO setNum(String num) {
        this.num = num;
        return this;
    }

    public Integer getDimension() {
        return dimension;
    }

    public FindTriangleListCQRSResponseDTO setDimension(Integer dimension) {
        this.dimension = dimension;
        return this;
    }

    public String getBusinessFormName() {
        return businessFormName;
    }

    public FindTriangleListCQRSResponseDTO setBusinessFormName(String businessFormName) {
        this.businessFormName = businessFormName;
        return this;
    }

    public String getBusinessSpeciesName() {
        return businessSpeciesName;
    }

    public FindTriangleListCQRSResponseDTO setBusinessSpeciesName(String businessSpeciesName) {
        this.businessSpeciesName = businessSpeciesName;
        return this;
    }

    public BigDecimal getProbablyProfits() {
        return probablyProfits;
    }

    public FindTriangleListCQRSResponseDTO setProbablyProfits(BigDecimal probablyProfits) {
        this.probablyProfits = probablyProfits;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public FindTriangleListCQRSResponseDTO setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getRentRatio() {
        return rentRatio;
    }

    public FindTriangleListCQRSResponseDTO setRentRatio(BigDecimal rentRatio) {
        this.rentRatio = rentRatio;
        return this;
    }

    public BigDecimal getGpDegree() {
        return gpDegree;
    }

    public FindTriangleListCQRSResponseDTO setGpDegree(BigDecimal gpDegree) {
        this.gpDegree = gpDegree;
        return this;
    }

    public BigDecimal getAdapter() {
        return adapter;
    }

    public FindTriangleListCQRSResponseDTO setAdapter(BigDecimal adapter) {
        this.adapter = adapter;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public FindTriangleListCQRSResponseDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public FindTriangleListCQRSResponseDTO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }
}
