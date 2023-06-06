package com.melting.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.melting.domain.Board;
import com.melting.domain.Member;

@Mapper
public interface BoardDAO {

	public int insertBoard(Board board);

	public List<Board> getAllList(String memberid);

	public Board read(int boardseq);

	public int delete(int boardseq);

	public int update(Board board);

	public int updateViewsCount(int boardseq);
	
}
