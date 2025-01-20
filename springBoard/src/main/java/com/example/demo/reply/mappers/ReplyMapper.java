package com.example.demo.reply.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.reply.service.ReplyDTO;
import com.example.demo.reply.service.ReplySearchDTO;



public interface ReplyMapper {
	//등록
	int insertReply(ReplyDTO replyDto);
	
	//업데이트
	int updateReply(ReplyDTO replyDTo);
	
	//삭제
	int deleteReply(Long rno);
	
	//댓글 조회
	List<ReplyDTO> getList(@Param("cri") ReplySearchDTO cri, @Param("bno") Long bno);
	
	/*
	 * public List<ReplyDTO> getList(@Param("cri") ReplySearchDTO cri, @Param("bno") Long bno);	//들어가는 값 이름을 지정할 수 있음
	 * */
	//게시물 댓글 개수(페이징)
	int getCountByBno(long bno);
	
	//게시물 댓글 전체 삭제
	int deleteByBNO(long bno);
	
	public void updateReplyCnt(@Param("bno") Long bno);
	
	//bno가져오기
	public long getBno(Long rno);
}