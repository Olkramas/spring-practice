package com.example.demo.insa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.insa.service.EmpService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/emp/*")
public class EmpController {
	
	private final EmpService empService;
	
	@GetMapping("/list")
	public String list(Model model) {
		model.addAttribute("list", empService.getList());
		log.info(empService.getList().toString());
		return "emp/list";
	}
	
	@GetMapping("register")
	public void register() {
		
	}
}
