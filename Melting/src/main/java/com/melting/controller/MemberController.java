package com.melting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.melting.domain.Member;
import com.melting.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	/*회원가입 화면 요청*/
	@GetMapping("/join")
	public String join() {
		return "/member/join";
	}
	
	/*회원가입 처리*/
	@PostMapping("/join")
	public String join(Member member) {
		int result = memberService.insertMember(member);
		System.out.println(result);
		return "redirect:/";
	}
	
	/*로그인 화면 요청*/
	@GetMapping("/login")
	public String login() {
		return "/member/login";
	}
	
	/*로그인 처리*/
	@PostMapping("/login")
	public String login(String memberid, Model model) {
		Member member = memberService.login(memberid);
		model.addAttribute("member", member);
		System.out.println(member);
		return "redirect:/";
	}

}
