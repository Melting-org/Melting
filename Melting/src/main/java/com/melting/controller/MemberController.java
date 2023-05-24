package com.melting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.melting.domain.Member;
import com.melting.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	/*회원가입 화면 요청*/
	@GetMapping("/join")
	public String join() {
		return "/member/joinView";
	}
	
	/*회원가입 처리*/
	@PostMapping("/join")
	public String join(Member member) {
		int result = memberService.insertMember(member);
		return "redirect:/";
	}
	
	/*로그인 화면 요청*/
	@GetMapping("/loginForm")
	public String login() {
		return "/member/loginForm";
	}
	
	/*중복 아이디 확인*/
	@GetMapping("/idCheck")
	@ResponseBody
	public String idCheck(String memberid) {
		System.out.println("전달된 id :"+ memberid);
		boolean result = memberService.idCheck(memberid);
		
		if(result)
			return "OK";
		return "Fail";
	}
	
	/*중복 아이디 확인 - 버튼용*/
	@ResponseBody
	@GetMapping("/idChk")
	public int idChk(Member member) {
		int result = memberService.idChk(member);
		return result;
	}

}
