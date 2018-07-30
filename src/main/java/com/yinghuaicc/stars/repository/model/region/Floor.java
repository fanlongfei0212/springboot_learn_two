package com.yinghuaicc.stars.repository.model.region;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/26 下午3:22
 * @Description: 层
 * @Modified:
 */
public class Floor {

    //层id
    private String id;

    //编号
    private String num;

    //公司id
    private String companyId;

    //项目id
    private String projectId;

    //楼栋id
    private String buildingId;

    //层名称
    private String name;

    //（1：地上，2：地下）
    private Integer location;

    //面积
    private BigDecimal acreage;

    //状态（true：启用，false：禁用）
    private boolean state;

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

    public Floor setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public Floor setNum(String num) {
        this.num = num;
        return this;
    }

    public String getCompanyId() {
        return companyId;
    }

    public Floor setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public Floor setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public Floor setBuildingId(String buildingId) {
        this.buildingId = buildingId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Floor setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getLocation() {
        return location;
    }

    public Floor setLocation(Integer location) {
        this.location = location;
        return this;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public Floor setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public Floor setState(boolean state) {
        this.state = state;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Floor setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public Floor setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Floor setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public Floor setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
