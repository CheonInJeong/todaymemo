package com.cafe24.todaymemo.service;

import java.util.List;


import org.springframework.stereotype.Service;

import com.cafe24.todaymemo.dao.LanguageMapper;
import com.cafe24.todaymemo.dto.LanguageDTO;

@Service
public class LanguageService {
	private final LanguageMapper languageMapper;
	public LanguageService(LanguageMapper languageMapper) {
		this.languageMapper = languageMapper;
	}
	
	public void addLanguage(LanguageDTO languageDTO) {
		languageMapper.addLanguage(languageDTO);
		
	}
	
	public List<LanguageDTO> getToday(String id, int idx){
		return languageMapper.getToday(id, idx);
	}
		
	
}
