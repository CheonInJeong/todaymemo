package com.cafe24.todaymemo.dao;

import java.util.List;

import com.cafe24.todaymemo.dto.CategoryDTO;

public interface CategoryMapper {
	//삭제된 카테고리에 저장된 단어 삭제
	public int deleteCategoryWord(int categoryIdx);
	//카테고리 삭제
	public int deleteCategory(int categoryIdx);
	//카테고리 추가
	public int addCategory(CategoryDTO categoryDTO);
	//해당 아이디의 카테고리 가져오기
	public List<CategoryDTO> getCategoryList(String id);
}