package com.cafe24.todaymemo.controller;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.cafe24.todaymemo.common.KakaoProfile;
import com.cafe24.todaymemo.common.KakaoToken;
import com.cafe24.todaymemo.dto.MemberDTO;
import com.cafe24.todaymemo.service.MemberService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class MemberController {

	private final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@GetMapping(value="/member/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	
	@GetMapping("/kakaoLogin")
	public String kakaoLogin(String code, HttpSession session) {
		System.out.println("코드:"+code);
		String clientId = "5e99e08729091418bc20869069cfe597"; //rest api 인증키
		//post 방식으로 key=value데이터를 요청(카카오쪽으로)
		
		RestTemplate rt = new RestTemplate();
		
		//HttpHeader 오브젝트생성
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		//HttpBody 오브젝트 생성
		MultiValueMap<String,String> params = new LinkedMultiValueMap<>();
		params.add("grant_type", "authorization_code");
		params.add("client_id", clientId);
		params.add("redirect_uri", "http://localhost:8090/kakaoLogin");
		params.add("code", code);
		//HttpHeader 와 HttpBody 를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String,String>> kakaoRequest = new HttpEntity<>(params,headers);
		//Http 요청하기 post 방식으로 그리고 response 변수의 응답을 받음
		ResponseEntity<String> response = rt.exchange(
				"https://kauth.kakao.com/oauth/token", 
				 HttpMethod.POST,
				 kakaoRequest,
				 String.class);
		KakaoToken kakaoToken = null;
		//json 파싱
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			 kakaoToken = objectMapper.readValue(response.getBody(), KakaoToken.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println("카카오 엑세스 토큰"+kakaoToken.getAccess_token());
		
		////
		RestTemplate rt2 = new RestTemplate();
		
		//HttpHeader 오브젝트생성
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", "Bearer "+kakaoToken.getAccess_token());
		headers2.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		//HttpHeader 와 HttpBody 를 하나의 오브젝트에 담기
		HttpEntity<MultiValueMap<String,String>> kakaoProfileRequest = new HttpEntity<>(headers2);
		//Http 요청하기 post 방식으로 그리고 response 변수의 응답을 받음
		ResponseEntity<String> response2 = rt2.exchange(
				"https://kapi.kakao.com/v2/user/me", 
				 HttpMethod.POST,
				 kakaoProfileRequest,
				 String.class);
		
		ObjectMapper objectMapper2 = new ObjectMapper();
		KakaoProfile kakaoProfile = null;
		
		try {
			kakaoProfile = objectMapper2.readValue(response2.getBody(),KakaoProfile.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("카카오 아이디"+kakaoProfile.getId());
		System.out.println("카카오 닉네임"+kakaoProfile.getKakao_account().getProfile().getNickname());
		System.out.println("카카오 프로필사진"+kakaoProfile.getKakao_account().getProfile().getProfile_image_url());
		
		
		MemberDTO memberDTO = new MemberDTO();
		
		String kakaoId = kakaoProfile.getId().toString();
		
		memberDTO.setMemberId(kakaoId);
		memberDTO.setMemberPw(kakaoId+"_kakaoPw");
		memberDTO.setMemberPhoto(kakaoProfile.getKakao_account().getProfile().getProfile_image_url());
		memberDTO.setMemberName(kakaoProfile.getKakao_account().getProfile().getNickname());
		
		if(memberService.getMember(kakaoId)==null) {
			memberService.signUp(memberDTO);
		}else {
			memberService.login(memberDTO.getMemberId(), memberDTO.getMemberPw(), session);
		}
		return "index";
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
