package com.shopadmin.shopAdminSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
