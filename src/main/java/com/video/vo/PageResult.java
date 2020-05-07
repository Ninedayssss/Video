package com.video.vo;

import lombok.Data;

import java.util.List;

/**
 * @author itsNine
 * @create 2019-06-19-11:18
 */
@Data
public class PageResult<T> {

    private  Long total;
    private Integer totalPage;
    private List<T> items;

    public PageResult() {
    }

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public PageResult(Long total, Integer totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }
}
