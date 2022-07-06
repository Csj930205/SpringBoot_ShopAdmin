package com.shopadmin.shopAdminSpringBoot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopadmin.shopAdminSpringBoot.repository.CategoryRepository;
import com.shopadmin.shopAdminSpringBoot.vo.CategoryVo;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryRepository cr;
	
	@GetMapping("categorylist.do")
	public String list(Model model) {
		Iterable<CategoryVo> categoryList=cr.findAll();
		model.addAttribute("categoryList",categoryList);
		return "/category/categorylist";
	}
	@GetMapping("categoryinsert.do")
	public String insert() {
		return "/category/categoryinsert";
	}
	@PostMapping("categoryinsert.do")
	public String insert(CategoryVo cate, HttpSession session) {
		boolean insert=true;
		cr.save(cate);
		if(insert) {
			session.setAttribute("msg", "카테고리 등록 성공");
			return "redirect:/category/categorylist.do";
		}else {
			session.setAttribute("msg", "카테고리 등록 실패");
			return "redirect:/category/categoryinsert.do";
		}
	}
}
