package com.yinghuaicc.stars.service.cqrs.standard.dto.response;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/9 下午9:53
 * @Description: 查询区间设置DTO
 * @Modified:
 */
public class FindIntervalListCQRSResponseDTO {

    //id
    private String id;

    //编号
    private String num;

    //维度(1:客销度、2:溢租率、3:适配值)
    private Integer dimension;

    //分类(1:项目、2:业态、3:楼层、4:品牌)
    private Integer type;

    //业态名称
    private String businessFormName;

    //业种名称
    private String businessSpeciesName;

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

    public FindIntervalListCQRSResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public FindIntervalListCQRSResponseDTO setNum(String num) {
        this.num = num;
        return this;
    }

    public Integer getDimension() {
        return dimension;
    }

    public FindIntervalListCQRSResponseDTO setDimension(Integer dimension) {
        this.dimension = dimension;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public FindIntervalListCQRSResponseDTO setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getBusinessFormName() {
        return businessFormName;
    }

    public FindIntervalListCQRSResponseDTO setBusinessFormName(String businessFormName) {
        this.businessFormName = businessFormName;
        return this;
    }

    public String getBusinessSpeciesName() {
        return businessSpeciesName;
    }

    public FindIntervalListCQRSResponseDTO setBusinessSpeciesName(String businessSpeciesName) {
        this.businessSpeciesName = businessSpeciesName;
        return this;
    }

    public Integer getYx() {
        return yx;
    }

    public FindIntervalListCQRSResponseDTO setYx(Integer yx) {
        this.yx = yx;
        return this;
    }

    public Integer getLh() {
        return lh;
    }

    public FindIntervalListCQRSResponseDTO setLh(Integer lh) {
        this.lh = lh;
        return this;
    }

    public Integer getTs() {
        return ts;
    }

    public FindIntervalListCQRSResponseDTO setTs(Integer ts) {
        this.ts = ts;
        return this;
    }

    public Integer getHl() {
        return hl;
    }

    public FindIntervalListCQRSResponseDTO setHl(Integer hl) {
        this.hl = hl;
        return this;
    }

    public Integer getKs() {
        return ks;
    }

    public FindIntervalListCQRSResponseDTO setKs(Integer ks) {
        this.ks = ks;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public FindIntervalListCQRSResponseDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public FindIntervalListCQRSResponseDTO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }
}
