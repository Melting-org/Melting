package com.melting.service;

import java.util.List;

import com.melting.domain.Reply;

public interface ReplyService {

	public int writeReply(Reply reply);

	public List<Reply> listReply(int boardseq);

	public int deleteReply(int replyseq);

}
