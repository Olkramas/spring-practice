package com.example.demo.board;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.DeptSearchDTO;
import com.example.demo.insa.service.DeptService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class DeptServiceTest {
	
	@Autowired DeptService deptService;
	
	@Test
	@DisplayName("전체 조회")
	public void getList() {
		DeptSearchDTO search = new DeptSearchDTO();
		search.setStart(1);
		search.setEnd(10);
		List<DeptDTO> list = deptService.getList(null);
		
		log.info(list.toString());
	}
}
