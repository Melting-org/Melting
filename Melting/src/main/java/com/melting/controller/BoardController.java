package com.melting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.melting.domain.Board;
import com.melting.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	// 쓰기write | 한개읽기read | 글목록list  | 글삭제delete | 글수정update |
	
	@GetMapping({"/", ""})
	public String main() {
		return "/main";
	}
	
	/*게시글 쓰기 화면 요청*/
	@GetMapping("/write")
	public String write() {
		return "/board/write";
	}
	
	/*게시글 저장 요청*/
	@PostMapping("/write")
	public String write(Board board) {
//		System.out.println(board);
		int result = boardService.write(board);
		System.out.println(result);
		return "redirect:/board/newlist";
	}
	
	/*게시글 목록 화면 요청*/
	@GetMapping("/board/newlist")
	public String boardlist(String memberid, Model model) {
		List<Board> list = boardService.getAllList(memberid);
		model.addAttribute("list", list);
		model.addAttribute("memberid", memberid);
		System.out.println(list);
		return "/board/newlist";
	}
	
	/*게시글 읽기 화면 요청*/
	@GetMapping("/read")
	public String read() {
		return "/board/read";
	}
	
	
	
	
	
	

}
