package com.example.demo.insa.mappers;

import java.util.List;

import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.DeptSearchDTO;

public interface DeptMapper {
	//전체 조회
	List<DeptDTO> getList(DeptSearchDTO searchDto);
	
	//단건조회
	DeptDTO get(long deptNo);
}
