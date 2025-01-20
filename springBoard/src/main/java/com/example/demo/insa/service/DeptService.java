package com.example.demo.insa.service;

import java.util.List;

public interface DeptService {
	//전체
	public List<DeptDTO> getList(DeptSearchDTO searchDto);
	
	//단건
	public DeptDTO get(Long deptNo);
}
