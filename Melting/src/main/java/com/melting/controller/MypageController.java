package com.melting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.melting.domain.Board;
import com.melting.domain.Member;
import com.melting.domain.Reply;
import com.melting.service.MemberService;
import com.melting.service.MypageService;

@Controller
public class MypageController {
	
	@Autowired
	MypageService mypageService;
	
	private MemberService memberService;

	public MypageController(MemberService memberService) {
		this.memberService = memberService;
	}
	
	
	/*마이페이지 화면 요청*/
	@GetMapping("/mypage")
	public String mypage(Authentication authentication, Model model) {
		
		// 유저이름 불러오기 (membername)
		if (authentication != null) {
			String username = authentication.getName();
			Member member = memberService.getMemberUsername(username);
			String membername = member.getMembername();
			model.addAttribute("membername", membername);
		}
		
		return "/mypage/mypage";
	}
	
	/*내가 쓴 글 확인하기*/
	@GetMapping("/mypage/mywrite")
	public String mywrite(String membername, Model model) {
		List<Board> list = mypageService.mywrite(membername);
		model.addAttribute("list", list);
		
		return "/mypage/mywrite";
	}
	
	/*내가 쓴 댓글 확인하기*/
	@GetMapping("/mypage/myreply")
	public String myreply(String membername, Model model) {
		List<Reply> list = mypageService.myreply(membername);
		model.addAttribute("list", list);
		System.out.println("내가 쓴 댓글 :" + list);
		
		return "/mypage/myreply";
	}

}
