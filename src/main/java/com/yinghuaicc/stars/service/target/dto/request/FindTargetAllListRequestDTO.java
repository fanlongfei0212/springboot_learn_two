package com.yinghuaicc.stars.service.target.dto.request;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/7 下午2:34
 * @Description: 查询所有指标
 * @Modified:
 */
public class FindTargetAllListRequestDTO {

    //编号
    private String num = "";

    //指标名称
    private String name = "";

    //显示名称
    private String showName = "";

    //是否启用（true：启用，false：禁用）
    private boolean state;

    //指标分类(1:溢租率、2:客销度、3:适配值)
    private Integer targetType;

    public String getNum() {
        return num;
    }

    public FindTargetAllListRequestDTO setNum(String num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public FindTargetAllListRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getShowName() {
        return showName;
    }

    public FindTargetAllListRequestDTO setShowName(String showName) {
        this.showName = showName;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public FindTargetAllListRequestDTO setState(boolean state) {
        this.state = state;
        return this;
    }

    public Integer getTargetType() {
        return targetType;
    }

    public FindTargetAllListRequestDTO setTargetType(Integer targetType) {
        this.targetType = targetType;
        return this;
    }
}
