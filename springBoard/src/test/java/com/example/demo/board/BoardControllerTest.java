package com.example.demo.board;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.ui.ModelMap;


import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc	//MockMvc -> 가짜 mvc
public class BoardControllerTest {
	
	//MockMvc를 인젝션
	@Autowired MockMvc mvc;
	
	@Test
	@DisplayName("조회 컨트롤러")
	void list() throws Exception {
		
	ModelMap map = mvc.perform(MockMvcRequestBuilders.get("/board/list")
			.param("page", "100"))
	    	   .andReturn()
	    	   .getModelAndView()
	    	   .getModelMap();

	log.debug(map.getAttribute("list").toString());
	log.debug(map.getAttribute("paging").toString());
		/*
		//호출
		mvc.perform(get("/board/list"))
			.andExpect(status().isOk());				//응답을 검증하는 역할
			//.andDo(MockMvcResultHandlers.print());	//요청/응답 메시지를 확인(디버깅 레벨로 출력)
		*/
	}
	
	//@Test
	@DisplayName("등록 컨트롤러")
	void register() throws Exception {
		String param = "title=제목제목테스트&content=내용&writer=kim";
		mvc.perform(post("/board/register")
			.content(param)
			.contentType(MediaType.APPLICATION_FORM_URLENCODED)
			);
			
	}
}
