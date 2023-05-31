package com.melting.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.melting.domain.Board;
import com.melting.domain.Crawling;
import com.melting.domain.Member;
import com.melting.domain.Reply;
import com.melting.service.BoardService;
import com.melting.service.CrawlingService;
import com.melting.service.MemberService;
import com.melting.service.ReplyService;

@Controller
public class BoardController{
	private final CrawlingService crawlingService;
	private final ReplyService replyService;
	private final MemberService memberService;
	
	@Autowired
	BoardService boardService;
	
	public BoardController(CrawlingService crawlingService, ReplyService replyService, MemberService memberService) {
        this.crawlingService = crawlingService;
        this.replyService = replyService;
        this.memberService = memberService;
    }
	
	@GetMapping({"/", ""})
	public String main(Model model, Authentication authentication) {
		
		// 유저이름 불러오기 (membername)
		if (authentication != null) {
			String username = authentication.getName();
			Member member = memberService.getMemberUsername(username);
			String membername = member.getMembername();
			model.addAttribute("membername", membername);
		}
		
		// 크롤링 List
		List<Crawling> dcInsideDataList = crawlingService.getDcInsideCrawlingData();
        List<Crawling> fmKoreaDataList = crawlingService.getFmKoreaCrawlingData();
        List<Crawling> ppomppuDataList = crawlingService.getPpomppuCrawlingData();

        model.addAttribute("dcInsideDataList", dcInsideDataList);
        model.addAttribute("fmKoreaDataList", fmKoreaDataList);
        model.addAttribute("ppomppuDataList",ppomppuDataList);
        
		return "/main";
	}
	
	/*게시글 쓰기 화면 요청*/
	@GetMapping("/write")
	public String write(Model model, Member member) {
		model.addAttribute("member", member);
		return "/board/write";
	}
	
	/*게시글 저장 요청*/
	@PostMapping("/write")
	public String write(Board board) {
		int result = boardService.write(board);
		return "redirect:/board/newlist";
	}
	
	/*게시글 목록 화면 요청*/
	@GetMapping("/board/newlist")
	public String boardlist(String memberid, Model model) {
		List<Board> list = boardService.getAllList(memberid);
		model.addAttribute("list", list);
		model.addAttribute("memberid", memberid);
		return "/board/newlist";
	}
	
	/*게시글 읽기 화면 요청*/
	@GetMapping("/read")
	public String read(int boardseq, Model model, Authentication authentication) {
		Board board = boardService.read(boardseq);
		boardService.updateViewsCount(boardseq);
		model.addAttribute("board", board);
		
		// 댓글 목록 출력
		List<Reply> replylist = replyService.listReply(boardseq);
		model.addAttribute("replylist", replylist);
		
		// 유저이름 불러오기 (membername)
		if (authentication != null) {
			String username = authentication.getName();
			Member member = memberService.getMemberUsername(username);
			String membername = member.getMembername();
			model.addAttribute("membername", membername);
		}
		
		return "/board/read";
		
	}
	
	/*게시글 삭제*/
	@GetMapping("/delete")
	public String delete(int boardseq) {
		int result = boardService.delete(boardseq);
		return "redirect:/board/newlist";
	}
	
	/*게시글 수정 화면 요청*/
	@GetMapping("/update")
	public String update(int boardseq, Model model) {
		Board board = boardService.read(boardseq);
		model.addAttribute("board", board);
		System.out.println(board);
		return "/board/update";
	}
	
	
	/*게시글 수정 처리*/
	@PostMapping("/update")
	public String update(Board board, RedirectAttributes rttr) {
		int result = boardService.update(board);
		System.out.println(result);
		rttr.addAttribute("boardseq", board.getBoardseq());
		System.out.println("board 글 수정됨");
		return "redirect:/board/newlist";
	}



	
	
	

}
