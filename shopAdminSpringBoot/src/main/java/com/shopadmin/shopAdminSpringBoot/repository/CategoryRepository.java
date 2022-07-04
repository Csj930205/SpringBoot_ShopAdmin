package com.shopadmin.shopAdminSpringBoot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shopadmin.shopAdminSpringBoot.vo.CategoryVo;

public interface CategoryRepository extends CrudRepository<CategoryVo, Integer>{
	public List<CategoryVo> findAll();
}
