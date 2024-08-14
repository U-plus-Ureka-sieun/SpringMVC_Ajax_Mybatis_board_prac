package com.mycom.myapp.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.myapp.board.dto.BoardParamDto;
import com.mycom.myapp.board.dto.BoardResultDto;
import com.mycom.myapp.board.service.BoardService;

@Controller
@RequestMapping("/boards")
public class BoardController {
	
	private final BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService=boardService;
	}
	
	@GetMapping("/list")
	@ResponseBody
	private BoardResultDto listBoard(BoardParamDto boardParamDto) {
		return boardService.listBoard(boardParamDto);
		
	}
}
