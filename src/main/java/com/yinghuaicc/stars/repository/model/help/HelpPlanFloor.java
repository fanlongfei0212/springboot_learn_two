package com.yinghuaicc.stars.repository.model.help;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/19 下午8:07
 * @Description: 楼层帮扶计划
 * @Modified:
 */
public class HelpPlanFloor {

    //id
    private String id;

    //项目id
    private String projectId;

    //楼层id
    private String floorId;

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

    public HelpPlanFloor setId(String id) {
        this.id = id;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public HelpPlanFloor setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getFloorId() {
        return floorId;
    }

    public HelpPlanFloor setFloorId(String floorId) {
        this.floorId = floorId;
        return this;
    }

    public String getYxHelpContext() {
        return yxHelpContext;
    }

    public HelpPlanFloor setYxHelpContext(String yxHelpContext) {
        this.yxHelpContext = yxHelpContext;
        return this;
    }

    public String getLhHelpContext() {
        return lhHelpContext;
    }

    public HelpPlanFloor setLhHelpContext(String lhHelpContext) {
        this.lhHelpContext = lhHelpContext;
        return this;
    }

    public String getTsHelpContext() {
        return tsHelpContext;
    }

    public HelpPlanFloor setTsHelpContext(String tsHelpContext) {
        this.tsHelpContext = tsHelpContext;
        return this;
    }

    public String getHlHelpContext() {
        return hlHelpContext;
    }

    public HelpPlanFloor setHlHelpContext(String hlHelpContext) {
        this.hlHelpContext = hlHelpContext;
        return this;
    }

    public String getKsHelpContext() {
        return ksHelpContext;
    }

    public HelpPlanFloor setKsHelpContext(String ksHelpContext) {
        this.ksHelpContext = ksHelpContext;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public HelpPlanFloor setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public HelpPlanFloor setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public HelpPlanFloor setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public HelpPlanFloor setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
