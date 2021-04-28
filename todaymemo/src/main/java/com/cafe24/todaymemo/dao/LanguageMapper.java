package com.cafe24.todaymemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cafe24.todaymemo.dto.LanguageDTO;

@Mapper
public interface LanguageMapper {
	
	//단어 삭제
	public int deleteLanguage(int langIdx);
	
	//단어 수정
	public int modifyLanguage(@Param(value="word") String word,
							  @Param(value="meaning") String meaning,
							  @Param(value="memo") String memo,
							  @Param(value="idx") int idx);
	//단어 추가
	public int addLanguage(LanguageDTO languageDTO);

	//선택한 날짜의 단어 리스트 가져오기
	public List<LanguageDTO> getPickDate(@Param(value="id") String id,
										 @Param(value="categoryIdx") int idx,
										 @Param(value="pickDate") String pickDate);
	//당일 단어 리스트 가져오기
	public List<LanguageDTO> getToday(@Param(value="id") String id,
									  @Param(value="categoryIdx") int idx);
	
}
