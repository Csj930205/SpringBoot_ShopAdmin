package com.shopadmin.shopAdminSpringBoot.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopadmin.shopAdminSpringBoot.repository.MemberRepository;
import com.shopadmin.shopAdminSpringBoot.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberController {
	@Autowired
	MemberRepository mr;
	@GetMapping("/admin/memberlist.do")
	public String list(Model model) {
		Iterable<MemberVo> memberList=mr.findAllByOrderBySignupTimeDesc();
		model.addAttribute("memberList",memberList);
		return "/member/memberlist";
	}
	@GetMapping("/admin/membermodify/{id}")
	public String update(@PathVariable("id") String id, Model model) {
		Optional<MemberVo> memVo=mr.findById(id);
		model.addAttribute("memVo",memVo);
		return "/member/membermodify";
	}
	@PostMapping("/admin/memberUpdate.do")
	public String update(MemberVo memVo, HttpSession session) {
		boolean update=false;
		Optional<MemberVo> memOption=mr.findById(memVo.getId());
		if(!(memOption.isEmpty())) {
			mr.save(memVo);
			update=true;
			session.setAttribute("msg", "수정 성공");
		}else {
			session.setAttribute("msg", "수정 실패");
		}
		if(update) {
			return "redirect:/";
		}else {
			return "redirect:/admin/membermodify/{id}";
		}
	}
	
}
