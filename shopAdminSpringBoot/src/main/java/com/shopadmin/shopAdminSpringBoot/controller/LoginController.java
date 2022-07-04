package com.shopadmin.shopAdminSpringBoot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopadmin.shopAdminSpringBoot.repository.LoginRepository;
import com.shopadmin.shopAdminSpringBoot.vo.MemberVo;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	LoginRepository lr;
	@GetMapping("login.do")
	public String login() {
		return "/login/login";
	}
	@PostMapping("login.do")
	public String login(String id, String pw, HttpSession session) {
		MemberVo memVo=lr.findByIdAndPw(id, pw);
		if(memVo !=null) {
			session.setAttribute("memVo", memVo);
			return "redirect:/";
		}else {
			return "redirect:/login/login";
		}
	}
	@GetMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
