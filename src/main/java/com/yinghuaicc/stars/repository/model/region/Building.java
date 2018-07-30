package com.yinghuaicc.stars.repository.model.region;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/26 下午3:18
 * @Description: 楼栋
 * @Modified:
 */
public class Building {

    //楼栋id
    private String id;

    //编号
    private String num;

    //公司id
    private String companyId;

    //项目id
    private String projectId;

    //楼栋名称
    private String name;

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

    public Building setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public Building setNum(String num) {
        this.num = num;
        return this;
    }

    public String getCompanyId() {
        return companyId;
    }

    public Building setCompanyId(String companyId) {
        this.companyId = companyId;
        return this;
    }

    public String getProjectId() {
        return projectId;
    }

    public Building setProjectId(String projectId) {
        this.projectId = projectId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Building setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Building setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public Building setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Building setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public Building setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
