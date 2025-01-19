package com.example.demo.insa.mappers;

import java.util.List;

import com.example.demo.insa.service.EmpDTO;

public interface EmpMapper {
	//사원 전체 조회
	public List<EmpDTO> getList();
}
