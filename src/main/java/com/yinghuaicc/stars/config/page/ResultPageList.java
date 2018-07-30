package com.yinghuaicc.stars.config.page;

import java.util.List;

/**
 * @Author:Fly
 * @Date:Create in 2018/7/3 下午5:23
 * @Description: 集合分页
 * @Modified:
 */
public class ResultPageList<T>{

    //页码
    private Integer page = 1;

    //每页数量
    private Integer size = 10;

    //总条数
    private long countSize;

    //总页数
    private Integer countPage;

    //结果
    private List<T> resultList;

    public Integer getPage() {
        return page;
    }

    public ResultPageList<T> setPage(Integer page) {
        this.page = page;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public ResultPageList<T> setSize(Integer size) {
        this.size = size;
        return this;
    }

    public long getCountSize() {
        return countSize;
    }

    public ResultPageList<T> setCountSize(long countSize) {
        this.countSize = countSize;
        return this;
    }

    public Integer getCountPage() {
        return countPage;
    }

    public ResultPageList<T> setCountPage(Integer countPage) {
        this.countPage = countPage;
        return this;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public ResultPageList<T> setResultList(List<T> resultList) {
        this.resultList = resultList;
        return this;
    }
}
