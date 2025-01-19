package com.example.demo.reply.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReplyDTO {
	
	private int rno;
	private long bno;
	private String reply;
	private String replyer;
	private java.sql.Date replydate;
}


