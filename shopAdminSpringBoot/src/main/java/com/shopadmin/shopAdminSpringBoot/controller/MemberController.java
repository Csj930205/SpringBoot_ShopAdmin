package com.shopadmin.shopAdminSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopadmin.shopAdminSpringBoot.repository.MemberRepository;
import com.shopadmin.shopAdminSpringBoot.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberRepository mr;
	@GetMapping("memberlist.do")
	public String list(Model model) {
		Iterable<MemberVo> memberList=mr.findAllByOrderBySignupTimeDesc();
		model.addAttribute("memberList",memberList);
		return "/member/memberlist";
	}
}
