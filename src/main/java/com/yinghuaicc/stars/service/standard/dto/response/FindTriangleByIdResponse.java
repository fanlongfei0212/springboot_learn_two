package com.yinghuaicc.stars.service.standard.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/10 下午3:46
 * @Description: 标准三角形详情
 * @Modified:
 */
public class FindTriangleByIdResponse {

    //id
    private String id;

    //编号
    private String num;

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
    private Integer rentRatio;

    //客销度
    private Integer gpDegree;

    //适配值
    private Integer adapter;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    public String getId() {
        return id;
    }

    public FindTriangleByIdResponse setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public FindTriangleByIdResponse setNum(String num) {
        this.num = num;
        return this;
    }

    public Integer getDimension() {
        return dimension;
    }

    public FindTriangleByIdResponse setDimension(Integer dimension) {
        this.dimension = dimension;
        return this;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public FindTriangleByIdResponse setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public String getBusinessSpeciesId() {
        return businessSpeciesId;
    }

    public FindTriangleByIdResponse setBusinessSpeciesId(String businessSpeciesId) {
        this.businessSpeciesId = businessSpeciesId;
        return this;
    }

    public BigDecimal getProbablyProfits() {
        return probablyProfits;
    }

    public FindTriangleByIdResponse setProbablyProfits(BigDecimal probablyProfits) {
        this.probablyProfits = probablyProfits;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public FindTriangleByIdResponse setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Integer getRentRatio() {
        return rentRatio;
    }

    public FindTriangleByIdResponse setRentRatio(Integer rentRatio) {
        this.rentRatio = rentRatio;
        return this;
    }

    public Integer getGpDegree() {
        return gpDegree;
    }

    public FindTriangleByIdResponse setGpDegree(Integer gpDegree) {
        this.gpDegree = gpDegree;
        return this;
    }

    public Integer getAdapter() {
        return adapter;
    }

    public FindTriangleByIdResponse setAdapter(Integer adapter) {
        this.adapter = adapter;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public FindTriangleByIdResponse setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public FindTriangleByIdResponse setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }
}
