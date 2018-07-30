package com.yinghuaicc.stars.service.base.dto.response;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/9 下午12:36
 * @Description: 查询业态列表
 * @Modified:
 */
public class FindBusinessFormListResponseDTO {

    //id
    private String id;

    //编号
    private String num;

    //名称
    private String name;

    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    public String getId() {
        return id;
    }

    public FindBusinessFormListResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public FindBusinessFormListResponseDTO setNum(String num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public FindBusinessFormListResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public FindBusinessFormListResponseDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public FindBusinessFormListResponseDTO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }
}
