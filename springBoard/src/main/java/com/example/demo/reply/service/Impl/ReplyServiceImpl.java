package com.example.demo.reply.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.mappers.BoardMapper;
import com.example.demo.common.Paging;
import com.example.demo.reply.mappers.ReplyMapper;
import com.example.demo.reply.service.ReplyDTO;
import com.example.demo.reply.service.ReplyPageDTO;
import com.example.demo.reply.service.ReplySearchDTO;
import com.example.demo.reply.service.ReplyService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReplyServiceImpl implements ReplyService {
	
	private final ReplyMapper replyMapper;

	
	//댓글 등록
	@Override
	@Transactional
	public int addReply(ReplyDTO replyDto) {
		
		int result = replyMapper.insertReply(replyDto);
		
		replyMapper.updateReplyCnt(replyDto.getBno());
		
		return result;
	}
	@Override
	public int modifyReply(ReplyDTO replyDto) {
		return replyMapper.updateReply(replyDto);
	}
	//댓글삭제
	@Override
	@Transactional
	public boolean removeReply(long rno) {
		
		long bno = replyMapper.getBno(rno);
		int result = replyMapper.deleteReply(rno);
		replyMapper.updateReplyCnt(bno);
		
		return result == 1;
	}
	
	@Override
	public ReplyPageDTO getList(ReplySearchDTO search, Long bno) {
		Paging paging = new Paging();
		int cnt = replyMapper.getCountByBno(bno);
		
		paging.setPage(search.getPage());
		paging.setPageUnit(search.getAmount());
		paging.setTotalRecord(cnt);
		
		return new ReplyPageDTO(
				cnt,
				paging,
				replyMapper.getList(search, bno));
		
	}
	

}
