package com.melting.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.melting.domain.Board;
import com.melting.domain.Reply;

@Mapper
public interface MypageDAO {

	public List<Board> mywrite(String membername);

	public List<Reply> myreply(String membername);

}
