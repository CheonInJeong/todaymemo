package com.cafe24.todaymemo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cafe24.todaymemo.dto.MemberDTO;
import com.cafe24.todaymemo.service.MemberService;

@Controller
public class MemberController {

	private final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@PostMapping(value="/member/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/ajax/login", method= RequestMethod.POST)
	public @ResponseBody boolean login(@RequestParam(value="memberId") String memberId,
									  @RequestParam(value="memberPw") String memberPw,
									  HttpSession session) {
		boolean loginCheck = false;
		
		if(memberService.login(memberId, memberPw,session)) {
			loginCheck = true;
		};
		
		return loginCheck;
	}
	
	//로그인 화면
	@GetMapping("/member/login")
	public String login() {
		return "/member/login";
	}
	
	@PostMapping("/member/signUp")
	public String signUp(MemberDTO memberDTO) {
		System.out.println(memberDTO);
		memberService.signUp(memberDTO);
		return "redirect:/";
	}
	@GetMapping("/member/signUp")
	public String signUp() {
		System.out.println("/member/signUp 확인");
		return "member/signUp";
	}
}
