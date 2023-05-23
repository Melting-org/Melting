package com.melting.dao;

import org.apache.ibatis.annotations.Mapper;

import com.melting.domain.Member;

@Mapper
public interface MemberDAO {

	public int insertMember(Member member);


}
