package com.example.demo.board.mappers;

import java.util.List;

import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardSearchDTO;


public interface BoardMapper {
	//등록
	int insertBoard(BoardDTO boardDto);
	
	//수정
	int updateBoard(BoardDTO boardDto);
	
	//삭제
	int deleteBoard(long bno);
	
	//단건조회
	BoardDTO info(long bno);
	
	//전체 조회
	List<BoardDTO> findAll(BoardSearchDTO searchDTO);
	
	//전체 개수
	int getCount(BoardSearchDTO searchDTO);
	
	
}