package com.cafe24.todaymemo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.todaymemo.dto.LanguageDTO;
import com.cafe24.todaymemo.service.LanguageService;

@Controller
public class LanguageController {
	
		private final LanguageService languageService;
		
		public LanguageController(LanguageService languageService){
			this.languageService = languageService;
		}
	
		//단어삭제
		@RequestMapping(value="/ajax/deleteLanguage", method=RequestMethod.GET)
		public @ResponseBody String deleteLanguage(@RequestParam(value="langIdx") int langIdx) {
			System.out.println("단어삭제 컨트롤러 확인");
			languageService.deleteLanguage(langIdx);
			return "단어삭제성공";
		}
		
		//단어수정
		@RequestMapping(value="/ajax/modifyLanguage", method=RequestMethod.POST)
		public @ResponseBody String modifyLanguage(@RequestParam(value="modifyWord") String modifyWord,
												   @RequestParam(value="modifyMeaning") String modifyMeaning,
												   @RequestParam(value="modifyMemo") String modifyMemo,
												   @RequestParam(value="langIdx") int langIdx) {
			System.out.println(modifyWord+"<-modifyWord");
			System.out.println(modifyMeaning+"<-modifyMeaning");
			System.out.println(modifyMemo+"<-modifyMemo");
			System.out.println(langIdx+"<-langIdx");
			
			languageService.modifyLanguage(modifyWord, modifyMeaning, modifyMemo, langIdx);
			
			
			return "성공";
		}
		
		@RequestMapping(value="/ajax/pickDate" , method= RequestMethod.POST)
		public @ResponseBody List<LanguageDTO> getPickdDateLanguageList(@RequestParam(value="categoryIdx") int categoryIdx,
																		@RequestParam(value="pickDate") String pickDate,
																		HttpSession session){
			
			return languageService.getPickDate((String)session.getAttribute("SID"), categoryIdx,pickDate);
		}
		@RequestMapping(value="/ajax/addLanguage", method= RequestMethod.POST)
		public @ResponseBody String addLanguage(@RequestParam(value="word") String word,
												@RequestParam(value="meaning") String meaning,
												@RequestParam(value="memo",required = false) String memo,
												@RequestParam(value="categoryIdx") int categoryIdx,
												HttpSession session) {
			System.out.println("컨트롤러");
			LanguageDTO languageDTO = new LanguageDTO();
			
			languageDTO.setLangWord(word);
			languageDTO.setLangMeaning(meaning);
			languageDTO.setLangEtc(memo);
			languageDTO.setCategoryIdx(categoryIdx);
			languageDTO.setLangRegId((String)session.getAttribute("SID"));
			
			languageService.addLanguage(languageDTO);
			
			return "성공";
		}
	  @GetMapping("/language/{id}/{number}") 
	  	public String getLanguageList(@PathVariable(name = "id") String id ,
	  								  @PathVariable(name ="number") String number,
	  								  @RequestParam(name="idx") int idx,
	  								  Model model) {
		  System.out.println("들어오나요?");
		  System.out.println(id+"id가 모");
		  System.out.println(number+"id가 모");
		  System.out.println(idx+"<---카테고리 인덱스");
		  
		  model.addAttribute("word",languageService.getToday(id, idx));
		  model.addAttribute("categoryIdx",idx);
		  
		  return "language/language";
		  
	  }
	 
}
