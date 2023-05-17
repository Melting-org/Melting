package com.melting.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.melting.domain.Board;
import com.melting.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	// 쓰기write | 한개읽기read | 글목록list  
	
	/*게시글 쓰기 화면 요청*/
	@GetMapping("/write")
	public String write() {
		return "/board/write";
	}
	
	/*게시글 저장 요청*/
	@PostMapping("/write")
	public String write(Board board) {
		System.out.println(board);
		int result = boardService.write(board);
		System.out.println(result);
		return "redirect:/";
	}
	
	
	
	
	

}
