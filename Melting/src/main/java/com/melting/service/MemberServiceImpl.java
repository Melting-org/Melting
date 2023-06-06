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
	public boolean idCheck(String memberid) {
		String result = memberDao.idCheck(memberid);
		if(result == null)
			return true;
		return false;
	}

	@Override
	public int idChk(Member member) {
		int result = memberDao.idChk(member);
		return result;
	}

	@Override
	public boolean nameCheck(String membername) {
		String result = memberDao.nameCheck(membername);
		if(result == null)
			return true;
		return false;
	}

	@Override
	public Member getMemberUsername(String username) {
		return memberDao.getMemberByUsername(username);
	}




}
