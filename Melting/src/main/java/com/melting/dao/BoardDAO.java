package com.melting.dao;

import org.apache.ibatis.annotations.Mapper;

import com.melting.domain.Board;

@Mapper
public interface BoardDAO {

	public int insertBoard(Board board);

}
