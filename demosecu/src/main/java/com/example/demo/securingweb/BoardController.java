package com.example.demo.securingweb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.securing.service.CustomUser;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BoardController {
	
	//모든 핸들러에 쓰일경우 이렇게 한번 선언해놓으면 세션을 가져가기 편함
	//요청 들어올 때마다 세션이 주입됨
	@Autowired HttpSession session;
	
	
	@GetMapping("/home")
	public void home() {
		 UserDetails userDetails = 
				 (CustomUser)SecurityContextHolder
				  .getContext().getAuthentication().getPrincipal();
				  
		log.info("userDetail: " + SecuUtil.getUser().getDeptName());
		log.info("session: " + session.getAttribute("deptName"));
	}
}
