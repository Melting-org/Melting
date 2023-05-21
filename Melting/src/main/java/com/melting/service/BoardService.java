package com.melting.service;

import java.util.List;

import com.melting.domain.Board;

public interface BoardService {

	public int write(Board board);

	public List<Board> getAllList(String memberid);


}
