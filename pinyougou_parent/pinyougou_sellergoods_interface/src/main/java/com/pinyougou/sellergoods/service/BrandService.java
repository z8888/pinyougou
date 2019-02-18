package com.pinyougou.sellergoods.service;

import com.pinyougou.entity.PageResult;
import com.pinyougou.pojo.TbBrand;


import java.util.List;
import java.util.Map;

/*
品牌信息
* */
public interface BrandService {
    // 查询所有品牌信息
    List<TbBrand> findAll();

    //返回分页列表
    PageResult findPage(Integer pageNum, Integer pagesize);

    // 增加品牌
    void add(TbBrand tbBrand);

    // 根据id查询
    TbBrand findOne(Long id);

    // 修改
    void  update(TbBrand tbBrand);

    // 删除品牌
    void delete(Long [] ids);

    // 按条件查询
    PageResult findPage(TbBrand tbBrand,int pageNum, int pagesize);

    List<Map> selectOptionList();

}
