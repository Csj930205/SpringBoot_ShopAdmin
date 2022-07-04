package com.shopadmin.shopAdminSpringBoot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shopadmin.shopAdminSpringBoot.vo.MemberVo;

public interface MemberRepository extends CrudRepository<MemberVo, String>{
	public List<MemberVo> findAllByOrderBySignupTimeDesc();
}
