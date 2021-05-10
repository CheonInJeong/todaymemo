package com.cafe24.todaymemo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.todaymemo.dto.CategoryDTO;
import com.cafe24.todaymemo.service.CategoryService;

@Controller
public class CommonController {

	private final CategoryService categoryService;
	
	public CommonController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	
	@RequestMapping(value="/ajax/deleteCategory", method=RequestMethod.POST)
	public @ResponseBody String deleteCategory(@RequestParam(value="checkArray[]",required=false) int[] checkArray
											   ,HttpSession session) {
		
		System.out.println(checkArray+"<---controller checkArray");
		if(checkArray!=null) {
			for(int categoryIdx : checkArray) {
				System.out.println(categoryIdx+"<----categoryidx");
				categoryService.deleteCategory(categoryIdx,session);
			}
		}
		
		
		
		return "success";
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
