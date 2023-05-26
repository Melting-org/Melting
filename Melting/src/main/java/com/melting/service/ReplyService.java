package com.melting.service;

import java.util.List;

import com.melting.domain.Reply;

public interface ReplyService {

	int writeReply(Reply reply);

	List<Reply> listReply(int boardseq);

	int deleteReply(int replyseq);

}
