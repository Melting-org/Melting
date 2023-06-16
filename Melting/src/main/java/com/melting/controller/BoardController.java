package com.melting.controller;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.melting.domain.Board;
import com.melting.domain.Crawling;
import com.melting.domain.Member;
import com.melting.domain.Reply;
import com.melting.service.BoardService;
import com.melting.service.CrawlingService;
import com.melting.service.MemberService;
import com.melting.service.ReplyService;
import com.melting.util.FileService;
import com.melting.util.MarkdownConverter;

@Controller
public class BoardController{
	private final CrawlingService crawlingService;
	private final ReplyService replyService;
	private final MemberService memberService;
	
	@Autowired
	private BoardService boardService;
	
	public BoardController(CrawlingService crawlingService, ReplyService replyService, MemberService memberService) {
        this.crawlingService = crawlingService;
        this.replyService = replyService;
        this.memberService = memberService;
    }
	
	@Value("${spring.servlet.multipart.location}")
	String uploadPath;
	
	@GetMapping({"/", ""})
	public String main(Model model, Authentication authentication) throws IOException {
		
		// 유저이름 불러오기 (membername)
		if (authentication != null) {
			String username = authentication.getName();
			Member member = memberService.getMemberUsername(username);
			String membername = member.getMembername();
			model.addAttribute("membername", membername);
		}
		
//		// DB 데이터 가져오기
//		List<Crawling> list = crawlingService.getCrawlingList();
//		model.addAttribute("list", list);
//		
		// 조회순으로 정렬
		List<Crawling> viewscntSortedList = crawlingService.getViewscntSortedList();
		model.addAttribute("viewscntSortedList", viewscntSortedList);
//		System.out.println(viewscntSortedList);
//		
//		// 추천순으로 정렬
//		List<Crawling> likecntSortedList = crawlingService.getLikecntSortedList();
//		model.addAttribute("likecntSortedList", likecntSortedList);
//
//		// 댓글순으로 정렬
//		List<Crawling> replycntSortedList = crawlingService.getReplycntSortedList();
//		model.addAttribute("replycntSortedList", replycntSortedList);
		
		
		// 크롤링 List
        List<Crawling> dcSearchList = crawlingService.getDcSearchCrawlingData();
        List<Crawling> hitList = crawlingService.getHitCrawlingData();

        model.addAttribute("dcSearchList", dcSearchList);
        model.addAttribute("hitList", hitList);
        
        
        
        
		return "/main";
	}
	
	/*게시글 쓰기 화면 요청*/
	@GetMapping("/write")
	public String write(Model model, Member member, Authentication authentication) {
		
		// 유저이름 불러오기 (membername)
		if (authentication != null) {
			String username = authentication.getName();
			member = memberService.getMemberUsername(username);
			String membername = member.getMembername();
			model.addAttribute("membername", membername);
		}
		
		model.addAttribute("member", member);
		return "/board/write";
	}
	
	/*게시글 저장 요청*/
	@PostMapping("/write")
	public String write(Board board, @RequestParam("boardtxt") String boardtxt, MultipartFile upload) {
		
		// 마크다운 적용
		String markdownContent = boardtxt;
        String htmlContent = MarkdownConverter.convertMarkdownToHtml(markdownContent);
        board.setContent(htmlContent);
        
        // 파일 업로드
		String originalFilename= null;
		String savedFileName = null;
		
		if(upload != null && !upload.isEmpty()) {
		
			System.out.println(upload.isEmpty()+ "," + upload.getSize());
		
			originalFilename = upload.getOriginalFilename();
			savedFileName=FileService.savedFile(upload, uploadPath);
			
	        // 파일이 성공적으로 저장되었을 경우에만 파일명을 Board에 세팅
	        if (savedFileName != null) {
	            board.setOriginalfile(originalFilename);
	            board.setSavedfile(savedFileName);
	        }
	        
		}
		
		int result = boardService.write(board);
		
		return "redirect:/board/newlist";
		
	}
	
	/*게시글 목록 화면 요청*/
	@GetMapping("/board/newlist")
	public String boardlist(String memberid, Model model, Authentication authentication) {
		List<Board> list = boardService.getAllList(memberid);
		model.addAttribute("list", list);
		model.addAttribute("memberid", memberid);
		
		// 유저이름 불러오기 (membername)
		if (authentication != null) {
			String username = authentication.getName();
			Member member = memberService.getMemberUsername(username);
			String membername = member.getMembername();
			model.addAttribute("membername", membername);
		}
		
		// 크롤링 List
		List<Crawling> dcSearchList = crawlingService.getDcSearchCrawlingData();
		model.addAttribute("dcSearchList", dcSearchList);
		
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
	public String update(int boardseq, Model model, Authentication authentication) {
		Board board = boardService.read(boardseq);
		model.addAttribute("board", board);
		System.out.println(board);
		
		// 유저이름 불러오기 (membername)
		if (authentication != null) {
			String username = authentication.getName();
			Member member = memberService.getMemberUsername(username);
			String membername = member.getMembername();
			model.addAttribute("membername", membername);
		}
				
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
	
	/*첨부파일 다운로드*/
	@GetMapping("board/download")
	public String download(int boardseq, HttpServletResponse response) {
		Board board = boardService.read(boardseq);	// db에 접근하는 식
		
		// 원래 파일명
		String originalFileName = board.getOriginalfile();
		
		// encode에 마우스 데서 surround 뭐시기 클릭
		if (originalFileName==null) {
			originalFileName="이름이 없음요";
		}else {
			try {
				response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(originalFileName, "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				originalFileName="파일없음";
				e.printStackTrace();
				
			}
		}
		
		
		// 저장된 파일명
		String savedFileName = board.getSavedfile();
		String fullPath = uploadPath + "/" +savedFileName;
		
		// 스트림 설정(하드디스크에서 입력스트림, 클라이언트에게 전달할 출력 스트림)
		FileInputStream filein = null;
		ServletOutputStream fileout = null;
		
		try {
			filein = new FileInputStream(fullPath);
			fileout = response.getOutputStream();
			
			FileCopyUtils.copy(filein, fileout);
			
			filein.close();
			fileout.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
	}



	
	
	

}
