package com.mm.base;

import com.mm.domain.Manager;
import com.mm.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 基本的数据库操作
 */
public interface BaseService<T> {
    /**
     * 增删改查
     */
    //插入一个对象，返回值是int
    int insert(T entiry);

    /******删除******/
    //通过id删除
    void deleteById(Serializable id);

    //通过实体类删除
    void deleteByEntiry(T entiry);

    //通过map删除
    void deleteByMap(Map<String,Object> params);

    /******修改******/
    //通过实体类修改
    void update(T entiry);

    //通过id进行修改
    void updateById(T entiry);

    /******查询******/
    //根据参数查询
    List<T> selectByMap(Map<String,Object> params);

    //根据实体查询
    List<T> selectByEntiry(T entiry);

    //列出所有
    List<T> listAll();

    List<T> findAll();

    /******查询******/
    //根据主键获取实体
    T getEntiryById(Serializable id);

    List<T> load(Serializable id);

    List<T> getEntiryById2();

    List<T> getListById();

    //根据map获取实体--不分页
    T getEntiryByMap(Map<String,Object> params);

    //根据实体获取实体--不分页
    T getEntiryByEntiry(T entiry);

    //根据map获取实体--分页
    Pager<T> getEntiryByMapPage(Map<String,Object> params);

    //根据实体获取实体--分页
    Pager<T> getEntiryByEntiryPage(T entiry);

    /******批量******/
    //批量增加
    int insertBatch(List<T> list);

    //批量修改
    void updateBatch(List<T> list);

    /******通过sql******/
    //通过执行sql返回map
    Map<String,Object> getMapBySql(@Param("sql")String sql);

    //通过执行sql返回Entiry
    T getEntiryBySql(@Param("sql")String sql);

    //通过执行sql返回集合
    List<T> getListBySql(@Param("sql")String sql);

    List<T> getListEntiryBySql(@Param("sql")String sql);

    //执行sql返回对象，分页
    Pager<T> getEntiryBySqlPage(@Param("sql")String sql);

    //通过sql修改
    void updateBySql(@Param("sql")String sql);

    //通过sql删除
    void deleteBySql(@Param("sql")String sql);







}
