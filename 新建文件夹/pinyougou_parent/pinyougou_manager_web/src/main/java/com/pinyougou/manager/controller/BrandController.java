package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.entity.PageResult;
import com.pinyougou.entity.Result;
import com.pinyougou.pojo.TbBrand;

import com.pinyougou.sellergoods.service.BrandService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    // 查询所有品牌
    @RequestMapping("findall")
    public List<TbBrand> findall(){
        return brandService.findAll();
    }

    // 分页
    @RequestMapping("findpage")
    public PageResult findpage(Integer page, Integer rows){

        return brandService.findPage(page,rows);
    }

    // 添加
    @RequestMapping("add")
    public Result add(@RequestBody TbBrand tbBrand){
       Result re= new Result();
        try {
            brandService.add(tbBrand);
            re.setSuccess(true);
        }catch (Exception e){
            re.setSuccess(false);
            re.setMessage("存储错误！请重试。");
        }

        return re;
    }

    // 更新
    @RequestMapping("update")
    public Result update(@RequestBody TbBrand tbBrand){
        Result re= new Result();
        try {
            brandService.update(tbBrand);
            re.setSuccess(true);
        }catch (Exception e){
            re.setSuccess(false);
            re.setMessage("存储错误！请重试。");
        }

        return re;
    }

    // 根据id查询品牌
    @RequestMapping("findOne")
    public TbBrand findOne(Long id){
        return brandService.findOne(id);
    }

    // 根据id查询品牌
    @RequestMapping("delete")
    public Result delete(Long [] ids){
        Result re= new Result();
        try {

                brandService.delete(ids);

            re.setSuccess(true);
        }catch (Exception e){
            re.setSuccess(false);
            re.setMessage("删除失败！请重试。");
        }

        return re;
    }

    // 分条件查询
    @RequestMapping("search")
    public PageResult search(@RequestBody TbBrand brand,int page,int rows){
        return brandService.findPage(brand,page,rows);
    }

    @RequestMapping("selectOptionList")
    public List<Map> selectOptionList(){
        return brandService.selectOptionList();
    }
}
