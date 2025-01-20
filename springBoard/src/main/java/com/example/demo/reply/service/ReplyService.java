package com.example.demo.reply.service;

import java.util.List;

public interface ReplyService {
	
	//등록
	int addReply(ReplyDTO replyDto);
	
	//업데이트
	int modifyReply(ReplyDTO replyDto);
	
	//삭제
	boolean removeReply(long rno);
	
	//조회
	//public List<ReplyDTO> getList(ReplySearchDTO searchDto, Long bno);
	
	
	//(ReplySearchDTO replySearch, Long bno)
	//조회
	public ReplyPageDTO getList(ReplySearchDTO search, Long bno);
}
