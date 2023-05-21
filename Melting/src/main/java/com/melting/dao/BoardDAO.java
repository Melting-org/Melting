package com.melting.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.melting.domain.Board;

@Mapper
public interface BoardDAO {

	public int insertBoard(Board board);

	public List<Board> getAllList(String memberid);

	public Board read(int boardseq);

	public int delete(int boardseq);

}
