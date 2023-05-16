package com.melting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.melting.domain.Main;

@Controller
public class IndexController {
	
	@GetMapping({"/", ""})
	public String main() {
		
		return "main";
	}

}


