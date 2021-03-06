package com.cafe24.todaymemo.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.StringPBEConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cafe24.todaymemo.dao.MemberMapper;
import com.cafe24.todaymemo.api.KakaoLoginApi;
import com.cafe24.todaymemo.dao.CategoryMapper;
import com.cafe24.todaymemo.dto.MemberDTO;


@Service
@Transactional
public class MemberService {

	private final MemberMapper memberMapper;
	private final CategoryMapper menuMapper;
	private final StringEncryptor stringEncrytor;
	
	
	public MemberService(MemberMapper memberMapper,
						 CategoryMapper menuMapper,
						 @Qualifier("jasyptStringEncryptor") StringEncryptor stringEncrytor) {
		this.memberMapper = memberMapper;
		
		this.menuMapper = menuMapper;
		this.stringEncrytor = stringEncrytor;
	}
	

	
	public MemberDTO getMember(String memberId) {
		return memberMapper.getMember(memberId);
		
	}
	
	
	public boolean login(String memberId, String memberPw,HttpSession session) {
		boolean loginCheck = false;
		List<MemberDTO> memberList = memberMapper.getMemberList();
	
		for(int i = 0; i<memberList.size(); i++) {
			MemberDTO member = memberList.get(i);
			if(member.getMemberId().equals(memberId)) {
				System.out.println("아이디 존재, 암호화된 비밀번호 : "+memberList.get(i).getMemberPw());
				
				StandardPBEStringEncryptor stringPBEConfig = new StandardPBEStringEncryptor();
				stringPBEConfig.setPassword("ksmart38");		   //대칭키 (암호화 키) 설정
				stringPBEConfig.setAlgorithm("PBEWithMD5AndDES");  //사용할 암호화  알고리즘
				String decryptPassword = stringPBEConfig.decrypt(memberList.get(i).getMemberPw());
				System.out.println("아이디 존재, 복호화된 비밀번호 : "+decryptPassword);

				if(memberPw.equals(decryptPassword)) {
					session.setAttribute("SID", memberId);
					session.setAttribute("SLEVEL",member.getMemberLevel());
					session.setAttribute("SNAME", member.getMemberName());
					session.setAttribute("SPHOTO", member.getMemberPhoto());
					
					System.out.println(menuMapper.getCategoryList(memberId)+"<----메뉴리스트");
					
					session.setAttribute("SMENU",menuMapper.getCategoryList(memberId));
					loginCheck = true;
				}
			}
		}
		return loginCheck;

	}
	public void signUp(MemberDTO memberDTO) {
		
		String encryptPassword = stringEncrytor.encrypt(memberDTO.getMemberPw());
		System.out.println(encryptPassword);
		memberDTO.setMemberPw(encryptPassword);
		memberMapper.signUp(memberDTO);

	}
}
