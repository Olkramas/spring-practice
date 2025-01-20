package com.example.demo.insa.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.insa.mappers.EmpMapper;
import com.example.demo.insa.service.EmpDTO;
import com.example.demo.insa.service.EmpService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpServiceImpl implements EmpService{
	private final EmpMapper empMapper;

	@Override
	public List<EmpDTO> getList() {
		
		List<EmpDTO> result = empMapper.getList();
		return result;
	}
	
	
}
