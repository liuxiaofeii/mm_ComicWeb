package com.mm.util;

import com.github.pagehelper.Page;

import java.util.List;

/**
 * 分页工具
 * @param <T>
 */
public class Pager<T>{
    //分页大小
    private int size;
    //起始页
    private int start;
    //总页数
    private long total;
    //每页数据
    private List<T> datas;

    public Pager(List<T> datas) {
        if(datas instanceof Page){
            Page<T> page=(Page<T>) datas;
            setStart(page.getPageNum());
            setSize(page.getPageSize());
            setTotal(page.getTotal());
            setDatas(datas);
        }
    }

    public Pager(int size, int start, long total, List<T> datas) {
        this.size = size;
        this.start = start;
        this.total = total;
        this.datas = datas;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }

    @Override
    public String toString() {
        return "Pager{" +
                "size=" + size +
                ", start=" + start +
                ", total=" + total +
                ", datas=" + datas +
                '}';
    }
}
