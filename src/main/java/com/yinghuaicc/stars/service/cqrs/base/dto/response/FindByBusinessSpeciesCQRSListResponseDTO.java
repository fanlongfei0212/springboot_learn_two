package com.yinghuaicc.stars.service.cqrs.base.dto.response;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/9 下午12:17
 * @Description: 业种
 * @Modified:
 */
public class FindByBusinessSpeciesCQRSListResponseDTO {

    //业种id
    private String id;

    //编号
    private String num;

    //业态名称
    private String businessFormName;

    //业种名称
    private String name;

    //修改时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime modifyTime;

    public String getId() {
        return id;
    }

    public FindByBusinessSpeciesCQRSListResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public FindByBusinessSpeciesCQRSListResponseDTO setNum(String num) {
        this.num = num;
        return this;
    }

    public String getBusinessFormName() {
        return businessFormName;
    }

    public FindByBusinessSpeciesCQRSListResponseDTO setBusinessFormName(String businessFormName) {
        this.businessFormName = businessFormName;
        return this;
    }

    public String getName() {
        return name;
    }

    public FindByBusinessSpeciesCQRSListResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public FindByBusinessSpeciesCQRSListResponseDTO setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public FindByBusinessSpeciesCQRSListResponseDTO setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }
}
