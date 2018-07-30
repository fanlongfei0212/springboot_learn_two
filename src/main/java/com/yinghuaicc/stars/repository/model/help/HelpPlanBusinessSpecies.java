package com.yinghuaicc.stars.repository.model.help;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/19 下午8:07
 * @Description: 业种帮扶计划
 * @Modified:
 */
public class HelpPlanBusinessSpecies {

    //id
    private String id;

    //项目id
    private String projectId;

    //业态id
    private String businessFormId;

    //业种id
    private String businessSpeciesId;

    //优秀帮扶内容
    private String yxHelpContext;

    //良好帮扶内容
    private String lhHelpContext;

    //提升帮扶内容
    private String tsHelpContext;

    //合理帮扶内容
    private String hlHelpContext;

    //亏损帮扶内容
    private String ksHelpContext;

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

    public HelpPlanBusinessSpecies setId(String id) {
        this.id = id;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public HelpPlanBusinessSpecies setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getBusinessFormId() {
        return businessFormId;
    }

    public HelpPlanBusinessSpecies setBusinessFormId(String businessFormId) {
        this.businessFormId = businessFormId;
        return this;
    }

    public String getBusinessSpeciesId() {
        return businessSpeciesId;
    }

    public HelpPlanBusinessSpecies setBusinessSpeciesId(String businessSpeciesId) {
        this.businessSpeciesId = businessSpeciesId;
        return this;
    }

    public String getYxHelpContext() {
        return yxHelpContext;
    }

    public HelpPlanBusinessSpecies setYxHelpContext(String yxHelpContext) {
        this.yxHelpContext = yxHelpContext;
        return this;
    }

    public String getLhHelpContext() {
        return lhHelpContext;
    }

    public HelpPlanBusinessSpecies setLhHelpContext(String lhHelpContext) {
        this.lhHelpContext = lhHelpContext;
        return this;
    }

    public String getTsHelpContext() {
        return tsHelpContext;
    }

    public HelpPlanBusinessSpecies setTsHelpContext(String tsHelpContext) {
        this.tsHelpContext = tsHelpContext;
        return this;
    }

    public String getHlHelpContext() {
        return hlHelpContext;
    }

    public HelpPlanBusinessSpecies setHlHelpContext(String hlHelpContext) {
        this.hlHelpContext = hlHelpContext;
        return this;
    }

    public String getKsHelpContext() {
        return ksHelpContext;
    }

    public HelpPlanBusinessSpecies setKsHelpContext(String ksHelpContext) {
        this.ksHelpContext = ksHelpContext;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public HelpPlanBusinessSpecies setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public HelpPlanBusinessSpecies setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public HelpPlanBusinessSpecies setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public HelpPlanBusinessSpecies setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
