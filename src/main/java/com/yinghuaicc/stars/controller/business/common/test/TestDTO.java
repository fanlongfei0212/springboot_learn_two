package com.yinghuaicc.stars.controller.business.common.test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/15 下午3:42
 * @Description:
 * @Modified:
 */
public class TestDTO {

    private String id;

    private String name;

    private LocalDateTime projectName;

    private Integer floor;

    private String roomNum;

    private BigDecimal a;

    private BigDecimal b;

    private BigDecimal c;

    private BigDecimal d;

    public String getId() {
        return id;
    }

    public TestDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getProjectName() {
        return projectName;
    }

    public TestDTO setProjectName(LocalDateTime projectName) {
        this.projectName = projectName;
        return this;
    }

    public Integer getFloor() {
        return floor;
    }

    public TestDTO setFloor(Integer floor) {
        this.floor = floor;
        return this;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public TestDTO setRoomNum(String roomNum) {
        this.roomNum = roomNum;
        return this;
    }

    public BigDecimal getA() {
        return a;
    }

    public TestDTO setA(BigDecimal a) {
        this.a = a;
        return this;
    }

    public BigDecimal getB() {
        return b;
    }

    public TestDTO setB(BigDecimal b) {
        this.b = b;
        return this;
    }

    public BigDecimal getC() {
        return c;
    }

    public TestDTO setC(BigDecimal c) {
        this.c = c;
        return this;
    }

    public BigDecimal getD() {
        return d;
    }

    public TestDTO setD(BigDecimal d) {
        this.d = d;
        return this;
    }
}
