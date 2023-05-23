package com.melting.service;

import java.util.List;

import com.melting.domain.Board;
import com.melting.domain.Member;

public interface BoardService {

	public int write(Board board);

	public List<Board> getAllList(String memberid);

	public Board read(int boardseq);

	public int delete(int boardseq);

	public int update(Board board);
	
	public int updateViewsCount(int boardseq);




}
