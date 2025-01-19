package com.example.demo.board.service;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BoardDTO {
	
	private Long bno;
	@NotBlank(message = "이름을 입력하세용ㅇ요용요용ㅇ")	//공백허용 안함
	private String title;
	@NotBlank(message = "내용은 null일 수 없습니다.")
	private String content;
	@NotBlank
	private String writer;
	private java.sql.Date regdate;
	private int replycnt;
	
	//@Pattern("0\\d{3,4}-") 정규 표현식 패턴검사도 가능함.
}

/*
 bno number(10,0),
 title varchar2(200) not null,
 content varchar2(2000) not null,
 writer
*/
