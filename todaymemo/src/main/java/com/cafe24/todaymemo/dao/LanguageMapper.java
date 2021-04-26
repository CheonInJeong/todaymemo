package com.cafe24.todaymemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cafe24.todaymemo.dto.LanguageDTO;

@Mapper
public interface LanguageMapper {
	//단어 추가
	public int addLanguage(LanguageDTO languageDTO);
	//당일 단어 리스트 가져오기
	public List<LanguageDTO> getToday(@Param(value="id") String id,
									  @Param(value="categoryIdx") int idx);
	
}