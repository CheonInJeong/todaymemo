package com.cafe24.todaymemo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cafe24.todaymemo.dto.CategoryDTO;
import com.cafe24.todaymemo.service.CategoryService;

@Controller
public class CommonController {

	private final CategoryService categoryService;
	
	public CommonController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@PostMapping("/language/addCategory")
	public String addCategory(CategoryDTO categoryDTO,HttpSession session) {
		categoryService.addCategory(categoryDTO,session);
		return "redirect:/";
	}
	
	@GetMapping("/language/addCategory")
	public String addCategory() {
		return "/language/addCategory";
	}
	@GetMapping("/")
	public String index() {
		
		return "index";
	}
	
}
