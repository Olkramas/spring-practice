package com.example.demo.dept;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/dept")	//2
@Controller	//1
@Slf4j //로그 어노테이션
public class DeptController {
	/*
	 목록페이지
	 등록페이지
	 수정페이지
	 상세조회페이지
	 */
	
	@GetMapping("/list")
	public void list(Model model) {
		ArrayList<DepartmentDTO> list = new ArrayList<>();
		list.add(DepartmentDTO.builder().departmentId("10").departmentName("기획").build());
		list.add(DepartmentDTO.builder().departmentId("20").departmentName("개발").build());
		model.addAttribute("list", list);
		
	}
	
	@GetMapping("/insert")
	public String insert() {
		
		//이동시킬 html페이지가 폴더 하위에 있다면 폴더 이름을 작성해줘야 함.
		return "dept/insert";
	}
	
	@GetMapping("/info")
	public void info() {
		
	}
	
	@GetMapping("/update")
	public void update() {
		
		
	}
	
	/*
	 등록처리
	 수정처리
	 삭제처리
	*/
	@PostMapping("/insert")
	public String insertProc(DepartmentDTO deptDto) {
		//저장버튼을 클릭하면 /insert로 요청이 가게 됨. 이를 핸들링함.
		
		//로그로 확인
		log.debug(deptDto.toString());
		return "redirect:list";
	}
	
	@PostMapping("/update")
	public String updateProc() {
		
		return "dept/update";
	}
	
	@PostMapping("/delete")
	public String deleteProc() {
		
		return "dept/delete";
	}
}
