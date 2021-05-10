package com.cafe24.todaymemo.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.cafe24.todaymemo.dao.CategoryMapper;
import com.cafe24.todaymemo.dto.CategoryDTO;

@Service
public class CategoryService {

	private final CategoryMapper categoryMapper;
	
	public CategoryService(CategoryMapper categoryMapper) {
		this.categoryMapper = categoryMapper;
	}
	//카테고리 삭제
	public void deleteCategory(int categoryIdx,HttpSession session) {
		categoryMapper.deleteCategory(categoryIdx);
		categoryMapper.deleteCategoryWord(categoryIdx);
		session.setAttribute("SMENU", getMenuList((String)session.getAttribute("SID")));
	}
	
	//카테고리추가
	public void addCategory(CategoryDTO categoryDTO, HttpSession session) {
		System.out.println(categoryDTO);
		categoryMapper.addCategory(categoryDTO);
		session.setAttribute("SMENU", getMenuList((String)session.getAttribute("SID")));
		
		
		
	}
	//해당아이디 카테고리 가져오기
	public List<CategoryDTO> getMenuList(String loginId){
		return categoryMapper.getCategoryList(loginId);
	}
	
}
