package com.yinghuaicc.stars.service.help.dto.response;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/19 下午4:15
 * @Description: 查询帮扶内容列表
 * @Modified:
 */
public class FindHelpContextListResponseDTO {

    //id
    private String id;

    //内容
    private String context;

    //类型（1：租金帮扶、2：活动支持、3：点位宣传支持、4：品牌及会员、5：其他）
    private Integer type;

    public String getId() {
        return id;
    }

    public FindHelpContextListResponseDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getContext() {
        return context;
    }

    public FindHelpContextListResponseDTO setContext(String context) {
        this.context = context;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public FindHelpContextListResponseDTO setType(Integer type) {
        this.type = type;
        return this;
    }
}
