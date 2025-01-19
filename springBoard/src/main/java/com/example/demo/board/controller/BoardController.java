package com.example.demo.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardSearchDTO;
import com.example.demo.board.service.BoardService;
import com.example.demo.common.Paging;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/board")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	//등록, 수정 -> post
	//삭제, 조회, 전체조회 -> get
	
	//전체조회
	@GetMapping("/list")
	//@ResponseBody
	public String list(Model model, 
						BoardSearchDTO searchDTO,
						Paging paging) {
		
		//페이징 처리
		//paging.setPageUnit(15);	//한번에 가져오는 개수
		paging.setTotalRecord(service.getCount(searchDTO));
		
		//첫페이지(아무것도 안들어오면 기본값 1)
		searchDTO.setStart(paging.getFirst());
		searchDTO.setEnd(paging.getLast());
		
		//가져오는 값 출력
		log.info("list: " + service.getList(searchDTO));
		
		model.addAttribute("list", service.getList(searchDTO));
		//return service.getList();
		return "board/list";
	}
	
	//등록 페이지
	@GetMapping("/register")
	public void register(BoardDTO board) {}
	
	//등록 요청보내기
	@PostMapping("/register")
	public String register(@Validated BoardDTO board, //@Validated유효성 검사
						   BindingResult bindingResult,	//유효성 검사 후 이 객체에 담음
						   RedirectAttributes rttr) {
		
		//유효성 검사 후 내용이 에러가 있다면(공백이 있다면)
		if(bindingResult.hasErrors()) {
			log.info(bindingResult.toString());
			return "board/register";
		}
		
		log.info("register: " + board);
		
		service.register(board);
		//rttr.addAttribute("result", true);
		//한번만 뜨게 할 수 있음 addFlash-- list.html의 js에서 result로 부를 수 있음.
		rttr.addFlashAttribute("result", true);
		
		return "redirect:list";
	}
	
	//수정 페이지 요청
	@GetMapping({"/modify", "/get"})
	public void modify(@RequestParam(name="bno") Long bno, Model model) {
		//서비스에서 단건 검색
		BoardDTO board = service.get(bno);
		model.addAttribute("board", board);
	}
	
	@PostMapping("/modify")
	public String modify(BoardDTO board, RedirectAttributes rttr) {
		log.info("modify: " + board);
		
		service.modify(board);
		rttr.addFlashAttribute("result", true);
		
		return "redirect:list";
	};
	
	//삭제 요청
	@GetMapping("/delete")
	public String delete(@RequestParam(name="bno") Long bno, RedirectAttributes rttr) {
		log.info("del_bno: " + bno);
		
		service.remove(bno);
		rttr.addFlashAttribute("delResult", true);
		
		return "redirect:list";
	}
}
