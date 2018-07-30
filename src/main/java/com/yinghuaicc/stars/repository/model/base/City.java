package com.yinghuaicc.stars.repository.model.base;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/6/26 下午3:43
 * @Description: 城市/直辖市+省
 * @Modified:
 */
public class City {

    //id
    private String id;

    //城市编号
    private String num;

    //城市名称
    private String name;

    //修改时间
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

    public City setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public City setNum(String num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public City setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public City setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public City setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public City setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public City setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
