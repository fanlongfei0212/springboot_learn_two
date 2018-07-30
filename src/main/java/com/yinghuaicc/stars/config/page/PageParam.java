package com.yinghuaicc.stars.config.page;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/3 下午8:19
 * @Description: 分页参数
 * @Modified:
 */
public class PageParam {

    private Integer p = 1;

    private Integer c = 10;

    public Integer getP() {
        return p;
    }

    public PageParam setP(Integer p) {
        this.p = p;
        return this;
    }

    public Integer getC() {
        return c;
    }

    public PageParam setC(Integer c) {
        this.c = c;
        return this;
    }
}
