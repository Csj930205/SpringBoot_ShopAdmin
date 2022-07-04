package com.shopadmin.shopAdminSpringBoot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shopadmin.shopAdminSpringBoot.vo.ItemVo;

public interface ItemRepository extends CrudRepository<ItemVo, Integer>{
	public List<ItemVo> findAllByOrderByPostTimeDesc();
}
