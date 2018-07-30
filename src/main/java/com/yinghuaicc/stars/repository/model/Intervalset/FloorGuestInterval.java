package com.yinghuaicc.stars.repository.model.Intervalset;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 区间设置-楼层客销度
 */
public class FloorGuestInterval {

    //id
    private String id ;
    //签约id
    private String  contractId;
    //项目id
    private String projectId;
    //项目名称
    private String  projectName;
    //楼层id
    private String floorId;
    //楼层名称
    private String  floorName;
    //区间最大值
    private BigDecimal maxvalue;
    //区间增长百分比
    private BigDecimal intervalRate;
    //优秀
    private Integer yx;
    //良好
    private Integer lh;
    //提升
    private Integer ts;
    //合格
    private Integer hl;
    //亏损
    private Integer ks;
    private LocalDateTime createTime;
    private LocalDateTime modifyTime;
    private String createUser;
    private String modifyUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getFloorId() {
        return floorId;
    }

    public void setFloorId(String floorId) {
        this.floorId = floorId;
    }

    public String getFloorName() {
        return floorName;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public BigDecimal getMaxvalue() {
        return maxvalue;
    }

    public void setMaxvalue(BigDecimal maxvalue) {
        this.maxvalue = maxvalue;
    }

    public BigDecimal getIntervalRate() {
        return intervalRate;
    }

    public void setIntervalRate(BigDecimal intervalRate) {
        this.intervalRate = intervalRate;
    }

    public Integer getYx() {
        return yx;
    }

    public void setYx(Integer yx) {
        this.yx = yx;
    }

    public Integer getLh() {
        return lh;
    }

    public void setLh(Integer lh) {
        this.lh = lh;
    }

    public Integer getTs() {
        return ts;
    }

    public void setTs(Integer ts) {
        this.ts = ts;
    }

    public Integer getHl() {
        return hl;
    }

    public void setHl(Integer hl) {
        this.hl = hl;
    }

    public Integer getKs() {
        return ks;
    }

    public void setKs(Integer ks) {
        this.ks = ks;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }
}
