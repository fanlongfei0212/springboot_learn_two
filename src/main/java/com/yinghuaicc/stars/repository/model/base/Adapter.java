package com.yinghuaicc.stars.repository.model.base;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/26 下午6:56
 * @Description: 适配值
 * @Modified:
 */
public class Adapter {

    //id
    private String id;

    //编号
    private String num;

    //名称
    private String name;

    //最大值
    private BigDecimal max;

    //分类（0：适配值，1：配合度）
    private Integer state;

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

    public Adapter setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public Adapter setNum(String num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public Adapter setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getMax() {
        return max;
    }

    public Adapter setMax(BigDecimal max) {
        this.max = max;
        return this;
    }

    public Integer getState() {
        return state;
    }

    public Adapter setState(Integer state) {
        this.state = state;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Adapter setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public Adapter setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public Adapter setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public Adapter setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}