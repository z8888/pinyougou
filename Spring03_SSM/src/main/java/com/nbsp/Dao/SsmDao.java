package com.nbsp.Dao;

import com.nbsp.domain.Account;
import com.nbsp.domain.Ssm;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface SsmDao {
/*
            *   @Insert:实现新增
                @Update:实现更新
                @Delete:实现删除
                @Select:实现查询
                @Result:实现结果集封装
                @Results:可以与@Result 一起使用，封装多个结果集
                @ResultMap:实现引用@Results 定义的封装
                @One:实现一对一结果集封装
                @Many:实现一对多结果集封装
                @SelectProvider: 实现动态 SQL 映射
                @CacheNamespace:实现注解二级缓存的使用
*
* */
    // 查询所有
    @Select("select * from ssm")
    @Results( id = "resultmap" ,value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name",column = "name"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "money",column = "money"),
    })
    List<Ssm> FindAll();

    // 查询单个
    @Select("select * from ssm where id=#{id}")
   // @ResultMap("resultmap")
    Ssm  FindByid(Integer id);

    // 删除用户
    @Delete("delete from ssm where id=#{id}")
   // @ResultMap("resultmap")
    void  deleteByid(Integer id);

    @Insert("")
    void insertSsm(Ssm...ssm);

    // 更新用户
    @Update("update ssm set name=#{ssm.name} ,sex=#{ssm.sex} ,money=#{ssm.money} where id=#{ssm.id}")
    void updateSsm(Ssm ssm);

    // 转账
    @Update("")
    void Transaction(String name1,String name2,Integer money);

    @Select("select * from account")
    List<Account> FindAccount();

    /*@Results(value = {
            @Result(id = true,property = "aid",column = "id"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "address",column = "address"),
            @Result(column = "aid",property = "ssm",one=@One(select = "com.nbsp.Dao.SsmDao.FindByid",fetchType = FetchType.LAZY))})*/

}
