package com.yinghuaicc.stars.repository.model.region;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/26 下午3:16
 * @Description: 项目
 * @Modified:
 */
public class Project {

    //项目id/编号
    private String id;

    //编号
    private String num;

    //区域id
    private String areaId;

    //城市公司id
    private String companyId;

    //项目名称
    private String name;

    //是否启用（true：启用，false：禁用）
    private boolean state;

    //项目负责人id
    private String projectHeadId;

    //项目运营人id
    private String projectAuditId;

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

    public Project setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public Project setNum(String num) {
        this.num = num;
        return this;
    }

    public String getAreaId() {
        return areaId;
    }

    public Project setAreaId(String areaId) {
        this.areaId = areaId;
        return this;
    }

    public String getCompanyId() {
        return companyId;
    }

    public Project setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Project setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public Project setState(boolean state) {
        this.state = state;
        return this;
    }

    public String getProjectHeadId() {
        return projectHeadId;
    }

    public Project setProjectHeadId(String projectHeadId) {
        this.projectHeadId = projectHeadId;
        return this;
    }

    public String getProjectAuditId() {
        return projectAuditId;
    }

    public Project setProjectAuditId(String projectAuditId) {
        this.projectAuditId = projectAuditId;
        return this;
    }

    public BigDecimal getAcreage() {
        return acreage;
    }

    public Project setAcreage(BigDecimal acreage) {
        this.acreage = acreage;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Project setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public Project setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Project setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public Project setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
