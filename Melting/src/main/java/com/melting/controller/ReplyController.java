package com.melting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.melting.domain.Reply;
import com.melting.service.ReplyService;

@Controller
public class ReplyController {
	@Autowired
	ReplyService replyService;
	
	@PostMapping("reply/replywrite")
	@ResponseBody
	public String replyWrite(Reply reply, @AuthenticationPrincipal UserDetails user) {
		System.out.println(reply);
		reply.setMemberid(user.getUsername()); // 로그인 후 수정
		
		int result = replyService.writeReply(reply);
		if(result == 1) {
			return "OK";	
		}
		return "Fail";
	}
	
	@GetMapping("/reply/replylist")
	@ResponseBody
	public List<Reply> replylist(int boardseq) {
		List<Reply> replylist = replyService.listReply(boardseq);
		
		return replylist;
	}
	
	
	@GetMapping("/reply/replydelete")
	@ResponseBody
	public String replydelete(int replyseq) {
		int result = replyService.deleteReply(replyseq);
		
		if(result == 1) {
			return "OK";
		}
		return "Fail";
	}

}
