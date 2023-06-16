package com.melting.service;

import java.util.List;

import com.melting.domain.Board;
import com.melting.domain.Reply;

public interface MypageService {

	public List<Board> mywrite(String membername);

	public List<Reply> myreply(String membername);
	
	

}
