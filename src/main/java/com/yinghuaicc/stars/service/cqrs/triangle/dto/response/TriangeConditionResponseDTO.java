package com.yinghuaicc.stars.service.cqrs.triangle.dto.response;

/**
 * 通过项目id、楼层id查询业态list--返回结果
 */
public class TriangeConditionResponseDTO {

    private String conditionId;
    private String conditionName;

    public String getConditionId() {
        return conditionId;
    }

    public void setConditionId(String conditionId) {
        this.conditionId = conditionId;
    }

    public String getConditionName() {
        return conditionName;
    }

    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }
}
