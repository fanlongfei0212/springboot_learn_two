package com.yinghuaicc.stars.repository.model.tissue;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/5 上午1:04
 * @Description: 员工项目数据权限
 * @Modified:
 */
public class EmployeeProjectData {

    //id
    private String id;

    //项目id
    private String projectId;

    //员工id
    private String employeeId;

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

    public EmployeeProjectData setId(String id) {
        this.id = id;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public EmployeeProjectData setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public EmployeeProjectData setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public EmployeeProjectData setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public EmployeeProjectData setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public EmployeeProjectData setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public EmployeeProjectData setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
