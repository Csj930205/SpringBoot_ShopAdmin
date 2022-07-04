package com.shopadmin.shopAdminSpringBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopadmin.shopAdminSpringBoot.repository.ItemRepository;
import com.shopadmin.shopAdminSpringBoot.vo.ItemVo;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemRepository ir;
	@GetMapping("itemlist.do")
	public String list(Model model) {
		Iterable<ItemVo> itemList=ir.findAllByOrderByPostTimeDesc();
		model.addAttribute("itemList",itemList);
		return "/item/itemlist";
	}
}
