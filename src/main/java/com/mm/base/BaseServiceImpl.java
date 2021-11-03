package com.mm.base;



import com.github.pagehelper.PageHelper;
import com.mm.util.Pager;
import com.mm.util.SystemContext;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class BaseServiceImpl<T> implements BaseService<T>{
    /**
     * BaseDao包含了对数据库所有的操作
     */
    private BaseDao<T> baseDao;
    public abstract BaseDao<T> getBaseDao();

    @Override
    public int insert(T entiry) {
        return this.getBaseDao().insert(entiry);
    }

    @Override
    public void deleteById(Serializable id) {
        this.getBaseDao().deleteById(id);
    }

    @Override
    public void deleteByEntiry(T entiry) {
        this.getBaseDao().deleteByEntiry(entiry);
    }

    @Override
    public void update(T entiry) {
        this.getBaseDao().update(entiry);
    }

    @Override
    public void updateById(T entiry) {
        this.getBaseDao().updateById(entiry);
    }

    @Override
    public List selectByEntiry(T entiry) {
        return this.getBaseDao().selectByEntiry(entiry);
    }

    @Override
    public List listAll() {
        return this.getBaseDao().listAll();
    }

    @Override
    public List findAll() {
        return this.getBaseDao().findAll();
    }


    @Override
    public T getEntiryById(Serializable id) {
        return this.getBaseDao().getEntiryById(id);
    }

    @Override
    public List<T> load(Serializable id) {
        return this.getBaseDao().load(id);
    }



    @Override
    public List<T> getEntiryById2() {
        return this.getBaseDao().getEntiryById2();
    }


    @Override
    public List<T> getListById() {
        return this.getBaseDao().getListById();
    }

    @Override
    public T getEntiryByEntiry(T entiry) {
        return this.getBaseDao().getEntiryByEntiry(entiry);
    }

    @Override
    public Pager<T> getEntiryByEntiryPage(T entiry) {
        return null;
    }

    @Override
    public int insertBatch(List list) {
        return this.getBaseDao().insertBatch(list);
    }

    @Override
    public void updateBatch(List list) {
        this.getBaseDao().updateBatch(list);
    }

    @Override
    public Map<String, Object> getMapBySql(String sql) {
        return this.getBaseDao().getMapBySql(sql);
    }

    @Override
    public T getEntiryBySql(String sql) {
        return this.getBaseDao().getEntiryBySql(sql);
    }
    //通过执行sql返回集合
    @Override
    public List<T> getListBySql(@Param("sql")String sql){
        return this.getBaseDao().getListBySql(sql);
    };
    @Override
    public List<T> getListEntiryBySql(@Param("sql")String sql){
        return this.getBaseDao().getListEntiryBySql(sql);
    }

    @Override
    public void updateBySql(String sql) {
        this.getBaseDao().updateBySql(sql);
    }

    @Override
    public void deleteBySql(String sql) {
        this.getBaseDao().deleteBySql(sql);
    }

    //执行sql返回对象，分页
    @Override
    public Pager<T> getEntiryBySqlPage(String sql){
        /**
         * 起始页：pageOffset
         * 分页大小：pageSize
         * 当前页码：pageNum
         */

        Integer pageSize = SystemContext.getPageSize();
        Integer pageOffset = SystemContext.getPageOffset();
        if(pageOffset==null||pageOffset<0) {pageOffset = 0;}
        if(pageSize==null||pageSize<0) {pageSize = 15;}
        String order = SystemContext.getOrder();
        String sort = SystemContext.getSort();
        Integer pageNum = null;
        if(pageOffset == 0){
            pageNum = 1;
        }else{
            System.out.println("=========排查排除排错pageOffset="+pageOffset+"pageNum="+pageNum);
            pageNum = pageOffset/pageSize+1;

        }
        PageHelper.startPage(pageNum, pageSize);
//        System.out.println("通过sql获取分页对象"+this.getBaseDao().getEntiryBySqlPage(sql));
        Pager<T> pages = new Pager<T>((List<T>) this.getBaseDao().getEntiryBySqlPage(sql));
        return pages;
    }



    @Override
    public Pager<T> getEntiryByMapPage(Map<String,Object> params) {
        return  null;

    }

    @Override
    public T getEntiryByMap(Map<String,Object> params) {
        return this.getBaseDao().getEntiryByMap(params);
    }

    @Override
    public List selectByMap(Map<String,Object> params) {
        return this.getBaseDao().selectByMap(params);
    }

    @Override
    public void deleteByMap(Map<String,Object> params) {
        this.getBaseDao().deleteByMap(params);
    }
}
