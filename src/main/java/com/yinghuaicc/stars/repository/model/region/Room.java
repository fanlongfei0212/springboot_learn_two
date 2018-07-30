package com.yinghuaicc.stars.repository.model.region;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/26 下午3:26
 * @Description: 铺位
 * @Modified:
 */
public class Room {

    //铺位id
    private String id;

    //编号
    private String num;

    //铺位名称
    private String name;

    //公司id
    private String companyId;

    //项目id
    private String projectId;

    //楼栋id
    private String buildingId;

    //层id
    private String floorId;

    //是否启用（1：启用，2：禁用，3：签约中）
    private Integer state;

    //面积
    private BigDecimal acreage;

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

    public Room setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public Room setNum(String num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public Room setName(String name) {
        this.name = name;
        return this;
    }

    public String getCompanyId() {
        return companyId;
    }

    public Room setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public Room setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getBuildingId() {
        return buildingId;
    }

    public Room setBuildingId(String buildingId) {
        this.buildingId = buildingId;
        return this;
    }

    public String getFloorId() {
        return floorId;
    }

    public Room setFloorId(String floorId) {
        this.floorId = floorId;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public Room setState(Integer state) {
        this.state = state;
        return this;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public Room setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Room setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public Room setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Room setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public Room setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
