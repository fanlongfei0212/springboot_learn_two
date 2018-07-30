package com.yinghuaicc.stars.service.standard.dto.response;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/9 下午11:28
 * @Description: 区间设置详情
 * @Modified:
 */
public class FindIntervalByIdResponse {

    //id
    private String id;

    //编号
    private String num;

    //维度(1:客销度、2:溢租率、3:适配值)
    private Integer dimension;

    //分类(1:项目、2:业态、3:楼层、4:品牌)
    private Integer type;

    //业态id
    private String businessFormId;

    //业种id
    private String businessSpeciesId;

    //优秀值
    private Integer yx;

    //良好
    private Integer lh;

    //提升
    private Integer ts;

    //合理
    private Integer hl;

    //亏损
    private Integer ks;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    public String getId() {
        return id;
    }

    public FindIntervalByIdResponse setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public FindIntervalByIdResponse setNum(String num) {
        this.num = num;
        return this;
    }

    public Integer getDimension() {
        return dimension;
    }

    public FindIntervalByIdResponse setDimension(Integer dimension) {
        this.dimension = dimension;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public FindIntervalByIdResponse setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public FindIntervalByIdResponse setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public String getBusinessSpeciesId() {
        return businessSpeciesId;
    }

    public FindIntervalByIdResponse setBusinessSpeciesId(String businessSpeciesId) {
        this.businessSpeciesId = businessSpeciesId;
        return this;
    }

    public Integer getYx() {
        return yx;
    }

    public FindIntervalByIdResponse setYx(Integer yx) {
        this.yx = yx;
        return this;
    }

    public Integer getLh() {
        return lh;
    }

    public FindIntervalByIdResponse setLh(Integer lh) {
        this.lh = lh;
        return this;
    }

    public Integer getTs() {
        return ts;
    }

    public FindIntervalByIdResponse setTs(Integer ts) {
        this.ts = ts;
        return this;
    }

    public Integer getHl() {
        return hl;
    }

    public FindIntervalByIdResponse setHl(Integer hl) {
        this.hl = hl;
        return this;
    }

    public Integer getKs() {
        return ks;
    }

    public FindIntervalByIdResponse setKs(Integer ks) {
        this.ks = ks;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public FindIntervalByIdResponse setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public FindIntervalByIdResponse setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }
}
