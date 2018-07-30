package com.yinghuaicc.stars.repository.model.help;

import java.time.LocalDateTime;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/19 下午3:36
 * @Description: 帮扶内容
 * @Modified:
 */
public class HelpContext {

    //id
    private String id;

    //内容
    private String context;

    //类型（1：租金帮扶、2：活动支持、3：点位宣传支持、4：品牌及会员、5：其他）
    private Integer type;

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

    public HelpContext setId(String id) {
        this.id = id;
        return this;
    }

    public String getContext() {
        return context;
    }

    public HelpContext setContext(String context) {
        this.context = context;
        return this;
    }

    public Integer getType() {
        return type;
    }

    public HelpContext setType(Integer type) {
        this.type = type;
        return this;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public HelpContext setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public LocalDateTime getModifyTime() {
        return modifyTime;
    }

    public HelpContext setModifyTime(LocalDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public String getCreateUser() {
        return createUser;
    }

    public HelpContext setCreateUser(String createUser) {
        this.createUser = createUser;
        return this;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public HelpContext setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
        return this;
    }
}
