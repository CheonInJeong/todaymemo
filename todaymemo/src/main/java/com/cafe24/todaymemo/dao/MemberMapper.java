package com.cafe24.todaymemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.todaymemo.dto.MemberDTO;

@Mapper
public interface MemberMapper {
	//회원정보 가져오기
	public MemberDTO getMember(String memberId);
	//회원리스트 가져오기
	public List<MemberDTO> getMemberList();
	//회원가입
	public int signUp(MemberDTO memberDTO);
}
