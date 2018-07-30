package com.yinghuaicc.stars.repository.model.target;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/26 下午5:33
 * @Description: 指标
 * @Modified:
 */
public class Target {

    //id
    private String id;

    //编号
    private String num;

    //指标名称
    private String name;

    //显示名称
    private String showName;

    //是否启用（true：启用，false：禁用）
    private boolean state;

    //指标分类(1:溢租率、2:客销度、3:适配值)
    private Integer targetType;

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

    public Target setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public Target setNum(String num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public Target setName(String name) {
        this.name = name;
        return this;
    }

    public String getShowName() {
        return showName;
    }

    public Target setShowName(String showName) {
        this.showName = showName;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public Target setState(boolean state) {
        this.state = state;
        return this;
    }

    public Integer getTargetType() {
        return targetType;
    }

    public Target setTargetType(Integer targetType) {
        this.targetType = targetType;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Target setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public Target setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Target setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public Target setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
