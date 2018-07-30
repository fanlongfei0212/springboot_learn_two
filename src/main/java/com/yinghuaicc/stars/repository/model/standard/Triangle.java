package com.yinghuaicc.stars.repository.model.standard;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/10 下午2:24
 * @Description: 标准三角形
 * @Modified:
 */
public class Triangle {

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
    private BigDecimal rentRatio;

    //客销度
    private BigDecimal gpDegree;

    //适配值
    private Integer adapter;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    //创建人
    private String createUser;

    //修改人
    private String modifyUser;

    public String getId() {
        return id;
    }

    public Triangle setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public Triangle setNum(String num) {
        this.num = num;
        return this;
    }

    public Integer getDimension() {
        return dimension;
    }

    public Triangle setDimension(Integer dimension) {
        this.dimension = dimension;
        return this;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public Triangle setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public String getBusinessSpeciesId() {
        return businessSpeciesId;
    }

    public Triangle setBusinessSpeciesId(String businessSpeciesId) {
        this.businessSpeciesId = businessSpeciesId;
        return this;
    }

    public BigDecimal getProbablyProfits() {
        return probablyProfits;
    }

    public Triangle setProbablyProfits(BigDecimal probablyProfits) {
        this.probablyProfits = probablyProfits;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Triangle setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public BigDecimal getRentRatio() {
        return rentRatio;
    }

    public Triangle setRentRatio(BigDecimal rentRatio) {
        this.rentRatio = rentRatio;
        return this;
    }

    public BigDecimal getGpDegree() {
        return gpDegree;
    }

    public Triangle setGpDegree(BigDecimal gpDegree) {
        this.gpDegree = gpDegree;
        return this;
    }

    public Integer getAdapter() {
        return adapter;
    }

    public Triangle setAdapter(Integer adapter) {
        this.adapter = adapter;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Triangle setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public Triangle setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Triangle setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public Triangle setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
