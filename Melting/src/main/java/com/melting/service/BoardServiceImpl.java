package com.melting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melting.dao.BoardDAO;
import com.melting.domain.Board;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO boardDao;
	
	
	@Override
	public int write(Board board) {
		int result = boardDao.insertBoard(board);
		return result;
	}


	@Override
	public List<Board> getAllList(String memberid) {
		List<Board> list = boardDao.getAllList(memberid);
		return list;
	}


	@Override
	public Board read(int boardseq) {
		Board board = boardDao.read(boardseq);
		return board;
	}


	@Override
	public int delete(int boardseq) {
		int result = boardDao.delete(boardseq);
		return result;
	}

}
