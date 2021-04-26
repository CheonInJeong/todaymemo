package com.cafe24.todaymemo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cafe24.todaymemo.dto.MemberDTO;

@Mapper
public interface MemberMapper {

	public List<MemberDTO> getMemberInfo();
	public int signUp(MemberDTO memberDTO);
}
