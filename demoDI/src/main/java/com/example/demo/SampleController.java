package com.example.demo;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.di.SampleDto;

import lombok.extern.slf4j.Slf4j;

//로그찍을때 롬복에서 slf4j어노테이션이 로그를 출력하게 해줌
@Slf4j
//컨테이너에 빈 등록을 하고, 서블릿커맨드를 사용할 수 있게 함.
@Controller
@RequestMapping("/sample")public class SampleController {
	
	//Logger log = LoggerFactory.getLogger(SampleController.class);
	
	//아래처럼 작성하면 @GetMapping을 사용하라고 안내해줌.
	//@RequestMapping(value="a", method = { RequestMethod.GET })
	@GetMapping("/a")
	public String main() {
		log.info("sample a");
		return "sample";
	}
	
	@GetMapping("/b")
	public String basicb() {
		log.info("sample b");
		return "sample";
	}
	
	
	//
	@GetMapping("/ex01")
	public String ex01(SampleDto dto) {
		log.debug(dto.toString());
		return "sample";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam(name="username") String name,
					   @RequestParam(required = false, defaultValue = "5") int age,
					   String tel) {//int의 초기값은 0, integer의 초기값은 null
		//String name = request.getParameter("username");과 @RequestParam(name="username") String name 같음
		log.info("name: " + name);
		log.info("age: " + age);
		log.info("tel: " + tel);
		return "sample";
	}
	
	//localhost:81/sample/ex02List?hobby=read&hobby=game
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam List<String> hobby) {
		log.debug("hobby: " + hobby);
		return "sample";
	}
	
	//sampleDtoList예시
	//localhost:81/sample/ex02Bean?list[0].name=kim&list[0].age=40&list[1].name=park&list[1].age=11
	@PostMapping("/ex02Bean")
	public String ex02Bean(SampleDtoList dtoList) {
		log.debug("dtoList: " + dtoList);
		return "sample";
	}
	
	/*
	//TodoDTO
	//localhost:81/sample/ex03?title=kim&dueDate=25/01/13
	@GetMapping("/ex03")
	public String ex03(@ModelAttribute(name = "todo") TodoDTO dto, Model model) {
		model.addAttribute("serverTime", new Date());
		log.debug("todoDTO" + dto);
		return "sample";	//포워드 : request전달
	}
	*/
	
	@ModelAttribute("dept")
	public List<String> deptList() {
		return Arrays.asList("기획", "개발", "인사");
	}
	
	//TodoDTO
	//localhost:81/sample/ex03?title=kim&dueDate=25/01/13
	@GetMapping("/ex03")
	public ModelAndView ex03(@ModelAttribute(name = "todo") TodoDTO dto) {
		ModelAndView mv = new ModelAndView("sample");
		mv.addObject("serverTime", new Date());
		log.debug("todoDTO" + dto);
		return mv;	//포워드 : request전달
	}
	
	//forward, redirect차이점 정리해오기
}
