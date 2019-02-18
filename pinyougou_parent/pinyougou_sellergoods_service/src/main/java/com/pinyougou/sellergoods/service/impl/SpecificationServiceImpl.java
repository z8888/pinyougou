package com.pinyougou.sellergoods.service.impl;
import java.util.List;
import java.util.Map;

import com.pinyougou.mapper.TbSpecificationOptionMapper;
import com.pinyougou.pojo.TbSpecificationOption;
import com.pinyougou.pojo.TbSpecificationOptionExample;
import com.pinyougou.pojogroup.Specification;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pinyougou.mapper.TbSpecificationMapper;
import com.pinyougou.pojo.TbSpecification;
import com.pinyougou.pojo.TbSpecificationExample;
import com.pinyougou.pojo.TbSpecificationExample.Criteria;
import com.pinyougou.sellergoods.service.SpecificationService;

import com.pinyougou.entity.PageResult;


/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class SpecificationServiceImpl implements SpecificationService {

	@Autowired
	private TbSpecificationMapper specificationMapper;

	@Autowired
	private TbSpecificationOptionMapper tbSpecificationOptionMapper;
	/**
	 * 查询全部
	 */
	@Override
	public List<TbSpecification> findAll() {
		return specificationMapper.selectByExample(null);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);		
		Page<TbSpecification> page=   (Page<TbSpecification>) specificationMapper.selectByExample(null);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(Specification specification) {
		specificationMapper.insert(specification.getSpecification());//插入规格
//循环插入规格选项
		for(TbSpecificationOption
				specificationOption:specification.getSpecificationOptionList()){
			specificationOption.setSpecId(specification.getSpecification().getId());//设置规格 ID
			tbSpecificationOptionMapper.insert(specificationOption);
		}

	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(Specification specification){
		//获取规格实体
		TbSpecification tbspecification = specification.getSpecification();
		specificationMapper.updateByPrimaryKey(tbspecification);

		// 删除原来规格的选项
		TbSpecificationOptionExample Example = new TbSpecificationOptionExample();
		TbSpecificationOptionExample.Criteria criteria = Example.createCriteria();
		criteria.andSpecIdEqualTo(tbspecification.getId());
		tbSpecificationOptionMapper.deleteByExample(Example);

		//获取规格选项集合
		List<TbSpecificationOption> specificationOptionList = specification.getSpecificationOptionList();
		for( TbSpecificationOption option:specificationOptionList){
			option.setSpecId(tbspecification.getId());//设置规格ID
			//option.setOptionName(tbspecification.getSpecName());//设置规格ID
			tbSpecificationOptionMapper.insert(option);//新增规格
		}
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public Specification findOne(Long id){

		Specification specification = new Specification();

		// 获取规格实体
		TbSpecification tbSpecification = specificationMapper.selectByPrimaryKey(id);
		specification.setSpecification(tbSpecification);

		// 获取规格选项列表
		TbSpecificationOptionExample eample=new TbSpecificationOptionExample();
		TbSpecificationOptionExample.Criteria criteria = eample.createCriteria();
		criteria.andSpecIdEqualTo(id);
		List<TbSpecificationOption> tbSpecificationOptions = tbSpecificationOptionMapper.selectByExample(eample);
		specification.setSpecificationOptionList(tbSpecificationOptions);
		return specification;
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Long[] ids) {
		for(Long id:ids){
			specificationMapper.deleteByPrimaryKey(id);

			//删除原有的规格选项
			TbSpecificationOptionExample example=new TbSpecificationOptionExample();
			com.pinyougou.pojo.TbSpecificationOptionExample.Criteria criteria =
					example.createCriteria();
			criteria.andSpecIdEqualTo(id);//指定规格 ID 为条件
			tbSpecificationOptionMapper.deleteByExample(example);//删除
		}		
	}
	
	
		@Override
	public PageResult findPage(TbSpecification specification, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbSpecificationExample example=new TbSpecificationExample();
		Criteria criteria = example.createCriteria();
		
		if(specification!=null){			
						if(specification.getSpecName()!=null && specification.getSpecName().length()>0){
				criteria.andSpecNameLike("%"+specification.getSpecName()+"%");
			}
	
		}
		
		Page<TbSpecification> page= (Page<TbSpecification>)specificationMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}

	@Override
	public List<Map> selectOptionList() {
		return specificationMapper.selectOptionList();
	}
}
