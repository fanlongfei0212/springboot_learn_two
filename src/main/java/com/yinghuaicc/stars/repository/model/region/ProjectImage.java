package com.yinghuaicc.stars.repository.model.region;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/4 下午1:12
 * @Description: 项目图片
 * @Modified:
 */
public class ProjectImage {

    //id
    private String id;

    //项目id
    private String projectId;

    //项目地址
    private String url;

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

    public ProjectImage setId(String id) {
        this.id = id;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public ProjectImage setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ProjectImage setUrl(String url) {
        this.url = url;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public ProjectImage setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public ProjectImage setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public ProjectImage setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public ProjectImage setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
