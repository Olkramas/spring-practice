package com.example.demo.insa.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.insa.mappers.DeptMapper;
import com.example.demo.insa.service.DeptDTO;
import com.example.demo.insa.service.DeptSearchDTO;
import com.example.demo.insa.service.DeptService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor	//final이 붙은 필드의 생성자를 자동 생성
public class DeptServiceImpl implements DeptService{
	
	private final DeptMapper deptMapper;
	
	@Override
	public List<DeptDTO> getList(DeptSearchDTO searchDto) {
		return deptMapper.getList(searchDto);
	}

	@Override
	public DeptDTO get(Long deptNo) {
		return deptMapper.get(deptNo);
	}
	
}
