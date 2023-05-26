package com.melting.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.melting.domain.Reply;

@Mapper
public interface ReplyDAO {
	
	public int writeReply(Reply reply);

	public List<Reply> listReply(int boardseq);

	public int deleteReply(int replyseq);

}
