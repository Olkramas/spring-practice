package com.example.demo.insa.service;

import lombok.Data;

@Data
public class DeptSearchDTO {
	int start;
	int end;
	
	//검색 타입
	String type;
	//검색 조건
	String keyword;
	//페이지 한번에 가져오는 갯수
	int pageUnit;
	
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
}
