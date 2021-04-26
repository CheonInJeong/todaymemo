package com.cafe24.todaymemo.dao;

import java.util.List;

import com.cafe24.todaymemo.dto.CategoryDTO;

public interface CategoryMapper {

	public int addCategory(CategoryDTO categoryDTO);
	public List<CategoryDTO> getCategoryList(String id);
}
