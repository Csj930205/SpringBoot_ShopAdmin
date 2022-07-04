package com.shopadmin.shopAdminSpringBoot.repository;

import org.springframework.data.repository.CrudRepository;

import com.shopadmin.shopAdminSpringBoot.vo.MemberVo;

public interface LoginRepository extends CrudRepository<MemberVo, String>{
	public MemberVo findByIdAndPw(String id, String pw);
}
