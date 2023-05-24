package com.melting.service;

import com.melting.domain.Member;

public interface MemberService {

	public int insertMember(Member member);

	public boolean idCheck(String memberid);

	public int idChk(Member member);


}
