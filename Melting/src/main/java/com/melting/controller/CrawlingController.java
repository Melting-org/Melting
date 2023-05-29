package com.melting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.melting.domain.Crawling;
import com.melting.service.CrawlingService;

@Controller
public class CrawlingController {
	
	@Autowired
	CrawlingService crawlingService;
	
	@GetMapping("/crawling")
	public String crawling(Model model) throws Exception {
		List<Crawling> newList = crawlingService.getCrawlingDatas();
		model.addAttribute("crawling", newList);
		return "/crawling";
	}

}
