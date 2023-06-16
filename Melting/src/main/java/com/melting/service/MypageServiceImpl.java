package com.melting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.melting.dao.MypageDAO;
import com.melting.domain.Board;
import com.melting.domain.Reply;

@Service
public class MypageServiceImpl implements MypageService {
	
	@Autowired
	private MypageDAO mypageDao;

	@Override
	public List<Board> mywrite(String membername) {
		List<Board> list = mypageDao.mywrite(membername);
		return list;
	}

	@Override
	public List<Reply> myreply(String membername) {
		List<Reply> list = mypageDao.myreply(membername);
		return list;
	}

}
