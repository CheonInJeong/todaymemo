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
	//단어 삭제
	public void deleteLanguage(int langIdx) {
		languageMapper.deleteLanguage(langIdx);
	}
	
	//단어 수정
	public void modifyLanguage(String word, String meaning, String memo, int idx) {
		languageMapper.modifyLanguage(word, meaning, memo, idx);
	}
	
	//단어 추가
	public void addLanguage(LanguageDTO languageDTO) {
		languageMapper.addLanguage(languageDTO);
		
	}
	//선택 날짜의 단어 가져오기
	public List<LanguageDTO> getPickDate(String id, int idx, String pickdate){
		return languageMapper.getPickDate(id, idx, pickdate);
	}
	//당일 날짜의 단어 가져오기 
	public List<LanguageDTO> getToday(String id, int idx){
		return languageMapper.getToday(id, idx);
	}
		
	
}
