package com.yinghuaicc.stars.repository.model.tissue;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/4 上午12:38
 * @Description: 项目负责人组员
 * @Modified:
 */
public class EmployeeProjectRelationTeam {

    //id
    private String id;

    //员工id
    private String employeeId;

    //项目id
    private String projectId;

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

    public EmployeeProjectRelationTeam setId(String id) {
        this.id = id;
        return this;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public EmployeeProjectRelationTeam setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public EmployeeProjectRelationTeam setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public EmployeeProjectRelationTeam setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public EmployeeProjectRelationTeam setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public EmployeeProjectRelationTeam setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public EmployeeProjectRelationTeam setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
