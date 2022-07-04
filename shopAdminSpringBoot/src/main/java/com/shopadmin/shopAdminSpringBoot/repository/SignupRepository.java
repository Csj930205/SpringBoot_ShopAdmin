package com.shopadmin.shopAdminSpringBoot.repository;

import org.springframework.data.repository.CrudRepository;

import com.shopadmin.shopAdminSpringBoot.vo.MemberVo;

public interface SignupRepository extends CrudRepository<MemberVo, String>{
	
}
