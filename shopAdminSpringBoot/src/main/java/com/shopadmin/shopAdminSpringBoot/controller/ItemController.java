package com.shopadmin.shopAdminSpringBoot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	@GetMapping("iteminsert.do")
	public String insert() {
		return "/item/iteminsert";
	}
	@PostMapping("iteminsert.do")
	public String insert(ItemVo item, HttpSession session) {
		boolean insert=true;
		ir.save(item);
		if(insert) {
			session.setAttribute("msg", "아이템 저장 성공");
			return "redirect:/item/itemlist.do";
		}else {
			session.setAttribute("msg", "아이템 저장 실패");
			return "redirect:/item/iteminsert.do";
		}
	}
}
