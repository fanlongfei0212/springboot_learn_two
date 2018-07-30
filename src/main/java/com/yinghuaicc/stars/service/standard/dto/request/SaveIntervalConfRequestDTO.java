package com.yinghuaicc.stars.service.standard.dto.request;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/9 下午9:16
 * @Description: 添加区间
 * @Modified:
 */
public class SaveIntervalConfRequestDTO {

    //维度(1:客销度、2:溢租率、3:适配值)
    @NotNull(message = "STANDARD_SAVE_INTERVAL_CONF_001")
    private Integer dimension;

    //分类(1:项目、2:业态、3:楼层、4:品牌)
    @NotNull(message = "STANDARD_SAVE_INTERVAL_CONF_002")
    private Integer type;

    //业态id
    @NotEmpty(message = "STANDARD_SAVE_INTERVAL_CONF_003")
    private String businessFormId;

    //业种id
    @NotEmpty(message = "STANDARD_SAVE_INTERVAL_CONF_004")
    private String businessSpeciesId;

    //优秀值
    @NotNull(message = "STANDARD_SAVE_INTERVAL_CONF_005")
    private Integer yx;

    //良好
    @NotNull(message = "STANDARD_SAVE_INTERVAL_CONF_006")
    private Integer lh;

    //提升
    @NotNull(message = "STANDARD_SAVE_INTERVAL_CONF_007")
    private Integer ts;

    //合理
    @NotNull(message = "STANDARD_SAVE_INTERVAL_CONF_008")
    private Integer hl;

    //亏损
    @NotNull(message = "STANDARD_SAVE_INTERVAL_CONF_009")
    private Integer ks;

    public Integer getDimension() {
        return dimension;
    }

    public SaveIntervalConfRequestDTO setDimension(Integer dimension) {
        this.dimension = dimension;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public SaveIntervalConfRequestDTO setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public SaveIntervalConfRequestDTO setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public String getBusinessSpeciesId() {
        return businessSpeciesId;
    }

    public SaveIntervalConfRequestDTO setBusinessSpeciesId(String businessSpeciesId) {
        this.businessSpeciesId = businessSpeciesId;
        return this;
    }

    public Integer getYx() {
        return yx;
    }

    public SaveIntervalConfRequestDTO setYx(Integer yx) {
        this.yx = yx;
        return this;
    }

    public Integer getLh() {
        return lh;
    }

    public SaveIntervalConfRequestDTO setLh(Integer lh) {
        this.lh = lh;
        return this;
    }

    public Integer getTs() {
        return ts;
    }

    public SaveIntervalConfRequestDTO setTs(Integer ts) {
        this.ts = ts;
        return this;
    }

    public Integer getHl() {
        return hl;
    }

    public SaveIntervalConfRequestDTO setHl(Integer hl) {
        this.hl = hl;
        return this;
    }

    public Integer getKs() {
        return ks;
    }

    public SaveIntervalConfRequestDTO setKs(Integer ks) {
        this.ks = ks;
        return this;
    }
}
