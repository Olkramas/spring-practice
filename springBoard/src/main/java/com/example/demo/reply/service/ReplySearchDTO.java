package com.example.demo.reply.service;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReplySearchDTO {
	//업으면 초기값 설정
	int page = 1;
	int amount = 3;
	
	public int getStart() {
		return (page-1) * amount + 1;
	}
	
	public int getEnd() {
		return page * amount;
	}
}
