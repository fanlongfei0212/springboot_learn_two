package com.yinghuaicc.stars.repository.model.standard;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/9 下午8:03
 * @Description: 区间设置
 * @Modified:
 */
public class IntervalConf {

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

    //创建人
    private String createUser;

    //修改人
    private String modifyUser;

    public String getId() {
        return id;
    }

    public IntervalConf setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public IntervalConf setNum(String num) {
        this.num = num;
        return this;
    }

    public Integer getDimension() {
        return dimension;
    }

    public IntervalConf setDimension(Integer dimension) {
        this.dimension = dimension;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public IntervalConf setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public IntervalConf setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public String getBusinessSpeciesId() {
        return businessSpeciesId;
    }

    public IntervalConf setBusinessSpeciesId(String businessSpeciesId) {
        this.businessSpeciesId = businessSpeciesId;
        return this;
    }

    public Integer getYx() {
        return yx;
    }

    public IntervalConf setYx(Integer yx) {
        this.yx = yx;
        return this;
    }

    public Integer getLh() {
        return lh;
    }

    public IntervalConf setLh(Integer lh) {
        this.lh = lh;
        return this;
    }

    public Integer getTs() {
        return ts;
    }

    public IntervalConf setTs(Integer ts) {
        this.ts = ts;
        return this;
    }

    public Integer getHl() {
        return hl;
    }

    public IntervalConf setHl(Integer hl) {
        this.hl = hl;
        return this;
    }

    public Integer getKs() {
        return ks;
    }

    public IntervalConf setKs(Integer ks) {
        this.ks = ks;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public IntervalConf setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public IntervalConf setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public IntervalConf setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public IntervalConf setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
