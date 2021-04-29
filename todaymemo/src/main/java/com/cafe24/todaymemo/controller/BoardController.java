package com.cafe24.todaymemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@GetMapping("/board/write")
	public String write() {
		return "board/write";
	}
	@GetMapping("/board")
	public String board() {
		return "board/main";
	}
}
