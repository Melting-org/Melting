package com.melting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melting.dao.MemberDAO;
import com.melting.domain.Member;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO memberDao;

	@Override
	public int insertMember(Member member) {
		int result = memberDao.insertMember(member);
		return result;
	}

}
