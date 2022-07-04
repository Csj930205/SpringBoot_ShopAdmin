package com.shopadmin.shopAdminSpringBoot.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopadmin.shopAdminSpringBoot.repository.SignupRepository;
import com.shopadmin.shopAdminSpringBoot.vo.MemberVo;

@Controller
@RequestMapping("/signup")
public class SignupController {
	@Autowired
	SignupRepository sr;
	
	@GetMapping("signup.do")
	public String signup() {
		return "/signup/signup";
	}
	@PostMapping("signup.do")
	public String signup(MemberVo memVo, HttpSession session) {
		boolean insert=false;
		try {
			Optional<MemberVo> memOption=sr.findById(memVo.getId());
			if(memOption.isEmpty()) {
				MemberVo memInsert=sr.save(memVo);
				if(memInsert!=null) {
					insert=true;
				}else {
					session.setAttribute("msg", "이미 존재하는 아이디 입니다.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.setAttribute("msg", "Email 또는 Phone이 이미 존재합니다.");
		}
		if(insert) {
			return "redirect:/";			
		}else {
			return "redirect:/signup/signup";
		}
	}
}
