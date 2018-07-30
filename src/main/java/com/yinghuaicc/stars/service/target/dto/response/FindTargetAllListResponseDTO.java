package com.yinghuaicc.stars.service.target.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/7 下午2:40
 * @Description: 分页查询所有指标
 * @Modified:
 */
public class FindTargetAllListResponseDTO {

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

    public String getId() {
        return id;
    }

    public FindTargetAllListResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getNum() {
        return num;
    }

    public FindTargetAllListResponseDTO setNum(String num) {
        this.num = num;
        return this;
    }

    public String getName() {
        return name;
    }

    public FindTargetAllListResponseDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getShowName() {
        return showName;
    }

    public FindTargetAllListResponseDTO setShowName(String showName) {
        this.showName = showName;
        return this;
    }

    public boolean isState() {
        return state;
    }

    public FindTargetAllListResponseDTO setState(boolean state) {
        this.state = state;
        return this;
    }

    public Integer getTargetType() {
        return targetType;
    }

    public FindTargetAllListResponseDTO setTargetType(Integer targetType) {
        this.targetType = targetType;
        return this;
    }
}
