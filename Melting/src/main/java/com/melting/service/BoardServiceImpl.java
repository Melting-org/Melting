package com.melting.service;

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

}
