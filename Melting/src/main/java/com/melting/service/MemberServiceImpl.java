package com.melting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.melting.dao.MemberDAO;
import com.melting.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO memberDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public int insertMember(Member member) {
		String encodedPassword = passwordEncoder.encode(member.getMemberpwd());
		member.setMemberpwd(encodedPassword);
		int result = memberDao.insertMember(member);
		return result;
	}

	@Override
	public Member login(String memberid) {
		Member member = memberDao.login(memberid);
		return member;
	}

}
